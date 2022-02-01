package com.tencent.mobileqq.mini.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.webview.webso.WebSoCgiService.WebSoCgiState;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import org.json.JSONException;
import org.json.JSONObject;

final class TroopApplicationListUtil$3
  extends Handler
{
  TroopApplicationListUtil$3(Looper paramLooper, AsyncResult paramAsyncResult, String paramString1, String paramString2)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((paramMessage.obj instanceof WebSoCgiService.WebSoCgiState))
    {
      paramMessage = (WebSoCgiService.WebSoCgiState)paramMessage.obj;
      if (paramMessage.i == 0) {
        try
        {
          if (paramMessage.d != null)
          {
            QLog.d("TroopApplicationListUtil", 1, new Object[] { "handleMessage cgiState.htmlBody: ", paramMessage.d });
            int i = new JSONObject(paramMessage.d).optInt("ec", -1);
            TroopApplicationListUtil.showToast(i);
            paramMessage = new JSONObject();
            if ((i != 0) && (i != 41012))
            {
              paramMessage.put("errorCode", i);
              this.val$listener.onReceiveResult(false, paramMessage);
            }
            else
            {
              paramMessage.put("errorCode", i);
              this.val$listener.onReceiveResult(true, paramMessage);
            }
            TroopApplicationListUtil.access$000(i, this.val$groupUin, this.val$appId);
            return;
          }
          new JSONObject().put("errMsg", "htmlBody is null");
          this.val$listener.onReceiveResult(false, null);
          return;
        }
        catch (JSONException paramMessage)
        {
          QLog.e("TroopApplicationListUtil", 1, "handleMessage addMiniAppToTroopApplicationList exception ", paramMessage);
          this.val$listener.onReceiveResult(false, null);
          return;
        }
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleMessage addMiniAppToTroopApplicationList ,resultCode : ");
      localStringBuilder.append(paramMessage.i);
      QLog.e("TroopApplicationListUtil", 1, localStringBuilder.toString());
      this.val$listener.onReceiveResult(false, null);
      return;
    }
    QLog.e("TroopApplicationListUtil", 1, new Object[] { "handleMessage addMiniAppToTroopApplicationList ", " invalid msg.obj" });
    this.val$listener.onReceiveResult(false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.utils.TroopApplicationListUtil.3
 * JD-Core Version:    0.7.0.1
 */