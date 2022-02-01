package shark.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/internal/UnsortedByteEntries$MutableByteSubArray;", "", "(Lshark/internal/UnsortedByteEntries;)V", "writeByte", "", "value", "", "writeId", "", "writeInt", "", "writeLong", "writeTruncatedLong", "byteCount", "shark-graph"}, k=1, mv={1, 4, 1})
public final class UnsortedByteEntries$MutableByteSubArray
{
  public final void a(byte paramByte)
  {
    int j = UnsortedByteEntries.a(this.a);
    Object localObject = this.a;
    UnsortedByteEntries.a((UnsortedByteEntries)localObject, UnsortedByteEntries.a((UnsortedByteEntries)localObject) + 1);
    int i = UnsortedByteEntries.b(this.a);
    if ((j >= 0) && (i >= j)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      i = UnsortedByteEntries.c(this.a);
      int k = UnsortedByteEntries.b(this.a);
      localObject = UnsortedByteEntries.d(this.a);
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      localObject[((i - 1) * k + j)] = paramByte;
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Index ");
    ((StringBuilder)localObject).append(j);
    ((StringBuilder)localObject).append(" should be between 0 and ");
    ((StringBuilder)localObject).append(UnsortedByteEntries.b(this.a));
    throw ((Throwable)new IllegalArgumentException(((StringBuilder)localObject).toString().toString()));
  }
  
  public final void a(int paramInt)
  {
    int j = UnsortedByteEntries.a(this.a);
    Object localObject = this.a;
    UnsortedByteEntries.a((UnsortedByteEntries)localObject, UnsortedByteEntries.a((UnsortedByteEntries)localObject) + 4);
    int i;
    if ((j >= 0) && (j <= UnsortedByteEntries.b(this.a) - 4)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      j = (UnsortedByteEntries.c(this.a) - 1) * UnsortedByteEntries.b(this.a) + j;
      localObject = UnsortedByteEntries.d(this.a);
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      i = j + 1;
      localObject[j] = ((byte)(paramInt >>> 24 & 0xFF));
      j = i + 1;
      localObject[i] = ((byte)(paramInt >>> 16 & 0xFF));
      localObject[j] = ((byte)(paramInt >>> 8 & 0xFF));
      localObject[(j + 1)] = ((byte)(paramInt & 0xFF));
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Index ");
    ((StringBuilder)localObject).append(j);
    ((StringBuilder)localObject).append(" should be between 0 and ");
    ((StringBuilder)localObject).append(UnsortedByteEntries.b(this.a) - 4);
    throw ((Throwable)new IllegalArgumentException(((StringBuilder)localObject).toString().toString()));
  }
  
  public final void a(long paramLong)
  {
    if (UnsortedByteEntries.e(this.a))
    {
      b(paramLong);
      return;
    }
    a((int)paramLong);
  }
  
  public final void a(long paramLong, int paramInt)
  {
    int j = UnsortedByteEntries.a(this.a);
    Object localObject = this.a;
    UnsortedByteEntries.a((UnsortedByteEntries)localObject, UnsortedByteEntries.a((UnsortedByteEntries)localObject) + paramInt);
    int i;
    if ((j >= 0) && (j <= UnsortedByteEntries.b(this.a) - paramInt)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      j = (UnsortedByteEntries.c(this.a) - 1) * UnsortedByteEntries.b(this.a) + j;
      localObject = UnsortedByteEntries.d(this.a);
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      i = (paramInt - 1) * 8;
      paramInt = j;
      while (i >= 8)
      {
        localObject[paramInt] = ((byte)(int)(0xFF & paramLong >>> i));
        i -= 8;
        paramInt += 1;
      }
      localObject[paramInt] = ((byte)(int)(paramLong & 0xFF));
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Index ");
    ((StringBuilder)localObject).append(j);
    ((StringBuilder)localObject).append(" should be between 0 and ");
    ((StringBuilder)localObject).append(UnsortedByteEntries.b(this.a) - paramInt);
    localObject = (Throwable)new IllegalArgumentException(((StringBuilder)localObject).toString().toString());
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  public final void b(long paramLong)
  {
    int j = UnsortedByteEntries.a(this.a);
    Object localObject = this.a;
    UnsortedByteEntries.a((UnsortedByteEntries)localObject, UnsortedByteEntries.a((UnsortedByteEntries)localObject) + 8);
    int i;
    if ((j >= 0) && (j <= UnsortedByteEntries.b(this.a) - 8)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      j = (UnsortedByteEntries.c(this.a) - 1) * UnsortedByteEntries.b(this.a) + j;
      localObject = UnsortedByteEntries.d(this.a);
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      i = j + 1;
      localObject[j] = ((byte)(int)(paramLong >>> 56 & 0xFF));
      j = i + 1;
      localObject[i] = ((byte)(int)(paramLong >>> 48 & 0xFF));
      i = j + 1;
      localObject[j] = ((byte)(int)(paramLong >>> 40 & 0xFF));
      j = i + 1;
      localObject[i] = ((byte)(int)(paramLong >>> 32 & 0xFF));
      i = j + 1;
      localObject[j] = ((byte)(int)(paramLong >>> 24 & 0xFF));
      j = i + 1;
      localObject[i] = ((byte)(int)(paramLong >>> 16 & 0xFF));
      localObject[j] = ((byte)(int)(paramLong >>> 8 & 0xFF));
      localObject[(j + 1)] = ((byte)(int)(paramLong & 0xFF));
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Index ");
    ((StringBuilder)localObject).append(j);
    ((StringBuilder)localObject).append(" should be between 0 and ");
    ((StringBuilder)localObject).append(UnsortedByteEntries.b(this.a) - 8);
    throw ((Throwable)new IllegalArgumentException(((StringBuilder)localObject).toString().toString()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.internal.UnsortedByteEntries.MutableByteSubArray
 * JD-Core Version:    0.7.0.1
 */