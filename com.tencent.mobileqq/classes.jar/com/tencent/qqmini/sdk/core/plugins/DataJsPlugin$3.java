package com.tencent.qqmini.sdk.core.plugins;

import bgkd;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONObject;

class DataJsPlugin$3
  implements AsyncResult
{
  DataJsPlugin$3(DataJsPlugin paramDataJsPlugin, bgkd parambgkd) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    QMLog.d("DataJsPlugin", "onCmdListener() called with: isSuc = [" + paramBoolean + "], ret = [" + paramJSONObject + "]");
    if (paramBoolean)
    {
      this.val$req.a(paramJSONObject);
      return;
    }
    this.val$req.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.DataJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */