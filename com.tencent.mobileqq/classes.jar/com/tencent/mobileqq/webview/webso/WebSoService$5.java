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
    Object localObject = this.a;
    if ((localObject != null) && (((HttpResponsePackage)localObject).d != null))
    {
      WebSoUtils.a(this.a.d.getBytes(), WebSoUtils.c(this.b));
      localObject = SHA1Util.a(this.a.d);
    }
    else
    {
      localObject = "";
    }
    if ((!TextUtils.isEmpty(this.c)) && (this.b != null))
    {
      SharedPreferences.Editor localEditor = WebSoService.c().edit();
      String str1 = String.valueOf(WebSoUtils.c());
      String str2 = WebSoUtils.b(this.b);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("eTag_");
      localStringBuilder.append(str1);
      localStringBuilder.append(str2);
      localEditor.putString(localStringBuilder.toString(), this.c);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("pageVersion_");
      localStringBuilder.append(str1);
      localStringBuilder.append(str2);
      localEditor.putString(localStringBuilder.toString(), this.d);
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
    this.e.q.q = ((int)(System.currentTimeMillis() - l));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.webso.WebSoService.5
 * JD-Core Version:    0.7.0.1
 */