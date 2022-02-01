package com.tencent.mobileqq.qqexpand.plugin.preload;

import com.tencent.mobileqq.qroute.module.IQRoutePluginInstallListener;
import com.tencent.qphone.base.util.QLog;

class DummyPluginInstallListener
  implements IQRoutePluginInstallListener
{
  public void onInstallBegin(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("ExpandPluginPreloadManager", 4, new Object[] { "pluginInstall: onInstallBegin()", paramString });
    }
  }
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("ExpandPluginPreloadManager", 4, new Object[] { "pluginInstall: onInstallDownloadProgress()", paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    }
  }
  
  public void onInstallError(String paramString, int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("ExpandPluginPreloadManager", 4, new Object[] { "pluginInstall: onInstallError()", paramString, Integer.valueOf(paramInt) });
    }
  }
  
  public void onInstallFinish(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("ExpandPluginPreloadManager", 4, new Object[] { "pluginInstall: onInstallFinish()", paramString });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.plugin.preload.DummyPluginInstallListener
 * JD-Core Version:    0.7.0.1
 */