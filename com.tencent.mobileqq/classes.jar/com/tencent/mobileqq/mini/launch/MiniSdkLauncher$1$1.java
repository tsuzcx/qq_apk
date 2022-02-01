package com.tencent.mobileqq.mini.launch;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class MiniSdkLauncher$1$1
  implements MiniAppCmdInterface
{
  MiniSdkLauncher$1$1(MiniSdkLauncher.1 param1) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("preLaunchMiniAppCheckinFromLeba onCmdListener");
      ((StringBuilder)localObject).append(MiniSdkLauncher.access$000());
      QLog.d("MiniSdkLauncher", 1, ((StringBuilder)localObject).toString());
      if (paramBoolean)
      {
        long l = paramJSONObject.optLong("retCode");
        localObject = paramJSONObject.optString("errMsg");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("preLaunchMiniAppCheckinFromLeba, retCode = ");
        localStringBuilder.append(l);
        localStringBuilder.append(",errMsg = ");
        localStringBuilder.append((String)localObject);
        QLog.i("MiniSdkLauncher", 1, localStringBuilder.toString());
        paramJSONObject = (MiniAppInfo)paramJSONObject.opt("mini_app_info_data");
        if (paramJSONObject != null)
        {
          MiniSdkLauncher.access$002(true);
          paramJSONObject = new MiniAppConfig(paramJSONObject);
          AppBrandLaunchManager.g().preLaunchMiniApp(BaseApplicationImpl.getContext(), paramJSONObject);
          return;
        }
      }
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
      QLog.i("MiniSdkLauncher", 1, "preLaunchMiniAppCheckinFromLeba", paramJSONObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.launch.MiniSdkLauncher.1.1
 * JD-Core Version:    0.7.0.1
 */