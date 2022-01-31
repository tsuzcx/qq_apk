package com.tencent.tissue.v8rt.engine;

public abstract interface IServiceEventHandler
{
  public abstract void onServiceEvent(String paramString1, String paramString2, int[] paramArrayOfInt);
  
  public abstract String onServiceNativeRequest(String paramString1, String paramString2, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tissue.v8rt.engine.IServiceEventHandler
 * JD-Core Version:    0.7.0.1
 */