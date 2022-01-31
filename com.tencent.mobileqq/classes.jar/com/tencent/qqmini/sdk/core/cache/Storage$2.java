package com.tencent.qqmini.sdk.core.cache;

import android.text.TextUtils;
import android.util.LruCache;
import behy;
import beib;
import beif;
import beig;
import beii;
import besl;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Storage$2
  implements Runnable
{
  public Storage$2(beig parambeig, String paramString1, String paramString2, beii parambeii, String paramString3) {}
  
  public void run()
  {
    ??? = beif.a(this.jdField_a_of_type_JavaLangString, this.b);
    if ((??? != null) && (((String)???).length() > 1048576) && (this.jdField_a_of_type_Beii != null)) {
      this.jdField_a_of_type_Beii.onFailed(this.c, "size limit reached");
    }
    if (beig.a(this.this$0) != null) {
      if (beig.a(this.this$0).a()) {
        beig.a(this.this$0);
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
            if (this.this$0.a() * 1000L + ((String)???).length() > 10485760L)
            {
              besl.d("Storage", "exceeded the limit size");
              if (this.jdField_a_of_type_Beii != null) {
                this.jdField_a_of_type_Beii.onFailed(this.c, "exceeded the limit size");
              }
            }
            beib localbeib = beig.a(this.this$0).a(this.c);
            if (localbeib != null)
            {
              localbeib.a(0, (String)???);
              localbeib.a();
            }
            if (beig.a(this.this$0) != null) {
              beig.a(this.this$0).put(this.c, ???);
            }
          }
          synchronized (beig.a())
          {
            beig.a(this.this$0).trimToSize(10485760 / beig.a().keySet().size());
            if (this.jdField_a_of_type_Beii != null) {
              this.jdField_a_of_type_Beii.onSuccess(this.c, "ok");
            }
          }
        }
        catch (Throwable localThrowable)
        {
          if (this.jdField_a_of_type_Beii != null) {
            this.jdField_a_of_type_Beii.onFailed(this.c, localThrowable.getMessage());
          }
          besl.d("Storage", localThrowable.getMessage(), localThrowable);
          if (beig.a(this.this$0) == null) {
            continue;
          }
          try
          {
            beig.a(this.this$0).a();
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
          if (beig.a(this.this$0) == null) {
            break label361;
          }
        }
        try
        {
          beig.a(this.this$0).a();
          return;
        }
        catch (IOException localIOException2)
        {
          localIOException2.printStackTrace();
          return;
        }
      }
      localObject3 = finally;
      throw localObject3;
      try
      {
        beig.a(this.this$0).a();
        throw localObject2;
      }
      catch (IOException localIOException3)
      {
        for (;;)
        {
          localIOException3.printStackTrace();
        }
      }
      besl.d("Storage", "mDiskCache.isClosed(): ");
    } while (this.jdField_a_of_type_Beii == null);
    this.jdField_a_of_type_Beii.onFailed(this.c, "can not write");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.cache.Storage.2
 * JD-Core Version:    0.7.0.1
 */