package com.tencent.open.appstore.dl;

import bisa;
import bise;
import bisy;
import bivy;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.ArrayList;
import java.util.List;

public class DownloadProxy$2
  implements Runnable
{
  public DownloadProxy$2(bise parambise, List paramList, bivy parambivy) {}
  
  public void run()
  {
    bisy.b("DownloadResolver", "[queryByDownloadManagerV2] enter");
    bisa.a().a();
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
          if (bisa.a().b(localDownloadInfo))
          {
            bisy.b("DownloadResolver", "[queryByDownloadManagerV2] refreshDownloadInfo true " + localDownloadInfo);
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
        bisy.c("DownloadResolver", "[queryByDownloadManagerV2] Exception>>>", localException);
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
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadProxy.2
 * JD-Core Version:    0.7.0.1
 */