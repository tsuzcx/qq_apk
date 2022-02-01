package com.tencent.mobileqq.transfile.quic.report;

public abstract interface DownloadListener
{
  public abstract boolean isCanceled();
  
  public abstract void onDownloadFailed(String paramString, QuicNetReport paramQuicNetReport);
  
  public abstract void onDownloadProgress(String paramString, long paramLong1, long paramLong2);
  
  public abstract void onDownloadSucceed(String paramString, QuicNetReport paramQuicNetReport);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.quic.report.DownloadListener
 * JD-Core Version:    0.7.0.1
 */