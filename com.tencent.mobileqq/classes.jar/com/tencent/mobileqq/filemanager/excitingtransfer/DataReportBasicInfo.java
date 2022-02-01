package com.tencent.mobileqq.filemanager.excitingtransfer;

import java.util.HashMap;

public class DataReportBasicInfo
{
  public int a;
  public long a;
  public String a;
  public int b;
  public long b;
  private int c;
  public long c;
  public long d;
  
  public DataReportBasicInfo()
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Int = 3;
  }
  
  public HashMap<String, String> a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_Result", String.valueOf(this.jdField_a_of_type_Long));
    localHashMap.put("param_SubReason", String.valueOf(this.jdField_b_of_type_Long));
    localHashMap.put("param_XTFReceiverType", String.valueOf(this.jdField_a_of_type_Int));
    localHashMap.put("param_Suffix", String.valueOf(this.jdField_a_of_type_JavaLangString));
    localHashMap.put("param_TargetUin", String.valueOf(this.jdField_c_of_type_Long));
    localHashMap.put("param_TargetType", String.valueOf(this.jdField_b_of_type_Int));
    localHashMap.put("param_FileSize", String.valueOf(this.d));
    localHashMap.put("param_TranferPlatform", String.valueOf(this.jdField_c_of_type_Int));
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.DataReportBasicInfo
 * JD-Core Version:    0.7.0.1
 */