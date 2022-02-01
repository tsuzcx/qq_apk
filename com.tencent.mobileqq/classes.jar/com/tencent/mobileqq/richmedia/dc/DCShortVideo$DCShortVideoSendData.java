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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_b_of_type_Int);
      localStringBuilder.append("");
      paramString.put("param_uinType", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.c);
      localStringBuilder.append("");
      paramString.put("param_GroupMemberCount", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_Boolean);
      localStringBuilder.append("");
      paramString.put("param_isForward", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_b_of_type_Boolean);
      localStringBuilder.append("");
      paramString.put("param_isExist", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append("");
      paramString.put("param_forwardSourceUinType", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.i);
      localStringBuilder.append("");
      paramString.put("param_forwardSourceGroupMemberCount", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.d);
      localStringBuilder.append("");
      paramString.put("param_age", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.e);
      localStringBuilder.append("");
      paramString.put("param_gender", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.l);
      localStringBuilder.append("");
      paramString.put("param_userType", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.f);
      localStringBuilder.append("");
      paramString.put("param_shortVideoType", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.j);
      localStringBuilder.append("");
      paramString.put("param_shortVideoSourceType", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.g);
      localStringBuilder.append("");
      paramString.put("param_reportHour", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.k);
      localStringBuilder.append("");
      paramString.put("param_fileInterval", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.h);
      localStringBuilder.append("");
      paramString.put("param_netType", localStringBuilder.toString());
      paramString.put("param_md5", this.jdField_b_of_type_JavaLangString);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_Long);
      localStringBuilder.append("");
      paramString.put("param_fileSize", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_b_of_type_Long);
      localStringBuilder.append("");
      paramString.put("param_duration", localStringBuilder.toString());
      return paramString;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.dc.DCShortVideo.DCShortVideoSendData
 * JD-Core Version:    0.7.0.1
 */