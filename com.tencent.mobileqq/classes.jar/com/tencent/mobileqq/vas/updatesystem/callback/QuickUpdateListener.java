package com.tencent.mobileqq.vas.updatesystem.callback;

public abstract interface QuickUpdateListener
{
  public abstract void onCompleted(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2);
  
  public abstract void onProgress(long paramLong1, String paramString1, String paramString2, long paramLong2, long paramLong3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.updatesystem.callback.QuickUpdateListener
 * JD-Core Version:    0.7.0.1
 */