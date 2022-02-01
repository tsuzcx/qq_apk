package com.tencent.mobileqq.webview.swift.component;

import com.tencent.mobileqq.qrscan.ScannerResult;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;

class SwiftBrowserLongClickHandler$4$3
  implements Runnable
{
  SwiftBrowserLongClickHandler$4$3(SwiftBrowserLongClickHandler.4 param4, ScannerResult paramScannerResult) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SwiftBrowserLongClickHandler", 2, "showQR Button");
    }
    if (this.a.h()) {
      this.b.this$0.a.addButton(2131890808);
    }
    if (this.a.g()) {
      this.b.this$0.a.addButton(2131890807);
    }
    this.b.this$0.a.updateAllButton();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserLongClickHandler.4.3
 * JD-Core Version:    0.7.0.1
 */