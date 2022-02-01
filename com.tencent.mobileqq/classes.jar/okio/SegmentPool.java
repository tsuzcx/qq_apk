package okio;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lokio/SegmentPool;", "", "()V", "MAX_SIZE", "", "byteCount", "getByteCount", "()J", "setByteCount", "(J)V", "next", "Lokio/Segment;", "getNext", "()Lokio/Segment;", "setNext", "(Lokio/Segment;)V", "recycle", "", "segment", "take", "okio"}, k=1, mv={1, 1, 16})
public final class SegmentPool
{
  public static final SegmentPool INSTANCE = new SegmentPool();
  public static final long MAX_SIZE = 65536L;
  private static long byteCount;
  @Nullable
  private static Segment next;
  
  public final long getByteCount()
  {
    return byteCount;
  }
  
  @Nullable
  public final Segment getNext()
  {
    return next;
  }
  
  public final void recycle(@NotNull Segment paramSegment)
  {
    Intrinsics.checkParameterIsNotNull(paramSegment, "segment");
    int i;
    if ((paramSegment.next == null) && (paramSegment.prev == null)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (paramSegment.shared) {
        return;
      }
      try
      {
        long l1 = byteCount;
        long l2 = 8192;
        if (l1 + l2 > 65536L) {
          return;
        }
        byteCount += l2;
        paramSegment.next = next;
        paramSegment.limit = 0;
        paramSegment.pos = paramSegment.limit;
        next = paramSegment;
        paramSegment = Unit.INSTANCE;
        return;
      }
      finally {}
    }
    throw ((Throwable)new IllegalArgumentException("Failed requirement.".toString()));
  }
  
  public final void setByteCount(long paramLong)
  {
    byteCount = paramLong;
  }
  
  public final void setNext(@Nullable Segment paramSegment)
  {
    next = paramSegment;
  }
  
  @NotNull
  public final Segment take()
  {
    try
    {
      Segment localSegment = next;
      if (localSegment != null)
      {
        next = localSegment.next;
        localSegment.next = ((Segment)null);
        byteCount -= 8192;
        return localSegment;
      }
      return new Segment();
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okio.SegmentPool
 * JD-Core Version:    0.7.0.1
 */