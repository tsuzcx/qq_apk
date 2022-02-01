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
  public String b;
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
  String l = null;
  
  public FilePreviewDataReporter(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = "actFilePreview";
    this.l = paramString;
  }
  
  private HashMap<String, String> a()
  {
    HashMap localHashMap = new HashMap();
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      this.jdField_d_of_type_JavaLangString = String.valueOf(9004);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.h);
      localStringBuilder.append("_NotNetWork");
      this.h = localStringBuilder.toString();
    }
    localHashMap.put("param_serverip", String.valueOf(this.jdField_b_of_type_JavaLangString));
    localHashMap.put("param_uuid", String.valueOf(this.jdField_c_of_type_JavaLangString));
    localHashMap.put("param_FailCode", String.valueOf(this.jdField_d_of_type_JavaLangString));
    localHashMap.put("param_fsizeo", String.valueOf(this.jdField_b_of_type_Long));
    localHashMap.put("param_url", String.valueOf(this.jdField_e_of_type_JavaLangString));
    localHashMap.put("param_key", String.valueOf(this.jdField_f_of_type_JavaLangString));
    localHashMap.put("param_retry", String.valueOf(this.jdField_a_of_type_Int));
    localHashMap.put("param_errMsg", String.valueOf(this.h));
    localHashMap.put("param_fileName", String.valueOf(this.g));
    localHashMap.put("param_fileExt", String.valueOf(this.i));
    localHashMap.put("param_source", String.valueOf(this.j));
    localHashMap.put("param_stage", String.valueOf(this.k));
    localHashMap.put("param_stagetimelen", String.valueOf(this.jdField_c_of_type_Long));
    localHashMap.put("param_staytimelen", String.valueOf(this.jdField_d_of_type_Long));
    this.h = "";
    return localHashMap;
  }
  
  public void a()
  {
    HashMap localHashMap = a();
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doReport:bSuccess[");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
      ((StringBuilder)localObject).append("],");
      localStringBuilder1.append(((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("strReportUin[");
      ((StringBuilder)localObject).append(this.l);
      ((StringBuilder)localObject).append("],");
      localStringBuilder1.append(((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startTime[");
      ((StringBuilder)localObject).append(this.jdField_e_of_type_Long);
      ((StringBuilder)localObject).append("],");
      localStringBuilder1.append(((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("endTime[");
      ((StringBuilder)localObject).append(this.jdField_f_of_type_Long);
      ((StringBuilder)localObject).append("],");
      localStringBuilder1.append(((StringBuilder)localObject).toString());
      localObject = localHashMap.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(str);
        localStringBuilder2.append("[");
        localStringBuilder2.append((String)localHashMap.get(str));
        localStringBuilder2.append("]");
        localStringBuilder1.append(localStringBuilder2.toString());
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doReport:");
      ((StringBuilder)localObject).append(localStringBuilder1.toString());
      QLog.i("FilePreviewDataReporter<FileAssistant>", 4, ((StringBuilder)localObject).toString());
    }
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.l, "actFilePreview", this.jdField_a_of_type_Boolean, 0L, 0L, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.FilePreviewDataReporter
 * JD-Core Version:    0.7.0.1
 */