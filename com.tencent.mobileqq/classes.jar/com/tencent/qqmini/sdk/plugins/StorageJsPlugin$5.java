package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.cache.Storage;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;

class StorageJsPlugin$5
  implements StorageJsPlugin.StorageTask
{
  StorageJsPlugin$5(StorageJsPlugin paramStorageJsPlugin, String paramString, RequestEvent paramRequestEvent) {}
  
  public String run()
  {
    if (StorageJsPlugin.access$000(this.this$0).removeStorage(this.val$key_real)) {
      return this.val$req.ok();
    }
    return this.val$req.fail("remove failed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.StorageJsPlugin.5
 * JD-Core Version:    0.7.0.1
 */