package com.tencent.mobileqq.videocodec.ffmpeg;

class Clip
  implements Cloneable
{
  public String aspect;
  public int audioBitrate = -1;
  public String audioCodec;
  public double duration = -1.0D;
  public String format;
  public int height = -1;
  public String mimeType;
  public String path;
  public String rotate = "0";
  public String startTime;
  public int videoBitrate = -1;
  public String videoCodec;
  public String videoFps;
  public int width = -1;
  
  public Clip(String paramString)
  {
    this.path = paramString;
  }
  
  public Clip clone()
  {
    return (Clip)super.clone();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.videocodec.ffmpeg.Clip
 * JD-Core Version:    0.7.0.1
 */