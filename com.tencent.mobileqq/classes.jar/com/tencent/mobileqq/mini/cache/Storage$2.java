package com.tencent.mobileqq.mini.cache;

import android.support.v4.util.LruCache;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

class Storage$2
  implements Runnable
{
  Storage$2(Storage paramStorage, String paramString1, String paramString2, Storage.StorageCallback paramStorageCallback, String paramString3) {}
  
  public void run()
  {
    String str = Util.encode(this.val$data, this.val$type);
    if ((str != null) && (str.length() > 1048576)) {
      if (this.val$callback != null) {
        this.val$callback.onFailed(this.val$key, "size limit reached");
      }
    }
    label453:
    do
    {
      for (;;)
      {
        return;
        if (Storage.access$000(this.this$0) == null) {
          break label453;
        }
        try
        {
          if (!TextUtils.isEmpty(str))
          {
            if (this.this$0.getCurrentSize() * 1000L + str.length() > 10485760L)
            {
              QLog.e("RequestHandler", 1, "exceeded the limit size");
              if (this.val$callback != null) {
                this.val$callback.onFailed(this.val$key, "exceeded the limit size");
              }
              if ((Storage.access$000(this.this$0) == null) || (Storage.access$000(this.this$0).isClosed())) {
                continue;
              }
              try
              {
                Storage.access$000(this.this$0).flush();
                return;
              }
              catch (IOException localIOException1)
              {
                localIOException1.printStackTrace();
                return;
              }
            }
            if (Storage.access$000(this.this$0).isClosed()) {
              Storage.access$100(this.this$0);
            }
            DiskLruCache.Editor localEditor = Storage.access$000(this.this$0).edit(this.val$key);
            if (localEditor != null)
            {
              localEditor.set(0, localIOException1);
              localEditor.commit();
            }
            if (Storage.access$200(this.this$0) != null) {
              Storage.access$200(this.this$0).put(this.val$key, localIOException1);
            }
          }
          synchronized (Storage.access$300())
          {
            Storage.access$200(this.this$0).trimToSize(10485760 / Storage.access$300().keySet().size());
            if (this.val$callback != null) {
              this.val$callback.onSuccess(this.val$key, "ok");
            }
            if ((Storage.access$000(this.this$0) != null) && (!Storage.access$000(this.this$0).isClosed())) {
              try
              {
                Storage.access$000(this.this$0).flush();
                return;
              }
              catch (IOException localIOException2)
              {
                localIOException2.printStackTrace();
                return;
              }
            }
          }
        }
        catch (Throwable localThrowable)
        {
          if (this.val$callback != null) {
            this.val$callback.onFailed(this.val$key, localThrowable.getMessage());
          }
          QLog.e("RequestHandler", 1, localThrowable, new Object[0]);
          if ((Storage.access$000(this.this$0) != null) && (!Storage.access$000(this.this$0).isClosed())) {
            try
            {
              Storage.access$000(this.this$0).flush();
              return;
            }
            catch (IOException localIOException3)
            {
              localIOException3.printStackTrace();
              return;
            }
          }
        }
        finally
        {
          if ((Storage.access$000(this.this$0) == null) || (Storage.access$000(this.this$0).isClosed())) {}
        }
      }
      try
      {
        Storage.access$000(this.this$0).flush();
        throw localObject1;
      }
      catch (IOException localIOException4)
      {
        for (;;)
        {
          localIOException4.printStackTrace();
        }
      }
      QLog.e("StoragePlugin", 1, "mDiskCache.isClosed(): ");
    } while (this.val$callback == null);
    this.val$callback.onFailed(this.val$key, "can not write");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.cache.Storage.2
 * JD-Core Version:    0.7.0.1
 */