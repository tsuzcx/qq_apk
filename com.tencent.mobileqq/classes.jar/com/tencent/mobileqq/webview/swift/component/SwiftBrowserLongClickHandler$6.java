package com.tencent.mobileqq.webview.swift.component;

import android.app.Activity;
import bhpf;
import biau;
import com.tencent.mobileqq.widget.QQToast;

public class SwiftBrowserLongClickHandler$6
  implements Runnable
{
  public SwiftBrowserLongClickHandler$6(bhpf parambhpf) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_Biau != null) && (this.this$0.jdField_a_of_type_Biau.isShowing())) {
      this.this$0.jdField_a_of_type_Biau.dismiss();
    }
    QQToast.a(this.this$0.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), 1, 2131715855, 1).b(this.this$0.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserLongClickHandler.6
 * JD-Core Version:    0.7.0.1
 */