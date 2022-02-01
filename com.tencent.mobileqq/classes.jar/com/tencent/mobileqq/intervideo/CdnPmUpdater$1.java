package com.tencent.mobileqq.intervideo;

import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.Callable;

class CdnPmUpdater$1
  implements Callable<File>
{
  CdnPmUpdater$1(CdnPmUpdater paramCdnPmUpdater) {}
  
  public File a()
  {
    try
    {
      boolean bool = CdnPmUpdater.a(this.a);
      Object localObject1;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("isNeedDownload:");
        ((StringBuilder)localObject1).append(bool);
        QLog.i("shadow::CdnPmUpdater", 2, ((StringBuilder)localObject1).toString());
      }
      if (!bool) {
        localObject1 = this.a.getLatest();
      }
      for (;;)
      {
        CdnPmUpdater.a(this.a, false);
        return localObject1;
        File localFile = this.a.a();
        localObject1 = localFile;
        if (CdnPmUpdater.b(this.a) != null)
        {
          CdnPmUpdater.b(this.a).a();
          localObject1 = localFile;
        }
      }
      throw localObject2;
    }
    finally
    {
      CdnPmUpdater.a(this.a, false);
    }
    for (;;) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.CdnPmUpdater.1
 * JD-Core Version:    0.7.0.1
 */