package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import NS_MINI_SHARE.MiniProgramShare.StGetGroupShareInfoRsp;
import android.os.Handler;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class DataJsPlugin$25
  implements MiniAppCmdInterface
{
  DataJsPlugin$25(DataJsPlugin paramDataJsPlugin, JsRuntime paramJsRuntime, String paramString, int paramInt, Handler paramHandler) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      QLog.d("[mini] DataJsPlugin", 2, "call getGroupShareInfo  ret:" + paramJSONObject.toString());
      for (;;)
      {
        try
        {
          Object localObject = (MiniProgramShare.StGetGroupShareInfoRsp)paramJSONObject.get("response");
          int i = paramJSONObject.getInt("resultCode");
          paramJSONObject = ((MiniProgramShare.StGetGroupShareInfoRsp)localObject).encryptedData.get();
          String str = ((MiniProgramShare.StGetGroupShareInfoRsp)localObject).iv.get();
          QLog.d("[mini] DataJsPlugin", 1, "getGroupShareInfo receive resultCode= " + i + " encryptedData=" + paramJSONObject + " iv=" + str);
          localObject = new JSONObject();
          ((JSONObject)localObject).putOpt("encryptedData", paramJSONObject);
          ((JSONObject)localObject).putOpt("iv", str);
          if (!this.this$0.isGameRuntime)
          {
            paramJSONObject = new JSONObject();
            try
            {
              paramJSONObject.put("data", localObject);
              QLog.d("[mini] DataJsPlugin", 1, "call getGroupShareInfo： " + paramJSONObject.toString());
              this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$event, paramJSONObject, this.val$callbackId);
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
          this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$event, localJSONException, this.val$callbackId);
        }
        catch (Exception paramJSONObject)
        {
          QLog.e("[mini] DataJsPlugin", 2, "call getGroupShareInfo failed ");
          this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$event, null, this.val$callbackId);
          return;
        }
      }
    }
    QLog.e("[mini] DataJsPlugin", 2, "call getGroupShareInfo failed ");
    this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$event, null, this.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.DataJsPlugin.25
 * JD-Core Version:    0.7.0.1
 */