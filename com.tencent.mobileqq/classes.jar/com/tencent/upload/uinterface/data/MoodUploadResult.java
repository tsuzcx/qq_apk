package com.tencent.upload.uinterface.data;

import com.tencent.upload.uinterface.AbstractUploadResult;

public class MoodUploadResult
  extends AbstractUploadResult
{
  public final byte[] vBusiNessDataRsp;
  
  public MoodUploadResult(byte[] paramArrayOfByte)
  {
    this.vBusiNessDataRsp = paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.upload.uinterface.data.MoodUploadResult
 * JD-Core Version:    0.7.0.1
 */