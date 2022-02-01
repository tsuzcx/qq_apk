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
    if (this.buffer != null)
    {
      this.buffer = null;
      this.segment = null;
      this.offset = -1L;
      this.data = null;
      this.start = -1;
      this.end = -1;
      return;
    }
    throw new IllegalStateException("not attached to a buffer");
  }
  
  public final long expandBuffer(int paramInt)
  {
    if (paramInt > 0)
    {
      if (paramInt <= 8192)
      {
        localObject = this.buffer;
        if (localObject != null)
        {
          if (this.readWrite)
          {
            long l1 = ((Buffer)localObject).size;
            localObject = this.buffer.writableSegment(paramInt);
            paramInt = 8192 - ((Segment)localObject).limit;
            ((Segment)localObject).limit = 8192;
            Buffer localBuffer = this.buffer;
            long l2 = paramInt;
            localBuffer.size = (l1 + l2);
            this.segment = ((Segment)localObject);
            this.offset = l1;
            this.data = ((Segment)localObject).data;
            this.start = (8192 - paramInt);
            this.end = 8192;
            return l2;
          }
          throw new IllegalStateException("expandBuffer() only permitted for read/write buffers");
        }
        throw new IllegalStateException("not attached to a buffer");
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("minByteCount > Segment.SIZE: ");
      ((StringBuilder)localObject).append(paramInt);
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("minByteCount <= 0: ");
    ((StringBuilder)localObject).append(paramInt);
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public final int next()
  {
    if (this.offset != this.buffer.size)
    {
      long l = this.offset;
      if (l == -1L) {
        return seek(0L);
      }
      return seek(l + (this.end - this.start));
    }
    throw new IllegalStateException();
  }
  
  public final long resizeBuffer(long paramLong)
  {
    Object localObject = this.buffer;
    if (localObject != null)
    {
      if (this.readWrite)
      {
        long l3 = ((Buffer)localObject).size;
        long l1;
        long l2;
        if (paramLong <= l3)
        {
          if (paramLong >= 0L)
          {
            l1 = l3 - paramLong;
            while (l1 > 0L)
            {
              localObject = this.buffer.head.prev;
              l2 = ((Segment)localObject).limit - ((Segment)localObject).pos;
              if (l2 <= l1)
              {
                this.buffer.head = ((Segment)localObject).pop();
                SegmentPool.recycle((Segment)localObject);
                l1 -= l2;
              }
              else
              {
                ((Segment)localObject).limit = ((int)(((Segment)localObject).limit - l1));
              }
            }
            this.segment = null;
            this.offset = paramLong;
            this.data = null;
            this.start = -1;
            this.end = -1;
          }
          else
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("newSize < 0: ");
            ((StringBuilder)localObject).append(paramLong);
            throw new IllegalArgumentException(((StringBuilder)localObject).toString());
          }
        }
        else if (paramLong > l3)
        {
          l1 = paramLong - l3;
          int i = 1;
          while (l1 > 0L)
          {
            localObject = this.buffer.writableSegment(1);
            int j = (int)Math.min(l1, 8192 - ((Segment)localObject).limit);
            ((Segment)localObject).limit += j;
            l2 = l1 - j;
            l1 = l2;
            if (i != 0)
            {
              this.segment = ((Segment)localObject);
              this.offset = l3;
              this.data = ((Segment)localObject).data;
              this.start = (((Segment)localObject).limit - j);
              this.end = ((Segment)localObject).limit;
              i = 0;
              l1 = l2;
            }
          }
        }
        this.buffer.size = paramLong;
        return l3;
      }
      throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers");
    }
    localObject = new IllegalStateException("not attached to a buffer");
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  public final int seek(long paramLong)
  {
    if ((paramLong >= -1L) && (paramLong <= this.buffer.size))
    {
      if ((paramLong != -1L) && (paramLong != this.buffer.size))
      {
        long l3 = 0L;
        long l4 = this.buffer.size;
        Segment localSegment1 = this.buffer.head;
        Segment localSegment2 = this.buffer.head;
        Segment localSegment3 = this.segment;
        long l1 = l3;
        long l2 = l4;
        localObject1 = localSegment1;
        Object localObject2 = localSegment2;
        if (localSegment3 != null)
        {
          l1 = this.offset - (this.start - localSegment3.pos);
          if (l1 > paramLong)
          {
            localObject2 = this.segment;
            l2 = l1;
            l1 = l3;
            localObject1 = localSegment1;
          }
          else
          {
            localObject1 = this.segment;
            localObject2 = localSegment2;
            l2 = l4;
          }
        }
        if (l2 - paramLong > paramLong - l1) {
          for (localObject2 = localObject1;; localObject2 = ((Segment)localObject2).next)
          {
            l2 = l1;
            localObject1 = localObject2;
            if (paramLong < ((Segment)localObject2).limit - ((Segment)localObject2).pos + l1) {
              break;
            }
            l1 += ((Segment)localObject2).limit - ((Segment)localObject2).pos;
          }
        }
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
        this.start = (((Segment)localObject2).pos + (int)(paramLong - l2));
        this.end = ((Segment)localObject2).limit;
        return this.end - this.start;
      }
      this.segment = null;
      this.offset = paramLong;
      this.data = null;
      this.start = -1;
      this.end = -1;
      return -1;
    }
    Object localObject1 = new ArrayIndexOutOfBoundsException(String.format("offset=%s > size=%s", new Object[] { Long.valueOf(paramLong), Long.valueOf(this.buffer.size) }));
    for (;;)
    {
      throw ((Throwable)localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     okio.Buffer.UnsafeCursor
 * JD-Core Version:    0.7.0.1
 */