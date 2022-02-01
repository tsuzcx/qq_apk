package com.tencent.open.appstore.dl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

class DownloadManagerV2$20
  implements Runnable
{
  DownloadManagerV2$20(DownloadManagerV2 paramDownloadManagerV2) {}
  
  public void run()
  {
    try
    {
      if (!CommonDataAdapter.a().b().getSharedPreferences("opensdk_config_DownloadManagerV2", 0).getBoolean("download_clear_unuse", false))
      {
        Iterator localIterator = DownloadManagerV2.c(this.this$0).values().iterator();
        Object localObject;
        while (localIterator.hasNext())
        {
          DownloadInfo localDownloadInfo = (DownloadInfo)localIterator.next();
          if (localDownloadInfo.o == 0)
          {
            if (localDownloadInfo.j == 0) {
              localObject = localDownloadInfo.d;
            } else {
              localObject = localDownloadInfo.k;
            }
            if (this.this$0.g((String)localObject) == null) {
              DownloadManagerV2.a(this.this$0, localDownloadInfo);
            }
          }
          else if (this.this$0.c(localDownloadInfo) == null)
          {
            DownloadManagerV2.a(this.this$0, localDownloadInfo);
          }
        }
        if (DownloadManagerV2.c(this.this$0).size() > 200)
        {
          localObject = CommonDataAdapter.a().b().getSharedPreferences("opensdk_config_DownloadManagerV2", 0).edit();
          ((SharedPreferences.Editor)localObject).putBoolean("download_clear_unuse", true);
          ((SharedPreferences.Editor)localObject).apply();
          return;
        }
      }
    }
    catch (Exception localException)
    {
      LogUtility.c("DownloadManagerV2", "checkDownloadList>>>", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadManagerV2.20
 * JD-Core Version:    0.7.0.1
 */