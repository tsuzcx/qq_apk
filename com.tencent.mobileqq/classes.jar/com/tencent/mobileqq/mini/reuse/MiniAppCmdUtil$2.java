package com.tencent.mobileqq.mini.reuse;

import com.tencent.mobileqq.mini.network.http.HttpCmdResult;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class MiniAppCmdUtil$2
  implements HttpCmdResult
{
  MiniAppCmdUtil$2(MiniAppCmdUtil paramMiniAppCmdUtil, MiniAppCmdInterface paramMiniAppCmdInterface) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    MiniAppCmdInterface localMiniAppCmdInterface = this.val$listener;
    if (localMiniAppCmdInterface != null)
    {
      localMiniAppCmdInterface.onCmdListener(paramBoolean, paramJSONObject);
      return;
    }
    QLog.e(MiniAppCmdUtil.TAG, 1, "getLoginCode, listener is null.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil.2
 * JD-Core Version:    0.7.0.1
 */