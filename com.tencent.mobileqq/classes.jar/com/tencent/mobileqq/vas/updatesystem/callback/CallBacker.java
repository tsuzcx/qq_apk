package com.tencent.mobileqq.vas.updatesystem.callback;

public abstract class CallBacker
{
  public int key;
  
  public abstract void callback(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2);
  
  public void onProgress(long paramLong1, String paramString1, String paramString2, long paramLong2, long paramLong3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.updatesystem.callback.CallBacker
 * JD-Core Version:    0.7.0.1
 */