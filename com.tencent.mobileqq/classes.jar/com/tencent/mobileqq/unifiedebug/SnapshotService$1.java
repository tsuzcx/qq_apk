package com.tencent.mobileqq.unifiedebug;

import bctv;
import bctw;
import bctx;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.qphone.base.util.QLog;

class SnapshotService$1
  implements Runnable
{
  SnapshotService$1(SnapshotService paramSnapshotService, bctx parambctx, bctv parambctv) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i(SnapshotService.a(), 2, "start once debug, webview id =" + bctx.a(this.jdField_a_of_type_Bctx) + ", seq=" + this.jdField_a_of_type_Bctv.a);
    }
    this.jdField_a_of_type_Bctx.a.mWebview.invalidate();
    if (this.jdField_a_of_type_Bctx.a.mWebview.getX5WebViewExtension() != null) {
      this.jdField_a_of_type_Bctx.a.mWebview.loadUrl("javascript:window.scrollTo(0, 0);");
    }
    for (;;)
    {
      SnapshotService.a(this.this$0, this.jdField_a_of_type_Bctv, this.jdField_a_of_type_Bctx);
      return;
      this.jdField_a_of_type_Bctx.a.mWebview.pageUp(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.unifiedebug.SnapshotService.1
 * JD-Core Version:    0.7.0.1
 */