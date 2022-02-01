package com.tencent.mobileqq.qzoneplayer.ui;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.oskplayer.util.PlayerUtils;
import java.lang.reflect.Method;
import java.util.Formatter;
import java.util.Locale;

public class VideoControllerView
  extends FrameLayout
{
  protected static final int FADE_OUT = 1;
  private static String LOG_NAME = "@lovelybone";
  protected static final int SET_PROGRESS = 3;
  protected static final int SHOW_PROGRESS = 2;
  private static final String TAG = "VideoControllerView";
  public static int sDefaultTimeout = 5000;
  private static HandlerThread sVideoControllerViewHandlerThread;
  private int curFullscreenButtonDrawableRes;
  private int curLandscapeButtonDrawableRes;
  private String currentStringName;
  protected ViewGroup mAnchor;
  protected Context mContext;
  private TextView mCurrentTime;
  private boolean mDragging;
  private TextView mDuration;
  private StringBuilder mFormatBuilder;
  private Formatter mFormatter;
  private ImageButton mFullscreenButton;
  protected View.OnClickListener mFullscreenListener = new VideoControllerView.4(this);
  protected Handler mHandler;
  private View.OnClickListener mPauseListener = new VideoControllerView.3(this);
  protected VideoControllerView.MediaPlayerControl mPlayer;
  protected ProgressBar mProgress;
  protected View mRoot;
  private SeekBar.OnSeekBarChangeListener mSeekBarChangeListener;
  protected SeekBar.OnSeekBarChangeListener mSeekListener = new VideoControllerView.6(this);
  protected volatile boolean mShowing;
  private View.OnClickListener mStreamSelectListener;
  private ImageButton mSwitchLandscapeButton;
  protected View.OnClickListener mSwitchLandscapeListener = new VideoControllerView.5(this);
  public ImageButton mVideoDanmakuSwitch;
  protected int mVideoDuration;
  public ImageButton mVideoOrigin;
  protected PlayerResources playerResources;
  private int seekBarrier = -1;
  
  public VideoControllerView(Context paramContext, AttributeSet paramAttributeSet, PlayerResources paramPlayerResources)
  {
    super(paramContext, paramAttributeSet);
    this.mRoot = null;
    this.mContext = paramContext;
    this.playerResources = paramPlayerResources;
    maybeInitHandlerThread();
    initHandler();
  }
  
  public VideoControllerView(Context paramContext, PlayerResources paramPlayerResources)
  {
    this(paramContext, true, paramPlayerResources);
  }
  
  public VideoControllerView(Context paramContext, boolean paramBoolean, PlayerResources paramPlayerResources)
  {
    super(paramContext);
    this.mContext = paramContext;
    this.playerResources = paramPlayerResources;
    maybeInitHandlerThread();
    initHandler();
  }
  
  private void destroyHandler()
  {
    Handler localHandler = this.mHandler;
    if (localHandler != null) {
      localHandler.removeCallbacksAndMessages(null);
    }
  }
  
  private boolean hasSmartBar()
  {
    if (!Build.MANUFACTURER.equals("Meizu")) {
      return false;
    }
    try
    {
      boolean bool = ((Boolean)Class.forName("android.os.Build").getMethod("hasSmartBar", new Class[0]).invoke(null, new Object[0])).booleanValue();
      return bool;
    }
    catch (Exception localException)
    {
      label44:
      break label44;
    }
    if (Build.DEVICE.equals("mx2")) {
      return true;
    }
    if ((!Build.DEVICE.equals("mx")) && (Build.DEVICE.equals("m9"))) {}
    return false;
  }
  
  private void initHandler()
  {
    Object localObject = this.mHandler;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacksAndMessages(null);
    }
    localObject = sVideoControllerViewHandlerThread;
    if (localObject != null)
    {
      this.mHandler = new VideoControllerView.MessageHandler(((HandlerThread)localObject).getLooper(), this);
      return;
    }
    this.mHandler = new VideoControllerView.MessageHandler(Looper.getMainLooper(), this);
  }
  
  private boolean isNotSupportFullscreen()
  {
    return Build.MODEL.equals("Lenovo A788T");
  }
  
  private void maybeInitHandlerThread()
  {
    HandlerThread localHandlerThread = sVideoControllerViewHandlerThread;
    if ((localHandlerThread == null) || (!localHandlerThread.isAlive()))
    {
      sVideoControllerViewHandlerThread = new HandlerThread("VideoControllerViewHandlerThread", -2);
      sVideoControllerViewHandlerThread.start();
    }
  }
  
  private int setProgress()
  {
    return setProgress(-1);
  }
  
  protected void disableUnsupportedButtons()
  {
    VideoControllerView.MediaPlayerControl localMediaPlayerControl = this.mPlayer;
    if (localMediaPlayerControl == null) {
      return;
    }
    try
    {
      if ((this.mFullscreenButton != null) && (!localMediaPlayerControl.enableToggleFullScreen())) {
        this.mFullscreenButton.setVisibility(8);
      }
      if ((this.mSwitchLandscapeButton != null) && (!this.mPlayer.enableToggleLandscape())) {
        this.mSwitchLandscapeButton.setVisibility(8);
      }
      return;
    }
    catch (IncompatibleClassChangeError localIncompatibleClassChangeError) {}
  }
  
  public void doPauseResume()
  {
    VideoControllerView.MediaPlayerControl localMediaPlayerControl = this.mPlayer;
    if (localMediaPlayerControl == null) {
      return;
    }
    if (!localMediaPlayerControl.canPausePlay()) {
      return;
    }
    if (this.mPlayer.isPlayComplete())
    {
      this.mPlayer.seekTo(0);
      this.mPlayer.start();
    }
    else if (this.mPlayer.isPlaying())
    {
      this.mPlayer.pause();
    }
    else
    {
      this.mPlayer.start();
    }
    updatePausePlay();
    show();
  }
  
  public void doToggleFullscreen()
  {
    VideoControllerView.MediaPlayerControl localMediaPlayerControl = this.mPlayer;
    if (localMediaPlayerControl == null) {
      return;
    }
    localMediaPlayerControl.toggleFullScreen();
  }
  
  protected void doToggleLandscape()
  {
    VideoControllerView.MediaPlayerControl localMediaPlayerControl = this.mPlayer;
    if (localMediaPlayerControl == null) {
      return;
    }
    localMediaPlayerControl.toggleLandscape();
  }
  
  public View getRootView()
  {
    return this.mRoot;
  }
  
  public void hide()
  {
    ViewGroup localViewGroup = this.mAnchor;
    if (localViewGroup == null) {
      return;
    }
    try
    {
      localViewGroup.removeView(this);
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      label18:
      break label18;
    }
    PlayerUtils.log(3, "MediaController", "already removed");
    this.mShowing = false;
  }
  
  protected void initControllerView(View paramView)
  {
    this.mFullscreenButton = ((ImageButton)paramView.findViewById(this.playerResources.getViewId(555)));
    Object localObject = this.mFullscreenButton;
    if (localObject != null)
    {
      ((ImageButton)localObject).setOnClickListener(this.mFullscreenListener);
      if ((hasSmartBar()) || (isNotSupportFullscreen())) {
        this.mFullscreenButton.setVisibility(8);
      }
    }
    this.mSwitchLandscapeButton = ((ImageButton)paramView.findViewById(this.playerResources.getViewId(554)));
    localObject = this.mSwitchLandscapeButton;
    if (localObject != null) {
      ((ImageButton)localObject).setOnClickListener(this.mSwitchLandscapeListener);
    }
    this.mProgress = ((ProgressBar)paramView.findViewById(this.playerResources.getViewId(556)));
    localObject = this.mProgress;
    if (localObject != null)
    {
      if ((localObject instanceof SeekBar)) {
        ((SeekBar)localObject).setOnSeekBarChangeListener(this.mSeekListener);
      }
      this.mProgress.setMax(1000);
    }
    this.mDuration = ((TextView)paramView.findViewById(this.playerResources.getViewId(557)));
    this.mCurrentTime = ((TextView)paramView.findViewById(this.playerResources.getViewId(558)));
    this.mFormatBuilder = new StringBuilder();
    this.mFormatter = new Formatter(this.mFormatBuilder, Locale.getDefault());
    this.mDuration.setOnTouchListener(new VideoControllerView.1(this));
    if (Build.VERSION.SDK_INT >= 11) {
      this.mCurrentTime.setAlpha(0.8F);
    }
    this.mVideoOrigin = ((ImageButton)paramView.findViewById(this.playerResources.getViewId(579)));
    this.mVideoDanmakuSwitch = ((ImageButton)paramView.findViewById(this.playerResources.getViewId(580)));
  }
  
  public boolean isShowing()
  {
    return this.mShowing;
  }
  
  protected View makeControllerView()
  {
    this.mRoot = ((LayoutInflater)this.mContext.getSystemService("layout_inflater")).inflate(this.playerResources.getLayoutId(2), null);
    initControllerView(this.mRoot);
    return this.mRoot;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    View localView = this.mRoot;
    if (localView != null) {
      initControllerView(localView);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    show(sDefaultTimeout);
    return true;
  }
  
  public boolean onTrackballEvent(MotionEvent paramMotionEvent)
  {
    show(sDefaultTimeout);
    return false;
  }
  
  public void postSetProgress()
  {
    Handler localHandler = this.mHandler;
    if (localHandler != null) {
      localHandler.sendEmptyMessage(3);
    }
  }
  
  public void resetDraggingState()
  {
    this.mDragging = false;
  }
  
  public void setAnchorView(ViewGroup paramViewGroup)
  {
    this.mAnchor = paramViewGroup;
    paramViewGroup = new FrameLayout.LayoutParams(-1, -1);
    removeAllViews();
    addView(makeControllerView(), paramViewGroup);
  }
  
  public void setCurrentStreamName(String paramString)
  {
    this.currentStringName = paramString;
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    ProgressBar localProgressBar = this.mProgress;
    if (localProgressBar != null) {
      localProgressBar.setEnabled(paramBoolean);
    }
    disableUnsupportedButtons();
    super.setEnabled(paramBoolean);
  }
  
  public void setFullscreenButtonVisible(int paramInt)
  {
    ImageButton localImageButton = this.mFullscreenButton;
    if (localImageButton != null) {
      localImageButton.setVisibility(paramInt);
    }
  }
  
  public void setMediaPlayer(VideoControllerView.MediaPlayerControl paramMediaPlayerControl)
  {
    this.mPlayer = paramMediaPlayerControl;
    if (this.mPlayer != null)
    {
      updatePausePlay();
      updateFullScreen();
      updateLandscapeIndicator();
    }
  }
  
  public int setProgress(int paramInt)
  {
    Object localObject = this.mPlayer;
    if ((localObject != null) && (!this.mDragging))
    {
      if (((VideoControllerView.MediaPlayerControl)localObject).isLoading()) {
        return 0;
      }
      int i = paramInt;
      if (paramInt == -1) {
        i = this.mPlayer.getCurrentPosition();
      }
      int j = this.mPlayer.getDuration();
      if (j > 0) {
        this.mVideoDuration = j;
      }
      paramInt = i;
      if (j > 0)
      {
        paramInt = i;
        if (i > j) {
          paramInt = j;
        }
      }
      int k = this.seekBarrier;
      i = paramInt;
      if (k >= 0)
      {
        i = paramInt;
        if (paramInt >= k) {
          i = 0;
        }
      }
      localObject = this.mProgress;
      if (localObject != null)
      {
        if (j > 0) {
          ((ProgressBar)localObject).setProgress((int)(i * 1000L / j));
        }
        paramInt = this.mPlayer.getBufferPercentage();
        this.mProgress.setSecondaryProgress(paramInt * 10);
      }
      PlayerUtils.runOnUiThread(new VideoControllerView.2(this, i));
      return i;
    }
    return 0;
  }
  
  public void setSeekBarChangeListener(SeekBar.OnSeekBarChangeListener paramOnSeekBarChangeListener)
  {
    this.mSeekBarChangeListener = paramOnSeekBarChangeListener;
  }
  
  public void setSeekBarrier(int paramInt)
  {
    this.seekBarrier = paramInt;
  }
  
  public void show()
  {
    show(sDefaultTimeout);
  }
  
  public void show(int paramInt)
  {
    if ((!this.mShowing) && (this.mAnchor != null))
    {
      postSetProgress();
      disableUnsupportedButtons();
      if ((this.mAnchor instanceof RelativeLayout))
      {
        localObject = new RelativeLayout.LayoutParams(-1, -2);
        ((RelativeLayout.LayoutParams)localObject).addRule(12);
      }
      else
      {
        localObject = new FrameLayout.LayoutParams(-1, -2, 80);
      }
      this.mAnchor.addView(this, (ViewGroup.LayoutParams)localObject);
      this.mShowing = true;
    }
    updatePausePlay();
    updateFullScreen();
    updateLandscapeIndicator();
    updateStreamNameButton();
    this.mHandler.removeMessages(2);
    this.mHandler.sendEmptyMessage(2);
    Object localObject = this.mHandler.obtainMessage(1);
    this.mHandler.removeMessages(1);
    if (paramInt != 0) {
      this.mHandler.sendMessageDelayed((Message)localObject, paramInt);
    }
  }
  
  public void updateFullScreen()
  {
    if ((this.mRoot != null) && (this.mFullscreenButton != null))
    {
      VideoControllerView.MediaPlayerControl localMediaPlayerControl = this.mPlayer;
      if (localMediaPlayerControl == null) {
        return;
      }
      if (localMediaPlayerControl.isFullScreen())
      {
        if (this.curFullscreenButtonDrawableRes != 1098)
        {
          this.mFullscreenButton.setImageResource(this.playerResources.getDrawableId(1098));
          this.curFullscreenButtonDrawableRes = 1098;
          return;
        }
        this.mFullscreenButton.setImageResource(this.playerResources.getDrawableId(1098));
        return;
      }
      if (this.curFullscreenButtonDrawableRes != 1099)
      {
        this.mFullscreenButton.setImageResource(this.playerResources.getDrawableId(1099));
        this.curFullscreenButtonDrawableRes = 1099;
        return;
      }
      this.mFullscreenButton.setImageResource(this.playerResources.getDrawableId(1099));
    }
  }
  
  public void updateLandscapeIndicator()
  {
    if ((this.mRoot != null) && (this.mSwitchLandscapeButton != null))
    {
      VideoControllerView.MediaPlayerControl localMediaPlayerControl = this.mPlayer;
      if (localMediaPlayerControl == null) {
        return;
      }
      if (localMediaPlayerControl.isLandscape())
      {
        if (this.curLandscapeButtonDrawableRes != 1097)
        {
          this.mSwitchLandscapeButton.setImageResource(this.playerResources.getDrawableId(1097));
          this.curLandscapeButtonDrawableRes = 1097;
        }
      }
      else if (this.curLandscapeButtonDrawableRes != 1096)
      {
        this.mSwitchLandscapeButton.setImageResource(this.playerResources.getDrawableId(1096));
        this.curLandscapeButtonDrawableRes = 1096;
      }
    }
  }
  
  public void updatePausePlay()
  {
    if (this.mRoot != null)
    {
      VideoControllerView.MediaPlayerControl localMediaPlayerControl = this.mPlayer;
      if (localMediaPlayerControl == null) {
        return;
      }
      localMediaPlayerControl.updatePlayPauseButton();
    }
  }
  
  protected void updateStreamNameButton() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qzoneplayer.ui.VideoControllerView
 * JD-Core Version:    0.7.0.1
 */