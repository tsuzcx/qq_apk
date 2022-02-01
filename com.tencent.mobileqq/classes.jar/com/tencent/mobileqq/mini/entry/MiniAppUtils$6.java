package com.tencent.mobileqq.mini.entry;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import bhkv;
import bisp;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import org.json.JSONException;
import org.json.JSONObject;

final class MiniAppUtils$6
  extends Handler
{
  MiniAppUtils$6(Looper paramLooper, boolean paramBoolean, AsyncResult paramAsyncResult)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    bisp localbisp;
    if ((paramMessage.obj instanceof bisp))
    {
      localbisp = (bisp)paramMessage.obj;
      QLog.d("MiniAppUtils", 1, new Object[] { "handleMessage ", localbisp });
      if (localbisp.jdField_c_of_type_Int == 0) {
        for (;;)
        {
          JSONObject localJSONObject;
          try
          {
            localJSONObject = new JSONObject();
            if (localbisp.d == null) {
              break label194;
            }
            if (this.val$returnAsJSON)
            {
              localJSONObject.put("data", new JSONObject(localbisp.d));
              localJSONObject.put("statusCode", localbisp.b);
              localJSONObject.put("wnsCode", localbisp.jdField_c_of_type_Int);
              localJSONObject.put("header", localbisp.jdField_c_of_type_JavaLangString);
              this.val$listener.onReceiveResult(true, localJSONObject);
              return;
            }
            if (localbisp.a)
            {
              paramMessage = bhkv.encodeToString(localbisp.d.getBytes(), 0);
              localJSONObject.put("data", paramMessage);
              continue;
            }
            paramMessage = localbisp.d;
          }
          catch (JSONException paramMessage)
          {
            QLog.e("MiniAppUtils", 1, "handleMessage wnsCgiRequest exception ", paramMessage);
            this.val$listener.onReceiveResult(false, null);
            return;
          }
          continue;
          label194:
          localJSONObject.put("data", "");
        }
      }
      paramMessage = new JSONObject();
    }
    try
    {
      paramMessage.put("wnsCode", localbisp.jdField_c_of_type_Int);
      label225:
      this.val$listener.onReceiveResult(false, paramMessage);
      return;
      QLog.e("MiniAppUtils", 1, new Object[] { "handleMessage wnsCgiRequest ", " invalid msg.obj" });
      this.val$listener.onReceiveResult(false, null);
      return;
    }
    catch (Exception localException)
    {
      break label225;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppUtils.6
 * JD-Core Version:    0.7.0.1
 */