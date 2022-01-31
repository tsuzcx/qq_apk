package com.tencent.qqmini.sdk.core.plugins;

import bghn;
import bgkd;
import bgki;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import org.json.JSONObject;

class AppJsPlugin$4
  implements AsyncResult
{
  AppJsPlugin$4(AppJsPlugin paramAppJsPlugin, bgkd parambgkd) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      paramJSONObject = bgki.a(this.val$req.jdField_a_of_type_JavaLangString, null);
      this.val$req.jdField_a_of_type_Bghn.a(this.val$req.b, paramJSONObject.toString());
      return;
    }
    paramJSONObject = bgki.b(this.val$req.jdField_a_of_type_JavaLangString, null);
    this.val$req.jdField_a_of_type_Bghn.a(this.val$req.b, paramJSONObject.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.AppJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */