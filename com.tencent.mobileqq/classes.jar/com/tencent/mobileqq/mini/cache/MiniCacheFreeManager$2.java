package com.tencent.mobileqq.mini.cache;

import com.tencent.mobileqq.mini.apkg.MiniAppInfo;

final class MiniCacheFreeManager$2
  implements Runnable
{
  MiniCacheFreeManager$2(MiniAppInfo paramMiniAppInfo, String paramString, boolean paramBoolean) {}
  
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.cache.MiniCacheFreeManager.2
 * JD-Core Version:    0.7.0.1
 */