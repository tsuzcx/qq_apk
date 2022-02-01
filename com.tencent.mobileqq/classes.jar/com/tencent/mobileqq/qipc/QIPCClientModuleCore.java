package com.tencent.mobileqq.qipc;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

class QIPCClientModuleCore
  extends QIPCModule
{
  public static final String ACTION_IS_MODULE_RUNNING = "isrun";
  public static final String NAME = "QIPCClientModuleCore";
  public static final String PARAM_KEY_MODULEID = "module_id";
  
  public QIPCClientModuleCore()
  {
    super("QIPCClientModuleCore");
  }
  
  public EIPCResult isModuleRunning(String paramString, Bundle paramBundle)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      paramString = paramBundle.getString("module_id");
      bool1 = bool2;
      bool2 = MobileQQ.sMobileQQ.isModuleLoaded(paramString);
      bool1 = bool2;
      if (!bool2)
      {
        bool1 = bool2;
        bool2 = MobileQQ.sMobileQQ.waitAppRuntime(null).isModuleRunning(paramString);
        bool1 = bool2;
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    if (bool1) {
      return EIPCResult.createSuccessResult(null);
    }
    return EIPCResult.createResult(-102, null);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      String str = this.name;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("action = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", params = ");
      localStringBuilder.append(paramBundle);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (TextUtils.equals(paramString, "isrun")) {
      return isModuleRunning(paramString, paramBundle);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qipc.QIPCClientModuleCore
 * JD-Core Version:    0.7.0.1
 */