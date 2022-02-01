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
    if (a == null) {
      try
      {
        if (a == null) {
          a = new FlutterMainQIPCModule("FlutterMainQIPCModule");
        }
      }
      finally {}
    }
    return a;
  }
  
  private void a(String paramString1, String paramString2)
  {
    QFlutterInstaller.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), new FlutterMainQIPCModule.1(this, paramString1, paramString2));
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    Object localObject = "com.tencent.mobileqq:tool";
    if (paramBundle == null) {
      paramBundle = (Bundle)localObject;
    } else {
      paramBundle = paramBundle.getString("FlutterCallerIpcProcessName", "com.tencent.mobileqq:tool");
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[onCall] procName=");
    ((StringBuilder)localObject).append(paramBundle);
    QLog.d("FlutterMainQIPCModule", 2, ((StringBuilder)localObject).toString());
    if ("ACTION_INSTALL_ENGINE".equals(paramString))
    {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.ipc.FlutterMainQIPCModule
 * JD-Core Version:    0.7.0.1
 */