package com.tencent.qqmini.sdk.core.plugins;

import bgnf;
import bgok;

class StorageJsPlugin$4
  implements StorageJsPlugin.StorageTask
{
  StorageJsPlugin$4(StorageJsPlugin paramStorageJsPlugin, String paramString, bgok parambgok) {}
  
  public String run()
  {
    if (StorageJsPlugin.access$000(this.this$0).a(this.val$key_real)) {
      return this.val$req.a();
    }
    return this.val$req.a("remove failed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.StorageJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */