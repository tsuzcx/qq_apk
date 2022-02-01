package com.tencent.mobileqq.mini.reuse;

import android.util.Log;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.launch.MiniSdkLauncher;
import com.tencent.mobileqq.mini.network.http.HttpCmdResult;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class MiniAppCmdUtil$5
  implements HttpCmdResult
{
  MiniAppCmdUtil$5(MiniAppCmdUtil paramMiniAppCmdUtil, MiniAppCmdInterface paramMiniAppCmdInterface) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject.put("mini_app_info_data", MiniSdkLauncher.convert((MiniAppInfo)paramJSONObject.opt("appInfo")));
      paramJSONObject.remove("appInfo");
      this.val$listener.onCmdListener(paramBoolean, paramJSONObject);
      return;
    }
    catch (Exception paramJSONObject)
    {
      String str = MiniAppCmdUtil.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getAppInfoByLinkForSDK, exception: ");
      localStringBuilder.append(Log.getStackTraceString(paramJSONObject));
      QLog.e(str, 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil.5
 * JD-Core Version:    0.7.0.1
 */