package com.tencent.mobileqq.nearby;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.Window;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class NearbyTitleBarActivity
  extends IphoneTitleBarActivity
{
  public NearbyAppInterface a;
  public boolean d = false;
  public boolean e = false;
  public long p = System.currentTimeMillis();
  public long q;
  
  public static void a(AppInterface paramAppInterface, String paramString)
  {
    a(paramAppInterface, paramString, "", "", "", "");
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    ThreadManager.post(new NearbyTitleBarActivity.1(paramAppInterface, paramString1, paramString2, paramString3, paramString4, paramString5), 5, null, true);
  }
  
  static void a(NearbyAppInterface paramNearbyAppInterface, long paramLong1, long paramLong2, long paramLong3)
  {
    NearbyTitleBarActivity.ReportRunnable localReportRunnable = null;
    if (paramLong1 != 0L) {}
    try
    {
      localReportRunnable = new NearbyTitleBarActivity.ReportRunnable();
      localReportRunnable.jdField_a_of_type_JavaLangString = paramNearbyAppInterface.getCurrentAccountUin();
      localReportRunnable.jdField_a_of_type_Int = paramNearbyAppInterface.c;
      localReportRunnable.jdField_b_of_type_Int = paramNearbyAppInterface.d;
      localReportRunnable.jdField_a_of_type_Long = paramLong2;
      localReportRunnable.c = paramLong1;
      localReportRunnable.jdField_b_of_type_Long = paramLong3;
      paramNearbyAppInterface.a(2, 0);
      ThreadManager.getUIHandler().post(localReportRunnable);
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
  
  public boolean a()
  {
    return false;
  }
  
  public int b()
  {
    return 0;
  }
  
  public void b() {}
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
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
      b();
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
    if (this.q == 0L)
    {
      this.q = System.currentTimeMillis();
      if (this.a.c == 2) {}
    }
    try
    {
      long l = getIntent().getLongExtra("ENTER_TIME", 0L);
      a(this.a, l, this.p, this.q);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public String getModuleId()
  {
    return "module_nearby";
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
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
      b();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyTitleBarActivity
 * JD-Core Version:    0.7.0.1
 */