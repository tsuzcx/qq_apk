package com.tencent.qqmini.sdk.core.cache;

import android.text.TextUtils;
import android.util.LruCache;
import bgin;
import bgiq;
import bgiu;
import bgiy;
import bgja;
import com.tencent.qqmini.sdk.log.QMLog;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Storage$2
  implements Runnable
{
  public Storage$2(bgiy parambgiy, String paramString1, String paramString2, bgja parambgja, String paramString3) {}
  
  public void run()
  {
    ??? = bgiu.a(this.jdField_a_of_type_JavaLangString, this.b);
    if ((??? != null) && (((String)???).length() > 1048576) && (this.jdField_a_of_type_Bgja != null)) {
      this.jdField_a_of_type_Bgja.onFailed(this.c, "size limit reached");
    }
    if (bgiy.a(this.this$0) != null) {
      if (bgiy.a(this.this$0).a()) {
        bgiy.a(this.this$0);
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
              if (this.jdField_a_of_type_Bgja != null) {
                this.jdField_a_of_type_Bgja.onFailed(this.c, "exceeded the limit size");
              }
            }
            bgiq localbgiq = bgiy.a(this.this$0).a(this.c);
            if (localbgiq != null)
            {
              localbgiq.a(0, (String)???);
              localbgiq.a();
            }
            if (bgiy.a(this.this$0) != null) {
              bgiy.a(this.this$0).put(this.c, ???);
            }
          }
          synchronized (bgiy.a())
          {
            bgiy.a(this.this$0).trimToSize(10485760 / bgiy.a().keySet().size());
            if (this.jdField_a_of_type_Bgja != null) {
              this.jdField_a_of_type_Bgja.onSuccess(this.c, "ok");
            }
          }
        }
        catch (Throwable localThrowable1)
        {
          if (this.jdField_a_of_type_Bgja != null) {
            this.jdField_a_of_type_Bgja.onFailed(this.c, localThrowable1.getMessage());
          }
          QMLog.e("Storage", localThrowable1.getMessage(), localThrowable1);
          if (bgiy.a(this.this$0) == null) {
            continue;
          }
          try
          {
            bgiy.a(this.this$0).a();
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
          if (bgiy.a(this.this$0) == null) {
            break label361;
          }
        }
        try
        {
          bgiy.a(this.this$0).a();
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
        bgiy.a(this.this$0).a();
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
    } while (this.jdField_a_of_type_Bgja == null);
    this.jdField_a_of_type_Bgja.onFailed(this.c, "can not write");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.cache.Storage.2
 * JD-Core Version:    0.7.0.1
 */