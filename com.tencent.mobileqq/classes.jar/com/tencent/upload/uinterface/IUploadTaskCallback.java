package com.tencent.upload.uinterface;

public abstract interface IUploadTaskCallback
{
  public static final int STATE_CANCEL = 5;
  public static final int STATE_CONNECTING = 4;
  public static final int STATE_FINISH = 3;
  public static final int STATE_PAUSE = 2;
  public static final int STATE_RUNNING = 1;
  public static final int STATE_UNKNOWN = -1000;
  public static final int STATE_WAITTING = 0;
  
  public abstract void onUploadError(AbstractUploadTask paramAbstractUploadTask, int paramInt, String paramString);
  
  public abstract void onUploadProgress(AbstractUploadTask paramAbstractUploadTask, long paramLong1, long paramLong2);
  
  public abstract void onUploadStateChange(AbstractUploadTask paramAbstractUploadTask, int paramInt);
  
  public abstract void onUploadSucceed(AbstractUploadTask paramAbstractUploadTask, Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.upload.uinterface.IUploadTaskCallback
 * JD-Core Version:    0.7.0.1
 */