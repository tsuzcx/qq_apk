package com.tencent.qqmini.sdk.core.plugins;

import bglu;
import bgok;
import bgop;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import org.json.JSONObject;

class AppJsPlugin$3
  implements AsyncResult
{
  AppJsPlugin$3(AppJsPlugin paramAppJsPlugin, bgok parambgok) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      paramJSONObject = bgop.a(this.val$req.jdField_a_of_type_JavaLangString, paramJSONObject);
      this.val$req.jdField_a_of_type_Bglu.a(this.val$req.b, paramJSONObject.toString());
      return;
    }
    paramJSONObject = bgop.b(this.val$req.jdField_a_of_type_JavaLangString, paramJSONObject);
    this.val$req.jdField_a_of_type_Bglu.a(this.val$req.b, paramJSONObject.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.AppJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */