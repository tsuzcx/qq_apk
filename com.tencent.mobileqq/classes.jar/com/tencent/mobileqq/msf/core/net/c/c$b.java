package com.tencent.mobileqq.msf.core.net.c;

import android.text.TextUtils;

class c$b
{
  public String[] a;
  public String b = "";
  
  public static b a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    b localb = new b();
    int j = paramString.indexOf("\r\n\r\n");
    int i = j;
    if (j == -1) {
      i = paramString.length();
    }
    localb.a = paramString.substring(0, i).split("\r\n");
    return localb;
  }
  
  public String a()
  {
    if ((this.a == null) || (this.a.length == 0)) {
      return "";
    }
    String str1 = "";
    String[] arrayOfString = this.a;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str2 = arrayOfString[i];
      str1 = str1 + str2 + "\r\n";
      i += 1;
    }
    return str1 + "\r\n";
  }
  
  public String b()
  {
    if ((this.a == null) || (this.a.length == 0)) {}
    for (;;)
    {
      return "";
      String[] arrayOfString = this.a;
      int m = arrayOfString.length;
      int i = 0;
      while (i < m)
      {
        String str = arrayOfString[i];
        if (((str.startsWith("Set-Cookie:")) && (str.contains("gateway="))) || ((str.startsWith("Cookie:")) && (str.contains("gateway="))))
        {
          int n = str.indexOf("gateway=");
          int k = str.indexOf(";", n);
          int j = k;
          if (k == -1) {
            j = str.length();
          }
          if ((n != -1) && (j > n)) {
            return str.substring("gateway=".length() + n, j);
          }
        }
        i += 1;
      }
    }
  }
  
  public String c()
  {
    if ((this.a == null) || (this.a.length == 0)) {}
    for (;;)
    {
      return "";
      String[] arrayOfString = this.a;
      int m = arrayOfString.length;
      int i = 0;
      while (i < m)
      {
        String str = arrayOfString[i];
        if (((str.startsWith("Set-Cookie:")) && (str.contains("md5="))) || ((str.startsWith("Cookie:")) && (str.contains("md5="))))
        {
          int n = str.indexOf("md5=");
          int k = str.indexOf(";", n);
          int j = k;
          if (k == -1) {
            j = str.length();
          }
          if ((n != -1) && (j > n)) {
            return str.substring("md5=".length() + n, j);
          }
        }
        i += 1;
      }
    }
  }
  
  public String d()
  {
    if ((this.a == null) || (this.a.length == 0)) {
      return this.b;
    }
    String[] arrayOfString = this.a;
    int j = arrayOfString.length;
    Object localObject1 = "";
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      Object localObject2;
      if (str.startsWith("Set-Cookie:"))
      {
        localObject2 = localObject1;
        if (str.contains("md5=")) {}
      }
      else if (str.startsWith("Cookie:"))
      {
        localObject2 = localObject1;
        if (str.contains("md5=")) {}
      }
      else
      {
        localObject2 = (String)localObject1 + str + "\r\n";
      }
      i += 1;
      localObject1 = localObject2;
    }
    return (String)localObject1 + "\r\n";
  }
  
  public int e()
  {
    int k = -1;
    int j = k;
    if (this.a != null)
    {
      j = k;
      if (this.a.length <= 0) {}
    }
    try
    {
      String[] arrayOfString = this.a;
      int m = arrayOfString.length;
      int i = 0;
      for (;;)
      {
        j = k;
        if (i < m)
        {
          String str = arrayOfString[i];
          if (str.startsWith("Content-Length:")) {
            j = Integer.parseInt(str.substring("Content-Length:".length(), str.length()).trim());
          }
        }
        else
        {
          return j;
        }
        i += 1;
      }
      return -1;
    }
    catch (Exception localException) {}
  }
  
  public boolean f()
  {
    if ((this.a == null) || (this.a.length <= 0)) {}
    label64:
    for (;;)
    {
      return false;
      String[] arrayOfString = this.a;
      int j = arrayOfString.length;
      int i = 0;
      for (;;)
      {
        if (i >= j) {
          break label64;
        }
        String str = arrayOfString[i];
        if (str.startsWith("HTTP/1."))
        {
          if (!str.contains("200")) {
            break;
          }
          return true;
        }
        i += 1;
      }
    }
  }
  
  public boolean g()
  {
    return (f()) && (!TextUtils.isEmpty(c()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.c.c.b
 * JD-Core Version:    0.7.0.1
 */