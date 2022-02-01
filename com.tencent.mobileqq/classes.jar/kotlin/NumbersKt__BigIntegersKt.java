package kotlin;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"and", "Ljava/math/BigInteger;", "other", "dec", "div", "inc", "inv", "minus", "or", "plus", "rem", "shl", "n", "", "shr", "times", "toBigDecimal", "Ljava/math/BigDecimal;", "scale", "mathContext", "Ljava/math/MathContext;", "toBigInteger", "", "unaryMinus", "xor", "kotlin-stdlib"}, k=5, mv={1, 1, 16}, xi=1, xs="kotlin/NumbersKt")
class NumbersKt__BigIntegersKt
  extends NumbersKt__BigDecimalsKt
{
  @SinceKotlin(version="1.2")
  @InlineOnly
  private static final BigInteger and(@NotNull BigInteger paramBigInteger1, BigInteger paramBigInteger2)
  {
    paramBigInteger1 = paramBigInteger1.and(paramBigInteger2);
    Intrinsics.checkExpressionValueIsNotNull(paramBigInteger1, "this.and(other)");
    return paramBigInteger1;
  }
  
  @SinceKotlin(version="1.2")
  @InlineOnly
  private static final BigInteger dec(@NotNull BigInteger paramBigInteger)
  {
    Intrinsics.checkParameterIsNotNull(paramBigInteger, "$this$dec");
    paramBigInteger = paramBigInteger.subtract(BigInteger.ONE);
    Intrinsics.checkExpressionValueIsNotNull(paramBigInteger, "this.subtract(BigInteger.ONE)");
    return paramBigInteger;
  }
  
  @InlineOnly
  private static final BigInteger div(@NotNull BigInteger paramBigInteger1, BigInteger paramBigInteger2)
  {
    Intrinsics.checkParameterIsNotNull(paramBigInteger1, "$this$div");
    paramBigInteger1 = paramBigInteger1.divide(paramBigInteger2);
    Intrinsics.checkExpressionValueIsNotNull(paramBigInteger1, "this.divide(other)");
    return paramBigInteger1;
  }
  
  @SinceKotlin(version="1.2")
  @InlineOnly
  private static final BigInteger inc(@NotNull BigInteger paramBigInteger)
  {
    Intrinsics.checkParameterIsNotNull(paramBigInteger, "$this$inc");
    paramBigInteger = paramBigInteger.add(BigInteger.ONE);
    Intrinsics.checkExpressionValueIsNotNull(paramBigInteger, "this.add(BigInteger.ONE)");
    return paramBigInteger;
  }
  
  @SinceKotlin(version="1.2")
  @InlineOnly
  private static final BigInteger inv(@NotNull BigInteger paramBigInteger)
  {
    paramBigInteger = paramBigInteger.not();
    Intrinsics.checkExpressionValueIsNotNull(paramBigInteger, "this.not()");
    return paramBigInteger;
  }
  
  @InlineOnly
  private static final BigInteger minus(@NotNull BigInteger paramBigInteger1, BigInteger paramBigInteger2)
  {
    Intrinsics.checkParameterIsNotNull(paramBigInteger1, "$this$minus");
    paramBigInteger1 = paramBigInteger1.subtract(paramBigInteger2);
    Intrinsics.checkExpressionValueIsNotNull(paramBigInteger1, "this.subtract(other)");
    return paramBigInteger1;
  }
  
  @SinceKotlin(version="1.2")
  @InlineOnly
  private static final BigInteger or(@NotNull BigInteger paramBigInteger1, BigInteger paramBigInteger2)
  {
    paramBigInteger1 = paramBigInteger1.or(paramBigInteger2);
    Intrinsics.checkExpressionValueIsNotNull(paramBigInteger1, "this.or(other)");
    return paramBigInteger1;
  }
  
  @InlineOnly
  private static final BigInteger plus(@NotNull BigInteger paramBigInteger1, BigInteger paramBigInteger2)
  {
    Intrinsics.checkParameterIsNotNull(paramBigInteger1, "$this$plus");
    paramBigInteger1 = paramBigInteger1.add(paramBigInteger2);
    Intrinsics.checkExpressionValueIsNotNull(paramBigInteger1, "this.add(other)");
    return paramBigInteger1;
  }
  
  @SinceKotlin(version="1.1")
  @InlineOnly
  private static final BigInteger rem(@NotNull BigInteger paramBigInteger1, BigInteger paramBigInteger2)
  {
    Intrinsics.checkParameterIsNotNull(paramBigInteger1, "$this$rem");
    paramBigInteger1 = paramBigInteger1.remainder(paramBigInteger2);
    Intrinsics.checkExpressionValueIsNotNull(paramBigInteger1, "this.remainder(other)");
    return paramBigInteger1;
  }
  
  @SinceKotlin(version="1.2")
  @InlineOnly
  private static final BigInteger shl(@NotNull BigInteger paramBigInteger, int paramInt)
  {
    paramBigInteger = paramBigInteger.shiftLeft(paramInt);
    Intrinsics.checkExpressionValueIsNotNull(paramBigInteger, "this.shiftLeft(n)");
    return paramBigInteger;
  }
  
  @SinceKotlin(version="1.2")
  @InlineOnly
  private static final BigInteger shr(@NotNull BigInteger paramBigInteger, int paramInt)
  {
    paramBigInteger = paramBigInteger.shiftRight(paramInt);
    Intrinsics.checkExpressionValueIsNotNull(paramBigInteger, "this.shiftRight(n)");
    return paramBigInteger;
  }
  
  @InlineOnly
  private static final BigInteger times(@NotNull BigInteger paramBigInteger1, BigInteger paramBigInteger2)
  {
    Intrinsics.checkParameterIsNotNull(paramBigInteger1, "$this$times");
    paramBigInteger1 = paramBigInteger1.multiply(paramBigInteger2);
    Intrinsics.checkExpressionValueIsNotNull(paramBigInteger1, "this.multiply(other)");
    return paramBigInteger1;
  }
  
  @SinceKotlin(version="1.2")
  @InlineOnly
  private static final BigDecimal toBigDecimal(@NotNull BigInteger paramBigInteger)
  {
    return new BigDecimal(paramBigInteger);
  }
  
  @SinceKotlin(version="1.2")
  @InlineOnly
  private static final BigDecimal toBigDecimal(@NotNull BigInteger paramBigInteger, int paramInt, MathContext paramMathContext)
  {
    return new BigDecimal(paramBigInteger, paramInt, paramMathContext);
  }
  
  @SinceKotlin(version="1.2")
  @InlineOnly
  private static final BigInteger toBigInteger(int paramInt)
  {
    BigInteger localBigInteger = BigInteger.valueOf(paramInt);
    Intrinsics.checkExpressionValueIsNotNull(localBigInteger, "BigInteger.valueOf(this.toLong())");
    return localBigInteger;
  }
  
  @SinceKotlin(version="1.2")
  @InlineOnly
  private static final BigInteger toBigInteger(long paramLong)
  {
    BigInteger localBigInteger = BigInteger.valueOf(paramLong);
    Intrinsics.checkExpressionValueIsNotNull(localBigInteger, "BigInteger.valueOf(this)");
    return localBigInteger;
  }
  
  @InlineOnly
  private static final BigInteger unaryMinus(@NotNull BigInteger paramBigInteger)
  {
    Intrinsics.checkParameterIsNotNull(paramBigInteger, "$this$unaryMinus");
    paramBigInteger = paramBigInteger.negate();
    Intrinsics.checkExpressionValueIsNotNull(paramBigInteger, "this.negate()");
    return paramBigInteger;
  }
  
  @SinceKotlin(version="1.2")
  @InlineOnly
  private static final BigInteger xor(@NotNull BigInteger paramBigInteger1, BigInteger paramBigInteger2)
  {
    paramBigInteger1 = paramBigInteger1.xor(paramBigInteger2);
    Intrinsics.checkExpressionValueIsNotNull(paramBigInteger1, "this.xor(other)");
    return paramBigInteger1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.NumbersKt__BigIntegersKt
 * JD-Core Version:    0.7.0.1
 */