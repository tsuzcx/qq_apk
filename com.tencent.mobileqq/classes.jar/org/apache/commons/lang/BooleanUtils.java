package org.apache.commons.lang;

import org.apache.commons.lang.math.NumberUtils;

public class BooleanUtils
{
  public static boolean isFalse(Boolean paramBoolean)
  {
    if (paramBoolean == null) {
      return false;
    }
    return paramBoolean.booleanValue() ^ true;
  }
  
  public static boolean isNotFalse(Boolean paramBoolean)
  {
    return isFalse(paramBoolean) ^ true;
  }
  
  public static boolean isNotTrue(Boolean paramBoolean)
  {
    return isTrue(paramBoolean) ^ true;
  }
  
  public static boolean isTrue(Boolean paramBoolean)
  {
    if (paramBoolean == null) {
      return false;
    }
    return paramBoolean.booleanValue();
  }
  
  public static Boolean negate(Boolean paramBoolean)
  {
    if (paramBoolean == null) {
      return null;
    }
    if (paramBoolean.booleanValue()) {
      return Boolean.FALSE;
    }
    return Boolean.TRUE;
  }
  
  public static boolean toBoolean(int paramInt)
  {
    return paramInt != 0;
  }
  
  public static boolean toBoolean(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == paramInt2) {
      return true;
    }
    if (paramInt1 == paramInt3) {
      return false;
    }
    throw new IllegalArgumentException("The Integer did not match either specified value");
  }
  
  public static boolean toBoolean(Boolean paramBoolean)
  {
    if (paramBoolean == null) {
      return false;
    }
    return paramBoolean.booleanValue();
  }
  
  public static boolean toBoolean(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3)
  {
    if (paramInteger1 == null)
    {
      if (paramInteger2 == null) {
        return true;
      }
      if (paramInteger3 == null) {
        return false;
      }
    }
    else
    {
      if (paramInteger1.equals(paramInteger2)) {
        return true;
      }
      if (paramInteger1.equals(paramInteger3)) {
        return false;
      }
    }
    throw new IllegalArgumentException("The Integer did not match either specified value");
  }
  
  public static boolean toBoolean(String paramString)
  {
    return toBoolean(toBooleanObject(paramString));
  }
  
  public static boolean toBoolean(String paramString1, String paramString2, String paramString3)
  {
    if (paramString1 == null)
    {
      if (paramString2 == null) {
        return true;
      }
      if (paramString3 == null) {
        return false;
      }
    }
    else
    {
      if (paramString1.equals(paramString2)) {
        return true;
      }
      if (paramString1.equals(paramString3)) {
        return false;
      }
    }
    throw new IllegalArgumentException("The String did not match either specified value");
  }
  
  public static boolean toBooleanDefaultIfNull(Boolean paramBoolean, boolean paramBoolean1)
  {
    if (paramBoolean == null) {
      return paramBoolean1;
    }
    return paramBoolean.booleanValue();
  }
  
  public static Boolean toBooleanObject(int paramInt)
  {
    if (paramInt == 0) {
      return Boolean.FALSE;
    }
    return Boolean.TRUE;
  }
  
  public static Boolean toBooleanObject(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt1 == paramInt2) {
      return Boolean.TRUE;
    }
    if (paramInt1 == paramInt3) {
      return Boolean.FALSE;
    }
    if (paramInt1 == paramInt4) {
      return null;
    }
    throw new IllegalArgumentException("The Integer did not match any specified value");
  }
  
  public static Boolean toBooleanObject(Integer paramInteger)
  {
    if (paramInteger == null) {
      return null;
    }
    if (paramInteger.intValue() == 0) {
      return Boolean.FALSE;
    }
    return Boolean.TRUE;
  }
  
  public static Boolean toBooleanObject(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, Integer paramInteger4)
  {
    if (paramInteger1 == null)
    {
      if (paramInteger2 == null) {
        return Boolean.TRUE;
      }
      if (paramInteger3 == null) {
        return Boolean.FALSE;
      }
      if (paramInteger4 == null) {
        return null;
      }
    }
    else
    {
      if (paramInteger1.equals(paramInteger2)) {
        return Boolean.TRUE;
      }
      if (paramInteger1.equals(paramInteger3)) {
        return Boolean.FALSE;
      }
      if (paramInteger1.equals(paramInteger4)) {
        return null;
      }
    }
    throw new IllegalArgumentException("The Integer did not match any specified value");
  }
  
  public static Boolean toBooleanObject(String paramString)
  {
    if (paramString == "true") {
      return Boolean.TRUE;
    }
    if (paramString == null) {
      return null;
    }
    int i = paramString.length();
    if (i != 1)
    {
      int j;
      if (i != 2)
      {
        int k;
        if (i != 3)
        {
          int m;
          if (i != 4)
          {
            if (i != 5) {
              return null;
            }
            i = paramString.charAt(0);
            j = paramString.charAt(1);
            k = paramString.charAt(2);
            m = paramString.charAt(3);
            int n = paramString.charAt(4);
            if (((i == 102) || (i == 70)) && ((j == 97) || (j == 65)) && ((k == 108) || (k == 76)) && ((m == 115) || (m == 83)) && ((n == 101) || (n == 69))) {
              return Boolean.FALSE;
            }
          }
          else
          {
            i = paramString.charAt(0);
            j = paramString.charAt(1);
            k = paramString.charAt(2);
            m = paramString.charAt(3);
            if (((i == 116) || (i == 84)) && ((j == 114) || (j == 82)) && ((k == 117) || (k == 85)) && ((m == 101) || (m == 69))) {
              return Boolean.TRUE;
            }
          }
        }
        else
        {
          i = paramString.charAt(0);
          j = paramString.charAt(1);
          k = paramString.charAt(2);
          if (((i != 121) && (i != 89)) || ((j != 101) && (j != 69)) || ((k != 115) && (k != 83)))
          {
            if (((i == 111) || (i == 79)) && ((j == 102) || (j == 70)) && ((k == 102) || (k == 70))) {
              return Boolean.FALSE;
            }
          }
          else {
            return Boolean.TRUE;
          }
        }
      }
      else
      {
        i = paramString.charAt(0);
        j = paramString.charAt(1);
        if (((i != 111) && (i != 79)) || ((j != 110) && (j != 78)))
        {
          if (((i == 110) || (i == 78)) && ((j == 111) || (j == 79))) {
            return Boolean.FALSE;
          }
        }
        else {
          return Boolean.TRUE;
        }
      }
    }
    else
    {
      i = paramString.charAt(0);
      if ((i == 121) || (i == 89) || (i == 116) || (i == 84)) {
        break label465;
      }
      if ((i == 110) || (i == 78) || (i == 102) || (i == 70)) {
        break label461;
      }
    }
    return null;
    label461:
    return Boolean.FALSE;
    label465:
    return Boolean.TRUE;
  }
  
  public static Boolean toBooleanObject(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (paramString1 == null)
    {
      if (paramString2 == null) {
        return Boolean.TRUE;
      }
      if (paramString3 == null) {
        return Boolean.FALSE;
      }
      if (paramString4 == null) {
        return null;
      }
    }
    else
    {
      if (paramString1.equals(paramString2)) {
        return Boolean.TRUE;
      }
      if (paramString1.equals(paramString3)) {
        return Boolean.FALSE;
      }
      if (paramString1.equals(paramString4)) {
        return null;
      }
    }
    throw new IllegalArgumentException("The String did not match any specified value");
  }
  
  public static Boolean toBooleanObject(boolean paramBoolean)
  {
    if (paramBoolean) {
      return Boolean.TRUE;
    }
    return Boolean.FALSE;
  }
  
  public static int toInteger(Boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramBoolean == null) {
      return paramInt3;
    }
    if (paramBoolean.booleanValue()) {
      return paramInt1;
    }
    return paramInt2;
  }
  
  public static int toInteger(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static int toInteger(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramBoolean) {
      return paramInt1;
    }
    return paramInt2;
  }
  
  public static Integer toIntegerObject(Boolean paramBoolean)
  {
    if (paramBoolean == null) {
      return null;
    }
    if (paramBoolean.booleanValue()) {
      return NumberUtils.INTEGER_ONE;
    }
    return NumberUtils.INTEGER_ZERO;
  }
  
  public static Integer toIntegerObject(Boolean paramBoolean, Integer paramInteger1, Integer paramInteger2, Integer paramInteger3)
  {
    if (paramBoolean == null) {
      return paramInteger3;
    }
    if (paramBoolean.booleanValue()) {
      return paramInteger1;
    }
    return paramInteger2;
  }
  
  public static Integer toIntegerObject(boolean paramBoolean)
  {
    if (paramBoolean) {
      return NumberUtils.INTEGER_ONE;
    }
    return NumberUtils.INTEGER_ZERO;
  }
  
  public static Integer toIntegerObject(boolean paramBoolean, Integer paramInteger1, Integer paramInteger2)
  {
    if (paramBoolean) {
      return paramInteger1;
    }
    return paramInteger2;
  }
  
  public static String toString(Boolean paramBoolean, String paramString1, String paramString2, String paramString3)
  {
    if (paramBoolean == null) {
      return paramString3;
    }
    if (paramBoolean.booleanValue()) {
      return paramString1;
    }
    return paramString2;
  }
  
  public static String toString(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (paramBoolean) {
      return paramString1;
    }
    return paramString2;
  }
  
  public static String toStringOnOff(Boolean paramBoolean)
  {
    return toString(paramBoolean, "on", "off", null);
  }
  
  public static String toStringOnOff(boolean paramBoolean)
  {
    return toString(paramBoolean, "on", "off");
  }
  
  public static String toStringTrueFalse(Boolean paramBoolean)
  {
    return toString(paramBoolean, "true", "false", null);
  }
  
  public static String toStringTrueFalse(boolean paramBoolean)
  {
    return toString(paramBoolean, "true", "false");
  }
  
  public static String toStringYesNo(Boolean paramBoolean)
  {
    return toString(paramBoolean, "yes", "no", null);
  }
  
  public static String toStringYesNo(boolean paramBoolean)
  {
    return toString(paramBoolean, "yes", "no");
  }
  
  public static Boolean xor(Boolean[] paramArrayOfBoolean)
  {
    if ((paramArrayOfBoolean == null) || (paramArrayOfBoolean.length != 0)) {}
    try
    {
      paramArrayOfBoolean = ArrayUtils.toPrimitive(paramArrayOfBoolean);
      if (xor(paramArrayOfBoolean)) {
        return Boolean.TRUE;
      }
      return Boolean.FALSE;
    }
    catch (NullPointerException paramArrayOfBoolean)
    {
      label29:
      break label29;
    }
    throw new IllegalArgumentException("The array must not contain any null elements");
    throw new IllegalArgumentException("Array is empty");
    throw new IllegalArgumentException("The Array must not be null");
  }
  
  public static boolean xor(boolean[] paramArrayOfBoolean)
  {
    if (paramArrayOfBoolean != null)
    {
      if (paramArrayOfBoolean.length != 0)
      {
        boolean bool = false;
        int i = 0;
        int k;
        for (int j = 0; i < paramArrayOfBoolean.length; j = k)
        {
          k = j;
          if (paramArrayOfBoolean[i] != 0) {
            if (j < 1) {
              k = j + 1;
            } else {
              return false;
            }
          }
          i += 1;
        }
        if (j == 1) {
          bool = true;
        }
        return bool;
      }
      throw new IllegalArgumentException("Array is empty");
    }
    paramArrayOfBoolean = new IllegalArgumentException("The Array must not be null");
    for (;;)
    {
      throw paramArrayOfBoolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.apache.commons.lang.BooleanUtils
 * JD-Core Version:    0.7.0.1
 */