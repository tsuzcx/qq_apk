package com.tencent.mobileqq.studyroom.updater;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.studyroom.download.IDownloadListener;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.CountDownLatch;

class CdnPmUpdater$3
  implements IDownloadListener
{
  CdnPmUpdater$3(CdnPmUpdater paramCdnPmUpdater, File paramFile, Exception[] paramArrayOfException, CountDownLatch paramCountDownLatch) {}
  
  public void a()
  {
    QLog.d("studyroom.CdnPmUpdater", 1, " download cdn success");
    if (!CdnPmUpdater.a(this.jdField_a_of_type_ComTencentMobileqqStudyroomUpdaterCdnPmUpdater).renameTo(this.jdField_a_of_type_JavaIoFile))
    {
      Exception[] arrayOfException = this.jdField_a_of_type_ArrayOfJavaLangException;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131701681));
      localStringBuilder.append(this.jdField_a_of_type_JavaIoFile.getAbsolutePath());
      arrayOfException[0] = new RuntimeException(localStringBuilder.toString());
    }
    this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.countDown();
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    Exception[] arrayOfException = this.jdField_a_of_type_ArrayOfJavaLangException;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("下载失败 retcode:");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" httpCode:");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(" err:");
    localStringBuilder.append(paramString);
    arrayOfException[0] = new Exception(localStringBuilder.toString());
    if (QLog.isColorLevel()) {
      QLog.d("studyroom.CdnPmUpdater", 2, " onDownloadFailed ");
    }
    this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.countDown();
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.updater.CdnPmUpdater.3
 * JD-Core Version:    0.7.0.1
 */