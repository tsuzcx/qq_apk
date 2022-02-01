package com.tencent.upload.uinterface.data;

import com.tencent.upload.uinterface.AbstractUploadResult;

public class MobileLogUploadResult
  extends AbstractUploadResult
{
  public long iUin = 0L;
  
  public MobileLogUploadResult(long paramLong, int paramInt)
  {
    this.iUin = paramLong;
    this.flowId = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.upload.uinterface.data.MobileLogUploadResult
 * JD-Core Version:    0.7.0.1
 */