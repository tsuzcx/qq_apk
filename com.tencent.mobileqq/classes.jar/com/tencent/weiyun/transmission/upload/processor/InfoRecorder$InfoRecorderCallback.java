package com.tencent.weiyun.transmission.upload.processor;

import com.tencent.weiyun.transmission.upload.UploadJobContext;
import com.tencent.weiyun.transmission.upload.UploadJobContext.StatusInfo;
import java.util.List;

public abstract interface InfoRecorder$InfoRecorderCallback
{
  public abstract void onInfoAdded(int paramInt, UploadJobContext paramUploadJobContext);
  
  public abstract void onInfoRemoved(long paramLong, boolean paramBoolean, UploadJobContext paramUploadJobContext);
  
  public abstract void onInfoRestored(String paramString, List<UploadJobContext> paramList);
  
  public abstract void onInfoUpdated(long paramLong, boolean paramBoolean1, UploadJobContext.StatusInfo paramStatusInfo, boolean paramBoolean2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.weiyun.transmission.upload.processor.InfoRecorder.InfoRecorderCallback
 * JD-Core Version:    0.7.0.1
 */