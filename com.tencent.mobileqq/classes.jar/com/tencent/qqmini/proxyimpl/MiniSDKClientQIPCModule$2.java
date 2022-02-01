package com.tencent.qqmini.proxyimpl;

import android.os.Bundle;
import com.tencent.mobileqq.mini.launch.CmdCallback;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import org.json.JSONException;
import org.json.JSONObject;

class MiniSDKClientQIPCModule$2
  implements EIPCResultCallback
{
  MiniSDKClientQIPCModule$2(MiniSDKClientQIPCModule paramMiniSDKClientQIPCModule, JSONObject paramJSONObject, CmdCallback paramCmdCallback) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    paramEIPCResult = paramEIPCResult.data.getString("preview");
    try
    {
      this.a.optJSONObject("metaData").optJSONObject("detail").put("preview", paramEIPCResult);
    }
    catch (JSONException paramEIPCResult)
    {
      QLog.e("MiniSDKClientQIPCModule", 1, "getReplaceJsonString JSONException,", paramEIPCResult);
    }
    MiniSDKClientQIPCModule.a(this.c, this.a.toString(), this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MiniSDKClientQIPCModule.2
 * JD-Core Version:    0.7.0.1
 */