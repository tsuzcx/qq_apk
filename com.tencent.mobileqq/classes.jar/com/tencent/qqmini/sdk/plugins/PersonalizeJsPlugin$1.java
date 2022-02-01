package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

class PersonalizeJsPlugin$1
  implements AsyncResult
{
  PersonalizeJsPlugin$1(PersonalizeJsPlugin paramPersonalizeJsPlugin, RequestEvent paramRequestEvent) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    paramJSONObject = new StringBuilder();
    paramJSONObject.append("setPersonalizeInfo result:");
    paramJSONObject.append(paramBoolean);
    QMLog.i("PersonalizeJsPlugin", paramJSONObject.toString());
    if (paramBoolean)
    {
      this.val$req.ok();
      return;
    }
    this.val$req.fail("params error.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.PersonalizeJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */