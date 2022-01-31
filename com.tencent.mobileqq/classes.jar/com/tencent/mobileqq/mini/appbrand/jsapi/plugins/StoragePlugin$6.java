package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.cache.Storage;
import com.tencent.mobileqq.mini.webview.JsRuntime;

class StoragePlugin$6
  implements StoragePlugin.StorageTask
{
  StoragePlugin$6(StoragePlugin paramStoragePlugin, JsRuntime paramJsRuntime, String paramString, int paramInt) {}
  
  public String run()
  {
    if (StoragePlugin.access$200(this.this$0).clearStorage()) {
      return StoragePlugin.access$000(this.this$0, this.val$webview, this.val$event, null, this.val$callbackId);
    }
    return StoragePlugin.access$100(this.this$0, this.val$webview, this.val$event, null, "remove failed", this.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.StoragePlugin.6
 * JD-Core Version:    0.7.0.1
 */