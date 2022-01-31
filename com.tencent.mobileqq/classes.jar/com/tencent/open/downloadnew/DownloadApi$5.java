package com.tencent.open.downloadnew;

import bdht;
import bdki;
import bdkp;
import bdkw;
import java.util.ArrayList;
import java.util.List;

public final class DownloadApi$5
  implements Runnable
{
  public DownloadApi$5(List paramList, bdkw parambdkw) {}
  
  public void run()
  {
    bdht.a(bdki.a, "getQueryDownloadAction enter");
    bdkp.a().a();
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
          if (bdkp.a().a(localDownloadInfo))
          {
            bdht.a(bdki.a, "refreshDownloadInfo true " + localDownloadInfo);
            localArrayList.add(localDownloadInfo);
          }
        }
        else
        {
          if (this.jdField_a_of_type_Bdkw != null) {
            this.jdField_a_of_type_Bdkw.a(localArrayList);
          }
          return;
        }
      }
      catch (Exception localException)
      {
        bdht.c(bdki.a, "Exception>>>", localException);
        if (this.jdField_a_of_type_Bdkw == null) {
          continue;
        }
        this.jdField_a_of_type_Bdkw.a(-1, localException.getMessage());
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