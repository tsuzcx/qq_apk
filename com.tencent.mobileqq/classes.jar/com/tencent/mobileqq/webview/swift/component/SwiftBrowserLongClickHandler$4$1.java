package com.tencent.mobileqq.webview.swift.component;

import android.app.Activity;
import biqa;
import bjbs;
import com.tencent.mobileqq.widget.QQToast;

class SwiftBrowserLongClickHandler$4$1
  implements Runnable
{
  SwiftBrowserLongClickHandler$4$1(SwiftBrowserLongClickHandler.4 param4) {}
  
  public void run()
  {
    if ((this.a.this$0.jdField_a_of_type_Bjbs != null) && (this.a.this$0.jdField_a_of_type_Bjbs.isShowing())) {
      this.a.this$0.jdField_a_of_type_Bjbs.dismiss();
    }
    QQToast.a(this.a.this$0.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), 1, 2131715964, 1).b(this.a.this$0.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserLongClickHandler.4.1
 * JD-Core Version:    0.7.0.1
 */