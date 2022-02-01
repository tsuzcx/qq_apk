package com.tencent.mobileqq.webview.webso;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import bije;
import bijg;
import bijv;

final class WebSoService$10
  implements Runnable
{
  WebSoService$10(bije parambije, Uri paramUri, String paramString1, String paramString2, WebSoService.WebSoState paramWebSoState) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    Object localObject2 = "";
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_Bije != null)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_Bije.d != null)
      {
        bijv.a(this.jdField_a_of_type_Bije.d.getBytes(), bijv.b(this.jdField_a_of_type_AndroidNetUri));
        localObject1 = bijg.a(this.jdField_a_of_type_Bije.d);
      }
    }
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_AndroidNetUri != null))
    {
      localObject2 = WebSoService.a().edit();
      String str1 = String.valueOf(bijv.a());
      String str2 = bijv.a(this.jdField_a_of_type_AndroidNetUri);
      ((SharedPreferences.Editor)localObject2).putString("eTag_" + str1 + str2, this.jdField_a_of_type_JavaLangString);
      ((SharedPreferences.Editor)localObject2).putString("pageVersion_" + str1 + str2, this.b);
      ((SharedPreferences.Editor)localObject2).putString("htmlSha1_" + str1 + str2, (String)localObject1);
      if (Build.VERSION.SDK_INT >= 9) {
        break label248;
      }
      ((SharedPreferences.Editor)localObject2).commit();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoService$WebSoState.a.d = ((int)(System.currentTimeMillis() - l));
      return;
      label248:
      ((SharedPreferences.Editor)localObject2).apply();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.webso.WebSoService.10
 * JD-Core Version:    0.7.0.1
 */