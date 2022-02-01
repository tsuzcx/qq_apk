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
  public static final VideoMaskController.Companion d = new VideoMaskController.Companion(null);
  private final VideoMaskController.seekBarChangeListener.1 A = new VideoMaskController.seekBarChangeListener.1(this);
  @NotNull
  private final Runnable B = (Runnable)new VideoMaskController.showLoadingProgressRunnable.1(this);
  @NotNull
  public FrameLayout a;
  @NotNull
  public TextView b;
  @NotNull
  public MsgLayoutHelper c;
  @NotNull
  private String e = "VideoMaskController";
  private VideoView f;
  @NotNull
  private FrameLayout g;
  @NotNull
  private SeekBar h;
  @NotNull
  private NativeReadInjoyImageView i;
  @NotNull
  private NativeReadInjoyImageView j;
  @NotNull
  private ImageButton k;
  @NotNull
  private ImageView l;
  @NotNull
  private TextView m;
  private AbsBaseArticleInfo n;
  private String o = "";
  private boolean p;
  @Nullable
  private IPlayer q;
  private float r = 1.0F;
  private long s = 3000L;
  private Runnable t;
  private BroadcastReceiver u;
  @NotNull
  private View.OnClickListener v = (View.OnClickListener)new VideoMaskController.retryClickListener.1(this);
  private int w;
  private int x;
  private int y;
  @NotNull
  private View.OnTouchListener z = (View.OnTouchListener)new VideoMaskController.onTouchListener.1(this);
  
  public VideoMaskController(@NotNull Context paramContext, @NotNull VideoView paramVideoView, @Nullable IPlayer paramIPlayer)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2131626435, null);
    if (paramContext != null)
    {
      this.g = ((FrameLayout)paramContext);
      paramContext = this.g.findViewById(2131433251);
      Intrinsics.checkExpressionValueIsNotNull(paramContext, "videoMaskContainer.findV…yId(R.id.fl_control_mask)");
      this.a = ((FrameLayout)paramContext);
      paramContext = this.g.findViewById(2131445256);
      Intrinsics.checkExpressionValueIsNotNull(paramContext, "videoMaskContainer.findV…Id(R.id.sb_play_progress)");
      this.h = ((SeekBar)paramContext);
      paramContext = this.g.findViewById(2131448729);
      Intrinsics.checkExpressionValueIsNotNull(paramContext, "videoMaskContainer.findViewById(R.id.tv_seek_time)");
      this.b = ((TextView)paramContext);
      paramContext = this.g.findViewById(2131436468);
      Intrinsics.checkExpressionValueIsNotNull(paramContext, "videoMaskContainer.findV…ById(R.id.iv_mute_button)");
      this.i = ((NativeReadInjoyImageView)paramContext);
      paramContext = this.g.findViewById(2131436584);
      Intrinsics.checkExpressionValueIsNotNull(paramContext, "videoMaskContainer.findV…id.iv_speed_ratio_button)");
      this.j = ((NativeReadInjoyImageView)paramContext);
      paramContext = this.g.findViewById(2131437634);
      Intrinsics.checkExpressionValueIsNotNull(paramContext, "videoMaskContainer.findV…ById(R.id.loading_button)");
      this.k = ((ImageButton)paramContext);
      paramContext = this.g.findViewById(2131440383);
      Intrinsics.checkExpressionValueIsNotNull(paramContext, "videoMaskContainer.findViewById(R.id.play_icon)");
      this.l = ((ImageView)paramContext);
      paramContext = this.g.findViewById(2131440382);
      Intrinsics.checkExpressionValueIsNotNull(paramContext, "videoMaskContainer.findV…wById(R.id.play_duration)");
      this.m = ((TextView)paramContext);
      this.f = paramVideoView;
      this.q = paramIPlayer;
      this.c = new MsgLayoutHelper((View)this.g, this.v);
      paramVideoView.addView((View)this.g);
      j();
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.widget.FrameLayout");
  }
  
  private final void A()
  {
    if (this.u == null)
    {
      this.u = ((BroadcastReceiver)new VideoMaskController.initVolumeChangeReceiver.1(this));
      QLog.i(this.e, 1, "[initVolumeChangeReceiver]");
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tencent.mobileqq.kandian.biz.gifvideo.VideoMaskController.ACTION_DOWN_AUDIO_BUTTON");
      VideoView localVideoView = this.f;
      if (localVideoView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("rootVideoView");
      }
      localVideoView.getContext().registerReceiver(this.u, localIntentFilter);
    }
  }
  
  private final void B()
  {
    boolean bool = VideoAudioControlUtil.a.c();
    if (bool) {
      this.i.setImageResource(2130844080);
    } else {
      this.i.setImageResource(2130844081);
    }
    VideoView localVideoView = this.f;
    if (localVideoView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rootVideoView");
    }
    localVideoView.setMute(bool);
  }
  
  private final void C()
  {
    Object localObject = this.f;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rootVideoView");
    }
    boolean bool = ((VideoView)localObject).isMute();
    localObject = this.e;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[switchMuteState] isMute: ");
    localStringBuilder.append(bool);
    localStringBuilder.append(" to ");
    localStringBuilder.append(bool ^ true);
    QLog.i((String)localObject, 1, localStringBuilder.toString());
    localObject = this.f;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rootVideoView");
    }
    ((VideoView)localObject).setMute(bool ^ true);
    localObject = this.f;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rootVideoView");
    }
    if (((VideoView)localObject).isMute())
    {
      this.i.setImageResource(2130844080);
      return;
    }
    this.i.setImageResource(2130844081);
  }
  
  private final void D()
  {
    a(this.r + 0.5F);
  }
  
  private final void E()
  {
    FrameLayout localFrameLayout = this.a;
    if (localFrameLayout == null) {
      Intrinsics.throwUninitializedPropertyAccessException("videoControlMask");
    }
    localFrameLayout.setVisibility(8);
    b(false);
  }
  
  private final void F()
  {
    FrameLayout localFrameLayout = this.a;
    if (localFrameLayout == null) {
      Intrinsics.throwUninitializedPropertyAccessException("videoControlMask");
    }
    localFrameLayout.setVisibility(0);
    b(true);
  }
  
  private final void G()
  {
    Runnable localRunnable = this.t;
    if (localRunnable != null) {
      this.g.removeCallbacks(localRunnable);
    }
    F();
  }
  
  private final void H()
  {
    VideoView localVideoView = this.f;
    if (localVideoView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rootVideoView");
    }
    if (!localVideoView.isPlaying())
    {
      QLog.i(this.e, 1, "[resumePlayVideo]");
      localVideoView = this.f;
      if (localVideoView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("rootVideoView");
      }
      localVideoView.resume();
      localVideoView = this.f;
      if (localVideoView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("rootVideoView");
      }
      localVideoView.setManualPause(false);
    }
  }
  
  private final void a(int paramInt)
  {
    VideoView localVideoView = this.f;
    if (localVideoView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rootVideoView");
    }
    localVideoView.updateProgress(paramInt);
  }
  
  private final void a(long paramLong)
  {
    F();
    if (this.t == null) {
      this.t = ((Runnable)new VideoMaskController.showVideoMaskForAWhile.1(this));
    }
    if (Util.f(this.n)) {
      return;
    }
    Runnable localRunnable = this.t;
    if (localRunnable != null)
    {
      this.g.removeCallbacks(localRunnable);
      this.g.postDelayed(localRunnable, paramLong);
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
    Object localObject = this.f;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rootVideoView");
    }
    if (((VideoView)localObject).getContext() != null)
    {
      localObject = this.h;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("seekBar");
      }
      ((SeekBar)localObject).setSelected(paramBoolean);
    }
  }
  
  private final void w()
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.n;
    if (localAbsBaseArticleInfo != null)
    {
      int i1 = localAbsBaseArticleInfo.getVideoDuration();
      this.m.setText((CharSequence)ReadInJoyDisplayUtils.a(i1));
    }
  }
  
  private final void x()
  {
    this.p = true;
    TextView localTextView = this.b;
    if (localTextView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("tvSeekTime");
    }
    localTextView.setVisibility(0);
  }
  
  private final void y()
  {
    this.p = false;
    TextView localTextView = this.b;
    if (localTextView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("tvSeekTime");
    }
    localTextView.setVisibility(8);
  }
  
  private final void z()
  {
    if (this.h == null) {
      Intrinsics.throwUninitializedPropertyAccessException("seekBar");
    }
    Object localObject = this.q;
    if (localObject != null)
    {
      SeekBar localSeekBar = this.h;
      if (localSeekBar == null) {
        Intrinsics.throwUninitializedPropertyAccessException("seekBar");
      }
      int i1 = localSeekBar.getProgress();
      long l1 = ((IPlayer)localObject).n();
      if (l1 > 0L) {
        ((IPlayer)localObject).a((int)((float)(i1 * l1) / 100.0F), 3);
      }
      localObject = this.f;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("rootVideoView");
      }
      ((VideoView)localObject).startPlay();
    }
  }
  
  @NotNull
  public final VideoMaskController a(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    this.n = paramAbsBaseArticleInfo;
    w();
    return this;
  }
  
  @NotNull
  public final String a()
  {
    return this.e;
  }
  
  public final void a(float paramFloat)
  {
    Object localObject = this.q;
    if ((localObject != null) && (paramFloat == ((IPlayer)localObject).a())) {
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[switchSpeedRatio] speedRatio:  ");
    ((StringBuilder)localObject).append(paramFloat);
    ((StringBuilder)localObject).append(" to ");
    localObject = new StringBuilder(((StringBuilder)localObject).toString());
    float f1 = paramFloat;
    if (Float.compare(paramFloat, 2.0F) > 0) {
      f1 = 0.5F;
    }
    this.r = f1;
    ((StringBuilder)localObject).append(f1);
    IPlayer localIPlayer = this.q;
    if (localIPlayer != null) {
      localIPlayer.a(f1);
    }
    if (Float.compare(f1, 0.5F) == 0) {
      this.j.setImageResource(2130843747);
    } else if (Float.compare(f1, 1.5F) == 0) {
      this.j.setImageResource(2130843748);
    } else if (Float.compare(f1, 2.0F) == 0) {
      this.j.setImageResource(2130843751);
    } else {
      this.j.setImageResource(2130843750);
    }
    QLog.i(this.e, 1, ((StringBuilder)localObject).toString());
  }
  
  public final void a(int paramInt, @NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "msg");
    Intrinsics.checkParameterIsNotNull(paramString2, "btnText");
    E();
    MsgLayoutHelper localMsgLayoutHelper = this.c;
    if (localMsgLayoutHelper == null) {
      Intrinsics.throwUninitializedPropertyAccessException("msgLayoutHelper");
    }
    localMsgLayoutHelper.a(paramInt, paramString1, paramString2);
  }
  
  public final void a(@Nullable IPlayer paramIPlayer)
  {
    this.q = paramIPlayer;
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.e = paramString;
  }
  
  public final void a(boolean paramBoolean)
  {
    if (Util.f(this.n))
    {
      Object localObject = this.a;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("videoControlMask");
      }
      int i1 = 0;
      ((FrameLayout)localObject).setVisibility(0);
      localObject = this.b;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("tvSeekTime");
      }
      int i2 = 8;
      ((TextView)localObject).setVisibility(8);
      if (!paramBoolean)
      {
        i1 = 8;
        i2 = 0;
      }
      this.i.setVisibility(i1);
      this.j.setVisibility(i1);
      this.m.setVisibility(i2);
    }
  }
  
  @NotNull
  public final SeekBar b()
  {
    SeekBar localSeekBar = this.h;
    if (localSeekBar == null) {
      Intrinsics.throwUninitializedPropertyAccessException("seekBar");
    }
    return localSeekBar;
  }
  
  @NotNull
  public final NativeReadInjoyImageView c()
  {
    return this.i;
  }
  
  @NotNull
  public final ImageButton d()
  {
    ImageButton localImageButton = this.k;
    if (localImageButton == null) {
      Intrinsics.throwUninitializedPropertyAccessException("loadingButton");
    }
    return localImageButton;
  }
  
  public final boolean e()
  {
    return this.p;
  }
  
  @Nullable
  public final IPlayer f()
  {
    return this.q;
  }
  
  public final void g()
  {
    Object localObject = this.f;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rootVideoView");
    }
    localObject = ((VideoView)localObject).getVideoView();
    if (localObject != null)
    {
      localObject = ((IVideoView)localObject).a();
      if (localObject != null) {
        ((View)localObject).setOnTouchListener(this.z);
      }
    }
    localObject = this.h;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("seekBar");
    }
    a((View)localObject, 5.0F, 15.0F);
    a((View)this.g, 0.0F, 15.0F);
    localObject = this.f;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rootVideoView");
    }
    a((View)localObject, 0.0F, 15.0F);
    j();
    A();
  }
  
  public final void h()
  {
    j();
    Object localObject = this.h;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("seekBar");
    }
    ((SeekBar)localObject).setOnSeekBarChangeListener(null);
    localObject = this.f;
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
    localObject = this.h;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("seekBar");
    }
    ((SeekBar)localObject).setVisibility(8);
    this.g.removeCallbacks(this.t);
  }
  
  public final void i()
  {
    QLog.i(this.e, 1, "[doOnDestroy]");
    Object localObject1 = this.t;
    if (localObject1 != null) {
      this.g.removeCallbacks((Runnable)localObject1);
    }
    localObject1 = this.u;
    if (localObject1 != null) {
      try
      {
        localObject2 = this.f;
        if (localObject2 == null) {
          Intrinsics.throwUninitializedPropertyAccessException("rootVideoView");
        }
        ((VideoView)localObject2).getContext().unregisterReceiver((BroadcastReceiver)localObject1);
        QLog.i(this.e, 1, "[doOnDestroy] unregisterReceiver.");
        return;
      }
      catch (Exception localException)
      {
        Object localObject2 = this.e;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[doOnDestroy] e = ");
        localStringBuilder.append(localException);
        QLog.e((String)localObject2, 1, localStringBuilder.toString());
      }
    }
  }
  
  public final void j()
  {
    B();
    k();
    m();
    this.r = 1.0F;
    this.j.setImageResource(2130843750);
    IPlayer localIPlayer = this.q;
    if (localIPlayer != null) {
      localIPlayer.a(this.r);
    }
    E();
    t();
    this.p = false;
  }
  
  public final void k()
  {
    TextView localTextView = this.b;
    if (localTextView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("tvSeekTime");
    }
    localTextView.setVisibility(8);
    localTextView = this.b;
    if (localTextView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("tvSeekTime");
    }
    localTextView.setText((CharSequence)"");
  }
  
  public final void l()
  {
    Object localObject = this.n;
    if (localObject != null)
    {
      int i1 = ((AbsBaseArticleInfo)localObject).getVideoDuration();
      localObject = this.h;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("seekBar");
      }
      int i2 = ((SeekBar)localObject).getProgress() * i1 / 100;
      localObject = this.b;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("tvSeekTime");
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(ReadInJoyDisplayUtils.a(i2));
      localStringBuilder.append(" / ");
      localStringBuilder.append(ReadInJoyDisplayUtils.a(i1));
      ((TextView)localObject).setText((CharSequence)localStringBuilder.toString());
    }
  }
  
  public final void m()
  {
    SeekBar localSeekBar = this.h;
    if (localSeekBar == null) {
      Intrinsics.throwUninitializedPropertyAccessException("seekBar");
    }
    localSeekBar.setPressed(false);
    localSeekBar = this.h;
    if (localSeekBar == null) {
      Intrinsics.throwUninitializedPropertyAccessException("seekBar");
    }
    localSeekBar.setProgress(0);
    localSeekBar = this.h;
    if (localSeekBar == null) {
      Intrinsics.throwUninitializedPropertyAccessException("seekBar");
    }
    localSeekBar.setVisibility(8);
    localSeekBar = this.h;
    if (localSeekBar == null) {
      Intrinsics.throwUninitializedPropertyAccessException("seekBar");
    }
    localSeekBar.setOnSeekBarChangeListener(null);
  }
  
  public final void n()
  {
    B();
    SeekBar localSeekBar = this.h;
    if (localSeekBar == null) {
      Intrinsics.throwUninitializedPropertyAccessException("seekBar");
    }
    localSeekBar.setVisibility(0);
    this.l.setVisibility(8);
    p();
    a(this.s);
  }
  
  public final void o()
  {
    B();
    G();
    if (Util.f(this.n))
    {
      this.l.setVisibility(4);
      return;
    }
    this.l.setVisibility(0);
  }
  
  @NotNull
  public final VideoMaskController p()
  {
    SeekBar localSeekBar = this.h;
    if (localSeekBar == null) {
      Intrinsics.throwUninitializedPropertyAccessException("seekBar");
    }
    localSeekBar.setOnSeekBarChangeListener((SeekBar.OnSeekBarChangeListener)this.A);
    return this;
  }
  
  public final void q()
  {
    Object localObject1 = this.n;
    if (localObject1 != null)
    {
      Object localObject2 = this.q;
      if (localObject2 != null)
      {
        localObject2 = VideoReportUtil.a.a((AbsBaseArticleInfo)localObject1, ((IPlayer)localObject2).o());
        ((RIJTransMergeKanDianReport.ReportR5Builder)localObject2).addStringNotThrow("video_progress_control_way", "1");
        localObject1 = VideoReportUtil.a;
        localObject2 = ((RIJTransMergeKanDianReport.ReportR5Builder)localObject2).build();
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "r5Builder.build()");
        ((VideoReportUtil)localObject1).a("", "0X800B3D8", (String)localObject2);
      }
    }
  }
  
  @NotNull
  public final VideoMaskController r()
  {
    View.OnClickListener localOnClickListener = (View.OnClickListener)new VideoMaskController.initMuteButton.muteClickListener.1(this);
    this.i.setOnClickListener(localOnClickListener);
    return this;
  }
  
  @NotNull
  public final VideoMaskController s()
  {
    View.OnClickListener localOnClickListener = (View.OnClickListener)new VideoMaskController.initSpeedRatioButton.speedRatioClickListener.1(this);
    this.j.setOnClickListener(localOnClickListener);
    return this;
  }
  
  public final void t()
  {
    MsgLayoutHelper localMsgLayoutHelper = this.c;
    if (localMsgLayoutHelper == null) {
      Intrinsics.throwUninitializedPropertyAccessException("msgLayoutHelper");
    }
    localMsgLayoutHelper.a();
  }
  
  public final void u()
  {
    ThreadManager.getUIHandler().removeCallbacks(this.B);
    ThreadManager.getUIHandler().postDelayed(this.B, 500L);
  }
  
  public final void v()
  {
    ThreadManager.getUIHandler().removeCallbacks(this.B);
    ImageButton localImageButton = this.k;
    if (localImageButton == null) {
      Intrinsics.throwUninitializedPropertyAccessException("loadingButton");
    }
    localImageButton.clearAnimation();
    localImageButton = this.k;
    if (localImageButton == null) {
      Intrinsics.throwUninitializedPropertyAccessException("loadingButton");
    }
    localImageButton.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.gifvideo.base.video.VideoMaskController
 * JD-Core Version:    0.7.0.1
 */