package com.tencent.mobileqq.mini.entry;

import NS_COMM.COMM.StCommonExt;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class MiniAppUserAppInfoListManager$4
  implements MiniAppCmdInterface
{
  MiniAppUserAppInfoListManager$4(MiniAppUserAppInfoListManager paramMiniAppUserAppInfoListManager, MiniAppInfo paramMiniAppInfo) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      paramJSONObject = (COMM.StCommonExt)paramJSONObject.opt("ext");
      if (paramJSONObject != null) {
        MiniAppUserAppInfoListManager.access$402(this.this$0, paramJSONObject);
      }
      this.this$0.updateMiniAppTopStatus(this.val$appInfo);
      QLog.e("MiniAppUserAppInfoListManager", 1, "sendSetUserAppTopRequest, success.");
      return;
    }
    QLog.e("MiniAppUserAppInfoListManager", 1, "sendSetUserAppTopRequest, failed to set top!");
    QQToast.a(BaseApplicationImpl.getApplication(), HardCodeUtil.a(2131706847), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppUserAppInfoListManager.4
 * JD-Core Version:    0.7.0.1
 */