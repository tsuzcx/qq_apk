package com.tencent.mobileqq.mini.cache;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.proxyimpl.MiniSdkUtil;
import com.tencent.qqmini.sdk.MiniSDK;
import org.json.JSONObject;

final class MiniCacheFreeManager$5
  implements MiniAppCmdInterface
{
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      long l = paramJSONObject.optLong("retCode");
      String str = paramJSONObject.optString("errMsg");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getAppInfoById, retCode = ");
      localStringBuilder.append(l);
      localStringBuilder.append(",errMsg = ");
      localStringBuilder.append(str);
      QLog.i("MiniCacheFreeManager", 1, localStringBuilder.toString());
      paramJSONObject = (MiniAppInfo)paramJSONObject.opt("mini_app_info_data");
      if (paramJSONObject != null) {
        MiniSDK.stopMiniApp(BaseApplicationImpl.getContext(), MiniSdkUtil.a(paramJSONObject));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.cache.MiniCacheFreeManager.5
 * JD-Core Version:    0.7.0.1
 */