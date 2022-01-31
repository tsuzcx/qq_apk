package com.tencent.mobileqq.webview.swift.component;

import android.app.Activity;
import bbbd;
import bbms;
import bbmy;

public class SwiftBrowserLongClickHandler$6
  implements Runnable
{
  public SwiftBrowserLongClickHandler$6(bbbd parambbbd) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_Bbms != null) && (this.this$0.jdField_a_of_type_Bbms.isShowing())) {
      this.this$0.jdField_a_of_type_Bbms.dismiss();
    }
    bbmy.a(this.this$0.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), 1, 2131651443, 1).b(this.this$0.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserLongClickHandler.6
 * JD-Core Version:    0.7.0.1
 */