package com.tencent.open.downloadnew;

import bflp;
import bfod;
import bfok;
import bfor;
import java.util.ArrayList;
import java.util.List;

public final class DownloadApi$5
  implements Runnable
{
  public DownloadApi$5(List paramList, bfor parambfor) {}
  
  public void run()
  {
    bflp.a(bfod.a, "getQueryDownloadAction enter");
    bfok.a().a();
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
          if (bfok.a().a(localDownloadInfo))
          {
            bflp.a(bfod.a, "refreshDownloadInfo true " + localDownloadInfo);
            localArrayList.add(localDownloadInfo);
          }
        }
        else
        {
          if (this.jdField_a_of_type_Bfor != null) {
            this.jdField_a_of_type_Bfor.a(localArrayList);
          }
          return;
        }
      }
      catch (Exception localException)
      {
        bflp.c(bfod.a, "Exception>>>", localException);
        if (this.jdField_a_of_type_Bfor == null) {
          continue;
        }
        this.jdField_a_of_type_Bfor.a(-1, localException.getMessage());
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