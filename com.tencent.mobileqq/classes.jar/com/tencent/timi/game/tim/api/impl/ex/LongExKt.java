package com.tencent.timi.game.tim.api.impl.ex;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"ulongToString", "", "v", "", "base", "", "ulongString", "timi-game-impl_release"}, k=2, mv={1, 1, 16})
public final class LongExKt
{
  @NotNull
  public static final String a(long paramLong)
  {
    return b(paramLong);
  }
  
  @NotNull
  public static final String a(long paramLong, int paramInt)
  {
    if (paramLong >= 0L)
    {
      localObject = Long.toString(paramLong, CharsKt.checkRadix(paramInt));
      Intrinsics.checkExpressionValueIsNotNull(localObject, "java.lang.Long.toString(this, checkRadix(radix))");
      return localObject;
    }
    long l4 = paramInt;
    long l2 = (paramLong >>> 1) / l4 << 1;
    long l3 = paramLong - l2 * l4;
    long l1 = l2;
    paramLong = l3;
    if (l3 >= l4)
    {
      paramLong = l3 - l4;
      l1 = l2 + 1L;
    }
    Object localObject = new StringBuilder();
    String str = Long.toString(l1, CharsKt.checkRadix(paramInt));
    Intrinsics.checkExpressionValueIsNotNull(str, "java.lang.Long.toString(this, checkRadix(radix))");
    ((StringBuilder)localObject).append(str);
    str = Long.toString(paramLong, CharsKt.checkRadix(paramInt));
    Intrinsics.checkExpressionValueIsNotNull(str, "java.lang.Long.toString(this, checkRadix(radix))");
    ((StringBuilder)localObject).append(str);
    return ((StringBuilder)localObject).toString();
  }
  
  @NotNull
  public static final String b(long paramLong)
  {
    return a(paramLong, 10);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.tim.api.impl.ex.LongExKt
 * JD-Core Version:    0.7.0.1
 */