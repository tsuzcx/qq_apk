package com.tencent.upload.image;

import com.tencent.upload.uinterface.IUploadConfig.UploadImageSize;

public class ImageCompressRecord
{
  final boolean autoRotate;
  final boolean compressToWebp;
  final int flowId;
  final IUploadConfig.UploadImageSize mSize;
  final String md5;
  final String path;
  
  public ImageCompressRecord(int paramInt, String paramString1, String paramString2, IUploadConfig.UploadImageSize paramUploadImageSize, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.flowId = paramInt;
    this.path = paramString1;
    this.md5 = paramString2;
    this.mSize = paramUploadImageSize;
    this.autoRotate = paramBoolean1;
    this.compressToWebp = paramBoolean2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.upload.image.ImageCompressRecord
 * JD-Core Version:    0.7.0.1
 */