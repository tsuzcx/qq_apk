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
    try
    {
      if (TextUtils.equals(MobileQQ.processName, BaseApplicationImpl.sApplication.getApplicationContext().getPackageName())) {
        QIPCServerHelper.getInstance().getServer().setModuleFactory(new QIPCEnvironmentInit.1());
      } else {
        QIPCClientHelper.getInstance().getClient().guardServerProcList.add(MobileQQ.sMobileQQ.getPackageName());
      }
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
      if (QLog.isColorLevel()) {
        QLog.d("QIPCEnvironmentInit", 2, "initEnvironment", localException);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("QIPCEnvironmentInit", 2, "registerNFCEventCallback");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qipc.QIPCEnvironmentInit
 * JD-Core Version:    0.7.0.1
 */