package com.tencent.mobileqq.qipc;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.IPluginAdapterProxy;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.PluginAdapterImpl;
import eipc.EIPCClient;
import eipc.EIPCServer;
import java.util.ArrayList;
import mqq.app.MobileQQ;

public class QIPCEnvironmentInit
{
  static void initEnvironment()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIPCEnvironmentInit", 2, "initEnvironment");
    }
    IPluginAdapterProxy.setProxy(new PluginAdapterImpl());
    for (;;)
    {
      try
      {
        if (!TextUtils.equals(MobileQQ.processName, BaseApplicationImpl.sApplication.getApplicationContext().getPackageName())) {
          continue;
        }
        QIPCServerHelper.getInstance().getServer().setModuleFactory(new QIPCEnvironmentInit.1());
        if (BaseApplicationImpl.useQIPCStart(MobileQQ.processName))
        {
          if (QLog.isColorLevel()) {
            QLog.d("QIPCEnvironmentInit", 2, "connectMainProc");
          }
          QIPCClientHelper.getInstance().getClient().connect(null);
        }
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("QIPCEnvironmentInit", 2, "initEnvironment", localException);
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QIPCEnvironmentInit", 2, "registerNFCEventCallback");
      }
      return;
      QIPCClientHelper.getInstance().getClient().guardServerProcList.add(MobileQQ.sMobileQQ.getPackageName());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qipc.QIPCEnvironmentInit
 * JD-Core Version:    0.7.0.1
 */