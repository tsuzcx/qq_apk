package com.tencent.mobileqq.webview.swift.component;

import com.tencent.biz.qrcode.activity.ScannerResult;
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
    if (this.jdField_a_of_type_ComTencentBizQrcodeActivityScannerResult.d()) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserLongClickHandler$4.this$0.a.addButton(2131693306);
    }
    if (this.jdField_a_of_type_ComTencentBizQrcodeActivityScannerResult.c()) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserLongClickHandler$4.this$0.a.addButton(2131693305);
    }
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserLongClickHandler$4.this$0.a.updateAllButton();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserLongClickHandler.4.3
 * JD-Core Version:    0.7.0.1
 */