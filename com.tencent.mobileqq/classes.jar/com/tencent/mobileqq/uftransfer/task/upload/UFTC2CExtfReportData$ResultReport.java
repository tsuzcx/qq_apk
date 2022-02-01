package com.tencent.mobileqq.uftransfer.task.upload;

import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadResultRp;
import com.tencent.mobileqq.uftransfer.depend.UFTDependFeatureApi;
import com.tencent.mobileqq.uftransfer.depend.UFTLog;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class UFTC2CExtfReportData$ResultReport
{
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long = 0L;
  ExcitingTransferUploadResultRp jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp;
  String jdField_a_of_type_JavaLangString;
  final AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = 0;
  long jdField_b_of_type_Long = 0L;
  String jdField_b_of_type_JavaLangString;
  int jdField_c_of_type_Int = 0;
  long jdField_c_of_type_Long = 0L;
  int jdField_d_of_type_Int = 0;
  long jdField_d_of_type_Long = 0L;
  long e = 0L;
  long f = 0L;
  long g;
  
  public UFTC2CExtfReportData$ResultReport(AppRuntime paramAppRuntime)
  {
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
  }
  
  protected HashMap<String, String> a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_ReportVer", String.valueOf(1));
    localHashMap.put("param_TransferType", String.valueOf(0));
    localHashMap.put("param_Platform", String.valueOf(2));
    localHashMap.put("param_AppType", String.valueOf(0));
    localHashMap.put("param_Result", String.valueOf(this.jdField_a_of_type_Int));
    localHashMap.put("param_FileName", String.valueOf(this.jdField_a_of_type_JavaLangString));
    localHashMap.put("param_Suffix", String.valueOf(this.jdField_b_of_type_JavaLangString));
    localHashMap.put("param_TargetUin", String.valueOf(this.jdField_b_of_type_Long));
    localHashMap.put("param_GroupCode", String.valueOf(this.jdField_c_of_type_Long));
    localHashMap.put("param_FileSize", String.valueOf(this.jdField_d_of_type_Long));
    localHashMap.put("param_IsFlashFile", String.valueOf(this.jdField_a_of_type_Boolean));
    localHashMap.put("param_TotalCostTime", String.valueOf(this.g));
    localHashMap.put("param_CalcShaCostTime", String.valueOf(this.e));
    localHashMap.put("param_CalcHashCostTime", String.valueOf(this.f));
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp;
    if (localObject != null)
    {
      localHashMap.put("param_Result", String.valueOf(((ExcitingTransferUploadResultRp)localObject).mnResult));
      localHashMap.put("param_IsXTFValid", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp.mbIsXTFValid));
      localHashMap.put("param_HttpTime", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp.mu64HttpTime));
      localHashMap.put("param_SrvReturCode", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp.mnSrvReturCode));
      localHashMap.put("param_TransferSpeed", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp.mu64TransferSpeed));
      localHashMap.put("param_TransferSize", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp.mu64TransferSize));
      localHashMap.put("param_StartSize", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp.mu64StartSize));
      localHashMap.put("param_ServerIp", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp.mstrServerIp));
      localHashMap.put("param_ServerPort", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp.mwServerPort));
      localHashMap.put("param_FileUrl", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp.mstrFileUrl));
      localHashMap.put("param_MaxUploadingFtnNum", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp.muMaxUploadingFtnNum));
      localHashMap.put("param_RetryCount", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp.muRetryCount));
      localHashMap.put("param_IpChangeCount", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp.muIpChangeCount));
      localHashMap.put("param_RollBackCount", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp.muRollBackCount));
      localHashMap.put("param_QueryHoleCount", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp.muQueryHoleCount));
      localHashMap.put("param_RangDiffCount", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp.muRangDiffCount));
      localHashMap.put("param_DelayTotoalCount", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp.muDelayTotoalCount));
      localHashMap.put("param_TcpCnnCode", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp.mnTcpCnnCode));
      localHashMap.put("param_TcpSocketCode", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp.mnTcpSocketCode));
      localHashMap.put("param_HttpsSupport", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp.mwHttpsSupport));
    }
    else
    {
      localHashMap.put("param_IsXTFValid", String.valueOf(false));
      localHashMap.put("param_HttpTime", String.valueOf(0));
      localHashMap.put("param_SrvReturCode", String.valueOf(0));
      localHashMap.put("param_TransferSpeed", String.valueOf(0));
      localHashMap.put("param_TransferSize", String.valueOf(0));
      localHashMap.put("param_StartSize", String.valueOf(0));
      localHashMap.put("param_ServerIp", "");
      localHashMap.put("param_ServerPort", String.valueOf(0));
      localHashMap.put("param_FileUrl", "");
      localHashMap.put("param_MaxUploadingFtnNum", String.valueOf(0));
      localHashMap.put("param_RetryCount", String.valueOf(0));
      localHashMap.put("param_IpChangeCount", String.valueOf(0));
      localHashMap.put("param_RollBackCount", String.valueOf(0));
      localHashMap.put("param_QueryHoleCount", String.valueOf(0));
      localHashMap.put("param_RangDiffCount", String.valueOf(0));
      localHashMap.put("param_DelayTotoalCount", String.valueOf(0));
      localHashMap.put("param_TcpCnnCode", String.valueOf(0));
      localHashMap.put("param_TcpSocketCode", String.valueOf(0));
      localHashMap.put("param_HttpsSupport", String.valueOf(0));
    }
    localHashMap.put("param_V6SelectType", String.valueOf(this.jdField_b_of_type_Int));
    localHashMap.put("param_ipAddrType", String.valueOf(this.jdField_c_of_type_Int));
    localHashMap.put("param_stackType", String.valueOf(UFTDependFeatureApi.d()));
    localHashMap.put("param_loginType", String.valueOf(UFTDependFeatureApi.e()));
    localHashMap.put("param_ishttps", String.valueOf(this.jdField_d_of_type_Int));
    if (UFTDependFeatureApi.a())
    {
      localObject = this.jdField_a_of_type_MqqAppAppRuntime;
      if ((localObject == null) || (((AppRuntime)localObject).isLogin())) {}
    }
    else
    {
      localHashMap.put("param_Result", String.valueOf(2));
    }
    return localHashMap;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(long paramLong1, long paramLong2, String paramString1, String paramString2, long paramLong3)
  {
    this.jdField_b_of_type_Long = paramLong1;
    this.jdField_c_of_type_Long = paramLong2;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_d_of_type_Long = paramLong3;
  }
  
  public void a(ExcitingTransferUploadResultRp paramExcitingTransferUploadResultRp)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp = paramExcitingTransferUploadResultRp;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void b(long paramLong)
  {
    this.e = paramLong;
  }
  
  public void b(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void c(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void c(long paramLong)
  {
    this.g = paramLong;
  }
  
  public void c(boolean paramBoolean)
  {
    HashMap localHashMap = a();
    String str = "null";
    StringBuilder localStringBuilder;
    if (paramBoolean)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Id[");
      localStringBuilder.append(this.jdField_a_of_type_Long);
      localStringBuilder.append("] >>> Extf_C2C_Suc_DR:act[");
      localStringBuilder.append("actC2CXTFUpload");
      localStringBuilder.append("] ");
      if (localHashMap != null) {
        str = localHashMap.toString();
      }
      localStringBuilder.append(str);
      UFTLog.b("[UFTTransfer] UFTC2CExtfReportData", 1, localStringBuilder.toString());
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Id[");
      localStringBuilder.append(this.jdField_a_of_type_Long);
      localStringBuilder.append("] >>> Extf_C2C_Fail_DR:act[");
      localStringBuilder.append("actC2CXTFUpload");
      localStringBuilder.append("] ");
      if (localHashMap != null) {
        str = localHashMap.toString();
      }
      localStringBuilder.append(str);
      UFTLog.d("[UFTTransfer] UFTC2CExtfReportData", 1, localStringBuilder.toString());
    }
    UFTDependFeatureApi.a(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin(), "actC2CXTFUpload", paramBoolean, 0L, 0L, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.upload.UFTC2CExtfReportData.ResultReport
 * JD-Core Version:    0.7.0.1
 */