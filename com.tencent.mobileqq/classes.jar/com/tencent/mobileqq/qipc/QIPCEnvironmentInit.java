package com.tencent.mobileqq.qipc;

import android.content.Context;
import android.text.TextUtils;
import bmar;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.ActivityLifecycle;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCServer;
import java.util.ArrayList;
import mqq.app.MobileQQ;

public class QIPCEnvironmentInit
{
  public static final bmar sCallbac = new bmar();
  
  static void initEnvironment()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIPCEnvironmentInit", 2, "initEnvironment");
    }
    try
    {
      QIPCClientHelper.setupThreadEngine(new QIPCEnvironmentInit.1());
      if (TextUtils.equals(MobileQQ.processName, BaseApplicationImpl.sApplication.getApplicationContext().getPackageName()))
      {
        QIPCServerHelper.getInstance().getServer().setModuleFactory(new QIPCEnvironmentInit.2());
        if (BaseApplicationImpl.useQIPCStart(MobileQQ.processName))
        {
          if (QLog.isColorLevel()) {
            QLog.d("QIPCEnvironmentInit", 2, "connectMainProc");
          }
          QIPCClientHelper.getInstance().getClient().connect(null);
        }
        if (QLog.isColorLevel()) {
          QLog.d("QIPCEnvironmentInit", 2, "registerNFCEventCallback");
        }
      }
    }
    catch (Exception localException1)
    {
      try
      {
        do
        {
          for (;;)
          {
            if ((!TextUtils.isEmpty(BaseApplicationImpl.processName)) && (!BaseApplicationImpl.processName.endsWith(":buscard"))) {
              ActivityLifecycle.registerNFCEventCallback(sCallbac);
            }
            return;
            QIPCClientHelper.getInstance().getClient().guardServerProcList.add(MobileQQ.sMobileQQ.getPackageName());
          }
          localException1 = localException1;
        } while (!QLog.isColorLevel());
        QLog.d("QIPCEnvironmentInit", 2, "initEnvironment", localException1);
      }
      catch (Exception localException2)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("QIPCEnvironmentInit", 2, "registerNFCEventCallback failed", localException2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qipc.QIPCEnvironmentInit
 * JD-Core Version:    0.7.0.1
 */