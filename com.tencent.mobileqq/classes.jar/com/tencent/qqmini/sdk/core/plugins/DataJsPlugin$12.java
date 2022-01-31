package com.tencent.qqmini.sdk.core.plugins;

import NS_MINI_SHARE.MiniProgramShare.StGetGroupShareInfoRsp;
import android.os.Handler;
import bekr;
import betc;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import org.json.JSONException;
import org.json.JSONObject;

class DataJsPlugin$12
  implements AsyncResult
{
  DataJsPlugin$12(DataJsPlugin paramDataJsPlugin, bekr parambekr, Handler paramHandler) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      betc.a("DataJsPlugin", "call getGroupShareInfo  ret:" + paramJSONObject.toString());
      for (;;)
      {
        try
        {
          Object localObject = (MiniProgramShare.StGetGroupShareInfoRsp)paramJSONObject.get("response");
          int i = paramJSONObject.getInt("resultCode");
          String str1 = ((MiniProgramShare.StGetGroupShareInfoRsp)localObject).encryptedData.get();
          String str2 = ((MiniProgramShare.StGetGroupShareInfoRsp)localObject).iv.get();
          betc.a("DataJsPlugin", "getGroupShareInfo receive resultCode= " + i + " encryptedData=" + str1 + " iv=" + str2);
          localObject = new JSONObject();
          ((JSONObject)localObject).putOpt("encryptedData", str1);
          ((JSONObject)localObject).putOpt("iv", str2);
          if (!this.this$0.mIsMiniGame)
          {
            paramJSONObject = new JSONObject();
            try
            {
              paramJSONObject.put("data", localObject);
              betc.a("DataJsPlugin", "call getGroupShareInfo： " + paramJSONObject.toString());
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
          betc.d("DataJsPlugin", "call getGroupShareInfo failed ");
          this.val$req.b();
          return;
        }
      }
    }
    betc.d("DataJsPlugin", "call getGroupShareInfo failed ");
    this.val$req.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.DataJsPlugin.12
 * JD-Core Version:    0.7.0.1
 */