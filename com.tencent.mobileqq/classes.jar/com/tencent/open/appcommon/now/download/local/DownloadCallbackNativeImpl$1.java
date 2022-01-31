package com.tencent.open.appcommon.now.download.local;

import bffi;
import bffr;
import bffs;
import bffx;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class DownloadCallbackNativeImpl$1
  implements Runnable
{
  public DownloadCallbackNativeImpl$1(bffr parambffr, int paramInt) {}
  
  public void run()
  {
    Iterator localIterator;
    if ((this.a == 4) || (this.a == 3) || (this.a == 2)) {
      localIterator = bffr.a(this.this$0).values().iterator();
    }
    while (localIterator.hasNext())
    {
      bffx localbffx = (bffx)localIterator.next();
      DownloadInfo localDownloadInfo = bffi.a().a(localbffx.a);
      if (localDownloadInfo != null) {
        if (localDownloadInfo.a() == 2)
        {
          if (localbffx.b) {
            bffs.a().a(localbffx.a);
          }
        }
        else if ((localDownloadInfo.a() == 3) && (!localbffx.b) && (!localbffx.c))
        {
          bffs.a().a(null, localbffx);
          continue;
          if (this.a == 1)
          {
            localIterator = bffr.a(this.this$0).values().iterator();
            while (localIterator.hasNext())
            {
              localbffx = (bffx)localIterator.next();
              localDownloadInfo = bffi.a().a(localbffx.a);
              if ((localDownloadInfo != null) && (localDownloadInfo.a() == 3) && (!localbffx.c)) {
                bffs.a().a(null, localbffx);
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