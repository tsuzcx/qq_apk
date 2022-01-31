package com.tencent.mobileqq.mini.entry;

import amnf;
import aokd;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import org.json.JSONObject;

class MiniAppUtils$10$1
  implements MiniAppCmdInterface
{
  MiniAppUtils$10$1(MiniAppUtils.10 param10, boolean paramBoolean) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.w("MiniAppUtils", 1, "doStartMiniApp, useUserApp request is " + paramBoolean);
    }
    if (!this.val$isFromPullDownEntry) {}
    do
    {
      do
      {
        do
        {
          return;
          paramJSONObject = BaseApplicationImpl.getApplication().getRuntime();
        } while (!(paramJSONObject instanceof QQAppInterface));
        paramBoolean = aokd.i();
        if (QLog.isColorLevel()) {
          QLog.d("MiniAppUtils", 2, "updatePullDownEntryListData, check needClearPublicAccountRedDot: " + paramBoolean);
        }
        if (paramBoolean)
        {
          amnf localamnf = (amnf)((QQAppInterface)paramJSONObject).a(148);
          if (localamnf != null) {
            localamnf.a(this.this$0.val$appConfig.config.appId);
          }
        }
        if (!aokd.g()) {
          break;
        }
        paramJSONObject = (DesktopDataManager)paramJSONObject.getManager(336);
      } while (paramJSONObject == null);
      paramJSONObject.removeRedDotData(this.this$0.val$appConfig.config.appId);
      return;
      paramJSONObject = (MiniAppUserAppInfoListManager)paramJSONObject.getManager(309);
    } while (paramJSONObject == null);
    paramJSONObject.removeRedDotData(this.this$0.val$appConfig.config.appId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppUtils.10.1
 * JD-Core Version:    0.7.0.1
 */