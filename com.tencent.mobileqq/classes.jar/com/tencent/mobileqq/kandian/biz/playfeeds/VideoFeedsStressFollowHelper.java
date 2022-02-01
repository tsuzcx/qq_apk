package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.StressState;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/playfeeds/VideoFeedsStressFollowHelper;", "", "stressLayout", "Lcom/tencent/mobileqq/kandian/biz/playfeeds/VideoFeedsStressFollowLayout;", "originAvatarLayout", "Landroid/view/View;", "(Lcom/tencent/mobileqq/kandian/biz/playfeeds/VideoFeedsStressFollowLayout;Landroid/view/View;)V", "hasJudgeShowStressLayout", "", "isAnimating", "getOriginAvatarLayout", "()Landroid/view/View;", "originFollowBtn", "getStressLayout", "()Lcom/tencent/mobileqq/kandian/biz/playfeeds/VideoFeedsStressFollowLayout;", "canDoStressAnim", "percent", "", "setStressState", "", "state", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/entity/StressState;", "startShrinkAnim", "startStretchAnim", "animatorListener", "Landroid/animation/Animator$AnimatorListener;", "updateVideoPlayPercent", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class VideoFeedsStressFollowHelper
{
  public static final VideoFeedsStressFollowHelper.Companion a = new VideoFeedsStressFollowHelper.Companion(null);
  private static int g;
  private static boolean h;
  private static float i;
  private static int j;
  private final View b;
  private boolean c;
  private boolean d;
  @NotNull
  private final VideoFeedsStressFollowLayout e;
  @NotNull
  private final View f;
  
  static
  {
    Object localObject = Aladdin.getConfig(359);
    boolean bool = false;
    if (((AladdinConfig)localObject).getIntegerFromString("rij_is_strengthen_follow", 0) == 1) {
      bool = true;
    }
    h = bool;
    i = Aladdin.getConfig(359).getFloatFromString("rij_show_strengthen_follow_timeinterval", 0.8F);
    j = Aladdin.getConfig(359).getIntegerFromString("rij_show_strengthen_follow_frequency", 5);
    VideoFeedsStressFollowHelper.Companion.c(a);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("dump config: stressEnable:");
      ((StringBuilder)localObject).append(h);
      ((StringBuilder)localObject).append(" showStrengthenInterval:");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(" stressCountLimit:");
      ((StringBuilder)localObject).append(j);
      QLog.d("VideoFeedsStressFollowHelper", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public VideoFeedsStressFollowHelper(@NotNull VideoFeedsStressFollowLayout paramVideoFeedsStressFollowLayout, @NotNull View paramView)
  {
    this.e = paramVideoFeedsStressFollowLayout;
    this.f = paramView;
    paramVideoFeedsStressFollowLayout = this.f.findViewById(2131434944);
    Intrinsics.checkExpressionValueIsNotNull(paramVideoFeedsStressFollowLayout, "originAvatarLayout.findV…er_account_follow_button)");
    this.b = paramVideoFeedsStressFollowLayout;
    this.e.a((VideoFeedsStressFollowLayout.OnFollowActionListener)new VideoFeedsStressFollowHelper.1(this));
  }
  
  private final void a(Animator.AnimatorListener paramAnimatorListener)
  {
    if ((this.e.a()) && (this.e.getState() != StressState.Stretched))
    {
      if (this.c) {
        return;
      }
      this.c = true;
      VideoFeedsStressFollowHelper.Companion.b(a);
      AnimatorSet localAnimatorSet1 = new AnimatorSet();
      localAnimatorSet1.setDuration(160L);
      localAnimatorSet1.play((Animator)ObjectAnimator.ofFloat(this.b, "scaleX", new float[] { 1.0F, 1.06F })).with((Animator)ObjectAnimator.ofFloat(this.b, "scaleY", new float[] { 1.0F, 1.06F }));
      AnimatorSet localAnimatorSet2 = new AnimatorSet();
      localAnimatorSet2.setDuration(200L);
      localAnimatorSet2.play((Animator)ObjectAnimator.ofFloat(this.b, "scaleX", new float[] { 1.06F, 0.0F })).with((Animator)ObjectAnimator.ofFloat(this.b, "scaleY", new float[] { 1.06F, 0.0F }));
      localAnimatorSet2.addListener((Animator.AnimatorListener)new VideoFeedsStressFollowHelper.startStretchAnim.1(this));
      ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      Intrinsics.checkExpressionValueIsNotNull(localValueAnimator, "translationAnimator");
      localValueAnimator.setDuration(400L);
      localValueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new VideoFeedsStressFollowHelper.startStretchAnim.2(this));
      AnimatorSet localAnimatorSet3 = new AnimatorSet();
      localAnimatorSet3.addListener((Animator.AnimatorListener)new VideoFeedsStressFollowHelper.startStretchAnim.3(this, paramAnimatorListener));
      localAnimatorSet3.playSequentially(new Animator[] { (Animator)localAnimatorSet1, (Animator)localAnimatorSet2 });
      localAnimatorSet3.play((Animator)localValueAnimator).after(280L);
      localAnimatorSet3.start();
    }
  }
  
  private final boolean a(float paramFloat)
  {
    return (h) && (paramFloat >= i) && (this.e.b());
  }
  
  private final void c()
  {
    if ((this.e.a()) && (this.e.getState() != StressState.Shrink))
    {
      if (this.c) {
        return;
      }
      this.c = true;
      ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      Intrinsics.checkExpressionValueIsNotNull(localValueAnimator, "translationAnimator");
      localValueAnimator.setDuration(400L);
      localValueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new VideoFeedsStressFollowHelper.startShrinkAnim.1(this));
      localValueAnimator.addListener((Animator.AnimatorListener)new VideoFeedsStressFollowHelper.startShrinkAnim.2(this));
      localValueAnimator.start();
    }
  }
  
  @NotNull
  public final VideoFeedsStressFollowLayout a()
  {
    return this.e;
  }
  
  public final void a(float paramFloat, @Nullable Animator.AnimatorListener paramAnimatorListener)
  {
    if ((a(paramFloat)) && (!this.d))
    {
      VideoFeedsStressFollowHelper.Companion.a(a);
      if (g < j)
      {
        a(paramAnimatorListener);
      }
      else if ((!this.d) && (QLog.isColorLevel()))
      {
        paramAnimatorListener = new StringBuilder();
        paramAnimatorListener.append("startStretchAnim ignore for nowStressCount:");
        paramAnimatorListener.append(g);
        paramAnimatorListener.append(" is lager than stressCountLimit:");
        paramAnimatorListener.append(j);
        paramAnimatorListener.append('.');
        QLog.w("VideoFeedsStressFollowHelper", 2, paramAnimatorListener.toString());
      }
      this.d = true;
    }
  }
  
  public final void a(@NotNull StressState paramStressState)
  {
    Intrinsics.checkParameterIsNotNull(paramStressState, "state");
    if (paramStressState == StressState.Stretched)
    {
      this.b.setScaleX(0.0F);
      this.b.setScaleY(0.0F);
    }
    else
    {
      this.b.setScaleX(1.0F);
      this.b.setScaleY(1.0F);
    }
    this.e.setStressState(paramStressState);
    this.d = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsStressFollowHelper
 * JD-Core Version:    0.7.0.1
 */