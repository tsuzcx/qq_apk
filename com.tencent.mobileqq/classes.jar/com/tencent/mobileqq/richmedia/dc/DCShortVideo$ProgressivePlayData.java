package com.tencent.mobileqq.richmedia.dc;

import java.util.HashMap;

class DCShortVideo$ProgressivePlayData
  extends DataAdapter
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  boolean jdField_a_of_type_Boolean;
  int b;
  int c;
  int d;
  int e;
  int f;
  int g;
  
  public HashMap<String, String> a(String paramString)
  {
    if ("actStreamingVideoPlay".equalsIgnoreCase(paramString))
    {
      paramString = new HashMap();
      paramString.put("StreamingVideoSupport", String.valueOf(this.jdField_a_of_type_Boolean));
      paramString.put("FirstBufferTime", String.valueOf(this.jdField_a_of_type_Int));
      paramString.put("PlayProgress", String.valueOf(this.b));
      paramString.put("LoadProgress", String.valueOf(this.c));
      paramString.put("FileDuration", String.valueOf(this.d));
      paramString.put("FileLen", String.valueOf(this.e));
      paramString.put("param_seekTimes", String.valueOf(this.f));
      paramString.put("PlayResult", String.valueOf(this.g));
      paramString.put("param_playTimeCost", String.valueOf(this.jdField_a_of_type_Long));
      return paramString;
    }
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("supportProgressive ").append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append("playReadyTime ").append(this.jdField_a_of_type_Int);
    localStringBuilder.append("exitPlayProgress ").append(this.b);
    localStringBuilder.append("exitCacheProgress ").append(this.c);
    localStringBuilder.append("durationTime ").append(this.d);
    localStringBuilder.append("fileSize ").append(this.e);
    localStringBuilder.append("seekTimes ").append(this.f);
    localStringBuilder.append("playResult ").append(this.g);
    localStringBuilder.append("playTimeCost").append(this.jdField_a_of_type_Long);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.dc.DCShortVideo.ProgressivePlayData
 * JD-Core Version:    0.7.0.1
 */