package com.tencent.mobileqq.webview.webso;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;

final class WebSoService$6
  implements Runnable
{
  WebSoService$6(String paramString1, Uri paramUri, String paramString2, String paramString3) {}
  
  public void run()
  {
    System.currentTimeMillis();
    String str1 = this.jdField_a_of_type_JavaLangString;
    if (str1 != null)
    {
      WebSoUtils.a(str1.getBytes(), WebSoUtils.b(this.jdField_a_of_type_AndroidNetUri));
      str1 = SHA1Util.a(this.jdField_a_of_type_JavaLangString);
    }
    else
    {
      str1 = "";
    }
    if ((!TextUtils.isEmpty(this.b)) && (this.jdField_a_of_type_AndroidNetUri != null))
    {
      SharedPreferences.Editor localEditor = WebSoService.a().edit();
      String str2 = String.valueOf(WebSoUtils.a());
      String str3 = WebSoUtils.a(this.jdField_a_of_type_AndroidNetUri);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("eTag_");
      localStringBuilder.append(str2);
      localStringBuilder.append(str3);
      localEditor.putString(localStringBuilder.toString(), this.b);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("pageVersion_");
      localStringBuilder.append(str2);
      localStringBuilder.append(str3);
      localEditor.putString(localStringBuilder.toString(), this.c);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("htmlSha1_");
      localStringBuilder.append(str2);
      localStringBuilder.append(str3);
      localEditor.putString(localStringBuilder.toString(), str1);
      if (Build.VERSION.SDK_INT < 9)
      {
        localEditor.commit();
        return;
      }
      localEditor.apply();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.webso.WebSoService.6
 * JD-Core Version:    0.7.0.1
 */