package com.tencent.qqmini.sdk.core.cache;

import android.text.TextUtils;
import android.util.LruCache;
import bddy;
import bdeb;
import bdef;
import bdeg;
import bdei;
import bdnw;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Storage$2
  implements Runnable
{
  public Storage$2(bdeg parambdeg, String paramString1, String paramString2, bdei parambdei, String paramString3) {}
  
  public void run()
  {
    ??? = bdef.a(this.jdField_a_of_type_JavaLangString, this.b);
    if ((??? != null) && (((String)???).length() > 1048576) && (this.jdField_a_of_type_Bdei != null)) {
      this.jdField_a_of_type_Bdei.onFailed(this.c, "size limit reached");
    }
    if (bdeg.a(this.this$0) != null) {
      if (bdeg.a(this.this$0).a()) {
        bdeg.a(this.this$0);
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
              bdnw.d("Storage", "exceeded the limit size");
              if (this.jdField_a_of_type_Bdei != null) {
                this.jdField_a_of_type_Bdei.onFailed(this.c, "exceeded the limit size");
              }
            }
            bdeb localbdeb = bdeg.a(this.this$0).a(this.c);
            if (localbdeb != null)
            {
              localbdeb.a(0, (String)???);
              localbdeb.a();
            }
            if (bdeg.a(this.this$0) != null) {
              bdeg.a(this.this$0).put(this.c, ???);
            }
          }
          synchronized (bdeg.a())
          {
            bdeg.a(this.this$0).trimToSize(10485760 / bdeg.a().keySet().size());
            if (this.jdField_a_of_type_Bdei != null) {
              this.jdField_a_of_type_Bdei.onSuccess(this.c, "ok");
            }
          }
        }
        catch (Throwable localThrowable)
        {
          if (this.jdField_a_of_type_Bdei != null) {
            this.jdField_a_of_type_Bdei.onFailed(this.c, localThrowable.getMessage());
          }
          bdnw.d("Storage", localThrowable.getMessage(), localThrowable);
          if (bdeg.a(this.this$0) == null) {
            continue;
          }
          try
          {
            bdeg.a(this.this$0).a();
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
          if (bdeg.a(this.this$0) == null) {
            break label361;
          }
        }
        try
        {
          bdeg.a(this.this$0).a();
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
        bdeg.a(this.this$0).a();
        throw localObject2;
      }
      catch (IOException localIOException3)
      {
        for (;;)
        {
          localIOException3.printStackTrace();
        }
      }
      bdnw.d("Storage", "mDiskCache.isClosed(): ");
    } while (this.jdField_a_of_type_Bdei == null);
    this.jdField_a_of_type_Bdei.onFailed(this.c, "can not write");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.cache.Storage.2
 * JD-Core Version:    0.7.0.1
 */