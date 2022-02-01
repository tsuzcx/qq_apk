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
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDataReportBasicInfo;
    if ((localObject1 != null) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferOneSlotComplete != null))
    {
      localObject1 = ((DataReportBasicInfo)localObject1).a();
      ((HashMap)localObject1).putAll(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferOneSlotComplete.getReportData());
      ((HashMap)localObject1).put("param_V6SelectType", String.valueOf(this.jdField_a_of_type_Int));
      ((HashMap)localObject1).put("param_ipAddrType", String.valueOf(this.jdField_b_of_type_Int));
      ((HashMap)localObject1).put("param_stackType", String.valueOf(QFileUtils.b()));
      ((HashMap)localObject1).put("param_loginType", String.valueOf(QFileUtils.c()));
      ((HashMap)localObject1).put("param_ishttps", String.valueOf(this.c));
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Id[");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_Long);
      ((StringBuilder)localObject2).append("] >>> GroupDownloaderDataReport:act=");
      ((StringBuilder)localObject2).append(a());
      ((StringBuilder)localObject2).append(((HashMap)localObject1).toString());
      QLog.i("ExtfGroupDownloaderDataReport<FileAssistant>", 1, ((StringBuilder)localObject2).toString());
      localObject2 = StatisticCollector.getInstance(BaseApplication.getContext());
      String str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      String str2 = a();
      boolean bool;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDataReportBasicInfo.jdField_b_of_type_Long == 0L) {
        bool = true;
      } else {
        bool = false;
      }
      ((StatisticCollector)localObject2).collectPerformance(str1, str2, bool, 0L, 0L, (HashMap)localObject1, "");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDataReportBasicInfo = null;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferOneSlotComplete = null;
      return;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Id[");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_Long);
    ((StringBuilder)localObject1).append("] GroupDownloaderDataReport err. param err");
    QLog.e("ExtfGroupDownloaderDataReport<FileAssistant>", 1, ((StringBuilder)localObject1).toString());
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(int paramInt, long paramLong1, String paramString, long paramLong2, long paramLong3)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDataReportBasicInfo = new DataReportBasicInfo();
    DataReportBasicInfo localDataReportBasicInfo = this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDataReportBasicInfo;
    localDataReportBasicInfo.jdField_a_of_type_Long = paramInt;
    localDataReportBasicInfo.jdField_b_of_type_Long = paramLong1;
    localDataReportBasicInfo.jdField_a_of_type_JavaLangString = paramString;
    localDataReportBasicInfo.d = paramLong2;
    localDataReportBasicInfo.c = paramLong3;
    localDataReportBasicInfo.jdField_a_of_type_Int = 0;
    localDataReportBasicInfo.jdField_b_of_type_Int = 1;
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
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.download.ExtfGroupDownloaderDataReport
 * JD-Core Version:    0.7.0.1
 */