package kotlin;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"dec", "Ljava/math/BigDecimal;", "div", "other", "inc", "minus", "mod", "plus", "rem", "times", "toBigDecimal", "", "mathContext", "Ljava/math/MathContext;", "", "", "", "unaryMinus", "kotlin-stdlib"}, k=5, mv={1, 1, 16}, xi=1, xs="kotlin/NumbersKt")
class NumbersKt__BigDecimalsKt
{
  @SinceKotlin(version="1.2")
  @InlineOnly
  private static final BigDecimal dec(@NotNull BigDecimal paramBigDecimal)
  {
    Intrinsics.checkParameterIsNotNull(paramBigDecimal, "$this$dec");
    paramBigDecimal = paramBigDecimal.subtract(BigDecimal.ONE);
    Intrinsics.checkExpressionValueIsNotNull(paramBigDecimal, "this.subtract(BigDecimal.ONE)");
    return paramBigDecimal;
  }
  
  @InlineOnly
  private static final BigDecimal div(@NotNull BigDecimal paramBigDecimal1, BigDecimal paramBigDecimal2)
  {
    Intrinsics.checkParameterIsNotNull(paramBigDecimal1, "$this$div");
    paramBigDecimal1 = paramBigDecimal1.divide(paramBigDecimal2, RoundingMode.HALF_EVEN);
    Intrinsics.checkExpressionValueIsNotNull(paramBigDecimal1, "this.divide(other, RoundingMode.HALF_EVEN)");
    return paramBigDecimal1;
  }
  
  @SinceKotlin(version="1.2")
  @InlineOnly
  private static final BigDecimal inc(@NotNull BigDecimal paramBigDecimal)
  {
    Intrinsics.checkParameterIsNotNull(paramBigDecimal, "$this$inc");
    paramBigDecimal = paramBigDecimal.add(BigDecimal.ONE);
    Intrinsics.checkExpressionValueIsNotNull(paramBigDecimal, "this.add(BigDecimal.ONE)");
    return paramBigDecimal;
  }
  
  @InlineOnly
  private static final BigDecimal minus(@NotNull BigDecimal paramBigDecimal1, BigDecimal paramBigDecimal2)
  {
    Intrinsics.checkParameterIsNotNull(paramBigDecimal1, "$this$minus");
    paramBigDecimal1 = paramBigDecimal1.subtract(paramBigDecimal2);
    Intrinsics.checkExpressionValueIsNotNull(paramBigDecimal1, "this.subtract(other)");
    return paramBigDecimal1;
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="Use rem(other) instead", replaceWith=@ReplaceWith(expression="rem(other)", imports={}))
  @InlineOnly
  private static final BigDecimal mod(@NotNull BigDecimal paramBigDecimal1, BigDecimal paramBigDecimal2)
  {
    Intrinsics.checkParameterIsNotNull(paramBigDecimal1, "$this$mod");
    paramBigDecimal1 = paramBigDecimal1.remainder(paramBigDecimal2);
    Intrinsics.checkExpressionValueIsNotNull(paramBigDecimal1, "this.remainder(other)");
    return paramBigDecimal1;
  }
  
  @InlineOnly
  private static final BigDecimal plus(@NotNull BigDecimal paramBigDecimal1, BigDecimal paramBigDecimal2)
  {
    Intrinsics.checkParameterIsNotNull(paramBigDecimal1, "$this$plus");
    paramBigDecimal1 = paramBigDecimal1.add(paramBigDecimal2);
    Intrinsics.checkExpressionValueIsNotNull(paramBigDecimal1, "this.add(other)");
    return paramBigDecimal1;
  }
  
  @InlineOnly
  private static final BigDecimal rem(@NotNull BigDecimal paramBigDecimal1, BigDecimal paramBigDecimal2)
  {
    Intrinsics.checkParameterIsNotNull(paramBigDecimal1, "$this$rem");
    paramBigDecimal1 = paramBigDecimal1.remainder(paramBigDecimal2);
    Intrinsics.checkExpressionValueIsNotNull(paramBigDecimal1, "this.remainder(other)");
    return paramBigDecimal1;
  }
  
  @InlineOnly
  private static final BigDecimal times(@NotNull BigDecimal paramBigDecimal1, BigDecimal paramBigDecimal2)
  {
    Intrinsics.checkParameterIsNotNull(paramBigDecimal1, "$this$times");
    paramBigDecimal1 = paramBigDecimal1.multiply(paramBigDecimal2);
    Intrinsics.checkExpressionValueIsNotNull(paramBigDecimal1, "this.multiply(other)");
    return paramBigDecimal1;
  }
  
  @SinceKotlin(version="1.2")
  @InlineOnly
  private static final BigDecimal toBigDecimal(double paramDouble)
  {
    return new BigDecimal(String.valueOf(paramDouble));
  }
  
  @SinceKotlin(version="1.2")
  @InlineOnly
  private static final BigDecimal toBigDecimal(double paramDouble, MathContext paramMathContext)
  {
    return new BigDecimal(String.valueOf(paramDouble), paramMathContext);
  }
  
  @SinceKotlin(version="1.2")
  @InlineOnly
  private static final BigDecimal toBigDecimal(float paramFloat)
  {
    return new BigDecimal(String.valueOf(paramFloat));
  }
  
  @SinceKotlin(version="1.2")
  @InlineOnly
  private static final BigDecimal toBigDecimal(float paramFloat, MathContext paramMathContext)
  {
    return new BigDecimal(String.valueOf(paramFloat), paramMathContext);
  }
  
  @SinceKotlin(version="1.2")
  @InlineOnly
  private static final BigDecimal toBigDecimal(int paramInt)
  {
    BigDecimal localBigDecimal = BigDecimal.valueOf(paramInt);
    Intrinsics.checkExpressionValueIsNotNull(localBigDecimal, "BigDecimal.valueOf(this.toLong())");
    return localBigDecimal;
  }
  
  @SinceKotlin(version="1.2")
  @InlineOnly
  private static final BigDecimal toBigDecimal(int paramInt, MathContext paramMathContext)
  {
    return new BigDecimal(paramInt, paramMathContext);
  }
  
  @SinceKotlin(version="1.2")
  @InlineOnly
  private static final BigDecimal toBigDecimal(long paramLong)
  {
    BigDecimal localBigDecimal = BigDecimal.valueOf(paramLong);
    Intrinsics.checkExpressionValueIsNotNull(localBigDecimal, "BigDecimal.valueOf(this)");
    return localBigDecimal;
  }
  
  @SinceKotlin(version="1.2")
  @InlineOnly
  private static final BigDecimal toBigDecimal(long paramLong, MathContext paramMathContext)
  {
    return new BigDecimal(paramLong, paramMathContext);
  }
  
  @InlineOnly
  private static final BigDecimal unaryMinus(@NotNull BigDecimal paramBigDecimal)
  {
    Intrinsics.checkParameterIsNotNull(paramBigDecimal, "$this$unaryMinus");
    paramBigDecimal = paramBigDecimal.negate();
    Intrinsics.checkExpressionValueIsNotNull(paramBigDecimal, "this.negate()");
    return paramBigDecimal;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.NumbersKt__BigDecimalsKt
 * JD-Core Version:    0.7.0.1
 */