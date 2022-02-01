package com.tencent.mobileqq.mini.entry;

import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

final class MiniAppUtils$10
  implements MiniAppCmdInterface
{
  MiniAppUtils$10(MiniAppConfig paramMiniAppConfig) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      long l = paramJSONObject.optLong("retCode");
      String str = paramJSONObject.optString("errMsg");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateMiniAppMemoryCache, getAppInfoById retCode = ");
      localStringBuilder.append(l);
      localStringBuilder.append(",errMsg = ");
      localStringBuilder.append(str);
      QLog.d("MiniAppUtils", 1, localStringBuilder.toString());
      paramJSONObject = (MiniAppInfo)paramJSONObject.opt("mini_app_info_data");
      if (paramJSONObject != null)
      {
        paramJSONObject.mergeData(this.val$appConfig.config);
        MiniAppUtils.access$200(paramJSONObject);
      }
    }
    else
    {
      MiniAppUtils.access$200(this.val$appConfig.config);
      MiniAppUtils.updateMiniAppList(11);
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("updateMiniAppMemoryCache, request fail. appInfo: ");
      paramJSONObject.append(this.val$appConfig.config);
      QLog.e("MiniAppUtils", 1, paramJSONObject.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppUtils.10
 * JD-Core Version:    0.7.0.1
 */