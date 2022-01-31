package com.tencent.open.downloadnew;

import bcds;
import bcgh;
import bcgo;
import bcgv;
import java.util.ArrayList;
import java.util.List;

public final class DownloadApi$5
  implements Runnable
{
  public DownloadApi$5(List paramList, bcgv parambcgv) {}
  
  public void run()
  {
    bcds.a(bcgh.a, "getQueryDownloadAction enter");
    bcgo.a().a();
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
          if (bcgo.a().a(localDownloadInfo))
          {
            bcds.a(bcgh.a, "refreshDownloadInfo true " + localDownloadInfo);
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
        bcds.c(bcgh.a, "Exception>>>", localException);
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
 * Qualified Name:     com.tencent.open.downloadnew.DownloadApi.5
 * JD-Core Version:    0.7.0.1
 */