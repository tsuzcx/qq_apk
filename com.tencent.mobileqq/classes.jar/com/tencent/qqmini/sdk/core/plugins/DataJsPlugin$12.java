package com.tencent.qqmini.sdk.core.plugins;

import android.os.Handler;
import bdfz;
import bdnw;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import org.json.JSONException;
import org.json.JSONObject;

class DataJsPlugin$12
  implements AsyncResult
{
  DataJsPlugin$12(DataJsPlugin paramDataJsPlugin, bdfz parambdfz, Handler paramHandler) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      bdnw.a("DataJsPlugin", "call getGroupShareInfo  ret:" + paramJSONObject.toString());
      for (;;)
      {
        try
        {
          if (!this.this$0.mIsMiniGame)
          {
            JSONObject localJSONObject = new JSONObject();
            try
            {
              localJSONObject.put("data", paramJSONObject);
              bdnw.a("DataJsPlugin", "call getGroupShareInfo： " + localJSONObject.toString());
              this.val$req.a(localJSONObject);
              if (this.val$getShareInfoHandler == null) {
                break;
              }
              this.val$getShareInfoHandler.removeMessages(1);
              return;
            }
            catch (JSONException paramJSONObject)
            {
              paramJSONObject.printStackTrace();
              continue;
            }
          }
          this.val$req.a(paramJSONObject);
        }
        catch (Exception paramJSONObject)
        {
          bdnw.d("DataJsPlugin", "call getGroupShareInfo failed ");
          this.val$req.b();
          return;
        }
      }
    }
    bdnw.d("DataJsPlugin", "call getGroupShareInfo failed ");
    this.val$req.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.DataJsPlugin.12
 * JD-Core Version:    0.7.0.1
 */