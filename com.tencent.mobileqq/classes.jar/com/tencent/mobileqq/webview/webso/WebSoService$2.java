package com.tencent.mobileqq.webview.webso;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;

class WebSoService$2
  implements WebSoService.CallBack
{
  WebSoService$2(WebSoService paramWebSoService, long paramLong, WebSoService.WebSoState paramWebSoState, Handler paramHandler) {}
  
  public void a(String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("verifyHtmlData cost=");
      ((StringBuilder)localObject).append(System.currentTimeMillis() - this.jdField_a_of_type_Long);
      QLog.d("WebSoService", 2, ((StringBuilder)localObject).toString());
    }
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState;
      if ((localObject != null) && (((WebSoService.WebSoState)localObject).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 2))
      {
        this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.jdField_b_of_type_Boolean = true;
        localObject = this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState;
        ((WebSoService.WebSoState)localObject).jdField_b_of_type_JavaLangString = paramString;
        ((WebSoService.WebSoState)localObject).jdField_b_of_type_Boolean = true;
        ((WebSoService.WebSoState)localObject).f = true;
        ((WebSoService.WebSoState)localObject).e = false;
        WebSoUtils.a("load from cache");
        WebSoService.a(this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService, this.jdField_a_of_type_AndroidOsHandler, this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.webso.WebSoService.2
 * JD-Core Version:    0.7.0.1
 */