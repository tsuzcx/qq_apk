package com.tencent.open.downloadnew;

import bisy;
import bivl;
import bivr;
import bivy;
import java.util.ArrayList;
import java.util.List;

public final class DownloadApi$5
  implements Runnable
{
  public DownloadApi$5(List paramList, bivy parambivy) {}
  
  public void run()
  {
    bisy.a(bivl.a, "getQueryDownloadAction enter");
    bivr.a().a();
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
          if (bivr.a().a(localDownloadInfo))
          {
            bisy.a(bivl.a, "refreshDownloadInfo true " + localDownloadInfo);
            localArrayList.add(localDownloadInfo);
          }
        }
        else
        {
          if (this.jdField_a_of_type_Bivy != null) {
            this.jdField_a_of_type_Bivy.a(localArrayList);
          }
          return;
        }
      }
      catch (Exception localException)
      {
        bisy.c(bivl.a, "Exception>>>", localException);
        if (this.jdField_a_of_type_Bivy == null) {
          continue;
        }
        this.jdField_a_of_type_Bivy.a(-1, localException.getMessage());
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