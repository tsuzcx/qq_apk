package com.tencent.mobileqq.mini.appbrand.ui;

import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import org.json.JSONObject;

class PreloadingFragment$7
  implements MiniAppCmdInterface
{
  PreloadingFragment$7(PreloadingFragment paramPreloadingFragment, LaunchParam paramLaunchParam) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    Object localObject1;
    if ((paramBoolean) && (paramJSONObject != null))
    {
      long l = paramJSONObject.optLong("retCode");
      localObject1 = paramJSONObject.optString("errMsg");
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getAppInfoByLink, retCode = ");
      ((StringBuilder)localObject2).append(l);
      ((StringBuilder)localObject2).append(",errMsg = ");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("PreloadingFragment", 2, ((StringBuilder)localObject2).toString());
      if (l != 0L)
      {
        paramJSONObject = (JSONObject)localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          paramJSONObject = this.this$0.getString(2131718218);
        }
        if (PreloadingFragment.access$300(this.this$0) != null)
        {
          localObject1 = new Bundle();
          ((Bundle)localObject1).putLong("retCode", l);
          ((Bundle)localObject1).putString("errMsg", paramJSONObject);
          PreloadingFragment.access$300(this.this$0).send(1, (Bundle)localObject1);
        }
        PreloadingFragment.access$500(this.this$0, paramJSONObject);
        PreloadingFragment.access$400(this.this$0);
        return;
      }
      localObject2 = (MiniAppInfo)paramJSONObject.opt("appInfo");
      Object localObject3 = paramJSONObject.optString("shareTicket", "");
      if ((l == 0L) && (localObject2 != null) && (!TextUtils.isEmpty(((MiniAppInfo)localObject2).appId)))
      {
        paramJSONObject = new MiniAppConfig((MiniAppInfo)localObject2);
        Object localObject4 = this.val$param;
        if (localObject4 == null) {
          paramJSONObject.launchParam = new LaunchParam();
        } else {
          paramJSONObject.launchParam = ((LaunchParam)localObject4);
        }
        paramJSONObject.launchParam.miniAppId = ((MiniAppInfo)localObject2).appId;
        paramJSONObject.launchParam.shareTicket = ((String)localObject3);
        paramJSONObject.launchParam.navigateExtData = ((MiniAppInfo)localObject2).extraData;
        if (!TextUtils.isEmpty(paramJSONObject.launchParam.shareTicket)) {
          paramJSONObject.launchParam.scene = 1044;
        }
        if (TextUtils.isEmpty(paramJSONObject.launchParam.reportData))
        {
          paramJSONObject.launchParam.reportData = ((MiniAppInfo)localObject2).reportData;
        }
        else if (!TextUtils.isEmpty(((MiniAppInfo)localObject2).reportData))
        {
          localObject3 = paramJSONObject.launchParam;
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append(paramJSONObject.launchParam.reportData);
          ((StringBuilder)localObject4).append("&");
          ((StringBuilder)localObject4).append(((MiniAppInfo)localObject2).reportData);
          ((LaunchParam)localObject3).reportData = ((StringBuilder)localObject4).toString();
        }
        if ((((MiniAppInfo)localObject2).verType != 3) && (((MiniAppInfo)localObject2).verType != 1)) {
          paramJSONObject.forceReroad = 3;
        }
        if ((((MiniAppInfo)localObject2).clearAuths == 1) && (CommonDataAdapter.a().a() > 0L)) {
          paramJSONObject.config.clearAuths = 0;
        }
        try
        {
          PreloadingFragment.access$200(this.this$0, paramJSONObject);
          if (PreloadingFragment.access$300(this.this$0) != null)
          {
            localObject2 = new Bundle();
            ((Bundle)localObject2).putLong("retCode", l);
            ((Bundle)localObject2).putString("errMsg", (String)localObject1);
            PreloadingFragment.access$300(this.this$0).send(0, (Bundle)localObject2);
          }
          MiniReportManager.reportEventType(paramJSONObject, 1028, "main_loading", MiniReportManager.getAppType(paramJSONObject));
        }
        catch (Throwable paramJSONObject)
        {
          QLog.e("PreloadingFragment", 1, "MiniAppController.startApp exception ", paramJSONObject);
        }
      }
      else
      {
        if (localObject2 == null)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("getAppInfoByLink  onCmdListener appinfo==null retCode= ");
          ((StringBuilder)localObject2).append(l);
          QLog.e("PreloadingFragment", 1, ((StringBuilder)localObject2).toString());
        }
        else
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("getAppInfoByLink  onCmdListener retCode= ");
          ((StringBuilder)localObject3).append(l);
          ((StringBuilder)localObject3).append(" appid=");
          ((StringBuilder)localObject3).append(((MiniAppInfo)localObject2).appId);
          QLog.e("PreloadingFragment", 1, ((StringBuilder)localObject3).toString());
        }
        ThreadManager.getUIHandler().post(new PreloadingFragment.7.1(this, paramJSONObject));
        if (PreloadingFragment.access$300(this.this$0) != null)
        {
          paramJSONObject = new Bundle();
          paramJSONObject.putLong("retCode", l);
          paramJSONObject.putString("errMsg", (String)localObject1);
          PreloadingFragment.access$300(this.this$0).send(1, paramJSONObject);
        }
      }
    }
    else
    {
      ThreadManager.getUIHandler().post(new PreloadingFragment.7.2(this, paramJSONObject));
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
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("GetAppInfoByLink failed. isSuc=");
      paramJSONObject.append(paramBoolean);
      QLog.e("PreloadingFragment", 1, paramJSONObject.toString());
    }
    PreloadingFragment.access$400(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.PreloadingFragment.7
 * JD-Core Version:    0.7.0.1
 */