package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.cache.Storage;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;

class StorageJsPlugin$6
  implements StorageJsPlugin.StorageTask
{
  StorageJsPlugin$6(StorageJsPlugin paramStorageJsPlugin, RequestEvent paramRequestEvent) {}
  
  public String run()
  {
    if (StorageJsPlugin.access$000(this.this$0).clearStorage()) {
      return this.val$req.ok();
    }
    return this.val$req.fail("clear failed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.StorageJsPlugin.6
 * JD-Core Version:    0.7.0.1
 */