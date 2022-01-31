package com.tencent.open.appstore.dl;

import bdhk;
import bdho;
import bdii;
import bdll;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.ArrayList;
import java.util.List;

public class DownloadProxy$2
  implements Runnable
{
  public DownloadProxy$2(bdho parambdho, List paramList, bdll parambdll) {}
  
  public void run()
  {
    bdii.b("DownloadResolver", "[queryByDownloadManagerV2] enter");
    bdhk.a().a();
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
          if (bdhk.a().b(localDownloadInfo))
          {
            bdii.b("DownloadResolver", "[queryByDownloadManagerV2] refreshDownloadInfo true " + localDownloadInfo);
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
        bdii.c("DownloadResolver", "[queryByDownloadManagerV2] Exception>>>", localException);
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
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadProxy.2
 * JD-Core Version:    0.7.0.1
 */