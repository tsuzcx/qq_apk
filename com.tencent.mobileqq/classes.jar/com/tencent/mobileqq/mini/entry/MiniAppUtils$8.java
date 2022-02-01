package com.tencent.mobileqq.mini.entry;

import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import common.config.service.QzoneConfig;

final class MiniAppUtils$8
  implements Runnable
{
  MiniAppUtils$8(MiniAppConfig paramMiniAppConfig) {}
  
  public void run()
  {
    Object localObject = this.val$appConfig;
    if (localObject != null) {
      if (MiniAppUtils.isFromPullDownEntry((MiniAppConfig)localObject))
      {
        MiniAppUtils.access$100(this.val$appConfig);
        if (QzoneConfig.getInstance().getConfig("qqminiapp", "backAutoHide", 0) == 2) {
          MiniAppUtils.updateMiniAppList(100);
        }
      }
      else if ((this.val$appConfig.config != null) && (!this.val$appConfig.config.isAppStoreMiniApp()))
      {
        localObject = MiniAppInfo.copy(this.val$appConfig.config);
        ((MiniAppInfo)localObject).debugInfo = null;
        MiniAppUtils.access$200((MiniAppInfo)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppUtils.8
 * JD-Core Version:    0.7.0.1
 */