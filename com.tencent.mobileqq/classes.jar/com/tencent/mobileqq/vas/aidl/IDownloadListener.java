package com.tencent.mobileqq.vas.aidl;

import android.os.IInterface;

public abstract interface IDownloadListener
  extends IInterface
{
  public abstract void onComplete(String paramString, int paramInt);
  
  public abstract void onProgress(String paramString, long paramLong1, long paramLong2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.aidl.IDownloadListener
 * JD-Core Version:    0.7.0.1
 */