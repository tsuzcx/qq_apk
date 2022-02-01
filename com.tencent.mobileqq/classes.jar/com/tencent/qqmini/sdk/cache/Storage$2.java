package com.tencent.qqmini.sdk.cache;

import android.text.TextUtils;
import android.util.LruCache;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

class Storage$2
  implements Runnable
{
  Storage$2(Storage paramStorage, String paramString1, String paramString2, Storage.StorageCallback paramStorageCallback, String paramString3) {}
  
  public void run()
  {
    ??? = DiskLruCacheUtil.encode(this.val$data, this.val$type);
    if ((??? != null) && (((String)???).length() > 1048576) && (this.val$callback != null)) {
      this.val$callback.onFailed(this.val$key, "size limit reached");
    }
    if (Storage.access$000(this.this$0) != null) {
      if (Storage.access$000(this.this$0).isClosed()) {
        Storage.access$100(this.this$0);
      }
    }
    label361:
    do
    {
      for (;;)
      {
        try
        {
          if (!TextUtils.isEmpty((CharSequence)???))
          {
            if (this.this$0.getCurrentSize() * 1000L + ((String)???).length() > 10485760L)
            {
              QMLog.e("Storage", "exceeded the limit size");
              if (this.val$callback != null) {
                this.val$callback.onFailed(this.val$key, "exceeded the limit size");
              }
            }
            DiskLruCache.Editor localEditor = Storage.access$000(this.this$0).edit(this.val$key);
            if (localEditor != null)
            {
              localEditor.set(0, (String)???);
              localEditor.commit();
            }
            if (Storage.access$200(this.this$0) != null) {
              Storage.access$200(this.this$0).put(this.val$key, ???);
            }
          }
          synchronized (Storage.access$300())
          {
            Storage.access$200(this.this$0).trimToSize(10485760 / Storage.access$300().keySet().size());
            if (this.val$callback != null) {
              this.val$callback.onSuccess(this.val$key, "ok");
            }
          }
        }
        catch (Throwable localThrowable1)
        {
          if (this.val$callback != null) {
            this.val$callback.onFailed(this.val$key, localThrowable1.getMessage());
          }
          QMLog.e("Storage", localThrowable1.getMessage(), localThrowable1);
          if (Storage.access$000(this.this$0) == null) {
            continue;
          }
          try
          {
            Storage.access$000(this.this$0).flush();
            return;
          }
          catch (Throwable localThrowable2)
          {
            localThrowable2.printStackTrace();
            return;
          }
        }
        finally
        {
          if (Storage.access$000(this.this$0) == null) {
            break label361;
          }
        }
        try
        {
          Storage.access$000(this.this$0).flush();
          return;
        }
        catch (Throwable localThrowable3)
        {
          localThrowable3.printStackTrace();
          return;
        }
      }
      localObject3 = finally;
      throw localObject3;
      try
      {
        Storage.access$000(this.this$0).flush();
        throw localObject2;
      }
      catch (Throwable localThrowable4)
      {
        for (;;)
        {
          localThrowable4.printStackTrace();
        }
      }
      QMLog.e("Storage", "mDiskCache.isClosed(): ");
    } while (this.val$callback == null);
    this.val$callback.onFailed(this.val$key, "can not write");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.cache.Storage.2
 * JD-Core Version:    0.7.0.1
 */