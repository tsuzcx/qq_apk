package com.tencent.mobileqq.webview.swift;

import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.biz.widgets.Hole;

class SwiftFloatViewUI$1
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  SwiftFloatViewUI$1(SwiftFloatViewUI paramSwiftFloatViewUI, View paramView, DisplayMetrics paramDisplayMetrics) {}
  
  public void onGlobalLayout()
  {
    if (Build.VERSION.SDK_INT >= 16) {
      this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    } else {
      this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.jdField_a_of_type_ComTencentBizWidgetsHole.setHole((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.jdField_a_of_type_AndroidViewView.getLeft() + this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.jdField_a_of_type_AndroidViewView.getRight()) / 2 - 1, (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.jdField_a_of_type_AndroidViewView.getTop() + this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.jdField_a_of_type_AndroidViewView.getBottom()) / 2 - 1, (int)(this.jdField_a_of_type_AndroidUtilDisplayMetrics.density * 30.0F));
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.jdField_a_of_type_ComTencentBizWidgetsHole.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.SwiftFloatViewUI.1
 * JD-Core Version:    0.7.0.1
 */