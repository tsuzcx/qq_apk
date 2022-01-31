package com.tencent.qapmsdk.impl.instrumentation.okhttp2;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;

public class QAPMPrebufferedResponseBody
  extends ResponseBody
{
  private ResponseBody impl;
  private BufferedSource source;
  
  public QAPMPrebufferedResponseBody(ResponseBody paramResponseBody, BufferedSource paramBufferedSource)
  {
    this.impl = paramResponseBody;
    this.source = paramBufferedSource;
  }
  
  public void close()
  {
    this.impl.close();
  }
  
  public long contentLength()
  {
    return this.source.buffer().size();
  }
  
  public MediaType contentType()
  {
    return this.impl.contentType();
  }
  
  public BufferedSource source()
  {
    return this.source;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.okhttp2.QAPMPrebufferedResponseBody
 * JD-Core Version:    0.7.0.1
 */