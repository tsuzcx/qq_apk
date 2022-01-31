package com.tencent.mobileqq.webview.swift.component;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import beib;
import bhuf;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.CookieManager;
import java.io.File;
import ndi;
import ndq;
import yak;

public class SwiftBrowserLongClickHandler$4
  implements Runnable
{
  public SwiftBrowserLongClickHandler$4(beib parambeib, String paramString) {}
  
  public void run()
  {
    ??? = new Bundle();
    if (this.this$0.jdField_a_of_type_ComTencentSmttSdkCookieManager == null)
    {
      this.this$0.jdField_a_of_type_ComTencentSmttSdkCookieManager = CookieManager.getInstance();
      this.this$0.jdField_a_of_type_ComTencentSmttSdkCookieManager.setAcceptCookie(true);
    }
    String str = this.this$0.jdField_a_of_type_ComTencentSmttSdkCookieManager.getCookie(this.a);
    if (str != null)
    {
      ((Bundle)???).putString("Cookie", str);
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserLongClickHandler", 2, "Get cookie: " + ndq.c(str, new String[0]) + " from " + ndq.b(this.a, new String[0]));
      }
    }
    ??? = ndi.a(BaseApplication.getContext(), this.a, (Bundle)???);
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
      int i = yak.a(Uri.parse("file://" + new File((String)???).getAbsolutePath()), this.this$0.jdField_a_of_type_AndroidAppActivity, 3);
      if (i <= 0) {
        continue;
      }
      synchronized (this.this$0.jdField_a_of_type_JavaLangObject)
      {
        this.this$0.jdField_c_of_type_JavaLangString = this.this$0.jdField_b_of_type_JavaLangString;
        this.this$0.jdField_c_of_type_Int = i;
        if (!this.this$0.jdField_a_of_type_Bhuf.isShowing()) {
          continue;
        }
        this.this$0.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new SwiftBrowserLongClickHandler.4.3(this, i));
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserLongClickHandler.4
 * JD-Core Version:    0.7.0.1
 */