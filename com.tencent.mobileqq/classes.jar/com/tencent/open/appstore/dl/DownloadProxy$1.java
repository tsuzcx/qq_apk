package com.tencent.open.appstore.dl;

import com.tencent.open.base.LogUtility;
import com.tencent.tmdatasourcesdk.ITMAssistantExchangeURLListenner;
import com.tencent.tmdatasourcesdk.internal.protocol.jce.AppSimpleDetail;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

class DownloadProxy$1
  implements ITMAssistantExchangeURLListenner
{
  DownloadProxy$1(DownloadProxy paramDownloadProxy) {}
  
  public void onExchangedURLSucceed(ArrayList arg1, boolean paramBoolean)
  {
    LogUtility.b("DownloadResolver", "onExchangedURLSucceed --- ");
    if ((paramBoolean) && (??? != null) && (???.size() > 0))
    {
      ??? = ???.iterator();
      while (???.hasNext())
      {
        Object localObject1 = ???.next();
        if ((localObject1 instanceof AppSimpleDetail))
        {
          int i = ((AppSimpleDetail)localObject1).versionCode;
          if (i > 0) {
            DownloadProxy.a(this.a).put(((AppSimpleDetail)localObject1).packageName, Integer.valueOf(i));
          }
        }
      }
    }
    synchronized (DownloadProxy.a(this.a))
    {
      DownloadProxy.a(this.a).notify();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadProxy.1
 * JD-Core Version:    0.7.0.1
 */