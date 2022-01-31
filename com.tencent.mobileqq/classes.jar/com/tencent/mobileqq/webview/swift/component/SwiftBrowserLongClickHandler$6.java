package com.tencent.mobileqq.webview.swift.component;

import android.app.Activity;
import beds;
import bepp;
import com.tencent.mobileqq.widget.QQToast;

public class SwiftBrowserLongClickHandler$6
  implements Runnable
{
  public SwiftBrowserLongClickHandler$6(beds parambeds) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_Bepp != null) && (this.this$0.jdField_a_of_type_Bepp.isShowing())) {
      this.this$0.jdField_a_of_type_Bepp.dismiss();
    }
    QQToast.a(this.this$0.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), 1, 2131717618, 1).b(this.this$0.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserLongClickHandler.6
 * JD-Core Version:    0.7.0.1
 */