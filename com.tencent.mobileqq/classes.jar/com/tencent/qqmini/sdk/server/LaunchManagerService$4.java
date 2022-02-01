package com.tencent.qqmini.sdk.server;

import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.manager.BaseLibManager.UpdateListener;

class LaunchManagerService$4
  implements BaseLibManager.UpdateListener
{
  LaunchManagerService$4(LaunchManagerService paramLaunchManagerService) {}
  
  public void onUpdateResult(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("updateBaseLib ret=");
    ((StringBuilder)localObject).append(paramInt);
    QMLog.w("minisdk-start_LaunchManagerService", ((StringBuilder)localObject).toString());
    if (paramInt == 0) {
      return;
    }
    if (paramInt == 1)
    {
      QMLog.w("minisdk-start_LaunchManagerService", "基础库无更新.");
      return;
    }
    if (paramInt == 1100) {
      localObject = "础库更新请求失败.";
    } else if (paramInt == 1101) {
      localObject = "基础库下载失败.";
    } else {
      localObject = "基础库更新失败.";
    }
    QMLog.w("minisdk-start_LaunchManagerService", (String)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.server.LaunchManagerService.4
 * JD-Core Version:    0.7.0.1
 */