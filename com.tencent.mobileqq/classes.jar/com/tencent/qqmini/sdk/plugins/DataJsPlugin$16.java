package com.tencent.qqmini.sdk.plugins;

import NS_MINI_SHARE.MiniProgramShare.StGetGroupShareInfoRsp;
import android.os.Handler;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONException;
import org.json.JSONObject;

class DataJsPlugin$16
  implements AsyncResult
{
  DataJsPlugin$16(DataJsPlugin paramDataJsPlugin, RequestEvent paramRequestEvent, Handler paramHandler) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    Object localObject1;
    if (paramBoolean)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("call getGroupShareInfo  ret:");
      ((StringBuilder)localObject1).append(paramJSONObject.toString());
      QMLog.d("DataJsPlugin", ((StringBuilder)localObject1).toString());
    }
    try
    {
      localObject1 = (MiniProgramShare.StGetGroupShareInfoRsp)paramJSONObject.get("response");
      int i = paramJSONObject.getInt("resultCode");
      paramJSONObject = ((MiniProgramShare.StGetGroupShareInfoRsp)localObject1).encryptedData.get();
      localObject1 = ((MiniProgramShare.StGetGroupShareInfoRsp)localObject1).iv.get();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getGroupShareInfo receive resultCode= ");
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append(" encryptedData=");
      ((StringBuilder)localObject2).append(paramJSONObject);
      ((StringBuilder)localObject2).append(" iv=");
      ((StringBuilder)localObject2).append((String)localObject1);
      QMLog.d("DataJsPlugin", ((StringBuilder)localObject2).toString());
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).putOpt("encryptedData", paramJSONObject);
      ((JSONObject)localObject2).putOpt("iv", localObject1);
      if (!DataJsPlugin.access$600(this.this$0))
      {
        paramJSONObject = new JSONObject();
        try
        {
          paramJSONObject.put("data", localObject2);
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("call getGroupShareInfo： ");
        localStringBuilder.append(paramJSONObject.toString());
        QMLog.d("DataJsPlugin", localStringBuilder.toString());
        this.val$req.ok(paramJSONObject);
      }
      else
      {
        this.val$req.ok((JSONObject)localObject2);
      }
      if (this.val$getShareInfoHandler == null) {
        break label314;
      }
      this.val$getShareInfoHandler.removeMessages(1);
      return;
    }
    catch (Exception paramJSONObject)
    {
      label283:
      break label283;
    }
    QMLog.e("DataJsPlugin", "call getGroupShareInfo failed ");
    this.val$req.fail();
    return;
    QMLog.e("DataJsPlugin", "call getGroupShareInfo failed ");
    this.val$req.fail();
    label314:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.DataJsPlugin.16
 * JD-Core Version:    0.7.0.1
 */