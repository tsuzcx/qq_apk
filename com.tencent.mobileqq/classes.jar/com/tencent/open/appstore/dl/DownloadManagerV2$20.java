package com.tencent.open.appstore.dl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import bfbm;
import bfkr;
import bflp;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class DownloadManagerV2$20
  implements Runnable
{
  public DownloadManagerV2$20(bfkr parambfkr) {}
  
  public void run()
  {
    DownloadInfo localDownloadInfo;
    try
    {
      if (!bfbm.a().a().getSharedPreferences("opensdk_config_DownloadManagerV2", 0).getBoolean("download_clear_unuse", false))
      {
        Iterator localIterator = bfkr.a(this.this$0).values().iterator();
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label139;
          }
          localDownloadInfo = (DownloadInfo)localIterator.next();
          if (localDownloadInfo.c != 0) {
            break label117;
          }
          if (localDownloadInfo.a != 0) {
            break;
          }
          String str = localDownloadInfo.d;
          label77:
          if (this.this$0.a(str) == null) {
            bfkr.a(this.this$0, localDownloadInfo);
          }
        }
      }
      return;
    }
    catch (Exception localException)
    {
      bflp.c("DownloadManagerV2", "checkDownloadList>>>", localException);
    }
    label117:
    do
    {
      localObject = localDownloadInfo.i;
      break label77;
      if (this.this$0.a(localDownloadInfo) != null) {
        break;
      }
      bfkr.a(this.this$0, localDownloadInfo);
      break;
    } while (bfkr.a(this.this$0).size() <= 200);
    label139:
    Object localObject = bfbm.a().a().getSharedPreferences("opensdk_config_DownloadManagerV2", 0).edit();
    ((SharedPreferences.Editor)localObject).putBoolean("download_clear_unuse", true);
    ((SharedPreferences.Editor)localObject).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadManagerV2.20
 * JD-Core Version:    0.7.0.1
 */