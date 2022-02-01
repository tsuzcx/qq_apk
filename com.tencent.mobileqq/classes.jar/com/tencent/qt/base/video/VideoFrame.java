package com.tencent.qt.base.video;

public class VideoFrame
{
  public byte[] content;
  public int contentLength = 0;
  public int height;
  public int seq;
  public boolean shouldDiscard = false;
  public long timestamp;
  public int type;
  public int width;
  
  public VideoFrame() {}
  
  public VideoFrame(int paramInt)
  {
    this.type = 0;
    this.timestamp = 0L;
    this.seq = 0;
    this.contentLength = 0;
    if (paramInt > 0) {}
    try
    {
      this.content = new byte[paramInt];
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      System.gc();
    }
  }
  
  public VideoFrame(VideoFrame paramVideoFrame)
  {
    this.type = paramVideoFrame.type;
    this.timestamp = paramVideoFrame.timestamp;
    this.content = paramVideoFrame.content;
    this.contentLength = paramVideoFrame.contentLength;
  }
  
  public void clear()
  {
    this.type = 0;
    this.content = null;
    this.timestamp = 0L;
    this.contentLength = 0;
  }
  
  public Object clone()
  {
    return new VideoFrame(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qt.base.video.VideoFrame
 * JD-Core Version:    0.7.0.1
 */