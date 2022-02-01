package okio;

import javax.annotation.Nullable;

final class SegmentPool
{
  static final long MAX_SIZE = 65536L;
  static long byteCount;
  @Nullable
  static Segment next;
  
  static void recycle(Segment paramSegment)
  {
    if ((paramSegment.next == null) && (paramSegment.prev == null))
    {
      if (paramSegment.shared) {
        return;
      }
      try
      {
        if (byteCount + 8192L > 65536L) {
          return;
        }
        byteCount += 8192L;
        paramSegment.next = next;
        paramSegment.limit = 0;
        paramSegment.pos = 0;
        next = paramSegment;
        return;
      }
      finally {}
    }
    throw new IllegalArgumentException();
  }
  
  static Segment take()
  {
    try
    {
      if (next != null)
      {
        Segment localSegment = next;
        next = localSegment.next;
        localSegment.next = null;
        byteCount -= 8192L;
        return localSegment;
      }
      return new Segment();
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     okio.SegmentPool
 * JD-Core Version:    0.7.0.1
 */