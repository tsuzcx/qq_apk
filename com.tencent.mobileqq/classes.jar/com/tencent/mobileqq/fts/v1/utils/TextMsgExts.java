package com.tencent.mobileqq.fts.v1.utils;

public class TextMsgExts
  extends MsgExts
  implements Cloneable
{
  public long shmsgseq;
  public long time;
  
  public TextMsgExts() {}
  
  public TextMsgExts(long paramLong1, long paramLong2)
  {
    this.time = paramLong1;
    this.shmsgseq = paramLong2;
  }
  
  protected Object clone()
  {
    return super.clone();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TextMsgExts{time=");
    localStringBuilder.append(this.time);
    localStringBuilder.append(", shmsgseq=");
    localStringBuilder.append(this.shmsgseq);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.fts.v1.utils.TextMsgExts
 * JD-Core Version:    0.7.0.1
 */