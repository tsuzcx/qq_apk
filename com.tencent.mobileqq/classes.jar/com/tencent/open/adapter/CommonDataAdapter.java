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
  protected static String a;
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
  
  static
  {
    jdField_a_of_type_JavaLangString = "androidqq";
  }
  
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
    if (this.jdField_a_of_type_Int != -1) {
      return this.jdField_a_of_type_Int;
    }
    a();
    return this.jdField_a_of_type_Int;
  }
  
  public long a()
  {
    try
    {
      this.jdField_a_of_type_Long = Long.valueOf(MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount()).longValue();
      LogUtility.b("CommonDataAdapter", "get uin from app runtim succ:" + this.jdField_a_of_type_Long);
      label47:
      return this.jdField_a_of_type_Long;
    }
    catch (Throwable localThrowable)
    {
      break label47;
    }
  }
  
  public Context a()
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return BaseApplication.getContext();
    }
    return this.jdField_a_of_type_AndroidContentContext;
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
      this.e = (this.d + "." + ((PackageInfo)localObject).versionCode);
      this.f = this.d.substring(this.d.lastIndexOf('.') + 1, this.d.length());
      this.jdField_a_of_type_Int = ((PackageInfo)localObject).versionCode;
      return;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      LogUtility.e("AppUpdate", "getPackageInfo NameNotFoundException : " + localNameNotFoundException.toString());
      return;
    }
    catch (Exception localException)
    {
      LogUtility.e("AppUpdate", "getPackageInfo exception : " + localException.toString());
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
    this.g = ("V1_AND_SQ_" + c());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.adapter.CommonDataAdapter
 * JD-Core Version:    0.7.0.1
 */