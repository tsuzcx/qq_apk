package com.tencent.mobileqq.listentogether;

import android.os.Bundle;
import android.text.TextUtils;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import org.json.JSONException;
import org.json.JSONObject;

class ListenTogetherPlugin$1
  implements EIPCResultCallback
{
  ListenTogetherPlugin$1(ListenTogetherPlugin paramListenTogetherPlugin) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    JSONObject localJSONObject;
    if (!TextUtils.isEmpty(ListenTogetherPlugin.a(this.a))) {
      localJSONObject = new JSONObject();
    }
    for (;;)
    {
      try
      {
        if (!paramEIPCResult.data.getBoolean("result")) {
          break label78;
        }
        i = 0;
        localJSONObject.put("result", i);
        this.a.callJs(ListenTogetherPlugin.a(this.a), new String[] { localJSONObject.toString() });
        return;
      }
      catch (JSONException paramEIPCResult)
      {
        paramEIPCResult.printStackTrace();
      }
      return;
      label78:
      int i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ListenTogetherPlugin.1
 * JD-Core Version:    0.7.0.1
 */