package com.tencent.mobileqq.kandian.biz.gifvideo.base.video;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView.ScaleType;
import android.widget.SeekBar;
import androidx.annotation.UiThread;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.utils.RIJThreadHandler;
import com.tencent.mobileqq.kandian.base.utils.ReadInJoyDisplayUtils;
import com.tencent.mobileqq.kandian.base.video.player.ErrorCode;
import com.tencent.mobileqq.kandian.base.video.player.api.IPlayer;
import com.tencent.mobileqq.kandian.base.video.player.api.IVideoView;
import com.tencent.mobileqq.kandian.base.view.widget.ZImageView;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.widget.NativeReadInjoyImageView;
import com.tencent.mobileqq.kandian.biz.gifvideo.utils.IStrategy;
import com.tencent.mobileqq.kandian.biz.gifvideo.utils.IStrategy.URLCallback;
import com.tencent.mobileqq.kandian.biz.pts.data.Util;
import com.tencent.mobileqq.kandian.glue.utils.RIJSmartCropUtils;
import com.tencent.mobileqq.kandian.glue.viola.event.ViolaEvent;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class VideoView
  extends FrameLayout
  implements VideoPlayController.OnStateChangeListener, Runnable
{
  public static final int MSG_FOR_UPDATE_VIDEO_PLAY_POSITION = -2;
  public static final double OLD_CARD_RATIO = 1.77D;
  public static int PLAYMODE_AUTO = 1;
  public static int PLAYMODE_CLICK = 2;
  public static int PLAYMODE_DISABLE = 3;
  public static int PLAYMODE_SCROOL = 0;
  public static final int PROGRESS_REFRESH_INTERNAL = 100;
  public static final String PTS_NORMAL_VIDEO_PLAY_EVENT_NAME = "NormalVideoPlay";
  public static final String PTS_VIDEO_PLAY_EVENT_NAME = "PtsVideoPlay";
  public static final double RATIO_THRESHOLD = 0.2D;
  public static final String THREE_VIDEO_EVENT_NAME = "OneDragThreeFirstVideoPlayInfoNotificationName";
  public static final String VIDEO_ROW_KEY = "rowkey";
  public static final String VIDEO_STATUS = "video_status";
  private static Drawable mLoadingDrawable;
  private AbsBaseArticleInfo articleInfo;
  SimpleEventReceiver<ViolaEvent> eventReceiver = new VideoView.9(this);
  private Runnable hideCoverRunnable = new VideoView.5(this);
  private int iconHeight;
  private int iconWidth;
  private boolean isManualPause;
  private boolean isPlayIconVisible = false;
  public int[] lastLocation = new int[2];
  private AtomicInteger mAction = new AtomicInteger(0);
  private Context mContext;
  private NativeReadInjoyImageView mCoverImageView;
  private String mCoverUrl;
  private VideoView.OnCheckShownListener mOnCheckShownListener;
  private VideoView.OnProgressChangedListener mOnProgressChangedListener;
  private NativeReadInjoyImageView mPlayIconImageView;
  private String mPlayIconUrl;
  protected Handler mProgressHandler = new Handler(Looper.getMainLooper());
  private AtomicInteger mState = new AtomicInteger(0);
  private String mVid;
  private String mVideoUrl;
  private IVideoView mVideoView;
  public boolean needInterceptGlobalLayoutChanged = false;
  private ObjectAnimator playCoverAnimator;
  private ObjectAnimator playIconAnimator;
  private int playMode = PLAYMODE_SCROOL;
  private List<String> reportList = new ArrayList();
  private Runnable showCoverRunnable = new VideoView.6(this);
  private boolean showVideoMask = true;
  private long startTime = 0L;
  public String suffix;
  public String tag = "ptsVideoView";
  private Handler uiHandler = new VideoView.2(this, Looper.myLooper());
  private boolean useVid = true;
  private View.OnClickListener videoCoverClickListener = new VideoView.4(this);
  private VideoMaskController videoMaskController;
  private VideoPlayController videoPlayController;
  private VideoPlayListener videoPlayListener;
  private View.OnClickListener videoViewClickListener = new VideoView.3(this);
  private FrameLayout videoViewLayout;
  private int xyAxis = 0;
  
  public VideoView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public VideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public VideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void changeMaskUI(int paramInt)
  {
    VideoMaskController localVideoMaskController = this.videoMaskController;
    if (localVideoMaskController != null)
    {
      boolean bool;
      if (paramInt == 7) {
        bool = true;
      } else {
        bool = false;
      }
      localVideoMaskController.a(bool);
    }
  }
  
  private void doAutoPlayClick()
  {
    pause();
    ReadInJoyUtils.a(this.articleInfo, true, this);
  }
  
  private void doNormalClick()
  {
    if (isPlaying())
    {
      setManualPause(true);
      pause();
      return;
    }
    if (this.isManualPause)
    {
      setManualPause(false);
      resume();
    }
  }
  
  private static Drawable getLoadingDrawable()
  {
    if (mLoadingDrawable == null) {
      mLoadingDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130853313);
    }
    return mLoadingDrawable;
  }
  
  private void handleViolaEvent(ViolaEvent paramViolaEvent)
  {
    if ("OneDragThreeFirstVideoPlayInfoNotificationName".equalsIgnoreCase(paramViolaEvent.eventName))
    {
      parseEvent(paramViolaEvent);
      return;
    }
    if (("PtsVideoPlay".equalsIgnoreCase(paramViolaEvent.eventName)) || ("NormalVideoPlay".equalsIgnoreCase(paramViolaEvent.eventName))) {
      parseVideoEvent(paramViolaEvent);
    }
  }
  
  private void hideCoverAnim()
  {
    if (this.mCoverImageView != null)
    {
      String str = this.tag;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("hidecover alpha: ");
      localStringBuilder.append(this.mCoverImageView.getAlpha());
      QLog.d(str, 1, localStringBuilder.toString());
      if (this.playIconAnimator == null)
      {
        this.playIconAnimator = ObjectAnimator.ofFloat(this.mCoverImageView, "alpha", new float[] { 1.0F, 0.0F });
        this.playIconAnimator.setDuration(300L);
        this.playIconAnimator.addListener(new VideoView.7(this));
      }
      if (this.playCoverAnimator == null)
      {
        this.playCoverAnimator = this.playIconAnimator.clone();
        this.playCoverAnimator.setTarget(this.mPlayIconImageView);
      }
      this.playIconAnimator.start();
      this.playCoverAnimator.start();
    }
  }
  
  private void initVideoCover()
  {
    this.mCoverImageView = new NativeReadInjoyImageView(this.mContext);
    this.mCoverImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    if (Build.VERSION.SDK_INT >= 21) {
      this.mCoverImageView.setClipToOutline(true);
    }
    addView(this.mCoverImageView, -1, -1);
    this.mCoverImageView.setOnClickListener(this.videoCoverClickListener);
    setVideoCover();
  }
  
  private void initVideoFrameLayout()
  {
    if (this.videoViewLayout == null)
    {
      this.videoViewLayout = new FrameLayout(this.mContext);
      this.videoViewLayout.setContentDescription("videoviewFL");
      this.videoViewLayout.setBackgroundDrawable(getResources().getDrawable(2130842687));
      addView(this.videoViewLayout, -1, -1);
    }
  }
  
  private void initVideoMaskController()
  {
    if ((this.showVideoMask) && (this.videoMaskController == null))
    {
      this.videoMaskController = new VideoMaskController(getContext(), this, this.videoPlayController.i());
      VideoMaskController localVideoMaskController = this.videoMaskController;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(VideoMaskController.class.getSimpleName());
      localStringBuilder.append(".");
      localStringBuilder.append(this.suffix);
      localVideoMaskController.a(localStringBuilder.toString());
      this.videoMaskController.p().r().s().a(this.articleInfo);
    }
  }
  
  private void initVideoPlayIcon()
  {
    this.mPlayIconImageView = new NativeReadInjoyImageView(this.mContext);
    this.mPlayIconImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    Object localObject = new FrameLayout.LayoutParams(-2, -2);
    int i = this.iconWidth;
    if (i != 0) {
      ((FrameLayout.LayoutParams)localObject).width = i;
    }
    i = this.iconHeight;
    if (i != 0) {
      ((FrameLayout.LayoutParams)localObject).height = i;
    }
    ((FrameLayout.LayoutParams)localObject).gravity = 17;
    addView(this.mPlayIconImageView, (ViewGroup.LayoutParams)localObject);
    localObject = this.mPlayIconImageView;
    if (shouldShowPlayIcon()) {
      i = 0;
    } else {
      i = 4;
    }
    ((NativeReadInjoyImageView)localObject).setVisibility(i);
    this.mPlayIconImageView.setImageResource(2130843744);
    setPlayIcon();
  }
  
  private void initVideoView()
  {
    IVideoView localIVideoView = this.mVideoView;
    if ((localIVideoView != null) && (localIVideoView.a() != null))
    {
      this.mVideoView.a().setBackgroundColor(Color.parseColor("#000000"));
      this.videoViewLayout.removeAllViews();
      this.videoViewLayout.addView(this.mVideoView.a(), -1, -1);
      setClipChildren(false);
      ((ViewGroup)getParent()).setClipChildren(false);
      setVideoViewClickListener();
    }
  }
  
  private void onIdle()
  {
    displayCover();
    hideLoading();
  }
  
  private void parseEvent(ViolaEvent paramViolaEvent)
  {
    if (paramViolaEvent.data != null)
    {
      if (this.articleInfo == null) {
        return;
      }
      String str = this.tag;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("parseEvent, eventName=");
      localStringBuilder.append(paramViolaEvent.eventName);
      localStringBuilder.append(" data=");
      localStringBuilder.append(paramViolaEvent.data);
      QLog.d(str, 1, localStringBuilder.toString());
      if (!paramViolaEvent.data.optString("rowkey").equalsIgnoreCase(this.articleInfo.innerUniqueID)) {
        return;
      }
      try
      {
        str = paramViolaEvent.data.optString("currentPlayTime");
        paramViolaEvent = paramViolaEvent.data.optString("playRate");
        int i = Integer.parseInt(str) * 1000;
        float f = Float.parseFloat(paramViolaEvent);
        if (this.videoMaskController != null) {
          this.videoMaskController.a(f);
        }
        if (this.videoPlayController != null)
        {
          if (isPlaying())
          {
            this.videoPlayController.d(i);
            return;
          }
          this.videoPlayController.a(this.articleInfo.innerUniqueID, i);
          return;
        }
      }
      catch (Exception paramViolaEvent)
      {
        str = this.tag;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("parseEvent, msg=");
        localStringBuilder.append(paramViolaEvent);
        QLog.d(str, 1, localStringBuilder.toString());
      }
    }
  }
  
  private void parseVideoEvent(ViolaEvent paramViolaEvent)
  {
    try
    {
      if (this.articleInfo != null)
      {
        if (TextUtils.isEmpty(this.articleInfo.innerUniqueID)) {
          return;
        }
        str = paramViolaEvent.data.optString("rowkey");
        boolean bool = paramViolaEvent.data.optBoolean("video_status");
        if ((!this.articleInfo.innerUniqueID.equalsIgnoreCase(str)) && (bool) && (isPlaying())) {
          pause();
        }
      }
      else {}
    }
    catch (Exception paramViolaEvent)
    {
      String str = this.tag;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("pparseVideoEvent,msg=");
      localStringBuilder.append(paramViolaEvent);
      QLog.d(str, 1, localStringBuilder.toString());
    }
  }
  
  private void removeHideCoverRunnable()
  {
    ThreadManager.getUIHandler().removeCallbacks(this.hideCoverRunnable);
    ObjectAnimator localObjectAnimator = this.playCoverAnimator;
    if (localObjectAnimator != null) {
      localObjectAnimator.cancel();
    }
    localObjectAnimator = this.playIconAnimator;
    if (localObjectAnimator != null) {
      localObjectAnimator.cancel();
    }
  }
  
  private void removeShowCoverRunnable()
  {
    ThreadManager.getUIHandler().removeCallbacks(this.showCoverRunnable);
  }
  
  private void setPlayIcon()
  {
    if ((this.mPlayIconImageView != null) && (!TextUtils.isEmpty(this.mPlayIconUrl))) {
      try
      {
        this.mPlayIconImageView.setImagePlaceHolder(getLoadingDrawable()).setImage(new URL(this.mPlayIconUrl));
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private void setVideoCover()
  {
    if ((this.mCoverImageView != null) && (!TextUtils.isEmpty(this.mCoverUrl))) {
      try
      {
        ReadInJoyDisplayUtils.a(this.mCoverImageView, new URL(this.mCoverUrl), this.mContext);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private boolean shouldShowPlayIcon()
  {
    return (this.isPlayIconVisible) && (!VideoPlayController.a.f());
  }
  
  private void updateXyAxis(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (!Util.f(paramAbsBaseArticleInfo)) {
      return;
    }
    if (paramAbsBaseArticleInfo.mVideoJsonHeight > 0)
    {
      if (paramAbsBaseArticleInfo.mVideoJsonWidth <= 0) {
        return;
      }
      double d1 = paramAbsBaseArticleInfo.mVideoJsonWidth;
      double d2 = paramAbsBaseArticleInfo.mVideoJsonHeight;
      Double.isNaN(d1);
      Double.isNaN(d2);
      if (Math.abs(d1 / d2 - 1.77D) < 0.2D) {
        this.xyAxis = 2;
      }
    }
  }
  
  public void clearVideoViewClick()
  {
    IVideoView localIVideoView = this.mVideoView;
    if ((localIVideoView != null) && (localIVideoView.a() != null)) {
      this.mVideoView.a().setOnClickListener(null);
    }
  }
  
  @UiThread
  public void destroy()
  {
    QLog.d(this.tag, 1, "destroy");
    this.videoPlayController.o();
  }
  
  public void displayCover()
  {
    removeHideCoverRunnable();
    removeShowCoverRunnable();
    if (RIJThreadHandler.f())
    {
      this.showCoverRunnable.run();
      return;
    }
    ThreadManager.getUIHandler().post(this.showCoverRunnable);
  }
  
  public int getAction()
  {
    return this.videoPlayController.w().get();
  }
  
  public AbsBaseArticleInfo getArticleInfo()
  {
    return this.articleInfo;
  }
  
  public long getCurrentProgress()
  {
    long l;
    if (this.videoPlayController.i() != null) {
      l = this.videoPlayController.i().o();
    } else {
      l = 0L;
    }
    return l / 1000L;
  }
  
  public float getCurrentRatio()
  {
    if (this.videoPlayController.i() != null) {
      return this.videoPlayController.i().a();
    }
    return 0.0F;
  }
  
  public int getCurrentState()
  {
    return this.videoPlayController.v().get();
  }
  
  public long getPercentage()
  {
    if (this.videoPlayController.i() != null) {
      return this.videoPlayController.i().o();
    }
    return 0L;
  }
  
  public int getPlayMode()
  {
    return this.playMode;
  }
  
  public String getVideoVid()
  {
    return this.mVid;
  }
  
  public IVideoView getVideoView()
  {
    return this.mVideoView;
  }
  
  public void hideCover()
  {
    removeHideCoverRunnable();
    removeShowCoverRunnable();
    ThreadManager.getUIHandler().post(this.hideCoverRunnable);
  }
  
  public void hideLoading()
  {
    QLog.d(this.tag, 1, "hideLoading");
    VideoMaskController localVideoMaskController = this.videoMaskController;
    if (localVideoMaskController != null) {
      localVideoMaskController.v();
    }
  }
  
  public void hideVideoError()
  {
    QLog.d(this.tag, 1, "hideVideoError");
    VideoMaskController localVideoMaskController = this.videoMaskController;
    if (localVideoMaskController != null) {
      localVideoMaskController.t();
    }
  }
  
  public void init()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(new Random().nextInt());
    localStringBuilder.append("");
    this.suffix = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.tag);
    localStringBuilder.append(".");
    localStringBuilder.append(this.suffix);
    this.tag = localStringBuilder.toString();
    this.mContext = getContext();
    setClickable(true);
    setBackgroundColor(Color.parseColor("#000000"));
    initVideoFrameLayout();
    initVideoCover();
    initVideoPlayIcon();
    initPTSVideoPlayManager();
    initVideoMaskController();
  }
  
  public void initPTSVideoPlayManager()
  {
    this.videoPlayController = new VideoPlayController(this, this.mState, this.mAction);
    this.videoPlayController.g(this.suffix);
    this.videoPlayController.a(this);
  }
  
  public boolean isMute()
  {
    return this.videoPlayController.d();
  }
  
  public boolean isPlaying()
  {
    return this.videoPlayController.v().get() == 7;
  }
  
  public boolean isShown()
  {
    if (this.mOnCheckShownListener != null) {
      return (super.isShown()) && (this.mOnCheckShownListener.a());
    }
    return super.isShown();
  }
  
  @UiThread
  public void onComplete() {}
  
  @UiThread
  public void onDestroy()
  {
    QLog.d(this.tag, 2, "onDestroy");
    removeShowCoverRunnable();
    removeHideCoverRunnable();
    hideLoading();
    Object localObject = this.mVideoView;
    if ((localObject != null) && (((IVideoView)localObject).a() != null)) {
      removeView(this.mVideoView.a());
    }
    this.isManualPause = false;
    this.mVideoView = null;
    this.mVideoUrl = "";
    this.mCoverUrl = "";
    this.videoPlayListener = null;
    removePlayProgressMessage();
    localObject = this.videoMaskController;
    if (localObject != null) {
      ((VideoMaskController)localObject).i();
    }
    this.videoPlayController.b(this);
    SimpleEventBus.getInstance().unRegisterReceiver(this.eventReceiver);
  }
  
  @UiThread
  public void onError()
  {
    hideLoading();
    String str1 = ErrorCode.a(this.videoPlayController.g(), this.videoPlayController.h(), this.videoPlayController.f());
    String str2 = HardCodeUtil.a(2131913610);
    String str3 = this.tag;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("errorMsg: ");
    localStringBuilder.append(str1);
    QLog.d(str3, 1, localStringBuilder.toString());
    showVideoError(1, str1, str2);
  }
  
  public void onFinishTemporaryDetach()
  {
    super.onFinishTemporaryDetach();
    setVideoCover();
    setPlayIcon();
  }
  
  @UiThread
  public void onInit()
  {
    initVideoView();
    updateXyAxis(this.articleInfo);
    this.videoPlayController.b(this.xyAxis);
    VideoMaskController localVideoMaskController = this.videoMaskController;
    if (localVideoMaskController != null)
    {
      localVideoMaskController.a(this.videoPlayController.i());
      this.videoMaskController.g();
    }
    SimpleEventBus.getInstance().registerReceiver(this.eventReceiver);
  }
  
  @UiThread
  public void onPause()
  {
    removePlayProgressMessage();
    VideoMaskController localVideoMaskController = this.videoMaskController;
    if (localVideoMaskController != null) {
      localVideoMaskController.o();
    }
  }
  
  @UiThread
  public void onPlay()
  {
    postPlayProgressMessage();
    hideCover();
    hideLoading();
    if (this.mOnProgressChangedListener != null) {
      this.mProgressHandler.postDelayed(this, 500L);
    }
    VideoMaskController localVideoMaskController = this.videoMaskController;
    if (localVideoMaskController != null) {
      localVideoMaskController.n();
    }
    postPlayProgressMessage();
    hideVideoError();
  }
  
  public void onScrollFromList(boolean paramBoolean)
  {
    if (this.playMode == PLAYMODE_AUTO)
    {
      if ((paramBoolean) && (this.mAction.get() != 3)) {
        startPlay();
      }
      if ((!paramBoolean) && (this.mAction.get() != 6)) {
        stop();
      }
    }
  }
  
  @UiThread
  public void onSeekComplete()
  {
    if (this.mOnProgressChangedListener != null) {
      this.mProgressHandler.postDelayed(this, 500L);
    }
  }
  
  public void onStateChanged(int paramInt1, int paramInt2)
  {
    ThreadManager.getUIHandler().post(new VideoView.1(this, paramInt2));
  }
  
  @UiThread
  public void onStop()
  {
    displayCover();
    this.mProgressHandler.removeCallbacksAndMessages(null);
    Object localObject = this.videoMaskController;
    if (localObject != null) {
      ((VideoMaskController)localObject).h();
    }
    removePlayProgressMessage();
    hideLoading();
    localObject = this.mVideoView;
    if (localObject != null) {
      ((IVideoView)localObject).c();
    }
    localObject = this.videoPlayListener;
    if (localObject != null) {
      ((VideoPlayListener)localObject).b();
    }
  }
  
  public void openVideo()
  {
    ThreadManager.getSubThreadHandler().post(new VideoView.8(this));
  }
  
  @UiThread
  public void pause()
  {
    QLog.d(this.tag, 2, "pause");
    this.videoPlayController.m();
  }
  
  public void postPlayProgressMessage()
  {
    removePlayProgressMessage();
    if (this.uiHandler != null)
    {
      Message localMessage = Message.obtain();
      localMessage.what = -2;
      this.uiHandler.sendMessageDelayed(localMessage, 100L);
    }
  }
  
  public void removePlayProgressMessage()
  {
    Handler localHandler = this.uiHandler;
    if (localHandler != null) {
      localHandler.removeMessages(-2);
    }
  }
  
  public void requestUrlByVid(IStrategy paramIStrategy, IStrategy.URLCallback paramURLCallback)
  {
    this.videoPlayController.a(paramIStrategy, paramURLCallback);
  }
  
  public void resetVideoMaskController()
  {
    VideoMaskController localVideoMaskController = this.videoMaskController;
    if (localVideoMaskController != null) {
      localVideoMaskController.j();
    }
  }
  
  @UiThread
  public void resume()
  {
    this.videoPlayController.n();
  }
  
  public void run()
  {
    if (this.mOnProgressChangedListener != null)
    {
      this.mProgressHandler.postDelayed(this, 500L);
      long l2 = 0L;
      long l1;
      try
      {
        l1 = this.videoPlayController.i().o();
      }
      catch (Exception localException)
      {
        l1 = l2;
        if (QLog.isColorLevel())
        {
          String str = this.tag;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("run: ");
          localStringBuilder.append(QLog.getStackTraceString(localException));
          QLog.e(str, 2, localStringBuilder.toString());
          l1 = l2;
        }
      }
      this.mOnProgressChangedListener.a(l1);
    }
  }
  
  public void setArticleInfo(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    this.articleInfo = paramAbsBaseArticleInfo;
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mTitle != null))
    {
      localObject = paramAbsBaseArticleInfo.mTitle.substring(0, Math.min(paramAbsBaseArticleInfo.mTitle.length(), 2));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ptsVideoView.");
      localStringBuilder.append(this.suffix);
      localStringBuilder.append(".");
      localStringBuilder.append((String)localObject);
      this.tag = localStringBuilder.toString();
      this.videoPlayController.g(this.tag);
    }
    Object localObject = this.videoMaskController;
    if (localObject != null) {
      ((VideoMaskController)localObject).a(paramAbsBaseArticleInfo);
    }
    this.videoPlayController.a(paramAbsBaseArticleInfo);
    this.videoPlayController.a(this);
  }
  
  @Deprecated
  public void setAutoPlayMode(int paramInt) {}
  
  public void setCoverUrl(String paramString)
  {
    this.mCoverUrl = paramString;
    if ((getHeight() > 0) && (getHeight() > 0)) {
      this.mCoverUrl = RIJSmartCropUtils.a(this.mCoverUrl, getWidth(), getHeight());
    }
    setVideoCover();
  }
  
  public void setDtPgid(String paramString)
  {
    this.videoPlayController.e(paramString);
  }
  
  public void setLoop(boolean paramBoolean)
  {
    this.videoPlayController.a(paramBoolean);
  }
  
  public void setManualPause(boolean paramBoolean)
  {
    this.isManualPause = paramBoolean;
    this.videoPlayController.c(paramBoolean);
  }
  
  public void setMute(boolean paramBoolean)
  {
    this.videoPlayController.b(paramBoolean);
  }
  
  public void setOnCheckShownListener(VideoView.OnCheckShownListener paramOnCheckShownListener)
  {
    this.mOnCheckShownListener = paramOnCheckShownListener;
  }
  
  public void setOnProgressChangedListener(VideoView.OnProgressChangedListener paramOnProgressChangedListener)
  {
    this.mOnProgressChangedListener = paramOnProgressChangedListener;
  }
  
  public void setPlayIconSize(int paramInt1, int paramInt2)
  {
    this.iconWidth = Utils.dp2px(paramInt1);
    this.iconHeight = Utils.dp2px(paramInt2);
    Object localObject = this.mPlayIconImageView;
    if (localObject != null)
    {
      localObject = (FrameLayout.LayoutParams)((NativeReadInjoyImageView)localObject).getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).width = this.iconWidth;
      ((FrameLayout.LayoutParams)localObject).height = this.iconHeight;
      this.mPlayIconImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
  
  public void setPlayIconUrl(String paramString)
  {
    this.mPlayIconUrl = paramString;
    setPlayIcon();
  }
  
  public void setPlayIconVisible(boolean paramBoolean)
  {
    this.isPlayIconVisible = paramBoolean;
    NativeReadInjoyImageView localNativeReadInjoyImageView = this.mPlayIconImageView;
    if (localNativeReadInjoyImageView != null)
    {
      int i;
      if (shouldShowPlayIcon()) {
        i = 0;
      } else {
        i = 4;
      }
      localNativeReadInjoyImageView.setVisibility(i);
    }
  }
  
  public void setPlayMode(int paramInt)
  {
    this.playMode = paramInt;
  }
  
  public void setReportR5(String paramString)
  {
    this.videoPlayController.f(paramString);
  }
  
  public void setScaleType(int paramInt)
  {
    int i = 2;
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        i = 0;
      }
    }
    else {
      i = 1;
    }
    try
    {
      this.videoPlayController.b(i);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setShowVideoMask(boolean paramBoolean)
  {
    this.showVideoMask = paramBoolean;
  }
  
  public void setUseVid(boolean paramBoolean)
  {
    this.useVid = paramBoolean;
  }
  
  public void setVideoBusiType(int paramInt)
  {
    this.videoPlayController.a(paramInt);
  }
  
  public void setVideoPlayListener(VideoPlayListener paramVideoPlayListener)
  {
    this.videoPlayController.a(paramVideoPlayListener);
  }
  
  public void setVideoUrl(String paramString)
  {
    this.mVideoUrl = paramString;
    this.videoPlayController.a(this.mVideoUrl);
  }
  
  public void setVideoVid(String paramString)
  {
    try
    {
      if ((this.mVid != null) && (!TextUtils.equals(this.mVid, paramString))) {
        displayCover();
      }
      this.mVid = paramString;
      this.videoPlayController.b(paramString);
      return;
    }
    finally {}
  }
  
  public void setVideoView(IVideoView paramIVideoView)
  {
    this.mVideoView = paramIVideoView;
  }
  
  public void setVideoViewClickListener()
  {
    IVideoView localIVideoView = this.mVideoView;
    if ((localIVideoView != null) && (localIVideoView.a() != null)) {
      this.mVideoView.a().setOnClickListener(this.videoViewClickListener);
    }
  }
  
  public void showLoading()
  {
    QLog.d(this.tag, 1, "showLoading");
    VideoMaskController localVideoMaskController = this.videoMaskController;
    if (localVideoMaskController != null) {
      localVideoMaskController.u();
    }
    this.mPlayIconImageView.setVisibility(4);
  }
  
  public void showVideoError(int paramInt, String paramString1, String paramString2)
  {
    Object localObject = this.tag;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("showVideoError: ");
    localStringBuilder.append(paramInt);
    QLog.d((String)localObject, 1, new Object[] { localStringBuilder.toString(), paramString1, paramString2 });
    localObject = this.videoMaskController;
    if (localObject != null) {
      ((VideoMaskController)localObject).a(paramInt, paramString1, paramString2);
    }
  }
  
  @UiThread
  public boolean startPlay()
  {
    return startPlay(3);
  }
  
  public boolean startPlay(int paramInt)
  {
    QLog.d(this.tag, 2, "receive startPlay");
    this.videoPlayController.c(paramInt);
    return true;
  }
  
  @UiThread
  public void stop()
  {
    String str = this.tag;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("receive stop current action is ");
    localStringBuilder.append(this.mAction.get());
    QLog.d(str, 2, localStringBuilder.toString());
    setManualPause(false);
    this.videoPlayController.l();
  }
  
  public void updateProgress(int paramInt)
  {
    VideoPlayController localVideoPlayController = this.videoPlayController;
    if (localVideoPlayController != null) {
      localVideoPlayController.e(paramInt);
    }
  }
  
  public void updateSeekBarImmediately()
  {
    IPlayer localIPlayer = this.videoPlayController.i();
    if ((localIPlayer != null) && (this.videoMaskController != null))
    {
      long l1 = localIPlayer.o();
      long l2 = localIPlayer.n();
      double d = (float)l1 * 100.0F / (float)l2;
      Double.isNaN(d);
      int i = Math.min((int)(d + 0.5D) + 1, 100);
      this.videoMaskController.b().setProgress(i);
      this.videoPlayController.t();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.gifvideo.base.video.VideoView
 * JD-Core Version:    0.7.0.1
 */