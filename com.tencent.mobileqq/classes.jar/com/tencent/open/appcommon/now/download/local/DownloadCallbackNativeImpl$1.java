package com.tencent.open.appcommon.now.download.local;

import bdfv;
import bdge;
import bdgf;
import bdgk;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class DownloadCallbackNativeImpl$1
  implements Runnable
{
  public DownloadCallbackNativeImpl$1(bdge parambdge, int paramInt) {}
  
  public void run()
  {
    Iterator localIterator;
    if ((this.a == 4) || (this.a == 3) || (this.a == 2)) {
      localIterator = bdge.a(this.this$0).values().iterator();
    }
    while (localIterator.hasNext())
    {
      bdgk localbdgk = (bdgk)localIterator.next();
      DownloadInfo localDownloadInfo = bdfv.a().a(localbdgk.a);
      if (localDownloadInfo != null) {
        if (localDownloadInfo.a() == 2)
        {
          if (localbdgk.b) {
            bdgf.a().a(localbdgk.a);
          }
        }
        else if ((localDownloadInfo.a() == 3) && (!localbdgk.b) && (!localbdgk.c))
        {
          bdgf.a().a(null, localbdgk);
          continue;
          if (this.a == 1)
          {
            localIterator = bdge.a(this.this$0).values().iterator();
            while (localIterator.hasNext())
            {
              localbdgk = (bdgk)localIterator.next();
              localDownloadInfo = bdfv.a().a(localbdgk.a);
              if ((localDownloadInfo != null) && (localDownloadInfo.a() == 3) && (!localbdgk.c)) {
                bdgf.a().a(null, localbdgk);
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appcommon.now.download.local.DownloadCallbackNativeImpl.1
 * JD-Core Version:    0.7.0.1
 */