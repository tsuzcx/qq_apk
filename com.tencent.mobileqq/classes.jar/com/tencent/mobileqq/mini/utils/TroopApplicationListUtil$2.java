package com.tencent.mobileqq.mini.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import bgyr;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import org.json.JSONException;
import org.json.JSONObject;

final class TroopApplicationListUtil$2
  extends Handler
{
  TroopApplicationListUtil$2(Looper paramLooper, AsyncResult paramAsyncResult)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((paramMessage.obj instanceof bgyr))
    {
      paramMessage = (bgyr)paramMessage.obj;
      if (paramMessage.c == 0)
      {
        int i;
        try
        {
          if (paramMessage.d == null) {
            break label203;
          }
          QLog.d("TroopApplicationListUtil", 1, new Object[] { "handleMessage cgiState.htmlBody: ", paramMessage.d });
          i = new JSONObject(paramMessage.d).optInt("ec", -1);
          paramMessage = new JSONObject();
          if (i == 44012)
          {
            paramMessage.put("isExisted", true);
            paramMessage.put("errorCode", i);
            this.val$listener.onReceiveResult(true, paramMessage);
            return;
          }
          if (i == 0)
          {
            paramMessage.put("isExisted", false);
            paramMessage.put("errorCode", i);
            this.val$listener.onReceiveResult(true, paramMessage);
            return;
          }
        }
        catch (JSONException paramMessage)
        {
          QLog.e("TroopApplicationListUtil", 1, "handleMessage addMiniAppToTroopApplicationList exception ", paramMessage);
          this.val$listener.onReceiveResult(false, null);
          return;
        }
        paramMessage.put("errorCode", i);
        if (i == 44004) {
          paramMessage.put("errMsg", "not group manager");
        }
        this.val$listener.onReceiveResult(false, paramMessage);
        return;
        label203:
        QLog.e("TroopApplicationListUtil", 1, "native error, htmlBody is null");
        this.val$listener.onReceiveResult(false, null);
        return;
      }
      QLog.e("TroopApplicationListUtil", 1, "handleMessage addMiniAppToTroopApplicationList ,resultCode : " + paramMessage.c);
      this.val$listener.onReceiveResult(false, null);
      return;
    }
    QLog.e("TroopApplicationListUtil", 1, new Object[] { "handleMessage addMiniAppToTroopApplicationList ", " invalid msg.obj" });
    this.val$listener.onReceiveResult(false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.utils.TroopApplicationListUtil.2
 * JD-Core Version:    0.7.0.1
 */