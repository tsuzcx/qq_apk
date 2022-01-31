package okio;

import java.io.IOException;
import java.io.InputStream;

class Okio$2
  implements Source
{
  Okio$2(Timeout paramTimeout, InputStream paramInputStream) {}
  
  public void close()
  {
    this.val$in.close();
  }
  
  public long read(Buffer paramBuffer, long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("byteCount < 0: " + paramLong);
    }
    if (paramLong == 0L) {
      return 0L;
    }
    try
    {
      this.val$timeout.throwIfReached();
      Segment localSegment = paramBuffer.writableSegment(1);
      int i = (int)Math.min(paramLong, 8192 - localSegment.limit);
      i = this.val$in.read(localSegment.data, localSegment.limit, i);
      if (i == -1) {
        return -1L;
      }
      localSegment.limit += i;
      paramBuffer.size += i;
      return i;
    }
    catch (AssertionError paramBuffer)
    {
      if (Okio.isAndroidGetsocknameError(paramBuffer)) {
        throw new IOException(paramBuffer);
      }
      throw paramBuffer;
    }
  }
  
  public Timeout timeout()
  {
    return this.val$timeout;
  }
  
  public String toString()
  {
    return "source(" + this.val$in + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     okio.Okio.2
 * JD-Core Version:    0.7.0.1
 */