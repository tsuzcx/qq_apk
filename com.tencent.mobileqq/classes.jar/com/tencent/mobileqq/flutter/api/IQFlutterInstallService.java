package com.tencent.mobileqq.flutter.api;

import com.tencent.mobileqq.flutter.download.InstallCallback;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(process={"all"})
public abstract interface IQFlutterInstallService
  extends IRuntimeService
{
  public abstract void install(InstallCallback paramInstallCallback);
  
  public abstract boolean isAppInstalled();
  
  public abstract boolean isEngineInstalled();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.api.IQFlutterInstallService
 * JD-Core Version:    0.7.0.1
 */