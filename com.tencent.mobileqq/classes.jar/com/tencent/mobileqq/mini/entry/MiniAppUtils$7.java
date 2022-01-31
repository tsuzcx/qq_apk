package com.tencent.mobileqq.mini.entry;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import bbca;
import bcgs;
import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPluginEngine;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

final class MiniAppUtils$7
  extends Handler
{
  MiniAppUtils$7(Looper paramLooper, boolean paramBoolean, BaseJsPluginEngine paramBaseJsPluginEngine, JsRuntime paramJsRuntime, String paramString, int paramInt)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    bcgs localbcgs;
    if ((paramMessage.obj instanceof bcgs))
    {
      localbcgs = (bcgs)paramMessage.obj;
      QLog.d("MiniAppUtils", 1, new Object[] { "handleMessage ", localbcgs });
      if (localbcgs.jdField_c_of_type_Int == 0) {
        for (;;)
        {
          JSONObject localJSONObject;
          try
          {
            localJSONObject = new JSONObject();
            if (localbcgs.d == null) {
              break label212;
            }
            if (this.val$returnAsJSON)
            {
              localJSONObject.put("data", new JSONObject(localbcgs.d));
              localJSONObject.put("statusCode", localbcgs.b);
              localJSONObject.put("wnsCode", localbcgs.jdField_c_of_type_Int);
              localJSONObject.put("header", localbcgs.jdField_c_of_type_JavaLangString);
              this.val$jsPluginEngine.callbackJsEventOK(this.val$jsRuntime, this.val$eventName, localJSONObject, this.val$callBackId);
              return;
            }
            if (localbcgs.a)
            {
              paramMessage = bbca.encodeToString(localbcgs.d.getBytes(), 0);
              localJSONObject.put("data", paramMessage);
              continue;
            }
            paramMessage = localbcgs.d;
          }
          catch (JSONException paramMessage)
          {
            QLog.e("MiniAppUtils", 1, "handleMessage wnsCgiRequest exception ", paramMessage);
            this.val$jsPluginEngine.callbackJsEventFail(this.val$jsRuntime, this.val$eventName, null, this.val$callBackId);
            return;
          }
          continue;
          label212:
          localJSONObject.put("data", "");
        }
      }
      paramMessage = new JSONObject();
    }
    try
    {
      paramMessage.put("wnsCode", localbcgs.jdField_c_of_type_Int);
      label243:
      this.val$jsPluginEngine.callbackJsEventFail(this.val$jsRuntime, this.val$eventName, paramMessage, this.val$callBackId);
      return;
      QLog.e("MiniAppUtils", 1, new Object[] { "handleMessage wnsCgiRequest ", " invalid msg.obj" });
      this.val$jsPluginEngine.callbackJsEventFail(this.val$jsRuntime, this.val$eventName, null, this.val$callBackId);
      return;
    }
    catch (Exception localException)
    {
      break label243;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppUtils.7
 * JD-Core Version:    0.7.0.1
 */