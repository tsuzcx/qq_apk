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
      String str = SnapshotService.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("start once debug, webview id =");
      localStringBuilder.append(SnapshotService.Snapshot.a(this.jdField_a_of_type_ComTencentMobileqqUnifiedebugSnapshotService$Snapshot));
      localStringBuilder.append(", seq=");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqUnifiedebugSnapshotService$DebugCommand.a);
      QLog.i(str, 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqUnifiedebugSnapshotService$Snapshot.a.mWebview.invalidate();
    if (this.jdField_a_of_type_ComTencentMobileqqUnifiedebugSnapshotService$Snapshot.a.mWebview.getX5WebViewExtension() != null) {
      this.jdField_a_of_type_ComTencentMobileqqUnifiedebugSnapshotService$Snapshot.a.mWebview.loadUrl("javascript:window.scrollTo(0, 0);");
    } else {
      this.jdField_a_of_type_ComTencentMobileqqUnifiedebugSnapshotService$Snapshot.a.mWebview.pageUp(true);
    }
    SnapshotService.a(this.this$0, this.jdField_a_of_type_ComTencentMobileqqUnifiedebugSnapshotService$DebugCommand, this.jdField_a_of_type_ComTencentMobileqqUnifiedebugSnapshotService$Snapshot);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.unifiedebug.SnapshotService.1
 * JD-Core Version:    0.7.0.1
 */