package com.tencent.mobileqq.mini.reuse;

import com.tencent.mobileqq.mini.network.http.HttpCmdResult;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class MiniAppCmdUtil$3
  implements HttpCmdResult
{
  MiniAppCmdUtil$3(MiniAppCmdUtil paramMiniAppCmdUtil, MiniAppCmdInterface paramMiniAppCmdInterface) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    MiniAppCmdInterface localMiniAppCmdInterface = this.val$listener;
    if (localMiniAppCmdInterface != null)
    {
      localMiniAppCmdInterface.onCmdListener(paramBoolean, paramJSONObject);
      return;
    }
    QLog.e(MiniAppCmdUtil.TAG, 1, "getAppInfoByLink, listener is null.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil.3
 * JD-Core Version:    0.7.0.1
 */