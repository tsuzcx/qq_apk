package com.tencent.txproxy;

public abstract interface HostEventListener
{
  public abstract void onDownloadCancel();
  
  public abstract void onDownloadProgress(long paramLong1, long paramLong2);
  
  public abstract void onDownloadResult(int paramInt1, int paramInt2, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.txproxy.HostEventListener
 * JD-Core Version:    0.7.0.1
 */