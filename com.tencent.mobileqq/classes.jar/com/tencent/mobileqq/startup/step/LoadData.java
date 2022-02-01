package com.tencent.mobileqq.startup.step;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.SafeModeUtil;
import com.tencent.mobileqq.activity.recent.RecentDataListManager;
import com.tencent.mobileqq.activity.recent.RecentParcelUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.startup.director.StartupDirector;
import com.tencent.mobileqq.statistics.CaughtExceptionReport;
import com.tencent.mobileqq.utils.TripleGraySwitchUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class LoadData
  extends Step
{
  private boolean a(QQAppInterface paramQQAppInterface)
  {
    if (!SafeModeUtil.a(BaseApplicationImpl.sApplication)) {
      return false;
    }
    try
    {
      QLog.e("LoadData", 2, "prepare try preload Database");
      paramQQAppInterface.getRecentUserProxy();
      QLog.e("LoadData", 2, "try preload getRecentUserProxy finish");
      return true;
    }
    catch (Throwable paramQQAppInterface)
    {
      for (;;)
      {
        try
        {
          QLog.e("LoadData", 2, "try preload fail", paramQQAppInterface);
          CaughtExceptionReport.a(paramQQAppInterface, "");
        }
        catch (Throwable paramQQAppInterface) {}
      }
    }
  }
  
  public boolean a(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoadData", 2, "LoadDataactivity = " + paramAppRuntime + paramAppRuntime.isLogin());
    }
    if ((paramAppRuntime != null) && ((paramAppRuntime instanceof QQAppInterface)) && (!TextUtils.isEmpty(paramAppRuntime.getAccount())))
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)paramAppRuntime;
      if (paramAppRuntime.isLogin())
      {
        if (a(localQQAppInterface)) {
          return false;
        }
        return RecentDataListManager.a().a(localQQAppInterface, BaseApplicationImpl.sApplication, paramBoolean, false);
      }
      if (QLog.isColorLevel()) {
        QLog.d("LoadData", 2, new Object[] { "Preload not login account: ", paramAppRuntime.getAccount() });
      }
      try
      {
        if (a(localQQAppInterface)) {
          return false;
        }
        paramBoolean = RecentDataListManager.a().a(localQQAppInterface, BaseApplicationImpl.sApplication, paramBoolean, false);
        return paramBoolean;
      }
      catch (Throwable paramAppRuntime)
      {
        if (QLog.isColorLevel()) {
          QLog.d("LoadData", 2, "has account and not login, preload fail.");
        }
        return false;
      }
    }
    return false;
  }
  
  protected boolean doStep()
  {
    Object localObject = this.mDirector.a;
    long l = System.currentTimeMillis();
    SafeModeUtil.a = l;
    if (localObject != null)
    {
      if (SafeModeUtil.a(BaseApplicationImpl.sApplication))
      {
        RecentParcelUtil.a(BaseApplicationImpl.sApplication, true);
        TripleGraySwitchUtil.a(BaseApplicationImpl.sApplication, true, null, null);
      }
      if ((localObject instanceof BaseActivity))
      {
        localObject = BaseApplicationImpl.sApplication.waitAppRuntime(null);
        if (this.mId == 19) {}
        for (boolean bool = true; (a((AppRuntime)localObject, bool)) && (System.currentTimeMillis() - l < 550L); bool = false) {
          return true;
        }
        return false;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.LoadData
 * JD-Core Version:    0.7.0.1
 */