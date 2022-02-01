package org.apache.commons.lang;

import java.math.BigDecimal;
import java.math.BigInteger;

public final class NumberUtils
{
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
    return new BigDecimal(paramString);
  }
  
  public static BigInteger createBigInteger(String paramString)
  {
    return new BigInteger(paramString);
  }
  
  public static Double createDouble(String paramString)
  {
    return Double.valueOf(paramString);
  }
  
  public static Float createFloat(String paramString)
  {
    return Float.valueOf(paramString);
  }
  
  public static Integer createInteger(String paramString)
  {
    return Integer.decode(paramString);
  }
  
  public static Long createLong(String paramString)
  {
    return Long.valueOf(paramString);
  }
  
  public static Number createNumber(String paramString)
  {
    Object localObject4 = null;
    String str = null;
    if (paramString == null) {
      return null;
    }
    int j;
    int k;
    Object localObject2;
    Object localObject3;
    if (paramString.length() != 0)
    {
      i = paramString.length();
      j = 0;
      if ((i == 1) && (!Character.isDigit(paramString.charAt(0))))
      {
        localObject1 = new StringBuffer();
        ((StringBuffer)localObject1).append(paramString);
        ((StringBuffer)localObject1).append(" is not a valid number.");
        throw new NumberFormatException(((StringBuffer)localObject1).toString());
      }
      if (paramString.startsWith("--")) {
        return null;
      }
      if ((!paramString.startsWith("0x")) && (!paramString.startsWith("-0x")))
      {
        char c = paramString.charAt(paramString.length() - 1);
        i = paramString.indexOf('.');
        k = paramString.indexOf('e') + paramString.indexOf('E') + 1;
        if (i > -1)
        {
          if (k > -1)
          {
            if (k >= i)
            {
              localObject1 = paramString.substring(i + 1, k);
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
            localObject1 = paramString.substring(i + 1);
          }
          localObject2 = paramString.substring(0, i);
          localObject3 = localObject1;
        }
        else
        {
          if (k > -1) {
            localObject1 = paramString.substring(0, k);
          } else {
            localObject1 = paramString;
          }
          localObject3 = null;
          localObject2 = localObject1;
        }
        if (!Character.isDigit(c))
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
      label449:
      break label449;
    }
    return createBigInteger(str);
    Object localObject1 = new StringBuffer();
    ((StringBuffer)localObject1).append(paramString);
    ((StringBuffer)localObject1).append(" is not a valid number.");
    throw new NumberFormatException(((StringBuffer)localObject1).toString());
    label529:
    label672:
    label681:
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
      label567:
      label577:
      label749:
      break label529;
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
      label783:
      break label567;
    }
    try
    {
      localObject1 = createBigDecimal(str);
      return localObject1;
    }
    catch (NumberFormatException localNumberFormatException3)
    {
      break label577;
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
      break label672;
    }
    try
    {
      localObject1 = createLong(paramString);
      return localObject1;
    }
    catch (NumberFormatException localNumberFormatException5)
    {
      break label681;
    }
    return createBigInteger(paramString);
    int i = j;
    if (isAllZeros((String)localObject2))
    {
      i = j;
      if (isAllZeros((String)localObject1)) {
        i = 1;
      }
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
      break label749;
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
      break label783;
    }
    return createBigDecimal(paramString);
    return createInteger(paramString);
    throw new NumberFormatException("\"\" is not a valid number.");
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
    if (paramString != null)
    {
      if (paramString.length() == 0) {
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
    return false;
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
  
  public static int maximum(int paramInt1, int paramInt2, int paramInt3)
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
  
  public static long maximum(long paramLong1, long paramLong2, long paramLong3)
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
  
  public static int minimum(int paramInt1, int paramInt2, int paramInt3)
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
  
  public static long minimum(long paramLong1, long paramLong2, long paramLong3)
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
  
  public static int stringToInt(String paramString)
  {
    return stringToInt(paramString, 0);
  }
  
  public static int stringToInt(String paramString, int paramInt)
  {
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (NumberFormatException paramString) {}
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.apache.commons.lang.NumberUtils
 * JD-Core Version:    0.7.0.1
 */