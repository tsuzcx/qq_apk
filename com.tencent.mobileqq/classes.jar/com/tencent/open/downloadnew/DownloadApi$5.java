package com.tencent.open.downloadnew;

import bfhg;
import bfju;
import bfkb;
import bfki;
import java.util.ArrayList;
import java.util.List;

public final class DownloadApi$5
  implements Runnable
{
  public DownloadApi$5(List paramList, bfki parambfki) {}
  
  public void run()
  {
    bfhg.a(bfju.a, "getQueryDownloadAction enter");
    bfkb.a().a();
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
          if (bfkb.a().a(localDownloadInfo))
          {
            bfhg.a(bfju.a, "refreshDownloadInfo true " + localDownloadInfo);
            localArrayList.add(localDownloadInfo);
          }
        }
        else
        {
          if (this.jdField_a_of_type_Bfki != null) {
            this.jdField_a_of_type_Bfki.a(localArrayList);
          }
          return;
        }
      }
      catch (Exception localException)
      {
        bfhg.c(bfju.a, "Exception>>>", localException);
        if (this.jdField_a_of_type_Bfki == null) {
          continue;
        }
        this.jdField_a_of_type_Bfki.a(-1, localException.getMessage());
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