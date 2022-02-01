package com.tencent.weiyun.uploader;

public abstract interface IReporter
{
  public abstract void handleReport(UploadResponse paramUploadResponse);
  
  public abstract boolean onlyReportLast();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.weiyun.uploader.IReporter
 * JD-Core Version:    0.7.0.1
 */