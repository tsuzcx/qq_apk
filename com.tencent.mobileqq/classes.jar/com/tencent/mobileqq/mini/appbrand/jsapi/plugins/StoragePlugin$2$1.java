package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.cache.Storage.StorageCallback;

class StoragePlugin$2$1
  implements Storage.StorageCallback
{
  StoragePlugin$2$1(StoragePlugin.2 param2) {}
  
  public void onFailed(String paramString1, String paramString2)
  {
    StoragePlugin.access$100(this.this$1.this$0, this.this$1.val$webview, this.this$1.val$event, null, paramString2, this.this$1.val$callbackId);
  }
  
  public void onSuccess(String paramString1, String paramString2)
  {
    StoragePlugin.access$000(this.this$1.this$0, this.this$1.val$webview, this.this$1.val$event, null, this.this$1.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.StoragePlugin.2.1
 * JD-Core Version:    0.7.0.1
 */