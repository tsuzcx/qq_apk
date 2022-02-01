package com.tencent.mobileqq.webview.webso;

import android.text.TextUtils;

class WebSoService$6
  implements WebSoService.CallBack
{
  WebSoService$6(WebSoService paramWebSoService, WebSoService.WebSoState paramWebSoState) {}
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState.a = 10004;
    }
    this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState.b = paramString;
    this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState.e = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webview.webso.WebSoService.6
 * JD-Core Version:    0.7.0.1
 */