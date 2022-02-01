package com.tencent.mobileqq.microapp.ext;

import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.microapp.apkg.ApkgConfigManager;
import com.tencent.mobileqq.qwallet.config.IQWalletConfigService;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;

public class ManagerProxy
{
  public static ApkgConfigManager getApkgConfigManager(AppRuntime paramAppRuntime)
  {
    return (ApkgConfigManager)paramAppRuntime.getManager(QQManagerFactory.APKG_CONFIG_MANAGER);
  }
  
  public static IQWalletConfigService getQWalletConfigManager(AppRuntime paramAppRuntime)
  {
    return (IQWalletConfigService)paramAppRuntime.getRuntimeService(IQWalletConfigService.class, "");
  }
  
  public static TicketManager getTicketManager(AppRuntime paramAppRuntime)
  {
    return (TicketManager)paramAppRuntime.getManager(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.ext.ManagerProxy
 * JD-Core Version:    0.7.0.1
 */