package com.tencent.mobileqq.filemanager.data;

import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class FilePreviewDataReporter
{
  public int a;
  public long a;
  public final String a;
  public boolean a;
  public long b;
  public final String b;
  public long c;
  public String c;
  public long d;
  public String d;
  public long e;
  public String e;
  public long f;
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  public String k;
  public String l;
  String m = null;
  
  public FilePreviewDataReporter(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = "FilePreviewDataReporter<FileAssistant>";
    this.jdField_b_of_type_JavaLangString = "actFilePreview";
    this.m = paramString;
  }
  
  private HashMap a()
  {
    HashMap localHashMap = new HashMap();
    if (!NetworkUtil.d(BaseApplication.getContext()))
    {
      this.jdField_e_of_type_JavaLangString = String.valueOf(9004);
      this.i += "_NotNetWork";
    }
    localHashMap.put("param_serverip", String.valueOf(this.jdField_c_of_type_JavaLangString));
    localHashMap.put("param_uuid", String.valueOf(this.jdField_d_of_type_JavaLangString));
    localHashMap.put("param_FailCode", String.valueOf(this.jdField_e_of_type_JavaLangString));
    localHashMap.put("param_fsizeo", String.valueOf(this.jdField_b_of_type_Long));
    localHashMap.put("param_url", String.valueOf(this.jdField_f_of_type_JavaLangString));
    localHashMap.put("param_key", String.valueOf(this.g));
    localHashMap.put("param_retry", String.valueOf(this.jdField_a_of_type_Int));
    localHashMap.put("param_errMsg", String.valueOf(this.i));
    localHashMap.put("param_fileName", String.valueOf(this.h));
    localHashMap.put("param_fileExt", String.valueOf(this.j));
    localHashMap.put("param_source", String.valueOf(this.k));
    localHashMap.put("param_stage", String.valueOf(this.l));
    localHashMap.put("param_stagetimelen", String.valueOf(this.jdField_c_of_type_Long));
    localHashMap.put("param_staytimelen", String.valueOf(this.jdField_d_of_type_Long));
    this.i = "";
    return localHashMap;
  }
  
  public void a()
  {
    HashMap localHashMap = a();
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doReport:bSuccess[" + this.jdField_a_of_type_Boolean + "],");
      localStringBuilder.append("strReportUin[" + this.m + "],");
      localStringBuilder.append("startTime[" + this.jdField_e_of_type_Long + "],");
      localStringBuilder.append("endTime[" + this.jdField_f_of_type_Long + "],");
      Iterator localIterator = localHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localStringBuilder.append(str + "[" + (String)localHashMap.get(str) + "]");
      }
      QLog.i("FilePreviewDataReporter<FileAssistant>", 4, "doReport:" + localStringBuilder.toString());
    }
    StatisticCollector.a(BaseApplication.getContext()).a(this.m, "actFilePreview", this.jdField_a_of_type_Boolean, 0L, 0L, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.FilePreviewDataReporter
 * JD-Core Version:    0.7.0.1
 */