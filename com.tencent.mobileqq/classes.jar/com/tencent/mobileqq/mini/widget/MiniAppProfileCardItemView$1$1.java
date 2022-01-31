package com.tencent.mobileqq.mini.widget;

import android.app.Activity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import mqq.os.MqqHandler;
import org.json.JSONObject;

class MiniAppProfileCardItemView$1$1
  implements MiniAppCmdInterface
{
  MiniAppProfileCardItemView$1$1(MiniAppProfileCardItemView.1 param1) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    long l;
    String str;
    if (paramBoolean)
    {
      l = paramJSONObject.optLong("retCode");
      str = paramJSONObject.optString("errMsg");
      paramJSONObject = (MiniAppInfo)paramJSONObject.opt("mini_app_info_data");
      if (paramJSONObject != null)
      {
        paramJSONObject = new MiniAppConfig(paramJSONObject);
        paramJSONObject.launchParam = new LaunchParam();
        paramJSONObject.launchParam.miniAppId = MiniAppProfileCardItemView.access$000(this.this$1.this$0);
        paramJSONObject.launchParam.scene = 2062;
        MiniAppController.startApp((Activity)MiniAppProfileCardItemView.access$100(this.this$1.this$0), paramJSONObject, null);
        MiniAppUtils.reportProfileCardItemClick(paramJSONObject);
      }
    }
    else
    {
      return;
    }
    ThreadManager.getUIHandler().post(new MiniAppProfileCardItemView.1.1.1(this, str, l));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.MiniAppProfileCardItemView.1.1
 * JD-Core Version:    0.7.0.1
 */