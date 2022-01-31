package com.tencent.mobileqq.webview.webso;

import java.lang.reflect.Field;
import wns_proxy.HttpRsp;

public class HttpResponsePackage
{
  public String a;
  public String b;
  public String c;
  public String d;
  private final String e = "\r\n";
  
  public HttpResponsePackage(HttpRsp paramHttpRsp)
  {
    a(paramHttpRsp.rspinfo);
    this.d = paramHttpRsp.body;
  }
  
  private void a(String paramString)
  {
    paramString = paramString.substring(0, paramString.indexOf("\r\n\r\n") - 1).split("\r\n");
    int j = paramString.length;
    int i = 0;
    if (i < j)
    {
      if (i == 0) {
        b(paramString[i]);
      }
      for (;;)
      {
        i += 1;
        break;
        Object localObject = paramString[i];
        int k = localObject.indexOf(":");
        a(localObject.substring(0, k).trim(), localObject.substring(k + 1, localObject.length()));
      }
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    if ((paramString2 == null) || (paramString2.length() == 0)) {}
    for (;;)
    {
      return;
      try
      {
        paramString1 = HttpRequestPackage.class.getDeclaredField(paramString1);
        if (paramString1 != null)
        {
          paramString1.set(this, paramString2);
          return;
        }
      }
      catch (NoSuchFieldException paramString1) {}catch (IllegalArgumentException paramString1) {}catch (IllegalAccessException paramString1) {}
    }
  }
  
  private void b(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0))
    {
      paramString = paramString.split(" ");
      if ((paramString != null) && (paramString.length == 3))
      {
        this.b = paramString[0];
        this.a = paramString[1];
        this.c = paramString[2];
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.webview.webso.HttpResponsePackage
 * JD-Core Version:    0.7.0.1
 */