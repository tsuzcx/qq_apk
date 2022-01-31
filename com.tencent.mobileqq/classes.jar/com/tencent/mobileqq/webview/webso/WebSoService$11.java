package com.tencent.mobileqq.webview.webso;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import bege;
import begt;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;

final class WebSoService$11
  implements Runnable
{
  WebSoService$11(String paramString1, Uri paramUri, String paramString2, String paramString3) {}
  
  public void run()
  {
    System.currentTimeMillis();
    String str1 = "";
    if (this.jdField_a_of_type_JavaLangString != null)
    {
      begt.a(this.jdField_a_of_type_JavaLangString.getBytes(), begt.b(this.jdField_a_of_type_AndroidNetUri));
      str1 = bege.a(this.jdField_a_of_type_JavaLangString);
    }
    SharedPreferences.Editor localEditor;
    if ((!TextUtils.isEmpty(this.b)) && (this.jdField_a_of_type_AndroidNetUri != null))
    {
      localEditor = WebSoService.a().edit();
      String str2 = String.valueOf(BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin());
      String str3 = begt.a(this.jdField_a_of_type_AndroidNetUri);
      localEditor.putString("eTag_" + str2 + str3, this.b);
      localEditor.putString("pageVersion_" + str2 + str3, this.c);
      localEditor.putString("htmlSha1_" + str2 + str3, str1);
      if (Build.VERSION.SDK_INT < 9) {
        localEditor.commit();
      }
    }
    else
    {
      return;
    }
    localEditor.apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.webso.WebSoService.11
 * JD-Core Version:    0.7.0.1
 */