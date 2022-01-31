package com.tencent.mobileqq.mini.entry;

import android.util.Log;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;

final class MiniAppUtils$9
  implements Runnable
{
  MiniAppUtils$9(MiniAppConfig paramMiniAppConfig) {}
  
  public void run()
  {
    if (this.val$appConfig != null)
    {
      if (!MiniAppUtils.access$100(this.val$appConfig)) {
        break label81;
      }
      MiniAppUtils.access$200(this.val$appConfig);
    }
    label81:
    while ((this.val$appConfig.config == null) || (this.val$appConfig.config.isAppStoreMiniApp())) {
      try
      {
        i = QzoneConfig.getInstance().getConfig("qqminiapp", "backAutoHide", 0);
        if (i == 1) {
          MiniAppUtils.updateMiniAppList(100);
        }
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("MiniAppUtils", 1, "updatePullDownEntryListData, exception:" + Log.getStackTraceString(localException));
          int i = 0;
        }
      }
    }
    MiniAppUtils.access$300(MiniAppInfo.copy(this.val$appConfig.config));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppUtils.9
 * JD-Core Version:    0.7.0.1
 */