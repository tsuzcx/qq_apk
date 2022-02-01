package com.tencent.mobileqq.filemanager.excitingtransfer.downloader.c2cdownloader;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.excitingtransfer.BaseDataReport;
import com.tencent.mobileqq.filemanager.excitingtransfer.DataReportBasicInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadCompletedInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloaderFirstPkgRp;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferOneSlotComplete;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.util.SystemUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class C2CDataReporter
  extends BaseDataReport
{
  public final DataReportBasicInfo b = new DataReportBasicInfo();
  int c = 0;
  int d = 0;
  int e = 0;
  List<Integer> f = null;
  Map<Integer, Integer> g = null;
  private ExcitingTransferDownloaderFirstPkgRp h = null;
  private ExcitingTransferDownloadCompletedInfo i = null;
  private long j = 0L;
  private long k = 0L;
  private boolean l = false;
  
  public C2CDataReporter(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private long a(long paramLong, int paramInt)
  {
    if (paramLong == 9004L) {
      return paramLong;
    }
    if ((paramLong != 0L) && (paramInt != 0))
    {
      i();
      if (this.f.indexOf(Integer.valueOf(paramInt)) >= 0) {
        return 9042L;
      }
      return paramInt;
    }
    j();
    if (paramLong < 300L)
    {
      paramInt = (int)paramLong;
      if (paramInt != 0)
      {
        if (paramInt != 101)
        {
          if (paramInt == 201) {
            return 9001L;
          }
        }
        else {
          return 9037L;
        }
      }
      else {
        return 0L;
      }
    }
    if (AppNetConnInfo.isNetSupport())
    {
      if (this.a.isLogin()) {
        return 9004L;
      }
      j();
      if (this.g.containsKey(Long.valueOf(paramLong))) {
        return ((Integer)this.g.get(Long.valueOf(paramLong))).intValue();
      }
      switch ((int)paramLong)
      {
      default: 
        return paramLong;
      case 506: 
        return 9040L;
      case 504: 
        return 9082L;
      }
      if (k()) {
        return 9040L;
      }
      return 9003L;
    }
    return 9004L;
  }
  
  private boolean k()
  {
    long l1;
    if (SystemUtil.a()) {
      l1 = SystemUtil.b();
    } else {
      l1 = SystemUtil.c();
    }
    return this.b.g > l1 * 1024L;
  }
  
  protected String a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return "actFileDown";
    }
    return "actPDFileDownload";
  }
  
  public void a(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2, ExcitingTransferOneSlotComplete paramExcitingTransferOneSlotComplete)
  {
    DataReportBasicInfo localDataReportBasicInfo = new DataReportBasicInfo();
    localDataReportBasicInfo.f = this.b.f;
    localDataReportBasicInfo.c = this.b.c;
    localDataReportBasicInfo.e = this.b.e;
    localDataReportBasicInfo.d = this.b.d;
    localDataReportBasicInfo.g = this.b.g;
    localDataReportBasicInfo.a = paramInt1;
    localDataReportBasicInfo.b = paramInt2;
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_V6SelectType", String.valueOf(this.c));
    if (paramExcitingTransferOneSlotComplete != null) {
      localHashMap.put("param_ipAddrType", String.valueOf(QFileUtils.b(paramExcitingTransferOneSlotComplete.mstrIp)));
    } else {
      localHashMap.put("param_ipAddrType", String.valueOf(0));
    }
    localHashMap.put("param_stackType", String.valueOf(QFileUtils.d()));
    localHashMap.put("param_loginType", String.valueOf(QFileUtils.e()));
    localHashMap.put("param_ishttps", String.valueOf(this.e));
    super.a(localDataReportBasicInfo, paramExcitingTransferOneSlotComplete, localHashMap);
  }
  
  public void a(long paramLong)
  {
    if (this.h.mHtpFirstDataSize != -1L) {
      return;
    }
    this.h.mHtpFirstDataSize = paramLong;
  }
  
  public void a(ExcitingTransferDownloadCompletedInfo paramExcitingTransferDownloadCompletedInfo)
  {
    this.h.mHttpFirstTime = (paramExcitingTransferDownloadCompletedInfo.muFirstRecvDataTime - paramExcitingTransferDownloadCompletedInfo.muStartTime);
    this.h.mHtpFirstDataSize = paramExcitingTransferDownloadCompletedInfo.muFirstRecvDataSize;
    this.i = paramExcitingTransferDownloadCompletedInfo;
  }
  
  protected boolean a()
  {
    return true;
  }
  
  protected HashMap<String, String> b()
  {
    HashMap localHashMap = new HashMap();
    Object localObject = this.b;
    if (localObject != null) {
      localHashMap.putAll(((DataReportBasicInfo)localObject).a());
    }
    localHashMap.put("param_SubReason", String.valueOf(this.j));
    localObject = this.h;
    if (localObject != null) {
      localHashMap.putAll(((ExcitingTransferDownloaderFirstPkgRp)localObject).getReportData());
    }
    localObject = this.i;
    if (localObject != null) {
      localHashMap.putAll(((ExcitingTransferDownloadCompletedInfo)localObject).getReportData());
    }
    long l1 = this.k;
    if (l1 != 0L) {
      localHashMap.put("param_SrvRetCode", String.valueOf(l1));
    }
    localHashMap.put("param_V6SelectType", String.valueOf(this.c));
    localHashMap.put("param_ipAddrType", String.valueOf(this.d));
    localHashMap.put("param_stackType", String.valueOf(QFileUtils.d()));
    localHashMap.put("param_loginType", String.valueOf(QFileUtils.e()));
    localHashMap.put("param_ishttps", String.valueOf(this.e));
    return localHashMap;
  }
  
  public void b(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void b(long paramLong)
  {
    DataReportBasicInfo localDataReportBasicInfo = this.b;
    localDataReportBasicInfo.a = 2L;
    this.j = 2L;
    localDataReportBasicInfo.b = paramLong;
    b(false);
  }
  
  protected HashMap<String, String> c()
  {
    HashMap localHashMap = new HashMap();
    ExcitingTransferDownloadCompletedInfo localExcitingTransferDownloadCompletedInfo = this.i;
    if (localExcitingTransferDownloadCompletedInfo != null)
    {
      localHashMap.put("serverip", String.valueOf(localExcitingTransferDownloadCompletedInfo.mstrLastServerHost));
      localHashMap.put("param_Server", String.valueOf(this.i.mstrLastServerHost));
      localHashMap.put("param_ftnIP", String.valueOf(this.i.mstrLastServerHost));
      localHashMap.put("param_retry", String.valueOf(this.i.muRetryTimes));
      localHashMap.put("param_FailCode", String.valueOf(a(this.b.b, this.i.mnSrvReturnCode)));
      localHashMap.put("param_fsized", String.valueOf(this.i.muDownloadedSize));
      localHashMap.put("param_ipStackType", String.valueOf(QFileUtils.b()));
      localHashMap.put("param_realTransferType", String.valueOf(this.i.muProxyType));
      if (this.i.muTotalTimes != 0L) {
        localHashMap.put("param_speed", String.valueOf((float)(this.i.muDownloadedSize / 1048576L) / (float)this.i.muTotalTimes));
      } else {
        localHashMap.put("param_speed", "0");
      }
    }
    else
    {
      localHashMap.put("param_FailCode", String.valueOf(this.b.b));
    }
    localHashMap.put("param_uuid", "");
    localHashMap.put("param_MD5", "");
    localHashMap.put("param_fsizeo", String.valueOf(this.b.g));
    localHashMap.put("param_PeerUin", String.valueOf(this.b.e));
    localHashMap.put("param_url", "");
    localHashMap.put("param_rspHeader", "");
    localHashMap.put("param_nSessionId", "");
    localHashMap.put("param_fromType", "1");
    localHashMap.put("param_V6SelectType", String.valueOf(this.c));
    localHashMap.put("param_ipAddrType", String.valueOf(this.d));
    localHashMap.put("param_stackType", String.valueOf(QFileUtils.d()));
    localHashMap.put("param_loginType", String.valueOf(QFileUtils.e()));
    localHashMap.put("param_ishttps", String.valueOf(this.e));
    return localHashMap;
  }
  
  public void c(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void c(long paramLong)
  {
    DataReportBasicInfo localDataReportBasicInfo = this.b;
    localDataReportBasicInfo.a = 2L;
    this.j = 7L;
    this.k = paramLong;
    localDataReportBasicInfo.b = paramLong;
    b(false);
  }
  
  public void d()
  {
    DataReportBasicInfo localDataReportBasicInfo = this.b;
    localDataReportBasicInfo.a = 5L;
    this.j = 3L;
    localDataReportBasicInfo.b = 9004L;
    b(false);
  }
  
  public void d(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void e()
  {
    this.b.a = 1L;
    if (this.l) {
      this.j = 3L;
    } else {
      this.j = 2L;
    }
    this.b.b = 9037L;
    b(false);
  }
  
  public void f()
  {
    if (this.h != null) {
      return;
    }
    this.h = new ExcitingTransferDownloaderFirstPkgRp();
    this.h.mCSStartTime = MessageCache.c();
  }
  
  public void g()
  {
    this.h.mCSEndTime = MessageCache.c();
  }
  
  public void h()
  {
    this.l = true;
  }
  
  protected void i()
  {
    if (this.f != null) {
      return;
    }
    this.f = new ArrayList();
    this.f.add(Integer.valueOf(-29120));
    this.f.add(Integer.valueOf(-29120));
    this.f.add(Integer.valueOf(-29150));
    this.f.add(Integer.valueOf(-21122));
    this.f.add(Integer.valueOf(-28123));
    this.f.add(Integer.valueOf(-25081));
    this.f.add(Integer.valueOf(-28126));
    this.f.add(Integer.valueOf(-6101));
    this.f.add(Integer.valueOf(-7003));
    this.f.add(Integer.valueOf(-403));
    this.f.add(Integer.valueOf(-9006));
    this.f.add(Integer.valueOf(-9004));
    this.f.add(Integer.valueOf(-9017));
    this.f.add(Integer.valueOf(-2813));
  }
  
  protected void j()
  {
    if (this.g != null) {
      return;
    }
    this.g = new HashMap();
    this.g.put(Integer.valueOf(300), Integer.valueOf(9052));
    this.g.put(Integer.valueOf(301), Integer.valueOf(9052));
    this.g.put(Integer.valueOf(302), Integer.valueOf(9052));
    this.g.put(Integer.valueOf(303), Integer.valueOf(9052));
    this.g.put(Integer.valueOf(400), Integer.valueOf(9052));
    this.g.put(Integer.valueOf(304), Integer.valueOf(304));
    this.g.put(Integer.valueOf(305), Integer.valueOf(305));
    this.g.put(Integer.valueOf(306), Integer.valueOf(306));
    this.g.put(Integer.valueOf(307), Integer.valueOf(307));
    this.g.put(Integer.valueOf(308), Integer.valueOf(308));
    this.g.put(Integer.valueOf(401), Integer.valueOf(9343));
    this.g.put(Integer.valueOf(402), Integer.valueOf(9321));
    this.g.put(Integer.valueOf(403), Integer.valueOf(9050));
    this.g.put(Integer.valueOf(405), Integer.valueOf(9058));
    this.g.put(Integer.valueOf(406), Integer.valueOf(9058));
    this.g.put(Integer.valueOf(407), Integer.valueOf(9009));
    this.g.put(Integer.valueOf(408), Integer.valueOf(-9527));
    this.g.put(Integer.valueOf(404), Integer.valueOf(9056));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.downloader.c2cdownloader.C2CDataReporter
 * JD-Core Version:    0.7.0.1
 */