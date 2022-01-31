package com.tencent.plato.mqq.network;

import android.util.Log;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;
import okio.Okio;
import okio.Sink;

public class ProgressRequestBody
  extends RequestBody
{
  private BufferedSink mBufferedSink;
  private final ProgressListener mProgressListener;
  private final RequestBody mRequestBody;
  
  public ProgressRequestBody(RequestBody paramRequestBody, ProgressListener paramProgressListener)
  {
    this.mRequestBody = paramRequestBody;
    this.mProgressListener = paramProgressListener;
  }
  
  private Sink sink(Sink paramSink)
  {
    return new ProgressRequestBody.1(this, paramSink);
  }
  
  public long contentLength()
  {
    return this.mRequestBody.contentLength();
  }
  
  public MediaType contentType()
  {
    return this.mRequestBody.contentType();
  }
  
  public void writeTo(BufferedSink paramBufferedSink)
  {
    try
    {
      if (this.mBufferedSink == null) {
        this.mBufferedSink = Okio.buffer(sink(paramBufferedSink));
      }
      this.mRequestBody.writeTo(this.mBufferedSink);
      this.mBufferedSink.flush();
      return;
    }
    catch (IllegalStateException paramBufferedSink)
    {
      Log.e("ProgressRequestBody", "ProgressRequestBody exp:" + paramBufferedSink.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.plato.mqq.network.ProgressRequestBody
 * JD-Core Version:    0.7.0.1
 */