package shark.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"and", "", "", "other", "", "readInt", "", "index", "readLong", "readShort", "", "shark-graph"}, k=2, mv={1, 4, 1})
public final class ByteSubArrayKt
{
  public static final short a(@NotNull byte[] paramArrayOfByte, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$readShort");
    int i = paramArrayOfByte[paramInt];
    return (short)(paramArrayOfByte[(paramInt + 1)] & 0xFF | (i & 0xFF) << 8);
  }
  
  public static final int b(@NotNull byte[] paramArrayOfByte, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$readInt");
    int j = paramInt + 1;
    paramInt = paramArrayOfByte[paramInt];
    int i = j + 1;
    j = paramArrayOfByte[j];
    int k = paramArrayOfByte[i];
    return paramArrayOfByte[(i + 1)] & 0xFF | (paramInt & 0xFF) << 24 | (j & 0xFF) << 16 | (k & 0xFF) << 8;
  }
  
  public static final long c(@NotNull byte[] paramArrayOfByte, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$readLong");
    int i = paramInt + 1;
    long l1 = paramArrayOfByte[paramInt];
    paramInt = i + 1;
    long l2 = paramArrayOfByte[i];
    i = paramInt + 1;
    long l3 = paramArrayOfByte[paramInt];
    paramInt = i + 1;
    long l4 = paramArrayOfByte[i];
    i = paramInt + 1;
    long l5 = paramArrayOfByte[paramInt];
    paramInt = i + 1;
    long l6 = paramArrayOfByte[i];
    long l7 = paramArrayOfByte[paramInt];
    return paramArrayOfByte[(paramInt + 1)] & 0xFF | (l1 & 0xFF) << 56 | (l2 & 0xFF) << 48 | (l3 & 0xFF) << 40 | (l4 & 0xFF) << 32 | (l5 & 0xFF) << 24 | (l6 & 0xFF) << 16 | (l7 & 0xFF) << 8;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.internal.ByteSubArrayKt
 * JD-Core Version:    0.7.0.1
 */