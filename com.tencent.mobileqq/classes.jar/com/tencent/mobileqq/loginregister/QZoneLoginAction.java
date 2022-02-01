package com.tencent.mobileqq.loginregister;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.service.qzone.QZoneUnreadServletLogic;
import com.tencent.mobileqq.startup.step.RecordTracer;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trackrecordlib.core.RecordManager;

public class QZoneLoginAction
  extends BaseLoginAction
{
  public void a(Activity paramActivity, Bundle paramBundle)
  {
    if (QZoneUnreadServletLogic.a(1, BaseApplicationImpl.processName))
    {
      long l1 = System.currentTimeMillis();
      paramActivity = BaseActivity.sTopActivity;
      if (QLog.isColorLevel()) {
        QLog.d("RecordTracer", 2, "doTracebackSDK in LoginActivity");
      }
      RecordManager.getInstance().setRecentActivityName(paramActivity);
      RecordTracer.a().step();
      long l2 = System.currentTimeMillis();
      QLog.d("RecordTracer", 1, "fuction time = " + (l2 - l1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginregister.QZoneLoginAction
 * JD-Core Version:    0.7.0.1
 */