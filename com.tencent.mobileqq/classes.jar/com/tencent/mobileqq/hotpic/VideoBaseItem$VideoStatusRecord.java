package com.tencent.mobileqq.hotpic;

class VideoBaseItem$VideoStatusRecord
  implements Cloneable
{
  public int a = 0;
  public long b = -1L;
  public String c = "";
  public String d = "";
  
  public VideoBaseItem$VideoStatusRecord(VideoBaseItem paramVideoBaseItem, int paramInt, long paramLong)
  {
    this.a = paramInt;
    this.b = paramLong;
  }
  
  protected VideoStatusRecord a()
  {
    return (VideoStatusRecord)super.clone();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.VideoBaseItem.VideoStatusRecord
 * JD-Core Version:    0.7.0.1
 */