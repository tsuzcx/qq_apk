package com.tencent.mobileqq.filemanager.excitingtransfer.download;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.excitingtransfer.DataReportBasicInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadCompletedInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloaderFirstPkgRp;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class ExtfGroupDownloadDataReport
{
  int a;
  protected long a;
  protected final QQAppInterface a;
  protected DataReportBasicInfo a;
  protected ExcitingTransferDownloadCompletedInfo a;
  protected ExcitingTransferDownloaderFirstPkgRp a;
  int b;
  int c = 0;
  
  public ExtfGroupDownloadDataReport(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  protected String a()
  {
    return "actGroupPDFileDownload";
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(int paramInt, long paramLong1, String paramString, long paramLong2, long paramLong3)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDataReportBasicInfo = new DataReportBasicInfo();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDataReportBasicInfo.jdField_a_of_type_Long = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDataReportBasicInfo.jdField_b_of_type_Long = paramLong1;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDataReportBasicInfo.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDataReportBasicInfo.d = paramLong2;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDataReportBasicInfo.c = paramLong3;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDataReportBasicInfo.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDataReportBasicInfo.jdField_b_of_type_Int = 1;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(ExcitingTransferDownloadCompletedInfo paramExcitingTransferDownloadCompletedInfo)
  {
    if (paramExcitingTransferDownloadCompletedInfo.muFirstRecvDataTime > paramExcitingTransferDownloadCompletedInfo.muStartTime) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloaderFirstPkgRp.mHttpFirstTime = (paramExcitingTransferDownloadCompletedInfo.muFirstRecvDataTime - paramExcitingTransferDownloadCompletedInfo.muStartTime);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloaderFirstPkgRp.mHtpFirstDataSize = paramExcitingTransferDownloadCompletedInfo.muFirstRecvDataSize;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadCompletedInfo = paramExcitingTransferDownloadCompletedInfo;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.c = i;
      return;
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void b(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloaderFirstPkgRp == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloaderFirstPkgRp = new ExcitingTransferDownloaderFirstPkgRp();
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloaderFirstPkgRp.mCSStartTime = paramLong;
  }
  
  public void b(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDataReportBasicInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadCompletedInfo == null))
    {
      QLog.e("ExtfGroupDownloadDataReport<FileAssistant>", 1, "Id[" + this.jdField_a_of_type_Long + "] GroupDownloadDataReport err. param err");
      return;
    }
    HashMap localHashMap = new HashMap();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDataReportBasicInfo != null) {
      localHashMap.putAll(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDataReportBasicInfo.a());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadCompletedInfo != null) {
      localHashMap.putAll(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadCompletedInfo.getReportData());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloaderFirstPkgRp != null) {
      localHashMap.putAll(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloaderFirstPkgRp.getReportData());
    }
    for (;;)
    {
      localHashMap.put("param_V6SelectType", String.valueOf(this.jdField_a_of_type_Int));
      localHashMap.put("param_ipAddrType", String.valueOf(this.jdField_b_of_type_Int));
      localHashMap.put("param_stackType", String.valueOf(QFileUtils.b()));
      localHashMap.put("param_loginType", String.valueOf(QFileUtils.c()));
      localHashMap.put("param_ishttps", String.valueOf(this.c));
      QLog.i("ExtfGroupDownloadDataReport<FileAssistant>", 1, "Id[" + this.jdField_a_of_type_Long + "] >>> GroupDownloadDataReport: act=" + a() + localHashMap.toString());
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), a(), paramBoolean, 0L, 0L, localHashMap, "");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDataReportBasicInfo = null;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadCompletedInfo = null;
      return;
      localHashMap.put("param_CSTime", String.valueOf(0));
      localHashMap.put("param_HttpFirstTime", String.valueOf(0));
      localHashMap.put("param_HttpFirstDataSize", String.valueOf(0));
    }
  }
  
  public void c(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloaderFirstPkgRp == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloaderFirstPkgRp.mCSEndTime = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.download.ExtfGroupDownloadDataReport
 * JD-Core Version:    0.7.0.1
 */