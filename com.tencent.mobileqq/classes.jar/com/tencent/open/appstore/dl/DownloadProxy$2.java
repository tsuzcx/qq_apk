package com.tencent.open.appstore.dl;

import bfgi;
import bfgm;
import bfhg;
import bfki;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.ArrayList;
import java.util.List;

public class DownloadProxy$2
  implements Runnable
{
  public DownloadProxy$2(bfgm parambfgm, List paramList, bfki parambfki) {}
  
  public void run()
  {
    bfhg.b("DownloadResolver", "[queryByDownloadManagerV2] enter");
    bfgi.a().a();
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
          if (bfgi.a().b(localDownloadInfo))
          {
            bfhg.b("DownloadResolver", "[queryByDownloadManagerV2] refreshDownloadInfo true " + localDownloadInfo);
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
        bfhg.c("DownloadResolver", "[queryByDownloadManagerV2] Exception>>>", localException);
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
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadProxy.2
 * JD-Core Version:    0.7.0.1
 */