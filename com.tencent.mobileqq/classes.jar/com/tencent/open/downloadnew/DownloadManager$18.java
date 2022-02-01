package com.tencent.open.downloadnew;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import bhpc;
import bhzm;
import biby;
import bidn;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class DownloadManager$18
  implements Runnable
{
  public DownloadManager$18(biby parambiby) {}
  
  public void run()
  {
    DownloadInfo localDownloadInfo;
    try
    {
      if (!bhpc.a().a().getSharedPreferences("opensdk_config", 0).getBoolean("download_clear_unuse", false))
      {
        Iterator localIterator = this.this$0.a.values().iterator();
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label173;
          }
          localDownloadInfo = (DownloadInfo)localIterator.next();
          if (localDownloadInfo.jdField_c_of_type_Int != 0) {
            break label134;
          }
          if (localDownloadInfo.a != 0) {
            break;
          }
          String str = localDownloadInfo.d;
          label77:
          if (this.this$0.a(str) == null)
          {
            this.this$0.a.remove(localDownloadInfo.jdField_c_of_type_JavaLangString);
            bidn.a().a(localDownloadInfo.jdField_c_of_type_JavaLangString);
          }
        }
      }
      return;
    }
    catch (Exception localException)
    {
      bhzm.c("DownloadManager_", "checkDownloadList>>>", localException);
    }
    label134:
    label173:
    do
    {
      localObject = localDownloadInfo.i;
      break label77;
      if (this.this$0.a(localDownloadInfo) != null) {
        break;
      }
      this.this$0.a.remove(localDownloadInfo.jdField_c_of_type_JavaLangString);
      bidn.a().a(localDownloadInfo.jdField_c_of_type_JavaLangString);
      break;
    } while (this.this$0.a.size() <= 200);
    Object localObject = bhpc.a().a().getSharedPreferences("opensdk_config", 0).edit();
    ((SharedPreferences.Editor)localObject).putBoolean("download_clear_unuse", true);
    ((SharedPreferences.Editor)localObject).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadManager.18
 * JD-Core Version:    0.7.0.1
 */