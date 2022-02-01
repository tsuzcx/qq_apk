package com.tencent.mobileqq.vas.troopgift;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.libpag.PAGFile;
import org.libpag.PAGView;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"}, k=3, mv={1, 1, 16})
final class TroopGiftComboView$startComboAnimation$2$1
  implements ValueAnimator.AnimatorUpdateListener
{
  TroopGiftComboView$startComboAnimation$2$1(TroopGiftComboView.startComboAnimation.2 param2, PAGView paramPAGView) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    Intrinsics.checkExpressionValueIsNotNull(paramValueAnimator, "it");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null) {
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Float");
    }
    int i = (int)(((Float)paramValueAnimator).floatValue() * this.jdField_a_of_type_ComTencentMobileqqVasTroopgiftTroopGiftComboView$startComboAnimation$2.$comboTimes);
    paramValueAnimator = this.jdField_a_of_type_OrgLibpagPAGView.getFile();
    if (paramValueAnimator != null) {}
    for (paramValueAnimator = paramValueAnimator.getTextData(0);; paramValueAnimator = null)
    {
      if (paramValueAnimator != null) {
        paramValueAnimator.text = String.valueOf(i);
      }
      this.jdField_a_of_type_OrgLibpagPAGView.setTextData(0, paramValueAnimator);
      this.jdField_a_of_type_OrgLibpagPAGView.flush();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopgift.TroopGiftComboView.startComboAnimation.2.1
 * JD-Core Version:    0.7.0.1
 */