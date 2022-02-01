package com.tencent.mobileqq.utils;

import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import com.tencent.qphone.base.util.QLog;

class ApolloLottieAnim$1
  implements OnCompositionLoadedListener
{
  ApolloLottieAnim$1(ApolloLottieAnim paramApolloLottieAnim, DiniFlyAnimationView paramDiniFlyAnimationView, boolean paramBoolean) {}
  
  public void onCompositionLoaded(LottieComposition paramLottieComposition)
  {
    if (paramLottieComposition == null) {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloLottieAnim", 2, "composition is null ,return");
      }
    }
    do
    {
      return;
      if (!ApolloLottieAnim.a(this.jdField_a_of_type_ComTencentMobileqqUtilsApolloLottieAnim)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloLottieAnim", 2, "anim is destroy ,return");
    return;
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setComposition(paramLottieComposition);
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setImageAssetDelegate(new ApolloLottieAnim.1.1(this));
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.playAnimation();
    }
    ApolloLottieAnim.a(this.jdField_a_of_type_ComTencentMobileqqUtilsApolloLottieAnim, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ApolloLottieAnim.1
 * JD-Core Version:    0.7.0.1
 */