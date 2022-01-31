package com.tencent.qqmini.sdk.core.plugins;

import bgkd;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONObject;

class DataJsPlugin$6
  implements AsyncResult
{
  DataJsPlugin$6(DataJsPlugin paramDataJsPlugin, bgkd parambgkd) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      StringBuilder localStringBuilder = new StringBuilder().append("verifyPlugin : ");
      if (paramJSONObject != null) {}
      for (String str = paramJSONObject.toString();; str = "")
      {
        QMLog.e("DataJsPlugin", str);
        this.val$req.a(paramJSONObject);
        return;
      }
    }
    this.val$req.a("verifyPlugin failed.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.DataJsPlugin.6
 * JD-Core Version:    0.7.0.1
 */