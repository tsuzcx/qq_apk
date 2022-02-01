package com.tencent.open.appcommon.now.download.local;

import bira;
import birj;
import birk;
import birp;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class DownloadCallbackNativeImpl$1
  implements Runnable
{
  public DownloadCallbackNativeImpl$1(birj parambirj, int paramInt) {}
  
  public void run()
  {
    Iterator localIterator;
    if ((this.a == 4) || (this.a == 3) || (this.a == 2)) {
      localIterator = birj.a(this.this$0).values().iterator();
    }
    while (localIterator.hasNext())
    {
      birp localbirp = (birp)localIterator.next();
      DownloadInfo localDownloadInfo = bira.a().a(localbirp.a);
      if (localDownloadInfo != null) {
        if (localDownloadInfo.a() == 2)
        {
          if (localbirp.b) {
            birk.a().a(localbirp.a);
          }
        }
        else if ((localDownloadInfo.a() == 3) && (!localbirp.b) && (!localbirp.c))
        {
          birk.a().a(null, localbirp);
          continue;
          if (this.a == 1)
          {
            localIterator = birj.a(this.this$0).values().iterator();
            while (localIterator.hasNext())
            {
              localbirp = (birp)localIterator.next();
              localDownloadInfo = bira.a().a(localbirp.a);
              if ((localDownloadInfo != null) && (localDownloadInfo.a() == 3) && (!localbirp.c)) {
                birk.a().a(null, localbirp);
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