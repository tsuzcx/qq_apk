package com.tencent.qqmini.sdk.ui;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import org.json.JSONObject;

class MiniAppInfoLoadingFragment$1
  implements AsyncResult
{
  MiniAppInfoLoadingFragment$1(MiniAppInfoLoadingFragment paramMiniAppInfoLoadingFragment, LaunchParam paramLaunchParam, String paramString) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    long l;
    Object localObject;
    if (paramBoolean)
    {
      l = paramJSONObject.optLong("retCode");
      localObject = paramJSONObject.optString("errMsg");
      QMLog.i("MiniAppInfoLoadingFragment", "getAppInfoById, retCode = " + l + ",errMsg = " + (String)localObject);
      paramJSONObject = (MiniAppInfo)paramJSONObject.opt("mini_app_info_data");
      if (paramJSONObject != null)
      {
        if (this.val$param != null)
        {
          paramJSONObject.launchParam.miniAppId = paramJSONObject.appId;
          if (!TextUtils.isEmpty(this.val$param.extendData)) {
            paramJSONObject.extendData = this.val$param.extendData;
          }
          paramJSONObject.launchParam.scene = this.val$param.scene;
        }
        if (paramJSONObject.verType != 3) {
          paramJSONObject.forceReroad = 3;
        }
        if (this.val$customInfo != null) {
          paramJSONObject.customInfo = this.val$customInfo;
        }
        MiniAppInfoLoadingFragment.access$000(this.this$0, paramJSONObject);
        if (MiniAppInfoLoadingFragment.access$100(this.this$0) != null)
        {
          Bundle localBundle = new Bundle();
          localBundle.putLong("retCode", l);
          localBundle.putString("errMsg", (String)localObject);
          MiniAppInfoLoadingFragment.access$100(this.this$0).send(0, localBundle);
        }
        MiniReportManager.reportEventType(paramJSONObject, 1028, "main_loading", MiniReportManager.getAppType(paramJSONObject));
      }
    }
    for (;;)
    {
      MiniAppInfoLoadingFragment.access$300(this.this$0);
      return;
      ThreadManager.getUIHandler().post(new MiniAppInfoLoadingFragment.1.1(this, (String)localObject, l));
      if (MiniAppInfoLoadingFragment.access$100(this.this$0) != null)
      {
        paramJSONObject = new Bundle();
        paramJSONObject.putLong("retCode", l);
        paramJSONObject.putString("errMsg", (String)localObject);
        MiniAppInfoLoadingFragment.access$100(this.this$0).send(1, paramJSONObject);
        continue;
        ThreadManager.getUIHandler().post(new MiniAppInfoLoadingFragment.1.2(this, paramJSONObject));
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
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.MiniAppInfoLoadingFragment.1
 * JD-Core Version:    0.7.0.1
 */