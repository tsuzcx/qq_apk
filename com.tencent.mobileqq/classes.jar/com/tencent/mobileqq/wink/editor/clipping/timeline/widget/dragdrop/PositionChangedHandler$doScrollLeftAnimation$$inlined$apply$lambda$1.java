package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "onAnimationUpdate", "com/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/PositionChangedHandler$doScrollLeftAnimation$1$1"}, k=3, mv={1, 1, 16})
final class PositionChangedHandler$doScrollLeftAnimation$$inlined$apply$lambda$1
  implements ValueAnimator.AnimatorUpdateListener
{
  PositionChangedHandler$doScrollLeftAnimation$$inlined$apply$lambda$1(PositionChangedHandler paramPositionChangedHandler, int paramInt1, int paramInt2, IDragView paramIDragView, int paramInt3) {}
  
  public final void onAnimationUpdate(@NotNull ValueAnimator paramValueAnimator)
  {
    Intrinsics.checkParameterIsNotNull(paramValueAnimator, "animation");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator != null)
    {
      int i = ((Integer)paramValueAnimator).intValue();
      PositionChangedHandler.a(this.a, this.c + i);
      paramValueAnimator = this.d;
      paramValueAnimator.setDragViewModel(DragViewModel.a(paramValueAnimator.getDragViewModel(), null, PositionChangedHandler.a(this.a), 0, 0L, 0, null, null, 125, null));
      PositionChangedHandler.b(this.a).b(this.d);
      PositionChangedHandler.b(this.a).a(this.e + i, 0);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.PositionChangedHandler.doScrollLeftAnimation..inlined.apply.lambda.1
 * JD-Core Version:    0.7.0.1
 */