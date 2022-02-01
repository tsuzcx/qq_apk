package com.tencent.open.downloadnew;

import bjko;
import bjmu;
import bjna;
import bjnh;
import java.util.ArrayList;
import java.util.List;

public final class DownloadApi$5
  implements Runnable
{
  public DownloadApi$5(List paramList, bjnh parambjnh) {}
  
  public void run()
  {
    bjko.a(bjmu.a, "getQueryDownloadAction enter");
    bjna.a().a();
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
          if (bjna.a().a(localDownloadInfo))
          {
            bjko.a(bjmu.a, "refreshDownloadInfo true " + localDownloadInfo);
            localArrayList.add(localDownloadInfo);
          }
        }
        else
        {
          if (this.jdField_a_of_type_Bjnh != null) {
            this.jdField_a_of_type_Bjnh.a(localArrayList);
          }
          return;
        }
      }
      catch (Exception localException)
      {
        bjko.c(bjmu.a, "Exception>>>", localException);
        if (this.jdField_a_of_type_Bjnh == null) {
          continue;
        }
        this.jdField_a_of_type_Bjnh.a(-1, localException.getMessage());
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