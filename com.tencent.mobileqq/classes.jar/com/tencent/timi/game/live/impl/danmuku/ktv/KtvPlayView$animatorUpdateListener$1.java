package com.tencent.timi.game.live.impl.danmuku.ktv;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"}, k=3, mv={1, 1, 16})
final class KtvPlayView$animatorUpdateListener$1
  implements ValueAnimator.AnimatorUpdateListener
{
  KtvPlayView$animatorUpdateListener$1(KtvPlayView paramKtvPlayView) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (paramValueAnimator != null)
    {
      KtvPlayView localKtvPlayView = this.a;
      Object localObject = paramValueAnimator.getAnimatedValue();
      paramValueAnimator = localObject;
      if (!(localObject instanceof Float)) {
        paramValueAnimator = null;
      }
      paramValueAnimator = (Float)paramValueAnimator;
      float f;
      if (paramValueAnimator != null) {
        f = paramValueAnimator.floatValue();
      } else {
        f = 0.0F;
      }
      KtvPlayView.a(localKtvPlayView, f);
      this.a.invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.live.impl.danmuku.ktv.KtvPlayView.animatorUpdateListener.1
 * JD-Core Version:    0.7.0.1
 */