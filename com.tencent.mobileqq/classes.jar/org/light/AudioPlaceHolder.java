package org.light;

public class AudioPlaceHolder
{
  public long duration;
  public long fadeInDuration;
  public long fadeOutDuration;
  public String key;
  public int loopCount = 1;
  public String musicID;
  public String path;
  public long startOffset;
  public float volume;
  
  public AudioPlaceHolder(String paramString1, String paramString2, long paramLong1, long paramLong2, float paramFloat, String paramString3, long paramLong3, long paramLong4, int paramInt)
  {
    this.key = paramString1;
    this.musicID = paramString2;
    this.fadeInDuration = paramLong1;
    this.fadeOutDuration = paramLong2;
    this.volume = paramFloat;
    this.path = paramString3;
    this.startOffset = paramLong3;
    this.duration = paramLong4;
    this.loopCount = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.light.AudioPlaceHolder
 * JD-Core Version:    0.7.0.1
 */