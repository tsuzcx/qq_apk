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
      paramString.put("param_uinType", this.b + "");
      paramString.put("param_GroupMemberCount", this.c + "");
      paramString.put("param_age", this.d + "");
      paramString.put("param_gender", this.e + "");
      paramString.put("param_shortVideoType", this.f + "");
      paramString.put("param_reportHour", this.g + "");
      paramString.put("param_netType", this.h + "");
      paramString.put("param_playAction", this.a + "");
      return paramString;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.dc.DCShortVideo.DCShortVideoPreviewData
 * JD-Core Version:    0.7.0.1
 */