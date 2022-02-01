package com.tencent.qqmini.sdk.ui;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.auth.AuthState;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.manager.LoginManager;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.qqmini.sdk.utils.DebugUtil;
import org.json.JSONObject;

class MiniAppInfoLoadingFragment$2
  implements AsyncResult
{
  MiniAppInfoLoadingFragment$2(MiniAppInfoLoadingFragment paramMiniAppInfoLoadingFragment, LaunchParam paramLaunchParam, String paramString) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    long l;
    Object localObject;
    if ((paramBoolean) && (paramJSONObject != null))
    {
      l = paramJSONObject.optLong("retCode");
      localObject = paramJSONObject.optString("errMsg");
      QMLog.d("MiniAppInfoLoadingFragment", "getAppInfoByLink, retCode = " + l + ",errMsg = " + (String)localObject);
      if (l != 0L)
      {
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          break label804;
        }
        paramJSONObject = "请求失败";
        if (!DebugUtil.isDebugVersion()) {}
      }
    }
    label398:
    label804:
    for (paramJSONObject = "请求失败" + ", retCode = " + l;; paramJSONObject = (JSONObject)localObject)
    {
      if (MiniAppInfoLoadingFragment.access$100(this.this$0) != null)
      {
        localObject = new Bundle();
        ((Bundle)localObject).putLong("retCode", l);
        ((Bundle)localObject).putString("errMsg", paramJSONObject);
        MiniAppInfoLoadingFragment.access$100(this.this$0).send(1, (Bundle)localObject);
      }
      MiniAppInfoLoadingFragment.access$200(this.this$0, paramJSONObject, l);
      MiniAppInfoLoadingFragment.access$300(this.this$0);
      return;
      MiniAppInfo localMiniAppInfo = (MiniAppInfo)paramJSONObject.opt("appInfo");
      String str = paramJSONObject.optString("shareTicket", "");
      if ((l == 0L) && (localMiniAppInfo != null) && (!TextUtils.isEmpty(localMiniAppInfo.appId)))
      {
        localMiniAppInfo.launchParam.miniAppId = localMiniAppInfo.appId;
        localMiniAppInfo.launchParam.shareTicket = str;
        localMiniAppInfo.launchParam.navigateExtData = localMiniAppInfo.extraData;
        if (this.val$param != null) {
          localMiniAppInfo.launchParam.scene = this.val$param.scene;
        }
        if (!TextUtils.isEmpty(localMiniAppInfo.launchParam.shareTicket)) {
          localMiniAppInfo.launchParam.scene = 1044;
        }
        if (TextUtils.isEmpty(localMiniAppInfo.launchParam.reportData)) {
          localMiniAppInfo.launchParam.reportData = localMiniAppInfo.reportData;
        }
      }
      for (;;)
      {
        if (localMiniAppInfo.verType != 3) {
          localMiniAppInfo.forceReroad = 3;
        }
        MiniAppInfoLoadingFragment.access$400(this.this$0, localMiniAppInfo);
        if (localMiniAppInfo.clearAuths == 1) {
          paramJSONObject = LoginManager.getInstance().getAccount();
        }
        try
        {
          if (Long.valueOf(Long.parseLong(paramJSONObject)).longValue() > 0L)
          {
            MiniAppEnv.g().getAuthSate(localMiniAppInfo.appId).clearAll();
            localMiniAppInfo.clearAuths = 0;
          }
          if (this.val$customInfo != null) {
            localMiniAppInfo.customInfo = this.val$customInfo;
          }
          for (;;)
          {
            try
            {
              MiniAppInfoLoadingFragment.access$000(this.this$0, localMiniAppInfo);
              if (MiniAppInfoLoadingFragment.access$100(this.this$0) != null)
              {
                paramJSONObject = new Bundle();
                paramJSONObject.putLong("retCode", l);
                paramJSONObject.putString("errMsg", (String)localObject);
                MiniAppInfoLoadingFragment.access$100(this.this$0).send(0, paramJSONObject);
              }
              MiniReportManager.reportEventType(localMiniAppInfo, 1028, "main_loading", MiniReportManager.getAppType(localMiniAppInfo));
            }
            catch (Throwable paramJSONObject)
            {
              QMLog.e("MiniAppInfoLoadingFragment", "MiniAppController.startApp exception ", paramJSONObject);
              continue;
            }
            MiniAppInfoLoadingFragment.access$300(this.this$0);
            return;
            if (TextUtils.isEmpty(localMiniAppInfo.reportData)) {
              break;
            }
            localMiniAppInfo.launchParam.reportData = (localMiniAppInfo.launchParam.reportData + "&" + localMiniAppInfo.reportData);
            break;
            if (localMiniAppInfo == null) {
              QMLog.e("MiniAppInfoLoadingFragment", "getAppInfoByLink  onCmdListener appinfo==null retCode= " + l);
            }
            for (;;)
            {
              ThreadManager.getUIHandler().post(new MiniAppInfoLoadingFragment.2.1(this, paramJSONObject));
              if (MiniAppInfoLoadingFragment.access$100(this.this$0) == null) {
                break;
              }
              paramJSONObject = new Bundle();
              paramJSONObject.putLong("retCode", l);
              paramJSONObject.putString("errMsg", (String)localObject);
              MiniAppInfoLoadingFragment.access$100(this.this$0).send(1, paramJSONObject);
              break;
              QMLog.e("MiniAppInfoLoadingFragment", "getAppInfoByLink  onCmdListener retCode= " + l + " appid=" + localMiniAppInfo.appId);
            }
            ThreadManager.getUIHandler().post(new MiniAppInfoLoadingFragment.2.2(this, paramJSONObject));
            if (MiniAppInfoLoadingFragment.access$100(this.this$0) != null)
            {
              localObject = new Bundle();
              if (paramJSONObject != null)
              {
                ((Bundle)localObject).putLong("retCode", paramJSONObject.optLong("retCode"));
                ((Bundle)localObject).putString("errMsg", paramJSONObject.optString("errMsg"));
              }
              MiniAppInfoLoadingFragment.access$100(this.this$0).send(1, (Bundle)localObject);
            }
            QMLog.e("MiniAppInfoLoadingFragment", "GetAppInfoByLink failed. isSuc=" + paramBoolean);
          }
        }
        catch (Exception paramJSONObject)
        {
          break label398;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.MiniAppInfoLoadingFragment.2
 * JD-Core Version:    0.7.0.1
 */