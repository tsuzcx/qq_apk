package com.tencent.plato.mqq.network;

import okhttp3.ResponseBody;
import okio.Buffer;
import okio.ForwardingSource;
import okio.Source;

class ProgressResponseBody$1
  extends ForwardingSource
{
  ProgressResponseBody$1(ProgressResponseBody paramProgressResponseBody, Source paramSource)
  {
    super(paramSource);
  }
  
  public long read(Buffer paramBuffer, long paramLong)
  {
    long l1 = super.read(paramBuffer, paramLong);
    paramBuffer = this.this$0;
    long l2 = ProgressResponseBody.access$000(paramBuffer);
    if (l1 != -1L) {
      paramLong = l1;
    } else {
      paramLong = 0L;
    }
    ProgressResponseBody.access$002(paramBuffer, l2 + paramLong);
    paramBuffer = ProgressResponseBody.access$200(this.this$0);
    paramLong = ProgressResponseBody.access$000(this.this$0);
    l2 = ProgressResponseBody.access$100(this.this$0).contentLength();
    boolean bool;
    if (l1 == -1L) {
      bool = true;
    } else {
      bool = false;
    }
    paramBuffer.onProgress(paramLong, l2, bool);
    return l1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.plato.mqq.network.ProgressResponseBody.1
 * JD-Core Version:    0.7.0.1
 */