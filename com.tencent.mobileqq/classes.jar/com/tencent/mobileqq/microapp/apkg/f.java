package com.tencent.mobileqq.microapp.apkg;

import Wallet.AllowDomainInfo;
import Wallet.ApkgConfig;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.mobileqq.microapp.b.a;
import com.tencent.mobileqq.microapp.c.c;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

public final class f
{
  public String a;
  public c b;
  public String c;
  public String d;
  public String e;
  public MiniAppConfig f;
  private String g;
  private Map h = new HashMap();
  private Map i = new HashMap();
  
  public f(String paramString, MiniAppConfig paramMiniAppConfig)
  {
    this.g = paramString;
    this.d = paramMiniAppConfig.config.mini_appid;
    this.c = paramMiniAppConfig.config.app_name;
    this.e = paramMiniAppConfig.config.icon_url;
    this.f = paramMiniAppConfig;
  }
  
  public static f a(String paramString, MiniAppConfig paramMiniAppConfig)
  {
    if ((TextUtils.isEmpty(paramString)) || (!new File(paramString).exists())) {
      return null;
    }
    paramString = new f(paramString, paramMiniAppConfig);
    paramString.a();
    return paramString;
  }
  
  public static String a(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      int k = paramString.indexOf("?");
      int j = k;
      if (k == -1) {
        j = paramString.length();
      }
      str = paramString.substring(0, j);
    }
    return str;
  }
  
  public static boolean a(f paramf)
  {
    if ((paramf != null) && (paramf.f != null)) {
      return paramf.f.isInnerUser();
    }
    return false;
  }
  
  public void a()
  {
    try
    {
      this.a = a.b(new File(this.g, "app-config.json"));
      JSONObject localJSONObject1 = new JSONObject(this.a);
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("USER_DATA_PATH", "wxfile://usr");
      localJSONObject1.put("env", localJSONObject2);
      this.a = localJSONObject1.toString();
      this.b = c.b(this.a);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void a(MiniAppConfig paramMiniAppConfig)
  {
    int j = this.f.config.mini_version;
    this.f = paramMiniAppConfig;
    this.f.config.mini_version = j;
  }
  
  public void a(String paramString, g.d paramd)
  {
    g.a().a(this, paramString, paramd);
  }
  
  public String b()
  {
    return this.g + "/" + "app-service.js";
  }
  
  public String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = "";
    }
    String str2;
    String str1;
    do
    {
      return paramString;
      str2 = a(paramString);
      str1 = (String)this.h.get(str2);
      paramString = str1;
    } while (!TextUtils.isEmpty(str1));
    paramString = str1;
    try
    {
      String str3 = a.b(new File(this.g, str2));
      paramString = str1;
      str1 = str3.substring(str3.indexOf("<script>") + "<script>".length(), str3.indexOf("</script>"));
      paramString = str1;
      this.h.put(str2, str1);
      return str1;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return paramString;
  }
  
  public String c()
  {
    return g.a().e();
  }
  
  public boolean c(String paramString)
  {
    paramString = d(paramString);
    if (TextUtils.isEmpty(paramString)) {}
    boolean bool;
    do
    {
      return true;
      paramString = new File(g.a(this.f.config), paramString).getAbsolutePath();
      bool = new File(paramString).exists();
      if (QLog.isColorLevel()) {
        QLog.d("ApkgInfo", 1, "isUrlResReady | subFolderPath :" + paramString + "isExist:" + bool);
      }
    } while (bool);
    return false;
  }
  
  public a d()
  {
    Object localObject = new File(this.g, "page-frame.html");
    a locala = new a();
    if (!((File)localObject).exists())
    {
      locala.a = c();
      return locala;
    }
    localObject = a.a((File)localObject);
    String str = ((String)localObject).substring(((String)localObject).indexOf("<script>") + "<script>".length(), ((String)localObject).indexOf("</script>"));
    locala.a = ((String)localObject).replace(str, "");
    locala.b = str;
    return locala;
  }
  
  public String d(String paramString)
  {
    return this.b.c(paramString);
  }
  
  public String e()
  {
    File localFile = new File(new File(this.g), "app-wxss.js");
    if (localFile.exists()) {
      return a.a(localFile);
    }
    return "";
  }
  
  public String e(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return this.g + "/" + "app-service.js";
    }
    return new File(new File(this.g, paramString), "app-service.js").getAbsolutePath();
  }
  
  public String f()
  {
    return g.a().b();
  }
  
  public String f(String paramString)
  {
    return a.a(new File(e(paramString)));
  }
  
  public String g()
  {
    return g.a().c();
  }
  
  public String g(String paramString)
  {
    paramString = this.b.c(paramString);
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    paramString = new File(new File(this.g, paramString), "page-frame.js");
    if (paramString.exists()) {
      return a.a(paramString);
    }
    return "";
  }
  
  public String h()
  {
    return g.a().d();
  }
  
  public boolean h(String paramString)
  {
    paramString = a.c(paramString);
    Object localObject = this.b.d;
    if (localObject != null)
    {
      localObject = ((s)localObject).f.iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((s.a)((Iterator)localObject).next()).a.equals(paramString)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean i()
  {
    return this.b.a;
  }
  
  public boolean i(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return false;
      paramString = a.c(paramString);
    } while ((!h(paramString)) && (!paramString.equals(this.b.b)));
    return true;
  }
  
  public String j(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return new File(this.g, paramString).getAbsolutePath();
  }
  
  public boolean k(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!new File(j(a.c(paramString))).exists()) {
      return false;
    }
    return true;
  }
  
  public Bitmap l(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      localObject = null;
    }
    Bitmap localBitmap;
    do
    {
      return localObject;
      localBitmap = (Bitmap)this.i.get(paramString);
      localObject = localBitmap;
    } while (localBitmap != null);
    Object localObject = a.i(paramString);
    this.i.put(paramString, localObject);
    return localObject;
  }
  
  public boolean m(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Iterator localIterator;
    if (this.f.config.allow_domains != null) {
      localIterator = this.f.config.allow_domains.iterator();
    }
    for (;;)
    {
      Object localObject;
      if (localIterator.hasNext()) {
        localObject = (AllowDomainInfo)localIterator.next();
      }
      try
      {
        localObject = ((AllowDomainInfo)localObject).allow_domain_regex;
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          continue;
        }
        boolean bool = Pattern.compile((String)localObject).matcher(paramString.toLowerCase()).matches();
        if (!bool) {
          continue;
        }
        return true;
      }
      catch (Throwable localThrowable) {}
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.apkg.f
 * JD-Core Version:    0.7.0.1
 */