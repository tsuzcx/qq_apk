package com.tencent.qqmini.minigame.plugins;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.qqmini.minigame.R.string;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONException;
import org.json.JSONObject;

class RaffleJsPlugin$2
  implements AsyncResult
{
  RaffleJsPlugin$2(RaffleJsPlugin paramRaffleJsPlugin, Context paramContext) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    int i = 0;
    if (paramBoolean) {}
    for (;;)
    {
      Object localObject;
      try
      {
        paramJSONObject = new JSONObject(paramJSONObject.getString("key_result_data"));
        localObject = RaffleJsPlugin.access$200();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("doGameRaffle result: ");
        localStringBuilder.append(paramJSONObject.toString());
        QMLog.d((String)localObject, localStringBuilder.toString());
        int j = paramJSONObject.getInt("state");
        if (j != 0)
        {
          if (j != 1)
          {
            if (j != 2) {
              break label295;
            }
            QMLog.e(RaffleJsPlugin.access$200(), "doGameRaffle onReceiveResult out of time");
            RaffleJsPlugin.access$400(this.this$0, this.val$context, this.val$context.getResources().getString(R.string.mini_sdk_game_raffle_out_of_time));
            RaffleJsPlugin.access$500(this.this$0, "raffle out of time");
            break label295;
          }
          QMLog.e(RaffleJsPlugin.access$200(), "doGameRaffle onReceiveResult limited");
          RaffleJsPlugin.access$400(this.this$0, this.val$context, this.val$context.getResources().getString(R.string.mini_sdk_game_raffle_limited));
          RaffleJsPlugin.access$500(this.this$0, "raffle limited");
          break label295;
        }
        QMLog.d(RaffleJsPlugin.access$200(), "doGameRaffle onReceiveResult success");
        try
        {
          RaffleJsPlugin.access$300(this.this$0, this.val$context, paramJSONObject);
        }
        catch (JSONException paramJSONObject)
        {
          i = 0;
        }
        QMLog.e(RaffleJsPlugin.access$200(), "doGameRaffle onReceiveResult JSONException", paramJSONObject);
      }
      catch (JSONException paramJSONObject)
      {
        i = 1;
      }
      paramBoolean = false;
      break label226;
      i = 1;
      label226:
      if (!paramBoolean)
      {
        QMLog.e(RaffleJsPlugin.access$200(), "doGameRaffle onReceiveResult fail");
        paramJSONObject = this.this$0;
        localObject = this.val$context;
        RaffleJsPlugin.access$400(paramJSONObject, (Context)localObject, ((Context)localObject).getResources().getString(R.string.mini_sdk_game_raffle_fail));
        RaffleJsPlugin.access$500(this.this$0, "raffle fail");
        RaffleJsPlugin.access$600(this.this$0, 1);
      }
      if (i != 0) {
        this.this$0.hideLoading();
      }
      return;
      label295:
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.plugins.RaffleJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */