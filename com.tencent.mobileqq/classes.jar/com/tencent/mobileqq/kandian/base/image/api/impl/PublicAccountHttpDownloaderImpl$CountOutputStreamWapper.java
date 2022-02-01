package com.tencent.mobileqq.kandian.base.image.api.impl;

import java.io.FilterOutputStream;
import java.io.OutputStream;

class PublicAccountHttpDownloaderImpl$CountOutputStreamWapper
  extends FilterOutputStream
{
  int a = 0;
  
  public PublicAccountHttpDownloaderImpl$CountOutputStreamWapper(PublicAccountHttpDownloaderImpl paramPublicAccountHttpDownloaderImpl, OutputStream paramOutputStream)
  {
    super(paramOutputStream);
  }
  
  public void write(int paramInt)
  {
    this.a += 1;
    this.out.write(paramInt);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.a += paramInt2;
    this.out.write(paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.image.api.impl.PublicAccountHttpDownloaderImpl.CountOutputStreamWapper
 * JD-Core Version:    0.7.0.1
 */