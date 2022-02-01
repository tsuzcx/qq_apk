package com.tencent.mobileqq.mini.entry;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import aoql;
import aqpv;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.util.StorageUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import org.json.JSONObject;

class MiniAppUtils$11$1
  implements MiniAppCmdInterface
{
  MiniAppUtils$11$1(MiniAppUtils.11 param11, String paramString1, String paramString2, boolean paramBoolean) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.w("MiniAppUtils", 1, "doStartMiniApp, useUserApp request is " + paramBoolean);
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (paramBoolean)
    {
      String str = "retain_confirm_" + this.this$0.val$appConfig.config.appId + "_" + localAppRuntime.getAccount() + "_" + this.val$refer + "_" + this.val$via;
      StorageUtil.getPreference().edit().putString(str, paramJSONObject.toString()).apply();
    }
    if (!this.val$isFromPullDownEntry) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (!(localAppRuntime instanceof QQAppInterface));
        paramBoolean = aqpv.e();
        if (QLog.isColorLevel()) {
          QLog.d("MiniAppUtils", 2, "updatePullDownEntryListData, check needClearPublicAccountRedDot: " + paramBoolean);
        }
        if (paramBoolean)
        {
          paramJSONObject = (aoql)((QQAppInterface)localAppRuntime).a(148);
          if (paramJSONObject != null) {
            paramJSONObject.a(this.this$0.val$appConfig.config.appId);
          }
        }
        if (!aqpv.c()) {
          break;
        }
        paramJSONObject = (DesktopDataManager)localAppRuntime.getManager(336);
      } while (paramJSONObject == null);
      paramJSONObject.removeRedDotData(this.this$0.val$appConfig.config.appId);
      return;
      paramJSONObject = (MiniAppUserAppInfoListManager)localAppRuntime.getManager(309);
    } while (paramJSONObject == null);
    paramJSONObject.removeRedDotData(this.this$0.val$appConfig.config.appId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppUtils.11.1
 * JD-Core Version:    0.7.0.1
 */