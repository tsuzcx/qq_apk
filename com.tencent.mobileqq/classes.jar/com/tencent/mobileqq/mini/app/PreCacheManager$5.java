package com.tencent.mobileqq.mini.app;

import com.tencent.mobileqq.mini.apkg.MiniAppConfig;

class PreCacheManager$5
  implements Runnable
{
  PreCacheManager$5(PreCacheManager paramPreCacheManager, MiniAppConfig paramMiniAppConfig) {}
  
  public void run()
  {
    this.this$0.doFetchPreResourceIfNeed(this.val$miniAppConfig);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.app.PreCacheManager.5
 * JD-Core Version:    0.7.0.1
 */