package com.tencent.plato.mqq.network;

import okio.Buffer;
import okio.ForwardingSink;
import okio.Sink;

class ProgressRequestBody$1
  extends ForwardingSink
{
  long bytesWritten = 0L;
  long contentLength = 0L;
  
  ProgressRequestBody$1(ProgressRequestBody paramProgressRequestBody, Sink paramSink)
  {
    super(paramSink);
  }
  
  public void write(Buffer paramBuffer, long paramLong)
  {
    super.write(paramBuffer, paramLong);
    if (this.contentLength == 0L) {
      this.contentLength = this.this$0.contentLength();
    }
    this.bytesWritten += paramLong;
    paramBuffer = ProgressRequestBody.access$000(this.this$0);
    paramLong = this.bytesWritten;
    long l = this.contentLength;
    if (this.bytesWritten == this.contentLength) {}
    for (boolean bool = true;; bool = false)
    {
      paramBuffer.onProgress(paramLong, l, bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.plato.mqq.network.ProgressRequestBody.1
 * JD-Core Version:    0.7.0.1
 */