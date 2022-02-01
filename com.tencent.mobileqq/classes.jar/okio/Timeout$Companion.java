package okio;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lokio/Timeout$Companion;", "", "()V", "NONE", "Lokio/Timeout;", "minTimeout", "", "aNanos", "bNanos", "okio"}, k=1, mv={1, 1, 16})
public final class Timeout$Companion
{
  public final long minTimeout(long paramLong1, long paramLong2)
  {
    if (paramLong1 != 0L)
    {
      if (paramLong2 == 0L) {
        return paramLong1;
      }
      if (paramLong1 < paramLong2) {
        return paramLong1;
      }
    }
    return paramLong2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okio.Timeout.Companion
 * JD-Core Version:    0.7.0.1
 */