package com.tencent.mobileqq.uftransfer.task.upload;

import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadResultRp;
import com.tencent.mobileqq.uftransfer.depend.UFTDependFeatureApi;
import com.tencent.mobileqq.uftransfer.depend.UFTLog;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class UFTTroopExtfReportData$ResultReport
  extends UFTTroopExtfReportData.BaseReport
{
  boolean i = false;
  long j = 0L;
  long k = 0L;
  long l;
  ExcitingTransferUploadResultRp m;
  int n = 0;
  int o = 0;
  int p = 0;
  
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
    localHashMap.put("param_IsFlashFile", String.valueOf(((ResultReport)localObject).i));
    localHashMap.put("param_TotalCostTime", String.valueOf(((ResultReport)localObject).l));
    localHashMap.put("param_CalcShaCostTime", String.valueOf(((ResultReport)localObject).j));
    localHashMap.put("param_CalcHashCostTime", String.valueOf(((ResultReport)localObject).k));
    ExcitingTransferUploadResultRp localExcitingTransferUploadResultRp = ((ResultReport)localObject).m;
    if (localExcitingTransferUploadResultRp != null)
    {
      localHashMap.put("param_Result", String.valueOf(localExcitingTransferUploadResultRp.mnResult));
      localHashMap.put("param_IsXTFValid", String.valueOf(((ResultReport)localObject).m.mbIsXTFValid));
      localHashMap.put("param_HttpTime", String.valueOf(((ResultReport)localObject).m.mu64HttpTime));
      localHashMap.put("param_SrvReturCode", String.valueOf(((ResultReport)localObject).m.mnSrvReturCode));
      localHashMap.put("param_TransferSpeed", String.valueOf(((ResultReport)localObject).m.mu64TransferSpeed));
      localHashMap.put("param_TransferSize", String.valueOf(((ResultReport)localObject).m.mu64TransferSize));
      localHashMap.put("param_StartSize", String.valueOf(((ResultReport)localObject).m.mu64StartSize));
      localHashMap.put("param_ServerIp", String.valueOf(((ResultReport)localObject).m.mstrServerIp));
      localHashMap.put("param_ServerPort", String.valueOf(((ResultReport)localObject).m.mwServerPort));
      localHashMap.put("param_FileUrl", String.valueOf(((ResultReport)localObject).m.mstrFileUrl));
      localHashMap.put("param_MaxUploadingFtnNum", String.valueOf(((ResultReport)localObject).m.muMaxUploadingFtnNum));
      localHashMap.put("param_RetryCount", String.valueOf(((ResultReport)localObject).m.muRetryCount));
      localHashMap.put("param_IpChangeCount", String.valueOf(((ResultReport)localObject).m.muIpChangeCount));
      localHashMap.put("param_RollBackCount", String.valueOf(((ResultReport)localObject).m.muRollBackCount));
      localHashMap.put("param_QueryHoleCount", String.valueOf(((ResultReport)localObject).m.muQueryHoleCount));
      localHashMap.put("param_RangDiffCount", String.valueOf(((ResultReport)localObject).m.muRangDiffCount));
      localHashMap.put("param_DelayTotoalCount", String.valueOf(((ResultReport)localObject).m.muDelayTotoalCount));
      localHashMap.put("param_TcpCnnCode", String.valueOf(((ResultReport)localObject).m.mnTcpCnnCode));
      localHashMap.put("param_TcpSocketCode", String.valueOf(((ResultReport)localObject).m.mnTcpSocketCode));
      localHashMap.put("param_HttpsSupport", String.valueOf(((ResultReport)localObject).m.mwHttpsSupport));
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
    localHashMap.put("param_V6SelectType", String.valueOf(((ResultReport)localObject).n));
    localHashMap.put("param_ipAddrType", String.valueOf(((ResultReport)localObject).o));
    localHashMap.put("param_stackType", String.valueOf(UFTDependFeatureApi.h()));
    localHashMap.put("param_loginType", String.valueOf(UFTDependFeatureApi.i()));
    localHashMap.put("param_ishttps", String.valueOf(((ResultReport)localObject).p));
    if ((!UFTDependFeatureApi.c()) || ((((ResultReport)localObject).a != null) && (!((ResultReport)localObject).a.isLogin()))) {
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
    this.m = paramExcitingTransferUploadResultRp;
  }
  
  public void b(int paramInt)
  {
    this.n = paramInt;
  }
  
  public void b(long paramLong)
  {
    this.j = paramLong;
  }
  
  public void c(int paramInt)
  {
    this.o = paramInt;
  }
  
  public void c(long paramLong)
  {
    this.l = paramLong;
  }
  
  public void c(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public void d(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.upload.UFTTroopExtfReportData.ResultReport
 * JD-Core Version:    0.7.0.1
 */