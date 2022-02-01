package com.tencent.mobileqq.flutter.ipc;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.flutter.download.QFlutterInstaller;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

public class FlutterMainQIPCModule
  extends QIPCModule
{
  private static volatile FlutterMainQIPCModule a;
  
  private FlutterMainQIPCModule(String paramString)
  {
    super(paramString);
  }
  
  public static FlutterMainQIPCModule a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new FlutterMainQIPCModule("FlutterMainQIPCModule");
      }
      return a;
    }
    finally {}
  }
  
  private void a(String paramString1, String paramString2)
  {
    QFlutterInstaller.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), new FlutterMainQIPCModule.1(this, paramString1, paramString2));
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (paramBundle == null) {}
    for (paramBundle = "com.tencent.mobileqq:tool";; paramBundle = paramBundle.getString("FlutterCallerIpcProcessName", "com.tencent.mobileqq:tool"))
    {
      QLog.d("FlutterMainQIPCModule", 2, "[onCall] procName=" + paramBundle);
      if (!"ACTION_INSTALL_ENGINE".equals(paramString)) {
        break;
      }
      a(paramBundle, "ACTION_INSTALL_RESULT");
      return EIPCResult.createSuccessResult(null);
    }
    if ("ACTION_PREDOWNLOAD_ENGINE".equals(paramString))
    {
      a(paramBundle, "ACTION_PREDOWNLOAD_RESULT");
      return EIPCResult.createSuccessResult(null);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.ipc.FlutterMainQIPCModule
 * JD-Core Version:    0.7.0.1
 */