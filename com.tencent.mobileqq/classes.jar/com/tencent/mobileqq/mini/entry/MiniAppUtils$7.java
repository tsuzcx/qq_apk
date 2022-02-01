package com.tencent.mobileqq.mini.entry;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import org.json.JSONObject;

final class MiniAppUtils$7
  implements MiniAppCmdInterface
{
  MiniAppUtils$7(int paramInt) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    long l;
    if (paramBoolean)
    {
      l = paramJSONObject.optLong("retCode");
      localObject = paramJSONObject.optString("errMsg");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getAppInfoById, retCode = ");
      localStringBuilder.append(l);
      localStringBuilder.append(",errMsg = ");
      localStringBuilder.append((String)localObject);
      QLog.i("MiniAppUtils", 1, localStringBuilder.toString());
      paramJSONObject = (MiniAppInfo)paramJSONObject.opt("mini_app_info_data");
      if (paramJSONObject != null)
      {
        paramJSONObject = new MiniAppConfig(paramJSONObject);
        paramJSONObject.launchParam.scene = this.val$scene;
        MiniAppUtils.updatePullDownEntryListData(paramJSONObject);
        ThreadManager.getSubThreadHandler().postDelayed(new MiniAppUtils.7.1(this), 600L);
        return;
      }
      QLog.e("MiniAppUtils", 1, "updatePullDownEntryWeixinApp getAppInfoById appInfo is null");
      return;
    }
    if (paramJSONObject != null) {
      l = paramJSONObject.optLong("retCode");
    } else {
      l = 0L;
    }
    if (paramJSONObject != null) {
      paramJSONObject = paramJSONObject.optString("errMsg");
    } else {
      paramJSONObject = "";
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("updatePullDownEntryWeixinApp getAppInfoById failed retCode:");
    ((StringBuilder)localObject).append(l);
    ((StringBuilder)localObject).append(" errMsg:");
    ((StringBuilder)localObject).append(paramJSONObject);
    QLog.e("MiniAppUtils", 1, ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppUtils.7
 * JD-Core Version:    0.7.0.1
 */