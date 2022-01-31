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
    boolean bool1 = false;
    for (;;)
    {
      try
      {
        paramString = paramBundle.getString("module_id");
        bool2 = MobileQQ.sMobileQQ.isModuleLoaded(paramString);
        bool1 = bool2;
        bool2 = bool1;
        if (!bool1) {}
        paramString.printStackTrace();
      }
      catch (Exception paramString)
      {
        try
        {
          bool2 = MobileQQ.sMobileQQ.waitAppRuntime(null).isModuleRunning(paramString);
          if (!bool2) {
            break;
          }
          return EIPCResult.createSuccessResult(null);
        }
        catch (Exception paramString)
        {
          boolean bool2;
          break label52;
        }
        paramString = paramString;
      }
      label52:
      bool2 = bool1;
    }
    return EIPCResult.createResult(-102, null);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.name, 2, "action = " + paramString + ", params = " + paramBundle);
    }
    if (TextUtils.equals(paramString, "isrun")) {
      return isModuleRunning(paramString, paramBundle);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.qipc.QIPCClientModuleCore
 * JD-Core Version:    0.7.0.1
 */