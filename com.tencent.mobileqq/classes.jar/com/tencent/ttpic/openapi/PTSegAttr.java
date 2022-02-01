package com.tencent.ttpic.openapi;

import com.tencent.aekit.openrender.internal.Frame;
import java.util.Map;

public class PTSegAttr
{
  private Map<String, Long> detectTimes;
  private Frame maskFrame;
  
  public Frame getMaskFrame()
  {
    return this.maskFrame;
  }
  
  public long getSegDetectTime()
  {
    Map localMap = this.detectTimes;
    if ((localMap != null) && (localMap.get("sdk_background_detect_time") != null)) {
      return ((Long)this.detectTimes.get("sdk_background_detect_time")).longValue();
    }
    return 0L;
  }
  
  public PTSegAttr setDetectTimes(Map paramMap)
  {
    this.detectTimes = paramMap;
    return this;
  }
  
  public void setMaskFrame(Frame paramFrame)
  {
    this.maskFrame = paramFrame;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.PTSegAttr
 * JD-Core Version:    0.7.0.1
 */