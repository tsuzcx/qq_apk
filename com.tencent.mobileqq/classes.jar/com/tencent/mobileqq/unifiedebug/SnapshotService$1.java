package com.tencent.mobileqq.unifiedebug;

import bhco;
import bhcp;
import bhcq;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.qphone.base.util.QLog;

class SnapshotService$1
  implements Runnable
{
  SnapshotService$1(SnapshotService paramSnapshotService, bhcq parambhcq, bhco parambhco) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i(SnapshotService.a(), 2, "start once debug, webview id =" + bhcq.a(this.jdField_a_of_type_Bhcq) + ", seq=" + this.jdField_a_of_type_Bhco.a);
    }
    this.jdField_a_of_type_Bhcq.a.mWebview.invalidate();
    if (this.jdField_a_of_type_Bhcq.a.mWebview.getX5WebViewExtension() != null) {
      this.jdField_a_of_type_Bhcq.a.mWebview.loadUrl("javascript:window.scrollTo(0, 0);");
    }
    for (;;)
    {
      SnapshotService.a(this.this$0, this.jdField_a_of_type_Bhco, this.jdField_a_of_type_Bhcq);
      return;
      this.jdField_a_of_type_Bhcq.a.mWebview.pageUp(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.unifiedebug.SnapshotService.1
 * JD-Core Version:    0.7.0.1
 */