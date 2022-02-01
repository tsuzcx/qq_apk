package okio;

import java.io.OutputStream;

final class Okio$1
  implements Sink
{
  Okio$1(Timeout paramTimeout, OutputStream paramOutputStream) {}
  
  public void close()
  {
    this.val$out.close();
  }
  
  public void flush()
  {
    this.val$out.flush();
  }
  
  public Timeout timeout()
  {
    return this.val$timeout;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sink(");
    localStringBuilder.append(this.val$out);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public void write(Buffer paramBuffer, long paramLong)
  {
    Util.checkOffsetAndCount(paramBuffer.size, 0L, paramLong);
    while (paramLong > 0L)
    {
      this.val$timeout.throwIfReached();
      Segment localSegment = paramBuffer.head;
      int i = (int)Math.min(paramLong, localSegment.limit - localSegment.pos);
      this.val$out.write(localSegment.data, localSegment.pos, i);
      localSegment.pos += i;
      long l2 = i;
      long l1 = paramLong - l2;
      paramBuffer.size -= l2;
      paramLong = l1;
      if (localSegment.pos == localSegment.limit)
      {
        paramBuffer.head = localSegment.pop();
        SegmentPool.recycle(localSegment);
        paramLong = l1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     okio.Okio.1
 * JD-Core Version:    0.7.0.1
 */