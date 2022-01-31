package com.tencent.turingfd.sdk.xq;

public abstract interface ITuringDID
{
  public abstract String getAIDTicket();
  
  public abstract int getErrorCode();
  
  public abstract long getExpiredTimestamp();
  
  public abstract String getTAIDTicket();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.ITuringDID
 * JD-Core Version:    0.7.0.1
 */