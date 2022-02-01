package com.tencent.mobileqq.mini.appbrand.ui;

import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class PreloadingFragment$4
  implements MiniAppCmdInterface
{
  PreloadingFragment$4(PreloadingFragment paramPreloadingFragment) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if ((paramBoolean) && (paramJSONObject != null))
    {
      long l = paramJSONObject.optLong("retCode");
      String str = paramJSONObject.optString("errMsg");
      paramJSONObject = (MiniAppInfo)paramJSONObject.opt("mini_app_info_data");
      if ((l != 0L) || (paramJSONObject != null))
      {
        if (paramJSONObject == null)
        {
          paramJSONObject = new StringBuilder();
          paramJSONObject.append("getAppInfoById  onCmdListener appinfo==null retCode= ");
          paramJSONObject.append(l);
          paramJSONObject.append("; errMsg : ");
          paramJSONObject.append(str);
          QLog.e("miniapp-db", 1, paramJSONObject.toString());
          return;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getAppInfoById  onCmdListener retCode= ");
        localStringBuilder.append(l);
        localStringBuilder.append(" appid=");
        localStringBuilder.append(paramJSONObject.appId);
        localStringBuilder.append("; errMsg : ");
        localStringBuilder.append(str);
        QLog.e("miniapp-db", 1, localStringBuilder.toString());
      }
    }
    else
    {
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("launchMiniAppById cmd fail.");
      paramJSONObject.append(paramBoolean);
      QLog.e("miniapp-db", 1, paramJSONObject.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.PreloadingFragment.4
 * JD-Core Version:    0.7.0.1
 */