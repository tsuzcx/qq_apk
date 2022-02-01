package com.tencent.open.appstore.dl;

import bhyo;
import bhys;
import bhzm;
import bicf;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.ArrayList;
import java.util.List;

public class DownloadProxy$2
  implements Runnable
{
  public DownloadProxy$2(bhys parambhys, List paramList, bicf parambicf) {}
  
  public void run()
  {
    bhzm.b("DownloadResolver", "[queryByDownloadManagerV2] enter");
    bhyo.a().a();
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
          if (bhyo.a().b(localDownloadInfo))
          {
            bhzm.b("DownloadResolver", "[queryByDownloadManagerV2] refreshDownloadInfo true " + localDownloadInfo);
            localArrayList.add(localDownloadInfo);
          }
        }
        else
        {
          if (this.jdField_a_of_type_Bicf != null) {
            this.jdField_a_of_type_Bicf.a(localArrayList);
          }
          return;
        }
      }
      catch (Exception localException)
      {
        bhzm.c("DownloadResolver", "[queryByDownloadManagerV2] Exception>>>", localException);
        if (this.jdField_a_of_type_Bicf == null) {
          continue;
        }
        this.jdField_a_of_type_Bicf.a(-1, localException.getMessage());
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