package com.tencent.qqmini.minigame.plugins;

import android.content.Context;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import org.json.JSONObject;

class RaffleJsPlugin$8
  implements AsyncResult
{
  RaffleJsPlugin$8(RaffleJsPlugin paramRaffleJsPlugin, RaffleJsPlugin.GetGameRaffleMaterialInterface paramGetGameRaffleMaterialInterface, Context paramContext) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    int i;
    if ((paramBoolean) && (RaffleJsPlugin.access$1800(this.this$0, paramJSONObject))) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      this.val$getGameRaffleMaterialInterface.onSuccess();
      RaffleJsPlugin.access$1900(this.this$0, this.val$context);
      return;
    }
    this.val$getGameRaffleMaterialInterface.onFail();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.plugins.RaffleJsPlugin.8
 * JD-Core Version:    0.7.0.1
 */