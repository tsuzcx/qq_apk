package com.tencent.mobileqq.microapp.ext;

import agzd;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.microapp.apkg.ApkgConfigManager;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;

public class ManagerProxy
{
  public static ApkgConfigManager getApkgConfigManager(AppRuntime paramAppRuntime)
  {
    return (ApkgConfigManager)paramAppRuntime.getManager(287);
  }
  
  public static PreloadManager getPreloadManager(AppRuntime paramAppRuntime)
  {
    return (PreloadManager)paramAppRuntime.getManager(151);
  }
  
  public static agzd getQWalletConfigManager(AppRuntime paramAppRuntime)
  {
    return (agzd)paramAppRuntime.getManager(245);
  }
  
  public static TicketManager getTicketManager(AppRuntime paramAppRuntime)
  {
    return (TicketManager)paramAppRuntime.getManager(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.ext.ManagerProxy
 * JD-Core Version:    0.7.0.1
 */