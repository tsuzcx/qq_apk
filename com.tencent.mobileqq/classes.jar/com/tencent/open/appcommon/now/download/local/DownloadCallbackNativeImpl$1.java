package com.tencent.open.appcommon.now.download.local;

import bfjr;
import bfka;
import bfkb;
import bfkg;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class DownloadCallbackNativeImpl$1
  implements Runnable
{
  public DownloadCallbackNativeImpl$1(bfka parambfka, int paramInt) {}
  
  public void run()
  {
    Iterator localIterator;
    if ((this.a == 4) || (this.a == 3) || (this.a == 2)) {
      localIterator = bfka.a(this.this$0).values().iterator();
    }
    while (localIterator.hasNext())
    {
      bfkg localbfkg = (bfkg)localIterator.next();
      DownloadInfo localDownloadInfo = bfjr.a().a(localbfkg.a);
      if (localDownloadInfo != null) {
        if (localDownloadInfo.a() == 2)
        {
          if (localbfkg.b) {
            bfkb.a().a(localbfkg.a);
          }
        }
        else if ((localDownloadInfo.a() == 3) && (!localbfkg.b) && (!localbfkg.c))
        {
          bfkb.a().a(null, localbfkg);
          continue;
          if (this.a == 1)
          {
            localIterator = bfka.a(this.this$0).values().iterator();
            while (localIterator.hasNext())
            {
              localbfkg = (bfkg)localIterator.next();
              localDownloadInfo = bfjr.a().a(localbfkg.a);
              if ((localDownloadInfo != null) && (localDownloadInfo.a() == 3) && (!localbfkg.c)) {
                bfkb.a().a(null, localbfkg);
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