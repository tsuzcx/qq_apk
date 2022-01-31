package com.tencent.mobileqq.webview.webso;

import android.os.Handler;
import android.text.TextUtils;
import bche;

class WebSoService$4
  implements Runnable
{
  WebSoService$4(WebSoService paramWebSoService, WebSoService.WebSoState paramWebSoState, String paramString, Handler paramHandler) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState.jdField_b_of_type_JavaLangString = bche.d(this.jdField_a_of_type_JavaLangString);
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState.jdField_b_of_type_JavaLangString)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState.f = true;
    this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState.jdField_b_of_type_Boolean = true;
    WebSoService.a(this.this$0, this.jdField_a_of_type_AndroidOsHandler, this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.webso.WebSoService.4
 * JD-Core Version:    0.7.0.1
 */