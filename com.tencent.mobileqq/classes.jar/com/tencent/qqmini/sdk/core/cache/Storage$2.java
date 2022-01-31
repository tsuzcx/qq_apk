package com.tencent.qqmini.sdk.core.cache;

import android.text.TextUtils;
import android.util.LruCache;
import beip;
import beis;
import beiw;
import beix;
import beiz;
import betc;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Storage$2
  implements Runnable
{
  public Storage$2(beix parambeix, String paramString1, String paramString2, beiz parambeiz, String paramString3) {}
  
  public void run()
  {
    ??? = beiw.a(this.jdField_a_of_type_JavaLangString, this.b);
    if ((??? != null) && (((String)???).length() > 1048576) && (this.jdField_a_of_type_Beiz != null)) {
      this.jdField_a_of_type_Beiz.onFailed(this.c, "size limit reached");
    }
    if (beix.a(this.this$0) != null) {
      if (beix.a(this.this$0).a()) {
        beix.a(this.this$0);
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
              betc.d("Storage", "exceeded the limit size");
              if (this.jdField_a_of_type_Beiz != null) {
                this.jdField_a_of_type_Beiz.onFailed(this.c, "exceeded the limit size");
              }
            }
            beis localbeis = beix.a(this.this$0).a(this.c);
            if (localbeis != null)
            {
              localbeis.a(0, (String)???);
              localbeis.a();
            }
            if (beix.a(this.this$0) != null) {
              beix.a(this.this$0).put(this.c, ???);
            }
          }
          synchronized (beix.a())
          {
            beix.a(this.this$0).trimToSize(10485760 / beix.a().keySet().size());
            if (this.jdField_a_of_type_Beiz != null) {
              this.jdField_a_of_type_Beiz.onSuccess(this.c, "ok");
            }
          }
        }
        catch (Throwable localThrowable)
        {
          if (this.jdField_a_of_type_Beiz != null) {
            this.jdField_a_of_type_Beiz.onFailed(this.c, localThrowable.getMessage());
          }
          betc.d("Storage", localThrowable.getMessage(), localThrowable);
          if (beix.a(this.this$0) == null) {
            continue;
          }
          try
          {
            beix.a(this.this$0).a();
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
          if (beix.a(this.this$0) == null) {
            break label361;
          }
        }
        try
        {
          beix.a(this.this$0).a();
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
        beix.a(this.this$0).a();
        throw localObject2;
      }
      catch (IOException localIOException3)
      {
        for (;;)
        {
          localIOException3.printStackTrace();
        }
      }
      betc.d("Storage", "mDiskCache.isClosed(): ");
    } while (this.jdField_a_of_type_Beiz == null);
    this.jdField_a_of_type_Beiz.onFailed(this.c, "can not write");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.cache.Storage.2
 * JD-Core Version:    0.7.0.1
 */