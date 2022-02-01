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
      if (QLog.isColorLevel()) {
        QLog.i("studyroom.CdnPmUpdater", 2, "isNeedDownload:" + bool);
      }
      if (!bool)
      {
        localFile = this.a.getLatest();
        return localFile;
      }
      File localFile = this.a.a();
      return localFile;
    }
    finally
    {
      CdnPmUpdater.a(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.updater.CdnPmUpdater.1
 * JD-Core Version:    0.7.0.1
 */