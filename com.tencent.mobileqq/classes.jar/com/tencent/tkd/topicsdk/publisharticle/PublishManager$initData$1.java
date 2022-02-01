package com.tencent.tkd.topicsdk.publisharticle;

import com.tencent.tkd.topicsdk.bean.PublishArticleInfo;
import com.tencent.tkd.topicsdk.framework.Account;
import com.tencent.tkd.topicsdk.framework.StorageManager;
import com.tencent.tkd.topicsdk.framework.TLog;
import com.tencent.tkd.topicsdk.framework.ThreadManagerKt;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class PublishManager$initData$1
  extends Lambda
  implements Function0<Unit>
{
  PublishManager$initData$1(Function0 paramFunction0)
  {
    super(0);
  }
  
  public final void invoke()
  {
    for (;;)
    {
      try
      {
        localObject1 = StorageManager.a.a("publishTaskList_" + Account.a.a());
        if (localObject1 != null)
        {
          localCloseable = (Closeable)new ObjectInputStream((InputStream)new ByteArrayInputStream((byte[])localObject1));
          localThrowable2 = (Throwable)null;
          localObject1 = localThrowable2;
        }
      }
      catch (Exception localException)
      {
        Object localObject1;
        Closeable localCloseable;
        Throwable localThrowable2;
        Object localObject4;
        Object localObject2;
        TLog.c("PublishManager", "initData, exception", (Throwable)localException);
        continue;
        continue;
        int i = 0;
        continue;
      }
      try
      {
        localObject4 = ((ObjectInputStream)localCloseable).readObject();
        localObject2 = localObject4;
        localObject1 = localThrowable2;
        if (!(localObject4 instanceof ArrayList)) {
          localObject2 = null;
        }
        localObject1 = localThrowable2;
        localObject2 = (ArrayList)localObject2;
        if (localObject2 != null)
        {
          localObject1 = localThrowable2;
          localObject2 = ((Iterable)localObject2).iterator();
          localObject1 = localThrowable2;
          if (((Iterator)localObject2).hasNext())
          {
            localObject1 = localThrowable2;
            localObject4 = (PublishArticleInfo)((Iterator)localObject2).next();
            localObject1 = localThrowable2;
            if (((PublishArticleInfo)localObject4).getPublishId() != null)
            {
              localObject1 = localThrowable2;
              if (((CharSequence)((PublishArticleInfo)localObject4).getPublishId()).length() <= 0) {
                continue;
              }
              i = 1;
              if (i != 0)
              {
                localObject1 = localThrowable2;
                ((PublishArticleInfo)localObject4).setPublishing(false);
                localObject1 = localThrowable2;
                PublishManager.a(PublishManager.a, (PublishArticleInfo)localObject4);
              }
            }
          }
          else
          {
            localObject1 = localThrowable2;
            localObject2 = Unit.INSTANCE;
          }
        }
        else
        {
          CloseableKt.closeFinally(localCloseable, localThrowable2);
          ThreadManagerKt.a((Function0)new PublishManager.initData.1.2(this));
          return;
        }
      }
      catch (Throwable localThrowable1)
      {
        localObject1 = localThrowable1;
        throw localThrowable1;
      }
      finally
      {
        CloseableKt.closeFinally(localCloseable, (Throwable)localObject1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.PublishManager.initData.1
 * JD-Core Version:    0.7.0.1
 */