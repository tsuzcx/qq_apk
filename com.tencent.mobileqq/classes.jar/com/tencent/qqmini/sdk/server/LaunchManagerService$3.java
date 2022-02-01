package com.tencent.qqmini.sdk.server;

import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

class LaunchManagerService$3
  implements AsyncResult
{
  LaunchManagerService$3(LaunchManagerService paramLaunchManagerService) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    QMLog.i("minisdk-start_LaunchManagerService", "---startApp---- useUserApp isSuccess = " + paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.server.LaunchManagerService.3
 * JD-Core Version:    0.7.0.1
 */