package com.tencent.open.adapter;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import com.tencent.open.base.LogUtility;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class CommonDataAdapter
{
  protected static CommonDataAdapter a;
  protected static String b = "androidqq";
  protected long c = 0L;
  protected long d = 0L;
  protected String e = "";
  protected String f = "";
  protected String g = "";
  protected String h = "";
  protected String i = "";
  protected String j = "";
  protected int k = -1;
  protected String l = "";
  protected Context m = BaseApplication.getContext();
  
  public static CommonDataAdapter a()
  {
    try
    {
      if (a == null) {
        a = new CommonDataAdapter();
      }
      CommonDataAdapter localCommonDataAdapter = a;
      return localCommonDataAdapter;
    }
    finally {}
  }
  
  public void a(long paramLong)
  {
    this.c = paramLong;
  }
  
  public void a(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    this.m = paramContext;
  }
  
  public void a(String paramString)
  {
    this.e = paramString;
  }
  
  public Context b()
  {
    Context localContext = this.m;
    Object localObject = localContext;
    if (localContext == null) {
      localObject = BaseApplication.getContext();
    }
    return localObject;
  }
  
  public void b(long paramLong)
  {
    this.d = paramLong;
  }
  
  public void b(String paramString)
  {
    this.f = paramString;
  }
  
  public long c()
  {
    try
    {
      this.c = Long.valueOf(MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount()).longValue();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("get uin from app runtim succ:");
      localStringBuilder.append(this.c);
      LogUtility.b("CommonDataAdapter", localStringBuilder.toString());
      label53:
      return this.c;
    }
    catch (Throwable localThrowable)
    {
      break label53;
    }
  }
  
  public void c(String paramString)
  {
    this.l = paramString;
  }
  
  public long d()
  {
    return this.d;
  }
  
  public String e()
  {
    return this.e;
  }
  
  public String f()
  {
    return this.f;
  }
  
  public String g()
  {
    if (!TextUtils.isEmpty(this.h)) {
      return this.h;
    }
    i();
    return this.h;
  }
  
  public int h()
  {
    int n = this.k;
    if (n != -1) {
      return n;
    }
    i();
    return this.k;
  }
  
  protected void i()
  {
    Object localObject = a().b().getApplicationContext();
    try
    {
      localObject = ((Context)localObject).getPackageManager().getPackageInfo(((Context)localObject).getPackageName(), 0);
      this.g = ((PackageInfo)localObject).versionName;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.g);
      localStringBuilder.append(".");
      localStringBuilder.append(((PackageInfo)localObject).versionCode);
      this.h = localStringBuilder.toString();
      this.i = this.g.substring(this.g.lastIndexOf('.') + 1, this.g.length());
      this.k = ((PackageInfo)localObject).versionCode;
      return;
    }
    catch (Exception localException)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getPackageInfo exception : ");
      localStringBuilder.append(localException.toString());
      LogUtility.e("AppUpdate", localStringBuilder.toString());
      return;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getPackageInfo NameNotFoundException : ");
      localStringBuilder.append(localNameNotFoundException.toString());
      LogUtility.e("AppUpdate", localStringBuilder.toString());
    }
  }
  
  public String j()
  {
    if (!TextUtils.isEmpty(this.g)) {
      return this.g;
    }
    i();
    return this.g;
  }
  
  public String k()
  {
    return "12";
  }
  
  public String l()
  {
    if (!TextUtils.isEmpty(this.j)) {
      return this.j;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("V1_AND_SQ_");
    localStringBuilder.append(g());
    this.j = localStringBuilder.toString();
    return this.j;
  }
  
  public String m()
  {
    return b;
  }
  
  public String n()
  {
    return this.l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.adapter.CommonDataAdapter
 * JD-Core Version:    0.7.0.1
 */