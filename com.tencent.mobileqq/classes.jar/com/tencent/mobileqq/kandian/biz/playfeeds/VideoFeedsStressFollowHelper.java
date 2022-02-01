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
  private static float jdField_a_of_type_Float;
  private static int jdField_a_of_type_Int;
  public static final VideoFeedsStressFollowHelper.Companion a;
  private static int jdField_b_of_type_Int;
  private static boolean c;
  private final View jdField_a_of_type_AndroidViewView;
  @NotNull
  private final VideoFeedsStressFollowLayout jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsStressFollowLayout;
  private boolean jdField_a_of_type_Boolean;
  @NotNull
  private final View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsStressFollowHelper$Companion = new VideoFeedsStressFollowHelper.Companion(null);
    Object localObject = Aladdin.getConfig(359);
    boolean bool = false;
    if (((AladdinConfig)localObject).getIntegerFromString("rij_is_strengthen_follow", 0) == 1) {
      bool = true;
    }
    c = bool;
    jdField_a_of_type_Float = Aladdin.getConfig(359).getFloatFromString("rij_show_strengthen_follow_timeinterval", 0.8F);
    jdField_b_of_type_Int = Aladdin.getConfig(359).getIntegerFromString("rij_show_strengthen_follow_frequency", 5);
    VideoFeedsStressFollowHelper.Companion.c(jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsStressFollowHelper$Companion);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("dump config: stressEnable:");
      ((StringBuilder)localObject).append(c);
      ((StringBuilder)localObject).append(" showStrengthenInterval:");
      ((StringBuilder)localObject).append(jdField_a_of_type_Float);
      ((StringBuilder)localObject).append(" stressCountLimit:");
      ((StringBuilder)localObject).append(jdField_b_of_type_Int);
      QLog.d("VideoFeedsStressFollowHelper", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public VideoFeedsStressFollowHelper(@NotNull VideoFeedsStressFollowLayout paramVideoFeedsStressFollowLayout, @NotNull View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsStressFollowLayout = paramVideoFeedsStressFollowLayout;
    this.jdField_b_of_type_AndroidViewView = paramView;
    paramVideoFeedsStressFollowLayout = this.jdField_b_of_type_AndroidViewView.findViewById(2131368090);
    Intrinsics.checkExpressionValueIsNotNull(paramVideoFeedsStressFollowLayout, "originAvatarLayout.findV…er_account_follow_button)");
    this.jdField_a_of_type_AndroidViewView = paramVideoFeedsStressFollowLayout;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsStressFollowLayout.a((VideoFeedsStressFollowLayout.OnFollowActionListener)new VideoFeedsStressFollowHelper.1(this));
  }
  
  private final void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsStressFollowLayout.a()) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsStressFollowLayout.a() != StressState.Shrink))
    {
      if (this.jdField_a_of_type_Boolean) {
        return;
      }
      this.jdField_a_of_type_Boolean = true;
      ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      Intrinsics.checkExpressionValueIsNotNull(localValueAnimator, "translationAnimator");
      localValueAnimator.setDuration(400L);
      localValueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new VideoFeedsStressFollowHelper.startShrinkAnim.1(this));
      localValueAnimator.addListener((Animator.AnimatorListener)new VideoFeedsStressFollowHelper.startShrinkAnim.2(this));
      localValueAnimator.start();
    }
  }
  
  private final void a(Animator.AnimatorListener paramAnimatorListener)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsStressFollowLayout.a()) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsStressFollowLayout.a() != StressState.Stretched))
    {
      if (this.jdField_a_of_type_Boolean) {
        return;
      }
      this.jdField_a_of_type_Boolean = true;
      VideoFeedsStressFollowHelper.Companion.b(jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsStressFollowHelper$Companion);
      AnimatorSet localAnimatorSet1 = new AnimatorSet();
      localAnimatorSet1.setDuration(160L);
      localAnimatorSet1.play((Animator)ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewView, "scaleX", new float[] { 1.0F, 1.06F })).with((Animator)ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewView, "scaleY", new float[] { 1.0F, 1.06F }));
      AnimatorSet localAnimatorSet2 = new AnimatorSet();
      localAnimatorSet2.setDuration(200L);
      localAnimatorSet2.play((Animator)ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewView, "scaleX", new float[] { 1.06F, 0.0F })).with((Animator)ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewView, "scaleY", new float[] { 1.06F, 0.0F }));
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
    return (c) && (paramFloat >= jdField_a_of_type_Float) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsStressFollowLayout.b());
  }
  
  @NotNull
  public final VideoFeedsStressFollowLayout a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsStressFollowLayout;
  }
  
  public final void a(float paramFloat, @Nullable Animator.AnimatorListener paramAnimatorListener)
  {
    if ((a(paramFloat)) && (!this.jdField_b_of_type_Boolean))
    {
      VideoFeedsStressFollowHelper.Companion.a(jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsStressFollowHelper$Companion);
      if (jdField_a_of_type_Int < jdField_b_of_type_Int)
      {
        a(paramAnimatorListener);
      }
      else if ((!this.jdField_b_of_type_Boolean) && (QLog.isColorLevel()))
      {
        paramAnimatorListener = new StringBuilder();
        paramAnimatorListener.append("startStretchAnim ignore for nowStressCount:");
        paramAnimatorListener.append(jdField_a_of_type_Int);
        paramAnimatorListener.append(" is lager than stressCountLimit:");
        paramAnimatorListener.append(jdField_b_of_type_Int);
        paramAnimatorListener.append('.');
        QLog.w("VideoFeedsStressFollowHelper", 2, paramAnimatorListener.toString());
      }
      this.jdField_b_of_type_Boolean = true;
    }
  }
  
  public final void a(@NotNull StressState paramStressState)
  {
    Intrinsics.checkParameterIsNotNull(paramStressState, "state");
    if (paramStressState == StressState.Stretched)
    {
      this.jdField_a_of_type_AndroidViewView.setScaleX(0.0F);
      this.jdField_a_of_type_AndroidViewView.setScaleY(0.0F);
    }
    else
    {
      this.jdField_a_of_type_AndroidViewView.setScaleX(1.0F);
      this.jdField_a_of_type_AndroidViewView.setScaleY(1.0F);
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsStressFollowLayout.setStressState(paramStressState);
    this.jdField_b_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsStressFollowHelper
 * JD-Core Version:    0.7.0.1
 */