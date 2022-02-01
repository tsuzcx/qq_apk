package com.tencent.qqmini.sdk.widget.media;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings.System;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.R.drawable;
import com.tencent.qqmini.sdk.R.id;
import com.tencent.qqmini.sdk.R.layout;
import com.tencent.qqmini.sdk.action.GetPageIntAction;
import com.tencent.qqmini.sdk.action.GetPageStringAction;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.ScreenOffOnListener;
import com.tencent.qqmini.sdk.core.utils.StringUtil;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.ServiceSubscribeEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnCaptureImageListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnCompletionListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnControllerClickListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnErrorListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnInfoListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnSeekCompleteListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnVideoPreparedListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.WindowInfo;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.launcher.utils.LiuHaiUtils;
import com.tencent.qqmini.sdk.launcher.widget.VideoGestureRelativeLayout;
import com.tencent.qqmini.sdk.launcher.widget.VideoGestureRelativeLayout.VideoGestureListener;
import com.tencent.qqmini.sdk.utils.ImmersiveUtils;
import com.tencent.qqmini.sdk.widget.media.danmu.Barrage;
import com.tencent.qqmini.sdk.widget.media.danmu.BarrageView;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MiniAppVideoPlayer
  extends FrameLayout
  implements MediaPlayer.OnPreparedListener, Handler.Callback, View.OnClickListener
{
  private static final int MSG_WHAT_HIDE = 2003;
  private static final int MSG_WHAT_PLAYING = 2002;
  public static final String NOTIFY_STATUS_RESET = "resetPlayer";
  public static final String NOTIFY_STATUS_RESUME = "resumePlayer";
  private static final String TAG = "MiniAppVideoPlayer";
  private static final String TVK_TAG = "MiniAppVideoPlayer_TVK_IMediaPlayer";
  private static final String VIDEO_STATE_ENDED = "ended";
  private static final String VIDEO_STATE_ERROR = "error";
  private static final String VIDEO_STATE_EXIT_FULL_SCREEN = "exitFullScreen";
  private static final String VIDEO_STATE_PAUSE = "pause";
  private static final String VIDEO_STATE_PLAY = "play";
  private static final String VIDEO_STATE_REQUEST_FULL_SCREEN = "requestFullScreen";
  private static final String VIDEO_STATE_TIME_UPDATE = "timeUpdate";
  private static final String VIDEO_STATE_WAITTING = "waiting";
  public static final String VIEW_TAG = "MiniAppVideoPlayer";
  public static volatile boolean mIsInited = false;
  private static final String oskPlayerContentTypeList = WnsConfig.getConfig("QZoneSetting", "MiniProgramVideoContentType", "application/octet-stream; charset=utf-8");
  private ViewGroup actionVg;
  public WeakReference<Activity> atyRef;
  public boolean autoPauseIfNavigate = true;
  public boolean autoPauseIfOpenNative = true;
  public boolean autoplay = false;
  private ImageView backIv;
  private ImageView barrageIv;
  public List<Barrage> barrages;
  private float brightness = 1.0F;
  private Bitmap cachedCaptureImage;
  private ImageView centerControlIv;
  private int componentLayoutScrollY = 0;
  private View controlBar;
  private ImageView controlIv;
  public boolean customCache;
  private BarrageView danmuView;
  public String data;
  public int direction = -1;
  public boolean enableDanmu = false;
  public boolean enablePlayGesture;
  public boolean enableProgressGesture = true;
  private final Handler handler = new Handler(Looper.getMainLooper(), this);
  private boolean hasSetUp = false;
  public boolean hide;
  public boolean hideTimeDesc = false;
  public double initialTime = 0.0D;
  public boolean isBarrageOpen;
  private boolean isBufferStart = false;
  boolean isBusyInChangeScreen = false;
  private boolean isChangingProgress;
  public boolean isFullScreen;
  public boolean isLive = false;
  public boolean isMuted = false;
  public boolean isPageOnBackground = false;
  private boolean isPause;
  boolean isResetPath = false;
  public boolean isShowBasicControl = true;
  public boolean isShowControlBar = true;
  private int lastBufferProgress = 0;
  private int lastNavBarVisibility = 8;
  public String lastPoster;
  long lastSmallScreenTime = -1L;
  private int lastTabBarVisibility = 8;
  private View loadingView;
  public boolean loop = false;
  private AudioManager mAudioManager;
  private Context mContext;
  private long mCurrPos;
  private WindowManager.LayoutParams mLayoutParams;
  public WeakReference<IMiniAppContext> mMiniAppContext;
  public String mUrls;
  private VideoGestureLayout mVideoGestureLayout;
  private AbsVideoPlayer mVideoPlayer = null;
  private View mVideoView = null;
  private Window mWindow;
  private int maxVolume = 0;
  private ImageView muteIv;
  public boolean muted = false;
  public boolean needEvent;
  private boolean needPauseOnLoad;
  private int newProgress = 0;
  private TextView nowTimeTv;
  public String objectFit = "contain";
  private int oldProgress = 0;
  private int oldVolume = 0;
  private int originHeight;
  private int originWidth;
  public boolean pageGesture = false;
  public IJsService pageWebview;
  public int parentId;
  public boolean pauseByUser = false;
  public String playBtnPosition;
  private ImageView play_status_img;
  private SeekBar playerSeekBar;
  public boolean playingBefore = false;
  private View playingPopView;
  public String poster = null;
  public JSONObject postionObj;
  private int rotation;
  private TextView seekTv;
  public boolean showCenterPlayBtn = true;
  public boolean showControlProgress;
  public boolean showDanmuBtn = false;
  public boolean showFullScreenBtn = true;
  public boolean showLiveBtn;
  public boolean showMuteBtn = false;
  public boolean showPlayBtn = true;
  public boolean showProgress = true;
  private ViewGroup.LayoutParams smallLayoutParams;
  public String title;
  private TextView titleTv;
  private TextView totalTimeTv;
  private View vdView;
  public int videoHeight = 150;
  public long videoId;
  public MiniAppVideoPlayer.VideoPlayerStatusObserver videoPlayerStatusObserver;
  public int videoWidth = 300;
  public int videoX;
  public int videoY;
  private VideoGestureRelativeLayout video_container;
  private ImageView video_img;
  private FrameLayout video_pop_container;
  private View view;
  public int webviewId;
  private ImageView windowIv;
  
  public MiniAppVideoPlayer(Context paramContext)
  {
    this(paramContext, null);
    setUpView(paramContext);
  }
  
  public MiniAppVideoPlayer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setUpView(paramContext);
  }
  
  private void avoidLockScreen()
  {
    if ((this.atyRef != null) && (this.atyRef.get() != null))
    {
      ((Activity)this.atyRef.get()).getWindow().addFlags(128);
      ((Activity)this.atyRef.get()).getWindow().clearFlags(1);
      QMLog.d("MiniAppVideoPlayer", "avoidLockScreen");
    }
  }
  
  private void callBackFullScreenChange()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("data", this.data);
      localJSONObject.put("videoId", this.videoId);
      localJSONObject.put("fullScreen", this.isFullScreen);
      if (this.mMiniAppContext != null) {}
      for (IMiniAppContext localIMiniAppContext = (IMiniAppContext)this.mMiniAppContext.get();; localIMiniAppContext = null)
      {
        if (localIMiniAppContext != null) {
          localIMiniAppContext.performAction(ServiceSubscribeEvent.obtain("onVideoFullScreenChange", localJSONObject.toString(), this.webviewId));
        }
        this.pageWebview.evaluateSubscribeJS("onVideoFullScreenChange", localJSONObject.toString(), this.webviewId);
        return;
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  private void callBackFullScreenChange(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("data", this.data);
        localJSONObject.put("videoId", this.videoId);
        localJSONObject.put("fullScreen", this.isFullScreen);
        if (paramBoolean)
        {
          localJSONObject.put("direction", "horizontal");
          if (this.mMiniAppContext != null)
          {
            IMiniAppContext localIMiniAppContext = (IMiniAppContext)this.mMiniAppContext.get();
            if (localIMiniAppContext != null) {
              localIMiniAppContext.performAction(ServiceSubscribeEvent.obtain("onVideoFullScreenChange", localJSONObject.toString(), this.webviewId));
            }
            this.pageWebview.evaluateSubscribeJS("onVideoFullScreenChange", localJSONObject.toString(), this.webviewId);
          }
        }
        else
        {
          localJSONObject.put("direction", "vertical");
          continue;
        }
        Object localObject = null;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return;
      }
    }
  }
  
  private void callbackVideoStateChange(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("data", this.data);
      localJSONObject.put("videoPlayerId", this.videoId);
      localJSONObject.put("state", paramString);
      if ("timeUpdate".equals(paramString))
      {
        localJSONObject.put("position", this.mVideoPlayer.getCurrentPostion() / 1000.0D);
        localJSONObject.put("duration", this.mVideoPlayer.getDuration() / 1000.0D);
      }
      if (this.mMiniAppContext != null) {}
      for (paramString = (IMiniAppContext)this.mMiniAppContext.get();; paramString = null)
      {
        if (paramString != null) {
          paramString.performAction(ServiceSubscribeEvent.obtain("onVideoStateChange", localJSONObject.toString(), this.webviewId));
        }
        this.pageWebview.evaluateSubscribeJS("onVideoStateChange", localJSONObject.toString(), this.webviewId);
        return;
      }
      return;
    }
    catch (Throwable paramString)
    {
      QMLog.e("MiniAppVideoPlayer", "callbackVideoStateChange error.", paramString);
    }
  }
  
  private void cancelAvoidLockScreen()
  {
    if ((this.atyRef != null) && (this.atyRef.get() != null))
    {
      ((Activity)this.atyRef.get()).getWindow().clearFlags(128);
      ((Activity)this.atyRef.get()).getWindow().addFlags(1);
      QMLog.d("MiniAppVideoPlayer", "cancelAvoidLockScreen");
    }
  }
  
  private void enterFullScreenMode(Activity paramActivity)
  {
    int i = paramActivity.getWindow().getDecorView().getSystemUiVisibility();
    if (Build.VERSION.SDK_INT >= 21)
    {
      i = 5894;
      if (Build.VERSION.SDK_INT < 19) {
        break label64;
      }
      i |= 0x800;
    }
    for (;;)
    {
      paramActivity.getWindow().getDecorView().setSystemUiVisibility(i);
      return;
      if (Build.VERSION.SDK_INT < 16) {
        break;
      }
      i = 1798;
      break;
      label64:
      i |= 0x1;
    }
  }
  
  public static int getAndSelectVideoTrackIndex(MediaExtractor paramMediaExtractor)
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
  
  private int getBrightness()
  {
    if (this.atyRef != null)
    {
      Activity localActivity = (Activity)this.atyRef.get();
      if (localActivity != null) {
        return Settings.System.getInt(localActivity.getContentResolver(), "screen_brightness", 255);
      }
    }
    return 255;
  }
  
  private void getCachedCaptureImage()
  {
    if ((this.cachedCaptureImage != null) && (!this.cachedCaptureImage.isRecycled()))
    {
      this.cachedCaptureImage.recycle();
      this.cachedCaptureImage = null;
    }
    if ((this.cachedCaptureImage == null) || (this.cachedCaptureImage.isRecycled())) {
      getHandler().postDelayed(new MiniAppVideoPlayer.17(this), 1000L);
    }
  }
  
  @NotNull
  private AbsVideoPlayer.OnCaptureImageListener getCaptureImageListener(AbsVideoPlayer.OnCaptureImageListener paramOnCaptureImageListener)
  {
    return new MiniAppVideoPlayer.18(this, paramOnCaptureImageListener);
  }
  
  @NotNull
  private AbsVideoPlayer.OnCompletionListener getCompletionListener()
  {
    return new MiniAppVideoPlayer.8(this);
  }
  
  @NotNull
  private AbsVideoPlayer.OnControllerClickListener getControllerClickListener()
  {
    return new MiniAppVideoPlayer.10(this);
  }
  
  @NotNull
  private AbsVideoPlayer.OnErrorListener getErrorListener()
  {
    return new MiniAppVideoPlayer.7(this);
  }
  
  @NotNull
  private AbsVideoPlayer.OnInfoListener getInfoListener()
  {
    return new MiniAppVideoPlayer.6(this);
  }
  
  @NotNull
  private SeekBar.OnSeekBarChangeListener getSeekBarChangeListener()
  {
    return new MiniAppVideoPlayer.2(this);
  }
  
  @NotNull
  private AbsVideoPlayer.OnSeekCompleteListener getSeekCompleteListener()
  {
    return new MiniAppVideoPlayer.5(this);
  }
  
  @NotNull
  private VideoGestureRelativeLayout.VideoGestureListener getVideoGestureListener()
  {
    return new MiniAppVideoPlayer.3(this);
  }
  
  @NotNull
  private AbsVideoPlayer.OnVideoPreparedListener getVideoPreparedListener()
  {
    return new MiniAppVideoPlayer.9(this);
  }
  
  private void handleBrightnessGesture(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2)
  {
    float f1 = 0.0F;
    if ((!this.pageGesture) || (this.isFullScreen)) {
      return;
    }
    float f2 = (paramMotionEvent1.getY() - paramMotionEvent2.getY()) / this.video_container.getHeight() + this.brightness;
    if (f2 < 0.0F) {}
    for (;;)
    {
      if ((this.mWindow != null) && (this.mLayoutParams != null))
      {
        this.mLayoutParams.screenBrightness = f1;
        this.mWindow.setAttributes(this.mLayoutParams);
      }
      this.mVideoGestureLayout.setProgress((int)(f1 * 100.0F));
      this.mVideoGestureLayout.setImageResource(R.drawable.mini_sdk_video_brightness);
      this.mVideoGestureLayout.show();
      return;
      if (f2 > 1.0F) {
        f1 = 1.0F;
      } else {
        f1 = f2;
      }
    }
  }
  
  private void handlePlayBtnClick()
  {
    if (this.play_status_img.getVisibility() == 0)
    {
      if ((this.initialTime > 0.0D) && (getCurrentPos() == 0L)) {
        play((this.initialTime * 1000.0D));
      }
    }
    else {
      return;
    }
    play(getCurrentPos());
  }
  
  private void handleProgressGesture(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2)
  {
    if (!this.enableProgressGesture) {}
    while (this.mVideoPlayer == null) {
      return;
    }
    float f1 = paramMotionEvent2.getX() - paramMotionEvent1.getX();
    float f2;
    if (f1 > 0.0F)
    {
      this.mVideoGestureLayout.setImageResource(R.drawable.mini_sdk_video_progress_ff);
      f2 = this.oldProgress;
      this.newProgress = ((int)(f1 / this.video_container.getWidth() * 100.0F + f2));
      if (this.newProgress > 100) {
        this.newProgress = 100;
      }
    }
    for (;;)
    {
      this.mVideoGestureLayout.setProgress(this.newProgress);
      this.mVideoGestureLayout.show();
      int i = (int)this.mVideoPlayer.getDuration() * this.newProgress / 100;
      this.mVideoPlayer.seekTo(i);
      return;
      this.mVideoGestureLayout.setImageResource(R.drawable.mini_sdk_video_progress_fr);
      f2 = this.oldProgress;
      this.newProgress = ((int)(f1 / this.video_container.getWidth() * 100.0F + f2));
      if (this.newProgress < 0) {
        this.newProgress = 0;
      }
    }
  }
  
  private void handleVolumeGesture(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2)
  {
    if ((!this.pageGesture) || (this.isFullScreen) || (this.maxVolume == 0)) {
      return;
    }
    int i = this.video_container.getHeight() / this.maxVolume;
    i = (int)((int)((paramMotionEvent1.getY() - paramMotionEvent2.getY()) / i + this.oldVolume) / Float.valueOf(this.maxVolume).floatValue() * 100.0F);
    if (i >= 50) {
      this.mVideoGestureLayout.setImageResource(R.drawable.mini_sdk_video_volume_higher);
    }
    for (;;)
    {
      this.mVideoGestureLayout.setProgress(i);
      this.mVideoGestureLayout.show();
      return;
      if (i > 0) {
        this.mVideoGestureLayout.setImageResource(R.drawable.mini_sdk_video_volume_lower);
      } else {
        this.mVideoGestureLayout.setImageResource(R.drawable.mini_sdk_video_volume_off);
      }
    }
  }
  
  private void hidePopCtrView()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 2003;
    this.handler.sendMessageDelayed(localMessage, 500L);
  }
  
  private void initDanmuView()
  {
    if (this.isShowBasicControl)
    {
      Properties localProperties = new Properties();
      if (this.enableDanmu)
      {
        this.danmuView = new BarrageView(this.mContext, null);
        FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
        addView(this.danmuView, localLayoutParams);
        this.danmuView.setBarrages(this.barrages);
      }
      if (this.customCache) {
        localProperties.put("mHaveCacheDownload", "true");
      }
    }
  }
  
  private void initPlayer()
  {
    int i = 0;
    if (this.mVideoPlayer == null)
    {
      localObject = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
      if (localObject == null) {
        break label51;
      }
    }
    label51:
    for (Object localObject = ((ChannelProxy)localObject).getVideoPlayer();; localObject = null)
    {
      this.mVideoPlayer = ((AbsVideoPlayer)localObject);
      if (this.mVideoPlayer != null) {
        break;
      }
      QMLog.e("MiniAppVideoPlayer", "initPlayer mVideoPlayer is null, return.");
      return;
    }
    this.mVideoView = this.mVideoPlayer.createVideoView(this.mContext);
    if (this.mVideoView == null)
    {
      QMLog.e("MiniAppVideoPlayer", "initPlayer mVideoView is null, return.");
      return;
    }
    localObject = new FrameLayout.LayoutParams(-1, -1);
    this.vdView = this.mVideoView;
    this.vdView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.vdView.setVisibility(0);
    this.mVideoPlayer.setXYaxis(0);
    initPoster();
    initDanmuView();
    this.mVideoPlayer.setOnControllerClickListener(getControllerClickListener());
    this.mVideoPlayer.setOnVideoPreparedListener(getVideoPreparedListener());
    this.mVideoPlayer.setOnCompletionListener(getCompletionListener());
    this.mVideoPlayer.setLoopback(this.loop);
    this.mVideoPlayer.setOnErrorListener(getErrorListener());
    this.mVideoPlayer.setOnInfoListener(getInfoListener());
    this.mVideoPlayer.setOnSeekCompleteListener(getSeekCompleteListener());
    updateCenterBtn();
    this.video_container.removeAllViews();
    this.video_container.addView(this.vdView);
    this.video_container.setBackgroundColor(-16777216);
    localObject = new FrameLayout.LayoutParams(DisplayUtil.dip2px(this.mContext, 100.0F), DisplayUtil.dip2px(this.mContext, 100.0F));
    ((FrameLayout.LayoutParams)localObject).gravity = 17;
    this.video_container.addView(this.mVideoGestureLayout, (ViewGroup.LayoutParams)localObject);
    boolean bool;
    if ((this.mCurrPos > 0L) && (isWifiConnect()))
    {
      QMLog.d("MiniAppVideoPlayer", "play current pos is: " + this.mCurrPos);
      play(this.mCurrPos);
      if (!this.isPause)
      {
        bool = true;
        resetControlIvDrawable(bool);
        this.needPauseOnLoad = this.isPause;
      }
    }
    else
    {
      localObject = this.mVideoPlayer;
      if (!this.objectFit.equals("contain")) {
        break label394;
      }
    }
    for (;;)
    {
      ((AbsVideoPlayer)localObject).setXYaxis(i);
      return;
      bool = false;
      break;
      label394:
      i = 1;
    }
  }
  
  private void initPoster()
  {
    if (!this.autoplay)
    {
      if (StringUtil.isEmpty(this.poster)) {
        break label22;
      }
      setPoster();
    }
    label22:
    while (StringUtil.isEmpty(this.mUrls)) {
      return;
    }
    MediaUtils.getImageForVideo(this.mMiniAppContext, this.mUrls, new MiniAppVideoPlayer.11(this));
  }
  
  private boolean isLandscapeVideo()
  {
    if (this.mVideoPlayer != null)
    {
      int j = this.mVideoPlayer.getVideoWidth();
      int k = this.mVideoPlayer.getVideoHeight();
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
  
  private List<Barrage> parseDanmuList(JSONArray paramJSONArray)
  {
    if (paramJSONArray == null) {
      return this.barrages;
    }
    if (this.barrages == null) {
      this.barrages = new LinkedList();
    }
    for (;;)
    {
      int j = paramJSONArray.length();
      if (j > 0)
      {
        int i = 0;
        label38:
        if (i < j) {
          try
          {
            this.barrages.add(Barrage.parseJson(paramJSONArray.getJSONObject(i)));
            i += 1;
            break label38;
            this.barrages.clear();
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              localJSONException.printStackTrace();
            }
          }
        }
      }
    }
    if (this.danmuView != null) {
      this.danmuView.setBarrages(this.barrages);
    }
    return this.barrages;
  }
  
  /* Error */
  private void parseOriVideoSize(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_1
    //   4: invokestatic 1159	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifne +130 -> 137
    //   10: aload_1
    //   11: ldc_w 1161
    //   14: invokevirtual 762	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   17: ifeq +120 -> 137
    //   20: getstatic 715	android/os/Build$VERSION:SDK_INT	I
    //   23: bipush 15
    //   25: if_icmple +112 -> 137
    //   28: new 1163	java/io/FileInputStream
    //   31: dup
    //   32: aload_0
    //   33: getfield 1100	com/tencent/qqmini/sdk/widget/media/MiniAppVideoPlayer:mUrls	Ljava/lang/String;
    //   36: invokespecial 1165	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   39: astore_3
    //   40: new 724	android/media/MediaExtractor
    //   43: dup
    //   44: invokespecial 1166	android/media/MediaExtractor:<init>	()V
    //   47: astore 5
    //   49: aload 5
    //   51: aload_3
    //   52: invokevirtual 1170	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   55: invokevirtual 1174	android/media/MediaExtractor:setDataSource	(Ljava/io/FileDescriptor;)V
    //   58: aload 5
    //   60: invokestatic 1176	com/tencent/qqmini/sdk/widget/media/MiniAppVideoPlayer:getAndSelectVideoTrackIndex	(Landroid/media/MediaExtractor;)I
    //   63: istore_2
    //   64: iload_2
    //   65: iconst_m1
    //   66: if_icmple +53 -> 119
    //   69: aload 5
    //   71: iload_2
    //   72: invokevirtual 747	android/media/MediaExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   75: astore_1
    //   76: aload_1
    //   77: ldc_w 1178
    //   80: invokevirtual 1181	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   83: ifeq +14 -> 97
    //   86: aload_0
    //   87: aload_1
    //   88: ldc_w 1178
    //   91: invokevirtual 1185	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   94: putfield 1121	com/tencent/qqmini/sdk/widget/media/MiniAppVideoPlayer:rotation	I
    //   97: aload_0
    //   98: aload_1
    //   99: ldc_w 1187
    //   102: invokevirtual 1185	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   105: putfield 1117	com/tencent/qqmini/sdk/widget/media/MiniAppVideoPlayer:originWidth	I
    //   108: aload_0
    //   109: aload_1
    //   110: ldc_w 1189
    //   113: invokevirtual 1185	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   116: putfield 1119	com/tencent/qqmini/sdk/widget/media/MiniAppVideoPlayer:originHeight	I
    //   119: aload_3
    //   120: ifnull +7 -> 127
    //   123: aload_3
    //   124: invokevirtual 1192	java/io/FileInputStream:close	()V
    //   127: aload 5
    //   129: ifnull +8 -> 137
    //   132: aload 5
    //   134: invokevirtual 1195	android/media/MediaExtractor:release	()V
    //   137: return
    //   138: astore 4
    //   140: aconst_null
    //   141: astore_3
    //   142: aload 6
    //   144: astore_1
    //   145: ldc 25
    //   147: ldc_w 1197
    //   150: aload 4
    //   152: invokestatic 1203	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   155: pop
    //   156: aload_3
    //   157: ifnull +7 -> 164
    //   160: aload_3
    //   161: invokevirtual 1192	java/io/FileInputStream:close	()V
    //   164: aload_1
    //   165: ifnull -28 -> 137
    //   168: aload_1
    //   169: invokevirtual 1195	android/media/MediaExtractor:release	()V
    //   172: return
    //   173: astore_1
    //   174: aconst_null
    //   175: astore 4
    //   177: aconst_null
    //   178: astore_3
    //   179: aload 4
    //   181: ifnull +8 -> 189
    //   184: aload 4
    //   186: invokevirtual 1192	java/io/FileInputStream:close	()V
    //   189: aload_3
    //   190: ifnull +7 -> 197
    //   193: aload_3
    //   194: invokevirtual 1195	android/media/MediaExtractor:release	()V
    //   197: aload_1
    //   198: athrow
    //   199: astore_1
    //   200: goto -73 -> 127
    //   203: astore_3
    //   204: goto -40 -> 164
    //   207: astore 4
    //   209: goto -20 -> 189
    //   212: astore_1
    //   213: aconst_null
    //   214: astore 5
    //   216: aload_3
    //   217: astore 4
    //   219: aload 5
    //   221: astore_3
    //   222: goto -43 -> 179
    //   225: astore_1
    //   226: aload_3
    //   227: astore 4
    //   229: aload 5
    //   231: astore_3
    //   232: goto -53 -> 179
    //   235: astore 4
    //   237: aload_1
    //   238: astore 5
    //   240: aload 4
    //   242: astore_1
    //   243: aload_3
    //   244: astore 4
    //   246: aload 5
    //   248: astore_3
    //   249: goto -70 -> 179
    //   252: astore 4
    //   254: aload 6
    //   256: astore_1
    //   257: goto -112 -> 145
    //   260: astore 4
    //   262: aload 5
    //   264: astore_1
    //   265: goto -120 -> 145
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	268	0	this	MiniAppVideoPlayer
    //   0	268	1	paramString	String
    //   63	9	2	i	int
    //   39	155	3	localFileInputStream	java.io.FileInputStream
    //   203	14	3	localIOException1	java.io.IOException
    //   221	28	3	localObject1	Object
    //   138	13	4	localThrowable1	Throwable
    //   175	10	4	localObject2	Object
    //   207	1	4	localIOException2	java.io.IOException
    //   217	11	4	localObject3	Object
    //   235	6	4	localObject4	Object
    //   244	1	4	localObject5	Object
    //   252	1	4	localThrowable2	Throwable
    //   260	1	4	localThrowable3	Throwable
    //   47	216	5	localObject6	Object
    //   1	254	6	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   28	40	138	java/lang/Throwable
    //   28	40	173	finally
    //   123	127	199	java/io/IOException
    //   160	164	203	java/io/IOException
    //   184	189	207	java/io/IOException
    //   40	49	212	finally
    //   49	64	225	finally
    //   69	97	225	finally
    //   97	119	225	finally
    //   145	156	235	finally
    //   40	49	252	java/lang/Throwable
    //   49	64	260	java/lang/Throwable
    //   69	97	260	java/lang/Throwable
    //   97	119	260	java/lang/Throwable
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
    if (paramString.startsWith("wxfile"))
    {
      if (this.mMiniAppContext != null) {}
      for (IMiniAppContext localIMiniAppContext = (IMiniAppContext)this.mMiniAppContext.get(); localIMiniAppContext != null; localIMiniAppContext = null) {
        return ((MiniAppFileManager)localIMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath(paramString);
      }
      return null;
    }
    if ((paramString.startsWith("http")) || (paramString.startsWith("https"))) {
      return paramString;
    }
    return null;
  }
  
  private void pause()
  {
    QMLog.d("MiniAppVideoPlayer", "pause");
    if (this.mVideoPlayer == null) {}
    do
    {
      return;
      this.playingBefore = false;
    } while (!this.mVideoPlayer.isPlaying());
    cancelAvoidLockScreen();
    this.mVideoPlayer.pause();
    this.isPause = true;
    if (this.mMiniAppContext != null) {}
    for (IMiniAppContext localIMiniAppContext = (IMiniAppContext)this.mMiniAppContext.get(); (localIMiniAppContext != null) && (localIMiniAppContext.isMiniGame()); localIMiniAppContext = null)
    {
      callbackVideoStateChange("pause");
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("videoId", this.videoId);
      localJSONObject.put("data", this.data);
      if (localIMiniAppContext != null) {
        localIMiniAppContext.performAction(ServiceSubscribeEvent.obtain("onVideoPause", localJSONObject.toString(), this.webviewId));
      }
      this.pageWebview.evaluateSubscribeJS("onVideoPause", localJSONObject.toString(), this.webviewId);
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  private void resetBarrageDrawable()
  {
    ImageView localImageView = this.barrageIv;
    if (this.isBarrageOpen) {}
    for (int i = R.drawable.mini_sdk_player_barrage_open;; i = R.drawable.mini_sdk_player_barrage_close)
    {
      localImageView.setImageResource(i);
      return;
    }
  }
  
  private void resetControlIvDrawable(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.controlIv.setImageResource(R.drawable.mini_sdk_player_pause);
      this.centerControlIv.setImageResource(R.drawable.mini_sdk_player_pause);
      return;
    }
    this.controlIv.setImageResource(R.drawable.mini_sdk_player_resume);
    this.centerControlIv.setImageResource(R.drawable.mini_sdk_player_resume);
  }
  
  private void resetMuteImage()
  {
    if (!this.showMuteBtn) {
      this.muteIv.setVisibility(8);
    }
    while (this.mVideoPlayer == null) {
      return;
    }
    ImageView localImageView = this.muteIv;
    if (this.mVideoPlayer.getOutputMute()) {}
    for (int i = R.drawable.mini_sdk_video_mute;; i = R.drawable.mini_sdk_video_unmute)
    {
      localImageView.setImageResource(i);
      this.muteIv.setVisibility(0);
      return;
    }
  }
  
  private void resetOrientationForSmallScreen(Activity paramActivity, IMiniAppContext paramIMiniAppContext)
  {
    paramIMiniAppContext = GetPageStringAction.obtain(paramIMiniAppContext).getPageOrientation();
    int i = 1;
    if (WindowInfo.ORIENTATION_AUTO.equals(paramIMiniAppContext)) {
      i = 4;
    }
    for (;;)
    {
      paramActivity.setRequestedOrientation(i);
      return;
      if (WindowInfo.ORIENTATION_LANDSCAPE.equals(paramIMiniAppContext)) {
        i = 0;
      }
    }
  }
  
  private void resetPlayingTime()
  {
    if (this.mVideoPlayer == null) {
      return;
    }
    this.nowTimeTv.setText(parseTimeString(this.mVideoPlayer.getCurrentPostion()));
  }
  
  private void resetStatusbarForSmallScreen(Activity paramActivity, IMiniAppContext paramIMiniAppContext)
  {
    if (!paramIMiniAppContext.isMiniGame())
    {
      if (Build.VERSION.SDK_INT >= 16) {
        paramActivity.getWindow().getDecorView().setSystemUiVisibility(1024);
      }
      try
      {
        int i = GetPageIntAction.obtain(paramIMiniAppContext).getNaviBarTextStyle();
        if (i == -1)
        {
          ImmersiveUtils.setStatusTextColor(false, paramActivity.getWindow());
          return;
        }
        if (i == -16777216)
        {
          ImmersiveUtils.setStatusTextColor(true, paramActivity.getWindow());
          return;
        }
      }
      catch (Exception paramActivity)
      {
        QMLog.e("MiniAppVideoPlayer", "smallScreen: ", paramActivity);
      }
    }
  }
  
  private void resetWindowIvDrawable()
  {
    ImageView localImageView = this.windowIv;
    if (this.isFullScreen) {}
    for (int i = R.drawable.mini_sdk_player_shrink_back;; i = R.drawable.mini_sdk_player_stretch_back)
    {
      localImageView.setImageResource(i);
      return;
    }
  }
  
  private void sendTimingMsg(long paramLong)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 2002;
    this.handler.sendMessageDelayed(localMessage, paramLong);
  }
  
  private void setOrientationForFullScreen(Activity paramActivity, boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      if ((this.direction == -90) || (this.direction == 270)) {
        i = 8;
      }
    }
    for (;;)
    {
      paramActivity.setRequestedOrientation(i);
      return;
      i = 0;
      continue;
      if ((this.direction == 180) || (this.direction == -180)) {
        i = 9;
      } else {
        i = 1;
      }
    }
  }
  
  private void setPoster()
  {
    Drawable localDrawable = ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getDrawable(this.mContext, this.poster, 0, 0, null);
    if ((localDrawable != null) && (this.video_img != null))
    {
      this.video_img.setVisibility(0);
      this.video_img.setImageDrawable(localDrawable);
      this.video_img.setScaleType(ImageView.ScaleType.FIT_XY);
    }
  }
  
  private void setProgressByPlayingTime()
  {
    if (this.mVideoPlayer == null) {
      return;
    }
    long l2 = this.mVideoPlayer.getDuration();
    long l1 = l2;
    if (l2 == 0L) {
      l1 = 1L;
    }
    this.playerSeekBar.setProgress((int)(this.mVideoPlayer.getCurrentPostion() * this.playerSeekBar.getMax() / l1));
  }
  
  private void setUpView(Context paramContext)
  {
    if (this.hasSetUp) {
      return;
    }
    this.hasSetUp = true;
    setTag("MiniAppVideoPlayer");
    this.mContext = paramContext;
    this.view = LayoutInflater.from(paramContext).inflate(R.layout.mini_sdk_player_view, null);
    this.video_container = ((VideoGestureRelativeLayout)this.view.findViewById(R.id.layout_videolayout));
    this.video_container.setContentDescription("video_container");
    this.video_pop_container = ((FrameLayout)this.view.findViewById(R.id.video_pop_container));
    this.video_img = ((ImageView)this.view.findViewById(R.id.video_img));
    this.play_status_img = ((ImageView)this.view.findViewById(R.id.play_status_img));
    this.play_status_img.setOnClickListener(this);
    this.playingPopView = this.view.findViewById(R.id.video_playing_pop_container);
    this.nowTimeTv = ((TextView)this.view.findViewById(R.id.video_playing_tv_time_now));
    this.totalTimeTv = ((TextView)this.view.findViewById(R.id.video_playing_tv_time_total));
    this.controlIv = ((ImageView)this.view.findViewById(R.id.video_playing_iv_control));
    this.centerControlIv = ((ImageView)this.view.findViewById(R.id.video_playing_iv_control_center));
    this.controlBar = this.view.findViewById(R.id.video_playing_control_bar);
    this.windowIv = ((ImageView)this.view.findViewById(R.id.video_playing_iv_window));
    this.playerSeekBar = ((SeekBar)this.view.findViewById(R.id.video_playing_bar));
    this.loadingView = this.view.findViewById(R.id.video_loading_container);
    this.barrageIv = ((ImageView)this.view.findViewById(R.id.video_playing_iv_barrage));
    this.seekTv = ((TextView)this.view.findViewById(R.id.video_playing_tv_seek));
    this.backIv = ((ImageView)this.view.findViewById(R.id.video_playing_iv_back_fullscreen));
    this.titleTv = ((TextView)this.view.findViewById(R.id.video_playing_tv_title));
    this.muteIv = ((ImageView)this.view.findViewById(R.id.video_playing_iv_mute));
    this.actionVg = ((FrameLayout)this.view.findViewById(R.id.video_action_container));
    paramContext = this.barrageIv;
    if (this.showDanmuBtn) {}
    for (int i = 0;; i = 4)
    {
      paramContext.setVisibility(i);
      if (Build.VERSION.SDK_INT > 15) {
        this.playerSeekBar.getThumb().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
      }
      this.controlIv.setOnClickListener(this);
      this.centerControlIv.setOnClickListener(this);
      this.windowIv.setOnClickListener(this);
      this.barrageIv.setOnClickListener(this);
      this.backIv.setOnClickListener(this);
      this.muteIv.setOnClickListener(this);
      this.videoPlayerStatusObserver = new MiniAppVideoPlayer.VideoPlayerStatusObserver(this);
      this.mVideoGestureLayout = new VideoGestureLayout(this.mContext);
      this.mVideoGestureLayout.setContentDescription("VideoGestureLayout");
      this.video_container.setVideoGestureListener(getVideoGestureListener());
      this.playerSeekBar.setOnSeekBarChangeListener(getSeekBarChangeListener());
      addView(this.view);
      return;
    }
  }
  
  private void showPopCtrView()
  {
    showPopCtrViewWithoutHideAfter();
    Message localMessage = Message.obtain();
    localMessage.what = 2003;
    this.handler.sendMessageDelayed(localMessage, 5000L);
  }
  
  private void showPopCtrViewWithoutHideAfter()
  {
    int i = 0;
    if (this.isShowBasicControl)
    {
      this.playingPopView.setVisibility(0);
      View localView = this.controlBar;
      if (this.isShowControlBar) {
        localView.setVisibility(i);
      }
    }
    for (;;)
    {
      this.handler.removeMessages(2003);
      return;
      i = 8;
      break;
      this.playingPopView.setVisibility(4);
    }
  }
  
  private void start()
  {
    QMLog.d("MiniAppVideoPlayer", "start");
    avoidLockScreen();
    if ((this.mVideoPlayer != null) && (this.mVideoPlayer.getCurrentPostion() > 0L)) {
      this.mVideoPlayer.start();
    }
    for (;;)
    {
      this.isPause = false;
      return;
      play((this.initialTime * 1000.0D));
    }
  }
  
  private void switchScreenSize()
  {
    if (this.isFullScreen)
    {
      smallScreen();
      return;
    }
    fullScreen();
  }
  
  private void updateBufferProgress(boolean paramBoolean)
  {
    MiniAppVideoPlayer.16 local16 = new MiniAppVideoPlayer.16(this);
    if (!paramBoolean) {
      local16.run();
    }
    while ((!this.isBufferStart) && (this.lastBufferProgress == 0)) {
      return;
    }
    this.handler.postDelayed(local16, 20L);
  }
  
  private void updateCenterBtn()
  {
    if (this.showCenterPlayBtn)
    {
      this.play_status_img.setVisibility(0);
      return;
    }
    this.play_status_img.setVisibility(8);
  }
  
  private void updateDanmuView()
  {
    if (this.danmuView != null)
    {
      if (this.isBarrageOpen)
      {
        this.danmuView.setVisibility(4);
        this.isBarrageOpen = false;
      }
    }
    else {
      return;
    }
    this.danmuView.setVisibility(0);
    this.isBarrageOpen = true;
  }
  
  private void updateMute()
  {
    if (this.mVideoPlayer != null)
    {
      this.mCurrPos = this.mVideoPlayer.getCurrentPostion();
      if (this.mVideoPlayer.getOutputMute() != this.muted)
      {
        Log.i("MiniAppVideoPlayer", "initSetting: set mute " + this.muted);
        this.mVideoPlayer.setOutputMute(this.muted);
      }
    }
  }
  
  private void updateObjFit()
  {
    if (this.mVideoPlayer != null)
    {
      if (!"contain".equals(this.objectFit)) {
        break label28;
      }
      this.mVideoPlayer.setXYaxis(0);
    }
    label28:
    while (!"fill".equals(this.objectFit)) {
      return;
    }
    this.mVideoPlayer.setXYaxis(1);
  }
  
  private void updatePopCtrView()
  {
    if (this.mVideoPlayer.isPlaying())
    {
      showPopCtrView();
      return;
    }
    showPopCtrViewWithoutHideAfter();
  }
  
  private void updatePoster()
  {
    if ((this.poster != null) && (!this.poster.equals(this.lastPoster))) {
      setPoster();
    }
    this.lastPoster = this.poster;
  }
  
  private void updateVideoControllerView()
  {
    int j = 0;
    ImageView localImageView;
    int i;
    if (this.barrageIv != null)
    {
      localImageView = this.barrageIv;
      if (this.showDanmuBtn)
      {
        i = 0;
        localImageView.setVisibility(i);
      }
    }
    else
    {
      if (!"center".equals(this.playBtnPosition)) {
        break label102;
      }
      localImageView = this.centerControlIv;
      if (!this.showCenterPlayBtn) {
        break label96;
      }
      i = j;
      label55:
      localImageView.setVisibility(i);
      this.controlIv.setVisibility(8);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.title)) {
        this.titleTv.setText(this.title);
      }
      return;
      i = 4;
      break;
      label96:
      i = 8;
      break label55;
      label102:
      this.centerControlIv.setVisibility(8);
      this.controlIv.setVisibility(0);
    }
  }
  
  private void updateVideoPosition()
  {
    if (!this.isFullScreen)
    {
      if ((this.mMiniAppContext != null) && (this.mMiniAppContext.get() != null) && (((IMiniAppContext)this.mMiniAppContext.get()).isMiniGame()))
      {
        localObject = new RelativeLayout.LayoutParams(DisplayUtil.dip2px(this.mContext, this.videoWidth), DisplayUtil.dip2px(this.mContext, this.videoHeight));
        ((RelativeLayout.LayoutParams)localObject).leftMargin = DisplayUtil.dip2px(this.mContext, this.videoX);
        ((RelativeLayout.LayoutParams)localObject).topMargin = DisplayUtil.dip2px(this.mContext, this.videoY);
        ((CoverVideoView)getParent()).setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
    else {
      return;
    }
    Object localObject = new FrameLayout.LayoutParams(DisplayUtil.dip2px(this.mContext, this.videoWidth), DisplayUtil.dip2px(this.mContext, this.videoHeight));
    ((FrameLayout.LayoutParams)localObject).leftMargin = DisplayUtil.dip2px(this.mContext, this.videoX);
    ((FrameLayout.LayoutParams)localObject).topMargin = DisplayUtil.dip2px(this.mContext, this.videoY);
    ((CoverVideoView)getParent()).setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private void updateVideoViewPosition(IMiniAppContext paramIMiniAppContext, boolean paramBoolean)
  {
    if (this.atyRef.get() != null) {
      LiuHaiUtils.initLiuHaiProperty((Activity)this.atyRef.get());
    }
    for (int i = LiuHaiUtils.getNotchInScreenHeight((Activity)this.atyRef.get());; i = 0)
    {
      int j = DisplayUtil.getRealHeight(getContext());
      if ((!paramBoolean) && (LiuHaiUtils.sHasNotch)) {}
      for (i = j - i;; i = j)
      {
        j = DisplayUtil.getScreenWidth(getContext());
        if (paramBoolean) {}
        for (int k = i;; k = j)
        {
          if (paramBoolean) {
            i = j;
          }
          if ((paramIMiniAppContext == null) || (!paramIMiniAppContext.isMiniGame())) {
            break;
          }
          paramIMiniAppContext = new RelativeLayout.LayoutParams(k, i);
          paramIMiniAppContext.leftMargin = 0;
          paramIMiniAppContext.topMargin = 0;
          ((CoverVideoView)getParent()).setLayoutParams(paramIMiniAppContext);
          return;
        }
        paramIMiniAppContext = new FrameLayout.LayoutParams(k, i);
        paramIMiniAppContext.leftMargin = 0;
        paramIMiniAppContext.topMargin = 0;
        ((CoverVideoView)getParent()).setLayoutParams(paramIMiniAppContext);
        return;
      }
    }
  }
  
  public void captureImage(AbsVideoPlayer.OnCaptureImageListener paramOnCaptureImageListener)
  {
    int i = 0;
    if (paramOnCaptureImageListener == null)
    {
      QMLog.e("MiniAppVideoPlayer", "captureImage onCaptureImageListener is null");
      return;
    }
    if (this.mVideoPlayer == null)
    {
      QMLog.e("MiniAppVideoPlayer", "captureImage video player is null");
      paramOnCaptureImageListener.onCaptureImageFailed(null);
      return;
    }
    try
    {
      if (this.mVideoPlayer.isPlaying()) {
        break label127;
      }
      if ((this.cachedCaptureImage != null) && (!this.cachedCaptureImage.isRecycled()))
      {
        paramOnCaptureImageListener.onCaptureImageSucceed(this.mVideoPlayer, this.cachedCaptureImage);
        return;
      }
    }
    catch (Exception localException)
    {
      QMLog.e("MiniAppVideoPlayer", "captureImage video player fail!,e" + localException);
      paramOnCaptureImageListener.onCaptureImageFailed(null);
      return;
    }
    paramOnCaptureImageListener.onCaptureImageFailed(this.mVideoPlayer);
    return;
    label127:
    int j;
    if (this.view != null)
    {
      j = this.view.getWidth();
      i = this.view.getHeight();
    }
    for (;;)
    {
      this.mVideoPlayer.setOnCaptureImageListener(getCaptureImageListener(paramOnCaptureImageListener));
      this.mVideoPlayer.captureImageInTime(j, i);
      return;
      j = 0;
    }
  }
  
  public void changeState()
  {
    ThreadManager.getUIHandler().post(new MiniAppVideoPlayer.4(this));
  }
  
  public void fullScreen()
  {
    this.handler.post(new MiniAppVideoPlayer.14(this));
  }
  
  public long getCurrentPos()
  {
    if (this.mVideoPlayer == null) {
      return 0L;
    }
    return this.mVideoPlayer.getCurrentPostion();
  }
  
  public long getDuration()
  {
    if (this.mVideoPlayer == null) {
      return 0L;
    }
    return this.mVideoPlayer.getDuration();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 2002: 
      long l = System.currentTimeMillis();
      if ((this.mVideoPlayer != null) && (this.mVideoPlayer.isPlaying()))
      {
        resetPlayingTime();
        if (this.danmuView != null) {
          this.danmuView.updateTime(this.mVideoPlayer.getCurrentPostion());
        }
        if (!this.isChangingProgress) {
          setProgressByPlayingTime();
        }
        if (this.pageWebview.getClass().getName().equals("com.tencent.qqmini.minigame.GameJsService")) {
          callbackVideoStateChange("timeUpdate");
        }
      }
      else
      {
        if (!this.isPause) {
          sendTimingMsg(l + 200L - System.currentTimeMillis());
        }
        return true;
      }
      for (;;)
      {
        try
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("data", this.data);
          localJSONObject.put("position", this.mVideoPlayer.getCurrentPostion() / 1000.0D);
          localJSONObject.put("duration", this.mVideoPlayer.getDuration() / 1000.0D);
          localJSONObject.put("videoId", this.videoId);
          if (this.mMiniAppContext == null) {
            break label316;
          }
          paramMessage = (IMiniAppContext)this.mMiniAppContext.get();
          if (paramMessage != null) {
            paramMessage.performAction(ServiceSubscribeEvent.obtain("onVideoTimeUpdate", localJSONObject.toString(), this.webviewId));
          }
          this.pageWebview.evaluateSubscribeJS("onVideoTimeUpdate", localJSONObject.toString(), this.webviewId);
          QMLog.d("MiniAppVideoPlayer", "evaluateSubcribeJS onVideoTimeUpdate = " + localJSONObject.toString());
        }
        catch (JSONException paramMessage)
        {
          paramMessage.printStackTrace();
        }
        break;
        label316:
        paramMessage = null;
      }
    }
    this.playingPopView.setVisibility(4);
    return true;
  }
  
  public void initSetting(JSONObject paramJSONObject)
  {
    QMLog.i("MiniAppVideoPlayer", "initSetting: " + paramJSONObject.toString());
    this.needEvent = paramJSONObject.optBoolean("needEvent", this.needEvent);
    this.hide = paramJSONObject.optBoolean("hide", this.hide);
    this.enableDanmu = paramJSONObject.optBoolean("enableDanmu", this.enableDanmu);
    this.showDanmuBtn = paramJSONObject.optBoolean("showDanmuBtn", this.showDanmuBtn);
    this.loop = paramJSONObject.optBoolean("loop", this.loop);
    this.enablePlayGesture = paramJSONObject.optBoolean("enablePlayGesture", this.enablePlayGesture);
    this.direction = paramJSONObject.optInt("direction", this.direction);
    this.isShowBasicControl = paramJSONObject.optBoolean("showBasicControls", this.isShowBasicControl);
    this.isShowControlBar = paramJSONObject.optBoolean("controls", this.isShowControlBar);
    this.playBtnPosition = paramJSONObject.optString("playBtnPosition", this.playBtnPosition);
    this.showProgress = paramJSONObject.optBoolean("showProgress", this.showProgress);
    this.showMuteBtn = paramJSONObject.optBoolean("showMuteBtn", this.showMuteBtn);
    this.title = paramJSONObject.optString("title", this.title);
    this.autoPauseIfNavigate = paramJSONObject.optBoolean("autoPauseIfNavigate", this.autoPauseIfNavigate);
    this.autoPauseIfOpenNative = paramJSONObject.optBoolean("autoPauseIfOpenNative", this.autoPauseIfOpenNative);
    this.muted = paramJSONObject.optBoolean("muted", this.muted);
    this.showCenterPlayBtn = paramJSONObject.optBoolean("showCenterPlayBtn", this.showCenterPlayBtn);
    this.objectFit = paramJSONObject.optString("objectFit", this.objectFit);
    this.autoplay = paramJSONObject.optBoolean("autoplay", this.autoplay);
    this.barrages = parseDanmuList((JSONArray)paramJSONObject.opt("danmuList"));
    this.isLive = paramJSONObject.optBoolean("isLive", this.isLive);
    this.isMuted = paramJSONObject.optBoolean("isMuted", this.isMuted);
    this.pageGesture = paramJSONObject.optBoolean("pageGesture", this.pageGesture);
    this.initialTime = paramJSONObject.optDouble("initialTime", this.initialTime);
    this.parentId = paramJSONObject.optInt("parentId", this.parentId);
    this.customCache = paramJSONObject.optBoolean("customCache", this.customCache);
    this.showProgress = paramJSONObject.optBoolean("showProgress", this.showProgress);
    this.showControlProgress = paramJSONObject.optBoolean("showControlProgress", this.showControlProgress);
    this.showLiveBtn = paramJSONObject.optBoolean("showLiveBtn", this.showLiveBtn);
    this.showPlayBtn = paramJSONObject.optBoolean("showPlayBtn", this.showPlayBtn);
    this.showFullScreenBtn = paramJSONObject.optBoolean("showFullScreenBtn", this.showFullScreenBtn);
    this.enableProgressGesture = paramJSONObject.optBoolean("enableProgressGesture", this.enableProgressGesture);
    JSONObject localJSONObject;
    if (!this.isFullScreen)
    {
      localJSONObject = paramJSONObject.optJSONObject("position");
      if (localJSONObject == null) {
        break label626;
      }
      this.videoX = localJSONObject.optInt("left", this.videoX);
      this.videoY = localJSONObject.optInt("top", this.videoY);
      this.videoWidth = localJSONObject.optInt("width", this.videoWidth);
    }
    for (this.videoHeight = localJSONObject.optInt("height", this.videoHeight);; this.videoHeight = paramJSONObject.optInt("height", this.videoHeight))
    {
      this.poster = paramJSONObject.optString("poster", this.poster);
      updateObjFit();
      updateMute();
      updateVideoControllerView();
      resetMuteImage();
      updateVideoPosition();
      return;
      label626:
      this.videoX = paramJSONObject.optInt("x", this.videoX);
      this.videoY = paramJSONObject.optInt("y", this.videoY);
      this.videoWidth = paramJSONObject.optInt("width", this.videoWidth);
    }
  }
  
  public void initVideoPlayerSettings(JSONObject paramJSONObject)
  {
    QMLog.d("MiniAppVideoPlayer", "initLivePlayerSettings isFullScreen: " + this.isFullScreen);
    initSetting(paramJSONObject);
    initPlayer();
    updatePoster();
  }
  
  public boolean isFullScreen()
  {
    return this.isFullScreen;
  }
  
  boolean isFullScreenSize(int paramInt1, int paramInt2)
  {
    return (paramInt1 == DisplayUtil.getRealHeight(getContext())) && (paramInt2 == DisplayUtil.getScreenWidth(getContext()));
  }
  
  public boolean isPlaying()
  {
    return (this.mVideoPlayer != null) && (this.mVideoPlayer.isPlaying());
  }
  
  public boolean isWifiConnect()
  {
    return ((ConnectivityManager)this.mContext.getSystemService("connectivity")).getNetworkInfo(1).isConnected();
  }
  
  public void onClick(View paramView)
  {
    if (this.mVideoPlayer == null) {}
    do
    {
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (paramView.getId() == R.id.play_status_img)
        {
          handlePlayBtnClick();
        }
        else if ((paramView.getId() == this.controlIv.getId()) || (paramView.getId() == this.centerControlIv.getId()))
        {
          operate();
          updatePopCtrView();
          resetControlIvDrawable(this.mVideoPlayer.isPlaying());
        }
        else if ((paramView.getId() == this.windowIv.getId()) || (paramView.getId() == this.backIv.getId()))
        {
          showPopCtrView();
          switchScreenSize();
          resetWindowIvDrawable();
        }
        else
        {
          if (paramView.getId() != this.barrageIv.getId()) {
            break;
          }
          showPopCtrView();
          updateDanmuView();
          resetBarrageDrawable();
        }
      }
    } while (paramView.getId() != this.muteIv.getId());
    AbsVideoPlayer localAbsVideoPlayer = this.mVideoPlayer;
    if (!this.mVideoPlayer.getOutputMute()) {}
    for (boolean bool = true;; bool = false)
    {
      localAbsVideoPlayer.setOutputMute(bool);
      resetMuteImage();
      break;
    }
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    paramMediaPlayer.start();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.isFullScreen) {
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void operate()
  {
    QMLog.d("MiniAppVideoPlayer", "operate");
    if (this.mVideoPlayer == null) {
      return;
    }
    if (this.mVideoPlayer.isPlaying())
    {
      this.pauseByUser = true;
      pause();
      return;
    }
    this.pauseByUser = false;
    start();
    IMiniAppContext localIMiniAppContext;
    if (this.mMiniAppContext != null)
    {
      localIMiniAppContext = (IMiniAppContext)this.mMiniAppContext.get();
      if ((localIMiniAppContext == null) || (!localIMiniAppContext.isMiniGame())) {
        break label95;
      }
      callbackVideoStateChange("play");
    }
    for (;;)
    {
      sendTimingMsg(200L);
      return;
      localIMiniAppContext = null;
      break;
      try
      {
        label95:
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("videoId", this.videoId);
        localJSONObject.put("data", this.data);
        if (localIMiniAppContext != null) {
          localIMiniAppContext.performAction(ServiceSubscribeEvent.obtain("onVideoPlay", localJSONObject.toString(), this.webviewId));
        }
        this.pageWebview.evaluateSubscribeJS("onVideoPlay", localJSONObject.toString(), this.webviewId);
        QMLog.d("MiniAppVideoPlayer", "operate start evaluateSubcribeJS onVideoPlay = " + localJSONObject.toString());
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public void play()
  {
    play(getCurrentPos());
  }
  
  public void play(long paramLong)
  {
    if (this.mVideoPlayer == null) {}
    do
    {
      return;
      Log.i("MiniAppVideoPlayer", "play: " + paramLong + " /" + this.mVideoPlayer.getDuration(), new Throwable());
    } while (StringUtil.isEmpty(this.mUrls));
    this.isBufferStart = true;
    updateBufferProgress(false);
    avoidLockScreen();
    this.loadingView.setVisibility(0);
    this.playingBefore = true;
    this.mVideoPlayer.stop();
    if (this.enableDanmu) {
      this.mVideoPlayer.startPlayDanmu();
    }
    this.mVideoPlayer.openMediaPlayerByUrl(getContext(), this.mUrls, paramLong);
    this.play_status_img.setVisibility(8);
    if (this.mMiniAppContext != null) {}
    for (IMiniAppContext localIMiniAppContext = (IMiniAppContext)this.mMiniAppContext.get(); (localIMiniAppContext != null) && (localIMiniAppContext.isMiniGame()); localIMiniAppContext = null)
    {
      callbackVideoStateChange("play");
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("data", this.data);
      if (localIMiniAppContext != null) {
        localIMiniAppContext.performAction(ServiceSubscribeEvent.obtain("onVideoPlay", localJSONObject.toString(), this.webviewId));
      }
      this.pageWebview.evaluateSubscribeJS("onVideoPlay", localJSONObject.toString(), this.webviewId);
      QMLog.d("MiniAppVideoPlayer", "evaluateSubcribeJS onVideoPlay = " + localJSONObject.toString());
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  public void playDanmu(String paramString, int paramInt)
  {
    if ((this.mVideoPlayer != null) && (this.danmuView != null)) {
      this.danmuView.showBarrageNextTime(new Barrage(paramString, paramInt, 0L));
    }
  }
  
  public void playRate() {}
  
  public void release()
  {
    if (this.danmuView != null) {
      this.danmuView.destroy();
    }
    if (this.mVideoPlayer != null) {
      this.mVideoPlayer.release();
    }
    this.hasSetUp = false;
    ThreadManager.getUIHandler().post(new MiniAppVideoPlayer.13(this));
    ScreenOffOnListener.getInstance().unRegistListener();
    this.handler.removeMessages(2002);
  }
  
  public boolean seekTo(int paramInt)
  {
    if (this.mVideoPlayer == null) {
      return false;
    }
    if (paramInt < 0)
    {
      this.mVideoPlayer.seekTo(0);
      return true;
    }
    long l = this.mVideoPlayer.getDuration();
    if ((l > 0L) && (paramInt > l))
    {
      this.mVideoPlayer.seekTo((int)l);
      return true;
    }
    this.initialTime = (paramInt / 1000.0D);
    if (l > 0L) {
      this.mVideoPlayer.seekTo(paramInt);
    }
    return true;
  }
  
  public void setAtyRef(WeakReference<Activity> paramWeakReference)
  {
    this.atyRef = paramWeakReference;
    if (paramWeakReference != null)
    {
      paramWeakReference = (Activity)paramWeakReference.get();
      this.mAudioManager = ((AudioManager)paramWeakReference.getSystemService("audio"));
      if (this.mAudioManager != null) {
        this.maxVolume = this.mAudioManager.getStreamMaxVolume(3);
      }
      this.mWindow = paramWeakReference.getWindow();
      if (this.mWindow != null)
      {
        this.mLayoutParams = this.mWindow.getAttributes();
        if (this.mLayoutParams != null) {
          this.brightness = this.mLayoutParams.screenBrightness;
        }
      }
    }
  }
  
  public void setVideoPath(String paramString)
  {
    Log.i("MiniAppVideoPlayer", "setVideoPath: " + paramString);
    stop(false);
    updateCenterBtn();
    this.playingPopView.setVisibility(8);
    this.handler.removeMessages(2002);
    this.mUrls = parseUrl(paramString);
    if ((this.isResetPath) || (this.autoplay)) {
      this.handler.postDelayed(new MiniAppVideoPlayer.1(this), 100L);
    }
    this.isResetPath = true;
    this.rotation = 0;
    parseOriVideoSize(paramString);
  }
  
  public void smallScreen()
  {
    this.handler.post(new MiniAppVideoPlayer.15(this));
  }
  
  public void stop()
  {
    stop(true);
  }
  
  public void stop(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.isFullScreen)) {
      smallScreen();
    }
    if (this.mVideoPlayer != null) {
      this.mVideoPlayer.stop();
    }
    ThreadManager.getUIHandler().post(new MiniAppVideoPlayer.12(this));
  }
  
  public void updateVideoPlayerSetting(JSONObject paramJSONObject)
  {
    QMLog.d("MiniAppVideoPlayer", "updateLivePlayerSetting isFullScreen: " + this.isFullScreen);
    initSetting(paramJSONObject);
    updatePoster();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.media.MiniAppVideoPlayer
 * JD-Core Version:    0.7.0.1
 */