package com.tencent.mobileqq.data;

public abstract interface HasSourceMessage
{
  public abstract boolean getHasPulledSourceMsg();
  
  public abstract MessageForReplyText.SourceMsgInfo getSourceMsgInfo();
  
  public abstract void setPulledSourceMsg();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.HasSourceMessage
 * JD-Core Version:    0.7.0.1
 */