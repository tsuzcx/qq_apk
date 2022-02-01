package com.tencent.qqmini.sdk.plugins;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONArray;
import org.json.JSONObject;

class ReportPlugin$1
  implements Runnable
{
  ReportPlugin$1(ReportPlugin paramReportPlugin, RequestEvent paramRequestEvent) {}
  
  public void run()
  {
    try
    {
      Object localObject = new JSONObject(this.val$req.jsonParams);
      String str = ((JSONObject)localObject).getString("table");
      localObject = ((JSONObject)localObject).getJSONArray("reportArray");
      if ((!TextUtils.isEmpty(str)) && (((JSONArray)localObject).length() > 0)) {
        ReportPlugin.access$000(this.this$0, str, (JSONArray)localObject);
      }
      return;
    }
    catch (Exception localException)
    {
      QMLog.e("ReportPlugin", " handleReportDC error.", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.ReportPlugin.1
 * JD-Core Version:    0.7.0.1
 */