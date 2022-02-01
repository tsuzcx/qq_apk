package com.tencent.mobileqq.uftransfer.task.upload;

import com.tencent.mobileqq.uftransfer.depend.UFTDependFeatureApi;
import java.util.HashMap;
import mqq.app.AppRuntime;

public abstract class UFTTroopExtfReportData$BaseReport
{
  protected final AppRuntime a;
  protected long b = 0L;
  protected int c = 0;
  protected long d = 0L;
  protected long e = 0L;
  protected String f;
  protected String g;
  protected long h = 0L;
  
  public UFTTroopExtfReportData$BaseReport(AppRuntime paramAppRuntime)
  {
    this.a = paramAppRuntime;
  }
  
  protected abstract String a();
  
  protected HashMap<String, String> a(boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_ReportVer", String.valueOf(1));
    localHashMap.put("param_TransferType", String.valueOf(2));
    localHashMap.put("param_Platform", String.valueOf(2));
    localHashMap.put("param_AppType", String.valueOf(0));
    localHashMap.put("param_Result", String.valueOf(this.c));
    localHashMap.put("param_FileName", String.valueOf(this.f));
    localHashMap.put("param_Suffix", String.valueOf(this.g));
    localHashMap.put("param_TargetUin", String.valueOf(this.d));
    localHashMap.put("param_GroupCode", String.valueOf(this.e));
    localHashMap.put("param_FileSize", String.valueOf(this.h));
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
  
  public void b(boolean paramBoolean)
  {
    HashMap localHashMap = a(paramBoolean);
    UFTDependFeatureApi.a(this.a.getCurrentAccountUin(), a(), paramBoolean, 0L, 0L, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.upload.UFTTroopExtfReportData.BaseReport
 * JD-Core Version:    0.7.0.1
 */