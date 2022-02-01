package com.tencent.mobileqq.webview.swift.component;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.qphone.base.util.QLog;

class SwiftBrowserScreenShotHandler$2
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  SwiftBrowserScreenShotHandler$2(SwiftBrowserScreenShotHandler paramSwiftBrowserScreenShotHandler, View paramView) {}
  
  public void onGlobalLayout()
  {
    Rect localRect = new Rect();
    this.jdField_a_of_type_AndroidViewView.getWindowVisibleDisplayFrame(localRect);
    int i = this.jdField_a_of_type_AndroidViewView.getRootView().getHeight() - localRect.height();
    if (QLog.isDevelopLevel()) {
      QLog.d("SwiftBrowserScreenShotHandler", 2, "heightDiff:" + i);
    }
    if (i > 150)
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserScreenShotHandler.c = true;
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserScreenShotHandler.a(false, 0);
    }
    while (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserScreenShotHandler.c) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserScreenShotHandler.c = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserScreenShotHandler.2
 * JD-Core Version:    0.7.0.1
 */