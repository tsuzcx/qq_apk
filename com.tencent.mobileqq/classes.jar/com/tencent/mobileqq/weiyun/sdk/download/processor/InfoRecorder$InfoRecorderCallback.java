package com.tencent.mobileqq.weiyun.sdk.download.processor;

import com.tencent.mobileqq.weiyun.model.DownloadJobContext;
import com.tencent.mobileqq.weiyun.model.WeiyunDownloadStatusInfo;
import java.util.List;

public abstract interface InfoRecorder$InfoRecorderCallback
{
  public abstract void a(int paramInt, DownloadJobContext paramDownloadJobContext, String paramString);
  
  public abstract void a(long paramLong, boolean paramBoolean, DownloadJobContext paramDownloadJobContext);
  
  public abstract void a(long paramLong, boolean paramBoolean1, WeiyunDownloadStatusInfo paramWeiyunDownloadStatusInfo, boolean paramBoolean2);
  
  public abstract void a(String paramString, List<DownloadJobContext> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.sdk.download.processor.InfoRecorder.InfoRecorderCallback
 * JD-Core Version:    0.7.0.1
 */