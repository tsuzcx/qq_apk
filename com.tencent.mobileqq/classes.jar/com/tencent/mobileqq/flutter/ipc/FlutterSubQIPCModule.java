package com.tencent.mobileqq.flutter.ipc;

import android.os.Bundle;
import com.tencent.mobileqq.flutter.launch.QFlutterLauncher;
import com.tencent.mobileqq.flutter.launch.QFlutterLauncher.InstallResult;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import eipc.EIPCClient;
import eipc.EIPCResult;

public class FlutterSubQIPCModule
  extends QIPCModule
{
  public static volatile boolean a = false;
  private static volatile FlutterSubQIPCModule b;
  
  private FlutterSubQIPCModule(String paramString)
  {
    super(paramString);
  }
  
  public static FlutterSubQIPCModule a()
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new FlutterSubQIPCModule("FlutterSubQIPCModule");
        }
      }
      finally {}
    }
    return b;
  }
  
  public static void b()
  {
    if (!a) {
      try
      {
        QIPCClientHelper.getInstance().register(a());
        a = true;
        return;
      }
      catch (Exception localException)
      {
        QLog.d("FlutterSubQIPCModule", 1, "register", localException);
      }
    }
  }
  
  public static void c()
  {
    try
    {
      if (QIPCClientHelper.getInstance().getClient() != null)
      {
        QIPCClientHelper.getInstance().getClient().unRegisterModule(a());
        a = false;
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.d("FlutterSubQIPCModule", 1, "unregister", localException);
    }
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if ("ACTION_INSTALL_RESULT".equals(paramString))
    {
      QFlutterLauncher.a().a(QFlutterLauncher.InstallResult.a(paramBundle));
    }
    else if ("ACTION_PREDOWNLOAD_RESULT".equals(paramString))
    {
      boolean bool = paramBundle.getBoolean("KEY_INSTALL_RESULT");
      paramString = new StringBuilder();
      paramString.append("predownload finish isSuccess=");
      paramString.append(bool);
      QLog.d("FlutterSubQIPCModule", 1, paramString.toString());
      LocalMultiProcConfig.putBool("qzone_flutter_predownload_success", bool);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.ipc.FlutterSubQIPCModule
 * JD-Core Version:    0.7.0.1
 */