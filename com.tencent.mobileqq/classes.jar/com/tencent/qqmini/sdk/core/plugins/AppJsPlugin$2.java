package com.tencent.qqmini.sdk.core.plugins;

import bdcy;
import bdfz;
import bdgg;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import org.json.JSONObject;

class AppJsPlugin$2
  implements AsyncResult
{
  AppJsPlugin$2(AppJsPlugin paramAppJsPlugin, bdfz parambdfz) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      paramJSONObject = bdgg.a(this.val$req.jdField_a_of_type_JavaLangString, paramJSONObject);
      this.val$req.jdField_a_of_type_Bdcy.a(this.val$req.b, paramJSONObject.toString());
      return;
    }
    paramJSONObject = bdgg.b(this.val$req.jdField_a_of_type_JavaLangString, paramJSONObject);
    this.val$req.jdField_a_of_type_Bdcy.a(this.val$req.b, paramJSONObject.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.AppJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */