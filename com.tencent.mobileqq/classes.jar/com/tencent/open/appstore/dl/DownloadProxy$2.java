package com.tencent.open.appstore.dl;

import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadQueryListener;
import java.util.ArrayList;
import java.util.List;

class DownloadProxy$2
  implements Runnable
{
  DownloadProxy$2(DownloadProxy paramDownloadProxy, List paramList, DownloadQueryListener paramDownloadQueryListener) {}
  
  public void run()
  {
    LogUtility.b("DownloadResolver", "[queryByDownloadManagerV2] enter");
    DownloadManagerV2.a().b();
    for (;;)
    {
      int i;
      try
      {
        ArrayList localArrayList = new ArrayList();
        int j = this.a.size();
        i = 0;
        if (i < j)
        {
          localObject = (DownloadInfo)this.a.get(i);
          if (!DownloadManagerV2.a().i((DownloadInfo)localObject)) {
            break label162;
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("[queryByDownloadManagerV2] refreshDownloadInfo true ");
          localStringBuilder.append(localObject);
          LogUtility.b("DownloadResolver", localStringBuilder.toString());
          localArrayList.add(localObject);
          break label162;
        }
        if (this.b != null)
        {
          this.b.a(localArrayList);
          return;
        }
      }
      catch (Exception localException)
      {
        LogUtility.c("DownloadResolver", "[queryByDownloadManagerV2] Exception>>>", localException);
        Object localObject = this.b;
        if (localObject != null) {
          ((DownloadQueryListener)localObject).a(-1, localException.getMessage());
        }
      }
      return;
      label162:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadProxy.2
 * JD-Core Version:    0.7.0.1
 */