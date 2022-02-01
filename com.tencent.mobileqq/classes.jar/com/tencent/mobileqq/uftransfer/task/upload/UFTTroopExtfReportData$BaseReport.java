package com.tencent.mobileqq.uftransfer.task.upload;

import com.tencent.mobileqq.uftransfer.depend.UFTDependFeatureApi;
import java.util.HashMap;
import mqq.app.AppRuntime;

public abstract class UFTTroopExtfReportData$BaseReport
{
  protected int a;
  protected long a;
  protected String a;
  protected final AppRuntime a;
  protected long b;
  protected String b;
  protected long c = 0L;
  protected long d = 0L;
  
  public UFTTroopExtfReportData$BaseReport(AppRuntime paramAppRuntime)
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
  }
  
  protected abstract String a();
  
  protected HashMap<String, String> a(boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_ReportVer", String.valueOf(1));
    localHashMap.put("param_TransferType", String.valueOf(2));
    localHashMap.put("param_Platform", String.valueOf(2));
    localHashMap.put("param_AppType", String.valueOf(0));
    localHashMap.put("param_Result", String.valueOf(this.jdField_a_of_type_Int));
    localHashMap.put("param_FileName", String.valueOf(this.jdField_a_of_type_JavaLangString));
    localHashMap.put("param_Suffix", String.valueOf(this.jdField_b_of_type_JavaLangString));
    localHashMap.put("param_TargetUin", String.valueOf(this.jdField_b_of_type_Long));
    localHashMap.put("param_GroupCode", String.valueOf(this.c));
    localHashMap.put("param_FileSize", String.valueOf(this.d));
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
    this.c = paramLong2;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.d = paramLong3;
  }
  
  public void a(boolean paramBoolean)
  {
    HashMap localHashMap = a(paramBoolean);
    UFTDependFeatureApi.a(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin(), a(), paramBoolean, 0L, 0L, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.upload.UFTTroopExtfReportData.BaseReport
 * JD-Core Version:    0.7.0.1
 */