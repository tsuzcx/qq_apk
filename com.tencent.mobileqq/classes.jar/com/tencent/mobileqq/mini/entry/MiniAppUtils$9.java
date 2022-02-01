package com.tencent.mobileqq.mini.entry;

import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

final class MiniAppUtils$9
  implements MiniAppCmdInterface
{
  MiniAppUtils$9(MiniAppConfig paramMiniAppConfig) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      long l = paramJSONObject.optLong("retCode");
      String str = paramJSONObject.optString("errMsg");
      QLog.d("MiniAppUtils", 1, "updateMiniAppMemoryCache, getAppInfoById retCode = " + l + ",errMsg = " + str);
      paramJSONObject = (MiniAppInfo)paramJSONObject.opt("mini_app_info_data");
      if (paramJSONObject != null)
      {
        paramJSONObject.mergeData(this.val$appConfig.config);
        MiniAppUtils.access$200(paramJSONObject);
      }
      return;
    }
    MiniAppUtils.access$200(this.val$appConfig.config);
    MiniAppUtils.updateMiniAppList(11);
    QLog.e("MiniAppUtils", 1, "updateMiniAppMemoryCache, request fail. appInfo: " + this.val$appConfig.config);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppUtils.9
 * JD-Core Version:    0.7.0.1
 */