package com.tencent.mobileqq.uftransfer.common.transfer.download;

import android.os.Bundle;

public abstract interface IUFTFtnDownloaderCallback
{
  public abstract void a(int paramInt, String paramString1, String paramString2, Bundle paramBundle);
  
  public abstract void a(byte[] paramArrayOfByte, long paramLong, String paramString);
  
  public abstract void f_(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.common.transfer.download.IUFTFtnDownloaderCallback
 * JD-Core Version:    0.7.0.1
 */