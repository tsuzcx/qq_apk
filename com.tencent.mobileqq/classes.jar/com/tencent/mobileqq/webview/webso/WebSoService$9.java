package com.tencent.mobileqq.webview.webso;

import android.net.Uri;

final class WebSoService$9
  implements Runnable
{
  WebSoService$9(String paramString1, String paramString2, String paramString3, String paramString4, Uri paramUri, WebSoService.WebSoState paramWebSoState, boolean paramBoolean, WebSoService.CallBack paramCallBack) {}
  
  public void run()
  {
    String str = WebSoService.a(this.jdField_a_of_type_JavaLangString, this.b, this.c, this.d, this.jdField_a_of_type_AndroidNetUri, this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState, this.jdField_a_of_type_Boolean);
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$CallBack == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$CallBack.a(str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webview.webso.WebSoService.9
 * JD-Core Version:    0.7.0.1
 */