package com.tencent.mobileqq.intervideo;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.intervideo.groupvideo.IVPluginDataReporter;
import com.tencent.mobileqq.intervideo.huayang.Monitor;
import com.tencent.mobileqq.intervideo.now.DownloadEngine.IDownloadListener;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.CountDownLatch;

class CdnPmUpdater$2
  implements IDownloadListener
{
  CdnPmUpdater$2(CdnPmUpdater paramCdnPmUpdater, File paramFile, Exception[] paramArrayOfException, long paramLong, CountDownLatch paramCountDownLatch) {}
  
  public void a()
  {
    QLog.d("shadow::CdnPmUpdater", 1, " download cdn success");
    Object localObject;
    if (!CdnPmUpdater.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoCdnPmUpdater).renameTo(this.jdField_a_of_type_JavaIoFile))
    {
      localObject = this.jdField_a_of_type_ArrayOfJavaLangException;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131701681));
      localStringBuilder.append(this.jdField_a_of_type_JavaIoFile.getAbsolutePath());
      localObject[0] = new RuntimeException(localStringBuilder.toString());
    }
    if (CdnPmUpdater.b(this.jdField_a_of_type_ComTencentMobileqqIntervideoCdnPmUpdater)) {
      localObject = "33669797";
    } else {
      localObject = "33669802";
    }
    Monitor.b((String)localObject);
    CdnPmUpdater.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoCdnPmUpdater).opType("onDownloadComplete").opResult((int)(System.currentTimeMillis() - this.jdField_a_of_type_Long)).report();
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
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append(" onDownloadFailed retCode =  ");
      paramString.append(paramInt1);
      QLog.d("shadow::CdnPmUpdater", 2, paramString.toString());
    }
    if (CdnPmUpdater.b(this.jdField_a_of_type_ComTencentMobileqqIntervideoCdnPmUpdater)) {
      paramString = "33669798";
    } else {
      paramString = "33669803";
    }
    Monitor.b(paramString);
    CdnPmUpdater.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoCdnPmUpdater).opType("onDownloadFailed").opResult((int)(System.currentTimeMillis() - this.jdField_a_of_type_Long)).report();
    this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.countDown();
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.CdnPmUpdater.2
 * JD-Core Version:    0.7.0.1
 */