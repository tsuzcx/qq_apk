package shark.internal;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/internal/ByteSubArray;", "", "array", "", "rangeStart", "", "size", "longIdentifiers", "", "([BIIZ)V", "currentIndex", "endInclusive", "readByte", "", "readId", "", "readInt", "readLong", "readTruncatedLong", "byteCount", "shark-graph"}, k=1, mv={1, 4, 1})
public final class ByteSubArray
{
  private final int a;
  private int b;
  private final byte[] c;
  private final int d;
  private final boolean e;
  
  public ByteSubArray(@NotNull byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.c = paramArrayOfByte;
    this.d = paramInt1;
    this.e = paramBoolean;
    this.a = (paramInt2 - 1);
  }
  
  public final byte a()
  {
    int j = this.b;
    this.b = (j + 1);
    int i = this.a;
    if ((j >= 0) && (i >= j)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return this.c[(this.d + j)];
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Index ");
    localStringBuilder.append(j);
    localStringBuilder.append(" should be between 0 and ");
    localStringBuilder.append(this.a);
    throw ((Throwable)new IllegalArgumentException(localStringBuilder.toString().toString()));
  }
  
  public final long a(int paramInt)
  {
    int j = this.b;
    this.b = (j + paramInt);
    int i;
    if ((j >= 0) && (j <= this.a - (paramInt - 1))) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      j = this.d + j;
      localObject = this.c;
      long l = 0L;
      i = (paramInt - 1) * 8;
      paramInt = j;
      while (i >= 8)
      {
        l |= (0xFF & localObject[paramInt]) << i;
        i -= 8;
        paramInt += 1;
      }
      return localObject[paramInt] & 0xFF | l;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Index ");
    ((StringBuilder)localObject).append(j);
    ((StringBuilder)localObject).append(" should be between 0 and ");
    ((StringBuilder)localObject).append(this.a - (paramInt - 1));
    localObject = (Throwable)new IllegalArgumentException(((StringBuilder)localObject).toString().toString());
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  public final long b()
  {
    if (this.e) {
      return d();
    }
    return c();
  }
  
  public final int c()
  {
    int j = this.b;
    this.b = (j + 4);
    int i;
    if ((j >= 0) && (j <= this.a - 3)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return ByteSubArrayKt.b(this.c, this.d + j);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Index ");
    localStringBuilder.append(j);
    localStringBuilder.append(" should be between 0 and ");
    localStringBuilder.append(this.a - 3);
    throw ((Throwable)new IllegalArgumentException(localStringBuilder.toString().toString()));
  }
  
  public final long d()
  {
    int j = this.b;
    this.b = (j + 8);
    int i;
    if ((j >= 0) && (j <= this.a - 7)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return ByteSubArrayKt.c(this.c, this.d + j);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Index ");
    localStringBuilder.append(j);
    localStringBuilder.append(" should be between 0 and ");
    localStringBuilder.append(this.a - 7);
    throw ((Throwable)new IllegalArgumentException(localStringBuilder.toString().toString()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.internal.ByteSubArray
 * JD-Core Version:    0.7.0.1
 */