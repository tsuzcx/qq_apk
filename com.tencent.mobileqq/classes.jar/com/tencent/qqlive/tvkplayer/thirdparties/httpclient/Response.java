package com.tencent.qqlive.tvkplayer.thirdparties.httpclient;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Response
{
  public final IOException e;
  public final Map<String, List<String>> responseHeaders;
  public final byte[] result;
  
  private Response(IOException paramIOException)
  {
    this.result = null;
    this.responseHeaders = null;
    this.e = paramIOException;
  }
  
  private Response(byte[] paramArrayOfByte, Map<String, List<String>> paramMap)
  {
    this.result = paramArrayOfByte;
    this.responseHeaders = paramMap;
    this.e = null;
  }
  
  public static Response error(IOException paramIOException)
  {
    return new Response(paramIOException);
  }
  
  public static Response success(byte[] paramArrayOfByte, Map<String, List<String>> paramMap)
  {
    return new Response(paramArrayOfByte, paramMap);
  }
  
  public boolean isSuccess()
  {
    return this.e == null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.thirdparties.httpclient.Response
 * JD-Core Version:    0.7.0.1
 */