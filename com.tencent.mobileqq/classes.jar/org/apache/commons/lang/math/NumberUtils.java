package org.apache.commons.lang.math;

import java.math.BigDecimal;
import java.math.BigInteger;
import org.apache.commons.lang.StringUtils;

public class NumberUtils
{
  public static final Byte BYTE_MINUS_ONE;
  public static final Byte BYTE_ONE;
  public static final Byte BYTE_ZERO;
  public static final Double DOUBLE_MINUS_ONE;
  public static final Double DOUBLE_ONE;
  public static final Double DOUBLE_ZERO;
  public static final Float FLOAT_MINUS_ONE = new Float(-1.0F);
  public static final Float FLOAT_ONE;
  public static final Float FLOAT_ZERO;
  public static final Integer INTEGER_MINUS_ONE;
  public static final Integer INTEGER_ONE;
  public static final Integer INTEGER_ZERO;
  public static final Long LONG_MINUS_ONE;
  public static final Long LONG_ONE;
  public static final Long LONG_ZERO = new Long(0L);
  public static final Short SHORT_MINUS_ONE;
  public static final Short SHORT_ONE;
  public static final Short SHORT_ZERO;
  
  static
  {
    LONG_ONE = new Long(1L);
    LONG_MINUS_ONE = new Long(-1L);
    INTEGER_ZERO = new Integer(0);
    INTEGER_ONE = new Integer(1);
    INTEGER_MINUS_ONE = new Integer(-1);
    SHORT_ZERO = new Short((short)0);
    SHORT_ONE = new Short((short)1);
    SHORT_MINUS_ONE = new Short((short)-1);
    BYTE_ZERO = new Byte((byte)0);
    BYTE_ONE = new Byte((byte)1);
    BYTE_MINUS_ONE = new Byte((byte)-1);
    DOUBLE_ZERO = new Double(0.0D);
    DOUBLE_ONE = new Double(1.0D);
    DOUBLE_MINUS_ONE = new Double(-1.0D);
    FLOAT_ZERO = new Float(0.0F);
    FLOAT_ONE = new Float(1.0F);
  }
  
  public static int compare(double paramDouble1, double paramDouble2)
  {
    if (paramDouble1 < paramDouble2) {
      return -1;
    }
    if (paramDouble1 > paramDouble2) {
      return 1;
    }
    long l1 = Double.doubleToLongBits(paramDouble1);
    long l2 = Double.doubleToLongBits(paramDouble2);
    if (l1 == l2) {
      return 0;
    }
    if (l1 < l2) {
      return -1;
    }
    return 1;
  }
  
