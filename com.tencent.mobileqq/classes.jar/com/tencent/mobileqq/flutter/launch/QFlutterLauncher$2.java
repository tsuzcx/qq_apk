package com.tencent.mobileqq.flutter.launch;

import com.tencent.mobileqq.flutter.ipc.FlutterSubQIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class QFlutterLauncher$2
  implements EIPCResultCallback
{
  QFlutterLauncher$2(QFlutterLauncher paramQFlutterLauncher) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (!paramEIPCResult.isSuccess())
    {
      QLog.d("QFlutter.launcher", 1, "install IPC fail");
      FlutterSubQIPCModule.b();
      QFlutterLauncher.a(this.a, 1, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.launch.QFlutterLauncher.2
 * JD-Core Version:    0.7.0.1
 */