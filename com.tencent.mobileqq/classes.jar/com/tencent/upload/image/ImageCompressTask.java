package com.tencent.upload.image;

import com.tencent.upload.uinterface.IUploadConfig.UploadImageSize;

public class ImageCompressTask
{
  final IUploadConfig.UploadImageSize a;
  final boolean b;
  final boolean c;
  final int d;
  final String e;
  final String f;
  
  public ImageCompressTask(int paramInt, String paramString1, String paramString2, IUploadConfig.UploadImageSize paramUploadImageSize, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.d = paramInt;
    this.e = paramString1;
    this.f = paramString2;
    this.a = paramUploadImageSize;
    this.b = paramBoolean1;
    this.c = paramBoolean2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.upload.image.ImageCompressTask
 * JD-Core Version:    0.7.0.1
 */