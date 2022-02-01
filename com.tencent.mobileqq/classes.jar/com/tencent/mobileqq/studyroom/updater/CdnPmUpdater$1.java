package com.tencent.mobileqq.studyroom.updater;

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
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("isNeedDownload:");
        ((StringBuilder)localObject1).append(bool);
        QLog.i("studyroom.CdnPmUpdater", 2, ((StringBuilder)localObject1).toString());
      }
      if (!bool) {}
      for (Object localObject1 = this.a.getLatest();; localObject1 = this.a.a())
      {
        CdnPmUpdater.a(this.a, false);
        return localObject1;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.updater.CdnPmUpdater.1
 * JD-Core Version:    0.7.0.1
 */