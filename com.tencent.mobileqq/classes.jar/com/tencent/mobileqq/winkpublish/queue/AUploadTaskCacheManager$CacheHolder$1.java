package com.tencent.mobileqq.winkpublish.queue;

import com.tencent.mobileqq.qcircle.api.db.IDBManagerWrapper;
import com.tencent.mobileqq.qcircle.api.db.IDBManagerWrapper.OnCloseListener;

class AUploadTaskCacheManager$CacheHolder$1
  implements IDBManagerWrapper.OnCloseListener
{
  AUploadTaskCacheManager$CacheHolder$1(AUploadTaskCacheManager.CacheHolder paramCacheHolder) {}
  
  public void onClosed(IDBManagerWrapper paramIDBManagerWrapper)
  {
    paramIDBManagerWrapper = this.a;
    paramIDBManagerWrapper.a = 0L;
    paramIDBManagerWrapper.b = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.queue.AUploadTaskCacheManager.CacheHolder.1
 * JD-Core Version:    0.7.0.1
 */