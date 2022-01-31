package com.tencent.qqmini.sdk.core.plugins;

import bghn;
import bgho;
import bgkd;
import bgki;
import com.tencent.qqmini.sdk.core.manager.VoIPManager;
import com.tencent.qqmini.sdk.core.manager.VoIPManager.RoomConfig;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONException;
import org.json.JSONObject;

class VoIPJsPlugin$2
  implements AsyncResult
{
  VoIPJsPlugin$2(VoIPJsPlugin paramVoIPJsPlugin, bgkd parambgkd, VoIPManager.RoomConfig paramRoomConfig) {}
  
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
      QMLog.i("[mini] VoIPJsPlugin", String.format("succ: %s ret:%s", new Object[] { Boolean.valueOf(paramBoolean), localObject1 }));
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
          QMLog.e("[mini] VoIPJsPlugin", (String)localObject1);
          localObject1 = new JSONObject();
        }
        try
        {
          ((JSONObject)localObject1).put("errCode", -1000);
          localObject1 = this.val$req.jdField_a_of_type_Bghn;
          i = this.val$req.jdField_b_of_type_Int;
          localObject3 = this.val$req.jdField_a_of_type_JavaLangString;
          if (paramJSONObject != null)
          {
            paramJSONObject = paramJSONObject.optString("errMsg", "idResult failed");
            ((bghn)localObject1).a(i, bgki.a((String)localObject3, null, paramJSONObject).toString());
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
            QMLog.e("[mini] VoIPJsPlugin", "JSONException", localJSONException1);
            continue;
            paramJSONObject = "internal error";
          }
        }
      }
    }
    if (this.val$roomConfig.muteConfig == null)
    {
      QMLog.e("[mini] VoIPJsPlugin", "muteConfig null " + this.val$req.jdField_b_of_type_JavaLangString);
      Object localObject2 = new JSONObject();
      try
      {
        ((JSONObject)localObject2).put("errCode", -1000);
        localObject2 = this.val$req.jdField_a_of_type_Bghn;
        i = this.val$req.jdField_b_of_type_Int;
        localObject3 = this.val$req.jdField_a_of_type_JavaLangString;
        if (paramJSONObject != null)
        {
          paramJSONObject = paramJSONObject.optString("errMsg", "muteConfig failed");
          ((bghn)localObject2).a(i, bgki.a((String)localObject3, null, paramJSONObject).toString());
          return;
        }
      }
      catch (JSONException localJSONException2)
      {
        for (;;)
        {
          QMLog.e("[mini] VoIPJsPlugin", "JSONException", localJSONException2);
          continue;
          paramJSONObject = "internal error";
        }
      }
    }
    VoIPManager.getInstance().joinRoom(localJSONException2, this.val$roomConfig.muteConfig, VoIPJsPlugin.access$100(this.this$0, this.this$0.mMiniAppContext.a().appId, this.val$roomConfig), new VoIPJsPlugin.2.1(this));
    return;
    label394:
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("errCode", -1000);
      localObject3 = this.val$req.jdField_a_of_type_Bghn;
      i = this.val$req.jdField_b_of_type_Int;
      String str = this.val$req.jdField_a_of_type_JavaLangString;
      if (paramJSONObject != null)
      {
        paramJSONObject = paramJSONObject.optString("errMsg", "transfer roomId err");
        ((bghn)localObject3).a(i, bgki.a(str, localJSONObject, paramJSONObject).toString());
        return;
      }
    }
    catch (JSONException localJSONException3)
    {
      for (;;)
      {
        QMLog.e("[mini] VoIPJsPlugin", "JSONException", localJSONException3);
        continue;
        paramJSONObject = "internal error";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.VoIPJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */