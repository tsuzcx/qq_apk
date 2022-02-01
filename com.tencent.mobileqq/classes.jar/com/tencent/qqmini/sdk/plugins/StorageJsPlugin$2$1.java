package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.cache.Storage.StorageCallback;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;

class StorageJsPlugin$2$1
  implements Storage.StorageCallback
{
  StorageJsPlugin$2$1(StorageJsPlugin.2 param2) {}
  
  public void onFailed(String paramString1, String paramString2)
  {
    this.this$1.val$req.fail(paramString2);
  }
  
  public void onSuccess(String paramString1, String paramString2)
  {
    this.this$1.val$req.ok();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.StorageJsPlugin.2.1
 * JD-Core Version:    0.7.0.1
 */