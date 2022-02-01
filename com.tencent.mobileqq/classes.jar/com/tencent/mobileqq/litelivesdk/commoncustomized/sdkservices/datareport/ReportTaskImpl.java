package com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.datareport;

import android.text.TextUtils;
import com.tencent.falco.base.libapi.datareport.DataReportInterface;
import com.tencent.falco.base.libapi.datareport.ReportTask;
import java.util.HashMap;
import java.util.Map;

public class ReportTaskImpl
  implements ReportTask
{
  DataReportInterface jdField_a_of_type_ComTencentFalcoBaseLibapiDatareportDataReportInterface;
  String jdField_a_of_type_JavaLangString;
  Map<String, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  boolean jdField_a_of_type_Boolean = false;
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
    if ((TextUtils.isEmpty(this.c)) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(this.b)) || (TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilMap.get("page_desc"))) || (TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilMap.get("page_module_desc"))) || (TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilMap.get("act_type_desc")))) {
      throw new NullPointerException("缺少上报基础字段，请检查 page,module,actType以及他们的描述");
    }
    this.jdField_a_of_type_ComTencentFalcoBaseLibapiDatareportDataReportInterface.reportEvent(str, this.jdField_a_of_type_JavaUtilMap, this.jdField_a_of_type_Boolean);
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
    this.jdField_a_of_type_Boolean = paramBoolean;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.datareport.ReportTaskImpl
 * JD-Core Version:    0.7.0.1
 */