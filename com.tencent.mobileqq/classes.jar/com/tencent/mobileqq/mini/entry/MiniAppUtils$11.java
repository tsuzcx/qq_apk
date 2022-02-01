package com.tencent.mobileqq.mini.entry;

import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.sdk.LaunchParam;

final class MiniAppUtils$11
  implements Runnable
{
  MiniAppUtils$11(MiniAppConfig paramMiniAppConfig) {}
  
  public void run()
  {
    boolean bool;
    int i;
    String str1;
    if ((this.val$appConfig != null) && (this.val$appConfig.config != null))
    {
      bool = MiniAppUtils.isFromPullDownEntry(this.val$appConfig);
      if (!bool) {
        break label124;
      }
      i = 1;
      if (this.val$appConfig.launchParam == null) {
        break label129;
      }
      str1 = String.valueOf(this.val$appConfig.launchParam.scene);
      label55:
      if (this.val$appConfig.config.via == null) {
        break label135;
      }
    }
    label129:
    label135:
    for (String str2 = this.val$appConfig.config.via;; str2 = "")
    {
      MiniAppCmdUtil.getInstance().useUserApp(this.val$appConfig.config.appId, this.val$appConfig.config.verType, i, str1, str2, null, new MiniAppUtils.11.1(this, str1, str2, bool));
      return;
      label124:
      i = 0;
      break;
      str1 = "";
      break label55;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppUtils.11
 * JD-Core Version:    0.7.0.1
 */