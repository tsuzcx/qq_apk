package com.tencent.qqmini.sdk.minigame.plugins;

import NS_MINI_CLOUDSTORAGE.CloudStorage.StGetUserInteractiveStorageRsp;
import bgkd;
import bgwc;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONObject;

class OpenDataJsPlugin$7
  implements AsyncResult
{
  OpenDataJsPlugin$7(OpenDataJsPlugin paramOpenDataJsPlugin, bgkd parambgkd) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    QMLog.d("OpenDataJsPlugin", "getUserInteractiveStorage receive isSuc= " + paramBoolean + " ret=" + String.valueOf(paramJSONObject));
    if (paramJSONObject == null)
    {
      bgwc.a().e("OpenDataJsPlugin", "handleNativeRequest API_GET_USER_INTERACTIVE_STORAGE error , ret == null");
      bgwc.a("handleNativeRequest API_GET_USER_INTERACTIVE_STORAGE error , ret == null");
      this.val$req.b();
      return;
    }
    if (paramBoolean)
    {
      int i;
      JSONObject localJSONObject;
      try
      {
        Object localObject = (CloudStorage.StGetUserInteractiveStorageRsp)paramJSONObject.get("response");
        i = paramJSONObject.getInt("retCode");
        paramJSONObject = paramJSONObject.getString("errMsg");
        String str = ((CloudStorage.StGetUserInteractiveStorageRsp)localObject).encryptedData.get();
        localObject = ((CloudStorage.StGetUserInteractiveStorageRsp)localObject).iv.get();
        localJSONObject = new JSONObject();
        if (i == 0)
        {
          localJSONObject.put("encryptedData", str);
          localJSONObject.put("iv", localObject);
          this.val$req.a(localJSONObject);
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        bgwc.a().e("OpenDataJsPlugin", "handleNativeRequest API_GET_USER_INTERACTIVE_STORAGE error ", paramJSONObject);
        bgwc.a("handleNativeRequest API_GET_USER_INTERACTIVE_STORAGE error " + paramJSONObject.getMessage());
        this.val$req.b();
        return;
      }
      localJSONObject.put("errMsg", paramJSONObject);
      localJSONObject.put("errCode", i);
      bgwc.a().e("OpenDataJsPlugin", "handleNativeRequest API_GET_USER_INTERACTIVE_STORAGE ret != null");
      bgwc.a("handleNativeRequest API_GET_USER_INTERACTIVE_STORAGE error ret != null");
      this.val$req.b();
      return;
    }
    bgwc.a().e("OpenDataJsPlugin", "handleNativeRequest API_GET_USER_INTERACTIVE_STORAGE error , isSuc false");
    bgwc.a("handleNativeRequest API_GET_USER_INTERACTIVE_STORAGE error , isSuc false");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.plugins.OpenDataJsPlugin.7
 * JD-Core Version:    0.7.0.1
 */