package com.tencent.mobileqq.vas;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

public class VasMonitorIPCModule
  extends QIPCModule
{
  private static VasMonitorIPCModule a;
  
  public VasMonitorIPCModule(String paramString)
  {
    super(paramString);
  }
  
  public static VasMonitorIPCModule a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new VasMonitorIPCModule("VasMonitorIPCModule");
      }
      return a;
    }
    finally {}
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasMonitorIPCModule", 2, "action = " + paramString);
    }
    if (paramBundle == null) {
      QLog.d("VasMonitorIPCModule", 2, "vasreport Err params=null, action=" + paramString);
    }
    while ((!"action_vas_monitor".equals(paramString)) || (BaseApplicationImpl.getApplication() == null) || (!(BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) || ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime() == null)) {
      return null;
    }
    VasMonitorHandler.a(null, paramBundle.getString("key_appid"), paramBundle.getString("key_err_code"), paramBundle.getString("key_log"), paramBundle.getString("key_key4"), paramBundle.getString("key_key5"), paramBundle.getString("key_key6"), paramBundle.getFloat("key_value2"), paramBundle.getFloat("key_value3"));
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasMonitorIPCModule
 * JD-Core Version:    0.7.0.1
 */