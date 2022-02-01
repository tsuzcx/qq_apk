package com.tencent.mobileqq.flutter.api.impl;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.flutter.api.IQFlutterInstallService;
import com.tencent.mobileqq.flutter.download.InstallCallback;
import com.tencent.mobileqq.flutter.download.QFlutterInstaller;
import mqq.app.AppRuntime;

public class QFlutterInstallServiceImpl
  implements IQFlutterInstallService
{
  private QQAppInterface mApp;
  
  public void install(InstallCallback paramInstallCallback)
  {
    QFlutterInstaller.a(this.mApp, paramInstallCallback);
  }
  
  public boolean isAppInstalled()
  {
    return QFlutterInstaller.b(this.mApp);
  }
  
  public boolean isEngineInstalled()
  {
    return QFlutterInstaller.a(this.mApp);
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mApp = ((QQAppInterface)paramAppRuntime);
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.api.impl.QFlutterInstallServiceImpl
 * JD-Core Version:    0.7.0.1
 */