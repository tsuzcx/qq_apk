package com.tencent.qqmini.sdk.widget.media;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.ScreenOffOnListener;
import com.tencent.qqmini.sdk.core.utils.StringUtil;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.ServiceSubscribeEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnCaptureImageListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnCompletionListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnControllerClickListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnErrorListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnInfoListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnSeekCompleteListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnVideoPreparedListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnVideoViewInitListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.widget.VideoGestureRelativeLayout.VideoGestureListener;
import java.util.LinkedList;
import java.util.Observer;
import java.util.Queue;
import org.json.JSONException;
import org.json.JSONObject;

public class MiniAppVideoController
  implements Handler.Callback
{
  private static final String TAG = "MiniAppVideoController";
  private Activity activity;
  private Bitmap cachedCaptureImage;
  private MiniAppVideoConfig config;
  private String data;
  private final Handler handler = new Handler(Looper.getMainLooper(), this);
  private boolean isAutoPausedOnBackground;
  private boolean isBufferStart = false;
  private boolean isBusyInChangeScreen = false;
  private boolean isChangingProgress;
  private boolean isPageBackground;
  private boolean isPause;
  private boolean isVideoPrepared = false;
  private int lastBufferProgress = 0;
  private MiniAppVideoPlayerListenerHolder listenerHolder;
  private AudioManager mAudioManager;
  private long mCurrPos;
  private int maxVolume = 0;
  private IMiniAppContext miniAppContext;
  private boolean needPauseOnLoad;
  private int oldVolume = 0;
  private int originHeight;
  private int originWidth;
  private IJsService pageWebView;
  private IVideoPlayer player;
  private boolean playingBefore;
  private int rotation;
  private Queue<Message> taskQueueRunAfterVideoPrepared = new LinkedList();
  private IVideoPlayerUI ui;
  private long videoPlayerId;
  private Observer videoPlayerStatusObserver;
  private int webViewId;
  
  public MiniAppVideoController(Activity paramActivity)
  {
    this.activity = paramActivity;
    this.config = new MiniAppVideoConfig();
    initUI();
  }
  
  private void avoidLockScreen()
  {
    if (this.activity != null)
    {
      this.activity.getWindow().addFlags(128);
      this.activity.getWindow().clearFlags(1);
      QMLog.d("MiniAppVideoController", "avoidLockScreen");
    }
  }
  
  private void callBackFullScreenChange()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("data", this.data);
      localJSONObject.put("videoId", this.videoPlayerId);
      localJSONObject.put("fullScreen", this.config.isFullScreen);
      if (this.miniAppContext != null) {
        this.miniAppContext.performAction(ServiceSubscribeEvent.obtain("onVideoFullScreenChange", localJSONObject.toString(), this.webViewId));
      }
      this.pageWebView.evaluateSubscribeJS("onVideoFullScreenChange", localJSONObject.toString(), this.webViewId);
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  private void callBackFullScreenChange(boolean paramBoolean)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("data", this.data);
      localJSONObject.put("videoId", this.videoPlayerId);
      localJSONObject.put("fullScreen", this.config.isFullScreen);
      if (paramBoolean) {
        localJSONObject.put("direction", "horizontal");
      }
      for (;;)
      {
        if (this.miniAppContext != null) {
          this.miniAppContext.performAction(ServiceSubscribeEvent.obtain("onVideoFullScreenChange", localJSONObject.toString(), this.webViewId));
        }
        this.pageWebView.evaluateSubscribeJS("onVideoFullScreenChange", localJSONObject.toString(), this.webViewId);
        return;
        localJSONObject.put("direction", "vertical");
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  private void callbackOnVideoPlay()
  {
    if ((this.miniAppContext != null) && (this.miniAppContext.isMiniGame()))
    {
      callbackVideoStateChange("play");
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("videoId", this.videoPlayerId);
    localJSONObject.put("data", this.data);
    if (this.miniAppContext != null) {
      this.miniAppContext.performAction(ServiceSubscribeEvent.obtain("onVideoPlay", localJSONObject.toString(), this.webViewId));
    }
    this.pageWebView.evaluateSubscribeJS("onVideoPlay", localJSONObject.toString(), this.webViewId);
    QMLog.d("MiniAppVideoController", "OnVideoPreparedListener - onVideoPrepared evaluateSubcribeJS onVideoPlay = " + localJSONObject.toString());
  }
  
  private void callbackOnVideoWaiting()
  {
    if ((this.miniAppContext != null) && (this.miniAppContext.isMiniGame()))
    {
      callbackVideoStateChange("waiting");
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("videoId", this.videoPlayerId);
    localJSONObject.put("data", this.data);
    if (this.miniAppContext != null) {
      this.miniAppContext.performAction(ServiceSubscribeEvent.obtain("onVideoWaiting", localJSONObject.toString(), this.webViewId));
    }
    this.pageWebView.evaluateSubscribeJS("onVideoWaiting", localJSONObject.toString(), this.webViewId);
  }
  
  private void callbackVideoStateChange(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("data", this.data);
      localJSONObject.put("videoPlayerId", this.videoPlayerId);
      localJSONObject.put("state", paramString);
      if ("timeUpdate".equals(paramString))
      {
        localJSONObject.put("position", this.player.getCurrentPostion() / 1000.0D);
        localJSONObject.put("duration", this.player.getDuration() / 1000.0D);
      }
      if (this.miniAppContext != null) {
        this.miniAppContext.performAction(ServiceSubscribeEvent.obtain("onVideoStateChange", localJSONObject.toString(), this.webViewId));
      }
      this.pageWebView.evaluateSubscribeJS("onVideoStateChange", localJSONObject.toString(), this.webViewId);
      return;
    }
    catch (Throwable paramString)
    {
      QMLog.e("MiniAppVideoController", "callbackVideoStateChange error.", paramString);
    }
  }
  
  private void cancelAvoidLockScreen()
  {
    if (this.activity != null)
    {
      this.activity.getWindow().clearFlags(128);
      this.activity.getWindow().addFlags(1);
      QMLog.d("MiniAppVideoController", "cancelAvoidLockScreen");
    }
  }
  
  private int getAndSelectVideoTrackIndex(MediaExtractor paramMediaExtractor)
  {
    try
    {
      if (Build.VERSION.SDK_INT >= 16)
      {
        int i = 0;
        while (i < paramMediaExtractor.getTrackCount())
        {
          QMLog.d("VideoJsPlugin", "format for track " + i + " is " + paramMediaExtractor.getTrackFormat(i).getString("mime"));
          if (paramMediaExtractor.getTrackFormat(i).getString("mime").startsWith("video/"))
          {
            paramMediaExtractor.selectTrack(i);
            return i;
          }
          i += 1;
        }
      }
      return -1;
    }
    catch (Exception paramMediaExtractor) {}
  }
  
  private void getCachedCaptureImage()
  {
    if ((this.cachedCaptureImage != null) && (!this.cachedCaptureImage.isRecycled()))
    {
      this.cachedCaptureImage.recycle();
      this.cachedCaptureImage = null;
    }
    if ((this.cachedCaptureImage == null) || (this.cachedCaptureImage.isRecycled())) {
      ThreadManager.getUIHandler().postDelayed(new MiniAppVideoController.18(this), 1000L);
    }
  }
  
  private AbsVideoPlayer.OnCaptureImageListener getCaptureImageListener(AbsVideoPlayer.OnCaptureImageListener paramOnCaptureImageListener)
  {
    return new MiniAppVideoController.19(this, paramOnCaptureImageListener);
  }
  
  private View.OnClickListener getClickListener()
  {
    return new MiniAppVideoController.2(this);
  }
  
  private AbsVideoPlayer.OnCompletionListener getOnCompletionListener()
  {
    return new MiniAppVideoController.8(this);
  }
  
  private AbsVideoPlayer.OnControllerClickListener getOnControllerClickListener()
  {
    return new MiniAppVideoController.5(this);
  }
  
  private AbsVideoPlayer.OnErrorListener getOnErrorListener()
  {
    return new MiniAppVideoController.10(this);
  }
  
  private AbsVideoPlayer.OnInfoListener getOnInfoListener()
  {
    return new MiniAppVideoController.9(this);
  }
  
  private SeekBar.OnSeekBarChangeListener getOnSeekBarChangeListener()
  {
    return new MiniAppVideoController.4(this);
  }
  
  private AbsVideoPlayer.OnSeekCompleteListener getOnSeekCompleteListener()
  {
    return new MiniAppVideoController.11(this);
  }
  
  private AbsVideoPlayer.OnVideoPreparedListener getOnVideoPreparedListener()
  {
    return new MiniAppVideoController.7(this);
  }
  
  private AbsVideoPlayer.OnVideoViewInitListener getOnVideoViewInitListener()
  {
    return new MiniAppVideoController.1(this);
  }
  
  private VideoGestureRelativeLayout.VideoGestureListener getVideoGestureListener()
  {
    return new MiniAppVideoController.3(this);
  }
  
  private void handlePlayBtnClick()
  {
    if (this.ui.getStatusImgVisibility() == 0)
    {
      if ((this.config.initialTime > 0.0D) && (getCurrentPos() == 0L)) {
        play((this.config.initialTime * 1000.0D));
      }
    }
    else {
      return;
    }
    play(getCurrentPos());
  }
  
  private void initPlayer(MiniAppVideoConfig paramMiniAppVideoConfig)
  {
    this.mAudioManager = ((AudioManager)this.activity.getSystemService("audio"));
    if (this.mAudioManager != null) {
      this.maxVolume = this.mAudioManager.getStreamMaxVolume(3);
    }
    this.player = new IVideoPlayerImpl(this.activity);
    this.listenerHolder = initPlayerListenerHolder();
    this.player.createVideoView(this.listenerHolder.onVideoViewInitListener);
  }
  
  private MiniAppVideoPlayerListenerHolder initPlayerListenerHolder()
  {
    return new MiniAppVideoPlayerListenerHolder.Builder().setOnVideoViewInitListener(getOnVideoViewInitListener()).setOnControllerClickListener(getOnControllerClickListener()).setOnVideoPreparedListener(getOnVideoPreparedListener()).setOnCompletionListener(getOnCompletionListener()).setOnErrorListener(getOnErrorListener()).setOnInfoListener(getOnInfoListener()).setOnSeekCompleteListener(getOnSeekCompleteListener()).build();
  }
  
  private void initPoster(MiniAppVideoConfig paramMiniAppVideoConfig)
  {
    if (!paramMiniAppVideoConfig.autoplay)
    {
      if (StringUtil.isEmpty(paramMiniAppVideoConfig.poster)) {
        break label22;
      }
      setPoster();
    }
    label22:
    while (StringUtil.isEmpty(paramMiniAppVideoConfig.mUrls)) {
      return;
    }
    MediaUtils.getImageForVideo(this.miniAppContext, paramMiniAppVideoConfig.mUrls, new MiniAppVideoController.13(this));
  }
  
  private void initUI()
  {
    this.ui = new IVideoPlayerUIImpl(this.activity);
    this.ui.setController(this);
    this.ui.setUpUI(getClickListener(), getVideoGestureListener(), getOnSeekBarChangeListener());
  }
  
  private boolean isLandscapeVideo()
  {
    if (this.player != null)
    {
      int j = this.player.getVideoWidth();
      int k = this.player.getVideoHeight();
      int i;
      if (j != 0)
      {
        i = k;
        if (k != 0) {}
      }
      else
      {
        j = this.originWidth;
        i = this.originHeight;
      }
      if ((this.rotation == 0) || (this.rotation == 180))
      {
        if (j < i) {
          return false;
        }
      }
      else if (j > i) {
        return false;
      }
    }
    return true;
  }
  
  /* Error */
  private void parseOriVideoSize(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_1
    //   4: invokestatic 662	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifne +134 -> 141
    //   10: aload_1
    //   11: ldc_w 664
    //   14: invokevirtual 422	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   17: ifeq +124 -> 141
    //   20: getstatic 389	android/os/Build$VERSION:SDK_INT	I
    //   23: bipush 15
    //   25: if_icmple +116 -> 141
    //   28: new 666	java/io/FileInputStream
    //   31: dup
    //   32: aload_0
    //   33: getfield 99	com/tencent/qqmini/sdk/widget/media/MiniAppVideoController:config	Lcom/tencent/qqmini/sdk/widget/media/MiniAppVideoConfig;
    //   36: getfield 616	com/tencent/qqmini/sdk/widget/media/MiniAppVideoConfig:mUrls	Ljava/lang/String;
    //   39: invokespecial 668	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   42: astore_3
    //   43: new 391	android/media/MediaExtractor
    //   46: dup
    //   47: invokespecial 669	android/media/MediaExtractor:<init>	()V
    //   50: astore 5
    //   52: aload 5
    //   54: aload_3
    //   55: invokevirtual 673	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   58: invokevirtual 677	android/media/MediaExtractor:setDataSource	(Ljava/io/FileDescriptor;)V
    //   61: aload_0
    //   62: aload 5
    //   64: invokespecial 679	com/tencent/qqmini/sdk/widget/media/MiniAppVideoController:getAndSelectVideoTrackIndex	(Landroid/media/MediaExtractor;)I
    //   67: istore_2
    //   68: iload_2
    //   69: iconst_m1
    //   70: if_icmple +53 -> 123
    //   73: aload 5
    //   75: iload_2
    //   76: invokevirtual 408	android/media/MediaExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   79: astore_1
    //   80: aload_1
    //   81: ldc_w 681
    //   84: invokevirtual 684	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   87: ifeq +14 -> 101
    //   90: aload_0
    //   91: aload_1
    //   92: ldc_w 681
    //   95: invokevirtual 688	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   98: putfield 654	com/tencent/qqmini/sdk/widget/media/MiniAppVideoController:rotation	I
    //   101: aload_0
    //   102: aload_1
    //   103: ldc_w 690
    //   106: invokevirtual 688	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   109: putfield 650	com/tencent/qqmini/sdk/widget/media/MiniAppVideoController:originWidth	I
    //   112: aload_0
    //   113: aload_1
    //   114: ldc_w 692
    //   117: invokevirtual 688	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   120: putfield 652	com/tencent/qqmini/sdk/widget/media/MiniAppVideoController:originHeight	I
    //   123: aload_3
    //   124: ifnull +7 -> 131
    //   127: aload_3
    //   128: invokevirtual 695	java/io/FileInputStream:close	()V
    //   131: aload 5
    //   133: ifnull +8 -> 141
    //   136: aload 5
    //   138: invokevirtual 698	android/media/MediaExtractor:release	()V
    //   141: return
    //   142: astore 4
    //   144: aconst_null
    //   145: astore_3
    //   146: aload 6
    //   148: astore_1
    //   149: ldc 10
    //   151: ldc_w 700
    //   154: aload 4
    //   156: invokestatic 706	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   159: pop
    //   160: aload_3
    //   161: ifnull +7 -> 168
    //   164: aload_3
    //   165: invokevirtual 695	java/io/FileInputStream:close	()V
    //   168: aload_1
    //   169: ifnull -28 -> 141
    //   172: aload_1
    //   173: invokevirtual 698	android/media/MediaExtractor:release	()V
    //   176: return
    //   177: astore_1
    //   178: aconst_null
    //   179: astore 4
    //   181: aconst_null
    //   182: astore_3
    //   183: aload 4
    //   185: ifnull +8 -> 193
    //   188: aload 4
    //   190: invokevirtual 695	java/io/FileInputStream:close	()V
    //   193: aload_3
    //   194: ifnull +7 -> 201
    //   197: aload_3
    //   198: invokevirtual 698	android/media/MediaExtractor:release	()V
    //   201: aload_1
    //   202: athrow
    //   203: astore_1
    //   204: goto -73 -> 131
    //   207: astore_3
    //   208: goto -40 -> 168
    //   211: astore 4
    //   213: goto -20 -> 193
    //   216: astore_1
    //   217: aconst_null
    //   218: astore 5
    //   220: aload_3
    //   221: astore 4
    //   223: aload 5
    //   225: astore_3
    //   226: goto -43 -> 183
    //   229: astore_1
    //   230: aload_3
    //   231: astore 4
    //   233: aload 5
    //   235: astore_3
    //   236: goto -53 -> 183
    //   239: astore 4
    //   241: aload_1
    //   242: astore 5
    //   244: aload 4
    //   246: astore_1
    //   247: aload_3
    //   248: astore 4
    //   250: aload 5
    //   252: astore_3
    //   253: goto -70 -> 183
    //   256: astore 4
    //   258: aload 6
    //   260: astore_1
    //   261: goto -112 -> 149
    //   264: astore 4
    //   266: aload 5
    //   268: astore_1
    //   269: goto -120 -> 149
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	272	0	this	MiniAppVideoController
    //   0	272	1	paramString	String
    //   67	9	2	i	int
    //   42	156	3	localFileInputStream	java.io.FileInputStream
    //   207	14	3	localIOException1	java.io.IOException
    //   225	28	3	localObject1	Object
    //   142	13	4	localThrowable1	Throwable
    //   179	10	4	localObject2	Object
    //   211	1	4	localIOException2	java.io.IOException
    //   221	11	4	localObject3	Object
    //   239	6	4	localObject4	Object
    //   248	1	4	localObject5	Object
    //   256	1	4	localThrowable2	Throwable
    //   264	1	4	localThrowable3	Throwable
    //   50	217	5	localObject6	Object
    //   1	258	6	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   28	43	142	java/lang/Throwable
    //   28	43	177	finally
    //   127	131	203	java/io/IOException
    //   164	168	207	java/io/IOException
    //   188	193	211	java/io/IOException
    //   43	52	216	finally
    //   52	68	229	finally
    //   73	101	229	finally
    //   101	123	229	finally
    //   149	160	239	finally
    //   43	52	256	java/lang/Throwable
    //   52	68	264	java/lang/Throwable
    //   73	101	264	java/lang/Throwable
    //   101	123	264	java/lang/Throwable
  }
  
  private static String parseTimeString(long paramLong)
  {
    long l2 = paramLong / 1000L;
    long l1 = l2;
    if (paramLong % 1000L != 0L) {
      l1 = l2 + 1L;
    }
    int i = (int)(l1 % 60L);
    paramLong = l1 / 60L;
    return parseTwoBitNumString(paramLong) + ":" + parseTwoBitNumString(i);
  }
  
  private static String parseTwoBitNumString(long paramLong)
  {
    if (paramLong == 0L) {
      return "00";
    }
    if (paramLong < 10L) {
      return "0" + paramLong;
    }
    return Long.toString(paramLong);
  }
  
  private String parseUrl(String paramString)
  {
    String str = null;
    if (paramString.startsWith("wxfile")) {
      if (this.miniAppContext != null) {
        str = ((MiniAppFileManager)this.miniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath(paramString);
      }
    }
    while ((!paramString.startsWith("http")) && (!paramString.startsWith("https"))) {
      return str;
    }
    return paramString;
  }
  
  private void pause()
  {
    QMLog.d("MiniAppVideoController", "pause");
    if (this.player == null) {}
    do
    {
      return;
      this.playingBefore = false;
    } while (!this.player.isPlaying());
    cancelAvoidLockScreen();
    this.player.pause();
    this.isPause = true;
    if ((this.miniAppContext != null) && (this.miniAppContext.isMiniGame()))
    {
      callbackVideoStateChange("pause");
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("videoId", this.videoPlayerId);
      localJSONObject.put("data", this.data);
      if (this.miniAppContext != null) {
        this.miniAppContext.performAction(ServiceSubscribeEvent.obtain("onVideoPause", localJSONObject.toString(), this.webViewId));
      }
      this.pageWebView.evaluateSubscribeJS("onVideoPause", localJSONObject.toString(), this.webViewId);
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  private void sendPlayingMsg(long paramLong)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 2002;
    this.handler.sendMessageDelayed(localMessage, paramLong);
  }
  
  private void setPoster()
  {
    Drawable localDrawable = ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getDrawable(this.activity, this.config.poster, 0, 0, null);
    if (localDrawable != null) {
      this.ui.setPoster(localDrawable);
    }
  }
  
  private void start()
  {
    avoidLockScreen();
    if ((this.player != null) && (this.player.getCurrentPostion() > 0L))
    {
      this.player.start();
      if ((this.miniAppContext != null) && (this.miniAppContext.isMiniGame())) {
        callbackVideoStateChange("play");
      }
    }
    for (;;)
    {
      this.isPause = false;
      return;
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("data", this.data);
        if (this.miniAppContext != null) {
          this.miniAppContext.performAction(ServiceSubscribeEvent.obtain("onVideoPlay", localJSONObject.toString(), this.webViewId));
        }
        this.pageWebView.evaluateSubscribeJS("onVideoPlay", localJSONObject.toString(), this.webViewId);
        QMLog.d("MiniAppVideoController", "evaluateSubcribeJS onVideoPlay = " + localJSONObject.toString());
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      continue;
      play((this.config.initialTime * 1000.0D));
    }
  }
  
  private void stop(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.config.isFullScreen)) {
      smallScreen();
    }
    this.isVideoPrepared = false;
    if (this.player != null) {
      this.player.stop();
    }
    ThreadManager.getUIHandler().post(new MiniAppVideoController.15(this));
  }
  
  private void switchScreenSize()
  {
    if (this.config.isFullScreen)
    {
      smallScreen();
      return;
    }
    fullScreen();
  }
  
  private void updateBufferProgress(boolean paramBoolean)
  {
    MiniAppVideoController.12 local12 = new MiniAppVideoController.12(this);
    if (!paramBoolean) {
      local12.run();
    }
    while ((!this.isBufferStart) && (this.lastBufferProgress == 0)) {
      return;
    }
    ThreadManager.getUIHandler().postDelayed(local12, 20L);
  }
  
  private void updatePoster(MiniAppVideoConfig paramMiniAppVideoConfig)
  {
    if ((paramMiniAppVideoConfig.poster != null) && (!paramMiniAppVideoConfig.poster.equals(paramMiniAppVideoConfig.lastPoster))) {
      setPoster();
    }
    paramMiniAppVideoConfig.lastPoster = paramMiniAppVideoConfig.poster;
  }
  
  public void captureImage(AbsVideoPlayer.OnCaptureImageListener paramOnCaptureImageListener)
  {
    if (paramOnCaptureImageListener == null)
    {
      QMLog.e("MiniAppVideoController", "captureImage onCaptureImageListener is null");
      return;
    }
    if (this.player == null)
    {
      QMLog.e("MiniAppVideoController", "captureImage video player is null");
      paramOnCaptureImageListener.onCaptureImageFailed();
      return;
    }
    try
    {
      if (this.player.isPlaying()) {
        break label117;
      }
      if ((this.cachedCaptureImage != null) && (!this.cachedCaptureImage.isRecycled()))
      {
        paramOnCaptureImageListener.onCaptureImageSucceed(this.cachedCaptureImage);
        return;
      }
    }
    catch (Exception localException)
    {
      QMLog.e("MiniAppVideoController", "captureImage video player fail!,e" + localException);
      paramOnCaptureImageListener.onCaptureImageFailed();
      return;
    }
    paramOnCaptureImageListener.onCaptureImageFailed();
    return;
    label117:
    int i = this.ui.getPlayerViewWidth();
    int j = this.ui.getPlayerViewHeight();
    this.player.setOnCaptureImageListener(getCaptureImageListener(paramOnCaptureImageListener));
    this.player.captureImageInTime(i, j);
  }
  
  public void fullScreen()
  {
    if (!this.isVideoPrepared)
    {
      localMessage = new Message();
      localMessage.what = 2004;
      this.taskQueueRunAfterVideoPrepared.add(localMessage);
    }
    while (this.isBusyInChangeScreen)
    {
      Message localMessage;
      return;
    }
    QMLog.e("fullScreen - fullScreen()", "fullScreen() - config.isFullScreen = true");
    this.config.isFullScreen = true;
    boolean bool = isLandscapeVideo();
    ThreadManager.getUIHandler().post(new MiniAppVideoController.20(this, bool));
  }
  
  public long getCurrentPos()
  {
    if (this.player == null) {
      return 0L;
    }
    return this.player.getCurrentPostion();
  }
  
  public FrameLayout getUI()
  {
    if (this.ui != null) {
      return this.ui.getUI();
    }
    QMLog.e("MiniAppVideoController", "IVideoPlayerUI is null when doing getUI()!");
    return null;
  }
  
  public Observer getVideoPlayerStatusObserver()
  {
    if (this.videoPlayerStatusObserver == null) {
      this.videoPlayerStatusObserver = new MiniAppVideoController.14(this);
    }
    return this.videoPlayerStatusObserver;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool = true;
    switch (paramMessage.what)
    {
    case 2003: 
    default: 
      bool = false;
      return bool;
    case 2002: 
      long l = System.currentTimeMillis();
      if ((this.player != null) && (this.player.isPlaying()))
      {
        this.ui.updatePlayingTime(parseTimeString(this.player.getCurrentPostion()));
        this.ui.updateDanmuTime(this.player.getCurrentPostion());
        if (!this.isChangingProgress) {
          this.ui.setProgressByPlayingTime(this.player.getDuration(), this.player.getCurrentPostion());
        }
        if (!"com.tencent.qqmini.minigame.GameJsService".equals(this.pageWebView.getClass().getName())) {
          break label180;
        }
        callbackVideoStateChange("timeUpdate");
      }
      while (!this.isPause)
      {
        sendPlayingMsg(l + 200L - System.currentTimeMillis());
        return true;
        try
        {
          label180:
          paramMessage = new JSONObject();
          paramMessage.put("data", this.data);
          paramMessage.put("position", this.player.getCurrentPostion() / 1000.0D);
          paramMessage.put("duration", this.player.getDuration() / 1000.0D);
          paramMessage.put("videoId", this.videoPlayerId);
          if (this.miniAppContext != null) {
            this.miniAppContext.performAction(ServiceSubscribeEvent.obtain("onVideoTimeUpdate", paramMessage.toString(), this.webViewId));
          }
          this.pageWebView.evaluateSubscribeJS("onVideoTimeUpdate", paramMessage.toString(), this.webViewId);
          QMLog.d("MiniAppVideoController", "evaluateSubcribeJS onVideoTimeUpdate = " + paramMessage.toString());
        }
        catch (JSONException paramMessage)
        {
          paramMessage.printStackTrace();
        }
      }
    }
    fullScreen();
    return true;
  }
  
  public void initVideoPlayerSettings(JSONObject paramJSONObject)
  {
    updateConfig(paramJSONObject);
    initPlayer(this.config);
    updateVideoPlayerSettings(paramJSONObject);
  }
  
  public boolean isFullScreen()
  {
    return this.config.isFullScreen;
  }
  
  public boolean isPlaying()
  {
    return false;
  }
  
  public boolean isWifiConnect()
  {
    return ((ConnectivityManager)this.activity.getSystemService("connectivity")).getNetworkInfo(1).isConnected();
  }
  
  public void onPageBackground()
  {
    this.isPageBackground = true;
    if ((this.config.autoPauseIfOpenNative) && (!this.isAutoPausedOnBackground)) {
      this.isAutoPausedOnBackground = pauseWithUi();
    }
  }
  
  public void onPageForeground()
  {
    this.isPageBackground = false;
    if ((this.isAutoPausedOnBackground) && (this.player != null)) {
      this.ui.changeState();
    }
  }
  
  public void operate()
  {
    QMLog.d("MiniAppVideoController", "operate");
    if (this.player == null) {
      return;
    }
    if (this.player.isPlaying())
    {
      pause();
      return;
    }
    start();
    sendPlayingMsg(200L);
  }
  
  public boolean pauseWithUi()
  {
    if (this.player.isPlaying())
    {
      ThreadManager.getUIHandler().post(new MiniAppVideoController.17(this));
      return true;
    }
    return false;
  }
  
  public void play()
  {
    play(getCurrentPos());
  }
  
  public void play(long paramLong)
  {
    if (this.player == null) {}
    while (StringUtil.isEmpty(this.config.mUrls)) {
      return;
    }
    this.isBufferStart = true;
    updateBufferProgress(false);
    avoidLockScreen();
    this.playingBefore = true;
    this.isVideoPrepared = false;
    this.player.stop();
    if (this.config.enableDanmu) {
      this.player.startPlayDanmu();
    }
    this.player.openMediaPlayerByUrl(this.activity, this.config.mUrls, paramLong);
    this.ui.showLoadingView();
    this.ui.hidePlayerStatusImg();
  }
  
  public void playDanmu(String paramString, int paramInt)
  {
    this.ui.showBarrageNextTime(paramString, paramInt);
  }
  
  public boolean playWithUi()
  {
    if (!this.player.isPlaying())
    {
      this.ui.changeState();
      return true;
    }
    return false;
  }
  
  public void release()
  {
    ThreadManager.getUIHandler().post(new MiniAppVideoController.16(this));
    ScreenOffOnListener.getInstance().unRegistListener();
    this.handler.removeMessages(2002);
  }
  
  public boolean seekTo(int paramInt)
  {
    if (this.player == null) {
      return false;
    }
    if (paramInt < 0)
    {
      this.player.seekTo(0);
      return true;
    }
    long l = this.player.getDuration();
    if ((l > 0L) && (paramInt > l))
    {
      this.player.seekTo((int)l);
      return true;
    }
    this.config.initialTime = (paramInt / 1000.0D);
    if (l > 0L) {
      this.player.seekTo(paramInt);
    }
    return true;
  }
  
  public void setData(String paramString)
  {
    this.data = paramString;
  }
  
  public void setMiniAppContext(IMiniAppContext paramIMiniAppContext)
  {
    this.miniAppContext = paramIMiniAppContext;
  }
  
  public void setPageWebViewId(int paramInt)
  {
    this.webViewId = paramInt;
  }
  
  public void setPageWebview(IJsService paramIJsService)
  {
    this.pageWebView = paramIJsService;
  }
  
  public void setVideoPath(String paramString)
  {
    QMLog.d("MiniAppVideoController", "setVideoPath: " + paramString);
    stop(false);
    this.ui.updateCenterBtn(this.config);
    this.ui.hideControllerPopContainer();
    this.handler.removeMessages(2002);
    this.config.mUrls = parseUrl(paramString);
    if ((this.config.isResetPath) || (this.config.autoplay)) {
      this.handler.postDelayed(new MiniAppVideoController.21(this), 100L);
    }
    this.config.isResetPath = true;
    this.rotation = 0;
    parseOriVideoSize(paramString);
  }
  
  public void setVideoPlayerId(int paramInt)
  {
    this.videoPlayerId = paramInt;
  }
  
  public void smallScreen()
  {
    this.mCurrPos = this.player.getCurrentPostion();
    QMLog.d("MiniAppVideoController", "smallScreen current pos is: " + this.mCurrPos);
    ThreadManager.getUIHandler().post(new MiniAppVideoController.6(this));
  }
  
  public void stop()
  {
    stop(true);
  }
  
  public void updateConfig(JSONObject paramJSONObject)
  {
    this.config.initSetting(paramJSONObject);
  }
  
  public void updateVideoPlayerSettings(JSONObject paramJSONObject)
  {
    this.ui.updateVideoGestureSetting(this.config);
    this.player.updateObjFit(this.config);
    this.player.updateMute(this.config);
    this.ui.updateControllerView(this.config);
    this.ui.resetMuteImage(this.config, this.player.getOutputMute());
    this.ui.updateVideoPosition(this.config, this.miniAppContext.isMiniGame());
    updatePoster(this.config);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.media.MiniAppVideoController
 * JD-Core Version:    0.7.0.1
 */