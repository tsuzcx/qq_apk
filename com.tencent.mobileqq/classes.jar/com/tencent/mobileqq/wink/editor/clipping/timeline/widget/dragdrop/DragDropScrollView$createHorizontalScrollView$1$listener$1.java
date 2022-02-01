package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop;

import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationUpdateListener;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Landroidx/dynamicanimation/animation/DynamicAnimation;", "kotlin.jvm.PlatformType", "value", "", "<anonymous parameter 2>", "onAnimationUpdate"}, k=3, mv={1, 1, 16})
final class DragDropScrollView$createHorizontalScrollView$1$listener$1
  implements DynamicAnimation.OnAnimationUpdateListener
{
  DragDropScrollView$createHorizontalScrollView$1$listener$1(DragDropScrollView.createHorizontalScrollView.1 param1) {}
  
  public final void onAnimationUpdate(DynamicAnimation<DynamicAnimation<?>> paramDynamicAnimation, float paramFloat1, float paramFloat2)
  {
    paramDynamicAnimation = this.a;
    paramDynamicAnimation.scrollTo((int)paramFloat1, paramDynamicAnimation.getScrollY());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.DragDropScrollView.createHorizontalScrollView.1.listener.1
 * JD-Core Version:    0.7.0.1
 */