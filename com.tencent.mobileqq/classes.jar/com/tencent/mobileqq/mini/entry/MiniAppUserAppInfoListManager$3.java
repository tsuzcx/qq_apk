package com.tencent.mobileqq.mini.entry;

import NS_COMM.COMM.StCommonExt;
import anni;
import aqpv;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class MiniAppUserAppInfoListManager$3
  implements MiniAppCmdInterface
{
  MiniAppUserAppInfoListManager$3(MiniAppUserAppInfoListManager paramMiniAppUserAppInfoListManager, MiniAppInfo paramMiniAppInfo) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      paramJSONObject = (COMM.StCommonExt)paramJSONObject.opt("ext");
      if (paramJSONObject != null) {
        MiniAppUserAppInfoListManager.access$102(this.this$0, paramJSONObject);
      }
      MiniAppUserAppInfoListManager.access$200(this.this$0, this.val$miniAppInfo);
      MiniAppUtils.updateMiniAppList(4);
      if (this.val$miniAppInfo.recommend == 1) {
        MiniAppUserAppInfoListManager.access$300(this.this$0, this.val$miniAppInfo);
      }
      if (aqpv.c())
      {
        paramJSONObject = MiniAppUtils.getAppInterface();
        if (paramJSONObject != null) {
          ((DesktopDataManager)paramJSONObject.getManager(336)).removeRedDotData(this.val$miniAppInfo.appId);
        }
      }
      for (;;)
      {
        QLog.e("MiniAppUserAppInfoListManager", 2, "sendDelUserAppRequest, success. delete appInfo: " + this.val$miniAppInfo);
        return;
        this.this$0.removeRedDotData(this.val$miniAppInfo.appId);
      }
    }
    QLog.e("MiniAppUserAppInfoListManager", 1, "sendDelUserAppRequest, failed to delete miniapp!");
    QQToast.a(BaseApplicationImpl.getApplication(), anni.a(2131705618), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppUserAppInfoListManager.3
 * JD-Core Version:    0.7.0.1
 */