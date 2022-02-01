package org.apache.commons.lang.math;

import java.math.BigInteger;
import org.apache.commons.lang.text.StrBuilder;

public final class Fraction
  extends Number
  implements Comparable
{
  public static final Fraction FOUR_FIFTHS = new Fraction(4, 5);
  public static final Fraction ONE;
  public static final Fraction ONE_FIFTH;
  public static final Fraction ONE_HALF;
  public static final Fraction ONE_QUARTER;
  public static final Fraction ONE_THIRD;
  public static final Fraction THREE_FIFTHS;
  public static final Fraction THREE_QUARTERS;
  public static final Fraction TWO_FIFTHS;
  public static final Fraction TWO_QUARTERS;
  public static final Fraction TWO_THIRDS;
  public static final Fraction ZERO = new Fraction(0, 1);
  private static final long serialVersionUID = 65382027393090L;
  private final int denominator;
  private transient int hashCode = 0;
  private final int numerator;
  private transient String toProperString = null;
  private transient String toString = null;
  
  static
  {
    ONE = new Fraction(1, 1);
    ONE_HALF = new Fraction(1, 2);
    ONE_THIRD = new Fraction(1, 3);
    TWO_THIRDS = new Fraction(2, 3);
    ONE_QUARTER = new Fraction(1, 4);
    TWO_QUARTERS = new Fraction(2, 4);
    THREE_QUARTERS = new Fraction(3, 4);
    ONE_FIFTH = new Fraction(1, 5);
    TWO_FIFTHS = new Fraction(2, 5);
    THREE_FIFTHS = new Fraction(3, 5);
  }
  
  private Fraction(int paramInt1, int paramInt2)
  {
    this.numerator = paramInt1;
    this.denominator = paramInt2;
  }
  
  private static int addAndCheck(int paramInt1, int paramInt2)
  {
    long l = paramInt1 + paramInt2;
    if ((l >= -2147483648L) && (l <= 2147483647L)) {
      return (int)l;
    }
    throw new ArithmeticException("overflow: add");
  }
  
  private Fraction addSub(Fraction paramFraction, boolean paramBoolean)
  {
    if (paramFraction != null)
    {
      if (this.numerator == 0)
      {
        if (paramBoolean) {
          return paramFraction;
        }
        return paramFraction.negate();
      }
      if (paramFraction.numerator == 0) {
        return this;
      }
      int j = greatestCommonDivisor(this.denominator, paramFraction.denominator);
      if (j == 1)
      {
        i = mulAndCheck(this.numerator, paramFraction.denominator);
        j = mulAndCheck(paramFraction.numerator, this.denominator);
        if (paramBoolean) {
          i = addAndCheck(i, j);
        } else {
          i = subAndCheck(i, j);
        }
        return new Fraction(i, mulPosAndCheck(this.denominator, paramFraction.denominator));
      }
      BigInteger localBigInteger1 = BigInteger.valueOf(this.numerator).multiply(BigInteger.valueOf(paramFraction.denominator / j));
      BigInteger localBigInteger2 = BigInteger.valueOf(paramFraction.numerator).multiply(BigInteger.valueOf(this.denominator / j));
      if (paramBoolean) {
        localBigInteger1 = localBigInteger1.add(localBigInteger2);
      } else {
        localBigInteger1 = localBigInteger1.subtract(localBigInteger2);
      }
      int i = localBigInteger1.mod(BigInteger.valueOf(j)).intValue();
      if (i == 0) {
        i = j;
      } else {
        i = greatestCommonDivisor(i, j);
      }
      localBigInteger1 = localBigInteger1.divide(BigInteger.valueOf(i));
      if (localBigInteger1.bitLength() <= 31) {
        return new Fraction(localBigInteger1.intValue(), mulPosAndCheck(this.denominator / j, paramFraction.denominator / i));
      }
      throw new ArithmeticException("overflow: numerator too large after multiply");
    }
    throw new IllegalArgumentException("The fraction must not be null");
  }
  
  public static Fraction getFraction(double paramDouble)
  {
    int k;
    if (paramDouble < 0.0D) {
      k = -1;
    } else {
      k = 1;
    }
    paramDouble = Math.abs(paramDouble);
    if ((paramDouble <= 2147483647.0D) && (!Double.isNaN(paramDouble)))
    {
      int i5 = (int)paramDouble;
      double d1 = i5;
      Double.isNaN(d1);
      double d5 = paramDouble - d1;
      int n = (int)d5;
      d1 = 1.0D;
      paramDouble = n;
      Double.isNaN(paramDouble);
      paramDouble = d5 - paramDouble;
      double d2 = 1.7976931348623157E+308D;
      int i = 1;
      int i2 = 0;
      int j = 0;
      int i1 = 1;
      int m = 1;
      for (;;)
      {
        double d3 = d2;
        d2 = d1;
        int i4 = (int)(d2 / paramDouble);
        double d6 = i4;
        Double.isNaN(d6);
        int i3 = n * i + i2;
        i1 = n * j + i1;
        d1 = i3;
        double d4 = i1;
        Double.isNaN(d1);
        Double.isNaN(d4);
        d4 = Math.abs(d5 - d1 / d4);
        m += 1;
        if ((d3 <= d4) || (i1 > 10000) || (i1 <= 0) || (m >= 25)) {
          break;
        }
        n = i4;
        i2 = i;
        i = i3;
        i3 = j;
        d1 = paramDouble;
        paramDouble = d2 - d6 * paramDouble;
        d2 = d4;
        j = i1;
        i1 = i3;
      }
      if (m != 25) {
        return getReducedFraction((i + i5 * j) * k, j);
      }
      throw new ArithmeticException("Unable to convert double to fraction");
    }
    ArithmeticException localArithmeticException = new ArithmeticException("The value must not be greater than Integer.MAX_VALUE or NaN");
    for (;;)
    {
      throw localArithmeticException;
    }
  }
  
  public static Fraction getFraction(int paramInt1, int paramInt2)
  {
    if (paramInt2 != 0)
    {
      int i = paramInt1;
      int j = paramInt2;
      if (paramInt2 < 0) {
        if ((paramInt1 != -2147483648) && (paramInt2 != -2147483648))
        {
          i = -paramInt1;
          j = -paramInt2;
        }
        else
        {
          throw new ArithmeticException("overflow: can't negate");
        }
      }
      return new Fraction(i, j);
    }
    throw new ArithmeticException("The denominator must not be zero");
  }
  
  public static Fraction getFraction(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 != 0)
    {
      if (paramInt3 >= 0)
      {
        if (paramInt2 >= 0)
        {
          long l;
          if (paramInt1 < 0) {
            l = paramInt1 * paramInt3 - paramInt2;
          } else {
            l = paramInt1 * paramInt3 + paramInt2;
          }
          if ((l >= -2147483648L) && (l <= 2147483647L)) {
            return new Fraction((int)l, paramInt3);
          }
          throw new ArithmeticException("Numerator too large to represent as an Integer.");
        }
        throw new ArithmeticException("The numerator must not be negative");
      }
      throw new ArithmeticException("The denominator must not be negative");
    }
    throw new ArithmeticException("The denominator must not be zero");
  }
  
  public static Fraction getFraction(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.indexOf('.') >= 0) {
        return getFraction(Double.parseDouble(paramString));
      }
      int j = paramString.indexOf(' ');
      if (j > 0)
      {
        i = Integer.parseInt(paramString.substring(0, j));
        paramString = paramString.substring(j + 1);
        j = paramString.indexOf('/');
        if (j >= 0) {
          return getFraction(i, Integer.parseInt(paramString.substring(0, j)), Integer.parseInt(paramString.substring(j + 1)));
        }
        throw new NumberFormatException("The fraction could not be parsed as the format X Y/Z");
      }
      int i = paramString.indexOf('/');
      if (i < 0) {
        return getFraction(Integer.parseInt(paramString), 1);
      }
      return getFraction(Integer.parseInt(paramString.substring(0, i)), Integer.parseInt(paramString.substring(i + 1)));
    }
    throw new IllegalArgumentException("The string must not be null");
  }
  
  public static Fraction getReducedFraction(int paramInt1, int paramInt2)
  {
    if (paramInt2 != 0)
    {
      if (paramInt1 == 0) {
        return ZERO;
      }
      int j = paramInt1;
      int i = paramInt2;
      if (paramInt2 == -2147483648)
      {
        j = paramInt1;
        i = paramInt2;
        if ((paramInt1 & 0x1) == 0)
        {
          j = paramInt1 / 2;
          i = paramInt2 / 2;
        }
      }
      paramInt1 = j;
      paramInt2 = i;
      if (i < 0) {
        if ((j != -2147483648) && (i != -2147483648))
        {
          paramInt1 = -j;
          paramInt2 = -i;
        }
        else
        {
          throw new ArithmeticException("overflow: can't negate");
        }
      }
      i = greatestCommonDivisor(paramInt1, paramInt2);
      return new Fraction(paramInt1 / i, paramInt2 / i);
    }
    throw new ArithmeticException("The denominator must not be zero");
  }
  
  private static int greatestCommonDivisor(int paramInt1, int paramInt2)
  {
    if (Math.abs(paramInt1) > 1)
    {
      if (Math.abs(paramInt2) <= 1) {
        return 1;
      }
      int i = paramInt1;
      if (paramInt1 > 0) {
        i = -paramInt1;
      }
      paramInt1 = paramInt2;
      if (paramInt2 > 0) {
        paramInt1 = -paramInt2;
      }
      int j = 0;
      paramInt2 = paramInt1;
      for (;;)
      {
        paramInt1 = i & 0x1;
        if ((paramInt1 != 0) || ((paramInt2 & 0x1) != 0) || (j >= 31)) {
          break;
        }
        i /= 2;
        paramInt2 /= 2;
        j += 1;
      }
      if (j != 31)
      {
        if (paramInt1 == 1) {
          paramInt1 = paramInt2;
        } else {
          paramInt1 = -(i / 2);
        }
        int k;
        int m;
        do
        {
          while ((paramInt1 & 0x1) == 0) {
            paramInt1 /= 2;
          }
          if (paramInt1 > 0)
          {
            k = -paramInt1;
          }
          else
          {
            paramInt2 = paramInt1;
            k = i;
          }
          m = (paramInt2 - k) / 2;
          paramInt1 = m;
          i = k;
        } while (m != 0);
        return -k * (1 << j);
      }
      throw new ArithmeticException("overflow: gcd is 2^31");
    }
    return 1;
  }
  
  private static int mulAndCheck(int paramInt1, int paramInt2)
  {
    long l = paramInt1 * paramInt2;
    if ((l >= -2147483648L) && (l <= 2147483647L)) {
      return (int)l;
    }
    throw new ArithmeticException("overflow: mul");
  }
  
  private static int mulPosAndCheck(int paramInt1, int paramInt2)
  {
    long l = paramInt1 * paramInt2;
    if (l <= 2147483647L) {
      return (int)l;
    }
    throw new ArithmeticException("overflow: mulPos");
  }
  
  private static int subAndCheck(int paramInt1, int paramInt2)
  {
    long l = paramInt1 - paramInt2;
    if ((l >= -2147483648L) && (l <= 2147483647L)) {
      return (int)l;
    }
    throw new ArithmeticException("overflow: add");
  }
  
  public Fraction abs()
  {
    if (this.numerator >= 0) {
      return this;
    }
    return negate();
  }
  
  public Fraction add(Fraction paramFraction)
  {
    return addSub(paramFraction, true);
  }
  
  public int compareTo(Object paramObject)
  {
    paramObject = (Fraction)paramObject;
    if (this == paramObject) {
      return 0;
    }
    if ((this.numerator == paramObject.numerator) && (this.denominator == paramObject.denominator)) {
      return 0;
    }
    long l1 = this.numerator * paramObject.denominator;
    long l2 = paramObject.numerator * this.denominator;
    if (l1 == l2) {
      return 0;
    }
    if (l1 < l2) {
      return -1;
    }
    return 1;
  }
  
  public Fraction divideBy(Fraction paramFraction)
  {
    if (paramFraction != null)
    {
      if (paramFraction.numerator != 0) {
        return multiplyBy(paramFraction.invert());
      }
      throw new ArithmeticException("The fraction to divide by must not be zero");
    }
    throw new IllegalArgumentException("The fraction must not be null");
  }
  
  public double doubleValue()
  {
    double d1 = this.numerator;
    double d2 = this.denominator;
    Double.isNaN(d1);
    Double.isNaN(d2);
    return d1 / d2;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof Fraction)) {
      return false;
    }
    paramObject = (Fraction)paramObject;
    return (getNumerator() == paramObject.getNumerator()) && (getDenominator() == paramObject.getDenominator());
  }
  
  public float floatValue()
  {
    return this.numerator / this.denominator;
  }
  
  public int getDenominator()
  {
    return this.denominator;
  }
  
  public int getNumerator()
  {
    return this.numerator;
  }
  
  public int getProperNumerator()
  {
    return Math.abs(this.numerator % this.denominator);
  }
  
  public int getProperWhole()
  {
    return this.numerator / this.denominator;
  }
  
  public int hashCode()
  {
    if (this.hashCode == 0) {
      this.hashCode = ((getNumerator() + 629) * 37 + getDenominator());
    }
    return this.hashCode;
  }
  
  public int intValue()
  {
    return this.numerator / this.denominator;
  }
  
  public Fraction invert()
  {
    int i = this.numerator;
    if (i != 0)
    {
      if (i != -2147483648)
      {
        if (i < 0) {
          return new Fraction(-this.denominator, -i);
        }
        return new Fraction(this.denominator, i);
      }
      throw new ArithmeticException("overflow: can't negate numerator");
    }
    throw new ArithmeticException("Unable to invert zero.");
  }
  
  public long longValue()
  {
    return this.numerator / this.denominator;
  }
  
  public Fraction multiplyBy(Fraction paramFraction)
  {
    if (paramFraction != null)
    {
      int i = this.numerator;
      if ((i != 0) && (paramFraction.numerator != 0))
      {
        i = greatestCommonDivisor(i, paramFraction.denominator);
        int j = greatestCommonDivisor(paramFraction.numerator, this.denominator);
        return getReducedFraction(mulAndCheck(this.numerator / i, paramFraction.numerator / j), mulPosAndCheck(this.denominator / j, paramFraction.denominator / i));
      }
      return ZERO;
    }
    throw new IllegalArgumentException("The fraction must not be null");
  }
  
  public Fraction negate()
  {
    int i = this.numerator;
    if (i != -2147483648) {
      return new Fraction(-i, this.denominator);
    }
    throw new ArithmeticException("overflow: too large to negate");
  }
  
  public Fraction pow(int paramInt)
  {
    if (paramInt == 1) {
      return this;
    }
    if (paramInt == 0) {
      return ONE;
    }
    if (paramInt < 0)
    {
      if (paramInt == -2147483648) {
        return invert().pow(2).pow(-(paramInt / 2));
      }
      return invert().pow(-paramInt);
    }
    Fraction localFraction = multiplyBy(this);
    if (paramInt % 2 == 0) {
      return localFraction.pow(paramInt / 2);
    }
    paramInt /= 2;
    try
    {
      localFraction = localFraction.pow(paramInt);
      return localFraction.multiplyBy(this);
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public Fraction reduce()
  {
    int i = this.numerator;
    if (i == 0)
    {
      if (equals(ZERO)) {
        return this;
      }
      return ZERO;
    }
    i = greatestCommonDivisor(Math.abs(i), this.denominator);
    if (i == 1) {
      return this;
    }
    return getFraction(this.numerator / i, this.denominator / i);
  }
  
  public Fraction subtract(Fraction paramFraction)
  {
    return addSub(paramFraction, false);
  }
  
  public String toProperString()
  {
    if (this.toProperString == null)
    {
      int j = this.numerator;
      if (j == 0)
      {
        this.toProperString = "0";
      }
      else
      {
        int i = this.denominator;
        if (j == i)
        {
          this.toProperString = "1";
        }
        else if (j == i * -1)
        {
          this.toProperString = "-1";
        }
        else
        {
          i = j;
          if (j > 0) {
            i = -j;
          }
          if (i < -this.denominator)
          {
            i = getProperNumerator();
            if (i == 0) {
              this.toProperString = Integer.toString(getProperWhole());
            } else {
              this.toProperString = new StrBuilder(32).append(getProperWhole()).append(' ').append(i).append('/').append(getDenominator()).toString();
            }
          }
          else
          {
            this.toProperString = new StrBuilder(32).append(getNumerator()).append('/').append(getDenominator()).toString();
          }
        }
      }
    }
    return this.toProperString;
  }
  
  public String toString()
  {
    if (this.toString == null) {
      this.toString = new StrBuilder(32).append(getNumerator()).append('/').append(getDenominator()).toString();
    }
    return this.toString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.apache.commons.lang.math.Fraction
 * JD-Core Version:    0.7.0.1
 */