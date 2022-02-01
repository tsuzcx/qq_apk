package com.tencent.open.appcommon.now.download.local;

import bjiq;
import bjiz;
import bjja;
import bjjf;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class DownloadCallbackNativeImpl$1
  implements Runnable
{
  public DownloadCallbackNativeImpl$1(bjiz parambjiz, int paramInt) {}
  
  public void run()
  {
    Iterator localIterator;
    if ((this.a == 4) || (this.a == 3) || (this.a == 2)) {
      localIterator = bjiz.a(this.this$0).values().iterator();
    }
    while (localIterator.hasNext())
    {
      bjjf localbjjf = (bjjf)localIterator.next();
      DownloadInfo localDownloadInfo = bjiq.a().a(localbjjf.a);
      if (localDownloadInfo != null) {
        if (localDownloadInfo.a() == 2)
        {
          if (localbjjf.b) {
            bjja.a().a(localbjjf.a);
          }
        }
        else if ((localDownloadInfo.a() == 3) && (!localbjjf.b) && (!localbjjf.c))
        {
          bjja.a().a(null, localbjjf);
          continue;
          if (this.a == 1)
          {
            localIterator = bjiz.a(this.this$0).values().iterator();
            while (localIterator.hasNext())
            {
              localbjjf = (bjjf)localIterator.next();
              localDownloadInfo = bjiq.a().a(localbjjf.a);
              if ((localDownloadInfo != null) && (localDownloadInfo.a() == 3) && (!localbjjf.c)) {
                bjja.a().a(null, localbjjf);
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.appcommon.now.download.local.DownloadCallbackNativeImpl.1
 * JD-Core Version:    0.7.0.1
 */