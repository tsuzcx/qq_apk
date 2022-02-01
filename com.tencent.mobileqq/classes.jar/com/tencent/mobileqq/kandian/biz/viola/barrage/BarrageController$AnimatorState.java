package com.tencent.mobileqq.kandian.biz.viola.barrage;

import android.animation.ValueAnimator;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/viola/barrage/BarrageController$AnimatorState;", "", "animator", "Landroid/animation/ValueAnimator;", "(Lcom/tencent/mobileqq/kandian/biz/viola/barrage/BarrageController;Landroid/animation/ValueAnimator;)V", "getAnimator", "()Landroid/animation/ValueAnimator;", "currentPlayTime", "", "getCurrentPlayTime", "()J", "setCurrentPlayTime", "(J)V", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class BarrageController$AnimatorState
{
  private long jdField_a_of_type_Long;
  @NotNull
  private final ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  
  public BarrageController$AnimatorState(ValueAnimator paramValueAnimator)
  {
    this.jdField_a_of_type_AndroidAnimationValueAnimator = localObject;
  }
  
  public final long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  @NotNull
  public final ValueAnimator a()
  {
    return this.jdField_a_of_type_AndroidAnimationValueAnimator;
  }
  
  public final void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.viola.barrage.BarrageController.AnimatorState
 * JD-Core Version:    0.7.0.1
 */