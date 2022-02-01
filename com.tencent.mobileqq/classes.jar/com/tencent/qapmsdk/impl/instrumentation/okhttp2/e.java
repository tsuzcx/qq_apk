package com.tencent.qapmsdk.impl.instrumentation.okhttp2;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;

public class e
  extends ResponseBody
{
  private ResponseBody a;
  private BufferedSource b;
  
  public e(ResponseBody paramResponseBody, BufferedSource paramBufferedSource)
  {
    this.a = paramResponseBody;
    this.b = paramBufferedSource;
  }
  
  public void close()
  {
    this.a.close();
  }
  
  public long contentLength()
  {
    return this.b.buffer().size();
  }
  
  public MediaType contentType()
  {
    return this.a.contentType();
  }
  
  public BufferedSource source()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.okhttp2.e
 * JD-Core Version:    0.7.0.1
 */