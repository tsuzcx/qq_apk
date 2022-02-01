package com.tencent.mobileqq.richmedia.dc;

import java.util.HashMap;

class DCShortVideo$ProgressivePlayData
  extends DataAdapter
{
  boolean a;
  int b;
  int c;
  int d;
  int e;
  int f;
  int g;
  int h;
  long i;
  
  public HashMap<String, String> a(String paramString)
  {
    if ("actStreamingVideoPlay".equalsIgnoreCase(paramString))
    {
      paramString = new HashMap();
      paramString.put("StreamingVideoSupport", String.valueOf(this.a));
      paramString.put("FirstBufferTime", String.valueOf(this.b));
      paramString.put("PlayProgress", String.valueOf(this.c));
      paramString.put("LoadProgress", String.valueOf(this.d));
      paramString.put("FileDuration", String.valueOf(this.e));
      paramString.put("FileLen", String.valueOf(this.f));
      paramString.put("param_seekTimes", String.valueOf(this.g));
      paramString.put("PlayResult", String.valueOf(this.h));
      paramString.put("param_playTimeCost", String.valueOf(this.i));
      return paramString;
    }
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("supportProgressive ");
    localStringBuilder.append(this.a);
    localStringBuilder.append("playReadyTime ");
    localStringBuilder.append(this.b);
    localStringBuilder.append("exitPlayProgress ");
    localStringBuilder.append(this.c);
    localStringBuilder.append("exitCacheProgress ");
    localStringBuilder.append(this.d);
    localStringBuilder.append("durationTime ");
    localStringBuilder.append(this.e);
    localStringBuilder.append("fileSize ");
    localStringBuilder.append(this.f);
    localStringBuilder.append("seekTimes ");
    localStringBuilder.append(this.g);
    localStringBuilder.append("playResult ");
    localStringBuilder.append(this.h);
    localStringBuilder.append("playTimeCost");
    localStringBuilder.append(this.i);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.dc.DCShortVideo.ProgressivePlayData
 * JD-Core Version:    0.7.0.1
 */