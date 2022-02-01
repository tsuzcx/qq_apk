package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

class Flags$EnumLiteFlagField<E extends Internal.EnumLite>
  extends Flags.FlagField<E>
{
  private final E[] values;
  
  public Flags$EnumLiteFlagField(int paramInt, E[] paramArrayOfE)
  {
    super(paramInt, bitWidth(paramArrayOfE), null);
    this.values = paramArrayOfE;
  }
  
  private static <E> int bitWidth(@NotNull E[] paramArrayOfE)
  {
    if (paramArrayOfE == null) {
      $$$reportNull$$$0(0);
    }
    int j = paramArrayOfE.length - 1;
    if (j == 0) {
      return 1;
    }
    int i = 31;
    while (i >= 0)
    {
      if ((1 << i & j) != 0) {
        return i + 1;
      }
      i -= 1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Empty enum: ");
    localStringBuilder.append(paramArrayOfE.getClass());
    paramArrayOfE = new IllegalStateException(localStringBuilder.toString());
    for (;;)
    {
      throw paramArrayOfE;
    }
  }
  
  @Nullable
  public E get(int paramInt)
  {
    int j = this.bitWidth;
    int k = this.offset;
    int m = this.offset;
    Internal.EnumLite[] arrayOfEnumLite = this.values;
    int n = arrayOfEnumLite.length;
    int i = 0;
    while (i < n)
    {
      Internal.EnumLite localEnumLite = arrayOfEnumLite[i];
      if (localEnumLite.getNumber() == (paramInt & (1 << j) - 1 << k) >> m) {
        return localEnumLite;
      }
      i += 1;
    }
    return null;
  }
  
  public int toFlags(E paramE)
  {
    return paramE.getNumber() << this.offset;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.EnumLiteFlagField
 * JD-Core Version:    0.7.0.1
 */