package com.tencent.mobileqq.kandian.biz.skin;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class SlideActiveAnimController$2
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  SlideActiveAnimController$2(SlideActiveAnimController paramSlideActiveAnimController, Runnable paramRunnable) {}
  
  public void onGlobalLayout()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinSlideActiveAnimController.a();
    Runnable localRunnable = this.jdField_a_of_type_JavaLangRunnable;
    if (localRunnable != null) {
      localRunnable.run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.skin.SlideActiveAnimController.2
 * JD-Core Version:    0.7.0.1
 */