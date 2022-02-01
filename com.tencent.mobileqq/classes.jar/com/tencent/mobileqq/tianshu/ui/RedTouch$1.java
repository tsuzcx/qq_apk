package com.tencent.mobileqq.tianshu.ui;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;

class RedTouch$1
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  RedTouch$1(RedTouch paramRedTouch, String paramString) {}
  
  public void onGlobalLayout()
  {
    this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    RedTouch.a(this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.tianshu.ui.RedTouch.1
 * JD-Core Version:    0.7.0.1
 */