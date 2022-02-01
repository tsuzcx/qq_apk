package com.tencent.mobileqq.microapp.appbrand.b;

import android.os.Environment;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.microapp.a.c;
import com.tencent.qphone.base.util.MD5;
import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;

public class b
{
  private static volatile b b;
  public c a;
  private String c;
  private String d;
  private Map e;
  private Map f = new HashMap();
  
  public static b a()
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new b();
        }
      }
      finally {}
    }
    return b;
  }
  
  private String a(int paramInt)
  {
    Object localObject2 = "tmp";
    Object localObject1 = localObject2;
    if (paramInt != 0) {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          localObject1 = localObject2;
        } else {
          localObject1 = "usr";
        }
      }
      else {
        localObject1 = "store";
      }
    }
    localObject2 = new StringBuilder(Environment.getExternalStorageDirectory().getPath());
    ((StringBuilder)localObject2).append("/miniApp/files/");
    ((StringBuilder)localObject2).append(this.c);
    ((StringBuilder)localObject2).append("/");
    ((StringBuilder)localObject2).append(this.d);
    ((StringBuilder)localObject2).append("/");
    ((StringBuilder)localObject2).append((String)localObject1);
    return ((StringBuilder)localObject2).toString();
  }
  
  private String d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    String str = e(paramString);
    if (TextUtils.isEmpty(str))
    {
      str = "";
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(".");
      ((StringBuilder)localObject).append(str);
      str = ((StringBuilder)localObject).toString();
    }
    Object localObject = new StringBuilder();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(System.currentTimeMillis());
    localStringBuilder.append("");
    ((StringBuilder)localObject).append(MD5.toMD5(localStringBuilder.toString()));
    ((StringBuilder)localObject).append(str);
    str = ((StringBuilder)localObject).toString();
    localObject = new StringBuffer("wxfile://");
    ((StringBuffer)localObject).append("tmp");
    ((StringBuffer)localObject).append("_");
    ((StringBuffer)localObject).append(str);
    str = ((StringBuffer)localObject).toString();
    this.e.put(str, paramString);
    return str;
  }
  
  private static String e(String paramString)
  {
    try
    {
      String str = new URL(paramString).getPath();
      paramString = str;
    }
    catch (Throwable localThrowable)
    {
      label14:
      int i;
      break label14;
    }
    if (!TextUtils.isEmpty(paramString))
    {
      i = paramString.lastIndexOf(".");
      if (i != -1)
      {
        i += 1;
        if (i < paramString.length()) {
          return paramString.substring(i);
        }
      }
    }
    return "";
  }
  
  public String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramString = "";
    }
    else
    {
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append(".");
      localStringBuilder1.append(paramString);
      paramString = localStringBuilder1.toString();
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(System.currentTimeMillis());
    localStringBuilder2.append("");
    localStringBuilder1.append(MD5.toMD5(localStringBuilder2.toString()));
    localStringBuilder1.append(paramString);
    paramString = localStringBuilder1.toString();
    return new File(a(0), paramString).getAbsolutePath();
  }
  
  public void a(c paramc)
  {
    this.c = paramc.d;
    this.d = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    this.a = paramc;
    paramc = new StringBuilder();
    paramc.append(this.c);
    paramc.append(this.d);
    paramc = paramc.toString();
    this.e = ((Map)this.f.get(paramc));
    if (this.e == null)
    {
      this.e = new HashMap();
      this.f.put(paramc, this.e);
    }
  }
  
  public String b(String paramString)
  {
    for (Object localObject1 = "store";; localObject1 = "tmp")
    {
      try
      {
        Object localObject2 = new File(paramString);
        String str = ((File)localObject2).getParentFile().getAbsolutePath();
        if ((!a(0).equals(str)) && (!a(1).equals(str)))
        {
          if (str.startsWith(a(2)))
          {
            paramString = a(2);
            paramString = ((File)localObject2).getAbsolutePath().replace(paramString, "");
            localObject1 = new StringBuilder("wxfile://usr");
            ((StringBuilder)localObject1).append(paramString);
            return ((StringBuilder)localObject1).toString();
          }
          if (new File(paramString).exists()) {
            return d(paramString);
          }
        }
        else
        {
          if (!((File)localObject2).getParentFile().getName().equals("store")) {
            continue;
          }
          paramString = new File(paramString).getName();
          localObject2 = new StringBuffer("wxfile://");
          ((StringBuffer)localObject2).append((String)localObject1);
          ((StringBuffer)localObject2).append("_");
          ((StringBuffer)localObject2).append(paramString);
          paramString = ((StringBuffer)localObject2).toString();
          return paramString;
        }
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
        return "";
      }
      return "";
    }
  }
  
  public String c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    String str = (String)this.e.get(paramString);
    if (!TextUtils.isEmpty(str)) {
      return str;
    }
    if (paramString.startsWith("wxfile://tmp_"))
    {
      paramString = paramString.replace("wxfile://tmp_", "");
      paramString = new File(a(0), paramString);
      if (paramString.exists()) {
        return paramString.getAbsolutePath();
      }
    }
    else if (paramString.startsWith("wxfile://store_"))
    {
      paramString = paramString.replace("wxfile://store_", "");
      paramString = new File(a(1), paramString);
      if (paramString.exists()) {
        return paramString.getAbsolutePath();
      }
    }
    else if (paramString.startsWith("wxfile://usr"))
    {
      paramString = paramString.replace("wxfile://usr", "");
      paramString = new File(a(2), paramString);
      if (paramString.exists()) {
        return paramString.getAbsolutePath();
      }
    }
    else
    {
      if (paramString.toLowerCase().startsWith("http://")) {
        return paramString;
      }
      if (paramString.toLowerCase().startsWith("https://")) {
        return paramString;
      }
      if (new File(this.a.j(paramString)).exists()) {
        return this.a.j(paramString);
      }
    }
    return "";
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.b.b
 * JD-Core Version:    0.7.0.1
 */