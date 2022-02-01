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
  protected final QQAppInterface a;
  protected DataReportBasicInfo b;
  protected ExcitingTransferOneSlotComplete c;
  protected long d = 0L;
  int e = 0;
  int f = 0;
  int g = 0;
  
  public ExtfGroupDownloaderDataReport(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  protected String a()
  {
    return "actGroupPDSlot";
  }
  
  public void a(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void a(int paramInt, long paramLong1, String paramString, long paramLong2, long paramLong3)
  {
    this.b = new DataReportBasicInfo();
    DataReportBasicInfo localDataReportBasicInfo = this.b;
    localDataReportBasicInfo.a = paramInt;
    localDataReportBasicInfo.b = paramLong1;
    localDataReportBasicInfo.d = paramString;
    localDataReportBasicInfo.g = paramLong2;
    localDataReportBasicInfo.e = paramLong3;
    localDataReportBasicInfo.c = 0;
    localDataReportBasicInfo.f = 1;
  }
  
  public void a(long paramLong)
  {
    this.d = paramLong;
  }
  
  public void a(ExcitingTransferOneSlotComplete paramExcitingTransferOneSlotComplete)
  {
    this.c = paramExcitingTransferOneSlotComplete;
  }
  
  public void a(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void b()
  {
    Object localObject1 = this.b;
    if ((localObject1 != null) && (this.c != null))
    {
      localObject1 = ((DataReportBasicInfo)localObject1).a();
      ((HashMap)localObject1).putAll(this.c.getReportData());
      ((HashMap)localObject1).put("param_V6SelectType", String.valueOf(this.e));
      ((HashMap)localObject1).put("param_ipAddrType", String.valueOf(this.f));
      ((HashMap)localObject1).put("param_stackType", String.valueOf(QFileUtils.d()));
      ((HashMap)localObject1).put("param_loginType", String.valueOf(QFileUtils.e()));
      ((HashMap)localObject1).put("param_ishttps", String.valueOf(this.g));
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Id[");
      ((StringBuilder)localObject2).append(this.d);
      ((StringBuilder)localObject2).append("] >>> GroupDownloaderDataReport:act=");
      ((StringBuilder)localObject2).append(a());
      ((StringBuilder)localObject2).append(((HashMap)localObject1).toString());
      QLog.i("ExtfGroupDownloaderDataReport<FileAssistant>", 1, ((StringBuilder)localObject2).toString());
      localObject2 = StatisticCollector.getInstance(BaseApplication.getContext());
      String str1 = this.a.getCurrentAccountUin();
      String str2 = a();
      boolean bool;
      if (this.b.b == 0L) {
        bool = true;
      } else {
        bool = false;
      }
      ((StatisticCollector)localObject2).collectPerformance(str1, str2, bool, 0L, 0L, (HashMap)localObject1, "");
      this.b = null;
      this.c = null;
      return;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Id[");
    ((StringBuilder)localObject1).append(this.d);
    ((StringBuilder)localObject1).append("] GroupDownloaderDataReport err. param err");
    QLog.e("ExtfGroupDownloaderDataReport<FileAssistant>", 1, ((StringBuilder)localObject1).toString());
  }
  
  public void b(int paramInt)
  {
    this.f = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.download.ExtfGroupDownloaderDataReport
 * JD-Core Version:    0.7.0.1
 */