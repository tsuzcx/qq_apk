package com.tencent.mobileqq.mini.entry;

import NS_MINI_INTERFACE.INTERFACE.StGetUserAppListRsp;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class MiniAppUserAppInfoListManager$2
  implements MiniAppCmdInterface
{
  MiniAppUserAppInfoListManager$2(MiniAppUserAppInfoListManager paramMiniAppUserAppInfoListManager) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if ((paramBoolean) && (paramJSONObject != null))
    {
      long l = paramJSONObject.optLong("retCode");
      Object localObject = paramJSONObject.optString("errMsg");
      if (l != 0L)
      {
        this.this$0.queryMiniAppInfoFromDb();
        MiniAppUtils.updateMiniAppList(10);
        MiniAppUtils.resetUserAppListRequestRefreshTime();
        QLog.e("MiniAppUserAppInfoListManager", 1, "sendUserAppListRequest, retCode = " + l + ", errMsg = " + (String)localObject);
        return;
      }
      paramJSONObject = (INTERFACE.StGetUserAppListRsp)paramJSONObject.opt("response");
      MiniAppUserAppInfoListManager.access$000(this.this$0, paramJSONObject);
      localObject = MiniAppUtils.getAppInterface();
      if (localObject != null) {
        MiniAppUtils.handlePreloadAppData(((AppInterface)localObject).getApp(), paramJSONObject);
      }
      for (;;)
      {
        MiniAppUtils.updateMiniAppList(1);
        return;
        QLog.e("MiniAppUserAppInfoListManager", 1, "sendUserAppListRequest, app is null.");
      }
    }
    if ((paramJSONObject != null) && (paramJSONObject.optLong("retCode") != 1000L)) {
      MiniAppUtils.resetUserAppListRequestRefreshTime();
    }
    this.this$0.queryMiniAppInfoFromDb();
    MiniAppUtils.updateMiniAppList(2);
    QLog.e("MiniAppUserAppInfoListManager", 1, "sendUserAppListRequest, isSuccess = " + paramBoolean + ", ret = " + paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppUserAppInfoListManager.2
 * JD-Core Version:    0.7.0.1
 */