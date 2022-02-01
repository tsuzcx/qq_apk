package com.tencent.mobileqq.mini.out.nativePlugins;

import android.os.Bundle;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.JSContext;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import org.json.JSONObject;

class GameBuddyPlugin$1
  implements EIPCResultCallback
{
  GameBuddyPlugin$1(GameBuddyPlugin paramGameBuddyPlugin, JSContext paramJSContext, String paramString) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    for (;;)
    {
      int i;
      try
      {
        JSONObject localJSONObject = new JSONObject();
        if (paramEIPCResult == null)
        {
          localJSONObject.put("code", -1);
          this.val$jsContext.evaluateCallback(false, localJSONObject, "result is null");
          return;
        }
        if (paramEIPCResult.code == 0)
        {
          i = paramEIPCResult.data.getInt("uin_type");
          localJSONObject.put("code", 0);
          if (i != 10009) {
            break label172;
          }
          i = 1;
          localJSONObject.put("type", i);
          if ("invokeGameBuddyAio".equals(this.val$apiName)) {
            this.val$jsContext.getActivity();
          }
        }
        else
        {
          localJSONObject.put("code", -2);
          JSContext localJSContext = this.val$jsContext;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("result code:");
          localStringBuilder.append(paramEIPCResult.code);
          localJSContext.evaluateCallback(false, localJSONObject, localStringBuilder.toString());
          return;
        }
      }
      catch (Throwable paramEIPCResult)
      {
        QLog.e("GameBuddyPlugin", 1, paramEIPCResult, new Object[0]);
      }
      return;
      label172:
      if (i == 0) {
        i = 2;
      } else {
        i = -1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.nativePlugins.GameBuddyPlugin.1
 * JD-Core Version:    0.7.0.1
 */