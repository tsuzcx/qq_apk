package com.tencent.mobileqq.qqlive.filter.download;

import com.tencent.mobileqq.qqlive.anchor.room.editor.QQLiveAEResPreLoadCallback;
import com.tencent.mobileqq.qqlive.filter.data.MetaMaterial;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

class QQLiveAEResDownloader$2
  implements Runnable
{
  public void run()
  {
    long l1 = System.currentTimeMillis();
    QLog.d("QQLiveAEResDownloader", 4, "[preDownloadAllRes] start");
    this.this$0.d();
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = this.this$0.c.values().iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (MetaMaterial)((Iterator)localObject1).next();
      if ((localObject2 != null) && (!this.this$0.a((MetaMaterial)localObject2))) {
        localArrayList.add(localObject2);
      }
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[preDownloadAllRes] needDownloads size=");
    ((StringBuilder)localObject1).append(localArrayList.size());
    QLog.d("QQLiveAEResDownloader", 4, ((StringBuilder)localObject1).toString());
    int i = 0;
    while (i < localArrayList.size())
    {
      int k = Math.min(4, localArrayList.size() - i);
      localObject1 = new CountDownLatch(k);
      int j = 0;
      while (j < k)
      {
        localObject2 = (MetaMaterial)localArrayList.get(i);
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("[preDownloadAllRes] do download index:");
        localStringBuilder2.append(i);
        localStringBuilder2.append(", id=");
        localStringBuilder2.append(((MetaMaterial)localObject2).b);
        QLog.d("QQLiveAEResDownloader", 4, localStringBuilder2.toString());
        this.this$0.a((MetaMaterial)localObject2, new QQLiveAEResDownloader.2.1(this, i, (MetaMaterial)localObject2, (CountDownLatch)localObject1, k));
        j += 1;
        i += 1;
      }
      try
      {
        ((CountDownLatch)localObject1).await();
      }
      catch (InterruptedException localInterruptedException)
      {
        this.a.a(false);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[preDownloadAllRes] latch.await() throw exception:");
        ((StringBuilder)localObject2).append(localInterruptedException.getMessage());
        QLog.e("QQLiveAEResDownloader", 4, ((StringBuilder)localObject2).toString());
      }
      QLog.d("QQLiveAEResDownloader", 4, new Object[] { "[preDownloadAllRes] finish a little group i:", Integer.valueOf(i) });
    }
    long l2 = System.currentTimeMillis();
    this.a.a(true);
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("[preDownloadAllRes] map download finish, cost=");
    localStringBuilder1.append(l2 - l1);
    QLog.d("QQLiveAEResDownloader", 4, localStringBuilder1.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.filter.download.QQLiveAEResDownloader.2
 * JD-Core Version:    0.7.0.1
 */