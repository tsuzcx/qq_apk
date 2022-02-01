package shark.internal;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import shark.internal.aosp.ByteArrayComparator;
import shark.internal.aosp.ByteArrayTimSort;
import shark.internal.aosp.ByteArrayTimSort.Companion;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/internal/UnsortedByteEntries;", "", "bytesPerValue", "", "longIdentifiers", "", "initialCapacity", "growthFactor", "", "(IZID)V", "assigned", "bytesPerEntry", "currentCapacity", "entries", "", "subArray", "Lshark/internal/UnsortedByteEntries$MutableByteSubArray;", "subArrayIndex", "append", "key", "", "growEntries", "", "newCapacity", "moveToSortedMap", "Lshark/internal/SortedBytesMap;", "readInt", "array", "index", "readLong", "and", "", "other", "MutableByteSubArray", "shark-graph"}, k=1, mv={1, 4, 1})
public final class UnsortedByteEntries
{
  private final int a;
  private byte[] b;
  private final UnsortedByteEntries.MutableByteSubArray c;
  private int d;
  private int e;
  private int f;
  private final int g;
  private final boolean h;
  private final int i;
  private final double j;
  
  public UnsortedByteEntries(int paramInt1, boolean paramBoolean, int paramInt2, double paramDouble)
  {
    this.g = paramInt1;
    this.h = paramBoolean;
    this.i = paramInt2;
    this.j = paramDouble;
    paramInt2 = this.g;
    if (this.h) {
      paramInt1 = 8;
    } else {
      paramInt1 = 4;
    }
    this.a = (paramInt2 + paramInt1);
    this.c = new UnsortedByteEntries.MutableByteSubArray(this);
  }
  
  private final int a(byte[] paramArrayOfByte, int paramInt)
  {
    int m = paramInt + 1;
    paramInt = paramArrayOfByte[paramInt];
    int k = m + 1;
    m = paramArrayOfByte[m];
    int n = paramArrayOfByte[k];
    return paramArrayOfByte[(k + 1)] & 0xFF | (paramInt & 0xFF) << 24 | (m & 0xFF) << 16 | (n & 0xFF) << 8;
  }
  
  private final void a(int paramInt)
  {
    int k = this.a;
    byte[] arrayOfByte = new byte[paramInt * k];
    System.arraycopy(this.b, 0, arrayOfByte, 0, this.e * k);
    this.b = arrayOfByte;
  }
  
  private final long b(byte[] paramArrayOfByte, int paramInt)
  {
    int k = paramInt + 1;
    long l1 = paramArrayOfByte[paramInt];
    paramInt = k + 1;
    long l2 = paramArrayOfByte[k];
    k = paramInt + 1;
    long l3 = paramArrayOfByte[paramInt];
    paramInt = k + 1;
    long l4 = paramArrayOfByte[k];
    k = paramInt + 1;
    long l5 = paramArrayOfByte[paramInt];
    paramInt = k + 1;
    long l6 = paramArrayOfByte[k];
    long l7 = paramArrayOfByte[paramInt];
    return paramArrayOfByte[(paramInt + 1)] & 0xFF | (l1 & 0xFF) << 56 | (l2 & 0xFF) << 48 | (l3 & 0xFF) << 40 | (l4 & 0xFF) << 32 | (l5 & 0xFF) << 24 | (l6 & 0xFF) << 16 | (l7 & 0xFF) << 8;
  }
  
  @NotNull
  public final SortedBytesMap a()
  {
    if (this.e == 0) {
      return new SortedBytesMap(this.h, this.g, new byte[0]);
    }
    byte[] arrayOfByte2 = this.b;
    if (arrayOfByte2 == null) {
      Intrinsics.throwNpe();
    }
    ByteArrayTimSort.a.a(arrayOfByte2, 0, this.e, this.a, (ByteArrayComparator)new UnsortedByteEntries.moveToSortedMap.1(this));
    int k = arrayOfByte2.length;
    int m = this.e;
    int n = this.a;
    byte[] arrayOfByte1 = arrayOfByte2;
    if (k > m * n)
    {
      arrayOfByte1 = Arrays.copyOf(arrayOfByte2, m * n);
      Intrinsics.checkExpressionValueIsNotNull(arrayOfByte1, "java.util.Arrays.copyOf(this, newSize)");
    }
    this.b = ((byte[])null);
    this.e = 0;
    return new SortedBytesMap(this.h, this.g, arrayOfByte1);
  }
  
  @NotNull
  public final UnsortedByteEntries.MutableByteSubArray a(long paramLong)
  {
    if (this.b == null)
    {
      this.f = this.i;
      this.b = new byte[this.f * this.a];
    }
    else
    {
      int k = this.f;
      if (k == this.e)
      {
        double d1 = k;
        double d2 = this.j;
        Double.isNaN(d1);
        k = (int)(d1 * d2);
        a(k);
        this.f = k;
      }
    }
    this.e += 1;
    this.d = 0;
    this.c.a(paramLong);
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.internal.UnsortedByteEntries
 * JD-Core Version:    0.7.0.1
 */