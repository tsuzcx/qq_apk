package com.tencent.mobileqq.mini.out.nativePlugins;

import android.os.Bundle;
import avdc;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin.JSContext;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import org.json.JSONObject;

class GameBuddyPlugin$1
  implements EIPCResultCallback
{
  GameBuddyPlugin$1(GameBuddyPlugin paramGameBuddyPlugin, NativePlugin.JSContext paramJSContext, String paramString1, String paramString2) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    int i = -1;
    JSONObject localJSONObject;
    for (;;)
    {
      int j;
      try
      {
        localJSONObject = new JSONObject();
        if (paramEIPCResult == null)
        {
          localJSONObject.put("code", -1);
          this.val$jsContext.evaluateCallback(false, localJSONObject, "result is null");
          return;
        }
        if (paramEIPCResult.code != 0) {
          break;
        }
        j = paramEIPCResult.data.getInt("uin_type");
        localJSONObject.put("code", 0);
        if (j == 10009)
        {
          i = 1;
          localJSONObject.put("type", i);
          if ("invokeGameBuddyAio".equals(this.val$apiName)) {
            avdc.a(this.val$jsContext.getActivity(), this.val$uin, j);
          }
          this.val$jsContext.evaluateCallback(true, localJSONObject, "");
          return;
        }
      }
      catch (Throwable paramEIPCResult)
      {
        QLog.e("GameBuddyPlugin", 1, paramEIPCResult, new Object[0]);
        return;
      }
      if (j == 0) {
        i = 2;
      }
    }
    localJSONObject.put("code", -2);
    this.val$jsContext.evaluateCallback(false, localJSONObject, "result code:" + paramEIPCResult.code);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.nativePlugins.GameBuddyPlugin.1
 * JD-Core Version:    0.7.0.1
 */