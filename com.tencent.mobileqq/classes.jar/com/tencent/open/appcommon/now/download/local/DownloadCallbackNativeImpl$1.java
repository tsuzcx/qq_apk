package com.tencent.open.appcommon.now.download.local;

import bhxo;
import bhxx;
import bhxy;
import bhyd;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class DownloadCallbackNativeImpl$1
  implements Runnable
{
  public DownloadCallbackNativeImpl$1(bhxx parambhxx, int paramInt) {}
  
  public void run()
  {
    Iterator localIterator;
    if ((this.a == 4) || (this.a == 3) || (this.a == 2)) {
      localIterator = bhxx.a(this.this$0).values().iterator();
    }
    while (localIterator.hasNext())
    {
      bhyd localbhyd = (bhyd)localIterator.next();
      DownloadInfo localDownloadInfo = bhxo.a().a(localbhyd.a);
      if (localDownloadInfo != null) {
        if (localDownloadInfo.a() == 2)
        {
          if (localbhyd.b) {
            bhxy.a().a(localbhyd.a);
          }
        }
        else if ((localDownloadInfo.a() == 3) && (!localbhyd.b) && (!localbhyd.c))
        {
          bhxy.a().a(null, localbhyd);
          continue;
          if (this.a == 1)
          {
            localIterator = bhxx.a(this.this$0).values().iterator();
            while (localIterator.hasNext())
            {
              localbhyd = (bhyd)localIterator.next();
              localDownloadInfo = bhxo.a().a(localbhyd.a);
              if ((localDownloadInfo != null) && (localDownloadInfo.a() == 3) && (!localbhyd.c)) {
                bhxy.a().a(null, localbhyd);
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