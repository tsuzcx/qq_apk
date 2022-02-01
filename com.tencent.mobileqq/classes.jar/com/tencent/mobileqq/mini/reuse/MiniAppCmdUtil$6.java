package com.tencent.mobileqq.mini.reuse;

import android.util.Log;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.launch.MiniSdkLauncher;
import com.tencent.mobileqq.mini.network.http.HttpCmdResult;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class MiniAppCmdUtil$6
  implements HttpCmdResult
{
  MiniAppCmdUtil$6(MiniAppCmdUtil paramMiniAppCmdUtil, MiniAppCmdInterface paramMiniAppCmdInterface) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject.put("mini_app_info_data", MiniSdkLauncher.convert((MiniAppInfo)paramJSONObject.opt("mini_app_info_data")));
      this.val$listener.onCmdListener(paramBoolean, paramJSONObject);
      return;
    }
    catch (Exception paramJSONObject)
    {
      String str = MiniAppCmdUtil.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getAppInfoByIdForSDK exception: ");
      localStringBuilder.append(Log.getStackTraceString(paramJSONObject));
      QLog.e(str, 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil.6
 * JD-Core Version:    0.7.0.1
 */