package com.tencent.qqmini.sdk.plugins;

import NS_MINI_CLOUDSTORAGE.CloudStorage.StGetUserInteractiveStorageRsp;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

class OpenDataCommonJsPlugin$8
  implements AsyncResult
{
  OpenDataCommonJsPlugin$8(OpenDataCommonJsPlugin paramOpenDataCommonJsPlugin, RequestEvent paramRequestEvent) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    QMLog.d("OpenDataCommonJsPlugin", "getUserInteractiveStorage receive isSuc= " + paramBoolean + " ret=" + String.valueOf(paramJSONObject));
    if (paramJSONObject == null)
    {
      QMLog.e("OpenDataCommonJsPlugin", "handleNativeRequest API_GET_USER_INTERACTIVE_STORAGE error , ret == null");
      this.val$req.fail("request request is null.");
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
          this.val$req.ok(localJSONObject);
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        QMLog.e("OpenDataCommonJsPlugin", "handleNativeRequest API_GET_USER_INTERACTIVE_STORAGE error ", paramJSONObject);
        this.val$req.fail(paramJSONObject.getMessage());
        return;
      }
      localJSONObject.put("retErrMsg", paramJSONObject);
      localJSONObject.put("errCode", i);
      QMLog.e("OpenDataCommonJsPlugin", "handleNativeRequest API_GET_USER_INTERACTIVE_STORAGE " + localJSONObject.toString());
      this.val$req.fail(localJSONObject, "");
      return;
    }
    QMLog.e("OpenDataCommonJsPlugin", "handleNativeRequest API_GET_USER_INTERACTIVE_STORAGE error , isSuc false");
    this.val$req.fail("request failed.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.OpenDataCommonJsPlugin.8
 * JD-Core Version:    0.7.0.1
 */