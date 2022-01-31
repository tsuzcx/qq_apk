package com.tencent.upload.uinterface;

public class IUploadConfig$UploadImageSize
{
  public int height;
  public int quality;
  public int width;
  
  public IUploadConfig$UploadImageSize(int paramInt1, int paramInt2, int paramInt3)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    this.quality = paramInt3;
  }
  
  public String toString()
  {
    return "[width=" + this.width + ", height=" + this.height + ", quality=" + this.quality + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.upload.uinterface.IUploadConfig.UploadImageSize
 * JD-Core Version:    0.7.0.1
 */