package com.tencent.mobileqq.mini.entry;

import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import common.config.service.QzoneConfig;

final class MiniAppUtils$10
  implements Runnable
{
  MiniAppUtils$10(MiniAppConfig paramMiniAppConfig) {}
  
  public void run()
  {
    if (this.val$appConfig != null)
    {
      if (!MiniAppUtils.isFromPullDownEntry(this.val$appConfig)) {
        break label45;
      }
      MiniAppUtils.access$200(this.val$appConfig);
      if (QzoneConfig.getInstance().getConfig("qqminiapp", "backAutoHide", 0) == 2) {
        MiniAppUtils.updateMiniAppList(100);
      }
    }
    label45:
    while ((this.val$appConfig.config == null) || (this.val$appConfig.config.isAppStoreMiniApp())) {
      return;
    }
    MiniAppInfo localMiniAppInfo = MiniAppInfo.copy(this.val$appConfig.config);
    localMiniAppInfo.debugInfo = null;
    MiniAppUtils.access$300(localMiniAppInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppUtils.10
 * JD-Core Version:    0.7.0.1
 */