package com.tencent.mobileqq.weiyun.api.download;

import com.tencent.mobileqq.weiyun.model.WeiyunDownloadStatusInfo;

public abstract interface IDownloadStatusListener
{
  public abstract void a(String paramString);
  
  public abstract void a(String paramString, long paramLong, WeiyunDownloadStatusInfo paramWeiyunDownloadStatusInfo, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.api.download.IDownloadStatusListener
 * JD-Core Version:    0.7.0.1
 */