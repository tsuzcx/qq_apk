package com.tencent.mobileqq.vas.troopgift;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.libpag.PAGFile;
import org.libpag.PAGView;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"}, k=3, mv={1, 1, 16})
final class TroopGiftComboXAController$setComboAnimationForXA$2$1
  implements ValueAnimator.AnimatorUpdateListener
{
  TroopGiftComboXAController$setComboAnimationForXA$2$1(TroopGiftComboXAController.setComboAnimationForXA.2 param2, PAGView paramPAGView) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    Intrinsics.checkExpressionValueIsNotNull(paramValueAnimator, "it");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator != null)
    {
      float f = ((Float)paramValueAnimator).floatValue();
      int i = (int)(this.jdField_a_of_type_ComTencentMobileqqVasTroopgiftTroopGiftComboXAController$setComboAnimationForXA$2.$comboTimes * f);
      paramValueAnimator = this.jdField_a_of_type_OrgLibpagPAGView.getFile();
      if (paramValueAnimator != null) {
        paramValueAnimator = paramValueAnimator.getTextData(0);
      } else {
        paramValueAnimator = null;
      }
      if (paramValueAnimator != null) {
        paramValueAnimator.text = String.valueOf(i);
      }
      this.jdField_a_of_type_OrgLibpagPAGView.setTextData(0, paramValueAnimator);
      this.jdField_a_of_type_OrgLibpagPAGView.flush();
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.Float");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopgift.TroopGiftComboXAController.setComboAnimationForXA.2.1
 * JD-Core Version:    0.7.0.1
 */