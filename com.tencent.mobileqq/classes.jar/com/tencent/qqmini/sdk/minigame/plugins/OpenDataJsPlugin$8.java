package com.tencent.qqmini.sdk.minigame.plugins;

import NS_MINI_CLOUDSTORAGE.CloudStorage.StGetUserInteractiveStorageRsp;
import beka;
import besl;
import bewt;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import org.json.JSONObject;

class OpenDataJsPlugin$8
  implements AsyncResult
{
  OpenDataJsPlugin$8(OpenDataJsPlugin paramOpenDataJsPlugin, beka parambeka) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    besl.a("OpenDataJsPlugin", "getUserInteractiveStorage receive isSuc= " + paramBoolean + " ret=" + String.valueOf(paramJSONObject));
    if (paramJSONObject == null)
    {
      bewt.a().e("OpenDataJsPlugin", "handleNativeRequest API_GET_USER_INTERACTIVE_STORAGE error , ret == null");
      bewt.a("handleNativeRequest API_GET_USER_INTERACTIVE_STORAGE error , ret == null");
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
        bewt.a().e("OpenDataJsPlugin", "handleNativeRequest API_GET_USER_INTERACTIVE_STORAGE error ", paramJSONObject);
        bewt.a("handleNativeRequest API_GET_USER_INTERACTIVE_STORAGE error " + paramJSONObject.getMessage());
        this.val$req.b();
        return;
      }
      localJSONObject.put("errMsg", paramJSONObject);
      localJSONObject.put("errCode", i);
      bewt.a().e("OpenDataJsPlugin", "handleNativeRequest API_GET_USER_INTERACTIVE_STORAGE ret != null");
      bewt.a("handleNativeRequest API_GET_USER_INTERACTIVE_STORAGE error ret != null");
      this.val$req.b();
      return;
    }
    bewt.a().e("OpenDataJsPlugin", "handleNativeRequest API_GET_USER_INTERACTIVE_STORAGE error , isSuc false");
    bewt.a("handleNativeRequest API_GET_USER_INTERACTIVE_STORAGE error , isSuc false");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.plugins.OpenDataJsPlugin.8
 * JD-Core Version:    0.7.0.1
 */