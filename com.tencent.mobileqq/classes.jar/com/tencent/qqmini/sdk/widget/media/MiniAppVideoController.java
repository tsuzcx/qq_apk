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
    Activity localActivity = this.activity;
    if (localActivity != null)
    {
      localActivity.getWindow().addFlags(128);
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
      IMiniAppContext localIMiniAppContext = this.miniAppContext;
      if (localIMiniAppContext != null) {
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
      } else {
        localJSONObject.put("direction", "vertical");
      }
      IMiniAppContext localIMiniAppContext = this.miniAppContext;
      if (localIMiniAppContext != null) {
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
  
  private void callbackOnVideoPlay()
  {
    Object localObject1 = this.miniAppContext;
    if ((localObject1 != null) && (((IMiniAppContext)localObject1).isMiniGame()))
    {
      callbackVideoStateChange("play");
      return;
    }
    localObject1 = new JSONObject();
    ((JSONObject)localObject1).put("videoId", this.videoPlayerId);
    ((JSONObject)localObject1).put("data", this.data);
    Object localObject2 = this.miniAppContext;
    if (localObject2 != null) {
      ((IMiniAppContext)localObject2).performAction(ServiceSubscribeEvent.obtain("onVideoPlay", ((JSONObject)localObject1).toString(), this.webViewId));
    }
    this.pageWebView.evaluateSubscribeJS("onVideoPlay", ((JSONObject)localObject1).toString(), this.webViewId);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("OnVideoPreparedListener - onVideoPrepared evaluateSubcribeJS onVideoPlay = ");
    ((StringBuilder)localObject2).append(((JSONObject)localObject1).toString());
    QMLog.d("MiniAppVideoController", ((StringBuilder)localObject2).toString());
  }
  
  private void callbackOnVideoWaiting()
  {
    Object localObject = this.miniAppContext;
    if ((localObject != null) && (((IMiniAppContext)localObject).isMiniGame()))
    {
      callbackVideoStateChange("waiting");
      return;
    }
    localObject = new JSONObject();
    ((JSONObject)localObject).put("videoId", this.videoPlayerId);
    ((JSONObject)localObject).put("data", this.data);
    IMiniAppContext localIMiniAppContext = this.miniAppContext;
    if (localIMiniAppContext != null) {
      localIMiniAppContext.performAction(ServiceSubscribeEvent.obtain("onVideoWaiting", ((JSONObject)localObject).toString(), this.webViewId));
    }
    this.pageWebView.evaluateSubscribeJS("onVideoWaiting", ((JSONObject)localObject).toString(), this.webViewId);
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
        long l = this.player.getCurrentPostion();
        double d = l;
        Double.isNaN(d);
        d /= 1000.0D;
        localJSONObject.put("position", d);
        l = this.player.getDuration();
        d = l;
        Double.isNaN(d);
        d /= 1000.0D;
        localJSONObject.put("duration", d);
      }
      paramString = this.miniAppContext;
      if (paramString != null) {
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
    Activity localActivity = this.activity;
    if (localActivity != null)
    {
      localActivity.getWindow().clearFlags(128);
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
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("format for track ");
          localStringBuilder.append(i);
          localStringBuilder.append(" is ");
          localStringBuilder.append(paramMediaExtractor.getTrackFormat(i).getString("mime"));
          QMLog.d("VideoJsPlugin", localStringBuilder.toString());
          if (paramMediaExtractor.getTrackFormat(i).getString("mime").startsWith("video/"))
          {
            paramMediaExtractor.selectTrack(i);
            return i;
          }
          i += 1;
        }
      }
    }
    catch (Exception paramMediaExtractor)
    {
      label108:
      break label108;
    }
    return -1;
  }
  
  private void getCachedCaptureImage()
  {
    Bitmap localBitmap = this.cachedCaptureImage;
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      this.cachedCaptureImage.recycle();
      this.cachedCaptureImage = null;
    }
    localBitmap = this.cachedCaptureImage;
    if ((localBitmap == null) || (localBitmap.isRecycled())) {
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
      if ((this.config.initialTime > 0.0D) && (getCurrentPos() == 0L))
      {
        play((this.config.initialTime * 1000.0D));
        return;
      }
      play(getCurrentPos());
    }
  }
  
  private void initPlayer(MiniAppVideoConfig paramMiniAppVideoConfig)
  {
    this.mAudioManager = ((AudioManager)this.activity.getSystemService("audio"));
    paramMiniAppVideoConfig = this.mAudioManager;
    if (paramMiniAppVideoConfig != null) {
      this.maxVolume = paramMiniAppVideoConfig.getStreamMaxVolume(3);
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
      if (!StringUtil.isEmpty(paramMiniAppVideoConfig.poster))
      {
        setPoster();
        return;
      }
      if (!StringUtil.isEmpty(paramMiniAppVideoConfig.mUrls)) {
        MediaUtils.getImageForVideo(this.miniAppContext, paramMiniAppVideoConfig.mUrls, new MiniAppVideoController.13(this));
      }
    }
  }
  
  private void initUI()
  {
    this.ui = new IVideoPlayerUIImpl(this.activity);
    this.ui.setController(this);
    this.ui.setUpUI(getClickListener(), getVideoGestureListener(), getOnSeekBarChangeListener());
  }
  
  private boolean isLandscapeVideo()
  {
    IVideoPlayer localIVideoPlayer = this.player;
    if (localIVideoPlayer != null)
    {
      int j = localIVideoPlayer.getVideoWidth();
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
      k = this.rotation;
      if ((k != 0) && (k != 180))
      {
        if (j > i) {
          return false;
        }
      }
      else if (j < i) {
        return false;
      }
    }
    return true;
  }
  
  /* Error */
  private void parseOriVideoSize(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 668	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +292 -> 296
    //   7: aload_1
    //   8: ldc_w 670
    //   11: invokevirtual 428	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   14: ifeq +282 -> 296
    //   17: getstatic 395	android/os/Build$VERSION:SDK_INT	I
    //   20: bipush 15
    //   22: if_icmple +274 -> 296
    //   25: new 672	java/io/FileInputStream
    //   28: dup
    //   29: aload_0
    //   30: getfield 99	com/tencent/qqmini/sdk/widget/media/MiniAppVideoController:config	Lcom/tencent/qqmini/sdk/widget/media/MiniAppVideoConfig;
    //   33: getfield 622	com/tencent/qqmini/sdk/widget/media/MiniAppVideoConfig:mUrls	Ljava/lang/String;
    //   36: invokespecial 674	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   39: astore_1
    //   40: new 397	android/media/MediaExtractor
    //   43: dup
    //   44: invokespecial 675	android/media/MediaExtractor:<init>	()V
    //   47: astore 5
    //   49: aload_1
    //   50: astore_3
    //   51: aload 5
    //   53: astore 4
    //   55: aload 5
    //   57: aload_1
    //   58: invokevirtual 679	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   61: invokevirtual 683	android/media/MediaExtractor:setDataSource	(Ljava/io/FileDescriptor;)V
    //   64: aload_1
    //   65: astore_3
    //   66: aload 5
    //   68: astore 4
    //   70: aload_0
    //   71: aload 5
    //   73: invokespecial 685	com/tencent/qqmini/sdk/widget/media/MiniAppVideoController:getAndSelectVideoTrackIndex	(Landroid/media/MediaExtractor;)I
    //   76: istore_2
    //   77: iload_2
    //   78: iconst_m1
    //   79: if_icmple +88 -> 167
    //   82: aload_1
    //   83: astore_3
    //   84: aload 5
    //   86: astore 4
    //   88: aload 5
    //   90: iload_2
    //   91: invokevirtual 412	android/media/MediaExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   94: astore 6
    //   96: aload_1
    //   97: astore_3
    //   98: aload 5
    //   100: astore 4
    //   102: aload 6
    //   104: ldc_w 687
    //   107: invokevirtual 690	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   110: ifeq +21 -> 131
    //   113: aload_1
    //   114: astore_3
    //   115: aload 5
    //   117: astore 4
    //   119: aload_0
    //   120: aload 6
    //   122: ldc_w 687
    //   125: invokevirtual 694	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   128: putfield 660	com/tencent/qqmini/sdk/widget/media/MiniAppVideoController:rotation	I
    //   131: aload_1
    //   132: astore_3
    //   133: aload 5
    //   135: astore 4
    //   137: aload_0
    //   138: aload 6
    //   140: ldc_w 696
    //   143: invokevirtual 694	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   146: putfield 656	com/tencent/qqmini/sdk/widget/media/MiniAppVideoController:originWidth	I
    //   149: aload_1
    //   150: astore_3
    //   151: aload 5
    //   153: astore 4
    //   155: aload_0
    //   156: aload 6
    //   158: ldc_w 698
    //   161: invokevirtual 694	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   164: putfield 658	com/tencent/qqmini/sdk/widget/media/MiniAppVideoController:originHeight	I
    //   167: aload_1
    //   168: invokevirtual 701	java/io/FileInputStream:close	()V
    //   171: aload 5
    //   173: astore_1
    //   174: goto +88 -> 262
    //   177: astore_3
    //   178: aload_1
    //   179: astore 6
    //   181: aload 5
    //   183: astore_1
    //   184: aload_3
    //   185: astore 5
    //   187: goto +41 -> 228
    //   190: astore_3
    //   191: goto +13 -> 204
    //   194: astore 4
    //   196: aload_1
    //   197: astore_3
    //   198: goto +21 -> 219
    //   201: astore_3
    //   202: aconst_null
    //   203: astore_1
    //   204: aconst_null
    //   205: astore 4
    //   207: aload_1
    //   208: astore 5
    //   210: aload_3
    //   211: astore_1
    //   212: goto +59 -> 271
    //   215: astore 4
    //   217: aconst_null
    //   218: astore_3
    //   219: aconst_null
    //   220: astore_1
    //   221: aload 4
    //   223: astore 5
    //   225: aload_3
    //   226: astore 6
    //   228: aload 6
    //   230: astore_3
    //   231: aload_1
    //   232: astore 4
    //   234: ldc 10
    //   236: ldc_w 703
    //   239: aload 5
    //   241: invokestatic 709	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   244: pop
    //   245: aload 6
    //   247: ifnull +11 -> 258
    //   250: aload 6
    //   252: invokevirtual 701	java/io/FileInputStream:close	()V
    //   255: goto +3 -> 258
    //   258: aload_1
    //   259: ifnull +37 -> 296
    //   262: aload_1
    //   263: invokevirtual 712	android/media/MediaExtractor:release	()V
    //   266: return
    //   267: astore_1
    //   268: aload_3
    //   269: astore 5
    //   271: aload 5
    //   273: ifnull +11 -> 284
    //   276: aload 5
    //   278: invokevirtual 701	java/io/FileInputStream:close	()V
    //   281: goto +3 -> 284
    //   284: aload 4
    //   286: ifnull +8 -> 294
    //   289: aload 4
    //   291: invokevirtual 712	android/media/MediaExtractor:release	()V
    //   294: aload_1
    //   295: athrow
    //   296: return
    //   297: astore_1
    //   298: aload 5
    //   300: astore_1
    //   301: goto -39 -> 262
    //   304: astore_3
    //   305: goto -47 -> 258
    //   308: astore_3
    //   309: goto -25 -> 284
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	312	0	this	MiniAppVideoController
    //   0	312	1	paramString	String
    //   76	15	2	i	int
    //   50	101	3	str1	String
    //   177	8	3	localThrowable1	Throwable
    //   190	1	3	localObject1	Object
    //   197	1	3	str2	String
    //   201	10	3	localObject2	Object
    //   218	51	3	localObject3	Object
    //   304	1	3	localIOException1	java.io.IOException
    //   308	1	3	localIOException2	java.io.IOException
    //   53	101	4	localObject4	Object
    //   194	1	4	localThrowable2	Throwable
    //   205	1	4	localObject5	Object
    //   215	7	4	localThrowable3	Throwable
    //   232	58	4	str3	String
    //   47	252	5	localObject6	Object
    //   94	157	6	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   55	64	177	java/lang/Throwable
    //   70	77	177	java/lang/Throwable
    //   88	96	177	java/lang/Throwable
    //   102	113	177	java/lang/Throwable
    //   119	131	177	java/lang/Throwable
    //   137	149	177	java/lang/Throwable
    //   155	167	177	java/lang/Throwable
    //   40	49	190	finally
    //   40	49	194	java/lang/Throwable
    //   25	40	201	finally
    //   25	40	215	java/lang/Throwable
    //   55	64	267	finally
    //   70	77	267	finally
    //   88	96	267	finally
    //   102	113	267	finally
    //   119	131	267	finally
    //   137	149	267	finally
    //   155	167	267	finally
    //   234	245	267	finally
    //   167	171	297	java/io/IOException
    //   250	255	304	java/io/IOException
    //   276	281	308	java/io/IOException
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(parseTwoBitNumString(paramLong));
    localStringBuilder.append(":");
    localStringBuilder.append(parseTwoBitNumString(i));
    return localStringBuilder.toString();
  }
  
  private static String parseTwoBitNumString(long paramLong)
  {
    if (paramLong == 0L) {
      return "00";
    }
    if (paramLong < 10L)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("0");
      localStringBuilder.append(paramLong);
      return localStringBuilder.toString();
    }
    return Long.toString(paramLong);
  }
  
  private String parseUrl(String paramString)
  {
    boolean bool = paramString.startsWith("wxfile");
    String str = null;
    if (bool)
    {
      IMiniAppContext localIMiniAppContext = this.miniAppContext;
      if (localIMiniAppContext != null) {
        str = ((MiniAppFileManager)localIMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath(paramString);
      }
      return str;
    }
    if (!paramString.startsWith("http"))
    {
      if (paramString.startsWith("https")) {
        return paramString;
      }
      return null;
    }
    return paramString;
  }
  
  private void pause()
  {
    QMLog.d("MiniAppVideoController", "pause");
    Object localObject = this.player;
    if (localObject == null) {
      return;
    }
    this.playingBefore = false;
    if (!((IVideoPlayer)localObject).isPlaying()) {
      return;
    }
    cancelAvoidLockScreen();
    this.player.pause();
    this.isPause = true;
    localObject = this.miniAppContext;
    if ((localObject != null) && (((IMiniAppContext)localObject).isMiniGame()))
    {
      callbackVideoStateChange("pause");
      return;
    }
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("videoId", this.videoPlayerId);
      ((JSONObject)localObject).put("data", this.data);
      IMiniAppContext localIMiniAppContext = this.miniAppContext;
      if (localIMiniAppContext != null) {
        this.miniAppContext.performAction(ServiceSubscribeEvent.obtain("onVideoPause", ((JSONObject)localObject).toString(), this.webViewId));
      }
      this.pageWebView.evaluateSubscribeJS("onVideoPause", ((JSONObject)localObject).toString(), this.webViewId);
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
    Object localObject1 = this.player;
    if ((localObject1 != null) && (((IVideoPlayer)localObject1).getCurrentPostion() > 0L))
    {
      this.player.start();
      localObject1 = this.miniAppContext;
      if ((localObject1 != null) && (((IMiniAppContext)localObject1).isMiniGame())) {
        callbackVideoStateChange("play");
      } else {
        try
        {
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("data", this.data);
          Object localObject2 = this.miniAppContext;
          if (localObject2 != null) {
            this.miniAppContext.performAction(ServiceSubscribeEvent.obtain("onVideoPlay", ((JSONObject)localObject1).toString(), this.webViewId));
          }
          this.pageWebView.evaluateSubscribeJS("onVideoPlay", ((JSONObject)localObject1).toString(), this.webViewId);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("evaluateSubcribeJS onVideoPlay = ");
          ((StringBuilder)localObject2).append(((JSONObject)localObject1).toString());
          QMLog.d("MiniAppVideoController", ((StringBuilder)localObject2).toString());
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
      }
    }
    else
    {
      play((this.config.initialTime * 1000.0D));
    }
    this.isPause = false;
  }
  
  private void stop(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.config.isFullScreen)) {
      smallScreen();
    }
    this.isVideoPrepared = false;
    IVideoPlayer localIVideoPlayer = this.player;
    if (localIVideoPlayer != null) {
      localIVideoPlayer.stop();
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
    if (!paramBoolean)
    {
      local12.run();
      return;
    }
    if ((this.isBufferStart) || (this.lastBufferProgress != 0)) {
      ThreadManager.getUIHandler().postDelayed(local12, 20L);
    }
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
    IVideoPlayer localIVideoPlayer = this.player;
    if (localIVideoPlayer == null)
    {
      QMLog.e("MiniAppVideoController", "captureImage video player is null");
      paramOnCaptureImageListener.onCaptureImageFailed();
      return;
    }
    try
    {
      if (!localIVideoPlayer.isPlaying())
      {
        if ((this.cachedCaptureImage != null) && (!this.cachedCaptureImage.isRecycled()))
        {
          paramOnCaptureImageListener.onCaptureImageSucceed(this.cachedCaptureImage);
          return;
        }
        paramOnCaptureImageListener.onCaptureImageFailed();
        return;
      }
      int i = this.ui.getPlayerViewWidth();
      int j = this.ui.getPlayerViewHeight();
      this.player.setOnCaptureImageListener(getCaptureImageListener(paramOnCaptureImageListener));
      this.player.captureImageInTime(i, j);
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("captureImage video player fail!,e");
      localStringBuilder.append(localException);
      QMLog.e("MiniAppVideoController", localStringBuilder.toString());
      paramOnCaptureImageListener.onCaptureImageFailed();
    }
  }
  
  public void fullScreen()
  {
    if (!this.isVideoPrepared)
    {
      Message localMessage = new Message();
      localMessage.what = 2004;
      this.taskQueueRunAfterVideoPrepared.add(localMessage);
      return;
    }
    if (this.isBusyInChangeScreen) {
      return;
    }
    QMLog.e("fullScreen - fullScreen()", "fullScreen() - config.isFullScreen = true");
    this.config.isFullScreen = true;
    boolean bool = isLandscapeVideo();
    ThreadManager.getUIHandler().post(new MiniAppVideoController.20(this, bool));
  }
  
  public long getCurrentPos()
  {
    IVideoPlayer localIVideoPlayer = this.player;
    if (localIVideoPlayer == null) {
      return 0L;
    }
    return localIVideoPlayer.getCurrentPostion();
  }
  
  public FrameLayout getUI()
  {
    IVideoPlayerUI localIVideoPlayerUI = this.ui;
    if (localIVideoPlayerUI != null) {
      return localIVideoPlayerUI.getUI();
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
    int i = paramMessage.what;
    if (i != 2002)
    {
      if (i != 2004) {
        return false;
      }
      fullScreen();
      return true;
    }
    long l1 = System.currentTimeMillis();
    paramMessage = this.player;
    if ((paramMessage != null) && (paramMessage.isPlaying()))
    {
      this.ui.updatePlayingTime(parseTimeString(this.player.getCurrentPostion()));
      this.ui.updateDanmuTime(this.player.getCurrentPostion());
      if (!this.isChangingProgress) {
        this.ui.setProgressByPlayingTime(this.player.getDuration(), this.player.getCurrentPostion());
      }
      if ("com.tencent.qqmini.minigame.GameJsService".equals(this.pageWebView.getClass().getName())) {
        callbackVideoStateChange("timeUpdate");
      } else {
        try
        {
          paramMessage = new JSONObject();
          paramMessage.put("data", this.data);
          long l2 = this.player.getCurrentPostion();
          double d = l2;
          Double.isNaN(d);
          d /= 1000.0D;
          paramMessage.put("position", d);
          l2 = this.player.getDuration();
          d = l2;
          Double.isNaN(d);
          d /= 1000.0D;
          paramMessage.put("duration", d);
          paramMessage.put("videoId", this.videoPlayerId);
          Object localObject = this.miniAppContext;
          if (localObject != null) {
            this.miniAppContext.performAction(ServiceSubscribeEvent.obtain("onVideoTimeUpdate", paramMessage.toString(), this.webViewId));
          }
          this.pageWebView.evaluateSubscribeJS("onVideoTimeUpdate", paramMessage.toString(), this.webViewId);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("evaluateSubcribeJS onVideoTimeUpdate = ");
          ((StringBuilder)localObject).append(paramMessage.toString());
          QMLog.d("MiniAppVideoController", ((StringBuilder)localObject).toString());
        }
        catch (JSONException paramMessage)
        {
          paramMessage.printStackTrace();
        }
      }
    }
    if (!this.isPause) {
      sendPlayingMsg(l1 + 200L - System.currentTimeMillis());
    }
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
    IVideoPlayer localIVideoPlayer = this.player;
    if (localIVideoPlayer == null) {
      return;
    }
    if (localIVideoPlayer.isPlaying())
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
    if (this.player == null) {
      return;
    }
    if (StringUtil.isEmpty(this.config.mUrls)) {
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
    this.handler.removeMessages(2002);
  }
  
  public boolean seekTo(int paramInt)
  {
    Object localObject = this.player;
    if (localObject == null) {
      return false;
    }
    if (paramInt < 0)
    {
      ((IVideoPlayer)localObject).seekTo(0);
      return true;
    }
    long l = ((IVideoPlayer)localObject).getDuration();
    if ((l > 0L) && (paramInt > l))
    {
      this.player.seekTo((int)l);
      return true;
    }
    localObject = this.config;
    double d = paramInt;
    Double.isNaN(d);
    ((MiniAppVideoConfig)localObject).initialTime = (d / 1000.0D);
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setVideoPath: ");
    localStringBuilder.append(paramString);
    QMLog.d("MiniAppVideoController", localStringBuilder.toString());
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("smallScreen current pos is: ");
    localStringBuilder.append(this.mCurrPos);
    QMLog.d("MiniAppVideoController", localStringBuilder.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.media.MiniAppVideoController
 * JD-Core Version:    0.7.0.1
 */