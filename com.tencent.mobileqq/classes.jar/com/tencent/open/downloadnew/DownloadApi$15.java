package com.tencent.open.downloadnew;

import com.tencent.open.base.LogUtility;
import com.tencent.tmdatasourcesdk.ITMAssistantExchangeURLListenner;
import com.tencent.tmdatasourcesdk.internal.protocol.jce.AppSimpleDetail;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

final class DownloadApi$15
  implements ITMAssistantExchangeURLListenner
{
  public void onExchangedURLSucceed(ArrayList arg1, boolean paramBoolean)
  {
    LogUtility.b(DownloadApi.a, "onExchangedURLSucceed --- ");
    if ((paramBoolean) && (??? != null) && (???.size() > 0))
    {
      ??? = ???.iterator();
      while (???.hasNext())
      {
        Object localObject1 = ???.next();
        if ((localObject1 instanceof AppSimpleDetail))
        {
          localObject1 = (AppSimpleDetail)localObject1;
          int i = ((AppSimpleDetail)localObject1).versionCode;
          if (i > 0) {
            DownloadApi.c.put(((AppSimpleDetail)localObject1).packageName, Integer.valueOf(i));
          }
        }
      }
    }
    synchronized (DownloadApi.b)
    {
      DownloadApi.b.notify();
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadApi.15
 * JD-Core Version:    0.7.0.1
 */