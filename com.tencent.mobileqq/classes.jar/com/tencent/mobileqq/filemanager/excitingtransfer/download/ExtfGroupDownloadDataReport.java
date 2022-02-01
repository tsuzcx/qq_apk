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
  protected final QQAppInterface a;
  protected DataReportBasicInfo b;
  protected ExcitingTransferDownloaderFirstPkgRp c;
  protected ExcitingTransferDownloadCompletedInfo d;
  protected long e = 0L;
  int f = 0;
  int g = 0;
  int h = 0;
  
  public ExtfGroupDownloadDataReport(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  protected String a()
  {
    return "actGroupPDFileDownload";
  }
  
  public void a(int paramInt)
  {
    this.f = paramInt;
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
    this.e = paramLong;
  }
  
  public void a(ExcitingTransferDownloadCompletedInfo paramExcitingTransferDownloadCompletedInfo)
  {
    if (paramExcitingTransferDownloadCompletedInfo.muFirstRecvDataTime > paramExcitingTransferDownloadCompletedInfo.muStartTime) {
      this.c.mHttpFirstTime = (paramExcitingTransferDownloadCompletedInfo.muFirstRecvDataTime - paramExcitingTransferDownloadCompletedInfo.muStartTime);
    }
    this.c.mHtpFirstDataSize = paramExcitingTransferDownloadCompletedInfo.muFirstRecvDataSize;
    this.d = paramExcitingTransferDownloadCompletedInfo;
  }
  
  public void a(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void b(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void b(long paramLong)
  {
    if (this.c == null) {
      this.c = new ExcitingTransferDownloaderFirstPkgRp();
    }
    this.c.mCSStartTime = paramLong;
  }
  
  public void b(boolean paramBoolean)
  {
    if ((this.b != null) && (this.d != null))
    {
      localObject1 = new HashMap();
      Object localObject2 = this.b;
      if (localObject2 != null) {
        ((HashMap)localObject1).putAll(((DataReportBasicInfo)localObject2).a());
      }
      localObject2 = this.d;
      if (localObject2 != null) {
        ((HashMap)localObject1).putAll(((ExcitingTransferDownloadCompletedInfo)localObject2).getReportData());
      }
      localObject2 = this.c;
      if (localObject2 != null)
      {
        ((HashMap)localObject1).putAll(((ExcitingTransferDownloaderFirstPkgRp)localObject2).getReportData());
      }
      else
      {
        ((HashMap)localObject1).put("param_CSTime", String.valueOf(0));
        ((HashMap)localObject1).put("param_HttpFirstTime", String.valueOf(0));
        ((HashMap)localObject1).put("param_HttpFirstDataSize", String.valueOf(0));
      }
      ((HashMap)localObject1).put("param_V6SelectType", String.valueOf(this.f));
      ((HashMap)localObject1).put("param_ipAddrType", String.valueOf(this.g));
      ((HashMap)localObject1).put("param_stackType", String.valueOf(QFileUtils.d()));
      ((HashMap)localObject1).put("param_loginType", String.valueOf(QFileUtils.e()));
      ((HashMap)localObject1).put("param_ishttps", String.valueOf(this.h));
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Id[");
      ((StringBuilder)localObject2).append(this.e);
      ((StringBuilder)localObject2).append("] >>> GroupDownloadDataReport: act=");
      ((StringBuilder)localObject2).append(a());
      ((StringBuilder)localObject2).append(((HashMap)localObject1).toString());
      QLog.i("ExtfGroupDownloadDataReport<FileAssistant>", 1, ((StringBuilder)localObject2).toString());
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.a.getCurrentAccountUin(), a(), paramBoolean, 0L, 0L, (HashMap)localObject1, "");
      this.b = null;
      this.d = null;
      return;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Id[");
    ((StringBuilder)localObject1).append(this.e);
    ((StringBuilder)localObject1).append("] GroupDownloadDataReport err. param err");
    QLog.e("ExtfGroupDownloadDataReport<FileAssistant>", 1, ((StringBuilder)localObject1).toString());
  }
  
  public void c(long paramLong)
  {
    ExcitingTransferDownloaderFirstPkgRp localExcitingTransferDownloaderFirstPkgRp = this.c;
    if (localExcitingTransferDownloaderFirstPkgRp == null) {
      return;
    }
    localExcitingTransferDownloaderFirstPkgRp.mCSEndTime = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.download.ExtfGroupDownloadDataReport
 * JD-Core Version:    0.7.0.1
 */