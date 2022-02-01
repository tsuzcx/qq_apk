package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.utils.BannerAdPosInfo;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

class BannerAdPlugin$2
  implements Runnable
{
  BannerAdPlugin$2(BannerAdPlugin paramBannerAdPlugin, RequestEvent paramRequestEvent) {}
  
  public void run()
  {
    boolean bool = BannerAdPlugin.access$900(this.this$0);
    if ((bool) && (BannerAdPlugin.access$000(this.this$0).mAdIntervals != 0)) {
      BannerAdPlugin.access$1000(this.this$0);
    }
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("state", "show");
        if (!bool) {
          break label154;
        }
        String str = "ok";
        localJSONObject.put("status", str);
        BannerAdPlugin.access$600(this.this$0, this.val$req, localJSONObject, "onBannerAdShowDone");
      }
      catch (JSONException localJSONException)
      {
        BannerAdPlugin.access$300(this.this$0, this.val$req, 1003, (String)BannerAdPlugin.access$200().get(Integer.valueOf(1003)), 0);
        QMLog.i("BannerAdPlugin", "handle operateBannerAd show error", localJSONException);
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showBannerAd ");
      ((StringBuilder)localObject).append(bool);
      QMLog.i("BannerAdPlugin", ((StringBuilder)localObject).toString());
      return;
      label154:
      localObject = "error";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.BannerAdPlugin.2
 * JD-Core Version:    0.7.0.1
 */