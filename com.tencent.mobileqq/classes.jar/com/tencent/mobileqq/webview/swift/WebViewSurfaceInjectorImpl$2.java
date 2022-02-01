package com.tencent.mobileqq.webview.swift;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.bigbrother.TeleScreenRunnable;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

class WebViewSurfaceInjectorImpl$2
  implements TeleScreenRunnable
{
  WebViewSurfaceInjectorImpl$2(WebViewSurfaceInjectorImpl paramWebViewSurfaceInjectorImpl, WebViewProvider paramWebViewProvider, Intent paramIntent, boolean paramBoolean1, String paramString, boolean paramBoolean2, long paramLong) {}
  
  public void run()
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getHostActivity().startActivity(this.jdField_a_of_type_AndroidContentIntent);
      if ((this.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
      {
        boolean bool1 = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("keyIsDownLoad", false);
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getHostActivity().finish();
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("forcedClosedAfterJump appName=");
          ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
          QLog.d("WebViewSurfaceInjectorImpl", 2, ((StringBuilder)localObject).toString());
        }
        boolean bool2 = this.b;
        Object localObject = "";
        if ((bool2) && (!bool1))
        {
          if (this.jdField_a_of_type_Long != -1L) {
            localObject = String.valueOf(this.jdField_a_of_type_Long);
          }
          ReportController.b(null, "dc00898", "", "", "0X800A86A", "0X800A86A", 0, 0, (String)localObject, "", "", "");
          return;
        }
        if (this.b)
        {
          if (this.jdField_a_of_type_Long != -1L) {
            localObject = String.valueOf(this.jdField_a_of_type_Long);
          }
          ReportController.b(null, "dc00898", "", "", "0X800A86B", "0X800A86B", 0, 0, (String)localObject, "", "", "");
          return;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("WebViewSurfaceInjectorImpl", 1, localThrowable, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.WebViewSurfaceInjectorImpl.2
 * JD-Core Version:    0.7.0.1
 */