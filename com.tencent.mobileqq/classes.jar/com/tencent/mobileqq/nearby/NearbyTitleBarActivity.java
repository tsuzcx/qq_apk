package com.tencent.mobileqq.nearby;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.api.INearbyAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class NearbyTitleBarActivity
  extends IphoneTitleBarActivity
{
  public INearbyAppInterface app;
  public long mCreateObjTime = System.currentTimeMillis();
  public boolean mHasInitViews = false;
  public boolean mHasSetContentView = false;
  public boolean mIsNew;
  public long mResumeTime;
  
  static void checkReport(INearbyAppInterface paramINearbyAppInterface, long paramLong1, long paramLong2, long paramLong3)
  {
    NearbyTitleBarActivity.ReportRunnable localReportRunnable = null;
    if (paramLong1 != 0L) {}
    try
    {
      localReportRunnable = new NearbyTitleBarActivity.ReportRunnable();
      localReportRunnable.c = paramINearbyAppInterface.getCurrentAccountUin();
      localReportRunnable.a = paramINearbyAppInterface.getmPerfState();
      localReportRunnable.b = paramINearbyAppInterface.getmPreloadFrom();
      localReportRunnable.d = paramLong2;
      localReportRunnable.f = paramLong1;
      localReportRunnable.e = paramLong3;
      paramINearbyAppInterface.updatePerfState(2, 0);
      ThreadManager.getUIHandler().post(localReportRunnable);
      return;
    }
    catch (Throwable paramINearbyAppInterface)
    {
      paramINearbyAppInterface.printStackTrace();
    }
  }
  
  public static void doClkActionReport(AppInterface paramAppInterface, String paramString)
  {
    doClkActionReport(paramAppInterface, paramString, "", "", "", "");
  }
  
  public static void doClkActionReport(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    ThreadManager.post(new NearbyTitleBarActivity.1(paramAppInterface, paramString1, paramString2, paramString3, paramString4, paramString5), 5, null, true);
  }
  
  public static AppInterface getAppinterface()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().waitAppRuntime(null).getAppRuntime("module_nearby");
    if ((localAppRuntime instanceof AppInterface)) {
      return (AppInterface)localAppRuntime;
    }
    return null;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool = super.doOnCreate(paramBundle);
    if (this.mIsNew) {
      return bool;
    }
    if (!this.mHasSetContentView)
    {
      if (needHardAccelerated()) {
        getWindow().addFlags(16777216);
      }
      i = getLayoutResId();
      if (i != 0)
      {
        setContentView(i);
        this.mHasSetContentView = true;
      }
    }
    if ((this.mHasSetContentView) && (!this.mHasInitViews)) {
      try
      {
        initViews();
        this.mHasInitViews = true;
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
      }
    }
    int i = getBackgroundDrawableResource();
    if (i == 0) {
      getWindow().setBackgroundDrawable(null);
    } else {
      getWindow().setBackgroundDrawableResource(i);
    }
    this.mUseOptimizMode = true;
    return bool;
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (this.mIsNew) {
      return;
    }
    if (this.mResumeTime == 0L)
    {
      this.mResumeTime = System.currentTimeMillis();
      if (this.app.getmPerfState() != 2) {
        try
        {
          long l = getIntent().getLongExtra("ENTER_TIME", 0L);
          checkReport(this.app, l, this.mCreateObjTime, this.mResumeTime);
          return;
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
        }
      }
    }
  }
  
  public int getBackgroundDrawableResource()
  {
    return 0;
  }
  
  public int getLayoutResId()
  {
    return 0;
  }
  
  protected String getModuleId()
  {
    return "module_nearby";
  }
  
  public void initViews() {}
  
  public boolean needHardAccelerated()
  {
    return false;
  }
  
  public boolean showPreview()
  {
    int i = getLayoutResId();
    if (i != 0)
    {
      if (needHardAccelerated()) {
        getWindow().addFlags(16777216);
      }
      setContentView(i);
      this.mHasSetContentView = true;
      try
      {
        initViews();
        this.mHasInitViews = true;
        return true;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    return true;
  }
  
  public void updateAppRuntime()
  {
    super.updateAppRuntime();
    AppRuntime localAppRuntime = getAppRuntime();
    if ((localAppRuntime instanceof INearbyAppInterface)) {
      this.app = ((INearbyAppInterface)localAppRuntime);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("NearbyActivity updateAppRuntime, ");
      localStringBuilder.append(localAppRuntime);
      QLog.i("IphoneTitleBarActivity", 4, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyTitleBarActivity
 * JD-Core Version:    0.7.0.1
 */