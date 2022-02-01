package com.tencent.mobileqq.mini.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import bisp;
import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPluginEngine;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

final class TroopApplicationListUtil$4
  extends Handler
{
  TroopApplicationListUtil$4(Looper paramLooper, BaseJsPluginEngine paramBaseJsPluginEngine, TroopApplicationListUtil.JsPluginParam paramJsPluginParam, String paramString1, String paramString2)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((paramMessage.obj instanceof bisp))
    {
      paramMessage = (bisp)paramMessage.obj;
      if (paramMessage.c == 0)
      {
        try
        {
          if (paramMessage.d != null)
          {
            QLog.d("TroopApplicationListUtil", 1, new Object[] { "handleMessage cgiState.htmlBody: ", paramMessage.d });
            int i = new JSONObject(paramMessage.d).optInt("ec", -1);
            TroopApplicationListUtil.access$000(i);
            paramMessage = new JSONObject();
            if ((i == 0) || (i == 41012))
            {
              paramMessage.put("errorCode", i);
              this.val$jsPluginEngine.callbackJsEventOK(this.val$jsPluginParam.jsRuntime, this.val$jsPluginParam.event, paramMessage, this.val$jsPluginParam.callbackId);
            }
            for (;;)
            {
              TroopApplicationListUtil.access$100(i, this.val$groupUin, this.val$appId);
              return;
              paramMessage.put("errorCode", i);
              this.val$jsPluginEngine.callbackJsEventFail(this.val$jsPluginParam.jsRuntime, this.val$jsPluginParam.event, paramMessage, this.val$jsPluginParam.callbackId);
            }
          }
          this.val$jsPluginEngine.callbackJsEventFail(this.val$jsPluginParam.jsRuntime, this.val$jsPluginParam.event, null, "native error, htmlBody is null", this.val$jsPluginParam.callbackId);
        }
        catch (JSONException paramMessage)
        {
          QLog.e("TroopApplicationListUtil", 1, "handleMessage addMiniAppToTroopApplicationList exception ", paramMessage);
          this.val$jsPluginEngine.callbackJsEventFail(this.val$jsPluginParam.jsRuntime, this.val$jsPluginParam.event, null, "native error, json exception", this.val$jsPluginParam.callbackId);
          return;
        }
        return;
      }
      QLog.e("TroopApplicationListUtil", 1, "handleMessage addMiniAppToTroopApplicationList ,resultCode : " + paramMessage.c);
      this.val$jsPluginEngine.callbackJsEventFail(this.val$jsPluginParam.jsRuntime, this.val$jsPluginParam.event, null, "native error, request fail", this.val$jsPluginParam.callbackId);
      return;
    }
    QLog.e("TroopApplicationListUtil", 1, new Object[] { "handleMessage addMiniAppToTroopApplicationList ", " invalid msg.obj" });
    this.val$jsPluginEngine.callbackJsEventFail(this.val$jsPluginParam.jsRuntime, this.val$jsPluginParam.event, null, "native error, invalid msg.obj", this.val$jsPluginParam.callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.utils.TroopApplicationListUtil.4
 * JD-Core Version:    0.7.0.1
 */