package com.tencent.mobileqq.unifiedebug;

import baun;
import bauo;
import baup;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.qphone.base.util.QLog;

class SnapshotService$1
  implements Runnable
{
  SnapshotService$1(SnapshotService paramSnapshotService, baup parambaup, baun parambaun) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i(SnapshotService.a(), 2, "start once debug, webview id =" + baup.a(this.jdField_a_of_type_Baup) + ", seq=" + this.jdField_a_of_type_Baun.a);
    }
    this.jdField_a_of_type_Baup.a.mWebview.invalidate();
    if (this.jdField_a_of_type_Baup.a.mWebview.getX5WebViewExtension() != null) {
      this.jdField_a_of_type_Baup.a.mWebview.loadUrl("javascript:window.scrollTo(0, 0);");
    }
    for (;;)
    {
      SnapshotService.a(this.this$0, this.jdField_a_of_type_Baun, this.jdField_a_of_type_Baup);
      return;
      this.jdField_a_of_type_Baup.a.mWebview.pageUp(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.unifiedebug.SnapshotService.1
 * JD-Core Version:    0.7.0.1
 */