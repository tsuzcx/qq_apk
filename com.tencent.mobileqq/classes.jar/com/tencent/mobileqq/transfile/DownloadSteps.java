package com.tencent.mobileqq.transfile;

public abstract interface DownloadSteps
{
  public abstract ChatImageDownloader.DownloadData getDownloadParams();
  
  public abstract boolean stepCheckParams();
  
  public abstract boolean stepDiretDownload();
  
  public abstract boolean stepOldDataCompact();
  
  public abstract boolean stepRequestAndDownload();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.DownloadSteps
 * JD-Core Version:    0.7.0.1
 */