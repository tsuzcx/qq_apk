package com.tencent.open.appcommon.now.download.local;

import bdgk;
import bdgt;
import bdgu;
import bdgz;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class DownloadCallbackNativeImpl$1
  implements Runnable
{
  public DownloadCallbackNativeImpl$1(bdgt parambdgt, int paramInt) {}
  
  public void run()
  {
    Iterator localIterator;
    if ((this.a == 4) || (this.a == 3) || (this.a == 2)) {
      localIterator = bdgt.a(this.this$0).values().iterator();
    }
    while (localIterator.hasNext())
    {
      bdgz localbdgz = (bdgz)localIterator.next();
      DownloadInfo localDownloadInfo = bdgk.a().a(localbdgz.a);
      if (localDownloadInfo != null) {
        if (localDownloadInfo.a() == 2)
        {
          if (localbdgz.b) {
            bdgu.a().a(localbdgz.a);
          }
        }
        else if ((localDownloadInfo.a() == 3) && (!localbdgz.b) && (!localbdgz.c))
        {
          bdgu.a().a(null, localbdgz);
          continue;
          if (this.a == 1)
          {
            localIterator = bdgt.a(this.this$0).values().iterator();
            while (localIterator.hasNext())
            {
              localbdgz = (bdgz)localIterator.next();
              localDownloadInfo = bdgk.a().a(localbdgz.a);
              if ((localDownloadInfo != null) && (localDownloadInfo.a() == 3) && (!localbdgz.c)) {
                bdgu.a().a(null, localbdgz);
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