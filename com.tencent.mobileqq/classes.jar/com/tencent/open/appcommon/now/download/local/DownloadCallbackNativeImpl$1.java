package com.tencent.open.appcommon.now.download.local;

import bjrz;
import bjsi;
import bjsj;
import bjso;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class DownloadCallbackNativeImpl$1
  implements Runnable
{
  public DownloadCallbackNativeImpl$1(bjsi parambjsi, int paramInt) {}
  
  public void run()
  {
    Iterator localIterator;
    if ((this.a == 4) || (this.a == 3) || (this.a == 2)) {
      localIterator = bjsi.a(this.this$0).values().iterator();
    }
    while (localIterator.hasNext())
    {
      bjso localbjso = (bjso)localIterator.next();
      DownloadInfo localDownloadInfo = bjrz.a().a(localbjso.a);
      if (localDownloadInfo != null) {
        if (localDownloadInfo.a() == 2)
        {
          if (localbjso.b) {
            bjsj.a().a(localbjso.a);
          }
        }
        else if ((localDownloadInfo.a() == 3) && (!localbjso.b) && (!localbjso.c))
        {
          bjsj.a().a(null, localbjso);
          continue;
          if (this.a == 1)
          {
            localIterator = bjsi.a(this.this$0).values().iterator();
            while (localIterator.hasNext())
            {
              localbjso = (bjso)localIterator.next();
              localDownloadInfo = bjrz.a().a(localbjso.a);
              if ((localDownloadInfo != null) && (localDownloadInfo.a() == 3) && (!localbjso.c)) {
                bjsj.a().a(null, localbjso);
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