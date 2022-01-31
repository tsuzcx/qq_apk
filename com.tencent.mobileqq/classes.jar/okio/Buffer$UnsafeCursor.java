package okio;

import java.io.Closeable;

public final class Buffer$UnsafeCursor
  implements Closeable
{
  public Buffer buffer;
  public byte[] data;
  public int end = -1;
  public long offset = -1L;
  public boolean readWrite;
  private Segment segment;
  public int start = -1;
  
  public void close()
  {
    if (this.buffer == null) {
      throw new IllegalStateException("not attached to a buffer");
    }
    this.buffer = null;
    this.segment = null;
    this.offset = -1L;
    this.data = null;
    this.start = -1;
    this.end = -1;
  }
  
  public final long expandBuffer(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("minByteCount <= 0: " + paramInt);
    }
    if (paramInt > 8192) {
      throw new IllegalArgumentException("minByteCount > Segment.SIZE: " + paramInt);
    }
    if (this.buffer == null) {
      throw new IllegalStateException("not attached to a buffer");
    }
    if (!this.readWrite) {
      throw new IllegalStateException("expandBuffer() only permitted for read/write buffers");
    }
    long l = this.buffer.size;
    Segment localSegment = this.buffer.writableSegment(paramInt);
    paramInt = 8192 - localSegment.limit;
    localSegment.limit = 8192;
    this.buffer.size = (paramInt + l);
    this.segment = localSegment;
    this.offset = l;
    this.data = localSegment.data;
    this.start = (8192 - paramInt);
    this.end = 8192;
    return paramInt;
  }
  
  public final int next()
  {
    if (this.offset == this.buffer.size) {
      throw new IllegalStateException();
    }
    if (this.offset == -1L) {
      return seek(0L);
    }
    return seek(this.offset + (this.end - this.start));
  }
  
  public final long resizeBuffer(long paramLong)
  {
    if (this.buffer == null) {
      throw new IllegalStateException("not attached to a buffer");
    }
    if (!this.readWrite) {
      throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers");
    }
    long l3 = this.buffer.size;
    long l1;
    Segment localSegment;
    int i;
    if (paramLong <= l3)
    {
      if (paramLong < 0L) {
        throw new IllegalArgumentException("newSize < 0: " + paramLong);
      }
      l1 = l3 - paramLong;
      while (l1 > 0L)
      {
        localSegment = this.buffer.head.prev;
        i = localSegment.limit - localSegment.pos;
        if (i <= l1)
        {
          this.buffer.head = localSegment.pop();
          SegmentPool.recycle(localSegment);
          l1 -= i;
        }
        else
        {
          localSegment.limit = ((int)(localSegment.limit - l1));
        }
      }
      this.segment = null;
      this.offset = paramLong;
      this.data = null;
      this.start = -1;
      this.end = -1;
    }
    for (;;)
    {
      this.buffer.size = paramLong;
      return l3;
      if (paramLong > l3)
      {
        l1 = paramLong - l3;
        i = 1;
        while (l1 > 0L)
        {
          localSegment = this.buffer.writableSegment(1);
          int j = (int)Math.min(l1, 8192 - localSegment.limit);
          localSegment.limit += j;
          long l2 = l1 - j;
          l1 = l2;
          if (i != 0)
          {
            this.segment = localSegment;
            this.offset = l3;
            this.data = localSegment.data;
            this.start = (localSegment.limit - j);
            this.end = localSegment.limit;
            i = 0;
            l1 = l2;
          }
        }
      }
    }
  }
  
  public final int seek(long paramLong)
  {
    if ((paramLong < -1L) || (paramLong > this.buffer.size)) {
      throw new ArrayIndexOutOfBoundsException(String.format("offset=%s > size=%s", new Object[] { Long.valueOf(paramLong), Long.valueOf(this.buffer.size) }));
    }
    if ((paramLong == -1L) || (paramLong == this.buffer.size))
    {
      this.segment = null;
      this.offset = paramLong;
      this.data = null;
      this.start = -1;
      this.end = -1;
      return -1;
    }
    long l1 = this.buffer.size;
    Object localObject1 = this.buffer.head;
    Object localObject2 = this.buffer.head;
    long l2;
    if (this.segment != null)
    {
      l2 = this.offset - (this.start - this.segment.pos);
      if (l2 > paramLong)
      {
        localObject2 = this.segment;
        l1 = 0L;
      }
    }
    for (;;)
    {
      if (l2 - paramLong > paramLong - l1)
      {
        for (localObject2 = localObject1;; localObject2 = ((Segment)localObject2).next)
        {
          l2 = l1;
          localObject1 = localObject2;
          if (paramLong < ((Segment)localObject2).limit - ((Segment)localObject2).pos + l1) {
            break;
          }
          l1 += ((Segment)localObject2).limit - ((Segment)localObject2).pos;
        }
        localObject1 = this.segment;
        long l3 = l1;
        l1 = l2;
        l2 = l3;
      }
      else
      {
        for (l1 = l2;; l1 -= ((Segment)localObject2).limit - ((Segment)localObject2).pos)
        {
          l2 = l1;
          localObject1 = localObject2;
          if (l1 <= paramLong) {
            break;
          }
          localObject2 = ((Segment)localObject2).prev;
        }
        localObject2 = localObject1;
        if (this.readWrite)
        {
          localObject2 = localObject1;
          if (((Segment)localObject1).shared)
          {
            localObject2 = ((Segment)localObject1).unsharedCopy();
            if (this.buffer.head == localObject1) {
              this.buffer.head = ((Segment)localObject2);
            }
            localObject2 = ((Segment)localObject1).push((Segment)localObject2);
            ((Segment)localObject2).prev.pop();
          }
        }
        this.segment = ((Segment)localObject2);
        this.offset = paramLong;
        this.data = ((Segment)localObject2).data;
        int i = ((Segment)localObject2).pos;
        this.start = ((int)(paramLong - l2) + i);
        this.end = ((Segment)localObject2).limit;
        return this.end - this.start;
        l2 = l1;
        l1 = 0L;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     okio.Buffer.UnsafeCursor
 * JD-Core Version:    0.7.0.1
 */