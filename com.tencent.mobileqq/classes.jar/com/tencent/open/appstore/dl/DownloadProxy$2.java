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
    DownloadManagerV2.a().a();
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
          DownloadInfo localDownloadInfo = (DownloadInfo)this.jdField_a_of_type_JavaUtilList.get(i);
          if (DownloadManagerV2.a().b(localDownloadInfo))
          {
            LogUtility.b("DownloadResolver", "[queryByDownloadManagerV2] refreshDownloadInfo true " + localDownloadInfo);
            localArrayList.add(localDownloadInfo);
          }
        }
        else
        {
          if (this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadQueryListener != null) {
            this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadQueryListener.a(localArrayList);
          }
          return;
        }
      }
      catch (Exception localException)
      {
        LogUtility.c("DownloadResolver", "[queryByDownloadManagerV2] Exception>>>", localException);
        if (this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadQueryListener == null) {
          continue;
        }
        this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadQueryListener.a(-1, localException.getMessage());
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadProxy.2
 * JD-Core Version:    0.7.0.1
 */