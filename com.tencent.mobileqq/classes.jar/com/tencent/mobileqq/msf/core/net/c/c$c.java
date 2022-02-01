package com.tencent.mobileqq.msf.core.net.c;

import android.text.TextUtils;

class c$c
{
  public String[] a;
  public String b = "";
  
  public static c a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    c localc = new c();
    int j = paramString.indexOf("\r\n\r\n");
    int i = j;
    if (j == -1) {
      i = paramString.length();
    }
    localc.a = paramString.substring(0, i).split("\r\n");
    return localc;
  }
  
  public String a()
  {
    Object localObject = this.a;
    String str1 = "";
    if (localObject != null)
    {
      if (localObject.length == 0) {
        return "";
      }
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        String str2 = localObject[i];
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str1);
        localStringBuilder.append(str2);
        localStringBuilder.append("\r\n");
        str1 = localStringBuilder.toString();
        i += 1;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str1);
      ((StringBuilder)localObject).append("\r\n");
      return ((StringBuilder)localObject).toString();
    }
    return "";
  }
  
  public String b()
  {
    String[] arrayOfString = this.a;
    if (arrayOfString != null)
    {
      if (arrayOfString.length == 0) {
        return "";
      }
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
            return str.substring(n + 8, j);
          }
        }
        i += 1;
      }
    }
    return "";
  }
  
  public String c()
  {
    String[] arrayOfString = this.a;
    if (arrayOfString != null)
    {
      if (arrayOfString.length == 0) {
        return "";
      }
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
            return str.substring(n + 4, j);
          }
        }
        i += 1;
      }
    }
    return "";
  }
  
  public String d()
  {
    String[] arrayOfString = this.a;
    if ((arrayOfString != null) && (arrayOfString.length != 0))
    {
      int j = arrayOfString.length;
      int i = 0;
      for (Object localObject1 = ""; i < j; localObject1 = localObject2)
      {
        String str = arrayOfString[i];
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
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append(str);
          ((StringBuilder)localObject2).append("\r\n");
          localObject2 = ((StringBuilder)localObject2).toString();
        }
        i += 1;
      }
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("\r\n");
      return ((StringBuilder)localObject2).toString();
    }
    return this.b;
  }
  
  public int e()
  {
    String[] arrayOfString = this.a;
    if ((arrayOfString != null) && (arrayOfString.length > 0)) {}
    try
    {
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        if (str.startsWith("Content-Length:"))
        {
          i = Integer.parseInt(str.substring(15, str.length()).trim());
          return i;
        }
        i += 1;
      }
      return -1;
    }
    catch (Exception localException) {}
    return -1;
  }
  
  public boolean f()
  {
    String[] arrayOfString = this.a;
    if (arrayOfString != null)
    {
      if (arrayOfString.length <= 0) {
        return false;
      }
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
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
    return false;
  }
  
  public boolean g()
  {
    return (f()) && (!TextUtils.isEmpty(c()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.c.c.c
 * JD-Core Version:    0.7.0.1
 */