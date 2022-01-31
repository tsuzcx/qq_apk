package com.tencent.plato.mqq.network;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.internal.Util;
import java.io.IOException;
import java.io.InputStream;
import okio.BufferedSink;
import okio.Okio;
import okio.Source;

class RequestBodyUtil$InputStreamRequestBody
  extends RequestBody
{
  private final InputStream mInputStream;
  private final MediaType mMediaType;
  
  RequestBodyUtil$InputStreamRequestBody(MediaType paramMediaType, InputStream paramInputStream)
  {
    this.mMediaType = paramMediaType;
    this.mInputStream = paramInputStream;
  }
  
  public long contentLength()
  {
    try
    {
      int i = this.mInputStream.available();
      return i;
    }
    catch (IOException localIOException) {}
    return 0L;
  }
  
  public MediaType contentType()
  {
    return this.mMediaType;
  }
  
  public void writeTo(BufferedSink paramBufferedSink)
  {
    Object localObject = null;
    try
    {
      Source localSource = Okio.source(this.mInputStream);
      localObject = localSource;
      paramBufferedSink.writeAll(localSource);
      return;
    }
    finally
    {
      Util.closeQuietly(localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.plato.mqq.network.RequestBodyUtil.InputStreamRequestBody
 * JD-Core Version:    0.7.0.1
 */