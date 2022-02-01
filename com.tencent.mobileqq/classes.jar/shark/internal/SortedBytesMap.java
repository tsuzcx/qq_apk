package shark.internal;

import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import shark.internal.hppc.LongObjectPair;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/internal/SortedBytesMap;", "", "longIdentifiers", "", "bytesPerValue", "", "sortedEntries", "", "(ZI[B)V", "bytesPerEntry", "bytesPerKey", "size", "getSize", "()I", "binarySearch", "key", "", "contains", "entrySequence", "Lkotlin/sequences/Sequence;", "Lshark/internal/hppc/LongObjectPair;", "Lshark/internal/ByteSubArray;", "get", "getAtIndex", "keyIndex", "indexOf", "keyAt", "index", "shark-graph"}, k=1, mv={1, 4, 1})
public final class SortedBytesMap
{
  private final int a;
  private final int b;
  private final int c;
  private final boolean d;
  private final int e;
  private final byte[] f;
  
  public SortedBytesMap(boolean paramBoolean, int paramInt, @NotNull byte[] paramArrayOfByte)
  {
    this.d = paramBoolean;
    this.e = paramInt;
    this.f = paramArrayOfByte;
    if (this.d) {
      paramInt = 8;
    } else {
      paramInt = 4;
    }
    this.a = paramInt;
    this.b = (this.a + this.e);
    this.c = (this.f.length / this.b);
  }
  
  private final int c(long paramLong)
  {
    int j = this.c - 1;
    int i = 0;
    while (i <= j)
    {
      int k = i + j >>> 1;
      long l = b(k);
      if (l < paramLong) {
        i = k + 1;
      } else if (l > paramLong) {
        j = k - 1;
      } else {
        return k;
      }
    }
    return i ^ 0xFFFFFFFF;
  }
  
  public final int a()
  {
    return this.c;
  }
  
  @NotNull
  public final ByteSubArray a(int paramInt)
  {
    int i = this.b;
    int j = this.a;
    return new ByteSubArray(this.f, paramInt * i + j, this.e, this.d);
  }
  
  @Nullable
  public final ByteSubArray a(long paramLong)
  {
    int i = c(paramLong);
    if (i < 0) {
      return null;
    }
    return a(i);
  }
  
  public final int b(long paramLong)
  {
    return c(paramLong);
  }
  
  public final long b(int paramInt)
  {
    paramInt *= this.b;
    if (this.d) {
      return ByteSubArrayKt.c(this.f, paramInt);
    }
    return ByteSubArrayKt.b(this.f, paramInt);
  }
  
  @NotNull
  public final Sequence<LongObjectPair<ByteSubArray>> b()
  {
    return SequencesKt.map(CollectionsKt.asSequence((Iterable)RangesKt.until(0, this.c)), (Function1)new SortedBytesMap.entrySequence.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.internal.SortedBytesMap
 * JD-Core Version:    0.7.0.1
 */