package kotlin;

import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"UShortArray", "Lkotlin/UShortArray;", "size", "", "init", "Lkotlin/Function1;", "Lkotlin/UShort;", "(ILkotlin/jvm/functions/Function1;)[S", "ushortArrayOf", "elements", "ushortArrayOf-rL5Bavg", "([S)[S", "kotlin-stdlib"}, k=2, mv={1, 1, 16})
public final class UShortArrayKt
{
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final short[] UShortArray(int paramInt, Function1<? super Integer, UShort> paramFunction1)
  {
    short[] arrayOfShort = new short[paramInt];
    int i = 0;
    while (i < paramInt)
    {
      arrayOfShort[i] = ((UShort)paramFunction1.invoke(Integer.valueOf(i))).unbox-impl();
      i += 1;
    }
    return UShortArray.constructor-impl(arrayOfShort);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final short[] ushortArrayOf-rL5Bavg(short... paramVarArgs)
  {
    return paramVarArgs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.UShortArrayKt
 * JD-Core Version:    0.7.0.1
 */