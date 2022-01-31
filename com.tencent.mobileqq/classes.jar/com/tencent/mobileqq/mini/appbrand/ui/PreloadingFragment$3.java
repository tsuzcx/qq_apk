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
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import org.json.JSONObject;

class PreloadingFragment$3
  implements MiniAppCmdInterface
{
  PreloadingFragment$3(PreloadingFragment paramPreloadingFragment, LaunchParam paramLaunchParam) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    long l;
    Object localObject1;
    if (paramBoolean)
    {
      l = paramJSONObject.optLong("retCode");
      localObject1 = paramJSONObject.optString("errMsg");
      QLog.i("PreloadingFragment", 1, "getAppInfoById, retCode = " + l + ",errMsg = " + (String)localObject1);
      Object localObject2 = (MiniAppInfo)paramJSONObject.opt("mini_app_info_data");
      if (localObject2 != null)
      {
        paramJSONObject = new MiniAppConfig((MiniAppInfo)localObject2);
        if (this.val$param != null)
        {
          paramJSONObject.launchParam = this.val$param;
          paramJSONObject.launchParam.miniAppId = ((MiniAppInfo)localObject2).appId;
          if (!TextUtils.isEmpty(this.val$param.extendData)) {
            paramJSONObject.config.extendData = this.val$param.extendData;
          }
        }
        if ((((MiniAppInfo)localObject2).verType != 3) && (((MiniAppInfo)localObject2).verType != 1)) {
          paramJSONObject.forceReroad = 3;
        }
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
    }
    for (;;)
    {
      PreloadingFragment.access$400(this.this$0);
      return;
      ThreadManager.getUIHandler().post(new PreloadingFragment.3.1(this, (String)localObject1, l));
      if (PreloadingFragment.access$300(this.this$0) != null)
      {
        paramJSONObject = new Bundle();
        paramJSONObject.putLong("retCode", l);
        paramJSONObject.putString("errMsg", (String)localObject1);
        PreloadingFragment.access$300(this.this$0).send(1, paramJSONObject);
        continue;
        ThreadManager.getUIHandler().post(new PreloadingFragment.3.2(this, paramJSONObject));
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
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.PreloadingFragment.3
 * JD-Core Version:    0.7.0.1
 */