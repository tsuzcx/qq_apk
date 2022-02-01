package com.tencent.open.downloadnew;

import bhzm;
import bibs;
import biby;
import bicf;
import java.util.ArrayList;
import java.util.List;

public final class DownloadApi$5
  implements Runnable
{
  public DownloadApi$5(List paramList, bicf parambicf) {}
  
  public void run()
  {
    bhzm.a(bibs.a, "getQueryDownloadAction enter");
    biby.a().a();
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
          if (biby.a().a(localDownloadInfo))
          {
            bhzm.a(bibs.a, "refreshDownloadInfo true " + localDownloadInfo);
            localArrayList.add(localDownloadInfo);
          }
        }
        else
        {
          if (this.jdField_a_of_type_Bicf != null) {
            this.jdField_a_of_type_Bicf.a(localArrayList);
          }
          return;
        }
      }
      catch (Exception localException)
      {
        bhzm.c(bibs.a, "Exception>>>", localException);
        if (this.jdField_a_of_type_Bicf == null) {
          continue;
        }
        this.jdField_a_of_type_Bicf.a(-1, localException.getMessage());
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadApi.5
 * JD-Core Version:    0.7.0.1
 */