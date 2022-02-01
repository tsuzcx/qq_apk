package com.tencent.mobileqq.webview.webso;

import android.os.Handler;
import android.text.TextUtils;

class WebSoService$4
  implements Runnable
{
  WebSoService$4(WebSoService paramWebSoService, WebSoService.WebSoState paramWebSoState, String paramString, Handler paramHandler) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState.jdField_b_of_type_JavaLangString = WebSoUtils.d(this.jdField_a_of_type_JavaLangString);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("读取缓存:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState.jdField_b_of_type_JavaLangString);
    WebSoUtils.a(((StringBuilder)localObject).toString());
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState.jdField_b_of_type_JavaLangString)) {
      return;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState;
    ((WebSoService.WebSoState)localObject).f = true;
    ((WebSoService.WebSoState)localObject).jdField_b_of_type_Boolean = true;
    WebSoService.a(this.this$0, this.jdField_a_of_type_AndroidOsHandler, (WebSoService.WebSoState)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.webso.WebSoService.4
 * JD-Core Version:    0.7.0.1
 */