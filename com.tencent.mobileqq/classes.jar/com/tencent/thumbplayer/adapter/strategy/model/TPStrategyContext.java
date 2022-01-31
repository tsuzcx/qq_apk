package com.tencent.thumbplayer.adapter.strategy.model;

public class TPStrategyContext
{
  public int errorCode;
  public int errorType;
  int lastPlayerType = 0;
  
  public TPStrategyContext(int paramInt1, int paramInt2, int paramInt3)
  {
    this.errorCode = paramInt3;
    this.errorType = paramInt2;
    this.lastPlayerType = paramInt1;
  }
  
  public int getPlayerType()
  {
    return this.lastPlayerType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.strategy.model.TPStrategyContext
 * JD-Core Version:    0.7.0.1
 */