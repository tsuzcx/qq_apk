package com.tencent.mobileqq.mini.launch;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.qphone.base.util.QLog;

public class AppBrandMainService$AppBrandMainServiceBinder
  extends IAppBrandService.Stub
{
  private static final byte[] INSTANCE_LOCK = new byte[0];
  private static volatile AppBrandMainServiceBinder mInstance;
  private Context mContext;
  public String mProcessName;
  
  public AppBrandMainService$AppBrandMainServiceBinder(Context paramContext, String paramString)
  {
    this.mContext = paramContext;
    this.mProcessName = paramString;
  }
  
  public void onAppBackground(String paramString, MiniAppConfig paramMiniAppConfig, Bundle paramBundle)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AppBrandMainService onAppBackground. pOrigName=");
    localStringBuilder.append(this.mProcessName);
    localStringBuilder.append(" Name=");
    localStringBuilder.append(paramString);
    QLog.w("miniapp-process_AppBrandMainService", 1, localStringBuilder.toString());
    AppBrandLaunchManager.g().getHandler().post(new AppBrandMainService.AppBrandMainServiceBinder.3(this, paramString, paramMiniAppConfig, paramBundle));
  }
  
  public void onAppForeground(String paramString, MiniAppConfig paramMiniAppConfig, Bundle paramBundle)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AppBrandMainService onAppForeground. pOrigName=");
    localStringBuilder.append(this.mProcessName);
    localStringBuilder.append(" Name=");
    localStringBuilder.append(paramString);
    QLog.w("miniapp-process_AppBrandMainService", 1, localStringBuilder.toString());
    AppBrandLaunchManager.g().getHandler().post(new AppBrandMainService.AppBrandMainServiceBinder.4(this, paramString, paramMiniAppConfig, paramBundle));
  }
  
  public void onAppStart(String paramString, MiniAppConfig paramMiniAppConfig, Bundle paramBundle)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AppBrandMainService onAppStart. pOrigName=");
    localStringBuilder.append(this.mProcessName);
    localStringBuilder.append(" Name=");
    localStringBuilder.append(paramString);
    QLog.w("miniapp-process_AppBrandMainService", 1, localStringBuilder.toString());
    AppBrandLaunchManager.g().getHandler().post(new AppBrandMainService.AppBrandMainServiceBinder.2(this, paramString, paramMiniAppConfig, paramBundle));
  }
  
  public void onAppStop(String paramString, MiniAppConfig paramMiniAppConfig, Bundle paramBundle)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AppBrandMainService onAppStop. pOrigName=");
    localStringBuilder.append(this.mProcessName);
    localStringBuilder.append(" Name=");
    localStringBuilder.append(paramString);
    QLog.w("miniapp-process_AppBrandMainService", 1, localStringBuilder.toString());
    AppBrandLaunchManager.g().getHandler().post(new AppBrandMainService.AppBrandMainServiceBinder.5(this, paramString, paramMiniAppConfig, paramBundle));
  }
  
  public void preloadMiniApp()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AppBrandMainService call preloadMiniApp not from Main Processor . pName=");
    localStringBuilder.append(this.mProcessName);
    QLog.w("miniapp-process_AppBrandMainService", 1, localStringBuilder.toString());
  }
  
  public void preloadPackage(MiniAppInfo paramMiniAppInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AppBrandMainService call preloadPackage not from Main Processor. pName=");
    localStringBuilder.append(this.mProcessName);
    QLog.w("miniapp-process_AppBrandMainService", 1, localStringBuilder.toString());
    if (paramMiniAppInfo != null) {
      AppBrandLaunchManager.g().preloadPackage(paramMiniAppInfo);
    }
  }
  
  public void sendCmd(String paramString, Bundle paramBundle, CmdCallback paramCmdCallback)
  {
    AppBrandLaunchManager.g().sendCmd(paramString, paramBundle, paramCmdCallback);
  }
  
  public void startMiniApp(MiniAppConfig paramMiniAppConfig, ResultReceiver paramResultReceiver)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AppBrandMainService call startMiniApp not from Main Processor. pName=");
    localStringBuilder.append(this.mProcessName);
    QLog.w("miniapp-process_AppBrandMainService", 1, localStringBuilder.toString());
    AppBrandLaunchManager.g().getHandler().post(new AppBrandMainService.AppBrandMainServiceBinder.1(this, paramMiniAppConfig, paramResultReceiver));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.launch.AppBrandMainService.AppBrandMainServiceBinder
 * JD-Core Version:    0.7.0.1
 */