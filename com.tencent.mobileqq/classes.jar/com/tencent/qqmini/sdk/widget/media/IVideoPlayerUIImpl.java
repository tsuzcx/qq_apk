package com.tencent.qqmini.sdk.widget.media;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.qqmini.sdk.R.drawable;
import com.tencent.qqmini.sdk.R.id;
import com.tencent.qqmini.sdk.R.layout;
import com.tencent.qqmini.sdk.action.GetPageIntAction;
import com.tencent.qqmini.sdk.action.GetPageStringAction;
import com.tencent.qqmini.sdk.action.SetViewVisibilityAction;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.WindowInfo;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.launcher.utils.LiuHaiUtils;
import com.tencent.qqmini.sdk.launcher.widget.VideoGestureRelativeLayout;
import com.tencent.qqmini.sdk.launcher.widget.VideoGestureRelativeLayout.VideoGestureListener;
import com.tencent.qqmini.sdk.utils.ImmersiveUtils;
import com.tencent.qqmini.sdk.widget.media.danmu.Barrage;
import com.tencent.qqmini.sdk.widget.media.danmu.BarrageView;

public class IVideoPlayerUIImpl
  extends FrameLayout
  implements Handler.Callback, IVideoPlayerUI
{
  private static final String TAG = "IVideoPlayerUIImpl";
  private Activity activity;
  private ImageView barrageIv;
  private ImageView bottomControlIv;
  private float brightness = 1.0F;
  private ImageView centerControlIv;
  private TextView centerSeekTv;
  private int componentLayoutScrollY = 0;
  private LinearLayout controlBar;
  private MiniAppVideoController controller;
  private RelativeLayout controllerPopContainer;
  private BarrageView danmuView;
  private ImageView fullScreenBackIv;
  private ImageView fullScreenIv;
  private TextView fullScreenTitleTv;
  private final Handler handler = new Handler(Looper.getMainLooper(), this);
  private boolean hasSetUp = false;
  private boolean isChangingProgress = true;
  private int lastNavBarVisibility = 8;
  private int lastTabBarVisibility = 8;
  private RelativeLayout loadingContainer;
  private WindowManager.LayoutParams mLayoutParams;
  private VideoGestureLayout mVideoGestureLayout;
  private Window mWindow;
  private ImageView muteIv;
  private int newProgress = 0;
  private TextView nowTimeTv;
  private int oldProgress = 0;
  private int oldVolume = 0;
  private FrameLayout playerPopContainer;
  private SeekBar playerSeekBar;
  private View playerView;
  private ViewGroup.LayoutParams smallLayoutParams;
  private TextView totalTimeTv;
  private FrameLayout videoActionContainer;
  private VideoGestureRelativeLayout videoGestureRelativeLayout;
  private ImageView videoPosterImg;
  private ImageView videoStatusImg;
  private View videoView;
  
  public IVideoPlayerUIImpl(@NonNull Activity paramActivity)
  {
    super(paramActivity);
    this.activity = paramActivity;
  }
  
  public IVideoPlayerUIImpl(@NonNull Activity paramActivity, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramActivity, paramAttributeSet);
    this.activity = paramActivity;
  }
  
  private void enterFullScreenMode(Activity paramActivity)
  {
    int i = paramActivity.getWindow().getDecorView().getSystemUiVisibility();
    if (Build.VERSION.SDK_INT >= 21) {
      i = 5894;
    } else if (Build.VERSION.SDK_INT >= 16) {
      i = 1798;
    }
    if (Build.VERSION.SDK_INT >= 19) {
      i |= 0x800;
    } else {
      i |= 0x1;
    }
    paramActivity.getWindow().getDecorView().setSystemUiVisibility(i);
  }
  
  private void hidePopCtrView()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 2003;
    this.handler.sendMessageDelayed(localMessage, 500L);
  }
  
  private void initDanmuView(MiniAppVideoConfig paramMiniAppVideoConfig)
  {
    if ((paramMiniAppVideoConfig.isShowBasicControl) && (paramMiniAppVideoConfig.enableDanmu))
    {
      this.danmuView = new BarrageView(this.activity, null);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      addView(this.danmuView, localLayoutParams);
      this.danmuView.setBarrages(paramMiniAppVideoConfig.barrages);
    }
  }
  
  private void resetOrientationForSmallScreen(Activity paramActivity, IMiniAppContext paramIMiniAppContext)
  {
    paramIMiniAppContext = GetPageStringAction.obtain(paramIMiniAppContext).getPageOrientation();
    int i;
    if (WindowInfo.ORIENTATION_AUTO.equals(paramIMiniAppContext)) {
      i = 4;
    } else if (WindowInfo.ORIENTATION_LANDSCAPE.equals(paramIMiniAppContext)) {
      i = 0;
    } else {
      i = 1;
    }
    paramActivity.setRequestedOrientation(i);
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
        QMLog.e("IVideoPlayerUIImpl", "smallScreen: ", paramActivity);
      }
    }
  }
  
  private void setOrientationForFullScreen(MiniAppVideoConfig paramMiniAppVideoConfig, Activity paramActivity, boolean paramBoolean)
  {
    int i;
    if (paramBoolean)
    {
      if ((paramMiniAppVideoConfig.direction != -90) && (paramMiniAppVideoConfig.direction != 270)) {
        i = 0;
      } else {
        i = 8;
      }
    }
    else if ((paramMiniAppVideoConfig.direction != 180) && (paramMiniAppVideoConfig.direction != -180)) {
      i = 1;
    } else {
      i = 9;
    }
    paramActivity.setRequestedOrientation(i);
  }
  
  private void updateVideoViewPosition(IMiniAppContext paramIMiniAppContext, boolean paramBoolean)
  {
    Activity localActivity = this.activity;
    if (localActivity != null)
    {
      LiuHaiUtils.initLiuHaiProperty(localActivity);
      j = LiuHaiUtils.getNotchInScreenHeight(this.activity);
    }
    else
    {
      j = 0;
    }
    int k = DisplayUtil.getRealHeight(getContext());
    int i = k;
    if (!paramBoolean)
    {
      i = k;
      if (LiuHaiUtils.sHasNotch) {
        i = k - j;
      }
    }
    int j = DisplayUtil.getScreenWidth(getContext());
    if (paramBoolean) {
      k = i;
    } else {
      k = j;
    }
    if (paramBoolean) {
      i = j;
    }
    if ((paramIMiniAppContext != null) && (paramIMiniAppContext.isMiniGame()))
    {
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
  }
  
  public void changeState()
  {
    this.bottomControlIv.performClick();
  }
  
  public void fullScreen(MiniAppVideoConfig paramMiniAppVideoConfig, IMiniAppContext paramIMiniAppContext, boolean paramBoolean, String paramString)
  {
    this.fullScreenBackIv.setVisibility(0);
    this.fullScreenTitleTv.setVisibility(0);
    if (paramMiniAppVideoConfig.hideTimeDesc)
    {
      this.totalTimeTv.setVisibility(0);
      this.nowTimeTv.setVisibility(0);
      this.playerSeekBar.setVisibility(0);
      this.totalTimeTv.setText(paramString);
    }
    if (paramIMiniAppContext != null)
    {
      this.lastNavBarVisibility = GetPageIntAction.obtain(paramIMiniAppContext).getNaviBarVisibility();
      this.lastTabBarVisibility = GetPageIntAction.obtain(paramIMiniAppContext).getTabBarVisibility();
      SetViewVisibilityAction.obtain(paramIMiniAppContext).setNaviBarVisibility(8);
      SetViewVisibilityAction.obtain(paramIMiniAppContext).setTabBarVisibility(8);
    }
    this.smallLayoutParams = ((CoverVideoView)getParent()).getLayoutParams();
    if (getParent().getParent() != null)
    {
      this.componentLayoutScrollY = ((ViewGroup)getParent().getParent()).getScrollY();
      ((ViewGroup)getParent().getParent()).scrollTo(0, 0);
    }
    updateVideoViewPosition(paramIMiniAppContext, paramBoolean);
    this.activity.getWindow().getDecorView().setSystemUiVisibility(2);
    setOrientationForFullScreen(paramMiniAppVideoConfig, this.activity, paramBoolean);
    enterFullScreenMode(this.activity);
    resetWindowIvDrawable(paramMiniAppVideoConfig);
  }
  
  public MiniAppVideoController getController()
  {
    return this.controller;
  }
  
  public int getGestureProgress()
  {
    return this.newProgress;
  }
  
  public boolean getIsBarrageOn()
  {
    BarrageView localBarrageView = this.danmuView;
    return (localBarrageView != null) && (localBarrageView.getVisibility() == 0);
  }
  
  public int getPlayerViewHeight()
  {
    return this.playerView.getHeight();
  }
  
  public int getPlayerViewWidth()
  {
    return this.playerView.getWidth();
  }
  
  public int getStatusImgVisibility()
  {
    ImageView localImageView = this.videoStatusImg;
    if (localImageView != null) {
      return localImageView.getVisibility();
    }
    return 8;
  }
  
  public FrameLayout getUI()
  {
    return this;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 2003)
    {
      this.controllerPopContainer.setVisibility(4);
      return true;
    }
    return false;
  }
  
  public void hideControllerPopContainer()
  {
    this.controllerPopContainer.setVisibility(8);
  }
  
  public void hideLoadingView()
  {
    this.loadingContainer.setVisibility(8);
  }
  
  public void hidePlayerStatusImg()
  {
    this.videoStatusImg.setVisibility(8);
  }
  
  public void hideVideoPosterImg()
  {
    this.videoPosterImg.setVisibility(8);
  }
  
  public void onBrightnessGesture(MiniAppVideoConfig paramMiniAppVideoConfig, MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (paramMiniAppVideoConfig.pageGesture)
    {
      if (paramMiniAppVideoConfig.isFullScreen) {
        return;
      }
      paramFloat2 = (paramMotionEvent1.getY() - paramMotionEvent2.getY()) / this.videoGestureRelativeLayout.getHeight() + this.brightness;
      if (paramFloat2 < 0.0F)
      {
        paramFloat1 = 0.0F;
      }
      else
      {
        paramFloat1 = paramFloat2;
        if (paramFloat2 > 1.0F) {
          paramFloat1 = 1.0F;
        }
      }
      paramMiniAppVideoConfig = this.mWindow;
      if (paramMiniAppVideoConfig != null)
      {
        paramMotionEvent1 = this.mLayoutParams;
        if (paramMotionEvent1 != null)
        {
          paramMotionEvent1.screenBrightness = paramFloat1;
          paramMiniAppVideoConfig.setAttributes(paramMotionEvent1);
        }
      }
      this.mVideoGestureLayout.setProgress((int)(paramFloat1 * 100.0F));
      this.mVideoGestureLayout.setImageResource(R.drawable.mini_sdk_video_brightness);
      this.mVideoGestureLayout.show();
    }
  }
  
  public void onCaptureImageSucceed(Canvas paramCanvas)
  {
    Object localObject = this.playerPopContainer;
    if ((localObject != null) && (((FrameLayout)localObject).getVisibility() == 0))
    {
      this.playerPopContainer.setDrawingCacheEnabled(true);
      this.playerPopContainer.buildDrawingCache();
      this.playerPopContainer.setDrawingCacheEnabled(false);
    }
    localObject = this.videoActionContainer;
    if ((localObject != null) && (((FrameLayout)localObject).getVisibility() == 0))
    {
      this.videoActionContainer.setDrawingCacheEnabled(true);
      this.videoActionContainer.buildDrawingCache();
      localObject = this.videoActionContainer.getDrawingCache();
      if (localObject != null) {
        paramCanvas.drawBitmap(Bitmap.createBitmap((Bitmap)localObject), 0.0F, 0.0F, null);
      }
      this.videoActionContainer.setDrawingCacheEnabled(false);
    }
  }
  
  public void onDoubleTapGesture(MiniAppVideoConfig paramMiniAppVideoConfig, boolean paramBoolean)
  {
    resetControlIvDrawable(paramBoolean);
    updatePopCtrView(paramMiniAppVideoConfig, paramBoolean);
  }
  
  public void onDown(int paramInt1, int paramInt2)
  {
    this.oldProgress = this.newProgress;
    this.oldVolume = paramInt1;
    WindowManager.LayoutParams localLayoutParams = this.mLayoutParams;
    if (localLayoutParams != null) {
      this.brightness = localLayoutParams.screenBrightness;
    }
    if (this.brightness == -1.0F) {
      this.brightness = paramInt2;
    }
  }
  
  public void onEndFF_REW(MotionEvent paramMotionEvent) {}
  
  public void onProgressChanged(String paramString)
  {
    this.centerSeekTv.setText(paramString);
    this.nowTimeTv.setText(paramString);
  }
  
  public void onProgressGesture(MiniAppVideoConfig paramMiniAppVideoConfig, MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (!paramMiniAppVideoConfig.enableProgressGesture) {
      return;
    }
    paramFloat1 = paramMotionEvent2.getX() - paramMotionEvent1.getX();
    if (paramFloat1 > 0.0F)
    {
      this.mVideoGestureLayout.setImageResource(R.drawable.mini_sdk_video_progress_ff);
      this.newProgress = ((int)(this.oldProgress + paramFloat1 / this.videoGestureRelativeLayout.getWidth() * 100.0F));
      if (this.newProgress > 100) {
        this.newProgress = 100;
      }
    }
    else
    {
      this.mVideoGestureLayout.setImageResource(R.drawable.mini_sdk_video_progress_fr);
      this.newProgress = ((int)(this.oldProgress + paramFloat1 / this.videoGestureRelativeLayout.getWidth() * 100.0F));
      if (this.newProgress < 0) {
        this.newProgress = 0;
      }
    }
    this.mVideoGestureLayout.setProgress(this.newProgress);
    this.mVideoGestureLayout.show();
  }
  
  public void onSingleTapGesture(MiniAppVideoConfig paramMiniAppVideoConfig, MotionEvent paramMotionEvent)
  {
    if (this.controllerPopContainer.getVisibility() == 4)
    {
      showPopCtrViewThenAutoHide(paramMiniAppVideoConfig);
      return;
    }
    if (this.controllerPopContainer.getVisibility() == 0) {
      hidePopCtrView();
    }
  }
  
  public void onStartTrackingTouch(MiniAppVideoConfig paramMiniAppVideoConfig)
  {
    this.isChangingProgress = true;
    this.centerSeekTv.setVisibility(0);
    this.centerSeekTv.setText("");
    showPopCtrViewNoAutoHide(paramMiniAppVideoConfig);
    if ((paramMiniAppVideoConfig.showCenterPlayBtn) && ("center".equals(paramMiniAppVideoConfig.playBtnPosition))) {
      this.centerControlIv.setVisibility(8);
    }
  }
  
  public void onStopTrackingTouch(MiniAppVideoConfig paramMiniAppVideoConfig)
  {
    this.isChangingProgress = false;
    this.loadingContainer.setVisibility(0);
    this.centerSeekTv.setVisibility(8);
    showPopCtrViewThenAutoHide(paramMiniAppVideoConfig);
    if ((paramMiniAppVideoConfig.showCenterPlayBtn) && ("center".equals(paramMiniAppVideoConfig.playBtnPosition))) {
      this.centerControlIv.setVisibility(0);
    }
  }
  
  public void onVolumeGesture(MiniAppVideoConfig paramMiniAppVideoConfig, MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2, int paramInt, AudioManager paramAudioManager)
  {
    if ((paramMiniAppVideoConfig.pageGesture) && (!paramMiniAppVideoConfig.isFullScreen))
    {
      if (paramInt == 0) {
        return;
      }
      int i = this.videoGestureRelativeLayout.getHeight() / paramInt;
      i = (int)((paramMotionEvent1.getY() - paramMotionEvent2.getY()) / i + this.oldVolume);
      if (paramAudioManager != null) {
        paramAudioManager.setStreamVolume(3, i, 4);
      }
      paramInt = (int)(i / paramInt * 100.0F);
      if (paramInt >= 50) {
        this.mVideoGestureLayout.setImageResource(R.drawable.mini_sdk_video_volume_higher);
      } else if (paramInt > 0) {
        this.mVideoGestureLayout.setImageResource(R.drawable.mini_sdk_video_volume_lower);
      } else {
        this.mVideoGestureLayout.setImageResource(R.drawable.mini_sdk_video_volume_off);
      }
      this.mVideoGestureLayout.setProgress(paramInt);
      this.mVideoGestureLayout.show();
    }
  }
  
  public void performClickControlBtn()
  {
    this.bottomControlIv.performClick();
  }
  
  public void release()
  {
    BarrageView localBarrageView = this.danmuView;
    if (localBarrageView != null) {
      localBarrageView.destroy();
    }
    this.hasSetUp = false;
  }
  
  public void resetBarrageDrawable(MiniAppVideoConfig paramMiniAppVideoConfig)
  {
    ImageView localImageView = this.barrageIv;
    int i;
    if (paramMiniAppVideoConfig.isBarrageOpen) {
      i = R.drawable.mini_sdk_player_barrage_open;
    } else {
      i = R.drawable.mini_sdk_player_barrage_close;
    }
    localImageView.setImageResource(i);
  }
  
  public void resetControlIvDrawable(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.bottomControlIv.setImageResource(R.drawable.mini_sdk_player_pause);
      this.centerControlIv.setImageResource(R.drawable.mini_sdk_player_pause);
      return;
    }
    this.bottomControlIv.setImageResource(R.drawable.mini_sdk_player_resume);
    this.centerControlIv.setImageResource(R.drawable.mini_sdk_player_resume);
  }
  
  public void resetMuteImage(MiniAppVideoConfig paramMiniAppVideoConfig, boolean paramBoolean)
  {
    if (!paramMiniAppVideoConfig.showMuteBtn)
    {
      this.muteIv.setVisibility(8);
      return;
    }
    paramMiniAppVideoConfig = this.muteIv;
    int i;
    if (paramBoolean) {
      i = R.drawable.mini_sdk_video_mute;
    } else {
      i = R.drawable.mini_sdk_video_unmute;
    }
    paramMiniAppVideoConfig.setImageResource(i);
    this.muteIv.setVisibility(0);
  }
  
  public void resetWindowIvDrawable(MiniAppVideoConfig paramMiniAppVideoConfig)
  {
    ImageView localImageView = this.fullScreenIv;
    int i;
    if (paramMiniAppVideoConfig.isFullScreen) {
      i = R.drawable.mini_sdk_player_shrink_back;
    } else {
      i = R.drawable.mini_sdk_player_stretch_back;
    }
    localImageView.setImageResource(i);
  }
  
  public void setController(MiniAppVideoController paramMiniAppVideoController)
  {
    this.controller = paramMiniAppVideoController;
  }
  
  public void setPoster(Bitmap paramBitmap)
  {
    ImageView localImageView = this.videoPosterImg;
    if (localImageView != null) {
      localImageView.setImageBitmap(paramBitmap);
    }
  }
  
  public void setPoster(Drawable paramDrawable)
  {
    ImageView localImageView = this.videoPosterImg;
    if (localImageView != null)
    {
      localImageView.setVisibility(0);
      this.videoPosterImg.setImageDrawable(paramDrawable);
      this.videoPosterImg.setScaleType(ImageView.ScaleType.FIT_XY);
    }
  }
  
  public void setProgressByPlayingTime(long paramLong1, long paramLong2)
  {
    long l = paramLong1;
    if (paramLong1 == 0L) {
      l = 1L;
    }
    SeekBar localSeekBar = this.playerSeekBar;
    localSeekBar.setProgress((int)(paramLong2 * localSeekBar.getMax() / l));
  }
  
  public void setSeekBarGone()
  {
    this.totalTimeTv.setVisibility(8);
    this.nowTimeTv.setVisibility(8);
    this.playerSeekBar.setVisibility(8);
  }
  
  public void setSeekBarInvisible()
  {
    this.totalTimeTv.setVisibility(4);
    this.nowTimeTv.setVisibility(4);
    this.playerSeekBar.setVisibility(4);
  }
  
  public void setSeekBarVisible()
  {
    this.totalTimeTv.setVisibility(0);
    this.nowTimeTv.setVisibility(0);
    this.playerSeekBar.setVisibility(0);
  }
  
  public void setUpUI(View.OnClickListener paramOnClickListener, VideoGestureRelativeLayout.VideoGestureListener paramVideoGestureListener, SeekBar.OnSeekBarChangeListener paramOnSeekBarChangeListener)
  {
    if (this.hasSetUp) {
      return;
    }
    this.hasSetUp = true;
    setTag("MiniAppVideoPlayer");
    this.mWindow = this.activity.getWindow();
    Object localObject = this.mWindow;
    if (localObject != null)
    {
      this.mLayoutParams = ((Window)localObject).getAttributes();
      localObject = this.mLayoutParams;
      if (localObject != null) {
        this.brightness = ((WindowManager.LayoutParams)localObject).screenBrightness;
      }
    }
    setTag("MiniAppVideoPlayer");
    this.playerView = LayoutInflater.from(this.activity).inflate(R.layout.mini_sdk_player_view, null);
    this.videoGestureRelativeLayout = ((VideoGestureRelativeLayout)this.playerView.findViewById(R.id.layout_videolayout));
    this.playerPopContainer = ((FrameLayout)this.playerView.findViewById(R.id.video_pop_container));
    this.videoPosterImg = ((ImageView)this.playerView.findViewById(R.id.video_img));
    this.videoStatusImg = ((ImageView)this.playerView.findViewById(R.id.play_status_img));
    this.controllerPopContainer = ((RelativeLayout)this.playerView.findViewById(R.id.video_playing_pop_container));
    this.nowTimeTv = ((TextView)this.playerView.findViewById(R.id.video_playing_tv_time_now));
    this.totalTimeTv = ((TextView)this.playerView.findViewById(R.id.video_playing_tv_time_total));
    this.bottomControlIv = ((ImageView)this.playerView.findViewById(R.id.video_playing_iv_control));
    this.centerControlIv = ((ImageView)this.playerView.findViewById(R.id.video_playing_iv_control_center));
    this.controlBar = ((LinearLayout)this.playerView.findViewById(R.id.video_playing_control_bar));
    this.fullScreenIv = ((ImageView)this.playerView.findViewById(R.id.video_playing_iv_window));
    this.playerSeekBar = ((SeekBar)this.playerView.findViewById(R.id.video_playing_bar));
    this.loadingContainer = ((RelativeLayout)this.playerView.findViewById(R.id.video_loading_container));
    this.barrageIv = ((ImageView)this.playerView.findViewById(R.id.video_playing_iv_barrage));
    this.centerSeekTv = ((TextView)this.playerView.findViewById(R.id.video_playing_tv_seek));
    this.fullScreenBackIv = ((ImageView)this.playerView.findViewById(R.id.video_playing_iv_back_fullscreen));
    this.fullScreenTitleTv = ((TextView)this.playerView.findViewById(R.id.video_playing_tv_title));
    this.muteIv = ((ImageView)this.playerView.findViewById(R.id.video_playing_iv_mute));
    this.videoActionContainer = ((FrameLayout)this.playerView.findViewById(R.id.video_action_container));
    if (Build.VERSION.SDK_INT > 15) {
      this.playerSeekBar.getThumb().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
    }
    if (paramOnClickListener != null)
    {
      this.videoStatusImg.setOnClickListener(paramOnClickListener);
      this.bottomControlIv.setOnClickListener(paramOnClickListener);
      this.centerControlIv.setOnClickListener(paramOnClickListener);
      this.fullScreenIv.setOnClickListener(paramOnClickListener);
      this.barrageIv.setOnClickListener(paramOnClickListener);
      this.fullScreenBackIv.setOnClickListener(paramOnClickListener);
      this.muteIv.setOnClickListener(paramOnClickListener);
    }
    this.mVideoGestureLayout = new VideoGestureLayout(this.activity);
    if (paramVideoGestureListener != null) {
      this.videoGestureRelativeLayout.setVideoGestureListener(paramVideoGestureListener);
    }
    if (paramOnSeekBarChangeListener != null) {
      this.playerSeekBar.setOnSeekBarChangeListener(paramOnSeekBarChangeListener);
    }
    addView(this.playerView);
  }
  
  public void setUpVideoView(View paramView, MiniAppVideoConfig paramMiniAppVideoConfig)
  {
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    this.videoView = paramView;
    this.videoView.setLayoutParams(localLayoutParams);
    this.videoView.setVisibility(0);
    initDanmuView(paramMiniAppVideoConfig);
    this.videoGestureRelativeLayout.removeAllViews();
    this.videoGestureRelativeLayout.addView(this.videoView);
    this.videoGestureRelativeLayout.setBackgroundColor(-16777216);
    paramView = new FrameLayout.LayoutParams(DisplayUtil.dip2px(this.activity, 100.0F), DisplayUtil.dip2px(this.activity, 100.0F));
    paramView.gravity = 17;
    this.videoGestureRelativeLayout.addView(this.mVideoGestureLayout, paramView);
  }
  
  public void showBarrageNextTime(String paramString, int paramInt)
  {
    BarrageView localBarrageView = this.danmuView;
    if (localBarrageView != null) {
      localBarrageView.showBarrageNextTime(new Barrage(paramString, paramInt, 0L));
    }
  }
  
  public void showLoadingView()
  {
    this.loadingContainer.setVisibility(0);
  }
  
  public void showPopCtrViewNoAutoHide(MiniAppVideoConfig paramMiniAppVideoConfig)
  {
    if (paramMiniAppVideoConfig.isShowBasicControl)
    {
      Object localObject = this.controllerPopContainer;
      int i = 0;
      ((RelativeLayout)localObject).setVisibility(0);
      localObject = this.controlBar;
      if (!paramMiniAppVideoConfig.isShowControlBar) {
        i = 8;
      }
      ((LinearLayout)localObject).setVisibility(i);
    }
    else
    {
      this.controllerPopContainer.setVisibility(4);
    }
    this.handler.removeMessages(2003);
  }
  
  public void showPopCtrViewThenAutoHide(MiniAppVideoConfig paramMiniAppVideoConfig)
  {
    showPopCtrViewNoAutoHide(paramMiniAppVideoConfig);
    paramMiniAppVideoConfig = Message.obtain();
    paramMiniAppVideoConfig.what = 2003;
    this.handler.sendMessageDelayed(paramMiniAppVideoConfig, 5000L);
  }
  
  public void smallScreen(IMiniAppContext paramIMiniAppContext, MiniAppVideoConfig paramMiniAppVideoConfig)
  {
    if (!paramMiniAppVideoConfig.isBusyInChangeScreen)
    {
      if (!paramMiniAppVideoConfig.isFullScreen) {
        return;
      }
      paramMiniAppVideoConfig.isFullScreen = false;
      this.fullScreenBackIv.setVisibility(8);
      this.fullScreenTitleTv.setVisibility(8);
      if (paramMiniAppVideoConfig.hideTimeDesc)
      {
        this.totalTimeTv.setVisibility(8);
        this.nowTimeTv.setVisibility(8);
        this.playerSeekBar.setVisibility(8);
      }
      if (paramIMiniAppContext != null)
      {
        SetViewVisibilityAction.obtain(paramIMiniAppContext).setNaviBarVisibility(this.lastNavBarVisibility);
        SetViewVisibilityAction.obtain(paramIMiniAppContext).setTabBarVisibility(this.lastTabBarVisibility);
      }
      this.activity.getWindow().clearFlags(1024);
      if (paramIMiniAppContext != null)
      {
        resetOrientationForSmallScreen(this.activity, paramIMiniAppContext);
        resetStatusbarForSmallScreen(this.activity, paramIMiniAppContext);
      }
      paramMiniAppVideoConfig.lastSmallScreenTime = System.currentTimeMillis();
      paramMiniAppVideoConfig.isBusyInChangeScreen = true;
      this.handler.postDelayed(new IVideoPlayerUIImpl.1(this, paramMiniAppVideoConfig), 200L);
      resetWindowIvDrawable(paramMiniAppVideoConfig);
    }
  }
  
  public void updateCenterBtn(MiniAppVideoConfig paramMiniAppVideoConfig)
  {
    if (paramMiniAppVideoConfig.showCenterPlayBtn)
    {
      this.videoStatusImg.setVisibility(0);
      this.videoPosterImg.setVisibility(0);
      return;
    }
    this.videoStatusImg.setVisibility(8);
    this.videoPosterImg.setVisibility(8);
  }
  
  public void updateControllerView(MiniAppVideoConfig paramMiniAppVideoConfig)
  {
    ImageView localImageView = this.barrageIv;
    int j = 0;
    int i;
    if (localImageView != null)
    {
      if (paramMiniAppVideoConfig.showDanmuBtn) {
        i = 0;
      } else {
        i = 4;
      }
      localImageView.setVisibility(i);
    }
    if ("center".equals(paramMiniAppVideoConfig.playBtnPosition))
    {
      localImageView = this.centerControlIv;
      if (paramMiniAppVideoConfig.showCenterPlayBtn) {
        i = j;
      } else {
        i = 8;
      }
      localImageView.setVisibility(i);
      this.bottomControlIv.setVisibility(8);
    }
    else
    {
      this.centerControlIv.setVisibility(8);
      this.bottomControlIv.setVisibility(0);
    }
    if (!TextUtils.isEmpty(paramMiniAppVideoConfig.title)) {
      this.fullScreenTitleTv.setText(paramMiniAppVideoConfig.title);
    }
  }
  
  public void updateDanmuTime(long paramLong)
  {
    BarrageView localBarrageView = this.danmuView;
    if (localBarrageView != null) {
      localBarrageView.updateTime(paramLong);
    }
  }
  
  public void updateDanmuView(MiniAppVideoConfig paramMiniAppVideoConfig)
  {
    if (this.danmuView != null)
    {
      if (paramMiniAppVideoConfig.isBarrageOpen)
      {
        this.danmuView.setVisibility(4);
        paramMiniAppVideoConfig.isBarrageOpen = false;
        return;
      }
      this.danmuView.setVisibility(0);
      paramMiniAppVideoConfig.isBarrageOpen = true;
    }
  }
  
  public void updatePlayingTime(String paramString)
  {
    this.nowTimeTv.setText(paramString);
  }
  
  public void updatePopCtrView(MiniAppVideoConfig paramMiniAppVideoConfig, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      showPopCtrViewThenAutoHide(paramMiniAppVideoConfig);
      return;
    }
    showPopCtrViewNoAutoHide(paramMiniAppVideoConfig);
  }
  
  public void updateTotalTimeText(String paramString)
  {
    this.totalTimeTv.setText(paramString);
  }
  
  public void updateVideoGestureSetting(MiniAppVideoConfig paramMiniAppVideoConfig)
  {
    VideoGestureRelativeLayout localVideoGestureRelativeLayout = this.videoGestureRelativeLayout;
    if (localVideoGestureRelativeLayout != null)
    {
      localVideoGestureRelativeLayout.setEnablePageGesture(paramMiniAppVideoConfig.pageGesture);
      this.videoGestureRelativeLayout.setEnableProgressGesture(paramMiniAppVideoConfig.enableProgressGesture);
      this.videoGestureRelativeLayout.setEnablePlayGesture(paramMiniAppVideoConfig.enablePlayGesture);
    }
  }
  
  public void updateVideoPosition(MiniAppVideoConfig paramMiniAppVideoConfig, boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("config.isFullScreen = ");
    ((StringBuilder)localObject).append(paramMiniAppVideoConfig.isFullScreen);
    QMLog.e("fullScreen - updateVideoPosition", ((StringBuilder)localObject).toString());
    if (!paramMiniAppVideoConfig.isFullScreen)
    {
      if (paramBoolean)
      {
        localObject = new RelativeLayout.LayoutParams(DisplayUtil.dip2px(this.activity, paramMiniAppVideoConfig.videoWidth), DisplayUtil.dip2px(this.activity, paramMiniAppVideoConfig.videoHeight));
        ((RelativeLayout.LayoutParams)localObject).leftMargin = DisplayUtil.dip2px(this.activity, paramMiniAppVideoConfig.videoX);
        ((RelativeLayout.LayoutParams)localObject).topMargin = DisplayUtil.dip2px(this.activity, paramMiniAppVideoConfig.videoY);
        ((CoverVideoView)getParent()).setLayoutParams((ViewGroup.LayoutParams)localObject);
        return;
      }
      localObject = new FrameLayout.LayoutParams(DisplayUtil.dip2px(this.activity, paramMiniAppVideoConfig.videoWidth), DisplayUtil.dip2px(this.activity, paramMiniAppVideoConfig.videoHeight));
      ((FrameLayout.LayoutParams)localObject).leftMargin = DisplayUtil.dip2px(this.activity, paramMiniAppVideoConfig.videoX);
      ((FrameLayout.LayoutParams)localObject).topMargin = DisplayUtil.dip2px(this.activity, paramMiniAppVideoConfig.videoY);
      ((CoverVideoView)getParent()).setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.media.IVideoPlayerUIImpl
 * JD-Core Version:    0.7.0.1
 */