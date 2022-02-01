package com.tencent.upload.uinterface.data;

import com.tencent.upload.network.session.SessionPool;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.TaskTypeConfig;
import com.tencent.upload.utils.Const.FileType;
import com.tencent.upload.utils.UploadLog;

public class UnifiedUploadTask
  extends AbstractUploadTask
{
  UnifiedUploadTask.MediaType mediaType = UnifiedUploadTask.MediaType.Photo;
  
  public UnifiedUploadTask(String paramString)
  {
    super(paramString);
  }
  
  public byte[] buildExtra()
  {
    return null;
  }
  
  public Const.FileType getFileType()
  {
    if (this.mediaType == UnifiedUploadTask.MediaType.Photo) {
      return Const.FileType.Photo;
    }
    return Const.FileType.Video;
  }
  
  public TaskTypeConfig getUploadTaskType()
  {
    return null;
  }
  
  protected void processFileUploadFinishRsp(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("ImageUploadTask put <");
    paramArrayOfByte.append(this.mOriginFilePath);
    paramArrayOfByte.append(",");
    paramArrayOfByte.append(this.mSessionId);
    paramArrayOfByte.append(">");
    UploadLog.d("AbstractUploadTask", paramArrayOfByte.toString());
    SessionPool.recordSessionId(this.mOriginFilePath, this.mSessionId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.upload.uinterface.data.UnifiedUploadTask
 * JD-Core Version:    0.7.0.1
 */