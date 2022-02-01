package com.tencent.mobileqq.mini.app;

import android.os.Bundle;
import com.tencent.mobileqq.mini.launch.CmdCallback;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import org.json.JSONException;
import org.json.JSONObject;

class MiniAppClientQIPCModule$9
  implements EIPCResultCallback
{
  MiniAppClientQIPCModule$9(MiniAppClientQIPCModule paramMiniAppClientQIPCModule, JSONObject paramJSONObject, CmdCallback paramCmdCallback) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    paramEIPCResult = paramEIPCResult.data.getString("preview");
    try
    {
      this.val$shareJson.optJSONObject("metaData").optJSONObject("detail").put("preview", paramEIPCResult);
      MiniAppClientQIPCModule.access$600(this.this$0, this.val$shareJson.toString(), this.val$cmdCallback);
      return;
    }
    catch (JSONException paramEIPCResult)
    {
      for (;;)
      {
        QLog.e("MiniAppClientQIPCModule", 1, "getReplaceJsonString JSONException,", paramEIPCResult);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.app.MiniAppClientQIPCModule.9
 * JD-Core Version:    0.7.0.1
 */