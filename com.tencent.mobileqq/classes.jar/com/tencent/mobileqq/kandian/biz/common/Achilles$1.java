package com.tencent.mobileqq.kandian.biz.common;

import com.tencent.mobileqq.bigbrother.RockDownloader.RockDownloaderProxy;
import com.tencent.mobileqq.data.RockDownloadInfo;
import com.tencent.mobileqq.kandian.repo.aladdin.config.AchillesParams;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

final class Achilles$1
  implements Runnable
{
  public void run()
  {
    Object localObject2 = Achilles.a();
    if (!Achilles.b())
    {
      QLog.i("Achilles", 1, "[run] wifi not connected, skip.");
      return;
    }
    Object localObject1 = new HashSet();
    localObject2 = ((Set)localObject2).iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject4 = (AchillesParams)((Iterator)localObject2).next();
      if (localObject4 == null)
      {
        QLog.e("Achilles", 1, "[run] param is null");
      }
      else
      {
        localObject3 = ((AchillesParams)localObject4).getPackageName();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[run] checking ");
        localStringBuilder.append((String)localObject3);
        QLog.i("Achilles", 1, localStringBuilder.toString());
        if (!((AchillesParams)localObject4).isEnable())
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("[run] disabled, skip ");
          ((StringBuilder)localObject4).append((String)localObject3);
          QLog.i("Achilles", 1, ((StringBuilder)localObject4).toString());
        }
        else if (Achilles.c((String)localObject3))
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("[run] installed, skip ");
          ((StringBuilder)localObject4).append((String)localObject3);
          QLog.i("Achilles", 1, ((StringBuilder)localObject4).toString());
        }
        else
        {
          ((Set)localObject1).add(localObject4);
        }
      }
    }
    if (!((Set)localObject1).isEmpty())
    {
      localObject1 = ((Set)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (AchillesParams)((Iterator)localObject1).next();
        localObject3 = Achilles.a((AchillesParams)localObject2);
        RockDownloaderProxy.a((RockDownloadInfo)localObject3, new Achilles.1.1(this, (RockDownloadInfo)localObject3, (AchillesParams)localObject2));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.Achilles.1
 * JD-Core Version:    0.7.0.1
 */