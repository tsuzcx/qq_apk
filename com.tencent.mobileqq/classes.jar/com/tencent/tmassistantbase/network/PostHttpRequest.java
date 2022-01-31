package com.tencent.tmassistantbase.network;

import com.tencent.tmassistantbase.util.ac;
import com.tencent.tmassistantbase.util.m;

public abstract class PostHttpRequest
{
  public static String REQUEST_SERVER_URL = "https://masdkv6.3g.qq.com";
  private static final String TAG = "PostHttpRequest";
  
  protected abstract void onFinished(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt);
  
  public boolean sendRequest(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return false;
    }
    paramArrayOfByte = new Thread(new f(this, paramArrayOfByte), m.c.name());
    try
    {
      paramArrayOfByte.start();
      return true;
    }
    catch (OutOfMemoryError paramArrayOfByte)
    {
      ac.e("PostHttpRequest", "<sendRequest>low memory!");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.tmassistantbase.network.PostHttpRequest
 * JD-Core Version:    0.7.0.1
 */