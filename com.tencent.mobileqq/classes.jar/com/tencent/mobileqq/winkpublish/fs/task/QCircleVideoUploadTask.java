package com.tencent.mobileqq.winkpublish.fs.task;

import com.tencent.upload.uinterface.data.VideoUploadTask;

public class QCircleVideoUploadTask
  extends VideoUploadTask
{
  public QCircleVideoUploadTask(String paramString)
  {
    super(paramString);
    this.mAppid = "circle_video";
    setIsNew(113);
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("QCircleVideoUploadTask{");
    localStringBuffer.append("sTitle='");
    localStringBuffer.append(this.sTitle);
    localStringBuffer.append('\'');
    localStringBuffer.append(", sDesc='");
    localStringBuffer.append(this.sDesc);
    localStringBuffer.append('\'');
    localStringBuffer.append(", sCoverUrl='");
    localStringBuffer.append(this.sCoverUrl);
    localStringBuffer.append('\'');
    localStringBuffer.append(", iIsNew=");
    localStringBuffer.append(this.iIsNew);
    localStringBuffer.append(", iBusiNessType=");
    localStringBuffer.append(this.iBusiNessType);
    localStringBuffer.append(", iIsOriginalVideo=");
    localStringBuffer.append(this.iIsOriginalVideo);
    localStringBuffer.append(", iIsFormatF20=");
    localStringBuffer.append(this.iIsFormatF20);
    localStringBuffer.append(", isSyncWeishi=");
    localStringBuffer.append(this.isSyncWeishi);
    localStringBuffer.append(", uploadFilePath='");
    localStringBuffer.append(this.uploadFilePath);
    localStringBuffer.append('\'');
    localStringBuffer.append(", iUploadTime=");
    localStringBuffer.append(this.iUploadTime);
    localStringBuffer.append(", flowId=");
    localStringBuffer.append(this.flowId);
    localStringBuffer.append(", sRefer=");
    localStringBuffer.append(this.sRefer);
    localStringBuffer.append(", uploadEntrance=");
    localStringBuffer.append(this.uploadEntrance);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.fs.task.QCircleVideoUploadTask
 * JD-Core Version:    0.7.0.1
 */