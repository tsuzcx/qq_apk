package com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.datareport;

import android.text.TextUtils;
import com.tencent.falco.base.libapi.datareport.DataReportInterface;
import com.tencent.falco.base.libapi.datareport.QualityReportTask;
import java.util.HashMap;
import java.util.Map;

public class QualityReportTaskImpl
  implements QualityReportTask
{
  private int jdField_a_of_type_Int = 1;
  CustomDataReportService jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedSdkservicesDatareportCustomDataReportService;
  String jdField_a_of_type_JavaLangString;
  Map<String, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean = false;
  
  public QualityReportTask addKeyValue(String paramString, double paramDouble)
  {
    this.jdField_a_of_type_JavaUtilMap.put(paramString, String.valueOf(paramDouble));
    return this;
  }
  
  public QualityReportTask addKeyValue(String paramString, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilMap.put(paramString, String.valueOf(paramInt));
    return this;
  }
  
  public QualityReportTask addKeyValue(String paramString, long paramLong)
  {
    this.jdField_a_of_type_JavaUtilMap.put(paramString, String.valueOf(paramLong));
    return this;
  }
  
  public QualityReportTask addKeyValue(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaUtilMap.put(paramString1, paramString2);
    return this;
  }
  
  public void send()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      int i = this.jdField_a_of_type_Int;
      if (i == 2)
      {
        this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedSdkservicesDatareportCustomDataReportService.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilMap, this.jdField_a_of_type_Boolean);
        return;
      }
      if (i == 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedSdkservicesDatareportCustomDataReportService.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilMap, this.jdField_a_of_type_Boolean);
        return;
      }
      if (i == 3) {
        this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedSdkservicesDatareportCustomDataReportService.a(this.jdField_a_of_type_JavaUtilMap, this.jdField_a_of_type_Boolean);
      }
      return;
    }
    throw new NullPointerException("缺少上报基础字段，请检查 actType以及他们的描述");
  }
  
  public QualityReportTask setActType(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilMap.put("act_type", paramString);
    return this;
  }
  
  public QualityReportTask setActTypeDesc(String paramString)
  {
    this.jdField_a_of_type_JavaUtilMap.put("act_type_desc", paramString);
    return this;
  }
  
  public void setDataReportService(DataReportInterface paramDataReportInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedSdkservicesDatareportCustomDataReportService = ((CustomDataReportService)paramDataReportInterface);
  }
  
  public QualityReportTask setModule(String paramString)
  {
    this.jdField_a_of_type_JavaUtilMap.put("page_module", paramString);
    return this;
  }
  
  public QualityReportTask setModuleDes(String paramString)
  {
    this.jdField_a_of_type_JavaUtilMap.put("page_module_desc", paramString);
    return this;
  }
  
  public QualityReportTask setPage(String paramString)
  {
    this.jdField_a_of_type_JavaUtilMap.put("page", paramString);
    return this;
  }
  
  public QualityReportTask setPageDes(String paramString)
  {
    this.jdField_a_of_type_JavaUtilMap.put("page_desc", paramString);
    return this;
  }
  
  public void setQualityType(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public QualityReportTask setRealTimeUpload(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.datareport.QualityReportTaskImpl
 * JD-Core Version:    0.7.0.1
 */