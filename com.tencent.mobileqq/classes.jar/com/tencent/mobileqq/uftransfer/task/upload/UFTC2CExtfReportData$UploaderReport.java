package com.tencent.mobileqq.uftransfer.task.upload;

import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploaderRp;
import com.tencent.mobileqq.uftransfer.depend.UFTDependFeatureApi;
import com.tencent.mobileqq.uftransfer.depend.UFTLog;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class UFTC2CExtfReportData$UploaderReport
{
  final AppRuntime a;
  long b = 0L;
  int c = 0;
  long d = 0L;
  long e = 0L;
  String f;
  String g;
  long h = 0L;
  ExcitingTransferUploaderRp i;
  int j = 0;
  int k = 0;
  int l = 0;
  
  public UFTC2CExtfReportData$UploaderReport(AppRuntime paramAppRuntime)
  {
    this.a = paramAppRuntime;
  }
  
  protected HashMap<String, String> a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_TransferType", String.valueOf(0));
    localHashMap.put("param_Platform", String.valueOf(2));
    localHashMap.put("param_AppType", String.valueOf(0));
    localHashMap.put("param_Result", String.valueOf(this.c));
    localHashMap.put("param_FileName", String.valueOf(this.f));
    localHashMap.put("param_Suffix", String.valueOf(this.g));
    localHashMap.put("param_TargetUin", String.valueOf(this.d));
    localHashMap.put("param_GroupCode", String.valueOf(this.e));
    localHashMap.put("param_FileSize", String.valueOf(this.h));
    Object localObject = this.i;
    if (localObject != null)
    {
      localHashMap.put("param_Result", String.valueOf(((ExcitingTransferUploaderRp)localObject).mnResult));
      localHashMap.put("param_IsBigData", String.valueOf(this.i.mbIsBigData));
      localHashMap.put("param_HttpTime", String.valueOf(this.i.mu64HttpTime));
      localHashMap.put("param_SrvReturCode", String.valueOf(this.i.mnSrvReturCode));
      localHashMap.put("param_TransferSpeed", String.valueOf(this.i.mu64TransferSpeed));
      localHashMap.put("param_TransferSize", String.valueOf(this.i.mu64TransferSize));
      localHashMap.put("param_ServerIp", String.valueOf(this.i.mstrServerIp));
      localHashMap.put("param_ServerPort", String.valueOf(this.i.mwServerPort));
      localHashMap.put("param_FileUrl", String.valueOf(this.i.mstrFileUrl));
    }
    else
    {
      localHashMap.put("param_IsBigData", String.valueOf(false));
      localHashMap.put("param_HttpTime", String.valueOf(0));
      localHashMap.put("param_SrvReturCode", String.valueOf(0));
      localHashMap.put("param_TransferSpeed", String.valueOf(0));
      localHashMap.put("param_TransferSize", String.valueOf(0));
      localHashMap.put("param_ServerIp", String.valueOf(0));
      localHashMap.put("param_ServerPort", String.valueOf(0));
      localHashMap.put("param_FileUrl", "");
    }
    localHashMap.put("param_V6SelectType", String.valueOf(this.j));
    localHashMap.put("param_ipAddrType", String.valueOf(this.k));
    localHashMap.put("param_stackType", String.valueOf(UFTDependFeatureApi.h()));
    localHashMap.put("param_loginType", String.valueOf(UFTDependFeatureApi.i()));
    localHashMap.put("param_ishttps", String.valueOf(this.l));
    if (UFTDependFeatureApi.c())
    {
      localObject = this.a;
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
    this.c = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.b = paramLong;
  }
  
  public void a(long paramLong1, long paramLong2, String paramString1, String paramString2, long paramLong3)
  {
    this.d = paramLong1;
    this.e = paramLong2;
    this.f = paramString1;
    this.g = paramString2;
    this.h = paramLong3;
  }
  
  public void a(ExcitingTransferUploaderRp paramExcitingTransferUploaderRp)
  {
    this.i = paramExcitingTransferUploaderRp;
  }
  
  public void a(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void b(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void b(boolean paramBoolean)
  {
    HashMap localHashMap = a();
    String str = "null";
    StringBuilder localStringBuilder;
    if (paramBoolean)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Id[");
      localStringBuilder.append(this.b);
      localStringBuilder.append("] >>> Extf_C2CUper_Suc_DR:act[");
      localStringBuilder.append("actC2CXTFUploadSender");
      localStringBuilder.append("]");
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
      localStringBuilder.append(this.b);
      localStringBuilder.append("] >>> Extf_C2CUper_Fail_DR:act[");
      localStringBuilder.append("actC2CXTFUploadSender");
      localStringBuilder.append("]");
      if (localHashMap != null) {
        str = localHashMap.toString();
      }
      localStringBuilder.append(str);
      UFTLog.d("[UFTTransfer] UFTC2CExtfReportData", 1, localStringBuilder.toString());
    }
    UFTDependFeatureApi.a(this.a.getCurrentAccountUin(), "actC2CXTFUploadSender", paramBoolean, 0L, 0L, localHashMap, "");
  }
  
  public void c(int paramInt)
  {
    this.k = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.upload.UFTC2CExtfReportData.UploaderReport
 * JD-Core Version:    0.7.0.1
 */