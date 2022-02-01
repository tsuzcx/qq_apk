package com.tencent.mobileqq.webview.swift.component;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import bigy;
import bkzi;
import com.tencent.biz.qrcode.activity.ScannerResult;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.CookieManager;
import java.io.File;
import nwh;
import nwo;
import zmk;

public class SwiftBrowserLongClickHandler$4
  implements Runnable
{
  public SwiftBrowserLongClickHandler$4(bigy parambigy, String paramString) {}
  
  public void run()
  {
    ??? = new Bundle();
    if (this.this$0.jdField_a_of_type_ComTencentSmttSdkCookieManager == null)
    {
      this.this$0.jdField_a_of_type_ComTencentSmttSdkCookieManager = CookieManager.getInstance();
      this.this$0.jdField_a_of_type_ComTencentSmttSdkCookieManager.setAcceptCookie(true);
    }
    Object localObject2 = this.this$0.jdField_a_of_type_ComTencentSmttSdkCookieManager.getCookie(this.a);
    if (localObject2 != null)
    {
      ((Bundle)???).putString("Cookie", (String)localObject2);
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserLongClickHandler", 2, "Get cookie: " + nwo.c((String)localObject2, new String[0]) + " from " + nwo.b(this.a, new String[0]));
      }
    }
    ??? = nwh.a(BaseApplication.getContext(), this.a, (Bundle)???);
    this.this$0.jdField_b_of_type_JavaLangString = ((String)???);
    if (QLog.isColorLevel()) {
      QLog.d("SwiftBrowserLongClickHandler", 2, "saveImage filepath = " + this.this$0.jdField_b_of_type_JavaLangString);
    }
    if (??? == null) {
      this.this$0.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new SwiftBrowserLongClickHandler.4.1(this));
    }
    for (;;)
    {
      return;
      if (this.this$0.jdField_b_of_type_Int == 0)
      {
        this.this$0.b((String)???);
        this.this$0.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new SwiftBrowserLongClickHandler.4.2(this));
        return;
      }
      if (this.this$0.jdField_b_of_type_Int == 1)
      {
        this.this$0.a((String)???);
        return;
      }
      if (this.this$0.jdField_b_of_type_Int == 2)
      {
        this.this$0.c((String)???);
        return;
      }
      localObject2 = zmk.a(Uri.parse("file://" + new File((String)???).getAbsolutePath()), this.this$0.jdField_a_of_type_AndroidAppActivity, 3);
      if (localObject2 == null) {
        continue;
      }
      synchronized (this.this$0.jdField_a_of_type_JavaLangObject)
      {
        this.this$0.c = this.this$0.jdField_b_of_type_JavaLangString;
        this.this$0.jdField_a_of_type_ComTencentBizQrcodeActivityScannerResult = ((ScannerResult)localObject2);
        if (!this.this$0.jdField_a_of_type_Bkzi.isShowing()) {
          continue;
        }
        this.this$0.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new SwiftBrowserLongClickHandler.4.3(this, (ScannerResult)localObject2));
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserLongClickHandler.4
 * JD-Core Version:    0.7.0.1
 */