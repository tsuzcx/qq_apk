package com.tencent.mobileqq.unifiedebug;

import aztj;
import aztk;
import aztl;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.qphone.base.util.QLog;

class SnapshotService$1
  implements Runnable
{
  SnapshotService$1(SnapshotService paramSnapshotService, aztl paramaztl, aztj paramaztj) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i(SnapshotService.a(), 2, "start once debug, webview id =" + aztl.a(this.jdField_a_of_type_Aztl) + ", seq=" + this.jdField_a_of_type_Aztj.a);
    }
    this.jdField_a_of_type_Aztl.a.mWebview.invalidate();
    if (this.jdField_a_of_type_Aztl.a.mWebview.getX5WebViewExtension() != null) {
      this.jdField_a_of_type_Aztl.a.mWebview.loadUrl("javascript:window.scrollTo(0, 0);");
    }
    for (;;)
    {
      SnapshotService.a(this.this$0, this.jdField_a_of_type_Aztj, this.jdField_a_of_type_Aztl);
      return;
      this.jdField_a_of_type_Aztl.a.mWebview.pageUp(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.unifiedebug.SnapshotService.1
 * JD-Core Version:    0.7.0.1
 */