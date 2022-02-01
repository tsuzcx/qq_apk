package shark.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import shark.internal.aosp.ByteArrayComparator;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"shark/internal/UnsortedByteEntries$moveToSortedMap$1", "Lshark/internal/aosp/ByteArrayComparator;", "compare", "", "entrySize", "o1Array", "", "o1Index", "o2Array", "o2Index", "shark-graph"}, k=1, mv={1, 4, 1})
public final class UnsortedByteEntries$moveToSortedMap$1
  implements ByteArrayComparator
{
  public int a(int paramInt1, @NotNull byte[] paramArrayOfByte1, int paramInt2, @NotNull byte[] paramArrayOfByte2, int paramInt3)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte1, "o1Array");
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte2, "o2Array");
    if (UnsortedByteEntries.e(this.a)) {
      return UnsortedByteEntries.a(this.a, paramArrayOfByte1, paramInt2 * paramInt1) < UnsortedByteEntries.a(this.a, paramArrayOfByte2, paramInt3 * paramInt1);
    }
    return Intrinsics.compare(UnsortedByteEntries.b(this.a, paramArrayOfByte1, paramInt2 * paramInt1), UnsortedByteEntries.b(this.a, paramArrayOfByte2, paramInt3 * paramInt1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.internal.UnsortedByteEntries.moveToSortedMap.1
 * JD-Core Version:    0.7.0.1
 */