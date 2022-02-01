package com.tencent.mobileqq.kandian.base.video.player.videourl;

import java.util.HashMap;

public class VideoGetUrlReportData
{
  public boolean a;
  public String b;
  public long c;
  public long d;
  public String e;
  public boolean f;
  
  public HashMap<String, String> a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_vid", this.b);
    localHashMap.put("param_success", String.valueOf(this.a).toLowerCase());
    localHashMap.put("param_costTime", String.valueOf(this.c));
    localHashMap.put("param_ret_code", String.valueOf(this.d));
    localHashMap.put("param_err_info", this.e);
    localHashMap.put("param_retry", String.valueOf(this.f));
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.video.player.videourl.VideoGetUrlReportData
 * JD-Core Version:    0.7.0.1
 */