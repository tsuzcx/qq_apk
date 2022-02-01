package com.tencent.mobileqq.mini.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import bhru;
import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPluginEngine;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

final class TroopApplicationListUtil$1
  extends Handler
{
  TroopApplicationListUtil$1(Looper paramLooper, BaseJsPluginEngine paramBaseJsPluginEngine, TroopApplicationListUtil.JsPluginParam paramJsPluginParam)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((paramMessage.obj instanceof bhru))
    {
      paramMessage = (bhru)paramMessage.obj;
      if (paramMessage.c == 0)
      {
        int i;
        try
        {
          if (paramMessage.d == null) {
            break label262;
          }
          QLog.d("TroopApplicationListUtil", 1, new Object[] { "handleMessage cgiState.htmlBody: ", paramMessage.d });
          i = new JSONObject(paramMessage.d).optInt("ec", -1);
          paramMessage = new JSONObject();
          if (i == 44012)
          {
            paramMessage.put("isExisted", true);
            paramMessage.put("errorCode", i);
            this.val$jsPluginEngine.callbackJsEventOK(this.val$jsPluginParam.jsRuntime, this.val$jsPluginParam.event, paramMessage, this.val$jsPluginParam.callbackId);
            return;
          }
          if (i == 0)
          {
            paramMessage.put("isExisted", false);
            paramMessage.put("errorCode", i);
            this.val$jsPluginEngine.callbackJsEventOK(this.val$jsPluginParam.jsRuntime, this.val$jsPluginParam.event, paramMessage, this.val$jsPluginParam.callbackId);
            return;
          }
        }
        catch (JSONException paramMessage)
        {
          QLog.e("TroopApplicationListUtil", 1, "handleMessage addMiniAppToTroopApplicationList exception ", paramMessage);
          this.val$jsPluginEngine.callbackJsEventFail(this.val$jsPluginParam.jsRuntime, this.val$jsPluginParam.event, null, "native error, json exception", this.val$jsPluginParam.callbackId);
          return;
        }
        paramMessage.put("errorCode", i);
        this.val$jsPluginEngine.callbackJsEventFail(this.val$jsPluginParam.jsRuntime, this.val$jsPluginParam.event, paramMessage, this.val$jsPluginParam.callbackId);
        return;
        label262:
        this.val$jsPluginEngine.callbackJsEventFail(this.val$jsPluginParam.jsRuntime, this.val$jsPluginParam.event, null, "native error, htmlBody is null", this.val$jsPluginParam.callbackId);
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
 * Qualified Name:     com.tencent.mobileqq.mini.utils.TroopApplicationListUtil.1
 * JD-Core Version:    0.7.0.1
 */