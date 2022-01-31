package com.tencent.mobileqq.unifiedebug;

import bcye;
import bcyf;
import bcyg;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.qphone.base.util.QLog;

class SnapshotService$1
  implements Runnable
{
  SnapshotService$1(SnapshotService paramSnapshotService, bcyg parambcyg, bcye parambcye) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i(SnapshotService.a(), 2, "start once debug, webview id =" + bcyg.a(this.jdField_a_of_type_Bcyg) + ", seq=" + this.jdField_a_of_type_Bcye.a);
    }
    this.jdField_a_of_type_Bcyg.a.mWebview.invalidate();
    if (this.jdField_a_of_type_Bcyg.a.mWebview.getX5WebViewExtension() != null) {
      this.jdField_a_of_type_Bcyg.a.mWebview.loadUrl("javascript:window.scrollTo(0, 0);");
    }
    for (;;)
    {
      SnapshotService.a(this.this$0, this.jdField_a_of_type_Bcye, this.jdField_a_of_type_Bcyg);
      return;
      this.jdField_a_of_type_Bcyg.a.mWebview.pageUp(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.unifiedebug.SnapshotService.1
 * JD-Core Version:    0.7.0.1
 */