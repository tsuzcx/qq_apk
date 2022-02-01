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
    localStringBuilder.append("supportProgressive ");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append("playReadyTime ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append("exitPlayProgress ");
    localStringBuilder.append(this.b);
    localStringBuilder.append("exitCacheProgress ");
    localStringBuilder.append(this.c);
    localStringBuilder.append("durationTime ");
    localStringBuilder.append(this.d);
    localStringBuilder.append("fileSize ");
    localStringBuilder.append(this.e);
    localStringBuilder.append("seekTimes ");
    localStringBuilder.append(this.f);
    localStringBuilder.append("playResult ");
    localStringBuilder.append(this.g);
    localStringBuilder.append("playTimeCost");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.dc.DCShortVideo.ProgressivePlayData
 * JD-Core Version:    0.7.0.1
 */