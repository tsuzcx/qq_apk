package com.tencent.mobileqq.mini.entry;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.applets.AppletsHandler;
import com.tencent.mobileqq.config.business.MiniAppConfProcessor;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.util.StorageUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import org.json.JSONObject;

class MiniAppUtils$9$1
  implements MiniAppCmdInterface
{
  MiniAppUtils$9$1(MiniAppUtils.9 param9, String paramString1, String paramString2, boolean paramBoolean) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("doStartMiniApp, useUserApp request is ");
      ((StringBuilder)localObject1).append(paramBoolean);
      QLog.w("MiniAppUtils", 1, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if (paramBoolean)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("retain_confirm_");
      ((StringBuilder)localObject2).append(this.this$0.val$appConfig.config.appId);
      ((StringBuilder)localObject2).append("_");
      ((StringBuilder)localObject2).append(((AppRuntime)localObject1).getAccount());
      ((StringBuilder)localObject2).append("_");
      ((StringBuilder)localObject2).append(this.val$refer);
      ((StringBuilder)localObject2).append("_");
      ((StringBuilder)localObject2).append(this.val$via);
      localObject2 = ((StringBuilder)localObject2).toString();
      StorageUtil.getPreference().edit().putString((String)localObject2, paramJSONObject.toString()).apply();
    }
    if (!this.val$isFromPullDownEntry) {
      return;
    }
    if ((localObject1 instanceof QQAppInterface))
    {
      paramBoolean = MiniAppConfProcessor.h();
      if (QLog.isColorLevel())
      {
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("updatePullDownEntryListData, check needClearPublicAccountRedDot: ");
        paramJSONObject.append(paramBoolean);
        QLog.d("MiniAppUtils", 2, paramJSONObject.toString());
      }
      if (paramBoolean)
      {
        paramJSONObject = (AppletsHandler)((QQAppInterface)localObject1).getBusinessHandler(BusinessHandlerFactory.APPLET_PUSH_HANDLER);
        if (paramJSONObject != null) {
          paramJSONObject.a(this.this$0.val$appConfig.config.appId);
        }
      }
      if (MiniAppConfProcessor.e())
      {
        paramJSONObject = (DesktopDataManager)((AppRuntime)localObject1).getManager(QQManagerFactory.MINI_APP_DESKTOP_MANAGER);
        if (paramJSONObject != null) {
          paramJSONObject.removeRedDotData(this.this$0.val$appConfig.config.appId);
        }
      }
      else
      {
        paramJSONObject = (MiniAppUserAppInfoListManager)((AppRuntime)localObject1).getManager(QQManagerFactory.MINI_APP_ITEM_MANAGER);
        if (paramJSONObject != null) {
          paramJSONObject.removeRedDotData(this.this$0.val$appConfig.config.appId);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppUtils.9.1
 * JD-Core Version:    0.7.0.1
 */