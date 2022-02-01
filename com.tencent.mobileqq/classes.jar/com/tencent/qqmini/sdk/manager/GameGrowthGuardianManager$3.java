package com.tencent.qqmini.sdk.manager;

import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

final class GameGrowthGuardianManager$3
  implements AsyncResult
{
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onReceived() called with: success = [");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("], stReportExecuteRsp = [");
    localStringBuilder.append(paramJSONObject);
    localStringBuilder.append("]");
    QMLog.d("GameGrowthGuardianManager", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.GameGrowthGuardianManager.3
 * JD-Core Version:    0.7.0.1
 */