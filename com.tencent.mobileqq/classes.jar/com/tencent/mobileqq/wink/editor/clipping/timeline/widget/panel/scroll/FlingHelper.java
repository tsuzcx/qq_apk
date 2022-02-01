package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.scroll;

import androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationUpdateListener;
import androidx.dynamicanimation.animation.FlingAnimation;
import androidx.dynamicanimation.animation.FloatValueHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/scroll/FlingHelper;", "", "()V", "animation", "Landroidx/dynamicanimation/animation/FlingAnimation;", "flingFactor", "", "getFlingFactor", "()F", "setFlingFactor", "(F)V", "isFlingAnimationRunning", "", "isFlingAnimationRunning$qq_wink_impl_release", "startFling", "", "velocityX", "startValue", "maxValue", "listener", "Landroidx/dynamicanimation/animation/DynamicAnimation$OnAnimationUpdateListener;", "stopFling", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class FlingHelper
{
  private FlingAnimation a;
  private float b = 1.0F;
  
  public final void a(float paramFloat)
  {
    this.b = paramFloat;
  }
  
  public final void a(float paramFloat1, float paramFloat2, float paramFloat3, @NotNull DynamicAnimation.OnAnimationUpdateListener paramOnAnimationUpdateListener)
  {
    Intrinsics.checkParameterIsNotNull(paramOnAnimationUpdateListener, "listener");
    b();
    FlingAnimation localFlingAnimation = new FlingAnimation(new FloatValueHolder());
    localFlingAnimation.setStartVelocity(paramFloat1 / this.b);
    localFlingAnimation.setStartValue(paramFloat2);
    localFlingAnimation.setMinValue(0.0F);
    localFlingAnimation.setMaxValue(paramFloat3);
    localFlingAnimation.addUpdateListener(paramOnAnimationUpdateListener);
    localFlingAnimation.start();
    this.a = localFlingAnimation;
  }
  
  public final boolean a()
  {
    FlingAnimation localFlingAnimation = this.a;
    if (localFlingAnimation != null) {
      return localFlingAnimation.isRunning();
    }
    return false;
  }
  
  public final void b()
  {
    FlingAnimation localFlingAnimation = this.a;
    if (localFlingAnimation != null) {
      localFlingAnimation.cancel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.scroll.FlingHelper
 * JD-Core Version:    0.7.0.1
 */