  public static int compare(float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 < paramFloat2) {
      return -1;
    }
    if (paramFloat1 > paramFloat2) {
      return 1;
    }
    int i = Float.floatToIntBits(paramFloat1);
    int j = Float.floatToIntBits(paramFloat2);
    if (i == j) {
      return 0;
    }
    if (i < j) {
      return -1;
    }
    return 1;
  }
  
  public static BigDecimal createBigDecimal(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    if (!StringUtils.isBlank(paramString)) {
      return new BigDecimal(paramString);
    }
    throw new NumberFormatException("A blank string is not a valid number");
  }
  
  public static BigInteger createBigInteger(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return new BigInteger(paramString);
  }
  
  public static Double createDouble(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return Double.valueOf(paramString);
  }
  
  public static Float createFloat(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return Float.valueOf(paramString);
  }
  
  public static Integer createInteger(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return Integer.decode(paramString);
  }
  
  public static Long createLong(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return Long.valueOf(paramString);
  }
  
  public static Number createNumber(String paramString)
  {
    Object localObject4 = null;
    String str = null;
    if (paramString == null) {
      return null;
    }
    int i;
    int k;
    Object localObject2;
    Object localObject3;
    if (!StringUtils.isBlank(paramString))
    {
      if (paramString.startsWith("--")) {
        return null;
      }
      if ((!paramString.startsWith("0x")) && (!paramString.startsWith("-0x")))
      {
        int j = paramString.length();
        i = 1;
        char c = paramString.charAt(j - 1);
        j = paramString.indexOf('.');
        k = paramString.indexOf('e') + paramString.indexOf('E') + 1;
        if (j > -1)
        {
          if (k > -1)
          {
            if ((k >= j) && (k <= paramString.length()))
            {
              localObject1 = paramString.substring(j + 1, k);
            }
            else
            {
              localObject1 = new StringBuffer();
              ((StringBuffer)localObject1).append(paramString);
              ((StringBuffer)localObject1).append(" is not a valid number.");
              throw new NumberFormatException(((StringBuffer)localObject1).toString());
            }
          }
          else {
            localObject1 = paramString.substring(j + 1);
          }
          localObject2 = paramString.substring(0, j);
          localObject3 = localObject1;
        }
        else
        {
          if (k > -1)
          {
            if (k <= paramString.length())
            {
              localObject1 = paramString.substring(0, k);
            }
            else
            {
              localObject1 = new StringBuffer();
              ((StringBuffer)localObject1).append(paramString);
              ((StringBuffer)localObject1).append(" is not a valid number.");
              throw new NumberFormatException(((StringBuffer)localObject1).toString());
            }
          }
          else {
            localObject1 = paramString;
          }
          localObject3 = null;
          localObject2 = localObject1;
        }
        if ((!Character.isDigit(c)) && (c != '.'))
        {
          localObject1 = str;
          if (k > -1)
          {
            localObject1 = str;
            if (k < paramString.length() - 1) {
              localObject1 = paramString.substring(k + 1, paramString.length() - 1);
            }
          }
          str = paramString.substring(0, paramString.length() - 1);
          if ((isAllZeros((String)localObject2)) && (isAllZeros((String)localObject1))) {
            i = 1;
          } else {
            i = 0;
          }
          if ((c != 'D') && ((c != 'F') && (((c == 'L') || ((c == 'd') || ((c == 'f') || (c == 'l')))) && ((localObject3 != null) || (localObject1 != null) || (((str.charAt(0) != '-') || (!isDigits(str.substring(1)))) && (!isDigits(str))))))) {}
        }
      }
    }
    try
    {
      paramString = createLong(str);
      return paramString;
    }
    catch (NumberFormatException paramString)
    {
      label451:
      break label451;
    }
    return createBigInteger(str);
    Object localObject1 = new StringBuffer();
    ((StringBuffer)localObject1).append(paramString);
    ((StringBuffer)localObject1).append(" is not a valid number.");
    throw new NumberFormatException(((StringBuffer)localObject1).toString());
    label531:
    label674:
    label683:
    try
    {
      localObject1 = createFloat(str);
      if (!((Float)localObject1).isInfinite())
      {
        f = ((Float)localObject1).floatValue();
        if ((f != 0.0F) || (i != 0)) {
          return localObject1;
        }
      }
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      float f;
      label569:
      label579:
      label746:
      break label531;
    }
    try
    {
      localObject1 = createDouble(str);
      if (!((Double)localObject1).isInfinite())
      {
        f = ((Double)localObject1).floatValue();
        if ((f != 0.0D) || (i != 0)) {
          return localObject1;
        }
      }
    }
    catch (NumberFormatException localNumberFormatException2)
    {
      label780:
      break label569;
    }
    try
    {
      localObject1 = createBigDecimal(str);
      return localObject1;
    }
    catch (NumberFormatException localNumberFormatException3)
    {
      break label579;
    }
    localObject1 = new StringBuffer();
    ((StringBuffer)localObject1).append(paramString);
    ((StringBuffer)localObject1).append(" is not a valid number.");
    throw new NumberFormatException(((StringBuffer)localObject1).toString());
    localObject1 = localObject4;
    if (k > -1)
    {
      localObject1 = localObject4;
      if (k < paramString.length() - 1) {
        localObject1 = paramString.substring(k + 1, paramString.length());
      }
    }
    if ((localObject3 == null) && (localObject1 == null)) {}
    try
    {
      localObject1 = createInteger(paramString);
      return localObject1;
    }
    catch (NumberFormatException localNumberFormatException4)
    {
      break label674;
    }
    try
    {
      localObject1 = createLong(paramString);
      return localObject1;
    }
    catch (NumberFormatException localNumberFormatException5)
    {
      break label683;
    }
    return createBigInteger(paramString);
    if ((!isAllZeros((String)localObject2)) || (!isAllZeros((String)localObject1))) {
      i = 0;
    }
    try
    {
      localObject1 = createFloat(paramString);
      if (!((Float)localObject1).isInfinite())
      {
        f = ((Float)localObject1).floatValue();
        if ((f != 0.0F) || (i != 0)) {
          return localObject1;
        }
      }
    }
    catch (NumberFormatException localNumberFormatException6)
    {
      break label746;
    }
    try
    {
      localObject1 = createDouble(paramString);
      if (!((Double)localObject1).isInfinite())
      {
        double d = ((Double)localObject1).doubleValue();
        if ((d != 0.0D) || (i != 0)) {
          return localObject1;
        }
      }
    }
    catch (NumberFormatException localNumberFormatException7)
    {
      break label780;
    }
    return createBigDecimal(paramString);
    return createInteger(paramString);
    throw new NumberFormatException("A blank string is not a valid number");
  }
  
  private static boolean isAllZeros(String paramString)
  {
    if (paramString == null) {
      return true;
    }
    int i = paramString.length() - 1;
    while (i >= 0)
    {
      if (paramString.charAt(i) != '0') {
        return false;
      }
      i -= 1;
    }
    return paramString.length() > 0;
  }
  
  public static boolean isDigits(String paramString)
  {
    if (StringUtils.isEmpty(paramString)) {
      return false;
    }
    int i = 0;
    while (i < paramString.length())
    {
      if (!Character.isDigit(paramString.charAt(i))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static boolean isNumber(String paramString)
  {
    boolean bool1 = StringUtils.isEmpty(paramString);
    boolean bool4 = false;
    boolean bool3 = false;
    if (bool1) {
      return false;
    }
    paramString = paramString.toCharArray();
    int k = paramString.length;
    int i;
    if (paramString[0] == '-') {
      i = 1;
    } else {
      i = 0;
    }
    int j = i + 1;
    if ((k > j) && (paramString[i] == '0') && (paramString[j] == 'x'))
    {
      j = i + 2;
      i = j;
      if (j == k) {
        return false;
      }
      while (i < paramString.length)
      {
        if (((paramString[i] < '0') || (paramString[i] > '9')) && ((paramString[i] < 'a') || (paramString[i] > 'f')))
        {
          if (paramString[i] < 'A') {
            break label143;
          }
          if (paramString[i] > 'F') {
            return false;
          }
        }
        i += 1;
        continue;
        label143:
        return false;
      }
      return true;
    }
    int i1 = k - 1;
    int n = 0;
    bool1 = false;
    int m = 0;
    j = 0;
    k = i;
    for (;;)
    {
      if ((k >= i1) && ((k >= i1 + 1) || (n == 0) || (bool1)))
      {
        if (k < paramString.length)
        {
          if ((paramString[k] >= '0') && (paramString[k] <= '9')) {
            return true;
          }
          bool2 = bool3;
          if (paramString[k] != 'e')
          {
            if (paramString[k] == 'E') {
              return false;
            }
            if (paramString[k] == '.')
            {
              if (j == 0)
              {
                if (m != 0) {
                  return false;
                }
                return bool1;
              }
              return false;
            }
            if ((n == 0) && ((paramString[k] == 'd') || (paramString[k] == 'D') || (paramString[k] == 'f') || (paramString[k] == 'F'))) {
              return bool1;
            }
            if ((paramString[k] != 'l') && (paramString[k] != 'L')) {
              return false;
            }
            bool2 = bool3;
            if (bool1)
            {
              bool2 = bool3;
              if (m == 0) {
                bool2 = true;
              }
            }
          }
          return bool2;
        }
        boolean bool2 = bool4;
        if (n == 0)
        {
          bool2 = bool4;
          if (bool1) {
            bool2 = true;
          }
        }
        return bool2;
      }
      if ((paramString[k] >= '0') && (paramString[k] <= '9'))
      {
        i = 0;
        bool1 = true;
      }
      else if (paramString[k] == '.')
      {
        if (j == 0)
        {
          if (m != 0) {
            return false;
          }
          j = 1;
          i = n;
        }
        else
        {
          return false;
        }
      }
      else if ((paramString[k] != 'e') && (paramString[k] != 'E'))
      {
        if ((paramString[k] != '+') && (paramString[k] != '-')) {
          return false;
        }
        if (n == 0) {
          return false;
        }
        i = 0;
        bool1 = false;
      }
      else
      {
        if (m != 0) {
          return false;
        }
        if (!bool1) {
          return false;
        }
        i = 1;
        m = 1;
      }
      k += 1;
      n = i;
    }
  }
  
  public static byte max(byte paramByte1, byte paramByte2, byte paramByte3)
  {
    byte b = paramByte1;
    if (paramByte2 > paramByte1) {
      b = paramByte2;
    }
    paramByte1 = b;
    if (paramByte3 > b) {
      paramByte1 = paramByte3;
    }
    return paramByte1;
  }
  
  public static byte max(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length != 0)
      {
        byte b1 = paramArrayOfByte[0];
        int i = 1;
        while (i < paramArrayOfByte.length)
        {
          byte b2 = b1;
          if (paramArrayOfByte[i] > b1) {
            b2 = paramArrayOfByte[i];
          }
          i += 1;
          b1 = b2;
        }
        return b1;
      }
      throw new IllegalArgumentException("Array cannot be empty.");
    }
    paramArrayOfByte = new IllegalArgumentException("The Array must not be null");
    for (;;)
    {
      throw paramArrayOfByte;
    }
  }
  
  public static double max(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    return Math.max(Math.max(paramDouble1, paramDouble2), paramDouble3);
  }
  
  public static double max(double[] paramArrayOfDouble)
  {
    if (paramArrayOfDouble != null)
    {
      if (paramArrayOfDouble.length != 0)
      {
        double d1 = paramArrayOfDouble[0];
        int i = 1;
        while (i < paramArrayOfDouble.length)
        {
          if (Double.isNaN(paramArrayOfDouble[i])) {
            return (0.0D / 0.0D);
          }
          double d2 = d1;
          if (paramArrayOfDouble[i] > d1) {
            d2 = paramArrayOfDouble[i];
          }
          i += 1;
          d1 = d2;
        }
        return d1;
      }
      throw new IllegalArgumentException("Array cannot be empty.");
    }
    paramArrayOfDouble = new IllegalArgumentException("The Array must not be null");
    for (;;)
    {
      throw paramArrayOfDouble;
    }
  }
  
  public static float max(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return Math.max(Math.max(paramFloat1, paramFloat2), paramFloat3);
  }
  
  public static float max(float[] paramArrayOfFloat)
  {
    if (paramArrayOfFloat != null)
    {
      if (paramArrayOfFloat.length != 0)
      {
        float f1 = paramArrayOfFloat[0];
        int i = 1;
        while (i < paramArrayOfFloat.length)
        {
          if (Float.isNaN(paramArrayOfFloat[i])) {
            return (0.0F / 0.0F);
          }
          float f2 = f1;
          if (paramArrayOfFloat[i] > f1) {
            f2 = paramArrayOfFloat[i];
          }
          i += 1;
          f1 = f2;
        }
        return f1;
      }
      throw new IllegalArgumentException("Array cannot be empty.");
    }
    paramArrayOfFloat = new IllegalArgumentException("The Array must not be null");
    for (;;)
    {
      throw paramArrayOfFloat;
    }
  }
  
  public static int max(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt1;
    if (paramInt2 > paramInt1) {
      i = paramInt2;
    }
    paramInt1 = i;
    if (paramInt3 > i) {
      paramInt1 = paramInt3;
    }
    return paramInt1;
  }
  
  public static int max(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt != null)
    {
      if (paramArrayOfInt.length != 0)
      {
        int j = paramArrayOfInt[0];
        int i = 1;
        while (i < paramArrayOfInt.length)
        {
          int k = j;
          if (paramArrayOfInt[i] > j) {
            k = paramArrayOfInt[i];
          }
          i += 1;
          j = k;
        }
        return j;
      }
      throw new IllegalArgumentException("Array cannot be empty.");
    }
    paramArrayOfInt = new IllegalArgumentException("The Array must not be null");
    for (;;)
    {
      throw paramArrayOfInt;
    }
  }
  
  public static long max(long paramLong1, long paramLong2, long paramLong3)
  {
    long l = paramLong1;
    if (paramLong2 > paramLong1) {
      l = paramLong2;
    }
    paramLong1 = l;
    if (paramLong3 > l) {
      paramLong1 = paramLong3;
    }
    return paramLong1;
  }
  
  public static long max(long[] paramArrayOfLong)
  {
    if (paramArrayOfLong != null)
    {
      if (paramArrayOfLong.length != 0)
      {
        long l1 = paramArrayOfLong[0];
        int i = 1;
        while (i < paramArrayOfLong.length)
        {
          long l2 = l1;
          if (paramArrayOfLong[i] > l1) {
            l2 = paramArrayOfLong[i];
          }
          i += 1;
          l1 = l2;
        }
        return l1;
      }
      throw new IllegalArgumentException("Array cannot be empty.");
    }
    paramArrayOfLong = new IllegalArgumentException("The Array must not be null");
    for (;;)
    {
      throw paramArrayOfLong;
    }
  }
  
  public static short max(short paramShort1, short paramShort2, short paramShort3)
  {
    short s = paramShort1;
    if (paramShort2 > paramShort1) {
      s = paramShort2;
    }
    paramShort1 = s;
    if (paramShort3 > s) {
      paramShort1 = paramShort3;
    }
    return paramShort1;
  }
  
  public static short max(short[] paramArrayOfShort)
  {
    if (paramArrayOfShort != null)
    {
      if (paramArrayOfShort.length != 0)
      {
        short s1 = paramArrayOfShort[0];
        int i = 1;
        while (i < paramArrayOfShort.length)
        {
          short s2 = s1;
          if (paramArrayOfShort[i] > s1) {
            s2 = paramArrayOfShort[i];
          }
          i += 1;
          s1 = s2;
        }
        return s1;
      }
      throw new IllegalArgumentException("Array cannot be empty.");
    }
    paramArrayOfShort = new IllegalArgumentException("The Array must not be null");
    for (;;)
    {
      throw paramArrayOfShort;
    }
  }
  
  public static byte min(byte paramByte1, byte paramByte2, byte paramByte3)
  {
    byte b = paramByte1;
    if (paramByte2 < paramByte1) {
      b = paramByte2;
    }
    paramByte1 = b;
    if (paramByte3 < b) {
      paramByte1 = paramByte3;
    }
    return paramByte1;
  }
  
  public static byte min(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length != 0)
      {
        byte b1 = paramArrayOfByte[0];
        int i = 1;
        while (i < paramArrayOfByte.length)
        {
          byte b2 = b1;
          if (paramArrayOfByte[i] < b1) {
            b2 = paramArrayOfByte[i];
          }
          i += 1;
          b1 = b2;
        }
        return b1;
      }
      throw new IllegalArgumentException("Array cannot be empty.");
    }
    paramArrayOfByte = new IllegalArgumentException("The Array must not be null");
    for (;;)
    {
      throw paramArrayOfByte;
    }
  }
  
  public static double min(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    return Math.min(Math.min(paramDouble1, paramDouble2), paramDouble3);
  }
  
  public static double min(double[] paramArrayOfDouble)
  {
    if (paramArrayOfDouble != null)
    {
      if (paramArrayOfDouble.length != 0)
      {
        double d1 = paramArrayOfDouble[0];
        int i = 1;
        while (i < paramArrayOfDouble.length)
        {
          if (Double.isNaN(paramArrayOfDouble[i])) {
            return (0.0D / 0.0D);
          }
          double d2 = d1;
          if (paramArrayOfDouble[i] < d1) {
            d2 = paramArrayOfDouble[i];
          }
          i += 1;
          d1 = d2;
        }
        return d1;
      }
      throw new IllegalArgumentException("Array cannot be empty.");
    }
    paramArrayOfDouble = new IllegalArgumentException("The Array must not be null");
    for (;;)
    {
      throw paramArrayOfDouble;
    }
  }
  
  public static float min(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return Math.min(Math.min(paramFloat1, paramFloat2), paramFloat3);
  }
  
  public static float min(float[] paramArrayOfFloat)
  {
    if (paramArrayOfFloat != null)
    {
      if (paramArrayOfFloat.length != 0)
      {
        float f1 = paramArrayOfFloat[0];
        int i = 1;
        while (i < paramArrayOfFloat.length)
        {
          if (Float.isNaN(paramArrayOfFloat[i])) {
            return (0.0F / 0.0F);
          }
          float f2 = f1;
          if (paramArrayOfFloat[i] < f1) {
            f2 = paramArrayOfFloat[i];
          }
          i += 1;
          f1 = f2;
        }
        return f1;
      }
      throw new IllegalArgumentException("Array cannot be empty.");
    }
    paramArrayOfFloat = new IllegalArgumentException("The Array must not be null");
    for (;;)
    {
      throw paramArrayOfFloat;
    }
  }
  
  public static int min(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt1;
    if (paramInt2 < paramInt1) {
      i = paramInt2;
    }
    paramInt1 = i;
    if (paramInt3 < i) {
      paramInt1 = paramInt3;
    }
    return paramInt1;
  }
  
  public static int min(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt != null)
    {
      if (paramArrayOfInt.length != 0)
      {
        int j = paramArrayOfInt[0];
        int i = 1;
        while (i < paramArrayOfInt.length)
        {
          int k = j;
          if (paramArrayOfInt[i] < j) {
            k = paramArrayOfInt[i];
          }
          i += 1;
          j = k;
        }
        return j;
      }
      throw new IllegalArgumentException("Array cannot be empty.");
    }
    paramArrayOfInt = new IllegalArgumentException("The Array must not be null");
    for (;;)
    {
      throw paramArrayOfInt;
    }
  }
  
  public static long min(long paramLong1, long paramLong2, long paramLong3)
  {
    long l = paramLong1;
    if (paramLong2 < paramLong1) {
      l = paramLong2;
    }
    paramLong1 = l;
    if (paramLong3 < l) {
      paramLong1 = paramLong3;
    }
    return paramLong1;
  }
  
  public static long min(long[] paramArrayOfLong)
  {
    if (paramArrayOfLong != null)
    {
      if (paramArrayOfLong.length != 0)
      {
        long l1 = paramArrayOfLong[0];
        int i = 1;
        while (i < paramArrayOfLong.length)
        {
          long l2 = l1;
          if (paramArrayOfLong[i] < l1) {
            l2 = paramArrayOfLong[i];
          }
          i += 1;
          l1 = l2;
        }
        return l1;
      }
      throw new IllegalArgumentException("Array cannot be empty.");
    }
    paramArrayOfLong = new IllegalArgumentException("The Array must not be null");
    for (;;)
    {
      throw paramArrayOfLong;
    }
  }
  
  public static short min(short paramShort1, short paramShort2, short paramShort3)
  {
    short s = paramShort1;
    if (paramShort2 < paramShort1) {
      s = paramShort2;
    }
    paramShort1 = s;
    if (paramShort3 < s) {
      paramShort1 = paramShort3;
    }
    return paramShort1;
  }
  
  public static short min(short[] paramArrayOfShort)
  {
    if (paramArrayOfShort != null)
    {
      if (paramArrayOfShort.length != 0)
      {
        short s1 = paramArrayOfShort[0];
        int i = 1;
        while (i < paramArrayOfShort.length)
        {
          short s2 = s1;
          if (paramArrayOfShort[i] < s1) {
            s2 = paramArrayOfShort[i];
          }
          i += 1;
          s1 = s2;
        }
        return s1;
      }
      throw new IllegalArgumentException("Array cannot be empty.");
    }
    paramArrayOfShort = new IllegalArgumentException("The Array must not be null");
    for (;;)
    {
      throw paramArrayOfShort;
    }
  }
  
  public static int stringToInt(String paramString)
  {
    return toInt(paramString);
  }
  
  public static int stringToInt(String paramString, int paramInt)
  {
    return toInt(paramString, paramInt);
  }
  
  public static byte toByte(String paramString)
  {
    return toByte(paramString, (byte)0);
  }
  
  public static byte toByte(String paramString, byte paramByte)
  {
    if (paramString == null) {
      return paramByte;
    }
    try
    {
      byte b = Byte.parseByte(paramString);
      return b;
    }
    catch (NumberFormatException paramString) {}
    return paramByte;
  }
  
  public static double toDouble(String paramString)
  {
    return toDouble(paramString, 0.0D);
  }
  
  public static double toDouble(String paramString, double paramDouble)
  {
    if (paramString == null) {
      return paramDouble;
    }
    try
    {
      double d = Double.parseDouble(paramString);
      return d;
    }
    catch (NumberFormatException paramString) {}
    return paramDouble;
  }
  
  public static float toFloat(String paramString)
  {
    return toFloat(paramString, 0.0F);
  }
  
  public static float toFloat(String paramString, float paramFloat)
  {
    if (paramString == null) {
      return paramFloat;
    }
    try
    {
      float f = Float.parseFloat(paramString);
      return f;
    }
    catch (NumberFormatException paramString) {}
    return paramFloat;
  }
  
  public static int toInt(String paramString)
  {
    return toInt(paramString, 0);
  }
  
  public static int toInt(String paramString, int paramInt)
  {
    if (paramString == null) {
      return paramInt;
    }
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (NumberFormatException paramString) {}
    return paramInt;
  }
  
  public static long toLong(String paramString)
  {
    return toLong(paramString, 0L);
  }
  
  public static long toLong(String paramString, long paramLong)
  {
    if (paramString == null) {
      return paramLong;
    }
    try
    {
      long l = Long.parseLong(paramString);
      return l;
    }
    catch (NumberFormatException paramString) {}
    return paramLong;
  }
  
  public static short toShort(String paramString)
  {
    return toShort(paramString, (short)0);
  }
  
  public static short toShort(String paramString, short paramShort)
  {
    if (paramString == null) {
      return paramShort;
    }
    try
    {
      short s = Short.parseShort(paramString);
      return s;
    }
    catch (NumberFormatException paramString) {}
    return paramShort;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.apache.commons.lang.math.NumberUtils
 * JD-Core Version:    0.7.0.1
 */