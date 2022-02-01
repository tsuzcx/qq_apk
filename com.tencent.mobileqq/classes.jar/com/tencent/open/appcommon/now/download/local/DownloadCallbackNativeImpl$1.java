package com.tencent.open.appcommon.now.download.local;

import com.tencent.open.appcommon.now.download.DownloadCenterImpl;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

class DownloadCallbackNativeImpl$1
  implements Runnable
{
  DownloadCallbackNativeImpl$1(DownloadCallbackNativeImpl paramDownloadCallbackNativeImpl, int paramInt) {}
  
  public void run()
  {
    int i = this.a;
    Iterator localIterator;
    if ((i != 4) && (i != 3) && (i != 2))
    {
      if (i == 1) {
        localIterator = DownloadCallbackNativeImpl.a(this.this$0).values().iterator();
      }
    }
    else {
      while (localIterator.hasNext())
      {
        DownloadTaskInfo localDownloadTaskInfo = (DownloadTaskInfo)localIterator.next();
        DownloadInfo localDownloadInfo = DownloadCenterImpl.a().a(localDownloadTaskInfo.a);
        if ((localDownloadInfo != null) && (localDownloadInfo.a() == 3) && (!localDownloadTaskInfo.c))
        {
          DownloadNativeApi.a().a(null, localDownloadTaskInfo);
          continue;
          localIterator = DownloadCallbackNativeImpl.a(this.this$0).values().iterator();
          while (localIterator.hasNext())
          {
            localDownloadTaskInfo = (DownloadTaskInfo)localIterator.next();
            localDownloadInfo = DownloadCenterImpl.a().a(localDownloadTaskInfo.a);
            if (localDownloadInfo != null) {
              if (localDownloadInfo.a() == 2)
              {
                if (localDownloadTaskInfo.b) {
                  DownloadNativeApi.a().a(localDownloadTaskInfo.a);
                }
              }
              else if ((localDownloadInfo.a() == 3) && (!localDownloadTaskInfo.b) && (!localDownloadTaskInfo.c)) {
                DownloadNativeApi.a().a(null, localDownloadTaskInfo);
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