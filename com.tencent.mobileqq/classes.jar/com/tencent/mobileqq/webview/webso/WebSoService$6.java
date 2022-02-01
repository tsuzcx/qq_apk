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
    String str1 = this.a;
    if (str1 != null)
    {
      WebSoUtils.a(str1.getBytes(), WebSoUtils.c(this.b));
      str1 = SHA1Util.a(this.a);
    }
    else
    {
      str1 = "";
    }
    if ((!TextUtils.isEmpty(this.c)) && (this.b != null))
    {
      SharedPreferences.Editor localEditor = WebSoService.c().edit();
      String str2 = String.valueOf(WebSoUtils.c());
      String str3 = WebSoUtils.b(this.b);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("eTag_");
      localStringBuilder.append(str2);
      localStringBuilder.append(str3);
      localEditor.putString(localStringBuilder.toString(), this.c);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("pageVersion_");
      localStringBuilder.append(str2);
      localStringBuilder.append(str3);
      localEditor.putString(localStringBuilder.toString(), this.d);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.webso.WebSoService.6
 * JD-Core Version:    0.7.0.1
 */