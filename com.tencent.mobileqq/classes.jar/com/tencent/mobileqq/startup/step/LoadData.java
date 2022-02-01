package com.tencent.mobileqq.startup.step;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.recent.RecentDataListManager;
import com.tencent.mobileqq.activity.recent.RecentParcelUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.startup.director.StartupDirector;
import com.tencent.mobileqq.utils.TripleGraySwitchUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.crash.catchedexception.CaughtExceptionReport;
import com.tencent.qqperf.monitor.crash.safemode.SafeModeUtil;
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
    }
    catch (Throwable paramQQAppInterface) {}
    try
    {
      QLog.e("LoadData", 2, "try preload fail", paramQQAppInterface);
      CaughtExceptionReport.a(paramQQAppInterface, "");
      label51:
      return true;
    }
    catch (Throwable paramQQAppInterface)
    {
      break label51;
    }
  }
  
  public boolean a(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("LoadDataactivity = ");
      ((StringBuilder)localObject).append(paramAppRuntime);
      ((StringBuilder)localObject).append(paramAppRuntime.isLogin());
      QLog.d("LoadData", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramAppRuntime != null) && ((paramAppRuntime instanceof QQAppInterface)) && (!TextUtils.isEmpty(paramAppRuntime.getAccount())))
    {
      localObject = (QQAppInterface)paramAppRuntime;
      if (paramAppRuntime.isLogin())
      {
        if (a((QQAppInterface)localObject)) {
          return false;
        }
        return RecentDataListManager.a().a((BaseQQAppInterface)localObject, BaseApplicationImpl.sApplication, paramBoolean, false);
      }
      if (QLog.isColorLevel()) {
        QLog.d("LoadData", 2, new Object[] { "Preload not login account: ", paramAppRuntime.getAccount() });
      }
    }
    try
    {
      if (a((QQAppInterface)localObject)) {
        return false;
      }
      paramBoolean = RecentDataListManager.a().a((BaseQQAppInterface)localObject, BaseApplicationImpl.sApplication, paramBoolean, false);
      return paramBoolean;
    }
    catch (Throwable paramAppRuntime)
    {
      label155:
      break label155;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LoadData", 2, "has account and not login, preload fail.");
    }
    return false;
  }
  
  protected boolean doStep()
  {
    Object localObject = this.mDirector.a;
    long l = System.currentTimeMillis();
    SafeModeUtil.a = l;
    boolean bool3 = false;
    boolean bool2 = bool3;
    if (localObject != null)
    {
      if (SafeModeUtil.a(BaseApplicationImpl.sApplication))
      {
        RecentParcelUtil.a(BaseApplicationImpl.sApplication, true);
        TripleGraySwitchUtil.a(BaseApplicationImpl.sApplication, true, null, null);
      }
      bool2 = bool3;
      if ((localObject instanceof BaseActivity))
      {
        localObject = BaseApplicationImpl.sApplication.waitAppRuntime(null);
        boolean bool1;
        if (this.mId == 19) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        bool2 = bool3;
        if (a((AppRuntime)localObject, bool1))
        {
          bool2 = bool3;
          if (System.currentTimeMillis() - l < 550L) {
            bool2 = true;
          }
        }
      }
    }
    return bool2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.LoadData
 * JD-Core Version:    0.7.0.1
 */