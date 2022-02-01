package com.tencent.mobileqq.webview.swift.component;

import android.app.Activity;
import biqa;
import bjbs;
import com.tencent.mobileqq.widget.QQToast;

public class SwiftBrowserLongClickHandler$6
  implements Runnable
{
  public SwiftBrowserLongClickHandler$6(biqa parambiqa) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_Bjbs != null) && (this.this$0.jdField_a_of_type_Bjbs.isShowing())) {
      this.this$0.jdField_a_of_type_Bjbs.dismiss();
    }
    QQToast.a(this.this$0.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), 1, 2131715964, 1).b(this.this$0.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserLongClickHandler.6
 * JD-Core Version:    0.7.0.1
 */