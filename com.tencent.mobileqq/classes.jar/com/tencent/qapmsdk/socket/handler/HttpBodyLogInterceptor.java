package com.tencent.qapmsdk.socket.handler;

import com.tencent.qapmsdk.socket.model.SocketInfo;

public class HttpBodyLogInterceptor
{
  private static IHttpBodyLogInterceptor sInterceptor;
  
  public static byte[] intercept(byte[] paramArrayOfByte, SocketInfo paramSocketInfo)
  {
    IHttpBodyLogInterceptor localIHttpBodyLogInterceptor = sInterceptor;
    byte[] arrayOfByte = paramArrayOfByte;
    if (localIHttpBodyLogInterceptor != null) {
      arrayOfByte = localIHttpBodyLogInterceptor.intercept(paramArrayOfByte, paramSocketInfo);
    }
    return arrayOfByte;
  }
  
  public static void setInterceptor(IHttpBodyLogInterceptor paramIHttpBodyLogInterceptor)
  {
    sInterceptor = paramIHttpBodyLogInterceptor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.handler.HttpBodyLogInterceptor
 * JD-Core Version:    0.7.0.1
 */