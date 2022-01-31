package com.tencent.qqmini.sdk.core.cache;

import android.text.TextUtils;
import android.util.LruCache;
import bgmu;
import bgmx;
import bgnb;
import bgnf;
import bgnh;
import com.tencent.qqmini.sdk.log.QMLog;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Storage$2
  implements Runnable
{
  public Storage$2(bgnf parambgnf, String paramString1, String paramString2, bgnh parambgnh, String paramString3) {}
  
  public void run()
  {
    ??? = bgnb.a(this.jdField_a_of_type_JavaLangString, this.b);
    if ((??? != null) && (((String)???).length() > 1048576) && (this.jdField_a_of_type_Bgnh != null)) {
      this.jdField_a_of_type_Bgnh.onFailed(this.c, "size limit reached");
    }
    if (bgnf.a(this.this$0) != null) {
      if (bgnf.a(this.this$0).a()) {
        bgnf.a(this.this$0);
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
              QMLog.e("Storage", "exceeded the limit size");
              if (this.jdField_a_of_type_Bgnh != null) {
                this.jdField_a_of_type_Bgnh.onFailed(this.c, "exceeded the limit size");
              }
            }
            bgmx localbgmx = bgnf.a(this.this$0).a(this.c);
            if (localbgmx != null)
            {
              localbgmx.a(0, (String)???);
              localbgmx.a();
            }
            if (bgnf.a(this.this$0) != null) {
              bgnf.a(this.this$0).put(this.c, ???);
            }
          }
          synchronized (bgnf.a())
          {
            bgnf.a(this.this$0).trimToSize(10485760 / bgnf.a().keySet().size());
            if (this.jdField_a_of_type_Bgnh != null) {
              this.jdField_a_of_type_Bgnh.onSuccess(this.c, "ok");
            }
          }
        }
        catch (Throwable localThrowable1)
        {
          if (this.jdField_a_of_type_Bgnh != null) {
            this.jdField_a_of_type_Bgnh.onFailed(this.c, localThrowable1.getMessage());
          }
          QMLog.e("Storage", localThrowable1.getMessage(), localThrowable1);
          if (bgnf.a(this.this$0) == null) {
            continue;
          }
          try
          {
            bgnf.a(this.this$0).a();
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
          if (bgnf.a(this.this$0) == null) {
            break label361;
          }
        }
        try
        {
          bgnf.a(this.this$0).a();
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
        bgnf.a(this.this$0).a();
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
    } while (this.jdField_a_of_type_Bgnh == null);
    this.jdField_a_of_type_Bgnh.onFailed(this.c, "can not write");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.cache.Storage.2
 * JD-Core Version:    0.7.0.1
 */