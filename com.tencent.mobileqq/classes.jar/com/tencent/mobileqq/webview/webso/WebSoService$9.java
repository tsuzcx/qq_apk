package com.tencent.mobileqq.webview.webso;

import android.net.Uri;
import bijt;

final class WebSoService$9
  implements Runnable
{
  WebSoService$9(String paramString1, String paramString2, String paramString3, String paramString4, Uri paramUri, WebSoService.WebSoState paramWebSoState, boolean paramBoolean, bijt parambijt) {}
  
  public void run()
  {
    String str = WebSoService.a(this.jdField_a_of_type_JavaLangString, this.b, this.c, this.d, this.jdField_a_of_type_AndroidNetUri, this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState, this.jdField_a_of_type_Boolean);
    if (this.jdField_a_of_type_Bijt == null) {
      return;
    }
    this.jdField_a_of_type_Bijt.a(str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.webso.WebSoService.9
 * JD-Core Version:    0.7.0.1
 */