package com.tencent.oskplayer.proxy;

import java.io.IOException;

public class ProxyException
  extends IOException
{
  public final int errCode;
  
  public ProxyException(String paramString)
  {
    super(paramString);
    this.errCode = 0;
  }
  
  public ProxyException(String paramString, int paramInt)
  {
    super(paramString);
    this.errCode = paramInt;
  }
  
  public int getErrCode()
  {
    return this.errCode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.oskplayer.proxy.ProxyException
 * JD-Core Version:    0.7.0.1
 */