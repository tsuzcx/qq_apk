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
    if (paramBoolean)
    {
      QMLog.d("DataJsPlugin", "call getGroupShareInfo  ret:" + paramJSONObject.toString());
      for (;;)
      {
        try
        {
          Object localObject = (MiniProgramShare.StGetGroupShareInfoRsp)paramJSONObject.get("response");
          int i = paramJSONObject.getInt("resultCode");
          String str1 = ((MiniProgramShare.StGetGroupShareInfoRsp)localObject).encryptedData.get();
          String str2 = ((MiniProgramShare.StGetGroupShareInfoRsp)localObject).iv.get();
          QMLog.d("DataJsPlugin", "getGroupShareInfo receive resultCode= " + i + " encryptedData=" + str1 + " iv=" + str2);
          localObject = new JSONObject();
          ((JSONObject)localObject).putOpt("encryptedData", str1);
          ((JSONObject)localObject).putOpt("iv", str2);
          if (!DataJsPlugin.access$600(this.this$0))
          {
            paramJSONObject = new JSONObject();
            try
            {
              paramJSONObject.put("data", localObject);
              QMLog.d("DataJsPlugin", "call getGroupShareInfo： " + paramJSONObject.toString());
              this.val$req.ok(paramJSONObject);
              if (this.val$getShareInfoHandler == null) {
                break;
              }
              this.val$getShareInfoHandler.removeMessages(1);
              return;
            }
            catch (JSONException localJSONException)
            {
              localJSONException.printStackTrace();
              continue;
            }
          }
          this.val$req.ok(paramJSONObject);
        }
        catch (Exception paramJSONObject)
        {
          QMLog.e("DataJsPlugin", "call getGroupShareInfo failed ");
          this.val$req.fail();
          return;
        }
      }
    }
    QMLog.e("DataJsPlugin", "call getGroupShareInfo failed ");
    this.val$req.fail();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.DataJsPlugin.16
 * JD-Core Version:    0.7.0.1
 */