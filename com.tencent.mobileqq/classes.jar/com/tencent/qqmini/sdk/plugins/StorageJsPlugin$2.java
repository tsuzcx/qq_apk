package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.cache.Storage;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;

class StorageJsPlugin$2
  implements Runnable
{
  StorageJsPlugin$2(StorageJsPlugin paramStorageJsPlugin, String paramString1, String paramString2, String paramString3, RequestEvent paramRequestEvent) {}
  
  public void run()
  {
    StorageJsPlugin.access$000(this.this$0).write(this.val$key_real, this.val$data, this.val$dataType, new StorageJsPlugin.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.StorageJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */