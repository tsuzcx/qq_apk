package com.tencent.qqmini.sdk.core.plugins;

import begy;
import beka;
import bekg;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import org.json.JSONObject;

class AppJsPlugin$2
  implements AsyncResult
{
  AppJsPlugin$2(AppJsPlugin paramAppJsPlugin, beka parambeka) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      paramJSONObject = bekg.a(this.val$req.jdField_a_of_type_JavaLangString, paramJSONObject);
      this.val$req.jdField_a_of_type_Begy.a(this.val$req.b, paramJSONObject.toString());
      return;
    }
    paramJSONObject = bekg.b(this.val$req.jdField_a_of_type_JavaLangString, paramJSONObject);
    this.val$req.jdField_a_of_type_Begy.a(this.val$req.b, paramJSONObject.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.AppJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */