package com.tencent.mobileqq.olympic.activity;

import android.animation.ObjectAnimator;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import java.lang.ref.WeakReference;

class PromotionEntry$UpdateOperateBtnStatusRunnable$1
  implements OnCompositionLoadedListener
{
  PromotionEntry$UpdateOperateBtnStatusRunnable$1(PromotionEntry.UpdateOperateBtnStatusRunnable paramUpdateOperateBtnStatusRunnable, String paramString) {}
  
  public void onCompositionLoaded(@Nullable LottieComposition paramLottieComposition)
  {
    if (paramLottieComposition == null) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry$UpdateOperateBtnStatusRunnable.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable = new LottieDrawable();
      this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry$UpdateOperateBtnStatusRunnable.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.setComposition(paramLottieComposition);
      this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry$UpdateOperateBtnStatusRunnable.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.setImageAssetDelegate(new PromotionEntry.UpdateOperateBtnStatusRunnable.1.1(this));
      this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry$UpdateOperateBtnStatusRunnable.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.loop(true);
      paramLottieComposition = (ImageView)PromotionEntry.UpdateOperateBtnStatusRunnable.a(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry$UpdateOperateBtnStatusRunnable).get();
    } while ((paramLottieComposition == null) || (paramLottieComposition.getVisibility() != 0) || (this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry$UpdateOperateBtnStatusRunnable.jdField_a_of_type_AndroidAnimationObjectAnimator == null) || (this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry$UpdateOperateBtnStatusRunnable.jdField_a_of_type_AndroidAnimationObjectAnimator.isRunning()));
    paramLottieComposition.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry$UpdateOperateBtnStatusRunnable.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable);
    this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionEntry$UpdateOperateBtnStatusRunnable.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.playAnimation();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.activity.PromotionEntry.UpdateOperateBtnStatusRunnable.1
 * JD-Core Version:    0.7.0.1
 */