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
  int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = 0L;
  public final DataReportBasicInfo a;
  private ExcitingTransferDownloadCompletedInfo jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadCompletedInfo = null;
  private ExcitingTransferDownloaderFirstPkgRp jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloaderFirstPkgRp = null;
  List<Integer> jdField_a_of_type_JavaUtilList = null;
  Map<Integer, Integer> jdField_a_of_type_JavaUtilMap = null;
  private boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = 0;
  private long jdField_b_of_type_Long = 0L;
  int c = 0;
  
  public C2CDataReporter(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDataReportBasicInfo = new DataReportBasicInfo();
  }
  
  private long a(long paramLong, int paramInt)
  {
    if (paramLong == 9004L) {
      return paramLong;
    }
    if ((paramLong != 0L) && (paramInt != 0))
    {
      f();
      if (this.jdField_a_of_type_JavaUtilList.indexOf(Integer.valueOf(paramInt)) >= 0) {
        return 9042L;
      }
      return paramInt;
    }
    g();
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
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isLogin()) {
        return 9004L;
      }
      g();
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(Long.valueOf(paramLong))) {
        return ((Integer)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong))).intValue();
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
      if (b()) {
        return 9040L;
      }
      return 9003L;
    }
    return 9004L;
  }
  
  private boolean b()
  {
    long l;
    if (SystemUtil.a()) {
      l = SystemUtil.a();
    } else {
      l = SystemUtil.b();
    }
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDataReportBasicInfo.d > l * 1024L;
  }
  
  protected String a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return "actFileDown";
    }
    return "actPDFileDownload";
  }
  
  protected HashMap<String, String> a()
  {
    HashMap localHashMap = new HashMap();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDataReportBasicInfo;
    if (localObject != null) {
      localHashMap.putAll(((DataReportBasicInfo)localObject).a());
    }
    localHashMap.put("param_SubReason", String.valueOf(this.jdField_a_of_type_Long));
    localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloaderFirstPkgRp;
    if (localObject != null) {
      localHashMap.putAll(((ExcitingTransferDownloaderFirstPkgRp)localObject).getReportData());
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadCompletedInfo;
    if (localObject != null) {
      localHashMap.putAll(((ExcitingTransferDownloadCompletedInfo)localObject).getReportData());
    }
    long l = this.jdField_b_of_type_Long;
    if (l != 0L) {
      localHashMap.put("param_SrvRetCode", String.valueOf(l));
    }
    localHashMap.put("param_V6SelectType", String.valueOf(this.jdField_a_of_type_Int));
    localHashMap.put("param_ipAddrType", String.valueOf(this.jdField_b_of_type_Int));
    localHashMap.put("param_stackType", String.valueOf(QFileUtils.b()));
    localHashMap.put("param_loginType", String.valueOf(QFileUtils.c()));
    localHashMap.put("param_ishttps", String.valueOf(this.c));
    return localHashMap;
  }
  
  public void a()
  {
    DataReportBasicInfo localDataReportBasicInfo = this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDataReportBasicInfo;
    localDataReportBasicInfo.jdField_a_of_type_Long = 5L;
    this.jdField_a_of_type_Long = 3L;
    localDataReportBasicInfo.jdField_b_of_type_Long = 9004L;
    a(false);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Long = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2, ExcitingTransferOneSlotComplete paramExcitingTransferOneSlotComplete)
  {
    DataReportBasicInfo localDataReportBasicInfo = new DataReportBasicInfo();
    localDataReportBasicInfo.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDataReportBasicInfo.jdField_b_of_type_Int;
    localDataReportBasicInfo.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDataReportBasicInfo.jdField_a_of_type_Int;
    localDataReportBasicInfo.c = this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDataReportBasicInfo.c;
    localDataReportBasicInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDataReportBasicInfo.jdField_a_of_type_JavaLangString;
    localDataReportBasicInfo.d = this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDataReportBasicInfo.d;
    localDataReportBasicInfo.jdField_a_of_type_Long = paramInt1;
    localDataReportBasicInfo.jdField_b_of_type_Long = paramInt2;
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_V6SelectType", String.valueOf(this.jdField_a_of_type_Int));
    if (paramExcitingTransferOneSlotComplete != null) {
      localHashMap.put("param_ipAddrType", String.valueOf(QFileUtils.b(paramExcitingTransferOneSlotComplete.mstrIp)));
    } else {
      localHashMap.put("param_ipAddrType", String.valueOf(0));
    }
    localHashMap.put("param_stackType", String.valueOf(QFileUtils.b()));
    localHashMap.put("param_loginType", String.valueOf(QFileUtils.c()));
    localHashMap.put("param_ishttps", String.valueOf(this.c));
    super.a(localDataReportBasicInfo, paramExcitingTransferOneSlotComplete, localHashMap);
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloaderFirstPkgRp.mHtpFirstDataSize != -1L) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloaderFirstPkgRp.mHtpFirstDataSize = paramLong;
  }
  
  public void a(ExcitingTransferDownloadCompletedInfo paramExcitingTransferDownloadCompletedInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloaderFirstPkgRp.mHttpFirstTime = (paramExcitingTransferDownloadCompletedInfo.muFirstRecvDataTime - paramExcitingTransferDownloadCompletedInfo.muStartTime);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloaderFirstPkgRp.mHtpFirstDataSize = paramExcitingTransferDownloadCompletedInfo.muFirstRecvDataSize;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadCompletedInfo = paramExcitingTransferDownloadCompletedInfo;
  }
  
  protected boolean a()
  {
    return true;
  }
  
  protected HashMap<String, String> b()
  {
    HashMap localHashMap = new HashMap();
    ExcitingTransferDownloadCompletedInfo localExcitingTransferDownloadCompletedInfo = this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadCompletedInfo;
    if (localExcitingTransferDownloadCompletedInfo != null)
    {
      localHashMap.put("serverip", String.valueOf(localExcitingTransferDownloadCompletedInfo.mstrLastServerHost));
      localHashMap.put("param_Server", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadCompletedInfo.mstrLastServerHost));
      localHashMap.put("param_ftnIP", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadCompletedInfo.mstrLastServerHost));
      localHashMap.put("param_retry", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadCompletedInfo.muRetryTimes));
      localHashMap.put("param_FailCode", String.valueOf(a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDataReportBasicInfo.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadCompletedInfo.mnSrvReturnCode)));
      localHashMap.put("param_fsized", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadCompletedInfo.muDownloadedSize));
      localHashMap.put("param_ipStackType", String.valueOf(QFileUtils.a()));
      localHashMap.put("param_realTransferType", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadCompletedInfo.muProxyType));
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadCompletedInfo.muTotalTimes != 0L) {
        localHashMap.put("param_speed", String.valueOf((float)(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadCompletedInfo.muDownloadedSize / 1048576L) / (float)this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadCompletedInfo.muTotalTimes));
      } else {
        localHashMap.put("param_speed", "0");
      }
    }
    else
    {
      localHashMap.put("param_FailCode", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDataReportBasicInfo.jdField_b_of_type_Long));
    }
    localHashMap.put("param_uuid", "");
    localHashMap.put("param_MD5", "");
    localHashMap.put("param_fsizeo", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDataReportBasicInfo.d));
    localHashMap.put("param_PeerUin", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDataReportBasicInfo.c));
    localHashMap.put("param_url", "");
    localHashMap.put("param_rspHeader", "");
    localHashMap.put("param_nSessionId", "");
    localHashMap.put("param_fromType", "1");
    localHashMap.put("param_V6SelectType", String.valueOf(this.jdField_a_of_type_Int));
    localHashMap.put("param_ipAddrType", String.valueOf(this.jdField_b_of_type_Int));
    localHashMap.put("param_stackType", String.valueOf(QFileUtils.b()));
    localHashMap.put("param_loginType", String.valueOf(QFileUtils.c()));
    localHashMap.put("param_ishttps", String.valueOf(this.c));
    return localHashMap;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDataReportBasicInfo.jdField_a_of_type_Long = 1L;
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Long = 3L;
    } else {
      this.jdField_a_of_type_Long = 2L;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDataReportBasicInfo.jdField_b_of_type_Long = 9037L;
    a(false);
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void b(long paramLong)
  {
    DataReportBasicInfo localDataReportBasicInfo = this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDataReportBasicInfo;
    localDataReportBasicInfo.jdField_a_of_type_Long = 2L;
    this.jdField_a_of_type_Long = 2L;
    localDataReportBasicInfo.jdField_b_of_type_Long = paramLong;
    a(false);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloaderFirstPkgRp != null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloaderFirstPkgRp = new ExcitingTransferDownloaderFirstPkgRp();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloaderFirstPkgRp.mCSStartTime = MessageCache.a();
  }
  
  public void c(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void c(long paramLong)
  {
    DataReportBasicInfo localDataReportBasicInfo = this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDataReportBasicInfo;
    localDataReportBasicInfo.jdField_a_of_type_Long = 2L;
    this.jdField_a_of_type_Long = 7L;
    this.jdField_b_of_type_Long = paramLong;
    localDataReportBasicInfo.jdField_b_of_type_Long = paramLong;
    a(false);
  }
  
  public void c(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloaderFirstPkgRp.mCSEndTime = MessageCache.a();
  }
  
  public void e()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  protected void f()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(-29120));
    this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(-29120));
    this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(-29150));
    this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(-21122));
    this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(-28123));
    this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(-25081));
    this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(-28126));
    this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(-6101));
    this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(-7003));
    this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(-403));
    this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(-9006));
    this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(-9004));
    this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(-9017));
    this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(-2813));
  }
  
  protected void g()
  {
    if (this.jdField_a_of_type_JavaUtilMap != null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(300), Integer.valueOf(9052));
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(301), Integer.valueOf(9052));
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(302), Integer.valueOf(9052));
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(303), Integer.valueOf(9052));
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(400), Integer.valueOf(9052));
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(304), Integer.valueOf(304));
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(305), Integer.valueOf(305));
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(306), Integer.valueOf(306));
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(307), Integer.valueOf(307));
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(308), Integer.valueOf(308));
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(401), Integer.valueOf(9343));
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(402), Integer.valueOf(9321));
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(403), Integer.valueOf(9050));
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(405), Integer.valueOf(9058));
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(406), Integer.valueOf(9058));
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(407), Integer.valueOf(9009));
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(408), Integer.valueOf(-9527));
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(404), Integer.valueOf(9056));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.downloader.c2cdownloader.C2CDataReporter
 * JD-Core Version:    0.7.0.1
 */