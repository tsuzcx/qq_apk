package com.tencent.qqmini.sdk.plugins;

import NS_MINI_CLOUDSTORAGE.CloudStorage.StGetUserInteractiveStorageRsp;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

class OpenDataCommonJsPlugin$6
  implements AsyncResult
{
  OpenDataCommonJsPlugin$6(OpenDataCommonJsPlugin paramOpenDataCommonJsPlugin, RequestEvent paramRequestEvent) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("getUserInteractiveStorage receive isSuc= ");
    ((StringBuilder)localObject1).append(paramBoolean);
    ((StringBuilder)localObject1).append(" ret=");
    ((StringBuilder)localObject1).append(String.valueOf(paramJSONObject));
    QMLog.d("OpenDataCommonJsPlugin", ((StringBuilder)localObject1).toString());
    if (paramJSONObject == null)
    {
      QMLog.e("OpenDataCommonJsPlugin", "handleNativeRequest API_GET_USER_INTERACTIVE_STORAGE error , ret == null");
      this.val$req.fail("request request is null.");
      return;
    }
    if (paramBoolean) {
      try
      {
        Object localObject2 = (CloudStorage.StGetUserInteractiveStorageRsp)paramJSONObject.get("response");
        int i = paramJSONObject.getInt("retCode");
        paramJSONObject = paramJSONObject.getString("errMsg");
        localObject1 = ((CloudStorage.StGetUserInteractiveStorageRsp)localObject2).encryptedData.get();
        String str = ((CloudStorage.StGetUserInteractiveStorageRsp)localObject2).iv.get();
        localObject2 = new JSONObject();
        if (i == 0)
        {
          ((JSONObject)localObject2).put("encryptedData", localObject1);
          ((JSONObject)localObject2).put("iv", str);
          this.val$req.ok((JSONObject)localObject2);
          return;
        }
        ((JSONObject)localObject2).put("retErrMsg", paramJSONObject);
        ((JSONObject)localObject2).put("errCode", i);
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("handleNativeRequest API_GET_USER_INTERACTIVE_STORAGE ");
        paramJSONObject.append(((JSONObject)localObject2).toString());
        QMLog.e("OpenDataCommonJsPlugin", paramJSONObject.toString());
        this.val$req.fail((JSONObject)localObject2, "");
        return;
      }
      catch (Exception paramJSONObject)
      {
        QMLog.e("OpenDataCommonJsPlugin", "handleNativeRequest API_GET_USER_INTERACTIVE_STORAGE error ", paramJSONObject);
        this.val$req.fail(paramJSONObject.getMessage());
        return;
      }
    }
    QMLog.e("OpenDataCommonJsPlugin", "handleNativeRequest API_GET_USER_INTERACTIVE_STORAGE error , isSuc false");
    this.val$req.fail("request failed.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.OpenDataCommonJsPlugin.6
 * JD-Core Version:    0.7.0.1
 */