package com.tencent.qqmini.sdk.core.plugins;

import NS_MINI_SHARE.MiniProgramShare.StGetGroupShareInfoRsp;
import android.os.Handler;
import bgok;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONException;
import org.json.JSONObject;

class DataJsPlugin$13
  implements AsyncResult
{
  DataJsPlugin$13(DataJsPlugin paramDataJsPlugin, bgok parambgok, Handler paramHandler) {}
  
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
          if (!this.this$0.mIsMiniGame)
          {
            paramJSONObject = new JSONObject();
            try
            {
              paramJSONObject.put("data", localObject);
              QMLog.d("DataJsPlugin", "call getGroupShareInfo： " + paramJSONObject.toString());
              this.val$req.a(paramJSONObject);
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
          this.val$req.a(paramJSONObject);
        }
        catch (Exception paramJSONObject)
        {
          QMLog.e("DataJsPlugin", "call getGroupShareInfo failed ");
          this.val$req.b();
          return;
        }
      }
    }
    QMLog.e("DataJsPlugin", "call getGroupShareInfo failed ");
    this.val$req.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.DataJsPlugin.13
 * JD-Core Version:    0.7.0.1
 */