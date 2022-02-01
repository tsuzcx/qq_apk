package com.tencent.mobileqq.mini.api.impl;

import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import org.json.JSONObject;

class MiniAppServiceImpl$7
  implements MiniAppCmdInterface
{
  MiniAppServiceImpl$7(MiniAppServiceImpl paramMiniAppServiceImpl, int paramInt) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if ((paramBoolean) && (paramJSONObject != null))
    {
      paramJSONObject = (MiniAppInfo)paramJSONObject.opt("appInfo");
      if (paramJSONObject != null)
      {
        MiniAppController.preloadPackage(paramJSONObject);
        paramJSONObject = new MiniAppConfig(paramJSONObject);
        if (paramJSONObject.launchParam != null) {
          paramJSONObject.launchParam.scene = 2064;
        }
        MiniProgramLpReportDC04239.reportAsync(paramJSONObject, "page_view", "expo", null, String.valueOf(this.val$total));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.api.impl.MiniAppServiceImpl.7
 * JD-Core Version:    0.7.0.1
 */