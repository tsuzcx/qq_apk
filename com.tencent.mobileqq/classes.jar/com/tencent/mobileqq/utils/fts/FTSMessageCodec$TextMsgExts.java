package com.tencent.mobileqq.utils.fts;

public class FTSMessageCodec$TextMsgExts
  extends FTSMessageCodec.MsgExts
  implements Cloneable
{
  public long shmsgseq;
  public long time;
  
  public FTSMessageCodec$TextMsgExts() {}
  
  public FTSMessageCodec$TextMsgExts(long paramLong1, long paramLong2)
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
    return "TextMsgExts{time=" + this.time + ", shmsgseq=" + this.shmsgseq + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.utils.fts.FTSMessageCodec.TextMsgExts
 * JD-Core Version:    0.7.0.1
 */