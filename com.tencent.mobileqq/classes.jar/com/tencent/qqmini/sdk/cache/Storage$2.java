package com.tencent.qqmini.sdk.cache;

import com.tencent.qqmini.sdk.launcher.log.QMLog;

class Storage$2
  implements Runnable
{
  Storage$2(Storage paramStorage, String paramString1, String paramString2, Storage.StorageCallback paramStorageCallback, String paramString3) {}
  
  public void run()
  {
    Object localObject = DiskLruCacheUtil.encode(this.val$data, this.val$type);
    if ((localObject != null) && (((String)localObject).length() > 1048576))
    {
      Storage.StorageCallback localStorageCallback = this.val$callback;
      if (localStorageCallback != null) {
        localStorageCallback.onFailed(this.val$key, "size limit reached");
      }
    }
    if (Storage.access$000(this.this$0) != null)
    {
      if (Storage.access$000(this.this$0).isClosed()) {
        Storage.access$100(this.this$0);
      }
      Storage.access$200(this.this$0, (String)localObject, this.val$callback, this.val$key);
      return;
    }
    QMLog.e("Storage", "mDiskCache.isClosed(): ");
    localObject = this.val$callback;
    if (localObject != null) {
      ((Storage.StorageCallback)localObject).onFailed(this.val$key, "can not write");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.cache.Storage.2
 * JD-Core Version:    0.7.0.1
 */