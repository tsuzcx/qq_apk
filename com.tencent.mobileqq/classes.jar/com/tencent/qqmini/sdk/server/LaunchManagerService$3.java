package com.tencent.qqmini.sdk.server;

import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.manager.BaseLibManager.UpdateListener;

class LaunchManagerService$3
  implements BaseLibManager.UpdateListener
{
  LaunchManagerService$3(LaunchManagerService paramLaunchManagerService) {}
  
  public void onUpdateResult(int paramInt)
  {
    QMLog.w("minisdk-start_LaunchManagerService", "updateBaseLib ret=" + paramInt);
    if (paramInt == 0) {
      return;
    }
    if (paramInt == 1)
    {
      QMLog.w("minisdk-start_LaunchManagerService", "基础库无更新.");
      return;
    }
    String str = "基础库更新失败.";
    if (paramInt == 1100) {
      str = "础库更新请求失败.";
    }
    for (;;)
    {
      QMLog.w("minisdk-start_LaunchManagerService", str);
      return;
      if (paramInt == 1101) {
        str = "基础库下载失败.";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.server.LaunchManagerService.3
 * JD-Core Version:    0.7.0.1
 */