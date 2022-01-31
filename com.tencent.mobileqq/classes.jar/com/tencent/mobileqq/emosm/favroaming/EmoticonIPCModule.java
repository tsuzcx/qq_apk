package com.tencent.mobileqq.emosm.favroaming;

import abzo;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.vas.VasExtensionManager;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import mqq.app.AppRuntime;

public class EmoticonIPCModule
  extends QIPCModule
{
  private static EmoticonIPCModule a;
  
  private EmoticonIPCModule(String paramString)
  {
    super(paramString);
  }
  
  public static EmoticonIPCModule a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new EmoticonIPCModule("EmoticonIPCModule");
      }
      return a;
    }
    finally {}
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonIPCModule", 2, "onCall action = " + paramString);
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (!(localAppRuntime instanceof QQAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonIPCModule", 2, "cannot get QQAppInterface.");
      }
      return null;
    }
    ThreadManager.post(new abzo(this, paramBundle, paramString, ((VasExtensionManager)((QQAppInterface)localAppRuntime).getManager(234)).a, paramInt), 5, null, true);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.favroaming.EmoticonIPCModule
 * JD-Core Version:    0.7.0.1
 */