package com.tencent.mobileqq.uftransfer.task.upload;

import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadResultRp;
import com.tencent.mobileqq.uftransfer.depend.UFTDependFeatureApi;
import com.tencent.mobileqq.uftransfer.depend.UFTLog;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class UFTTroopExtfReportData$ResultReport
  extends UFTTroopExtfReportData.BaseReport
{
  ExcitingTransferUploadResultRp jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp;
  boolean jdField_a_of_type_Boolean = false;
  int b = 0;
  int c = 0;
  int d = 0;
  long e = 0L;
  long f = 0L;
  long g;
  
  public UFTTroopExtfReportData$ResultReport(AppRuntime paramAppRuntime)
  {
    super(paramAppRuntime);
  }
  
  protected String a()
  {
    return "actGroupXTFUpload";
  }
  
  protected HashMap<String, String> a(boolean paramBoolean)
  {
    Object localObject = this;
    HashMap localHashMap = super.a(paramBoolean);
    localHashMap.put("param_IsFlashFile", String.valueOf(((ResultReport)localObject).jdField_a_of_type_Boolean));
    localHashMap.put("param_TotalCostTime", String.valueOf(((ResultReport)localObject).g));
    localHashMap.put("param_CalcShaCostTime", String.valueOf(((ResultReport)localObject).e));
    localHashMap.put("param_CalcHashCostTime", String.valueOf(((ResultReport)localObject).f));
    ExcitingTransferUploadResultRp localExcitingTransferUploadResultRp = ((ResultReport)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp;
    if (localExcitingTransferUploadResultRp != null)
    {
      localHashMap.put("param_Result", String.valueOf(localExcitingTransferUploadResultRp.mnResult));
      localHashMap.put("param_IsXTFValid", String.valueOf(((ResultReport)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp.mbIsXTFValid));
      localHashMap.put("param_HttpTime", String.valueOf(((ResultReport)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp.mu64HttpTime));
      localHashMap.put("param_SrvReturCode", String.valueOf(((ResultReport)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp.mnSrvReturCode));
      localHashMap.put("param_TransferSpeed", String.valueOf(((ResultReport)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp.mu64TransferSpeed));
      localHashMap.put("param_TransferSize", String.valueOf(((ResultReport)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp.mu64TransferSize));
      localHashMap.put("param_StartSize", String.valueOf(((ResultReport)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp.mu64StartSize));
      localHashMap.put("param_ServerIp", String.valueOf(((ResultReport)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp.mstrServerIp));
      localHashMap.put("param_ServerPort", String.valueOf(((ResultReport)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp.mwServerPort));
      localHashMap.put("param_FileUrl", String.valueOf(((ResultReport)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp.mstrFileUrl));
      localHashMap.put("param_MaxUploadingFtnNum", String.valueOf(((ResultReport)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp.muMaxUploadingFtnNum));
      localHashMap.put("param_RetryCount", String.valueOf(((ResultReport)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp.muRetryCount));
      localHashMap.put("param_IpChangeCount", String.valueOf(((ResultReport)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp.muIpChangeCount));
      localHashMap.put("param_RollBackCount", String.valueOf(((ResultReport)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp.muRollBackCount));
      localHashMap.put("param_QueryHoleCount", String.valueOf(((ResultReport)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp.muQueryHoleCount));
      localHashMap.put("param_RangDiffCount", String.valueOf(((ResultReport)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp.muRangDiffCount));
      localHashMap.put("param_DelayTotoalCount", String.valueOf(((ResultReport)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp.muDelayTotoalCount));
      localHashMap.put("param_TcpCnnCode", String.valueOf(((ResultReport)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp.mnTcpCnnCode));
      localHashMap.put("param_TcpSocketCode", String.valueOf(((ResultReport)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp.mnTcpSocketCode));
      localHashMap.put("param_HttpsSupport", String.valueOf(((ResultReport)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp.mwHttpsSupport));
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
    localObject = this;
    localHashMap.put("param_V6SelectType", String.valueOf(((ResultReport)localObject).b));
    localHashMap.put("param_ipAddrType", String.valueOf(((ResultReport)localObject).c));
    localHashMap.put("param_stackType", String.valueOf(UFTDependFeatureApi.d()));
    localHashMap.put("param_loginType", String.valueOf(UFTDependFeatureApi.e()));
    localHashMap.put("param_ishttps", String.valueOf(((ResultReport)localObject).d));
    if ((!UFTDependFeatureApi.a()) || ((((ResultReport)localObject).jdField_a_of_type_MqqAppAppRuntime != null) && (!((ResultReport)localObject).jdField_a_of_type_MqqAppAppRuntime.isLogin()))) {
      localHashMap.put("param_Result", String.valueOf(2));
    }
    if (paramBoolean)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(">>> Extf_Troop_Suc_DR:actType[");
      ((StringBuilder)localObject).append(a());
      ((StringBuilder)localObject).append("] params:");
      ((StringBuilder)localObject).append(localHashMap.toString());
      UFTLog.b("[UFTTransfer] UFTToopExtfReportData", 1, ((StringBuilder)localObject).toString());
      return localHashMap;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(">>> ExtfTroop_Fail_DR:actType[");
    ((StringBuilder)localObject).append(a());
    ((StringBuilder)localObject).append("] params:");
    ((StringBuilder)localObject).append(localHashMap.toString());
    UFTLog.d("[UFTTransfer] UFTToopExtfReportData", 1, ((StringBuilder)localObject).toString());
    return localHashMap;
  }
  
  public void a(ExcitingTransferUploadResultRp paramExcitingTransferUploadResultRp)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp = paramExcitingTransferUploadResultRp;
  }
  
  public void b(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void b(long paramLong)
  {
    this.e = paramLong;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void c(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void c(long paramLong)
  {
    this.g = paramLong;
  }
  
  public void c(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.upload.UFTTroopExtfReportData.ResultReport
 * JD-Core Version:    0.7.0.1
 */