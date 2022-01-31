package com.tencent.open.appstore.dl;

import bccu;
import bccy;
import bcds;
import bcgv;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.ArrayList;
import java.util.List;

public class DownloadProxy$2
  implements Runnable
{
  public DownloadProxy$2(bccy parambccy, List paramList, bcgv parambcgv) {}
  
  public void run()
  {
    bcds.b("DownloadResolver", "[queryByDownloadManagerV2] enter");
    bccu.a().a();
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
          if (bccu.a().a(localDownloadInfo))
          {
            bcds.b("DownloadResolver", "[queryByDownloadManagerV2] refreshDownloadInfo true " + localDownloadInfo);
            localArrayList.add(localDownloadInfo);
          }
        }
        else
        {
          if (this.jdField_a_of_type_Bcgv != null) {
            this.jdField_a_of_type_Bcgv.a(localArrayList);
          }
          return;
        }
      }
      catch (Exception localException)
      {
        bcds.c("DownloadResolver", "[queryByDownloadManagerV2] Exception>>>", localException);
        if (this.jdField_a_of_type_Bcgv == null) {
          continue;
        }
        this.jdField_a_of_type_Bcgv.a(-1, localException.getMessage());
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadProxy.2
 * JD-Core Version:    0.7.0.1
 */