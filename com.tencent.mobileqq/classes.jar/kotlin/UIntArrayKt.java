package kotlin;

import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"UIntArray", "Lkotlin/UIntArray;", "size", "", "init", "Lkotlin/Function1;", "Lkotlin/UInt;", "(ILkotlin/jvm/functions/Function1;)[I", "uintArrayOf", "elements", "uintArrayOf--ajY-9A", "([I)[I", "kotlin-stdlib"}, k=2, mv={1, 1, 16})
public final class UIntArrayKt
{
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int[] UIntArray(int paramInt, Function1<? super Integer, UInt> paramFunction1)
  {
    int[] arrayOfInt = new int[paramInt];
    int i = 0;
    while (i < paramInt)
    {
      arrayOfInt[i] = ((UInt)paramFunction1.invoke(Integer.valueOf(i))).unbox-impl();
      i += 1;
    }
    return UIntArray.constructor-impl(arrayOfInt);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int[] uintArrayOf--ajY-9A(int... paramVarArgs)
  {
    return paramVarArgs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.UIntArrayKt
 * JD-Core Version:    0.7.0.1
 */