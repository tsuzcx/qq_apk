package com.tencent.tfd.sdk.wxa;

public abstract interface ITuringDID
{
  public abstract String getAIDTicket();
  
  public abstract int getErrorCode();
  
  public abstract long getExpiredTimestamp();
  
  public abstract String getOpenIdTicket();
  
  public abstract String getTAIDTicket();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tfd.sdk.wxa.ITuringDID
 * JD-Core Version:    0.7.0.1
 */