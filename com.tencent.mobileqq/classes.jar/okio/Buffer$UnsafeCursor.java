package okio;

import java.io.Closeable;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lokio/Buffer$UnsafeCursor;", "Ljava/io/Closeable;", "()V", "buffer", "Lokio/Buffer;", "data", "", "end", "", "offset", "", "readWrite", "", "segment", "Lokio/Segment;", "start", "close", "", "expandBuffer", "minByteCount", "next", "resizeBuffer", "newSize", "seek", "okio"}, k=1, mv={1, 1, 16})
public final class Buffer$UnsafeCursor
  implements Closeable
{
  @JvmField
  @Nullable
  public Buffer buffer;
  @JvmField
  @Nullable
  public byte[] data;
  @JvmField
  public int end = -1;
  @JvmField
  public long offset = -1L;
  @JvmField
  public boolean readWrite;
  private Segment segment;
  @JvmField
  public int start = -1;
  
  public void close()
  {
    int i;
    if (this.buffer != null) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      this.buffer = ((Buffer)null);
      this.segment = ((Segment)null);
      this.offset = -1L;
      this.data = ((byte[])null);
      this.start = -1;
      this.end = -1;
      return;
    }
    throw ((Throwable)new IllegalStateException("not attached to a buffer".toString()));
  }
  
  public final long expandBuffer(int paramInt)
  {
    int j = 1;
    int i;
    if (paramInt > 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (paramInt <= 8192) {
        i = j;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        localObject = this.buffer;
        if (localObject != null)
        {
          if (this.readWrite)
          {
            long l1 = ((Buffer)localObject).size();
            Segment localSegment = ((Buffer)localObject).writableSegment$okio(paramInt);
            paramInt = 8192 - localSegment.limit;
            localSegment.limit = 8192;
            long l2 = paramInt;
            ((Buffer)localObject).setSize$okio(l1 + l2);
            this.segment = localSegment;
            this.offset = l1;
            this.data = localSegment.data;
            this.start = (8192 - paramInt);
            this.end = 8192;
            return l2;
          }
          throw ((Throwable)new IllegalStateException("expandBuffer() only permitted for read/write buffers".toString()));
        }
        throw ((Throwable)new IllegalStateException("not attached to a buffer".toString()));
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("minByteCount > Segment.SIZE: ");
      ((StringBuilder)localObject).append(paramInt);
      throw ((Throwable)new IllegalArgumentException(((StringBuilder)localObject).toString().toString()));
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("minByteCount <= 0: ");
    ((StringBuilder)localObject).append(paramInt);
    throw ((Throwable)new IllegalArgumentException(((StringBuilder)localObject).toString().toString()));
  }
  
  public final int next()
  {
    long l = this.offset;
    Buffer localBuffer = this.buffer;
    if (localBuffer == null) {
      Intrinsics.throwNpe();
    }
    int i;
    if (l != localBuffer.size()) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      l = this.offset;
      if (l == -1L) {
        l = 0L;
      } else {
        l += this.end - this.start;
      }
      return seek(l);
    }
    throw ((Throwable)new IllegalStateException("no more bytes".toString()));
  }
  
  public final long resizeBuffer(long paramLong)
  {
    Object localObject = this.buffer;
    if (localObject != null)
    {
      if (this.readWrite)
      {
        long l2 = ((Buffer)localObject).size();
        int i;
        long l1;
        Segment localSegment;
        if (paramLong <= l2)
        {
          if (paramLong >= 0L) {
            i = 1;
          } else {
            i = 0;
          }
          if (i != 0)
          {
            l1 = l2 - paramLong;
            while (l1 > 0L)
            {
              localSegment = ((Buffer)localObject).head;
              if (localSegment == null) {
                Intrinsics.throwNpe();
              }
              localSegment = localSegment.prev;
              if (localSegment == null) {
                Intrinsics.throwNpe();
              }
              long l3 = localSegment.limit - localSegment.pos;
              if (l3 <= l1)
              {
                ((Buffer)localObject).head = localSegment.pop();
                SegmentPool.INSTANCE.recycle(localSegment);
                l1 -= l3;
              }
              else
              {
                localSegment.limit -= (int)l1;
              }
            }
            this.segment = ((Segment)null);
            this.offset = paramLong;
            this.data = ((byte[])null);
            this.start = -1;
            this.end = -1;
          }
          else
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("newSize < 0: ");
            ((StringBuilder)localObject).append(paramLong);
            throw ((Throwable)new IllegalArgumentException(((StringBuilder)localObject).toString().toString()));
          }
        }
        else if (paramLong > l2)
        {
          l1 = paramLong - l2;
          int j;
          for (i = 1; l1 > 0L; i = j)
          {
            localSegment = ((Buffer)localObject).writableSegment$okio(1);
            int k = (int)Math.min(l1, 8192 - localSegment.limit);
            localSegment.limit += k;
            l1 -= k;
            j = i;
            if (i != 0)
            {
              this.segment = localSegment;
              this.offset = l2;
              this.data = localSegment.data;
              this.start = (localSegment.limit - k);
              this.end = localSegment.limit;
              j = 0;
            }
          }
        }
        ((Buffer)localObject).setSize$okio(paramLong);
        return l2;
      }
      throw ((Throwable)new IllegalStateException("resizeBuffer() only permitted for read/write buffers".toString()));
    }
    localObject = (Throwable)new IllegalStateException("not attached to a buffer".toString());
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  public final int seek(long paramLong)
  {
    Buffer localBuffer = this.buffer;
    if (localBuffer != null)
    {
      if ((paramLong >= -1) && (paramLong <= localBuffer.size()))
      {
        if ((paramLong != -1L) && (paramLong != localBuffer.size()))
        {
          long l3 = 0L;
          long l4 = localBuffer.size();
          Segment localSegment1 = localBuffer.head;
          Segment localSegment2 = localBuffer.head;
          Segment localSegment3 = this.segment;
          long l1 = l3;
          long l2 = l4;
          localObject1 = localSegment1;
          Object localObject2 = localSegment2;
          if (localSegment3 != null)
          {
            l1 = this.offset;
            int i = this.start;
            if (localSegment3 == null) {
              Intrinsics.throwNpe();
            }
            l1 -= i - localSegment3.pos;
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
              if (localObject2 == null) {
                Intrinsics.throwNpe();
              }
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
            if (localObject2 == null) {
              Intrinsics.throwNpe();
            }
            localObject2 = ((Segment)localObject2).prev;
            if (localObject2 == null) {
              Intrinsics.throwNpe();
            }
          }
          localObject2 = localObject1;
          if (this.readWrite)
          {
            if (localObject1 == null) {
              Intrinsics.throwNpe();
            }
            localObject2 = localObject1;
            if (((Segment)localObject1).shared)
            {
              localObject2 = ((Segment)localObject1).unsharedCopy();
              if (localBuffer.head == localObject1) {
                localBuffer.head = ((Segment)localObject2);
              }
              localObject2 = ((Segment)localObject1).push((Segment)localObject2);
              localObject1 = ((Segment)localObject2).prev;
              if (localObject1 == null) {
                Intrinsics.throwNpe();
              }
              ((Segment)localObject1).pop();
            }
          }
          this.segment = ((Segment)localObject2);
          this.offset = paramLong;
          if (localObject2 == null) {
            Intrinsics.throwNpe();
          }
          this.data = ((Segment)localObject2).data;
          this.start = (((Segment)localObject2).pos + (int)(paramLong - l2));
          this.end = ((Segment)localObject2).limit;
          return this.end - this.start;
        }
        this.segment = ((Segment)null);
        this.offset = paramLong;
        this.data = ((byte[])null);
        this.start = -1;
        this.end = -1;
        return -1;
      }
      localObject1 = StringCompanionObject.INSTANCE;
      localObject1 = new Object[2];
      localObject1[0] = Long.valueOf(paramLong);
      localObject1[1] = Long.valueOf(localBuffer.size());
      localObject1 = String.format("offset=%s > size=%s", Arrays.copyOf((Object[])localObject1, localObject1.length));
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "java.lang.String.format(format, *args)");
      throw ((Throwable)new ArrayIndexOutOfBoundsException((String)localObject1));
    }
    Object localObject1 = (Throwable)new IllegalStateException("not attached to a buffer".toString());
    for (;;)
    {
      throw ((Throwable)localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okio.Buffer.UnsafeCursor
 * JD-Core Version:    0.7.0.1
 */