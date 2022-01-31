package com.tencent.mobileqq.microapp.a;

import android.support.v4.util.LruCache;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

final class f
  implements Runnable
{
  f(d paramd, String paramString1, String paramString2, String paramString3, d.a parama) {}
  
  public void run()
  {
    if (d.a(this.e) != null) {
      if (d.a(this.e).d()) {
        d.b(this.e);
      }
    }
    label274:
    do
    {
      for (;;)
      {
        try
        {
          ??? = i.a(this.a, this.b);
          if (!TextUtils.isEmpty((CharSequence)???))
          {
            a.a locala = d.a(this.e).b(this.c);
            if (locala != null)
            {
              locala.a(0, (String)???);
              locala.a();
            }
            if (d.c(this.e) != null) {
              d.c(this.e).put(this.c, ???);
            }
          }
        }
        catch (Throwable localThrowable)
        {
          if (this.d == null) {
            continue;
          }
          this.d.b(this.c, localThrowable.getMessage());
          QLog.e("RequestHandler", 1, localThrowable, new Object[0]);
          if (d.a(this.e) == null) {
            continue;
          }
          try
          {
            d.a(this.e).e();
            return;
          }
          catch (IOException localIOException1)
          {
            localIOException1.printStackTrace();
            return;
          }
        }
        finally
        {
          if (d.a(this.e) == null) {
            break label274;
          }
        }
        synchronized (d.e())
        {
          d.c(this.e).trimToSize(10485760 / d.e().keySet().size());
          if (this.d != null) {
            this.d.a(this.c, "ok");
          }
          if (d.a(this.e) == null) {}
        }
      }
      try
      {
        d.a(this.e).e();
        throw localObject2;
      }
      catch (IOException localIOException3)
      {
        for (;;)
        {
          localIOException3.printStackTrace();
        }
      }
      QLog.e("StoragePlugin", 1, "mDiskCache.isClosed(): " + d.a(this.e).d());
    } while (this.d == null);
    this.d.b(this.c, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.a.f
 * JD-Core Version:    0.7.0.1
 */