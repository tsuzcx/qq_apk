package com.tencent.mobileqq.webview.webso;

import com.tencent.qphone.base.util.QLog;
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
    try
    {
      paramString = paramString.substring(0, paramString.indexOf("\r\n\r\n") - 1).split("\r\n");
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        if (i == 0)
        {
          b(paramString[i]);
        }
        else
        {
          Object localObject = paramString[i];
          int k = localObject.indexOf(":");
          a(localObject.substring(0, k).trim(), localObject.substring(k + 1, localObject.length()));
        }
        i += 1;
      }
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("HttpResponsePackage", 1, paramString.toString());
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (paramString2 != null) {
      if (paramString2.length() == 0) {
        return;
      }
    }
    try
    {
      paramString1 = HttpRequestPackage.class.getDeclaredField(paramString1);
      if (paramString1 != null) {
        paramString1.set(this, paramString2);
      }
      return;
    }
    catch (NoSuchFieldException|IllegalAccessException|IllegalArgumentException paramString1) {}
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.webso.HttpResponsePackage
 * JD-Core Version:    0.7.0.1
 */