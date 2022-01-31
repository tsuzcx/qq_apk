package com.tencent.mobileqq.filemanager.discoperation;

import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class FileReportData
{
  public int a;
  public long a;
  public String a;
  public int b;
  public long b;
  public String b;
  public long c;
  public String c;
  public long d;
  public String d;
  public long e;
  public String e;
  public long f;
  public String f;
  public long g;
  public String g;
  public long h;
  public String h;
  public long i;
  public String i;
  public long j;
  public String j;
  public String k;
  
  public FileReportData(String paramString1, String paramString2)
  {
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_JavaLangString = paramString2;
  }
  
  String a()
  {
    if (this.jdField_i_of_type_Long == 0L) {
      return "0 KB/s";
    }
    long l = this.f - this.d;
    if (l == 0L) {
      return "0 KB/s";
    }
    float f1 = (float)(this.jdField_i_of_type_Long / 1024L) / (float)(l / 1000L);
    return f1 + " KB/s";
  }
  
  public HashMap a()
  {
    HashMap localHashMap = null;
    Object localObject = localHashMap;
    try
    {
      if (this.jdField_g_of_type_JavaLangString != null)
      {
        localObject = localHashMap;
        if (this.jdField_g_of_type_JavaLangString.length() > 0) {
          localObject = this.jdField_g_of_type_JavaLangString.substring(this.jdField_g_of_type_JavaLangString.indexOf("://") + 3, this.jdField_g_of_type_JavaLangString.lastIndexOf(":"));
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str = this.jdField_g_of_type_JavaLangString;
      }
    }
    localHashMap = new HashMap();
    localHashMap.put("param_serverip", String.valueOf(localObject));
    localHashMap.put("param_Server", String.valueOf(localObject));
    localHashMap.put("param_PeerUin", String.valueOf(this.jdField_h_of_type_JavaLangString));
    localHashMap.put("param_PeerType", String.valueOf(this.jdField_a_of_type_Int));
    localHashMap.put("param_uuid", String.valueOf(this.jdField_i_of_type_JavaLangString));
    localHashMap.put("param_FailCode", Long.toString(this.jdField_a_of_type_Long));
    localHashMap.put("param_fsized", String.valueOf(this.jdField_h_of_type_Long));
    localHashMap.put("param_fsizeo", String.valueOf(this.jdField_j_of_type_Long));
    localHashMap.put("param_url", String.valueOf(this.jdField_g_of_type_JavaLangString));
    localHashMap.put("param_rspHeader", String.valueOf(this.jdField_j_of_type_JavaLangString));
    localHashMap.put("param_retry", String.valueOf(this.jdField_b_of_type_Int));
    localHashMap.put("param_errMsg", String.valueOf(this.jdField_c_of_type_JavaLangString));
    localHashMap.put("param_nSessionId", String.valueOf(this.jdField_b_of_type_Long));
    localHashMap.put("param_CSDuration", String.valueOf(this.d - this.jdField_c_of_type_Long));
    localHashMap.put("param_HttpDuration", String.valueOf(this.f - this.e));
    localHashMap.put("param_AllDuration", String.valueOf(this.jdField_g_of_type_Long - this.jdField_c_of_type_Long));
    return localHashMap;
  }
  
  public void a()
  {
    long l2 = System.currentTimeMillis() - this.f;
    long l1 = l2;
    if (l2 < 0L) {
      l1 = 0L;
    }
    this.jdField_g_of_type_Long = System.currentTimeMillis();
    HashMap localHashMap = a();
    StatisticCollector localStatisticCollector = StatisticCollector.a(BaseApplication.getContext());
    String str1 = this.jdField_b_of_type_JavaLangString;
    String str2 = this.jdField_a_of_type_JavaLangString + "Detail";
    if (this.jdField_a_of_type_Long == 0L) {}
    for (boolean bool = true;; bool = false)
    {
      localStatisticCollector.a(str1, str2, bool, l1, this.jdField_i_of_type_Long, localHashMap, this.k);
      return;
    }
  }
  
  public void b()
  {
    long l2 = System.currentTimeMillis() - this.f;
    long l1 = l2;
    if (l2 < 0L) {
      l1 = 0L;
    }
    this.jdField_g_of_type_Long = System.currentTimeMillis();
    HashMap localHashMap = a();
    StatisticCollector localStatisticCollector = StatisticCollector.a(BaseApplication.getContext());
    String str1 = this.jdField_b_of_type_JavaLangString;
    String str2 = this.jdField_a_of_type_JavaLangString;
    if (this.jdField_a_of_type_Long == 0L) {}
    for (boolean bool = true;; bool = false)
    {
      localStatisticCollector.a(str1, str2, bool, l1, this.jdField_i_of_type_Long, localHashMap, this.k);
      return;
    }
  }
  
  public void c()
  {
    long l2 = System.currentTimeMillis() - this.f;
    long l1 = l2;
    if (l2 < 0L) {
      l1 = 0L;
    }
    this.jdField_g_of_type_Long = System.currentTimeMillis();
    HashMap localHashMap = a();
    StatisticCollector localStatisticCollector = StatisticCollector.a(BaseApplication.getContext());
    String str1 = this.jdField_b_of_type_JavaLangString;
    String str2 = this.jdField_a_of_type_JavaLangString;
    if (this.jdField_a_of_type_Long == 0L)
    {
      bool = true;
      localStatisticCollector.a(str1, str2, bool, l1, this.jdField_i_of_type_Long, localHashMap, this.k);
      localStatisticCollector = StatisticCollector.a(BaseApplication.getContext());
      str1 = this.jdField_b_of_type_JavaLangString;
      str2 = this.jdField_a_of_type_JavaLangString + "Detail";
      if (this.jdField_a_of_type_Long != 0L) {
        break label165;
      }
    }
    label165:
    for (boolean bool = true;; bool = false)
    {
      localStatisticCollector.a(str1, str2, bool, l1, this.jdField_i_of_type_Long, localHashMap, this.k);
      return;
      bool = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.discoperation.FileReportData
 * JD-Core Version:    0.7.0.1
 */