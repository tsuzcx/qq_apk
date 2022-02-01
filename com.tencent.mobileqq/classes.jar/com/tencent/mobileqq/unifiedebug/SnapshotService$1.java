package com.tencent.mobileqq.unifiedebug;

import bgcn;
import bgco;
import bgcp;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.qphone.base.util.QLog;

class SnapshotService$1
  implements Runnable
{
  SnapshotService$1(SnapshotService paramSnapshotService, bgcp parambgcp, bgcn parambgcn) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i(SnapshotService.a(), 2, "start once debug, webview id =" + bgcp.a(this.jdField_a_of_type_Bgcp) + ", seq=" + this.jdField_a_of_type_Bgcn.a);
    }
    this.jdField_a_of_type_Bgcp.a.mWebview.invalidate();
    if (this.jdField_a_of_type_Bgcp.a.mWebview.getX5WebViewExtension() != null) {
      this.jdField_a_of_type_Bgcp.a.mWebview.loadUrl("javascript:window.scrollTo(0, 0);");
    }
    for (;;)
    {
      SnapshotService.a(this.this$0, this.jdField_a_of_type_Bgcn, this.jdField_a_of_type_Bgcp);
      return;
      this.jdField_a_of_type_Bgcp.a.mWebview.pageUp(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.unifiedebug.SnapshotService.1
 * JD-Core Version:    0.7.0.1
 */