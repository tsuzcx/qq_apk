package com.tencent.qqmini.sdk.core.plugins;

import bgok;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONObject;

class PersonalizeJsPlugin$1
  implements AsyncResult
{
  PersonalizeJsPlugin$1(PersonalizeJsPlugin paramPersonalizeJsPlugin, bgok parambgok) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    QMLog.i("PersonalizeJsPlugin", "setPersonalizeInfo result:" + paramBoolean);
    if (paramBoolean)
    {
      this.val$req.a();
      return;
    }
    this.val$req.a("params error.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.PersonalizeJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */