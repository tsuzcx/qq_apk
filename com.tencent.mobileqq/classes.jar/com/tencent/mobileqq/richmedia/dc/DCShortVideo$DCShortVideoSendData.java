package com.tencent.mobileqq.richmedia.dc;

import java.util.HashMap;

class DCShortVideo$DCShortVideoSendData
  extends DCShortVideo.DCShortVideoReportData
{
  public int a;
  long jdField_a_of_type_Long = 0L;
  public String a;
  boolean jdField_a_of_type_Boolean = false;
  long jdField_b_of_type_Long = 0L;
  String jdField_b_of_type_JavaLangString = "";
  boolean jdField_b_of_type_Boolean = false;
  public int i = 0;
  int j = -1;
  int k = -1;
  int l = 1001;
  
  DCShortVideo$DCShortVideoSendData()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = -1;
  }
  
  public HashMap<String, String> a(String paramString)
  {
    if ("ShortVideo.Send".equals(paramString))
    {
      paramString = new HashMap();
      paramString.put("param_DetailUrl", this.jdField_a_of_type_JavaLangString);
      paramString.put("param_uinType", this.jdField_b_of_type_Int + "");
      paramString.put("param_GroupMemberCount", this.c + "");
      paramString.put("param_isForward", this.jdField_a_of_type_Boolean + "");
      paramString.put("param_isExist", this.jdField_b_of_type_Boolean + "");
      paramString.put("param_forwardSourceUinType", this.jdField_a_of_type_Int + "");
      paramString.put("param_forwardSourceGroupMemberCount", this.i + "");
      paramString.put("param_age", this.d + "");
      paramString.put("param_gender", this.e + "");
      paramString.put("param_userType", this.l + "");
      paramString.put("param_shortVideoType", this.f + "");
      paramString.put("param_shortVideoSourceType", this.j + "");
      paramString.put("param_reportHour", this.g + "");
      paramString.put("param_fileInterval", this.k + "");
      paramString.put("param_netType", this.h + "");
      paramString.put("param_md5", this.jdField_b_of_type_JavaLangString);
      paramString.put("param_fileSize", this.jdField_a_of_type_Long + "");
      paramString.put("param_duration", this.jdField_b_of_type_Long + "");
      return paramString;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.dc.DCShortVideo.DCShortVideoSendData
 * JD-Core Version:    0.7.0.1
 */