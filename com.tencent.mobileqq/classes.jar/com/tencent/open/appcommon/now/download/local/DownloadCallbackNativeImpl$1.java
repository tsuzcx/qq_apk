package com.tencent.open.appcommon.now.download.local;

import bcbu;
import bccd;
import bcce;
import bccj;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class DownloadCallbackNativeImpl$1
  implements Runnable
{
  public DownloadCallbackNativeImpl$1(bccd parambccd, int paramInt) {}
  
  public void run()
  {
    Iterator localIterator;
    if ((this.a == 4) || (this.a == 3) || (this.a == 2)) {
      localIterator = bccd.a(this.this$0).values().iterator();
    }
    while (localIterator.hasNext())
    {
      bccj localbccj = (bccj)localIterator.next();
      DownloadInfo localDownloadInfo = bcbu.a().a(localbccj.a);
      if (localDownloadInfo != null) {
        if (localDownloadInfo.a() == 2)
        {
          if (localbccj.b) {
            bcce.a().a(localbccj.a);
          }
        }
        else if ((localDownloadInfo.a() == 3) && (!localbccj.b) && (!localbccj.c))
        {
          bcce.a().a(null, localbccj);
          continue;
          if (this.a == 1)
          {
            localIterator = bccd.a(this.this$0).values().iterator();
            while (localIterator.hasNext())
            {
              localbccj = (bccj)localIterator.next();
              localDownloadInfo = bcbu.a().a(localbccj.a);
              if ((localDownloadInfo != null) && (localDownloadInfo.a() == 3) && (!localbccj.c)) {
                bcce.a().a(null, localbccj);
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