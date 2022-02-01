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
    if ((this.this$0.d != null) && (this.this$0.d.isShowing())) {
      this.this$0.d.dismiss();
    }
    QQToast.makeText(this.this$0.f.getApplicationContext(), 1, 2131914169, 1).show(this.this$0.g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserLongClickHandler.6
 * JD-Core Version:    0.7.0.1
 */