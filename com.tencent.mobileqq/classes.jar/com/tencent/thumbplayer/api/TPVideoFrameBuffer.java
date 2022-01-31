package com.tencent.thumbplayer.api;

public class TPVideoFrameBuffer
{
  public static final int TP_PLAYER_AVFRAME_OUTPUT_FORMAT_NONE = -1;
  public static final int TP_PLAYER_AVFRAME_OUTPUT_FORMAT_V_RGB565 = 37;
  public static final int TP_PLAYER_AVFRAME_OUTPUT_FORMAT_V_YUV420P = 0;
  public static final int TP_PLAYER_AVFRAME_OUTPUT_FORMAT_V_YUVJ420P = 12;
  public byte[][] data;
  public int dstHeight;
  public int dstWidth;
  public int flags;
  public int format;
  public int[] lineSize;
  public long ptsMs;
  public int rotation;
  public int srcHeight;
  public int srcWidth;
  public int trackID;
  
  public byte[][] getData()
  {
    return this.data;
  }
  
  public int getDstHeight()
  {
    return this.dstHeight;
  }
  
  public int getDstWidth()
  {
    return this.dstWidth;
  }
  
  public int getFlags()
  {
    return this.flags;
  }
  
  public int getFormat()
  {
    return this.format;
  }
  
  public int[] getLineSize()
  {
    return this.lineSize;
  }
  
  public long getPtsMs()
  {
    return this.ptsMs;
  }
  
  public int getRotation()
  {
    return this.rotation;
  }
  
  public int getSrcHeight()
  {
    return this.srcHeight;
  }
  
  public int getSrcWidth()
  {
    return this.srcWidth;
  }
  
  public int getTrackID()
  {
    return this.trackID;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.thumbplayer.api.TPVideoFrameBuffer
 * JD-Core Version:    0.7.0.1
 */