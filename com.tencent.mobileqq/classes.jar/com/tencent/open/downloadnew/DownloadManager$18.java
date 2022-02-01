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
      if (!CommonDataAdapter.a().a().getSharedPreferences("opensdk_config", 0).getBoolean("download_clear_unuse", false))
      {
        Iterator localIterator = this.this$0.a.values().iterator();
        Object localObject;
        while (localIterator.hasNext())
        {
          DownloadInfo localDownloadInfo = (DownloadInfo)localIterator.next();
          if (localDownloadInfo.jdField_c_of_type_Int == 0)
          {
            if (localDownloadInfo.a == 0) {
              localObject = localDownloadInfo.d;
            } else {
              localObject = localDownloadInfo.i;
            }
            if (this.this$0.a((String)localObject) == null)
            {
              this.this$0.a.remove(localDownloadInfo.jdField_c_of_type_JavaLangString);
              DownloadDBHelper.a().a(localDownloadInfo.jdField_c_of_type_JavaLangString);
            }
          }
          else if (this.this$0.a(localDownloadInfo) == null)
          {
            this.this$0.a.remove(localDownloadInfo.jdField_c_of_type_JavaLangString);
            DownloadDBHelper.a().a(localDownloadInfo.jdField_c_of_type_JavaLangString);
          }
        }
        if (this.this$0.a.size() > 200)
        {
          localObject = CommonDataAdapter.a().a().getSharedPreferences("opensdk_config", 0).edit();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadManager.18
 * JD-Core Version:    0.7.0.1
 */