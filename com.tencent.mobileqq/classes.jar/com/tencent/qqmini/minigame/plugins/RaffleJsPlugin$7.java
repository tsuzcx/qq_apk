package com.tencent.qqmini.minigame.plugins;

import android.content.Context;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

final class RaffleJsPlugin$7
  implements AsyncResult
{
  RaffleJsPlugin$7(Context paramContext) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    String str = RaffleJsPlugin.access$200();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getGameRaffleMaterialStatic isSuc: ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(";jsonObject: ");
    localStringBuilder.append(paramJSONObject.toString());
    QMLog.d(str, localStringBuilder.toString());
    if (paramBoolean) {
      RaffleJsPlugin.access$1700(this.val$context, paramJSONObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.plugins.RaffleJsPlugin.7
 * JD-Core Version:    0.7.0.1
 */