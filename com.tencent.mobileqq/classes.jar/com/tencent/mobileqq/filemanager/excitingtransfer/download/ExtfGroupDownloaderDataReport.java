package com.tencent.mobileqq.filemanager.excitingtransfer.download;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.excitingtransfer.DataReportBasicInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferOneSlotComplete;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class ExtfGroupDownloaderDataReport
{
  int a;
  protected long a;
  protected final QQAppInterface a;
  protected DataReportBasicInfo a;
  protected ExcitingTransferOneSlotComplete a;
  int b;
  int c = 0;
  
  public ExtfGroupDownloaderDataReport(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  protected String a()
  {
    return "actGroupPDSlot";
  }
  
  public void a()
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDataReportBasicInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferOneSlotComplete == null))
    {
      QLog.e("ExtfGroupDownloaderDataReport<FileAssistant>", 1, "Id[" + this.jdField_a_of_type_Long + "] GroupDownloaderDataReport err. param err");
      return;
    }
    HashMap localHashMap = this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDataReportBasicInfo.a();
    localHashMap.putAll(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferOneSlotComplete.getReportData());
    localHashMap.put("param_V6SelectType", String.valueOf(this.jdField_a_of_type_Int));
    localHashMap.put("param_ipAddrType", String.valueOf(this.jdField_b_of_type_Int));
    localHashMap.put("param_stackType", String.valueOf(QFileUtils.b()));
    localHashMap.put("param_loginType", String.valueOf(QFileUtils.c()));
    localHashMap.put("param_ishttps", String.valueOf(this.c));
    QLog.i("ExtfGroupDownloaderDataReport<FileAssistant>", 1, "Id[" + this.jdField_a_of_type_Long + "] >>> GroupDownloaderDataReport:act=" + a() + localHashMap.toString());
    StatisticCollector localStatisticCollector = StatisticCollector.getInstance(BaseApplication.getContext());
    String str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    String str2 = a();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDataReportBasicInfo.jdField_b_of_type_Long == 0L) {}
    for (;;)
    {
      localStatisticCollector.collectPerformance(str1, str2, bool, 0L, 0L, localHashMap, "");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDataReportBasicInfo = null;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferOneSlotComplete = null;
      return;
      bool = false;
    }
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
  
  public void a(ExcitingTransferOneSlotComplete paramExcitingTransferOneSlotComplete)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferOneSlotComplete = paramExcitingTransferOneSlotComplete;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.download.ExtfGroupDownloaderDataReport
 * JD-Core Version:    0.7.0.1
 */