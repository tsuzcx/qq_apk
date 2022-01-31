package com.tencent.mobileqq.mini.appbrand.ui;

import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import bcxm;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.app.AuthorizeCenter;
import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import mqq.os.MqqHandler;
import org.json.JSONObject;

class PreloadingFragment$6
  implements MiniAppCmdInterface
{
  PreloadingFragment$6(PreloadingFragment paramPreloadingFragment, LaunchParam paramLaunchParam) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    long l1;
    Object localObject1;
    if ((paramBoolean) && (paramJSONObject != null))
    {
      l1 = paramJSONObject.optLong("retCode");
      localObject1 = paramJSONObject.optString("errMsg");
      QLog.d("PreloadingFragment", 2, "getAppInfoByLink, retCode = " + l1 + ",errMsg = " + (String)localObject1);
      if (l1 != 0L) {
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label733;
        }
      }
    }
    label733:
    for (paramJSONObject = this.this$0.getString(2131718737);; paramJSONObject = (JSONObject)localObject1)
    {
      if (PreloadingFragment.access$300(this.this$0) != null)
      {
        localObject1 = new Bundle();
        ((Bundle)localObject1).putLong("retCode", l1);
        ((Bundle)localObject1).putString("errMsg", paramJSONObject);
        PreloadingFragment.access$300(this.this$0).send(1, (Bundle)localObject1);
      }
      PreloadingFragment.access$500(this.this$0, paramJSONObject);
      PreloadingFragment.access$400(this.this$0);
      return;
      Object localObject2 = (MiniAppInfo)paramJSONObject.opt("appInfo");
      String str = paramJSONObject.optString("shareTicket", "");
      if ((l1 == 0L) && (localObject2 != null) && (!TextUtils.isEmpty(((MiniAppInfo)localObject2).appId)))
      {
        paramJSONObject = new MiniAppConfig((MiniAppInfo)localObject2);
        if (this.val$param == null)
        {
          paramJSONObject.launchParam = new LaunchParam();
          paramJSONObject.launchParam.miniAppId = ((MiniAppInfo)localObject2).appId;
          paramJSONObject.launchParam.shareTicket = str;
          paramJSONObject.launchParam.navigateExtData = ((MiniAppInfo)localObject2).extraData;
          if (!TextUtils.isEmpty(paramJSONObject.launchParam.shareTicket)) {
            paramJSONObject.launchParam.scene = 1044;
          }
          if (paramJSONObject.launchParam.reportData == null) {
            paramJSONObject.launchParam.reportData = new HashMap();
          }
          if (((MiniAppInfo)localObject2).reportData != null) {
            paramJSONObject.launchParam.reportData.putAll(((MiniAppInfo)localObject2).reportData);
          }
          if ((((MiniAppInfo)localObject2).verType != 3) && (((MiniAppInfo)localObject2).verType != 1)) {
            paramJSONObject.forceReroad = 3;
          }
          if (((MiniAppInfo)localObject2).clearAuths == 1)
          {
            long l2 = bcxm.a().a();
            if (l2 > 0L)
            {
              AuthorizeCenter.clearAuth(((MiniAppInfo)localObject2).appId, String.valueOf(l2));
              paramJSONObject.config.clearAuths = 0;
            }
          }
        }
      }
      for (;;)
      {
        try
        {
          PreloadingFragment.access$200(this.this$0, paramJSONObject);
          if (PreloadingFragment.access$300(this.this$0) != null)
          {
            localObject2 = new Bundle();
            ((Bundle)localObject2).putLong("retCode", l1);
            ((Bundle)localObject2).putString("errMsg", (String)localObject1);
            PreloadingFragment.access$300(this.this$0).send(0, (Bundle)localObject2);
          }
          MiniReportManager.reportEventType(paramJSONObject, 1028, "main_loading", MiniReportManager.getAppType(paramJSONObject));
        }
        catch (Throwable paramJSONObject)
        {
          QLog.e("PreloadingFragment", 1, "MiniAppController.startApp exception ", paramJSONObject);
          continue;
        }
        PreloadingFragment.access$400(this.this$0);
        return;
        paramJSONObject.launchParam = this.val$param;
        break;
        if (localObject2 == null) {
          QLog.e("PreloadingFragment", 1, "getAppInfoByLink  onCmdListener appinfo==null retCode= " + l1);
        }
        for (;;)
        {
          ThreadManager.getUIHandler().post(new PreloadingFragment.6.1(this, paramJSONObject));
          if (PreloadingFragment.access$300(this.this$0) == null) {
            break;
          }
          paramJSONObject = new Bundle();
          paramJSONObject.putLong("retCode", l1);
          paramJSONObject.putString("errMsg", (String)localObject1);
          PreloadingFragment.access$300(this.this$0).send(1, paramJSONObject);
          break;
          QLog.e("PreloadingFragment", 1, "getAppInfoByLink  onCmdListener retCode= " + l1 + " appid=" + ((MiniAppInfo)localObject2).appId);
        }
        ThreadManager.getUIHandler().post(new PreloadingFragment.6.2(this, paramJSONObject));
        if (PreloadingFragment.access$300(this.this$0) != null)
        {
          localObject1 = new Bundle();
          if (paramJSONObject != null)
          {
            ((Bundle)localObject1).putLong("retCode", paramJSONObject.optLong("retCode"));
            ((Bundle)localObject1).putString("errMsg", paramJSONObject.optString("errMsg"));
          }
          PreloadingFragment.access$300(this.this$0).send(1, (Bundle)localObject1);
        }
        QLog.e("PreloadingFragment", 1, "GetAppInfoByLink failed. isSuc=" + paramBoolean);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.PreloadingFragment.6
 * JD-Core Version:    0.7.0.1
 */