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
  protected static String a = "androidqq";
  protected int a;
  protected long a;
  protected Context a;
  protected long b;
  protected String b;
  protected String c = "";
  protected String d = "";
  protected String e = "";
  protected String f = "";
  protected String g = "";
  protected String h = "";
  
  protected CommonDataAdapter()
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_AndroidContentContext = BaseApplication.getContext();
  }
  
  public static CommonDataAdapter a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentOpenAdapterCommonDataAdapter == null) {
        jdField_a_of_type_ComTencentOpenAdapterCommonDataAdapter = new CommonDataAdapter();
      }
      CommonDataAdapter localCommonDataAdapter = jdField_a_of_type_ComTencentOpenAdapterCommonDataAdapter;
      return localCommonDataAdapter;
    }
    finally {}
  }
  
  public int a()
  {
    int i = this.jdField_a_of_type_Int;
    if (i != -1) {
      return i;
    }
    a();
    return this.jdField_a_of_type_Int;
  }
  
  public long a()
  {
    try
    {
      this.jdField_a_of_type_Long = Long.valueOf(MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount()).longValue();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("get uin from app runtim succ:");
      localStringBuilder.append(this.jdField_a_of_type_Long);
      LogUtility.b("CommonDataAdapter", localStringBuilder.toString());
      label53:
      return this.jdField_a_of_type_Long;
    }
    catch (Throwable localThrowable)
    {
      break label53;
    }
  }
  
  public Context a()
  {
    Context localContext = this.jdField_a_of_type_AndroidContentContext;
    Object localObject = localContext;
    if (localContext == null) {
      localObject = BaseApplication.getContext();
    }
    return localObject;
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  protected void a()
  {
    Object localObject = a().a().getApplicationContext();
    try
    {
      localObject = ((Context)localObject).getPackageManager().getPackageInfo(((Context)localObject).getPackageName(), 0);
      this.d = ((PackageInfo)localObject).versionName;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.d);
      localStringBuilder.append(".");
      localStringBuilder.append(((PackageInfo)localObject).versionCode);
      this.e = localStringBuilder.toString();
      this.f = this.d.substring(this.d.lastIndexOf('.') + 1, this.d.length());
      this.jdField_a_of_type_Int = ((PackageInfo)localObject).versionCode;
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
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public long b()
  {
    return this.jdField_b_of_type_Long;
  }
  
  public String b()
  {
    return this.c;
  }
  
  public void b(long paramLong)
  {
    this.jdField_b_of_type_Long = paramLong;
  }
  
  public void b(String paramString)
  {
    this.c = paramString;
  }
  
  public String c()
  {
    if (!TextUtils.isEmpty(this.e)) {
      return this.e;
    }
    a();
    return this.e;
  }
  
  public void c(String paramString)
  {
    this.h = paramString;
  }
  
  public String d()
  {
    if (!TextUtils.isEmpty(this.d)) {
      return this.d;
    }
    a();
    return this.d;
  }
  
  public String e()
  {
    return "12";
  }
  
  public String f()
  {
    if (!TextUtils.isEmpty(this.g)) {
      return this.g;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("V1_AND_SQ_");
    localStringBuilder.append(c());
    this.g = localStringBuilder.toString();
    return this.g;
  }
  
  public String g()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public String h()
  {
    return this.h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.adapter.CommonDataAdapter
 * JD-Core Version:    0.7.0.1
 */