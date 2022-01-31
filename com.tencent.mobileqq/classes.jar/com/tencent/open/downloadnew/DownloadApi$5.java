package com.tencent.open.downloadnew;

import bdii;
import bdkx;
import bdle;
import bdll;
import java.util.ArrayList;
import java.util.List;

public final class DownloadApi$5
  implements Runnable
{
  public DownloadApi$5(List paramList, bdll parambdll) {}
  
  public void run()
  {
    bdii.a(bdkx.a, "getQueryDownloadAction enter");
    bdle.a().a();
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
          if (bdle.a().a(localDownloadInfo))
          {
            bdii.a(bdkx.a, "refreshDownloadInfo true " + localDownloadInfo);
            localArrayList.add(localDownloadInfo);
          }
        }
        else
        {
          if (this.jdField_a_of_type_Bdll != null) {
            this.jdField_a_of_type_Bdll.a(localArrayList);
          }
          return;
        }
      }
      catch (Exception localException)
      {
        bdii.c(bdkx.a, "Exception>>>", localException);
        if (this.jdField_a_of_type_Bdll == null) {
          continue;
        }
        this.jdField_a_of_type_Bdll.a(-1, localException.getMessage());
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