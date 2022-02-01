package com.tencent.turingfd.sdk.ams.ga;

public abstract interface ITuringDID
{
  public abstract String getAIDTicket();
  
  public abstract int getErrorCode();
  
  public abstract long getExpiredTimestamp();
  
  public abstract String getTAIDTicket();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.ams.ga.ITuringDID
 * JD-Core Version:    0.7.0.1
 */