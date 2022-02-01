package com.tencent.mobileqq.winkpublish.request;

import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.winkpublish.task.report.TaskReportInfo.MediaReportInfo;
import com.tencent.upload.uinterface.AbstractUploadTask;

public abstract interface AUploadMediaUploadRequest$IMediaUploadListener
{
  public abstract void a(int paramInt1, int paramInt2, String paramString, boolean paramBoolean);
  
  public abstract void a(int paramInt, String paramString1, String paramString2);
  
  public abstract void a(JceStruct paramJceStruct, AbstractUploadTask paramAbstractUploadTask, int paramInt, String paramString1, String paramString2, String paramString3);
  
  public abstract void a(TaskReportInfo.MediaReportInfo paramMediaReportInfo);
  
  public abstract void a(String paramString, int paramInt, double paramDouble);
  
  public abstract void a(String paramString1, int paramInt1, int paramInt2, String paramString2);
  
  public abstract void a(String paramString1, String paramString2, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.request.AUploadMediaUploadRequest.IMediaUploadListener
 * JD-Core Version:    0.7.0.1
 */