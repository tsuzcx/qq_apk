package com.tencent.mobileqq.mini.widget.media;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings.System;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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
import android.webkit.URLUtil;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mobileqq.mini.utils.ScreenOffOnListener;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.mini.widget.media.danmu.Barrage;
import com.tencent.mobileqq.mini.widget.media.danmu.BarrageView;
import com.tencent.mobileqq.minigame.jsapi.GameJsRuntime;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.oskplayer.OskPlayerConfig;
import com.tencent.oskplayer.OskPlayerCore;
import com.tencent.oskplayer.PlayerConfig;
import com.tencent.oskplayer.cache.DefaultCacheKeyGenerator;
import com.tencent.oskplayer.util.DefaultLogger;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCaptureImageListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
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
  public static volatile boolean mIsInited;
  private static final String oskPlayerContentTypeList = QzoneConfig.getInstance().getConfig("QZoneSetting", "MiniProgramVideoContentType", "application/octet-stream; charset=utf-8");
  private ViewGroup actionVg;
  public WeakReference<Activity> atyRef;
  public boolean autoPauseIfNavigate = true;
  public boolean autoPauseIfOpenNative = true;
  public boolean autoplay;
  private ImageView backIv;
  private ImageView barrageIv;
  public List<Barrage> barrages;
  private float brightness = 1.0F;
  private Bitmap cachedCaptureImage;
  private ImageView centerControlIv;
  private int componentLayoutScrollY;
  private View controlBar;
  private ImageView controlIv;
  public boolean customCache;
  private BarrageView danmuView;
  public String data;
  public int direction = -1;
  public boolean enableDanmu;
  public boolean enablePlayGesture;
  public boolean enableProgressGesture = true;
  private final Handler handler = new Handler(Looper.getMainLooper(), this);
  private boolean hasSetUp;
  private boolean hasShowDanmuBtnSet;
  public boolean hide;
  public boolean hideTimeDesc;
  public double initialTime;
  public boolean isBarrageOpen;
  private boolean isBufferStart;
  boolean isBusyInChangeScreen = false;
  private boolean isChangingProgress;
  public boolean isFullScreen;
  public boolean isLive;
  public boolean isMuted;
  public boolean isPageOnBackground;
  private boolean isPause;
  boolean isResetPath = false;
  public boolean isShowBasicControl = true;
  public boolean isShowControlBar = true;
  private int lastBufferProgress;
  private int lastNavBarVisibility = 8;
  public String lastPoster;
  long lastSmallScreenTime = -1L;
  private int lastTabBarVisibility = 8;
  private View loadingView;
  public boolean loop;
  private AudioManager mAudioManager;
  private Context mContext;
  private long mCurrPos;
  private WindowManager.LayoutParams mLayoutParams;
  public String mUrls;
  private VideoGestureLayout mVideoGestureLayout;
  private TVK_IMediaPlayer mVideoPlayer;
  private IVideoViewBase mVideoView;
  private Window mWindow;
  private int maxVolume;
  private ImageView muteIv;
  public boolean muted;
  public boolean needEvent;
  private boolean needPauseOnLoad;
  private int newProgress;
  private TextView nowTimeTv;
  public String objectFit = "contain";
  private int oldProgress;
  private int oldVolume;
  private int originHeight;
  private int originWidth;
  public boolean pageGesture;
  public int parentId;
  public boolean pauseByUser;
  public String playBtnPosition;
  private ImageView play_status_img;
  private SeekBar playerSeekBar;
  public boolean playingBefore;
  private View playingPopView;
  public String poster;
  public JSONObject postionObj;
  private TVK_IMediaPlayer preVideoPlayer;
  private int rotation;
  private TextView seekTv;
  public JsRuntime serviceWebview;
  public boolean showCenterPlayBtn = true;
  public boolean showControlProgress;
  public boolean showDanmuBtn;
  public boolean showFullScreenBtn = true;
  public boolean showLiveBtn;
  public boolean showMuteBtn;
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
  public WebviewContainer webviewContainer;
  public int webviewId;
  private ImageView windowIv;
  
  public MiniAppVideoPlayer(@NonNull Context paramContext)
  {
    this(paramContext, null);
    setUpView(paramContext);
  }
  
  public MiniAppVideoPlayer(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
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
      QLog.d("MiniAppVideoPlayer", 1, "avoidLockScreen");
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
      this.serviceWebview.evaluateSubcribeJS("onVideoFullScreenChange", localJSONObject.toString(), this.webviewId);
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
      localJSONObject.put("videoId", this.videoId);
      localJSONObject.put("fullScreen", this.isFullScreen);
      if (paramBoolean) {
        localJSONObject.put("direction", "horizontal");
      }
      for (;;)
      {
        this.serviceWebview.evaluateSubcribeJS("onVideoFullScreenChange", localJSONObject.toString(), this.webviewId);
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
      this.serviceWebview.evaluateSubcribeJS("onVideoStateChange", localJSONObject.toString(), this.webviewId);
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("MiniAppVideoPlayer", 1, "callbackVideoStateChange error.", paramString);
    }
  }
  
  private void cancelAvoidLockScreen()
  {
    if ((this.atyRef != null) && (this.atyRef.get() != null))
    {
      ((Activity)this.atyRef.get()).getWindow().clearFlags(128);
      ((Activity)this.atyRef.get()).getWindow().addFlags(1);
      QLog.d("MiniAppVideoPlayer", 1, "cancelAvoidLockScreen");
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
      getHandler().postDelayed(new MiniAppVideoPlayer.19(this), 1000L);
    }
  }
  
  private void hidePopCtrView()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 2003;
    this.handler.sendMessageDelayed(localMessage, 500L);
  }
  
  public static void initOskOnce(Context paramContext)
  {
    if (!mIsInited)
    {
      OskPlayerConfig localOskPlayerConfig = new OskPlayerConfig();
      localOskPlayerConfig.setEnableHLSCache(true);
      localOskPlayerConfig.setDebugVersion(true);
      localOskPlayerConfig.setLogger(new DefaultLogger());
      localOskPlayerConfig.setCacheKeyGenerator(new DefaultCacheKeyGenerator());
      OskPlayerCore.init(paramContext.getApplicationContext(), localOskPlayerConfig);
      paramContext = PlayerConfig.g().getContentTypeList();
      if (paramContext == null) {
        break label126;
      }
    }
    for (;;)
    {
      try
      {
        paramContext.addAll(Arrays.asList(oskPlayerContentTypeList.split("|")));
        PlayerConfig.g().setContentTypeList(paramContext);
        mIsInited = true;
        return;
      }
      catch (Exception paramContext)
      {
        QLog.e("MiniAppVideoPlayer", 2, "initOskOnce contentTypeList.addAll oskPlayerContentTypeStrList get an err!!:" + paramContext);
        continue;
      }
      label126:
      QLog.e("MiniAppVideoPlayer", 2, "getContentTypeList null");
    }
  }
  
  private void initPlayer(Context paramContext)
  {
    i = 0;
    if (this.mVideoPlayer == null)
    {
      TVK_SDKMgr.setDebugEnable(true);
      TVK_SDKMgr.setOnLogListener(new MiniAppVideoPlayer.6(this));
      TVK_SDKMgr.initSdk(getContext(), "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", "");
    }
    if (!TVK_SDKMgr.isInstalled(getContext())) {
      if (QLog.isColorLevel()) {
        QLog.d("MiniAppVideoPlayer", 2, "TVK_SDK is not installed");
      }
    }
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = TVK_SDKMgr.getProxyFactory();
      } while (localObject == null);
      this.mVideoView = ((TVK_IProxyFactory)localObject).createVideoView_Scroll(paramContext);
      this.mVideoPlayer = ((TVK_IProxyFactory)localObject).createMediaPlayer(paramContext, this.mVideoView);
    } while (this.mVideoPlayer == null);
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    this.vdView = ((View)this.mVideoView);
    this.vdView.setLayoutParams(paramContext);
    this.vdView.setVisibility(0);
    this.mVideoPlayer.setXYaxis(0);
    if (!this.autoplay)
    {
      if (StringUtil.isEmpty(this.poster)) {
        break label582;
      }
      setPoster();
    }
    for (;;)
    {
      try
      {
        if (this.isShowBasicControl)
        {
          paramContext = new Properties();
          if (this.enableDanmu)
          {
            this.danmuView = new BarrageView(this.mContext, null);
            localObject = new FrameLayout.LayoutParams(-1, -1);
            addView(this.danmuView, (ViewGroup.LayoutParams)localObject);
            this.danmuView.setBarrages(this.barrages);
          }
          if (this.customCache) {
            paramContext.put("mHaveCacheDownload", "true");
          }
        }
      }
      catch (Exception paramContext)
      {
        label582:
        paramContext.printStackTrace();
        continue;
        this.play_status_img.setVisibility(8);
        continue;
        boolean bool = false;
        continue;
        i = 1;
        continue;
      }
      this.mVideoPlayer.setOnControllerClickListener(new MiniAppVideoPlayer.8(this));
      this.mVideoPlayer.setOnVideoPreparedListener(new MiniAppVideoPlayer.9(this));
      this.mVideoPlayer.setOnCompletionListener(new MiniAppVideoPlayer.10(this));
      this.mVideoPlayer.setLoopback(this.loop);
      this.mVideoPlayer.setOnErrorListener(new MiniAppVideoPlayer.11(this));
      this.mVideoPlayer.setOnInfoListener(new MiniAppVideoPlayer.12(this));
      this.mVideoPlayer.setOnSeekCompleteListener(new MiniAppVideoPlayer.13(this));
      if (!this.showCenterPlayBtn) {
        continue;
      }
      this.play_status_img.setVisibility(0);
      this.video_container.removeAllViews();
      this.video_container.addView(this.vdView);
      this.video_container.setBackgroundColor(-16777216);
      paramContext = new FrameLayout.LayoutParams(DisplayUtil.dip2px(this.mContext, 100.0F), DisplayUtil.dip2px(this.mContext, 100.0F));
      paramContext.gravity = 17;
      this.video_container.addView(this.mVideoGestureLayout, paramContext);
      if ((this.mCurrPos > 0L) && (NetworkUtil.isWifiConnected(this.mContext)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MiniAppVideoPlayer", 2, "play current pos is: " + this.mCurrPos);
        }
        play(this.mCurrPos);
        this.preVideoPlayer = null;
        if (this.isPause) {
          continue;
        }
        bool = true;
        resetControlIvDrawable(bool);
        this.needPauseOnLoad = this.isPause;
      }
      paramContext = this.mVideoPlayer;
      if (!this.objectFit.equals("contain")) {
        continue;
      }
      paramContext.setXYaxis(i);
      return;
      if (!StringUtil.isEmpty(this.mUrls)) {
        MediaUtils.getImageForVideo(this.mUrls, new MiniAppVideoPlayer.7(this));
      }
    }
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
  
  private void pause()
  {
    QLog.d("MiniAppVideoPlayer", 4, "pause");
    if (this.mVideoPlayer == null) {}
    do
    {
      return;
      this.playingBefore = false;
    } while (!this.mVideoPlayer.isPlaying());
    cancelAvoidLockScreen();
    this.mVideoPlayer.pause();
    this.isPause = true;
    if ((this.serviceWebview instanceof GameJsRuntime))
    {
      callbackVideoStateChange("pause");
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("videoId", this.videoId);
      localJSONObject.put("data", this.data);
      this.serviceWebview.evaluateSubcribeJS("onVideoPause", localJSONObject.toString(), this.webviewId);
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
    for (int i = 2130847615;; i = 2130847614)
    {
      localImageView.setImageResource(i);
      return;
    }
  }
  
  private void resetControlIvDrawable(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.controlIv.setImageResource(2130847616);
      this.centerControlIv.setImageResource(2130847616);
      return;
    }
    this.controlIv.setImageResource(2130847618);
    this.centerControlIv.setImageResource(2130847618);
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
    for (int i = 2130841304;; i = 2130841305)
    {
      localImageView.setImageResource(i);
      this.muteIv.setVisibility(0);
      return;
    }
  }
  
  private void resetPlayingTime()
  {
    if (this.mVideoPlayer == null) {
      return;
    }
    this.nowTimeTv.setText(parseTimeString(this.mVideoPlayer.getCurrentPostion()));
  }
  
  private void resetWindowIvDrawable()
  {
    ImageView localImageView = this.windowIv;
    if (this.isFullScreen) {}
    for (int i = 2130848546;; i = 2130848548)
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
  
  private void setPoster()
  {
    Object localObject1 = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
    ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = URLDrawableHelper.TRANSPARENT;
    try
    {
      if (URLUtil.isNetworkUrl(this.poster)) {}
      for (localObject1 = URLDrawable.getDrawable(this.poster, (URLDrawable.URLDrawableOptions)localObject1);; localObject1 = URLDrawable.getFileDrawable(this.poster, (URLDrawable.URLDrawableOptions)localObject1))
      {
        if ((localObject1 != null) && (this.video_img != null))
        {
          this.video_img.setVisibility(0);
          this.video_img.setImageDrawable((Drawable)localObject1);
          this.video_img.setScaleType(ImageView.ScaleType.FIT_XY);
        }
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("MiniAppVideoPlayer", 1, "initPlayer get poster drawable error.", localThrowable);
        Object localObject2 = null;
      }
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
    this.view = LayoutInflater.from(paramContext).inflate(2131559409, null);
    this.video_container = ((VideoGestureRelativeLayout)this.view.findViewById(2131369780));
    this.video_container.setContentDescription("video_container");
    this.video_pop_container = ((FrameLayout)this.view.findViewById(2131380660));
    this.video_img = ((ImageView)this.view.findViewById(2131380590));
    this.play_status_img = ((ImageView)this.view.findViewById(2131372744));
    this.play_status_img.setOnClickListener(this);
    this.playingPopView = this.view.findViewById(2131380655);
    this.nowTimeTv = ((TextView)this.view.findViewById(2131380657));
    this.totalTimeTv = ((TextView)this.view.findViewById(2131380658));
    this.controlIv = ((ImageView)this.view.findViewById(2131380650));
    this.centerControlIv = ((ImageView)this.view.findViewById(2131380651));
    this.controlBar = this.view.findViewById(2131380647);
    this.windowIv = ((ImageView)this.view.findViewById(2131380653));
    this.playerSeekBar = ((SeekBar)this.view.findViewById(2131380646));
    this.loadingView = this.view.findViewById(2131380612);
    this.barrageIv = ((ImageView)this.view.findViewById(2131380649));
    this.seekTv = ((TextView)this.view.findViewById(2131380656));
    this.backIv = ((ImageView)this.view.findViewById(2131380648));
    this.titleTv = ((TextView)this.view.findViewById(2131380659));
    this.muteIv = ((ImageView)this.view.findViewById(2131380652));
    this.actionVg = ((FrameLayout)this.view.findViewById(2131380461));
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
      updateVideoGestureSetting();
      this.video_container.setVideoGestureListener(new MiniAppVideoPlayer.3(this));
      this.playerSeekBar.setOnSeekBarChangeListener(new MiniAppVideoPlayer.4(this));
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
    QLog.d("MiniAppVideoPlayer", 4, "start");
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
  
  private void updateBufferProgress(boolean paramBoolean)
  {
    MiniAppVideoPlayer.18 local18 = new MiniAppVideoPlayer.18(this);
    if (!paramBoolean) {
      local18.run();
    }
    while ((!this.isBufferStart) && (this.lastBufferProgress == 0)) {
      return;
    }
    this.handler.postDelayed(local18, 20L);
  }
  
  private void updatePoster()
  {
    if ((this.poster != null) && (!this.poster.equals(this.lastPoster))) {
      setPoster();
    }
    this.lastPoster = this.poster;
  }
  
  private void updateVideoGestureSetting()
  {
    if (this.video_container != null)
    {
      this.video_container.setEnablePageGesture(this.pageGesture);
      this.video_container.setEnableProgressGesture(this.enableProgressGesture);
      this.video_container.setEnablePlayGesture(this.enablePlayGesture);
    }
  }
  
  public void captureImage(TVK_IMediaPlayer.OnCaptureImageListener paramOnCaptureImageListener)
  {
    if (this.mVideoPlayer == null)
    {
      QLog.e("MiniAppVideoPlayer", 1, "captureImage video player is null");
      if (paramOnCaptureImageListener != null) {
        paramOnCaptureImageListener.onCaptureImageFailed(null, 0, 0);
      }
    }
    do
    {
      for (;;)
      {
        return;
        try
        {
          if (this.mVideoPlayer.isPlaying()) {
            break label137;
          }
          if ((this.cachedCaptureImage == null) || (this.cachedCaptureImage.isRecycled())) {
            break label124;
          }
          if (paramOnCaptureImageListener != null)
          {
            paramOnCaptureImageListener.onCaptureImageSucceed(this.mVideoPlayer, 0, 0, 0, this.cachedCaptureImage);
            return;
          }
        }
        catch (Exception localException)
        {
          QLog.e("MiniAppVideoPlayer", 1, "captureImage video player fail!,e" + localException);
        }
      }
    } while (paramOnCaptureImageListener == null);
    paramOnCaptureImageListener.onCaptureImageFailed(null, 0, 0);
    return;
    label124:
    paramOnCaptureImageListener.onCaptureImageFailed(this.mVideoPlayer, 0, 0);
    return;
    label137:
    int j;
    int i;
    if (this.view != null)
    {
      j = this.view.getWidth();
      i = this.view.getHeight();
    }
    for (;;)
    {
      this.mVideoPlayer.setOnCaptureImageListener(new MiniAppVideoPlayer.20(this, paramOnCaptureImageListener));
      try
      {
        this.mVideoPlayer.captureImageInTime(j, i);
        return;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        QLog.e("MiniAppVideoPlayer", 1, "captureImage ", localIllegalAccessException);
        return;
      }
      i = 0;
      j = 0;
    }
  }
  
  public void changeState()
  {
    AppBrandTask.runTaskOnUiThread(new MiniAppVideoPlayer.5(this));
  }
  
  public void fullScreen()
  {
    this.handler.post(new MiniAppVideoPlayer.16(this));
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
    boolean bool = true;
    switch (paramMessage.what)
    {
    default: 
      bool = false;
      return bool;
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
        if (!(this.serviceWebview instanceof GameJsRuntime)) {
          break label131;
        }
        callbackVideoStateChange("timeUpdate");
      }
      while (!this.isPause)
      {
        sendTimingMsg(l + 200L - System.currentTimeMillis());
        return true;
        try
        {
          label131:
          paramMessage = new JSONObject();
          paramMessage.put("data", this.data);
          paramMessage.put("position", this.mVideoPlayer.getCurrentPostion() / 1000.0D);
          paramMessage.put("duration", this.mVideoPlayer.getDuration() / 1000.0D);
          paramMessage.put("videoId", this.videoId);
          this.serviceWebview.evaluateSubcribeJS("onVideoTimeUpdate", paramMessage.toString(), this.webviewId);
          if (QLog.isColorLevel()) {
            QLog.d("MiniAppVideoPlayer", 4, "evaluateSubcribeJS onVideoTimeUpdate = " + paramMessage.toString());
          }
        }
        catch (JSONException paramMessage)
        {
          paramMessage.printStackTrace();
        }
      }
    }
    this.playingPopView.setVisibility(4);
    return true;
  }
  
  public void initSetting(JSONObject paramJSONObject)
  {
    int j = 0;
    QLog.i("MiniAppVideoPlayer", 1, "initSetting: " + paramJSONObject.toString());
    this.needEvent = paramJSONObject.optBoolean("needEvent", this.needEvent);
    this.hide = paramJSONObject.optBoolean("hide", this.hide);
    this.enableDanmu = paramJSONObject.optBoolean("enableDanmu", this.enableDanmu);
    if (!this.hasShowDanmuBtnSet)
    {
      this.showDanmuBtn = paramJSONObject.optBoolean("showDanmuBtn", this.showDanmuBtn);
      this.loop = paramJSONObject.optBoolean("loop", this.loop);
      QLog.i("MiniAppVideoPlayer", 1, "initSetting: set dan mu btn " + this.enableDanmu);
      this.hasShowDanmuBtnSet = true;
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
    }
    if (paramJSONObject.has("muted")) {}
    try
    {
      this.muted = paramJSONObject.getBoolean("muted");
      this.showCenterPlayBtn = paramJSONObject.optBoolean("showCenterPlayBtn", this.showCenterPlayBtn);
      Object localObject = paramJSONObject.optString("objectFit", this.objectFit);
      if (!this.objectFit.equals(localObject))
      {
        if ("contain".equals(localObject))
        {
          if (this.mVideoPlayer != null) {
            this.mVideoPlayer.setXYaxis(0);
          }
          this.objectFit = ((String)localObject);
        }
      }
      else
      {
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
        updateVideoGestureSetting();
        if (!this.isFullScreen)
        {
          localObject = paramJSONObject.optJSONObject("position");
          if (localObject == null) {
            break label1016;
          }
          this.videoX = ((JSONObject)localObject).optInt("left", this.videoX);
          this.videoY = ((JSONObject)localObject).optInt("top", this.videoY);
          this.videoWidth = ((JSONObject)localObject).optInt("width", this.videoWidth);
          this.videoHeight = ((JSONObject)localObject).optInt("height", this.videoHeight);
        }
        if (StringUtil.isEmpty(this.poster)) {
          this.poster = paramJSONObject.optString("poster", this.poster);
        }
        if (this.mVideoPlayer != null)
        {
          this.mCurrPos = this.mVideoPlayer.getCurrentPostion();
          if (this.mVideoPlayer.getOutputMute() != this.muted)
          {
            Log.i("MiniAppVideoPlayer", "initSetting: set mute " + this.muted);
            this.mVideoPlayer.setOutputMute(this.muted);
          }
        }
        if (this.barrageIv != null)
        {
          paramJSONObject = this.barrageIv;
          if (!this.showDanmuBtn) {
            break label1079;
          }
          i = 0;
          paramJSONObject.setVisibility(i);
        }
        if (!"center".equals(this.playBtnPosition)) {
          break label1090;
        }
        paramJSONObject = this.centerControlIv;
        if (!this.showCenterPlayBtn) {
          break label1084;
        }
        i = j;
        paramJSONObject.setVisibility(i);
        this.controlIv.setVisibility(8);
        if (!TextUtils.isEmpty(this.title)) {
          this.titleTv.setText(this.title);
        }
        resetMuteImage();
        if (!this.isFullScreen)
        {
          if (this.webviewContainer != null) {
            break label1110;
          }
          paramJSONObject = new RelativeLayout.LayoutParams(ViewUtils.dpToPx(this.videoWidth), ViewUtils.dpToPx(this.videoHeight));
          paramJSONObject.leftMargin = ViewUtils.dpToPx(this.videoX);
          paramJSONObject.topMargin = ViewUtils.dpToPx(this.videoY);
          ((CoverVideoView)getParent()).setLayoutParams(paramJSONObject);
        }
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        int i;
        QLog.w("MiniAppVideoPlayer", 2, "initSetting: ", localJSONException);
        continue;
        if ("fill".equals(localJSONException))
        {
          if (this.mVideoPlayer != null) {
            this.mVideoPlayer.setXYaxis(1);
          }
          this.objectFit = localJSONException;
          continue;
          label1016:
          this.videoX = paramJSONObject.optInt("x", this.videoX);
          this.videoY = paramJSONObject.optInt("y", this.videoY);
          this.videoWidth = paramJSONObject.optInt("width", this.videoWidth);
          this.videoHeight = paramJSONObject.optInt("height", this.videoHeight);
          continue;
          label1079:
          i = 4;
          continue;
          label1084:
          i = 8;
          continue;
          label1090:
          this.centerControlIv.setVisibility(8);
          this.controlIv.setVisibility(0);
        }
      }
      label1110:
      paramJSONObject = new FrameLayout.LayoutParams(ViewUtils.dpToPx(this.videoWidth), ViewUtils.dpToPx(this.videoHeight));
      paramJSONObject.leftMargin = ViewUtils.dpToPx(this.videoX);
      paramJSONObject.topMargin = ViewUtils.dpToPx(this.videoY);
      ((CoverVideoView)getParent()).setLayoutParams(paramJSONObject);
    }
  }
  
  public void initVideoPlayerSettings(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppVideoPlayer", 2, "initLivePlayerSettings isFullScreen: " + this.isFullScreen);
    }
    initOskOnce(this.mContext);
    initSetting(paramJSONObject);
    initPlayer(this.mContext);
    updatePoster();
  }
  
  public boolean isFullScreen()
  {
    return this.isFullScreen;
  }
  
  boolean isFullScreenSize(int paramInt1, int paramInt2)
  {
    return (paramInt1 == DisplayUtil.getRealHeight(getContext())) && (paramInt2 == ImmersiveUtils.a());
  }
  
  public boolean isPlaying()
  {
    return (this.mVideoPlayer != null) && ((this.mVideoPlayer.isPlayingAD()) || (this.mVideoPlayer.isPlaying()));
  }
  
  public void onClick(View paramView)
  {
    boolean bool = true;
    if (this.mVideoPlayer == null) {}
    do
    {
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (paramView.getId() != 2131372744) {
          break;
        }
        if (this.play_status_img.getVisibility() == 0) {
          if ((this.initialTime > 0.0D) && (getCurrentPos() == 0L)) {
            play((this.initialTime * 1000.0D));
          } else {
            play(getCurrentPos());
          }
        }
      }
      if ((paramView.getId() == this.controlIv.getId()) || (paramView.getId() == this.centerControlIv.getId()))
      {
        operate();
        if (this.mVideoPlayer.isPlaying()) {
          showPopCtrView();
        }
        for (;;)
        {
          resetControlIvDrawable(this.mVideoPlayer.isPlaying());
          break;
          showPopCtrViewWithoutHideAfter();
        }
      }
      if ((paramView.getId() == this.windowIv.getId()) || (paramView.getId() == this.backIv.getId()))
      {
        showPopCtrView();
        if (this.isFullScreen) {
          smallScreen();
        }
        for (;;)
        {
          resetWindowIvDrawable();
          break;
          fullScreen();
        }
      }
      if (paramView.getId() == this.barrageIv.getId())
      {
        showPopCtrView();
        if (this.isBarrageOpen)
        {
          this.danmuView.setVisibility(4);
          this.isBarrageOpen = false;
        }
        for (;;)
        {
          resetBarrageDrawable();
          break;
          if (this.danmuView != null)
          {
            this.danmuView.setVisibility(0);
            this.isBarrageOpen = true;
          }
        }
      }
    } while (paramView.getId() != this.muteIv.getId());
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.mVideoPlayer;
    if (!this.mVideoPlayer.getOutputMute()) {}
    for (;;)
    {
      localTVK_IMediaPlayer.setOutputMute(bool);
      resetMuteImage();
      break;
      bool = false;
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
    QLog.d("MiniAppVideoPlayer", 4, "operate");
    if (this.mVideoPlayer == null) {}
    do
    {
      return;
      if (this.mVideoPlayer.isPlaying())
      {
        this.pauseByUser = true;
        pause();
        return;
      }
    } while (this.isPageOnBackground);
    this.pauseByUser = false;
    start();
    if ((this.serviceWebview instanceof GameJsRuntime)) {
      callbackVideoStateChange("play");
    }
    for (;;)
    {
      sendTimingMsg(200L);
      return;
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("videoId", this.videoId);
        localJSONObject.put("data", this.data);
        this.serviceWebview.evaluateSubcribeJS("onVideoPlay", localJSONObject.toString(), this.webviewId);
        QLog.d("MiniAppVideoPlayer", 4, "operate start evaluateSubcribeJS onVideoPlay = " + localJSONObject.toString());
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
    Object localObject = new TVK_PlayerVideoInfo();
    ((TVK_PlayerVideoInfo)localObject).setConfigMap("keep_last_frame", "true");
    if ((this.mUrls.startsWith("http")) || (this.mUrls.startsWith("https"))) {
      if (this.mUrls.toLowerCase().contains(".m3u8"))
      {
        ((TVK_PlayerVideoInfo)localObject).setPlayType(1);
        if (this.mUrls.startsWith("https")) {
          this.mUrls = OskPlayerCore.getInstance().getUrl(this.mUrls);
        }
      }
    }
    for (;;)
    {
      if (this.enableDanmu) {
        this.mVideoPlayer.startPlayDanmu();
      }
      this.mVideoPlayer.openMediaPlayerByUrl(getContext(), this.mUrls, paramLong, 0L, (TVK_PlayerVideoInfo)localObject);
      this.play_status_img.setVisibility(8);
      if (!(this.serviceWebview instanceof GameJsRuntime)) {
        break;
      }
      callbackVideoStateChange("play");
      return;
      QLog.d("MiniAppVideoPlayer", 1, "OskPlayerCore.getInstance().getUrl: " + this.mUrls);
      this.mUrls = OskPlayerCore.getInstance().getUrl(this.mUrls);
      QLog.d("MiniAppVideoPlayer", 1, "OskPlayerCore.getInstance().getUrl done: " + this.mUrls);
      ((TVK_PlayerVideoInfo)localObject).setPlayType(5);
      continue;
      ((TVK_PlayerVideoInfo)localObject).setPlayType(4);
    }
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("data", this.data);
      this.serviceWebview.evaluateSubcribeJS("onVideoPlay", ((JSONObject)localObject).toString(), this.webviewId);
      QLog.d("MiniAppVideoPlayer", 4, "evaluateSubcribeJS onVideoPlay = " + ((JSONObject)localObject).toString());
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
    AppBrandTask.runTaskOnUiThread(new MiniAppVideoPlayer.15(this));
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
    if (this.showCenterPlayBtn)
    {
      this.play_status_img.setVisibility(0);
      this.playingPopView.setVisibility(8);
      this.handler.removeMessages(2002);
      if (!paramString.startsWith("wxfile")) {
        break label166;
      }
    }
    for (this.mUrls = MiniAppFileManager.getInstance().getAbsolutePath(paramString);; this.mUrls = paramString) {
      label166:
      do
      {
        if ((this.isResetPath) || (this.autoplay)) {
          this.handler.postDelayed(new MiniAppVideoPlayer.1(this), 100L);
        }
        this.isResetPath = true;
        this.rotation = 0;
        if (Build.VERSION.SDK_INT > 15) {
          ThreadManagerV2.excute(new MiniAppVideoPlayer.2(this), 128, null, true);
        }
        return;
        this.play_status_img.setVisibility(8);
        break;
      } while ((!paramString.startsWith("http")) && (!paramString.startsWith("https")));
    }
  }
  
  public void smallScreen()
  {
    this.handler.post(new MiniAppVideoPlayer.17(this));
  }
  
  public void stop()
  {
    stop(true);
  }
  
  public void stop(boolean paramBoolean)
  {
    if (this.mVideoPlayer != null) {
      this.mVideoPlayer.stop();
    }
    AppBrandTask.runTaskOnUiThread(new MiniAppVideoPlayer.14(this));
  }
  
  public void updateVideoPlayerSetting(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppVideoPlayer", 2, "updateLivePlayerSetting isFullScreen: " + this.isFullScreen);
    }
    initSetting(paramJSONObject);
    updatePoster();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.media.MiniAppVideoPlayer
 * JD-Core Version:    0.7.0.1
 */