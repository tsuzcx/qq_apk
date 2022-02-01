package com.tencent.mobileqq.webview.webso;

import android.text.TextUtils;
import java.util.concurrent.atomic.AtomicInteger;

class WebSoService$8
  implements WebSoService.CallBack
{
  WebSoService$8(WebSoService paramWebSoService, WebSoService.WebSoState paramWebSoState, long paramLong) {}
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState.jdField_a_of_type_Int = 10003;
    }
    this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState.jdField_b_of_type_JavaLangString = paramString;
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState.e)) && (this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 1)) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState.g = true;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState.f = false;
      this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.d = ((int)(System.currentTimeMillis() - this.jdField_a_of_type_Long));
      this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService.a(this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState);
      return;
      this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState.jdField_a_of_type_Boolean = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webview.webso.WebSoService.8
 * JD-Core Version:    0.7.0.1
 */