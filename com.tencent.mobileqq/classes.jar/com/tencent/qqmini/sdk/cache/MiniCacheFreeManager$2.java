package com.tencent.qqmini.sdk.cache;

import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

final class MiniCacheFreeManager$2
  implements Runnable
{
  MiniCacheFreeManager$2(MiniAppInfo paramMiniAppInfo, String paramString, boolean paramBoolean, Runnable paramRunnable) {}
  
  public void run()
  {
    MiniCacheFreeManager.access$000(this.val$miniAppInfo);
    MiniCacheFreeManager.access$100(this.val$miniAppInfo);
    MiniCacheFreeManager.access$200(this.val$uin, this.val$miniAppInfo);
    MiniCacheFreeManager.access$300(this.val$uin, this.val$miniAppInfo);
    MiniCacheFreeManager.access$400(this.val$miniAppInfo);
    if (this.val$killSelf) {
      MiniCacheFreeManager.access$500(this.val$miniAppInfo);
    }
    if (this.val$onPostRun != null) {
      this.val$onPostRun.run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.cache.MiniCacheFreeManager.2
 * JD-Core Version:    0.7.0.1
 */