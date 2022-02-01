package com.tencent.mobileqq.mini.entry;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.webview.webso.WebSoCgiService.WebSoCgiState;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import org.json.JSONException;
import org.json.JSONObject;

final class MiniAppUtils$5
  extends Handler
{
  MiniAppUtils$5(Looper paramLooper, boolean paramBoolean, AsyncResult paramAsyncResult)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    WebSoCgiService.WebSoCgiState localWebSoCgiState;
    if ((paramMessage.obj instanceof WebSoCgiService.WebSoCgiState))
    {
      localWebSoCgiState = (WebSoCgiService.WebSoCgiState)paramMessage.obj;
      QLog.d("MiniAppUtils", 1, new Object[] { "handleMessage ", localWebSoCgiState });
      if (localWebSoCgiState.jdField_c_of_type_Int == 0) {
        try
        {
          JSONObject localJSONObject = new JSONObject();
          paramMessage = localWebSoCgiState.d;
          if (paramMessage != null)
          {
            if (this.val$returnAsJSON)
            {
              localJSONObject.put("data", new JSONObject(localWebSoCgiState.d));
            }
            else
            {
              if (localWebSoCgiState.a) {
                paramMessage = Base64Util.encodeToString(localWebSoCgiState.d.getBytes(), 0);
              } else {
                paramMessage = localWebSoCgiState.d;
              }
              localJSONObject.put("data", paramMessage);
            }
          }
          else {
            localJSONObject.put("data", "");
          }
          localJSONObject.put("statusCode", localWebSoCgiState.b);
          localJSONObject.put("wnsCode", localWebSoCgiState.jdField_c_of_type_Int);
          localJSONObject.put("header", localWebSoCgiState.jdField_c_of_type_JavaLangString);
          this.val$listener.onReceiveResult(true, localJSONObject);
          return;
        }
        catch (JSONException paramMessage)
        {
          QLog.e("MiniAppUtils", 1, "handleMessage wnsCgiRequest exception ", paramMessage);
          this.val$listener.onReceiveResult(false, null);
          return;
        }
      }
      paramMessage = new JSONObject();
    }
    try
    {
      paramMessage.put("wnsCode", localWebSoCgiState.jdField_c_of_type_Int);
      label227:
      this.val$listener.onReceiveResult(false, paramMessage);
      return;
      QLog.e("MiniAppUtils", 1, new Object[] { "handleMessage wnsCgiRequest ", " invalid msg.obj" });
      this.val$listener.onReceiveResult(false, null);
      return;
    }
    catch (Exception localException)
    {
      break label227;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppUtils.5
 * JD-Core Version:    0.7.0.1
 */