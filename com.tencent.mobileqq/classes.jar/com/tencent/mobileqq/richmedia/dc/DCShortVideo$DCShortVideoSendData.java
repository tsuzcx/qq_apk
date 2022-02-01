package com.tencent.mobileqq.richmedia.dc;

import java.util.HashMap;

class DCShortVideo$DCShortVideoSendData
  extends DCShortVideo.DCShortVideoReportData
{
  public String a = "";
  boolean b = false;
  boolean j = false;
  public int k = -1;
  public int l = 0;
  int m = -1;
  int n = -1;
  int o = 1001;
  long p = 0L;
  String q = "";
  long r = 0L;
  
  public HashMap<String, String> a(String paramString)
  {
    if ("ShortVideo.Send".equals(paramString))
    {
      paramString = new HashMap();
      paramString.put("param_DetailUrl", this.a);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.c);
      localStringBuilder.append("");
      paramString.put("param_uinType", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.d);
      localStringBuilder.append("");
      paramString.put("param_GroupMemberCount", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.b);
      localStringBuilder.append("");
      paramString.put("param_isForward", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.j);
      localStringBuilder.append("");
      paramString.put("param_isExist", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.k);
      localStringBuilder.append("");
      paramString.put("param_forwardSourceUinType", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.l);
      localStringBuilder.append("");
      paramString.put("param_forwardSourceGroupMemberCount", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.e);
      localStringBuilder.append("");
      paramString.put("param_age", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.f);
      localStringBuilder.append("");
      paramString.put("param_gender", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.o);
      localStringBuilder.append("");
      paramString.put("param_userType", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.g);
      localStringBuilder.append("");
      paramString.put("param_shortVideoType", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.m);
      localStringBuilder.append("");
      paramString.put("param_shortVideoSourceType", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.h);
      localStringBuilder.append("");
      paramString.put("param_reportHour", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.n);
      localStringBuilder.append("");
      paramString.put("param_fileInterval", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.i);
      localStringBuilder.append("");
      paramString.put("param_netType", localStringBuilder.toString());
      paramString.put("param_md5", this.q);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.p);
      localStringBuilder.append("");
      paramString.put("param_fileSize", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.r);
      localStringBuilder.append("");
      paramString.put("param_duration", localStringBuilder.toString());
      return paramString;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.dc.DCShortVideo.DCShortVideoSendData
 * JD-Core Version:    0.7.0.1
 */