package com.tencent.mobileqq.unifiedebug;

import com.tencent.biz.ui.TouchWebView;
import com.tencent.qphone.base.util.QLog;

class SnapshotService$1
  implements Runnable
{
  SnapshotService$1(SnapshotService paramSnapshotService, SnapshotService.Snapshot paramSnapshot, SnapshotService.DebugCommand paramDebugCommand) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      String str = SnapshotService.b();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("start once debug, webview id =");
      localStringBuilder.append(SnapshotService.Snapshot.a(this.a));
      localStringBuilder.append(", seq=");
      localStringBuilder.append(this.b.a);
      QLog.i(str, 2, localStringBuilder.toString());
    }
    this.a.a.mWebview.invalidate();
    if (this.a.a.mWebview.getX5WebViewExtension() != null) {
      this.a.a.mWebview.loadUrl("javascript:window.scrollTo(0, 0);");
    } else {
      this.a.a.mWebview.pageUp(true);
    }
    SnapshotService.a(this.this$0, this.b, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.unifiedebug.SnapshotService.1
 * JD-Core Version:    0.7.0.1
 */