package okio;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lokio/Segment;", "", "()V", "data", "", "pos", "", "limit", "shared", "", "owner", "([BIIZZ)V", "next", "prev", "compact", "", "pop", "push", "segment", "sharedCopy", "split", "byteCount", "unsharedCopy", "writeTo", "sink", "Companion", "okio"}, k=1, mv={1, 1, 16})
public final class Segment
{
  public static final Segment.Companion Companion = new Segment.Companion(null);
  public static final int SHARE_MINIMUM = 1024;
  public static final int SIZE = 8192;
  @JvmField
  @NotNull
  public final byte[] data;
  @JvmField
  public int limit;
  @JvmField
  @Nullable
  public Segment next;
  @JvmField
  public boolean owner;
  @JvmField
  public int pos;
  @JvmField
  @Nullable
  public Segment prev;
  @JvmField
  public boolean shared;
  
  public Segment()
  {
    this.data = new byte[8192];
    this.owner = true;
    this.shared = false;
  }
  
  public Segment(@NotNull byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.data = paramArrayOfByte;
    this.pos = paramInt1;
    this.limit = paramInt2;
    this.shared = paramBoolean1;
    this.owner = paramBoolean2;
  }
  
  public final void compact()
  {
    Segment localSegment1 = this.prev;
    Segment localSegment2 = (Segment)this;
    int j = 0;
    int i;
    if (localSegment1 != localSegment2) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      localSegment1 = this.prev;
      if (localSegment1 == null) {
        Intrinsics.throwNpe();
      }
      if (!localSegment1.owner) {
        return;
      }
      int k = this.limit - this.pos;
      localSegment1 = this.prev;
      if (localSegment1 == null) {
        Intrinsics.throwNpe();
      }
      int m = localSegment1.limit;
      localSegment1 = this.prev;
      if (localSegment1 == null) {
        Intrinsics.throwNpe();
      }
      if (localSegment1.shared)
      {
        i = j;
      }
      else
      {
        localSegment1 = this.prev;
        if (localSegment1 == null) {
          Intrinsics.throwNpe();
        }
        i = localSegment1.pos;
      }
      if (k > 8192 - m + i) {
        return;
      }
      localSegment1 = this.prev;
      if (localSegment1 == null) {
        Intrinsics.throwNpe();
      }
      writeTo(localSegment1, k);
      pop();
      SegmentPool.INSTANCE.recycle(this);
      return;
    }
    throw ((Throwable)new IllegalStateException("cannot compact".toString()));
  }
  
  @Nullable
  public final Segment pop()
  {
    Segment localSegment1 = this.next;
    if (localSegment1 == (Segment)this) {
      localSegment1 = null;
    }
    Segment localSegment2 = this.prev;
    if (localSegment2 == null) {
      Intrinsics.throwNpe();
    }
    localSegment2.next = this.next;
    localSegment2 = this.next;
    if (localSegment2 == null) {
      Intrinsics.throwNpe();
    }
    localSegment2.prev = this.prev;
    localSegment2 = (Segment)null;
    this.next = localSegment2;
    this.prev = localSegment2;
    return localSegment1;
  }
  
  @NotNull
  public final Segment push(@NotNull Segment paramSegment)
  {
    Intrinsics.checkParameterIsNotNull(paramSegment, "segment");
    paramSegment.prev = ((Segment)this);
    paramSegment.next = this.next;
    Segment localSegment = this.next;
    if (localSegment == null) {
      Intrinsics.throwNpe();
    }
    localSegment.prev = paramSegment;
    this.next = paramSegment;
    return paramSegment;
  }
  
  @NotNull
  public final Segment sharedCopy()
  {
    this.shared = true;
    return new Segment(this.data, this.pos, this.limit, true, false);
  }
  
  @NotNull
  public final Segment split(int paramInt)
  {
    int i;
    if ((paramInt > 0) && (paramInt <= this.limit - this.pos)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      Segment localSegment;
      if (paramInt >= 1024)
      {
        localSegment = sharedCopy();
      }
      else
      {
        localSegment = SegmentPool.INSTANCE.take();
        localObject = this.data;
        byte[] arrayOfByte = localSegment.data;
        i = this.pos;
        ArraysKt.copyInto$default((byte[])localObject, arrayOfByte, 0, i, i + paramInt, 2, null);
      }
      localSegment.limit = (localSegment.pos + paramInt);
      this.pos += paramInt;
      Object localObject = this.prev;
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      ((Segment)localObject).push(localSegment);
      return localSegment;
    }
    throw ((Throwable)new IllegalArgumentException("byteCount out of range".toString()));
  }
  
  @NotNull
  public final Segment unsharedCopy()
  {
    byte[] arrayOfByte = this.data;
    arrayOfByte = Arrays.copyOf(arrayOfByte, arrayOfByte.length);
    Intrinsics.checkExpressionValueIsNotNull(arrayOfByte, "java.util.Arrays.copyOf(this, size)");
    return new Segment(arrayOfByte, this.pos, this.limit, false, true);
  }
  
  public final void writeTo(@NotNull Segment paramSegment, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramSegment, "sink");
    if (paramSegment.owner)
    {
      int i = paramSegment.limit;
      if (i + paramInt > 8192) {
        if (!paramSegment.shared)
        {
          j = paramSegment.pos;
          if (i + paramInt - j <= 8192)
          {
            arrayOfByte1 = paramSegment.data;
            ArraysKt.copyInto$default(arrayOfByte1, arrayOfByte1, 0, j, i, 2, null);
            paramSegment.limit -= paramSegment.pos;
            paramSegment.pos = 0;
          }
          else
          {
            throw ((Throwable)new IllegalArgumentException());
          }
        }
        else
        {
          throw ((Throwable)new IllegalArgumentException());
        }
      }
      byte[] arrayOfByte1 = this.data;
      byte[] arrayOfByte2 = paramSegment.data;
      i = paramSegment.limit;
      int j = this.pos;
      ArraysKt.copyInto(arrayOfByte1, arrayOfByte2, i, j, j + paramInt);
      paramSegment.limit += paramInt;
      this.pos += paramInt;
      return;
    }
    throw ((Throwable)new IllegalStateException("only owner can write".toString()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okio.Segment
 * JD-Core Version:    0.7.0.1
 */