package com.tencent.mobileqq.webview.webso;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;

final class WebSoService$5
  implements Runnable
{
  WebSoService$5(HttpResponsePackage paramHttpResponsePackage, Uri paramUri, String paramString1, String paramString2, WebSoService.WebSoState paramWebSoState) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHttpResponsePackage;
    if ((localObject != null) && (((HttpResponsePackage)localObject).d != null))
    {
      WebSoUtils.a(this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHttpResponsePackage.d.getBytes(), WebSoUtils.b(this.jdField_a_of_type_AndroidNetUri));
      localObject = SHA1Util.a(this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoHttpResponsePackage.d);
    }
    else
    {
      localObject = "";
    }
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_AndroidNetUri != null))
    {
      SharedPreferences.Editor localEditor = WebSoService.a().edit();
      String str1 = String.valueOf(WebSoUtils.a());
      String str2 = WebSoUtils.a(this.jdField_a_of_type_AndroidNetUri);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("eTag_");
      localStringBuilder.append(str1);
      localStringBuilder.append(str2);
      localEditor.putString(localStringBuilder.toString(), this.jdField_a_of_type_JavaLangString);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("pageVersion_");
      localStringBuilder.append(str1);
      localStringBuilder.append(str2);
      localEditor.putString(localStringBuilder.toString(), this.b);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("htmlSha1_");
      localStringBuilder.append(str1);
      localStringBuilder.append(str2);
      localEditor.putString(localStringBuilder.toString(), (String)localObject);
      if (Build.VERSION.SDK_INT < 9) {
        localEditor.commit();
      } else {
        localEditor.apply();
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState.a.d = ((int)(System.currentTimeMillis() - l));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.webso.WebSoService.5
 * JD-Core Version:    0.7.0.1
 */