package com.tencent.mobileqq.vas.troopgift;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.libpag.PAGFile;
import org.libpag.PAGView;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"}, k=3, mv={1, 1, 16})
final class CommonGiftController$setComboAnimationForXA$2$1
  implements ValueAnimator.AnimatorUpdateListener
{
  CommonGiftController$setComboAnimationForXA$2$1(CommonGiftController.setComboAnimationForXA.2 param2, PAGView paramPAGView) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    Intrinsics.checkExpressionValueIsNotNull(paramValueAnimator, "it");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator != null)
    {
      float f = ((Float)paramValueAnimator).floatValue();
      int i = (int)(this.a.$comboTimes * f);
      PAGFile localPAGFile = (PAGFile)this.b.getComposition();
      if (localPAGFile != null) {
        paramValueAnimator = localPAGFile.getTextData(0);
      } else {
        paramValueAnimator = null;
      }
      if (paramValueAnimator != null) {
        paramValueAnimator.text = String.valueOf(i);
      }
      if (localPAGFile != null) {
        localPAGFile.replaceText(0, paramValueAnimator);
      }
      this.b.flush();
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.Float");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopgift.CommonGiftController.setComboAnimationForXA.2.1
 * JD-Core Version:    0.7.0.1
 */