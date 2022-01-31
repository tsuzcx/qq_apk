package com.tencent.mobileqq.webview.swift.component;

import android.app.Activity;
import bbbd;
import bbms;
import bbmy;

class SwiftBrowserLongClickHandler$4$1
  implements Runnable
{
  SwiftBrowserLongClickHandler$4$1(SwiftBrowserLongClickHandler.4 param4) {}
  
  public void run()
  {
    if ((this.a.this$0.jdField_a_of_type_Bbms != null) && (this.a.this$0.jdField_a_of_type_Bbms.isShowing())) {
      this.a.this$0.jdField_a_of_type_Bbms.dismiss();
    }
    bbmy.a(this.a.this$0.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), 1, 2131651443, 1).b(this.a.this$0.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserLongClickHandler.4.1
 * JD-Core Version:    0.7.0.1
 */