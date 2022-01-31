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
import axwd;
import badq;
import baip;
import bajq;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.mini.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mobileqq.mini.utils.ScreenOffOnListener;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.mini.widget.media.danmu.Barrage;
import com.tencent.mobileqq.mini.widget.media.danmu.BarrageView;
import com.tencent.mobileqq.minigame.jsapi.GameJsRuntime;
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
  public int initialTime;
  public boolean isBarrageOpen;
  private boolean isBufferStart;
  boolean isBusyInChangeScreen = false;
  private boolean isChangingProgress;
  public boolean isFullScreen;
  public boolean isLive;
  public boolean isMuted;
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
      getHandler().postDelayed(new MiniAppVideoPlayer.18(this), 1000L);
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
      TVK_SDKMgr.setOnLogListener(new MiniAppVideoPlayer.5(this));
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
      if (baip.a(this.poster)) {
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
      this.mVideoPlayer.setOnControllerClickListener(new MiniAppVideoPlayer.7(this));
      this.mVideoPlayer.setOnVideoPreparedListener(new MiniAppVideoPlayer.8(this));
      this.mVideoPlayer.setOnCompletionListener(new MiniAppVideoPlayer.9(this));
      this.mVideoPlayer.setLoopback(this.loop);
      this.mVideoPlayer.setOnErrorListener(new MiniAppVideoPlayer.10(this));
      this.mVideoPlayer.setOnInfoListener(new MiniAppVideoPlayer.11(this));
      this.mVideoPlayer.setOnSeekCompleteListener(new MiniAppVideoPlayer.12(this));
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
      if ((this.mCurrPos > 0L) && (badq.h(this.mContext)))
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
      if (!baip.a(this.mUrls)) {
        MediaUtils.getImageForVideo(this.mUrls, new MiniAppVideoPlayer.6(this));
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
    for (int i = 2130846593;; i = 2130846592)
    {
      localImageView.setImageResource(i);
      return;
    }
  }
  
  private void resetControlIvDrawable(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.controlIv.setImageResource(2130846594);
      this.centerControlIv.setImageResource(2130846594);
      return;
    }
    this.controlIv.setImageResource(2130846596);
    this.centerControlIv.setImageResource(2130846596);
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
    for (int i = 2130840827;; i = 2130840828)
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
    for (int i = 2130847453;; i = 2130847455)
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
    ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = axwd.a;
    ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = axwd.a;
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
    this.view = LayoutInflater.from(paramContext).inflate(2131493702, null);
    this.video_container = ((VideoGestureRelativeLayout)this.view.findViewById(2131303390));
    this.video_container.setContentDescription("video_container");
    this.video_pop_container = ((FrameLayout)this.view.findViewById(2131313225));
    this.video_img = ((ImageView)this.view.findViewById(2131313168));
    this.play_status_img = ((ImageView)this.view.findViewById(2131306059));
    this.play_status_img.setOnClickListener(this);
    this.playingPopView = this.view.findViewById(2131313220);
    this.nowTimeTv = ((TextView)this.view.findViewById(2131313222));
    this.totalTimeTv = ((TextView)this.view.findViewById(2131313223));
    this.controlIv = ((ImageView)this.view.findViewById(2131313215));
    this.centerControlIv = ((ImageView)this.view.findViewById(2131313216));
    this.controlBar = this.view.findViewById(2131313212);
    this.windowIv = ((ImageView)this.view.findViewById(2131313218));
    this.playerSeekBar = ((SeekBar)this.view.findViewById(2131313211));
    this.loadingView = this.view.findViewById(2131313185);
    this.barrageIv = ((ImageView)this.view.findViewById(2131313214));
    this.seekTv = ((TextView)this.view.findViewById(2131313221));
    this.backIv = ((ImageView)this.view.findViewById(2131313213));
    this.titleTv = ((TextView)this.view.findViewById(2131313224));
    this.muteIv = ((ImageView)this.view.findViewById(2131313217));
    this.actionVg = ((FrameLayout)this.view.findViewById(2131313078));
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
      this.video_container.setVideoGestureListener(new MiniAppVideoPlayer.2(this));
      this.playerSeekBar.setOnSeekBarChangeListener(new MiniAppVideoPlayer.3(this));
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
      play();
    }
  }
  
  private void updateBufferProgress(boolean paramBoolean)
  {
    MiniAppVideoPlayer.17 local17 = new MiniAppVideoPlayer.17(this);
    if (!paramBoolean) {
      local17.run();
    }
    while ((!this.isBufferStart) && (this.lastBufferProgress == 0)) {
      return;
    }
    this.handler.postDelayed(local17, 20L);
  }
  
  private void updatePoster()
  {
    if ((this.poster != null) && (!this.poster.equals(this.lastPoster))) {
      setPoster();
    }
    this.lastPoster = this.poster;
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
      this.mVideoPlayer.setOnCaptureImageListener(new MiniAppVideoPlayer.19(this, paramOnCaptureImageListener));
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
    AppBrandTask.runTaskOnUiThread(new MiniAppVideoPlayer.4(this));
  }
  
  public void fullScreen()
  {
    this.handler.post(new MiniAppVideoPlayer.15(this));
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
        this.initialTime = paramJSONObject.optInt("initialTime", this.initialTime);
        this.parentId = paramJSONObject.optInt("parentId", this.parentId);
        this.customCache = paramJSONObject.optBoolean("customCache", this.customCache);
        this.showProgress = paramJSONObject.optBoolean("showProgress", this.showProgress);
        this.showControlProgress = paramJSONObject.optBoolean("showControlProgress", this.showControlProgress);
        this.showLiveBtn = paramJSONObject.optBoolean("showLiveBtn", this.showLiveBtn);
        this.showPlayBtn = paramJSONObject.optBoolean("showPlayBtn", this.showPlayBtn);
        this.showFullScreenBtn = paramJSONObject.optBoolean("showFullScreenBtn", this.showFullScreenBtn);
        this.enableProgressGesture = paramJSONObject.optBoolean("enableProgressGesture", this.enableProgressGesture);
        if (!this.isFullScreen)
        {
          localObject = paramJSONObject.optJSONObject("position");
          if (localObject == null) {
            break label1012;
          }
          this.videoX = ((JSONObject)localObject).optInt("left", this.videoX);
          this.videoY = ((JSONObject)localObject).optInt("top", this.videoY);
          this.videoWidth = ((JSONObject)localObject).optInt("width", this.videoWidth);
          this.videoHeight = ((JSONObject)localObject).optInt("height", this.videoHeight);
        }
        if (baip.a(this.poster)) {
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
            break label1075;
          }
          i = 0;
          paramJSONObject.setVisibility(i);
        }
        if (!"center".equals(this.playBtnPosition)) {
          break label1086;
        }
        paramJSONObject = this.centerControlIv;
        if (!this.showCenterPlayBtn) {
          break label1080;
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
            break label1106;
          }
          paramJSONObject = new RelativeLayout.LayoutParams(bajq.b(this.videoWidth), bajq.b(this.videoHeight));
          paramJSONObject.leftMargin = bajq.b(this.videoX);
          paramJSONObject.topMargin = bajq.b(this.videoY);
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
          label1012:
          this.videoX = paramJSONObject.optInt("x", this.videoX);
          this.videoY = paramJSONObject.optInt("y", this.videoY);
          this.videoWidth = paramJSONObject.optInt("width", this.videoWidth);
          this.videoHeight = paramJSONObject.optInt("height", this.videoHeight);
          continue;
          label1075:
          i = 4;
          continue;
          label1080:
          i = 8;
          continue;
          label1086:
          this.centerControlIv.setVisibility(8);
          this.controlIv.setVisibility(0);
        }
      }
      label1106:
      paramJSONObject = new FrameLayout.LayoutParams(bajq.b(this.videoWidth), bajq.b(this.videoHeight));
      paramJSONObject.leftMargin = bajq.b(this.videoX);
      paramJSONObject.topMargin = bajq.b(this.videoY);
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
      do
      {
        return;
        if (paramView.getId() != 2131306059) {
          break;
        }
      } while (this.play_status_img.getVisibility() != 0);
      play(getCurrentPos());
      return;
      if ((paramView.getId() == this.controlIv.getId()) || (paramView.getId() == this.centerControlIv.getId()))
      {
        operate();
        if (this.mVideoPlayer.isPlaying()) {
          showPopCtrView();
        }
        for (;;)
        {
          resetControlIvDrawable(this.mVideoPlayer.isPlaying());
          return;
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
          return;
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
          return;
          if (this.danmuView != null)
          {
            this.danmuView.setVisibility(0);
            this.isBarrageOpen = true;
          }
        }
      }
    } while (paramView.getId() != this.muteIv.getId());
    paramView = this.mVideoPlayer;
    if (!this.mVideoPlayer.getOutputMute()) {}
    for (;;)
    {
      paramView.setOutputMute(bool);
      resetMuteImage();
      return;
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
    } while (baip.a(this.mUrls));
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
    AppBrandTask.runTaskOnUiThread(new MiniAppVideoPlayer.14(this));
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
    if (paramInt > this.mVideoPlayer.getDuration())
    {
      this.mVideoPlayer.seekTo((int)this.mVideoPlayer.getDuration());
      return true;
    }
    this.mVideoPlayer.seekTo(paramInt);
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
  
  /* Error */
  public void setVideoPath(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: ldc 25
    //   5: new 774	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 775	java/lang/StringBuilder:<init>	()V
    //   12: ldc_w 1679
    //   15: invokevirtual 781	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: aload_1
    //   19: invokevirtual 781	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: invokevirtual 785	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   25: invokestatic 1452	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   28: pop
    //   29: aload_0
    //   30: iconst_0
    //   31: invokevirtual 1681	com/tencent/mobileqq/mini/widget/media/MiniAppVideoPlayer:stop	(Z)V
    //   34: aload_0
    //   35: getfield 253	com/tencent/mobileqq/mini/widget/media/MiniAppVideoPlayer:showCenterPlayBtn	Z
    //   38: ifeq +212 -> 250
    //   41: aload_0
    //   42: getfield 415	com/tencent/mobileqq/mini/widget/media/MiniAppVideoPlayer:play_status_img	Landroid/widget/ImageView;
    //   45: iconst_0
    //   46: invokevirtual 946	android/widget/ImageView:setVisibility	(I)V
    //   49: aload_0
    //   50: getfield 295	com/tencent/mobileqq/mini/widget/media/MiniAppVideoPlayer:playingPopView	Landroid/view/View;
    //   53: bipush 8
    //   55: invokevirtual 852	android/view/View:setVisibility	(I)V
    //   58: aload_0
    //   59: getfield 235	com/tencent/mobileqq/mini/widget/media/MiniAppVideoPlayer:handler	Landroid/os/Handler;
    //   62: sipush 2002
    //   65: invokevirtual 1238	android/os/Handler:removeMessages	(I)V
    //   68: aload_1
    //   69: ldc_w 1683
    //   72: invokevirtual 1587	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   75: ifeq +187 -> 262
    //   78: aload_0
    //   79: invokestatic 1688	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getInstance	()Lcom/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager;
    //   82: aload_1
    //   83: invokevirtual 1691	com/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager:getAbsolutePath	(Ljava/lang/String;)Ljava/lang/String;
    //   86: putfield 985	com/tencent/mobileqq/mini/widget/media/MiniAppVideoPlayer:mUrls	Ljava/lang/String;
    //   89: aload_0
    //   90: getfield 269	com/tencent/mobileqq/mini/widget/media/MiniAppVideoPlayer:isResetPath	Z
    //   93: ifne +10 -> 103
    //   96: aload_0
    //   97: getfield 857	com/tencent/mobileqq/mini/widget/media/MiniAppVideoPlayer:autoplay	Z
    //   100: ifeq +22 -> 122
    //   103: aload_0
    //   104: getfield 235	com/tencent/mobileqq/mini/widget/media/MiniAppVideoPlayer:handler	Landroid/os/Handler;
    //   107: new 1693	com/tencent/mobileqq/mini/widget/media/MiniAppVideoPlayer$1
    //   110: dup
    //   111: aload_0
    //   112: invokespecial 1694	com/tencent/mobileqq/mini/widget/media/MiniAppVideoPlayer$1:<init>	(Lcom/tencent/mobileqq/mini/widget/media/MiniAppVideoPlayer;)V
    //   115: ldc2_w 1695
    //   118: invokevirtual 685	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   121: pop
    //   122: aload_0
    //   123: iconst_1
    //   124: putfield 269	com/tencent/mobileqq/mini/widget/media/MiniAppVideoPlayer:isResetPath	Z
    //   127: aload_0
    //   128: iconst_0
    //   129: putfield 454	com/tencent/mobileqq/mini/widget/media/MiniAppVideoPlayer:rotation	I
    //   132: getstatic 647	android/os/Build$VERSION:SDK_INT	I
    //   135: bipush 15
    //   137: if_icmple +112 -> 249
    //   140: new 1698	java/io/FileInputStream
    //   143: dup
    //   144: aload_0
    //   145: getfield 985	com/tencent/mobileqq/mini/widget/media/MiniAppVideoPlayer:mUrls	Ljava/lang/String;
    //   148: invokespecial 1700	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   151: astore_3
    //   152: new 1702	android/media/MediaExtractor
    //   155: dup
    //   156: invokespecial 1703	android/media/MediaExtractor:<init>	()V
    //   159: astore 5
    //   161: aload 5
    //   163: aload_3
    //   164: invokevirtual 1707	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   167: invokevirtual 1711	android/media/MediaExtractor:setDataSource	(Ljava/io/FileDescriptor;)V
    //   170: aload 5
    //   172: invokestatic 1717	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/VideoJsPlugin:getAndSelectVideoTrackIndex	(Landroid/media/MediaExtractor;)I
    //   175: istore_2
    //   176: iload_2
    //   177: iconst_m1
    //   178: if_icmple +53 -> 231
    //   181: aload 5
    //   183: iload_2
    //   184: invokevirtual 1721	android/media/MediaExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   187: astore_1
    //   188: aload_1
    //   189: ldc_w 1723
    //   192: invokevirtual 1728	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   195: ifeq +14 -> 209
    //   198: aload_0
    //   199: aload_1
    //   200: ldc_w 1723
    //   203: invokevirtual 1732	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   206: putfield 454	com/tencent/mobileqq/mini/widget/media/MiniAppVideoPlayer:rotation	I
    //   209: aload_0
    //   210: aload_1
    //   211: ldc_w 1442
    //   214: invokevirtual 1732	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   217: putfield 448	com/tencent/mobileqq/mini/widget/media/MiniAppVideoPlayer:originWidth	I
    //   220: aload_0
    //   221: aload_1
    //   222: ldc_w 1444
    //   225: invokevirtual 1732	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   228: putfield 451	com/tencent/mobileqq/mini/widget/media/MiniAppVideoPlayer:originHeight	I
    //   231: aload_3
    //   232: ifnull +7 -> 239
    //   235: aload_3
    //   236: invokevirtual 1735	java/io/FileInputStream:close	()V
    //   239: aload 5
    //   241: ifnull +8 -> 249
    //   244: aload 5
    //   246: invokevirtual 1736	android/media/MediaExtractor:release	()V
    //   249: return
    //   250: aload_0
    //   251: getfield 415	com/tencent/mobileqq/mini/widget/media/MiniAppVideoPlayer:play_status_img	Landroid/widget/ImageView;
    //   254: bipush 8
    //   256: invokevirtual 946	android/widget/ImageView:setVisibility	(I)V
    //   259: goto -210 -> 49
    //   262: aload_1
    //   263: ldc_w 1584
    //   266: invokevirtual 1587	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   269: ifne +13 -> 282
    //   272: aload_1
    //   273: ldc_w 1589
    //   276: invokevirtual 1587	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   279: ifeq -190 -> 89
    //   282: aload_0
    //   283: aload_1
    //   284: putfield 985	com/tencent/mobileqq/mini/widget/media/MiniAppVideoPlayer:mUrls	Ljava/lang/String;
    //   287: goto -198 -> 89
    //   290: astore 4
    //   292: aconst_null
    //   293: astore_3
    //   294: aload 6
    //   296: astore_1
    //   297: ldc 25
    //   299: ldc_w 1679
    //   302: aload 4
    //   304: invokestatic 1738	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   307: pop
    //   308: aload_3
    //   309: ifnull +7 -> 316
    //   312: aload_3
    //   313: invokevirtual 1735	java/io/FileInputStream:close	()V
    //   316: aload_1
    //   317: ifnull -68 -> 249
    //   320: aload_1
    //   321: invokevirtual 1736	android/media/MediaExtractor:release	()V
    //   324: return
    //   325: astore_1
    //   326: aconst_null
    //   327: astore 4
    //   329: aconst_null
    //   330: astore_3
    //   331: aload 4
    //   333: ifnull +8 -> 341
    //   336: aload 4
    //   338: invokevirtual 1735	java/io/FileInputStream:close	()V
    //   341: aload_3
    //   342: ifnull +7 -> 349
    //   345: aload_3
    //   346: invokevirtual 1736	android/media/MediaExtractor:release	()V
    //   349: aload_1
    //   350: athrow
    //   351: astore_1
    //   352: goto -113 -> 239
    //   355: astore_3
    //   356: goto -40 -> 316
    //   359: astore 4
    //   361: goto -20 -> 341
    //   364: astore_1
    //   365: aconst_null
    //   366: astore 5
    //   368: aload_3
    //   369: astore 4
    //   371: aload 5
    //   373: astore_3
    //   374: goto -43 -> 331
    //   377: astore_1
    //   378: aload_3
    //   379: astore 4
    //   381: aload 5
    //   383: astore_3
    //   384: goto -53 -> 331
    //   387: astore 4
    //   389: aload_1
    //   390: astore 5
    //   392: aload 4
    //   394: astore_1
    //   395: aload_3
    //   396: astore 4
    //   398: aload 5
    //   400: astore_3
    //   401: goto -70 -> 331
    //   404: astore 4
    //   406: aload 6
    //   408: astore_1
    //   409: goto -112 -> 297
    //   412: astore 4
    //   414: aload 5
    //   416: astore_1
    //   417: goto -120 -> 297
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	420	0	this	MiniAppVideoPlayer
    //   0	420	1	paramString	String
    //   175	9	2	i	int
    //   151	195	3	localFileInputStream	java.io.FileInputStream
    //   355	14	3	localIOException1	java.io.IOException
    //   373	28	3	localObject1	Object
    //   290	13	4	localThrowable1	Throwable
    //   327	10	4	localObject2	Object
    //   359	1	4	localIOException2	java.io.IOException
    //   369	11	4	localObject3	Object
    //   387	6	4	localObject4	Object
    //   396	1	4	localObject5	Object
    //   404	1	4	localThrowable2	Throwable
    //   412	1	4	localThrowable3	Throwable
    //   159	256	5	localObject6	Object
    //   1	406	6	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   140	152	290	java/lang/Throwable
    //   140	152	325	finally
    //   235	239	351	java/io/IOException
    //   312	316	355	java/io/IOException
    //   336	341	359	java/io/IOException
    //   152	161	364	finally
    //   161	176	377	finally
    //   181	209	377	finally
    //   209	231	377	finally
    //   297	308	387	finally
    //   152	161	404	java/lang/Throwable
    //   161	176	412	java/lang/Throwable
    //   181	209	412	java/lang/Throwable
    //   209	231	412	java/lang/Throwable
  }
  
  public void smallScreen()
  {
    this.handler.post(new MiniAppVideoPlayer.16(this));
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
    AppBrandTask.runTaskOnUiThread(new MiniAppVideoPlayer.13(this));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.media.MiniAppVideoPlayer
 * JD-Core Version:    0.7.0.1
 */