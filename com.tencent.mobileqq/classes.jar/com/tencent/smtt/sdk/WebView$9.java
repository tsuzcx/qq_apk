package com.tencent.smtt.sdk;

import com.tencent.smtt.utils.TbsLog;

final class WebView$9
  implements Runnable
{
  public void run()
  {
    if (WebView.access$700() == null) {
      TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--mAppContext == null");
    }
    SDKEngine localSDKEngine;
    int i;
    int j;
    do
    {
      return;
      localSDKEngine = SDKEngine.getInstance(true);
      if (SDKEngine.mTbsNeedReboot)
      {
        TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--needReboot = true");
        return;
      }
      TbsCoreVerManager localTbsCoreVerManager = TbsCoreVerManager.getInstance(WebView.access$700());
      i = localTbsCoreVerManager.getTbsCoreInstallStatus();
      TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--installStatus = " + i);
      if (i == 2)
      {
        TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--install setTbsNeedReboot true");
        localSDKEngine.setCalledCountKey(String.valueOf(localTbsCoreVerManager.getTbsCoreInstallVer()));
        localSDKEngine.setTbsNeedReboot(true);
        return;
      }
      j = localTbsCoreVerManager.getIntStatus("copy_status");
      TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--copyStatus = " + j);
      if (j == 1)
      {
        TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--copy setTbsNeedReboot true");
        localSDKEngine.setCalledCountKey(String.valueOf(localTbsCoreVerManager.getIntNum("copy_core_ver")));
        localSDKEngine.setTbsNeedReboot(true);
        return;
      }
    } while ((X5CoreEngine.getInstance().isX5Core()) || ((i != 3) && (j != 3)));
    TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--setTbsNeedReboot true");
    localSDKEngine.setCalledCountKey(String.valueOf(SDKEngine.getTbsCoreVersion()));
    localSDKEngine.setTbsNeedReboot(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.smtt.sdk.WebView.9
 * JD-Core Version:    0.7.0.1
 */