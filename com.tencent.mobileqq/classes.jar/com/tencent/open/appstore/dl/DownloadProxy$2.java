package com.tencent.open.appstore.dl;

import bfkr;
import bfkv;
import bflp;
import bfor;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.ArrayList;
import java.util.List;

public class DownloadProxy$2
  implements Runnable
{
  public DownloadProxy$2(bfkv parambfkv, List paramList, bfor parambfor) {}
  
  public void run()
  {
    bflp.b("DownloadResolver", "[queryByDownloadManagerV2] enter");
    bfkr.a().a();
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
          if (bfkr.a().b(localDownloadInfo))
          {
            bflp.b("DownloadResolver", "[queryByDownloadManagerV2] refreshDownloadInfo true " + localDownloadInfo);
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
        bflp.c("DownloadResolver", "[queryByDownloadManagerV2] Exception>>>", localException);
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
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadProxy.2
 * JD-Core Version:    0.7.0.1
 */