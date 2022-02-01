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
    long l2 = ProgressResponseBody.access$000(this.this$0);
    if (l1 != -1L)
    {
      paramLong = l1;
      ProgressResponseBody.access$002(paramBuffer, paramLong + l2);
      paramBuffer = ProgressResponseBody.access$200(this.this$0);
      paramLong = ProgressResponseBody.access$000(this.this$0);
      l2 = ProgressResponseBody.access$100(this.this$0).contentLength();
      if (l1 != -1L) {
        break label102;
      }
    }
    label102:
    for (boolean bool = true;; bool = false)
    {
      paramBuffer.onProgress(paramLong, l2, bool);
      return l1;
      paramLong = 0L;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.plato.mqq.network.ProgressResponseBody.1
 * JD-Core Version:    0.7.0.1
 */