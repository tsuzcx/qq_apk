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
    if (!CdnPmUpdater.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoCdnPmUpdater).renameTo(this.jdField_a_of_type_JavaIoFile)) {
      this.jdField_a_of_type_ArrayOfJavaLangException[0] = new RuntimeException(HardCodeUtil.a(2131701541) + this.jdField_a_of_type_JavaIoFile.getAbsolutePath());
    }
    if (CdnPmUpdater.b(this.jdField_a_of_type_ComTencentMobileqqIntervideoCdnPmUpdater)) {}
    for (String str = "33669797";; str = "33669802")
    {
      Monitor.b(str);
      CdnPmUpdater.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoCdnPmUpdater).opType("onDownloadComplete").opResult((int)(System.currentTimeMillis() - this.jdField_a_of_type_Long)).report();
      this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.countDown();
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    this.jdField_a_of_type_ArrayOfJavaLangException[0] = new Exception("下载失败 retcode:" + paramInt1 + " httpCode:" + paramInt2 + " err:" + paramString);
    if (QLog.isColorLevel()) {
      QLog.d("shadow::CdnPmUpdater", 2, " onDownloadFailed retCode =  " + paramInt1);
    }
    if (CdnPmUpdater.b(this.jdField_a_of_type_ComTencentMobileqqIntervideoCdnPmUpdater)) {}
    for (paramString = "33669798";; paramString = "33669803")
    {
      Monitor.b(paramString);
      CdnPmUpdater.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoCdnPmUpdater).opType("onDownloadFailed").opResult((int)(System.currentTimeMillis() - this.jdField_a_of_type_Long)).report();
      this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.countDown();
      return;
    }
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.CdnPmUpdater.2
 * JD-Core Version:    0.7.0.1
 */