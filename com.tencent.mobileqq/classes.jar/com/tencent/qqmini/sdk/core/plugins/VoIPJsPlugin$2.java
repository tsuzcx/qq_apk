package com.tencent.qqmini.sdk.core.plugins;

import bdcy;
import bdcz;
import bdey;
import bdfg;
import bdfz;
import bdgg;
import bdnw;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import org.json.JSONException;
import org.json.JSONObject;

class VoIPJsPlugin$2
  implements AsyncResult
{
  VoIPJsPlugin$2(VoIPJsPlugin paramVoIPJsPlugin, bdfz parambdfz, bdfg parambdfg) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    Object localObject1;
    if (paramJSONObject != null) {
      localObject1 = paramJSONObject.toString();
    }
    Object localObject3;
    int i;
    for (;;)
    {
      bdnw.b("[mini] VoIPJsPlugin", String.format("succ: %s ret:%s", new Object[] { Boolean.valueOf(paramBoolean), localObject1 }));
      if (!paramBoolean) {
        break label394;
      }
      localObject1 = VoIPJsPlugin.access$000(this.this$0, paramJSONObject);
      if (localObject1 == null)
      {
        localObject3 = new StringBuilder().append("idResult null ");
        if (paramJSONObject != null)
        {
          localObject1 = paramJSONObject.toString();
          bdnw.d("[mini] VoIPJsPlugin", (String)localObject1);
          localObject1 = new JSONObject();
        }
        try
        {
          ((JSONObject)localObject1).put("errCode", -1000);
          localObject1 = this.val$req.jdField_a_of_type_Bdcy;
          i = this.val$req.jdField_b_of_type_Int;
          localObject3 = this.val$req.jdField_a_of_type_JavaLangString;
          if (paramJSONObject != null)
          {
            paramJSONObject = paramJSONObject.optString("errMsg", "idResult failed");
            ((bdcy)localObject1).a(i, bdgg.a((String)localObject3, null, paramJSONObject).toString());
            return;
            localObject1 = "";
            continue;
            localObject1 = "";
          }
        }
        catch (JSONException localJSONException1)
        {
          for (;;)
          {
            bdnw.d("[mini] VoIPJsPlugin", "JSONException", localJSONException1);
            continue;
            paramJSONObject = "internal error";
          }
        }
      }
    }
    if (this.val$roomConfig.a == null)
    {
      bdnw.d("[mini] VoIPJsPlugin", "muteConfig null " + this.val$req.jdField_b_of_type_JavaLangString);
      Object localObject2 = new JSONObject();
      try
      {
        ((JSONObject)localObject2).put("errCode", -1000);
        localObject2 = this.val$req.jdField_a_of_type_Bdcy;
        i = this.val$req.jdField_b_of_type_Int;
        localObject3 = this.val$req.jdField_a_of_type_JavaLangString;
        if (paramJSONObject != null)
        {
          paramJSONObject = paramJSONObject.optString("errMsg", "muteConfig failed");
          ((bdcy)localObject2).a(i, bdgg.a((String)localObject3, null, paramJSONObject).toString());
          return;
        }
      }
      catch (JSONException localJSONException2)
      {
        for (;;)
        {
          bdnw.d("[mini] VoIPJsPlugin", "JSONException", localJSONException2);
          continue;
          paramJSONObject = "internal error";
        }
      }
    }
    bdey.a().a(localJSONException2, this.val$roomConfig.a, VoIPJsPlugin.access$100(this.this$0, this.this$0.mMiniAppContext.a().appId, this.val$roomConfig), new VoIPJsPlugin.2.1(this));
    return;
    label394:
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("errCode", -1000);
      localObject3 = this.val$req.jdField_a_of_type_Bdcy;
      i = this.val$req.jdField_b_of_type_Int;
      String str = this.val$req.jdField_a_of_type_JavaLangString;
      if (paramJSONObject != null)
      {
        paramJSONObject = paramJSONObject.optString("errMsg", "transfer roomId err");
        ((bdcy)localObject3).a(i, bdgg.a(str, localJSONObject, paramJSONObject).toString());
        return;
      }
    }
    catch (JSONException localJSONException3)
    {
      for (;;)
      {
        bdnw.d("[mini] VoIPJsPlugin", "JSONException", localJSONException3);
        continue;
        paramJSONObject = "internal error";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.VoIPJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */