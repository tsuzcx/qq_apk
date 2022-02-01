package com.tencent.mobileqq.kandian.biz.gifvideo.base.video;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.utils.ReadInJoyDisplayUtils;
import com.tencent.mobileqq.kandian.base.video.player.api.IPlayer;
import com.tencent.mobileqq.kandian.base.video.player.api.IVideoView;
import com.tencent.mobileqq.kandian.biz.common.widget.NativeReadInjoyImageView;
import com.tencent.mobileqq.kandian.biz.gifvideo.utils.VideoAudioControlUtil;
import com.tencent.mobileqq.kandian.biz.gifvideo.utils.VideoReportUtil;
import com.tencent.mobileqq.kandian.biz.pts.data.Util;
import com.tencent.mobileqq.kandian.biz.video.playfeedback.MsgLayoutHelper;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/gifvideo/base/video/VideoMaskController;", "", "context", "Landroid/content/Context;", "rootView", "Lcom/tencent/mobileqq/kandian/biz/gifvideo/base/video/VideoView;", "videoPlayer", "Lcom/tencent/mobileqq/kandian/base/video/player/api/IPlayer;", "(Landroid/content/Context;Lcom/tencent/mobileqq/kandian/biz/gifvideo/base/video/VideoView;Lcom/tencent/mobileqq/kandian/base/video/player/api/IPlayer;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "articleInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "hideVideoMaskRunnable", "Ljava/lang/Runnable;", "<set-?>", "", "isSeeking", "()Z", "lastProgress", "", "lastX", "lastY", "Landroid/widget/ImageButton;", "loadingButton", "getLoadingButton", "()Landroid/widget/ImageButton;", "maskShowDuration", "", "msgLayoutHelper", "Lcom/tencent/mobileqq/kandian/biz/video/playfeedback/MsgLayoutHelper;", "getMsgLayoutHelper", "()Lcom/tencent/mobileqq/kandian/biz/video/playfeedback/MsgLayoutHelper;", "setMsgLayoutHelper", "(Lcom/tencent/mobileqq/kandian/biz/video/playfeedback/MsgLayoutHelper;)V", "Lcom/tencent/mobileqq/kandian/biz/common/widget/NativeReadInjoyImageView;", "muteButton", "getMuteButton", "()Lcom/tencent/mobileqq/kandian/biz/common/widget/NativeReadInjoyImageView;", "onTouchListener", "Landroid/view/View$OnTouchListener;", "getOnTouchListener", "()Landroid/view/View$OnTouchListener;", "setOnTouchListener", "(Landroid/view/View$OnTouchListener;)V", "Landroid/widget/TextView;", "playDuration", "getPlayDuration", "()Landroid/widget/TextView;", "Landroid/widget/ImageView;", "playIcon", "getPlayIcon", "()Landroid/widget/ImageView;", "retryClickListener", "Landroid/view/View$OnClickListener;", "getRetryClickListener", "()Landroid/view/View$OnClickListener;", "setRetryClickListener", "(Landroid/view/View$OnClickListener;)V", "rootVideoView", "Landroid/widget/SeekBar;", "seekBar", "getSeekBar", "()Landroid/widget/SeekBar;", "seekBarChangeListener", "com/tencent/mobileqq/kandian/biz/gifvideo/base/video/VideoMaskController$seekBarChangeListener$1", "Lcom/tencent/mobileqq/kandian/biz/gifvideo/base/video/VideoMaskController$seekBarChangeListener$1;", "showLoadingProgressRunnable", "getShowLoadingProgressRunnable", "()Ljava/lang/Runnable;", "speedRatio", "", "speedRatioButton", "getSpeedRatioButton", "tvSeekTime", "getTvSeekTime", "setTvSeekTime", "(Landroid/widget/TextView;)V", "vid", "videoControlMask", "Landroid/widget/FrameLayout;", "getVideoControlMask", "()Landroid/widget/FrameLayout;", "setVideoControlMask", "(Landroid/widget/FrameLayout;)V", "videoMaskContainer", "getVideoMaskContainer", "setVideoMaskContainer", "getVideoPlayer", "()Lcom/tencent/mobileqq/kandian/base/video/player/api/IPlayer;", "setVideoPlayer", "(Lcom/tencent/mobileqq/kandian/base/video/player/api/IPlayer;)V", "volumeChangeReceiver", "Landroid/content/BroadcastReceiver;", "changeSeekbarStyle", "", "useCircleBar", "doOnDestroy", "expandTouchArea", "view", "Landroid/view/View;", "top", "bottom", "getCurrentProgress", "getCurrentRatio", "hideLoading", "hideMask", "hideSeekTime", "hideVideoError", "initArticleInfo", "initDuration", "initMuteButton", "initSeekBar", "initSpeedRatioButton", "initVolumeChangeReceiver", "notifyVideoViewProgress", "progress", "onInit", "onPauseVideo", "onStartPlayVideo", "onStop", "reportSeekBar", "resetMuteButtonUI", "resetSeekBar", "resetSeekTimeTextView", "resetUI", "resumePlayVideo", "seekPlayer", "setSeekTimeTextView", "shouldIntercept", "parent", "Landroid/view/ViewGroup;", "v", "event", "Landroid/view/MotionEvent;", "px", "showLoading", "showMask", "showSeekTime", "showVideoError", "msgType", "msg", "btnText", "showVideoMask", "showVideoMaskForAWhile", "showMillis", "switchMuteState", "switchSpeedRatio", "ratio", "updateAutoPlayLayout", "isPlay", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class VideoMaskController
{
  public static final VideoMaskController.Companion a;
  private float jdField_a_of_type_Float = 1.0F;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = 3000L;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  @NotNull
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = (View.OnClickListener)new VideoMaskController.retryClickListener.1(this);
  @NotNull
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = (View.OnTouchListener)new VideoMaskController.onTouchListener.1(this);
  @NotNull
  public FrameLayout a;
  @NotNull
  private ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  @NotNull
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  @NotNull
  private SeekBar jdField_a_of_type_AndroidWidgetSeekBar;
  @NotNull
  public TextView a;
  @Nullable
  private IPlayer jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIPlayer;
  @NotNull
  private NativeReadInjoyImageView jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetNativeReadInjoyImageView;
  private final VideoMaskController.seekBarChangeListener.1 jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseVideoVideoMaskController$seekBarChangeListener$1 = new VideoMaskController.seekBarChangeListener.1(this);
  private VideoView jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseVideoVideoView;
  @NotNull
  public MsgLayoutHelper a;
  private AbsBaseArticleInfo jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  @NotNull
  private String jdField_a_of_type_JavaLangString = "VideoMaskController";
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  @NotNull
  private FrameLayout jdField_b_of_type_AndroidWidgetFrameLayout;
  @NotNull
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  @NotNull
  private NativeReadInjoyImageView jdField_b_of_type_ComTencentMobileqqKandianBizCommonWidgetNativeReadInjoyImageView;
  @NotNull
  private final Runnable jdField_b_of_type_JavaLangRunnable = (Runnable)new VideoMaskController.showLoadingProgressRunnable.1(this);
  private String jdField_b_of_type_JavaLangString = "";
  private int c;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseVideoVideoMaskController$Companion = new VideoMaskController.Companion(null);
  }
  
  public VideoMaskController(@NotNull Context paramContext, @NotNull VideoView paramVideoView, @Nullable IPlayer paramIPlayer)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2131560389, null);
    if (paramContext != null)
    {
      this.jdField_b_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramContext);
      paramContext = this.jdField_b_of_type_AndroidWidgetFrameLayout.findViewById(2131366912);
      Intrinsics.checkExpressionValueIsNotNull(paramContext, "videoMaskContainer.findV…yId(R.id.fl_control_mask)");
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramContext);
      paramContext = this.jdField_b_of_type_AndroidWidgetFrameLayout.findViewById(2131376906);
      Intrinsics.checkExpressionValueIsNotNull(paramContext, "videoMaskContainer.findV…Id(R.id.sb_play_progress)");
      this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)paramContext);
      paramContext = this.jdField_b_of_type_AndroidWidgetFrameLayout.findViewById(2131379871);
      Intrinsics.checkExpressionValueIsNotNull(paramContext, "videoMaskContainer.findViewById(R.id.tv_seek_time)");
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext);
      paramContext = this.jdField_b_of_type_AndroidWidgetFrameLayout.findViewById(2131369426);
      Intrinsics.checkExpressionValueIsNotNull(paramContext, "videoMaskContainer.findV…ById(R.id.iv_mute_button)");
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetNativeReadInjoyImageView = ((NativeReadInjoyImageView)paramContext);
      paramContext = this.jdField_b_of_type_AndroidWidgetFrameLayout.findViewById(2131369503);
      Intrinsics.checkExpressionValueIsNotNull(paramContext, "videoMaskContainer.findV…id.iv_speed_ratio_button)");
      this.jdField_b_of_type_ComTencentMobileqqKandianBizCommonWidgetNativeReadInjoyImageView = ((NativeReadInjoyImageView)paramContext);
      paramContext = this.jdField_b_of_type_AndroidWidgetFrameLayout.findViewById(2131370372);
      Intrinsics.checkExpressionValueIsNotNull(paramContext, "videoMaskContainer.findV…ById(R.id.loading_button)");
      this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)paramContext);
      paramContext = this.jdField_b_of_type_AndroidWidgetFrameLayout.findViewById(2131372833);
      Intrinsics.checkExpressionValueIsNotNull(paramContext, "videoMaskContainer.findViewById(R.id.play_icon)");
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramContext);
      paramContext = this.jdField_b_of_type_AndroidWidgetFrameLayout.findViewById(2131372832);
      Intrinsics.checkExpressionValueIsNotNull(paramContext, "videoMaskContainer.findV…wById(R.id.play_duration)");
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramContext);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseVideoVideoView = paramVideoView;
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIPlayer = paramIPlayer;
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedbackMsgLayoutHelper = new MsgLayoutHelper((View)this.jdField_b_of_type_AndroidWidgetFrameLayout, this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramVideoView.addView((View)this.jdField_b_of_type_AndroidWidgetFrameLayout);
      d();
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.widget.FrameLayout");
  }
  
  private final void a(int paramInt)
  {
    VideoView localVideoView = this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseVideoVideoView;
    if (localVideoView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rootVideoView");
    }
    localVideoView.updateProgress(paramInt);
  }
  
  private final void a(long paramLong)
  {
    w();
    if (this.jdField_a_of_type_JavaLangRunnable == null) {
      this.jdField_a_of_type_JavaLangRunnable = ((Runnable)new VideoMaskController.showVideoMaskForAWhile.1(this));
    }
    if (Util.e(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo)) {
      return;
    }
    Runnable localRunnable = this.jdField_a_of_type_JavaLangRunnable;
    if (localRunnable != null)
    {
      this.jdField_b_of_type_AndroidWidgetFrameLayout.removeCallbacks(localRunnable);
      this.jdField_b_of_type_AndroidWidgetFrameLayout.postDelayed(localRunnable, paramLong);
    }
  }
  
  private final void a(View paramView, float paramFloat1, float paramFloat2)
  {
    ViewParent localViewParent = paramView.getParent();
    if ((localViewParent != null) && ((localViewParent instanceof View))) {
      ((View)localViewParent).post((Runnable)new VideoMaskController.expandTouchArea..inlined.let.lambda.1(localViewParent, this, paramView, paramFloat1, paramFloat2));
    }
  }
  
  private final void b(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseVideoVideoView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rootVideoView");
    }
    if (((VideoView)localObject).getContext() != null)
    {
      localObject = this.jdField_a_of_type_AndroidWidgetSeekBar;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("seekBar");
      }
      ((SeekBar)localObject).setSelected(paramBoolean);
    }
  }
  
  private final void n()
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
    if (localAbsBaseArticleInfo != null)
    {
      int i = localAbsBaseArticleInfo.getVideoDuration();
      this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)ReadInJoyDisplayUtils.a(i));
    }
  }
  
  private final void o()
  {
    this.jdField_a_of_type_Boolean = true;
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localTextView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("tvSeekTime");
    }
    localTextView.setVisibility(0);
  }
  
  private final void p()
  {
    this.jdField_a_of_type_Boolean = false;
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localTextView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("tvSeekTime");
    }
    localTextView.setVisibility(8);
  }
  
  private final void q()
  {
    if (this.jdField_a_of_type_AndroidWidgetSeekBar == null) {
      Intrinsics.throwUninitializedPropertyAccessException("seekBar");
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIPlayer;
    if (localObject != null)
    {
      SeekBar localSeekBar = this.jdField_a_of_type_AndroidWidgetSeekBar;
      if (localSeekBar == null) {
        Intrinsics.throwUninitializedPropertyAccessException("seekBar");
      }
      int i = localSeekBar.getProgress();
      long l = ((IPlayer)localObject).a();
      if (l > 0L) {
        ((IPlayer)localObject).a((int)((float)(i * l) / 100.0F), 3);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseVideoVideoView;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("rootVideoView");
      }
      ((VideoView)localObject).startPlay();
    }
  }
  
  private final void r()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null)
    {
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = ((BroadcastReceiver)new VideoMaskController.initVolumeChangeReceiver.1(this));
      QLog.i(this.jdField_a_of_type_JavaLangString, 1, "[initVolumeChangeReceiver]");
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tencent.mobileqq.kandian.biz.gifvideo.VideoMaskController.ACTION_DOWN_AUDIO_BUTTON");
      VideoView localVideoView = this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseVideoVideoView;
      if (localVideoView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("rootVideoView");
      }
      localVideoView.getContext().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    }
  }
  
  private final void s()
  {
    boolean bool = VideoAudioControlUtil.a.b();
    if (bool) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetNativeReadInjoyImageView.setImageResource(2130843125);
    } else {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetNativeReadInjoyImageView.setImageResource(2130843126);
    }
    VideoView localVideoView = this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseVideoVideoView;
    if (localVideoView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rootVideoView");
    }
    localVideoView.setMute(bool);
  }
  
  private final void t()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseVideoVideoView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rootVideoView");
    }
    boolean bool = ((VideoView)localObject).isMute();
    localObject = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[switchMuteState] isMute: ");
    localStringBuilder.append(bool);
    localStringBuilder.append(" to ");
    localStringBuilder.append(bool ^ true);
    QLog.i((String)localObject, 1, localStringBuilder.toString());
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseVideoVideoView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rootVideoView");
    }
    ((VideoView)localObject).setMute(bool ^ true);
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseVideoVideoView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rootVideoView");
    }
    if (((VideoView)localObject).isMute())
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetNativeReadInjoyImageView.setImageResource(2130843125);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetNativeReadInjoyImageView.setImageResource(2130843126);
  }
  
  private final void u()
  {
    a(this.jdField_a_of_type_Float + 0.5F);
  }
  
  private final void v()
  {
    FrameLayout localFrameLayout = this.jdField_a_of_type_AndroidWidgetFrameLayout;
    if (localFrameLayout == null) {
      Intrinsics.throwUninitializedPropertyAccessException("videoControlMask");
    }
    localFrameLayout.setVisibility(8);
    b(false);
  }
  
  private final void w()
  {
    FrameLayout localFrameLayout = this.jdField_a_of_type_AndroidWidgetFrameLayout;
    if (localFrameLayout == null) {
      Intrinsics.throwUninitializedPropertyAccessException("videoControlMask");
    }
    localFrameLayout.setVisibility(0);
    b(true);
  }
  
  private final void x()
  {
    Runnable localRunnable = this.jdField_a_of_type_JavaLangRunnable;
    if (localRunnable != null) {
      this.jdField_b_of_type_AndroidWidgetFrameLayout.removeCallbacks(localRunnable);
    }
    w();
  }
  
  private final void y()
  {
    VideoView localVideoView = this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseVideoVideoView;
    if (localVideoView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rootVideoView");
    }
    if (!localVideoView.isPlaying())
    {
      QLog.i(this.jdField_a_of_type_JavaLangString, 1, "[resumePlayVideo]");
      localVideoView = this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseVideoVideoView;
      if (localVideoView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("rootVideoView");
      }
      localVideoView.resume();
      localVideoView = this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseVideoVideoView;
      if (localVideoView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("rootVideoView");
      }
      localVideoView.setManualPause(false);
    }
  }
  
  @NotNull
  public final ImageButton a()
  {
    ImageButton localImageButton = this.jdField_a_of_type_AndroidWidgetImageButton;
    if (localImageButton == null) {
      Intrinsics.throwUninitializedPropertyAccessException("loadingButton");
    }
    return localImageButton;
  }
  
  @NotNull
  public final SeekBar a()
  {
    SeekBar localSeekBar = this.jdField_a_of_type_AndroidWidgetSeekBar;
    if (localSeekBar == null) {
      Intrinsics.throwUninitializedPropertyAccessException("seekBar");
    }
    return localSeekBar;
  }
  
  @Nullable
  public final IPlayer a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIPlayer;
  }
  
  @NotNull
  public final NativeReadInjoyImageView a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetNativeReadInjoyImageView;
  }
  
  @NotNull
  public final VideoMaskController a()
  {
    SeekBar localSeekBar = this.jdField_a_of_type_AndroidWidgetSeekBar;
    if (localSeekBar == null) {
      Intrinsics.throwUninitializedPropertyAccessException("seekBar");
    }
    localSeekBar.setOnSeekBarChangeListener((SeekBar.OnSeekBarChangeListener)this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseVideoVideoMaskController$seekBarChangeListener$1);
    return this;
  }
  
  @NotNull
  public final VideoMaskController a(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = paramAbsBaseArticleInfo;
    n();
    return this;
  }
  
  @NotNull
  public final String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public final void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseVideoVideoView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rootVideoView");
    }
    localObject = ((VideoView)localObject).getVideoView();
    if (localObject != null)
    {
      localObject = ((IVideoView)localObject).a();
      if (localObject != null) {
        ((View)localObject).setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      }
    }
    localObject = this.jdField_a_of_type_AndroidWidgetSeekBar;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("seekBar");
    }
    a((View)localObject, 5.0F, 15.0F);
    a((View)this.jdField_b_of_type_AndroidWidgetFrameLayout, 0.0F, 15.0F);
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseVideoVideoView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rootVideoView");
    }
    a((View)localObject, 0.0F, 15.0F);
    d();
    r();
  }
  
  public final void a(float paramFloat)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIPlayer;
    if ((localObject != null) && (paramFloat == ((IPlayer)localObject).a())) {
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[switchSpeedRatio] speedRatio:  ");
    ((StringBuilder)localObject).append(paramFloat);
    ((StringBuilder)localObject).append(" to ");
    localObject = new StringBuilder(((StringBuilder)localObject).toString());
    float f = paramFloat;
    if (Float.compare(paramFloat, 2.0F) > 0) {
      f = 0.5F;
    }
    this.jdField_a_of_type_Float = f;
    ((StringBuilder)localObject).append(f);
    IPlayer localIPlayer = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIPlayer;
    if (localIPlayer != null) {
      localIPlayer.a(f);
    }
    if (Float.compare(f, 0.5F) == 0) {
      this.jdField_b_of_type_ComTencentMobileqqKandianBizCommonWidgetNativeReadInjoyImageView.setImageResource(2130842793);
    } else if (Float.compare(f, 1.5F) == 0) {
      this.jdField_b_of_type_ComTencentMobileqqKandianBizCommonWidgetNativeReadInjoyImageView.setImageResource(2130842794);
    } else if (Float.compare(f, 2.0F) == 0) {
      this.jdField_b_of_type_ComTencentMobileqqKandianBizCommonWidgetNativeReadInjoyImageView.setImageResource(2130842797);
    } else {
      this.jdField_b_of_type_ComTencentMobileqqKandianBizCommonWidgetNativeReadInjoyImageView.setImageResource(2130842796);
    }
    QLog.i(this.jdField_a_of_type_JavaLangString, 1, ((StringBuilder)localObject).toString());
  }
  
  public final void a(int paramInt, @NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "msg");
    Intrinsics.checkParameterIsNotNull(paramString2, "btnText");
    v();
    MsgLayoutHelper localMsgLayoutHelper = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedbackMsgLayoutHelper;
    if (localMsgLayoutHelper == null) {
      Intrinsics.throwUninitializedPropertyAccessException("msgLayoutHelper");
    }
    localMsgLayoutHelper.a(paramInt, paramString1, paramString2);
  }
  
  public final void a(@Nullable IPlayer paramIPlayer)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIPlayer = paramIPlayer;
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public final void a(boolean paramBoolean)
  {
    if (Util.e(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo))
    {
      Object localObject = this.jdField_a_of_type_AndroidWidgetFrameLayout;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("videoControlMask");
      }
      int i = 0;
      ((FrameLayout)localObject).setVisibility(0);
      localObject = this.jdField_a_of_type_AndroidWidgetTextView;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("tvSeekTime");
      }
      int j = 8;
      ((TextView)localObject).setVisibility(8);
      if (!paramBoolean)
      {
        i = 8;
        j = 0;
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetNativeReadInjoyImageView.setVisibility(i);
      this.jdField_b_of_type_ComTencentMobileqqKandianBizCommonWidgetNativeReadInjoyImageView.setVisibility(i);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(j);
    }
  }
  
  public final boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  @NotNull
  public final VideoMaskController b()
  {
    View.OnClickListener localOnClickListener = (View.OnClickListener)new VideoMaskController.initMuteButton.muteClickListener.1(this);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetNativeReadInjoyImageView.setOnClickListener(localOnClickListener);
    return this;
  }
  
  public final void b()
  {
    d();
    Object localObject = this.jdField_a_of_type_AndroidWidgetSeekBar;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("seekBar");
    }
    ((SeekBar)localObject).setOnSeekBarChangeListener(null);
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseVideoVideoView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rootVideoView");
    }
    localObject = ((VideoView)localObject).getVideoView();
    if (localObject != null)
    {
      localObject = ((IVideoView)localObject).a();
      if (localObject != null) {
        ((View)localObject).setOnTouchListener(null);
      }
    }
    localObject = this.jdField_a_of_type_AndroidWidgetSeekBar;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("seekBar");
    }
    ((SeekBar)localObject).setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetFrameLayout.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  @NotNull
  public final VideoMaskController c()
  {
    View.OnClickListener localOnClickListener = (View.OnClickListener)new VideoMaskController.initSpeedRatioButton.speedRatioClickListener.1(this);
    this.jdField_b_of_type_ComTencentMobileqqKandianBizCommonWidgetNativeReadInjoyImageView.setOnClickListener(localOnClickListener);
    return this;
  }
  
  public final void c()
  {
    QLog.i(this.jdField_a_of_type_JavaLangString, 1, "[doOnDestroy]");
    Object localObject1 = this.jdField_a_of_type_JavaLangRunnable;
    if (localObject1 != null) {
      this.jdField_b_of_type_AndroidWidgetFrameLayout.removeCallbacks((Runnable)localObject1);
    }
    localObject1 = this.jdField_a_of_type_AndroidContentBroadcastReceiver;
    if (localObject1 != null) {
      try
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoBaseVideoVideoView;
        if (localObject2 == null) {
          Intrinsics.throwUninitializedPropertyAccessException("rootVideoView");
        }
        ((VideoView)localObject2).getContext().unregisterReceiver((BroadcastReceiver)localObject1);
        QLog.i(this.jdField_a_of_type_JavaLangString, 1, "[doOnDestroy] unregisterReceiver.");
        return;
      }
      catch (Exception localException)
      {
        Object localObject2 = this.jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[doOnDestroy] e = ");
        localStringBuilder.append(localException);
        QLog.e((String)localObject2, 1, localStringBuilder.toString());
      }
    }
  }
  
  public final void d()
  {
    s();
    e();
    g();
    this.jdField_a_of_type_Float = 1.0F;
    this.jdField_b_of_type_ComTencentMobileqqKandianBizCommonWidgetNativeReadInjoyImageView.setImageResource(2130842796);
    IPlayer localIPlayer = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIPlayer;
    if (localIPlayer != null) {
      localIPlayer.a(this.jdField_a_of_type_Float);
    }
    v();
    k();
    this.jdField_a_of_type_Boolean = false;
  }
  
  public final void e()
  {
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localTextView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("tvSeekTime");
    }
    localTextView.setVisibility(8);
    localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localTextView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("tvSeekTime");
    }
    localTextView.setText((CharSequence)"");
  }
  
  public final void f()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
    if (localObject != null)
    {
      int i = ((AbsBaseArticleInfo)localObject).getVideoDuration();
      localObject = this.jdField_a_of_type_AndroidWidgetSeekBar;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("seekBar");
      }
      int j = ((SeekBar)localObject).getProgress() * i / 100;
      localObject = this.jdField_a_of_type_AndroidWidgetTextView;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("tvSeekTime");
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(ReadInJoyDisplayUtils.a(j));
      localStringBuilder.append(" / ");
      localStringBuilder.append(ReadInJoyDisplayUtils.a(i));
      ((TextView)localObject).setText((CharSequence)localStringBuilder.toString());
    }
  }
  
  public final void g()
  {
    SeekBar localSeekBar = this.jdField_a_of_type_AndroidWidgetSeekBar;
    if (localSeekBar == null) {
      Intrinsics.throwUninitializedPropertyAccessException("seekBar");
    }
    localSeekBar.setPressed(false);
    localSeekBar = this.jdField_a_of_type_AndroidWidgetSeekBar;
    if (localSeekBar == null) {
      Intrinsics.throwUninitializedPropertyAccessException("seekBar");
    }
    localSeekBar.setProgress(0);
    localSeekBar = this.jdField_a_of_type_AndroidWidgetSeekBar;
    if (localSeekBar == null) {
      Intrinsics.throwUninitializedPropertyAccessException("seekBar");
    }
    localSeekBar.setVisibility(8);
    localSeekBar = this.jdField_a_of_type_AndroidWidgetSeekBar;
    if (localSeekBar == null) {
      Intrinsics.throwUninitializedPropertyAccessException("seekBar");
    }
    localSeekBar.setOnSeekBarChangeListener(null);
  }
  
  public final void h()
  {
    s();
    SeekBar localSeekBar = this.jdField_a_of_type_AndroidWidgetSeekBar;
    if (localSeekBar == null) {
      Intrinsics.throwUninitializedPropertyAccessException("seekBar");
    }
    localSeekBar.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    a();
    a(this.jdField_a_of_type_Long);
  }
  
  public final void i()
  {
    s();
    x();
    if (Util.e(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  public final void j()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
    if (localObject1 != null)
    {
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIPlayer;
      if (localObject2 != null)
      {
        localObject2 = VideoReportUtil.a.a((AbsBaseArticleInfo)localObject1, ((IPlayer)localObject2).b());
        ((RIJTransMergeKanDianReport.ReportR5Builder)localObject2).addStringNotThrow("video_progress_control_way", "1");
        localObject1 = VideoReportUtil.a;
        localObject2 = ((RIJTransMergeKanDianReport.ReportR5Builder)localObject2).build();
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "r5Builder.build()");
        ((VideoReportUtil)localObject1).a("", "0X800B3D8", (String)localObject2);
      }
    }
  }
  
  public final void k()
  {
    MsgLayoutHelper localMsgLayoutHelper = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedbackMsgLayoutHelper;
    if (localMsgLayoutHelper == null) {
      Intrinsics.throwUninitializedPropertyAccessException("msgLayoutHelper");
    }
    localMsgLayoutHelper.a();
  }
  
  public final void l()
  {
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    ThreadManager.getUIHandler().postDelayed(this.jdField_b_of_type_JavaLangRunnable, 500L);
  }
  
  public final void m()
  {
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    ImageButton localImageButton = this.jdField_a_of_type_AndroidWidgetImageButton;
    if (localImageButton == null) {
      Intrinsics.throwUninitializedPropertyAccessException("loadingButton");
    }
    localImageButton.clearAnimation();
    localImageButton = this.jdField_a_of_type_AndroidWidgetImageButton;
    if (localImageButton == null) {
      Intrinsics.throwUninitializedPropertyAccessException("loadingButton");
    }
    localImageButton.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.gifvideo.base.video.VideoMaskController
 * JD-Core Version:    0.7.0.1
 */