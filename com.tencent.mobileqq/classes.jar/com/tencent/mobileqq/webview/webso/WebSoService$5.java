package com.tencent.mobileqq.webview.webso;

import android.text.TextUtils;

class WebSoService$5
  implements WebSoService.CallBack
{
  WebSoService$5(WebSoService paramWebSoService, WebSoService.WebSoState paramWebSoState, long paramLong) {}
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState.jdField_a_of_type_Int = 10005;
    }
    this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState.b = paramString;
    this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState.f = false;
    this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHybridWebReporter$HybridWebReportInfo.d = ((int)(System.currentTimeMillis() - this.jdField_a_of_type_Long));
    this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService.a(this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webview.webso.WebSoService.5
 * JD-Core Version:    0.7.0.1
 */