package com.tencent.mobileqq.richmedia.dc;

import java.util.HashMap;

class DCShortVideo$DCShortVideoPreviewData
  extends DCShortVideo.DCShortVideoReportData
{
  int a = -1;
  
  public HashMap<String, String> a(String paramString)
  {
    if ("ShortVideo.Preview".equals(paramString))
    {
      paramString = new HashMap();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.c);
      localStringBuilder.append("");
      paramString.put("param_uinType", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.d);
      localStringBuilder.append("");
      paramString.put("param_GroupMemberCount", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.e);
      localStringBuilder.append("");
      paramString.put("param_age", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.f);
      localStringBuilder.append("");
      paramString.put("param_gender", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.g);
      localStringBuilder.append("");
      paramString.put("param_shortVideoType", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.h);
      localStringBuilder.append("");
      paramString.put("param_reportHour", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.i);
      localStringBuilder.append("");
      paramString.put("param_netType", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.a);
      localStringBuilder.append("");
      paramString.put("param_playAction", localStringBuilder.toString());
      return paramString;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.dc.DCShortVideo.DCShortVideoPreviewData
 * JD-Core Version:    0.7.0.1
 */