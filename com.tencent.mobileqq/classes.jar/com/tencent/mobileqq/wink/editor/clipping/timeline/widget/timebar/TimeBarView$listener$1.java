package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.timebar;

import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationUpdateListener;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Landroidx/dynamicanimation/animation/DynamicAnimation;", "kotlin.jvm.PlatformType", "value", "", "<anonymous parameter 2>", "onAnimationUpdate"}, k=3, mv={1, 1, 16})
final class TimeBarView$listener$1
  implements DynamicAnimation.OnAnimationUpdateListener
{
  TimeBarView$listener$1(TimeBarView paramTimeBarView) {}
  
  public final void onAnimationUpdate(DynamicAnimation<DynamicAnimation<?>> paramDynamicAnimation, float paramFloat1, float paramFloat2)
  {
    paramDynamicAnimation = TimeBarView.a(this.a);
    if (paramDynamicAnimation != null) {
      paramDynamicAnimation.b((int)paramFloat1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.widget.timebar.TimeBarView.listener.1
 * JD-Core Version:    0.7.0.1
 */