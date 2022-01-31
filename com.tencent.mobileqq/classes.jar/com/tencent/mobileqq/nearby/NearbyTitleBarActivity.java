package com.tencent.mobileqq.nearby;

import aevk;
import aevl;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;
import mqq.app.AppRuntime;

public class NearbyTitleBarActivity
  extends IphoneTitleBarActivity
{
  public NearbyAppInterface a;
  public boolean d;
  public boolean e;
  public long o = System.currentTimeMillis();
  public long p;
  
  public static void a(AppInterface paramAppInterface, String paramString)
  {
    a(paramAppInterface, paramString, "", "", "", "");
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    ThreadManager.post(new aevk(paramAppInterface, paramString1, paramString2, paramString3, paramString4, paramString5), 5, null, true);
  }
  
  static void a(NearbyAppInterface paramNearbyAppInterface, long paramLong1, long paramLong2, long paramLong3)
  {
    aevl localaevl = null;
    if (paramLong1 != 0L) {}
    try
    {
      localaevl = new aevl();
      localaevl.jdField_a_of_type_JavaLangString = paramNearbyAppInterface.getCurrentAccountUin();
      localaevl.jdField_a_of_type_Int = paramNearbyAppInterface.c;
      localaevl.jdField_b_of_type_Int = paramNearbyAppInterface.d;
      localaevl.jdField_a_of_type_Long = paramLong2;
      localaevl.c = paramLong1;
      localaevl.jdField_b_of_type_Long = paramLong3;
      paramNearbyAppInterface.a(2, 0);
      if (localaevl != null)
      {
        paramNearbyAppInterface = Class.forName("android.view.ViewRootImpl");
        paramNearbyAppInterface.getMethod("addFirstDrawHandler", new Class[] { Runnable.class }).invoke(paramNearbyAppInterface, new Object[] { localaevl });
      }
      return;
    }
    catch (Throwable paramNearbyAppInterface)
    {
      paramNearbyAppInterface.printStackTrace();
    }
  }
  
  public int a()
  {
    return 0;
  }
  
  public void a() {}
  
  public boolean a()
  {
    return false;
  }
  
  public int b()
  {
    return 0;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool = super.doOnCreate(paramBundle);
    int i;
    if (!this.d)
    {
      if (a()) {
        getWindow().addFlags(16777216);
      }
      i = a();
      if (i != 0)
      {
        setContentView(i);
        this.d = true;
      }
    }
    if ((this.d) && (!this.e)) {}
    try
    {
      a();
      this.e = true;
      i = b();
      if (i == 0)
      {
        getWindow().setBackgroundDrawable(null);
        this.mUseOptimizMode = true;
        return bool;
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        paramBundle.printStackTrace();
        continue;
        getWindow().setBackgroundDrawableResource(i);
      }
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (this.p == 0L)
    {
      this.p = System.currentTimeMillis();
      if (this.a.c == 2) {}
    }
    try
    {
      long l = getIntent().getLongExtra("ENTER_TIME", 0L);
      a(this.a, l, this.o, this.p);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  protected String getModuleId()
  {
    return "module_nearby";
  }
  
  public boolean showPreview()
  {
    int i = a();
    if (i != 0)
    {
      if (a()) {
        getWindow().addFlags(16777216);
      }
      setContentView(i);
      this.d = true;
    }
    try
    {
      a();
      this.e = true;
      return true;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return true;
  }
  
  public void updateAppRuntime()
  {
    super.updateAppRuntime();
    AppRuntime localAppRuntime = getAppRuntime();
    if ((localAppRuntime instanceof NearbyAppInterface)) {
      this.a = ((NearbyAppInterface)localAppRuntime);
    }
    if (QLog.isColorLevel()) {
      QLog.i("IphoneTitleBarActivity", 4, "NearbyActivity updateAppRuntime, " + localAppRuntime);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyTitleBarActivity
 * JD-Core Version:    0.7.0.1
 */