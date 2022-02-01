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
  private static volatile FlutterSubQIPCModule a;
  public static volatile boolean a;
  
  static
  {
    jdField_a_of_type_Boolean = false;
  }
  
  private FlutterSubQIPCModule(String paramString)
  {
    super(paramString);
  }
  
  public static FlutterSubQIPCModule a()
  {
    if (jdField_a_of_type_ComTencentMobileqqFlutterIpcFlutterSubQIPCModule == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqFlutterIpcFlutterSubQIPCModule == null) {
        jdField_a_of_type_ComTencentMobileqqFlutterIpcFlutterSubQIPCModule = new FlutterSubQIPCModule("FlutterSubQIPCModule");
      }
      return jdField_a_of_type_ComTencentMobileqqFlutterIpcFlutterSubQIPCModule;
    }
    finally {}
  }
  
  public static void a()
  {
    if (!jdField_a_of_type_Boolean) {}
    try
    {
      QIPCClientHelper.getInstance().register(a());
      jdField_a_of_type_Boolean = true;
      return;
    }
    catch (Exception localException)
    {
      QLog.d("FlutterSubQIPCModule", 1, "register", localException);
    }
  }
  
  public static void b()
  {
    try
    {
      if (QIPCClientHelper.getInstance().getClient() != null)
      {
        QIPCClientHelper.getInstance().getClient().unRegisterModule(a());
        jdField_a_of_type_Boolean = false;
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.d("FlutterSubQIPCModule", 1, "unregister", localException);
    }
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if ("ACTION_INSTALL_RESULT".equals(paramString)) {
      QFlutterLauncher.a().a(QFlutterLauncher.InstallResult.a(paramBundle));
    }
    for (;;)
    {
      return null;
      if ("ACTION_PREDOWNLOAD_RESULT".equals(paramString))
      {
        boolean bool = paramBundle.getBoolean("KEY_INSTALL_RESULT");
        QLog.d("FlutterSubQIPCModule", 1, "predownload finish isSuccess=" + bool);
        LocalMultiProcConfig.putBool("qzone_flutter_predownload_success", bool);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.ipc.FlutterSubQIPCModule
 * JD-Core Version:    0.7.0.1
 */