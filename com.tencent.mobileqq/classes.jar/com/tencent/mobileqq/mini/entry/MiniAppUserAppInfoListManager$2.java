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
      localObject = paramJSONObject.optString("errMsg");
      if (l != 0L)
      {
        this.this$0.queryMiniAppInfoFromDb();
        MiniAppUtils.updateMiniAppList(10);
        MiniAppUtils.resetUserAppListRequestRefreshTime();
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("sendUserAppListRequest, retCode = ");
        paramJSONObject.append(l);
        paramJSONObject.append(", errMsg = ");
        paramJSONObject.append((String)localObject);
        QLog.e("MiniAppUserAppInfoListManager", 1, paramJSONObject.toString());
        return;
      }
      paramJSONObject = (INTERFACE.StGetUserAppListRsp)paramJSONObject.opt("response");
      MiniAppUserAppInfoListManager.access$000(this.this$0, paramJSONObject);
      localObject = MiniAppUtils.getAppInterface();
      if (localObject != null) {
        MiniAppUtils.handlePreloadAppData(((AppInterface)localObject).getApp(), paramJSONObject);
      } else {
        QLog.e("MiniAppUserAppInfoListManager", 1, "sendUserAppListRequest, app is null.");
      }
      MiniAppUtils.updateMiniAppList(1);
      return;
    }
    if ((paramJSONObject != null) && (paramJSONObject.optLong("retCode") != 1000L)) {
      MiniAppUtils.resetUserAppListRequestRefreshTime();
    }
    this.this$0.queryMiniAppInfoFromDb();
    MiniAppUtils.updateMiniAppList(2);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("sendUserAppListRequest, isSuccess = ");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(", ret = ");
    ((StringBuilder)localObject).append(paramJSONObject);
    QLog.e("MiniAppUserAppInfoListManager", 1, ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppUserAppInfoListManager.2
 * JD-Core Version:    0.7.0.1
 */