package com.tencent.mobileqq.mini.widget;

import android.app.Activity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wxmini.api.IWxMiniManager;
import mqq.os.MqqHandler;
import org.json.JSONObject;

class MiniAppProfileCardItemView$1$1
  implements MiniAppCmdInterface
{
  MiniAppProfileCardItemView$1$1(MiniAppProfileCardItemView.1 param1) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    long l = paramJSONObject.optLong("retCode");
    Object localObject = paramJSONObject.optString("errMsg");
    if (paramBoolean)
    {
      paramJSONObject = (MiniAppInfo)paramJSONObject.opt("mini_app_info_data");
      if (paramJSONObject != null)
      {
        localObject = new MiniAppConfig(paramJSONObject);
        ((MiniAppConfig)localObject).launchParam = new LaunchParam();
        ((MiniAppConfig)localObject).launchParam.miniAppId = MiniAppProfileCardItemView.access$000(this.this$1.this$0);
        ((MiniAppConfig)localObject).launchParam.scene = 2062;
        if (paramJSONObject.isWxMiniApp()) {
          ((IWxMiniManager)QRoute.api(IWxMiniManager.class)).startWxMiniAppById((Activity)MiniAppProfileCardItemView.access$100(this.this$1.this$0), paramJSONObject.appId, "", 2062);
        } else {
          MiniAppController.startApp((Activity)MiniAppProfileCardItemView.access$100(this.this$1.this$0), (MiniAppConfig)localObject, null);
        }
        MiniAppUtils.reportProfileCardItemClick((MiniAppConfig)localObject);
        return;
      }
    }
    ThreadManager.getUIHandler().post(new MiniAppProfileCardItemView.1.1.1(this, (String)localObject, l));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.MiniAppProfileCardItemView.1.1
 * JD-Core Version:    0.7.0.1
 */