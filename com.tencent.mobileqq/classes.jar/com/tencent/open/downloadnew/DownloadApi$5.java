package com.tencent.open.downloadnew;

import bjtx;
import bjwk;
import bjwq;
import bjwx;
import java.util.ArrayList;
import java.util.List;

public final class DownloadApi$5
  implements Runnable
{
  public DownloadApi$5(List paramList, bjwx parambjwx) {}
  
  public void run()
  {
    bjtx.a(bjwk.a, "getQueryDownloadAction enter");
    bjwq.a().a();
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
          if (bjwq.a().a(localDownloadInfo))
          {
            bjtx.a(bjwk.a, "refreshDownloadInfo true " + localDownloadInfo);
            localArrayList.add(localDownloadInfo);
          }
        }
        else
        {
          if (this.jdField_a_of_type_Bjwx != null) {
            this.jdField_a_of_type_Bjwx.a(localArrayList);
          }
          return;
        }
      }
      catch (Exception localException)
      {
        bjtx.c(bjwk.a, "Exception>>>", localException);
        if (this.jdField_a_of_type_Bjwx == null) {
          continue;
        }
        this.jdField_a_of_type_Bjwx.a(-1, localException.getMessage());
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