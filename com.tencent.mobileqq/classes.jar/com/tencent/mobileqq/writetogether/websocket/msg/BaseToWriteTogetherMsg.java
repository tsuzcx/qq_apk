package com.tencent.mobileqq.writetogether.websocket.msg;

public abstract class BaseToWriteTogetherMsg<H extends BaseHeader, B>
  extends BaseWriteTogetherMsg<H, B>
{
  private int seq;
  private long timeout;
  
  public int getSeq()
  {
    return this.seq;
  }
  
  public long getTimeout()
  {
    return this.timeout;
  }
  
  public void setSeq(int paramInt)
  {
    this.seq = paramInt;
  }
  
  public void setTimeout(long paramLong)
  {
    this.timeout = paramLong;
  }
  
  public String toShortStr()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BaseToWriteTogetherMsg: {seq: ");
    localStringBuilder.append(this.seq);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.websocket.msg.BaseToWriteTogetherMsg
 * JD-Core Version:    0.7.0.1
 */