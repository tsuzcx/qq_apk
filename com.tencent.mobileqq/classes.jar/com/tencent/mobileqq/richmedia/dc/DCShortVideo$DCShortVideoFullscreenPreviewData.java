package com.tencent.mobileqq.richmedia.dc;

import java.util.HashMap;

class DCShortVideo$DCShortVideoFullscreenPreviewData
  extends DCShortVideo.DCShortVideoReportData
{
  long a = 0L;
  long b;
  
  DCShortVideo$DCShortVideoFullscreenPreviewData()
  {
    this.jdField_b_of_type_Long = -1L;
  }
  
  public HashMap<String, String> a(String paramString)
  {
    if ("ShortVideo.FullscreenPreview".equals(paramString))
    {
      paramString = new HashMap();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_b_of_type_Int);
      localStringBuilder.append("");
      paramString.put("param_uinType", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.c);
      localStringBuilder.append("");
      paramString.put("param_GroupMemberCount", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.d);
      localStringBuilder.append("");
      paramString.put("param_age", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.e);
      localStringBuilder.append("");
      paramString.put("param_gender", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.f);
      localStringBuilder.append("");
      paramString.put("param_shortVideoType", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.a);
      localStringBuilder.append("");
      paramString.put("param_duration", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.g);
      localStringBuilder.append("");
      paramString.put("param_reportHour", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.h);
      localStringBuilder.append("");
      paramString.put("param_netType", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_b_of_type_Long);
      localStringBuilder.append("");
      paramString.put("param_playTimeCost", localStringBuilder.toString());
      return paramString;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.dc.DCShortVideo.DCShortVideoFullscreenPreviewData
 * JD-Core Version:    0.7.0.1
 */