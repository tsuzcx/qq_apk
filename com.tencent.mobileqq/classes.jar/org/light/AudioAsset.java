package org.light;

import java.util.HashMap;

public class AudioAsset
{
  public long duration;
  HashMap<String, long[]> events = new HashMap();
  public long fadeInDuration;
  public long fadeOutDuration;
  public int loopCount = 1;
  public String musicID;
  public String path;
  public long startOffset;
  public float volume;
  
  public AudioAsset(String paramString1, long paramLong1, long paramLong2, float paramFloat, String paramString2, long paramLong3, long paramLong4, HashMap<String, long[]> paramHashMap, int paramInt)
  {
    this.musicID = paramString1;
    this.fadeInDuration = paramLong1;
    this.fadeOutDuration = paramLong2;
    this.volume = paramFloat;
    this.path = paramString2;
    this.startOffset = paramLong3;
    this.duration = paramLong4;
    if (paramHashMap != null) {
      this.events.putAll(paramHashMap);
    }
    this.loopCount = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.light.AudioAsset
 * JD-Core Version:    0.7.0.1
 */