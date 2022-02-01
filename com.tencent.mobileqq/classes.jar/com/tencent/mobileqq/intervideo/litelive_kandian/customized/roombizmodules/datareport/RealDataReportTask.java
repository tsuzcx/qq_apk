package com.tencent.mobileqq.intervideo.litelive_kandian.customized.roombizmodules.datareport;

import android.text.TextUtils;
import com.tencent.falco.base.libapi.datareport.DataReportInterface;
import com.tencent.falco.base.libapi.datareport.ReportTask;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class RealDataReportTask
  implements ReportTask
{
  DataReportInterface jdField_a_of_type_ComTencentFalcoBaseLibapiDatareportDataReportInterface;
  String jdField_a_of_type_JavaLangString;
  Map<String, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  String b;
  String c;
  
  public ReportTask addKeyValue(String paramString, double paramDouble)
  {
    this.jdField_a_of_type_JavaUtilMap.put(paramString, String.valueOf(paramDouble));
    return this;
  }
  
  public ReportTask addKeyValue(String paramString, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilMap.put(paramString, String.valueOf(paramInt));
    return this;
  }
  
  public ReportTask addKeyValue(String paramString, long paramLong)
  {
    this.jdField_a_of_type_JavaUtilMap.put(paramString, String.valueOf(paramLong));
    return this;
  }
  
  public ReportTask addKeyValue(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaUtilMap.put(paramString1, paramString2);
    return this;
  }
  
  public void send()
  {
    String str = this.c + "#" + this.jdField_a_of_type_JavaLangString + "#" + this.b;
    if ((!TextUtils.isEmpty(this.c)) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.b)) && (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilMap.get("page_desc"))) && (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilMap.get("page_module_desc"))) && (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilMap.get("act_type_desc"))))
    {
      this.jdField_a_of_type_ComTencentFalcoBaseLibapiDatareportDataReportInterface.reportEvent(str, true, -1L, -1L, this.jdField_a_of_type_JavaUtilMap, true, true);
      return;
    }
    QLog.e("RealDataReportTask", 1, "缺少上报基础字段，请检查 page,module,actType以及他们的描述");
  }
  
  public ReportTask setActType(String paramString)
  {
    this.c = paramString;
    this.jdField_a_of_type_JavaUtilMap.put("act_type", paramString);
    return this;
  }
  
  public ReportTask setActTypeDesc(String paramString)
  {
    this.jdField_a_of_type_JavaUtilMap.put("act_type_desc", paramString);
    return this;
  }
  
  public ReportTask setCommonet(String paramString)
  {
    this.jdField_a_of_type_JavaUtilMap.put("report_commoent", paramString);
    return this;
  }
  
  public void setDataReportService(DataReportInterface paramDataReportInterface)
  {
    this.jdField_a_of_type_ComTencentFalcoBaseLibapiDatareportDataReportInterface = paramDataReportInterface;
  }
  
  public ReportTask setModule(String paramString)
  {
    this.b = paramString;
    this.jdField_a_of_type_JavaUtilMap.put("page_module", paramString);
    return this;
  }
  
  public ReportTask setModuleDesc(String paramString)
  {
    this.jdField_a_of_type_JavaUtilMap.put("page_module_desc", paramString);
    return this;
  }
  
  public ReportTask setPage(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilMap.put("page", paramString);
    return this;
  }
  
  public ReportTask setPageDesc(String paramString)
  {
    this.jdField_a_of_type_JavaUtilMap.put("page_desc", paramString);
    return this;
  }
  
  public ReportTask setRealTimeUpload(boolean paramBoolean)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.litelive_kandian.customized.roombizmodules.datareport.RealDataReportTask
 * JD-Core Version:    0.7.0.1
 */