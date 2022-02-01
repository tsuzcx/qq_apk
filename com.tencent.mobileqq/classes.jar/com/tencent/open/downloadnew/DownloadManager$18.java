package com.tencent.open.downloadnew;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.common.DownloadDBHelper;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

class DownloadManager$18
  implements Runnable
{
  DownloadManager$18(DownloadManager paramDownloadManager) {}
  
  public void run()
  {
    try
    {
      if (!CommonDataAdapter.a().b().getSharedPreferences("opensdk_config", 0).getBoolean("download_clear_unuse", false))
      {
        Iterator localIterator = this.this$0.g.values().iterator();
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
            if (this.this$0.h((String)localObject) == null)
            {
              this.this$0.g.remove(localDownloadInfo.c);
              DownloadDBHelper.a().b(localDownloadInfo.c);
            }
          }
          else if (this.this$0.c(localDownloadInfo) == null)
          {
            this.this$0.g.remove(localDownloadInfo.c);
            DownloadDBHelper.a().b(localDownloadInfo.c);
          }
        }
        if (this.this$0.g.size() > 200)
        {
          localObject = CommonDataAdapter.a().b().getSharedPreferences("opensdk_config", 0).edit();
          ((SharedPreferences.Editor)localObject).putBoolean("download_clear_unuse", true);
          ((SharedPreferences.Editor)localObject).commit();
          return;
        }
      }
    }
    catch (Exception localException)
    {
      LogUtility.c("DownloadManager_", "checkDownloadList>>>", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadManager.18
 * JD-Core Version:    0.7.0.1
 */