package com.tencent.mobileqq.webview.swift;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.Transformation;
import com.tencent.mobileqq.utils.ValueAnimation;
import com.tencent.mobileqq.utils.ValueAnimation.AnimationUpdateListener;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler.SwiftBrowserUIStyle;

class SwiftIphoneTitleBarUI$4
  implements ValueAnimation.AnimationUpdateListener<Integer>
{
  SwiftIphoneTitleBarUI$4(SwiftIphoneTitleBarUI paramSwiftIphoneTitleBarUI, View paramView, int paramInt) {}
  
  public void a(ValueAnimation<Integer> paramValueAnimation, float paramFloat, Integer paramInteger, Transformation paramTransformation)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.a.x) {}
    do
    {
      return;
      this.jdField_a_of_type_AndroidViewView.getBackground().mutate().setAlpha(paramInteger.intValue());
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.a.d = paramInteger.intValue();
    } while (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.a.d != this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.a.x = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI.4
 * JD-Core Version:    0.7.0.1
 */