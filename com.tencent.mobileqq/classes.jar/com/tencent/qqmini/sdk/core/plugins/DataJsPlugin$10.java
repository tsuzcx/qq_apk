package com.tencent.qqmini.sdk.core.plugins;

import bgkd;
import com.tencent.qqmini.sdk.core.proxy.AdProxy.ICmdListener;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONException;
import org.json.JSONObject;

class DataJsPlugin$10
  implements AdProxy.ICmdListener
{
  DataJsPlugin$10(DataJsPlugin paramDataJsPlugin, bgkd parambgkd, int paramInt) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean) {
      try
      {
        int i = paramJSONObject.getInt("retCode");
        paramJSONObject.getString("errMsg");
        String str1 = paramJSONObject.getString("response");
        String str2 = paramJSONObject.getString("adClass");
        paramJSONObject = new JSONObject();
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("data", str1);
          localJSONObject.put("ret", i);
          localJSONObject.put("adClass", str2);
          paramJSONObject.put("data", localJSONObject.toString());
          QMLog.d("DataJsPlugin", "sendAdRequest. retCode = " + i);
          this.val$req.a(paramJSONObject);
          DataJsPlugin.access$000(this.this$0, str1, this.val$constAdType);
          return;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            QMLog.i("DataJsPlugin", "sendAdRequest. retCode = " + i);
          }
        }
        this.val$req.b();
      }
      catch (Exception paramJSONObject)
      {
        this.val$req.b();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.DataJsPlugin.10
 * JD-Core Version:    0.7.0.1
 */