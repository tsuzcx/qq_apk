package com.tencent.qqmini.sdk.server;

import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

class LaunchManagerService$1
  implements AsyncResult
{
  LaunchManagerService$1(LaunchManagerService paramLaunchManagerService) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    paramJSONObject = new StringBuilder();
    paramJSONObject.append("---startApp---- useUserApp isSuccess = ");
    paramJSONObject.append(paramBoolean);
    QMLog.i("minisdk-start_LaunchManagerService", paramJSONObject.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.server.LaunchManagerService.1
 * JD-Core Version:    0.7.0.1
 */