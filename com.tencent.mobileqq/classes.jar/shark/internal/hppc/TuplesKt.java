package shark.internal.hppc;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"to", "Lshark/internal/hppc/IntObjectPair;", "B", "", "that", "(ILjava/lang/Object;)Lshark/internal/hppc/IntObjectPair;", "Lshark/internal/hppc/LongObjectPair;", "", "(JLjava/lang/Object;)Lshark/internal/hppc/LongObjectPair;", "Lshark/internal/hppc/LongLongPair;", "shark-graph"}, k=2, mv={1, 4, 1})
public final class TuplesKt
{
  @NotNull
  public static final <B> IntObjectPair<B> a(int paramInt, B paramB)
  {
    return new IntObjectPair(paramInt, paramB);
  }
  
  @NotNull
  public static final LongLongPair a(long paramLong1, long paramLong2)
  {
    return new LongLongPair(paramLong1, paramLong2);
  }
  
  @NotNull
  public static final <B> LongObjectPair<B> a(long paramLong, B paramB)
  {
    return new LongObjectPair(paramLong, paramB);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.internal.hppc.TuplesKt
 * JD-Core Version:    0.7.0.1
 */