package com.tencent.open.downloadnew;

import com.tencent.open.base.LogUtility;
import java.util.ArrayList;
import java.util.List;

final class DownloadApi$5
  implements Runnable
{
  DownloadApi$5(List paramList, DownloadQueryListener paramDownloadQueryListener) {}
  
  public void run()
  {
    LogUtility.a(DownloadApi.a, "getQueryDownloadAction enter");
    DownloadManager.a().a();
    for (;;)
    {
      int i;
      try
      {
        ArrayList localArrayList = new ArrayList();
        int j = this.jdField_a_of_type_JavaUtilList.size();
        i = 0;
        if (i < j)
        {
          localObject = (DownloadInfo)this.jdField_a_of_type_JavaUtilList.get(i);
          if (!DownloadManager.a().a((DownloadInfo)localObject)) {
            break label169;
          }
          String str = DownloadApi.a;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("refreshDownloadInfo true ");
          localStringBuilder.append(localObject);
          LogUtility.a(str, localStringBuilder.toString());
          localArrayList.add(localObject);
          break label169;
        }
        if (this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadQueryListener != null)
        {
          this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadQueryListener.a(localArrayList);
          return;
        }
      }
      catch (Exception localException)
      {
        LogUtility.c(DownloadApi.a, "Exception>>>", localException);
        Object localObject = this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadQueryListener;
        if (localObject != null) {
          ((DownloadQueryListener)localObject).a(-1, localException.getMessage());
        }
      }
      return;
      label169:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadApi.5
 * JD-Core Version:    0.7.0.1
 */