package com.tencent.mobileqq.webview.ui;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.Transformation;
import com.tencent.mobileqq.utils.ValueAnimation;
import com.tencent.mobileqq.utils.ValueAnimation.AnimationUpdateListener;

class WebViewTitlerBar$3
  implements ValueAnimation.AnimationUpdateListener<Integer>
{
  WebViewTitlerBar$3(WebViewTitlerBar paramWebViewTitlerBar, int paramInt) {}
  
  public void a(ValueAnimation<Integer> paramValueAnimation, float paramFloat, Integer paramInteger, Transformation paramTransformation)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTitlerBar.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTitlerBar.jdField_a_of_type_AndroidViewView.getBackground().mutate().setAlpha(paramInteger.intValue());
    this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTitlerBar.jdField_a_of_type_Int = paramInteger.intValue();
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTitlerBar.jdField_a_of_type_Int == this.jdField_a_of_type_Int) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTitlerBar.jdField_a_of_type_Boolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.ui.WebViewTitlerBar.3
 * JD-Core Version:    0.7.0.1
 */