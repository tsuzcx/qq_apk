package com.tencent.weiyun.uploader.xplatform;

public final class UploadNative$CanceledFlag
{
  private volatile boolean isCanceled;
  
  private UploadNative$CanceledFlag() {}
  
  public UploadNative$CanceledFlag(boolean paramBoolean)
  {
    this.isCanceled = paramBoolean;
  }
  
  public boolean isCanceled()
  {
    return this.isCanceled;
  }
  
  public void setCanceled(boolean paramBoolean)
  {
    this.isCanceled = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.weiyun.uploader.xplatform.UploadNative.CanceledFlag
 * JD-Core Version:    0.7.0.1
 */