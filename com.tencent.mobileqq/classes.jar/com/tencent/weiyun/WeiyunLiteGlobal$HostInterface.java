package com.tencent.weiyun;

import android.net.NetworkInfo;

public abstract interface WeiyunLiteGlobal$HostInterface
{
  public abstract int getCurrentIsp();
  
  public abstract long getCurrentUin();
  
  public abstract NetworkInfo getRecentNetworkInfo();
  
  public abstract void sendRequest(String paramString, byte[] paramArrayOfByte, WeiyunLiteGlobal.IResponseHandler paramIResponseHandler);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weiyun.WeiyunLiteGlobal.HostInterface
 * JD-Core Version:    0.7.0.1
 */