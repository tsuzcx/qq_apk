package okhttp3.internal.http1;

import okio.Buffer;

class Http1Codec$UnknownLengthSource
  extends Http1Codec.AbstractSource
{
  private boolean inputExhausted;
  
  Http1Codec$UnknownLengthSource(Http1Codec paramHttp1Codec)
  {
    super(paramHttp1Codec, null);
  }
  
  public void close()
  {
    if (this.closed) {
      return;
    }
    if (!this.inputExhausted) {
      endOfInput(false, null);
    }
    this.closed = true;
  }
  
  public long read(Buffer paramBuffer, long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("byteCount < 0: " + paramLong);
    }
    if (this.closed) {
      throw new IllegalStateException("closed");
    }
    if (this.inputExhausted) {
      return -1L;
    }
    paramLong = super.read(paramBuffer, paramLong);
    if (paramLong == -1L)
    {
      this.inputExhausted = true;
      endOfInput(true, null);
      return -1L;
    }
    return paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     okhttp3.internal.http1.Http1Codec.UnknownLengthSource
 * JD-Core Version:    0.7.0.1
 */