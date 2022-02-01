package com.tencent.mobileqq.webview.swift.component;

import android.app.Activity;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;

class SwiftBrowserLongClickHandler$6
  implements Runnable
{
  SwiftBrowserLongClickHandler$6(SwiftBrowserLongClickHandler paramSwiftBrowserLongClickHandler) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    QQToast.a(this.this$0.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), 1, 2131717052, 1).b(this.this$0.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserLongClickHandler.6
 * JD-Core Version:    0.7.0.1
 */