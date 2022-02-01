package com.tencent.thumbplayer.adapter.strategy.model;

public class TPStrategyContext
{
  private String definition;
  private int errorCode;
  private int errorType;
  int lastPlayerType = 0;
  
  public TPStrategyContext(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    this.errorCode = paramInt3;
    this.errorType = paramInt2;
    this.lastPlayerType = paramInt1;
    this.definition = paramString;
  }
  
  public String getDefinition()
  {
    return this.definition;
  }
  
  public int getErrorCode()
  {
    return this.errorCode;
  }
  
  public int getErrorType()
  {
    return this.errorType;
  }
  
  public int getPlayerType()
  {
    return this.lastPlayerType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.strategy.model.TPStrategyContext
 * JD-Core Version:    0.7.0.1
 */