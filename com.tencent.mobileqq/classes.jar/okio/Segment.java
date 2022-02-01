package okio;

import javax.annotation.Nullable;

final class Segment
{
  static final int SHARE_MINIMUM = 1024;
  static final int SIZE = 8192;
  final byte[] data;
  int limit;
  Segment next;
  boolean owner;
  int pos;
  Segment prev;
  boolean shared;
  
  Segment()
  {
    this.data = new byte[8192];
    this.owner = true;
    this.shared = false;
  }
  
  Segment(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.data = paramArrayOfByte;
    this.pos = paramInt1;
    this.limit = paramInt2;
    this.shared = paramBoolean1;
    this.owner = paramBoolean2;
  }
  
  public final void compact()
  {
    Segment localSegment = this.prev;
    if (localSegment != this)
    {
      if (!localSegment.owner) {
        return;
      }
      int j = this.limit - this.pos;
      int k = localSegment.limit;
      int i;
      if (localSegment.shared) {
        i = 0;
      } else {
        i = localSegment.pos;
      }
      if (j > 8192 - k + i) {
        return;
      }
      writeTo(this.prev, j);
      pop();
      SegmentPool.recycle(this);
      return;
    }
    throw new IllegalStateException();
  }
  
  @Nullable
  public final Segment pop()
  {
    Segment localSegment1 = this.next;
    if (localSegment1 == this) {
      localSegment1 = null;
    }
    Segment localSegment2 = this.prev;
    localSegment2.next = this.next;
    this.next.prev = localSegment2;
    this.next = null;
    this.prev = null;
    return localSegment1;
  }
  
  public final Segment push(Segment paramSegment)
  {
    paramSegment.prev = this;
    paramSegment.next = this.next;
    this.next.prev = paramSegment;
    this.next = paramSegment;
    return paramSegment;
  }
  
  final Segment sharedCopy()
  {
    this.shared = true;
    return new Segment(this.data, this.pos, this.limit, true, false);
  }
  
  public final Segment split(int paramInt)
  {
    if ((paramInt > 0) && (paramInt <= this.limit - this.pos))
    {
      Segment localSegment;
      if (paramInt >= 1024)
      {
        localSegment = sharedCopy();
      }
      else
      {
        localSegment = SegmentPool.take();
        System.arraycopy(this.data, this.pos, localSegment.data, 0, paramInt);
      }
      localSegment.limit = (localSegment.pos + paramInt);
      this.pos += paramInt;
      this.prev.push(localSegment);
      return localSegment;
    }
    throw new IllegalArgumentException();
  }
  
  final Segment unsharedCopy()
  {
    return new Segment((byte[])this.data.clone(), this.pos, this.limit, false, true);
  }
  
  public final void writeTo(Segment paramSegment, int paramInt)
  {
    if (paramSegment.owner)
    {
      int i = paramSegment.limit;
      if (i + paramInt > 8192) {
        if (!paramSegment.shared)
        {
          int j = paramSegment.pos;
          if (i + paramInt - j <= 8192)
          {
            byte[] arrayOfByte = paramSegment.data;
            System.arraycopy(arrayOfByte, j, arrayOfByte, 0, i - j);
            paramSegment.limit -= paramSegment.pos;
            paramSegment.pos = 0;
          }
          else
          {
            throw new IllegalArgumentException();
          }
        }
        else
        {
          throw new IllegalArgumentException();
        }
      }
      System.arraycopy(this.data, this.pos, paramSegment.data, paramSegment.limit, paramInt);
      paramSegment.limit += paramInt;
      this.pos += paramInt;
      return;
    }
    throw new IllegalArgumentException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     okio.Segment
 * JD-Core Version:    0.7.0.1
 */