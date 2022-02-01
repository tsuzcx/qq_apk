package com.tencent.mobileqq.microapp.ext;

import aktz;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.microapp.apkg.ApkgConfigManager;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;

public class ManagerProxy
{
  public static ApkgConfigManager getApkgConfigManager(AppRuntime paramAppRuntime)
  {
    return (ApkgConfigManager)paramAppRuntime.getManager(QQManagerFactory.APKG_CONFIG_MANAGER);
  }
  
  public static PreloadManager getPreloadManager(AppRuntime paramAppRuntime)
  {
    return (PreloadManager)paramAppRuntime.getManager(QQManagerFactory.PRELOAD_MANAGER);
  }
  
  public static aktz getQWalletConfigManager(AppRuntime paramAppRuntime)
  {
    return (aktz)paramAppRuntime.getManager(QQManagerFactory.QWALLET_CONFIG_MANAGER);
  }
  
  public static TicketManager getTicketManager(AppRuntime paramAppRuntime)
  {
    return (TicketManager)paramAppRuntime.getManager(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.ext.ManagerProxy
 * JD-Core Version:    0.7.0.1
 */