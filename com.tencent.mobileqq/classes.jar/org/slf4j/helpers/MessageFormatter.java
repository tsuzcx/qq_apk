package org.slf4j.helpers;

import java.util.HashMap;
import java.util.Map;

public final class MessageFormatter
{
  static final char DELIM_START = '{';
  static final char DELIM_STOP = '}';
  static final String DELIM_STR = "{}";
  private static final char ESCAPE_CHAR = '\\';
  
  public static final FormattingTuple arrayFormat(String paramString, Object[] paramArrayOfObject)
  {
    Throwable localThrowable = getThrowableCandidate(paramArrayOfObject);
    Object[] arrayOfObject = paramArrayOfObject;
    if (localThrowable != null) {
      arrayOfObject = trimmedCopy(paramArrayOfObject);
    }
    return arrayFormat(paramString, arrayOfObject, localThrowable);
  }
  
  public static final FormattingTuple arrayFormat(String paramString, Object[] paramArrayOfObject, Throwable paramThrowable)
  {
    if (paramString == null) {
      return new FormattingTuple(null, paramArrayOfObject, paramThrowable);
    }
    if (paramArrayOfObject == null) {
      return new FormattingTuple(paramString);
    }
    StringBuilder localStringBuilder = new StringBuilder(paramString.length() + 50);
    int i = 0;
    int j = 0;
    while (i < paramArrayOfObject.length)
    {
      int k = paramString.indexOf("{}", j);
      if (k == -1)
      {
        if (j == 0) {
          return new FormattingTuple(paramString, paramArrayOfObject, paramThrowable);
        }
        localStringBuilder.append(paramString, j, paramString.length());
        return new FormattingTuple(localStringBuilder.toString(), paramArrayOfObject, paramThrowable);
      }
      if (isEscapedDelimeter(paramString, k))
      {
        if (!isDoubleEscaped(paramString, k))
        {
          i -= 1;
          localStringBuilder.append(paramString, j, k - 1);
          localStringBuilder.append('{');
          j = k + 1;
          break label230;
        }
        localStringBuilder.append(paramString, j, k - 1);
        deeplyAppendParameter(localStringBuilder, paramArrayOfObject[i], new HashMap());
      }
      else
      {
        localStringBuilder.append(paramString, j, k);
        deeplyAppendParameter(localStringBuilder, paramArrayOfObject[i], new HashMap());
      }
      j = k + 2;
      label230:
      i += 1;
    }
    localStringBuilder.append(paramString, j, paramString.length());
    return new FormattingTuple(localStringBuilder.toString(), paramArrayOfObject, paramThrowable);
  }
  
  private static void booleanArrayAppend(StringBuilder paramStringBuilder, boolean[] paramArrayOfBoolean)
  {
    paramStringBuilder.append('[');
    int j = paramArrayOfBoolean.length;
    int i = 0;
    while (i < j)
    {
      paramStringBuilder.append(paramArrayOfBoolean[i]);
      if (i != j - 1) {
        paramStringBuilder.append(", ");
      }
      i += 1;
    }
    paramStringBuilder.append(']');
  }
  
  private static void byteArrayAppend(StringBuilder paramStringBuilder, byte[] paramArrayOfByte)
  {
    paramStringBuilder.append('[');
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      paramStringBuilder.append(paramArrayOfByte[i]);
      if (i != j - 1) {
        paramStringBuilder.append(", ");
      }
      i += 1;
    }
    paramStringBuilder.append(']');
  }
  
  private static void charArrayAppend(StringBuilder paramStringBuilder, char[] paramArrayOfChar)
  {
    paramStringBuilder.append('[');
    int j = paramArrayOfChar.length;
    int i = 0;
    while (i < j)
    {
      paramStringBuilder.append(paramArrayOfChar[i]);
      if (i != j - 1) {
        paramStringBuilder.append(", ");
      }
      i += 1;
    }
    paramStringBuilder.append(']');
  }
  
  private static void deeplyAppendParameter(StringBuilder paramStringBuilder, Object paramObject, Map<Object[], Object> paramMap)
  {
    if (paramObject == null)
    {
      paramStringBuilder.append("null");
      return;
    }
    if (!paramObject.getClass().isArray())
    {
      safeObjectAppend(paramStringBuilder, paramObject);
      return;
    }
    if ((paramObject instanceof boolean[]))
    {
      booleanArrayAppend(paramStringBuilder, (boolean[])paramObject);
      return;
    }
    if ((paramObject instanceof byte[]))
    {
      byteArrayAppend(paramStringBuilder, (byte[])paramObject);
      return;
    }
    if ((paramObject instanceof char[]))
    {
      charArrayAppend(paramStringBuilder, (char[])paramObject);
      return;
    }
    if ((paramObject instanceof short[]))
    {
      shortArrayAppend(paramStringBuilder, (short[])paramObject);
      return;
    }
    if ((paramObject instanceof int[]))
    {
      intArrayAppend(paramStringBuilder, (int[])paramObject);
      return;
    }
    if ((paramObject instanceof long[]))
    {
      longArrayAppend(paramStringBuilder, (long[])paramObject);
      return;
    }
    if ((paramObject instanceof float[]))
    {
      floatArrayAppend(paramStringBuilder, (float[])paramObject);
      return;
    }
    if ((paramObject instanceof double[]))
    {
      doubleArrayAppend(paramStringBuilder, (double[])paramObject);
      return;
    }
    objectArrayAppend(paramStringBuilder, (Object[])paramObject, paramMap);
  }
  
  private static void doubleArrayAppend(StringBuilder paramStringBuilder, double[] paramArrayOfDouble)
  {
    paramStringBuilder.append('[');
    int j = paramArrayOfDouble.length;
    int i = 0;
    while (i < j)
    {
      paramStringBuilder.append(paramArrayOfDouble[i]);
      if (i != j - 1) {
        paramStringBuilder.append(", ");
      }
      i += 1;
    }
    paramStringBuilder.append(']');
  }
  
  private static void floatArrayAppend(StringBuilder paramStringBuilder, float[] paramArrayOfFloat)
  {
    paramStringBuilder.append('[');
    int j = paramArrayOfFloat.length;
    int i = 0;
    while (i < j)
    {
      paramStringBuilder.append(paramArrayOfFloat[i]);
      if (i != j - 1) {
        paramStringBuilder.append(", ");
      }
      i += 1;
    }
    paramStringBuilder.append(']');
  }
  
  public static final FormattingTuple format(String paramString, Object paramObject)
  {
    return arrayFormat(paramString, new Object[] { paramObject });
  }
  
  public static final FormattingTuple format(String paramString, Object paramObject1, Object paramObject2)
  {
    return arrayFormat(paramString, new Object[] { paramObject1, paramObject2 });
  }
  
  static final Throwable getThrowableCandidate(Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject != null)
    {
      if (paramArrayOfObject.length == 0) {
        return null;
      }
      paramArrayOfObject = paramArrayOfObject[(paramArrayOfObject.length - 1)];
      if ((paramArrayOfObject instanceof Throwable)) {
        return (Throwable)paramArrayOfObject;
      }
    }
    return null;
  }
  
  private static void intArrayAppend(StringBuilder paramStringBuilder, int[] paramArrayOfInt)
  {
    paramStringBuilder.append('[');
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      paramStringBuilder.append(paramArrayOfInt[i]);
      if (i != j - 1) {
        paramStringBuilder.append(", ");
      }
      i += 1;
    }
    paramStringBuilder.append(']');
  }
  
  static final boolean isDoubleEscaped(String paramString, int paramInt)
  {
    return (paramInt >= 2) && (paramString.charAt(paramInt - 2) == '\\');
  }
  
  static final boolean isEscapedDelimeter(String paramString, int paramInt)
  {
    if (paramInt == 0) {
      return false;
    }
    return paramString.charAt(paramInt - 1) == '\\';
  }
  
  private static void longArrayAppend(StringBuilder paramStringBuilder, long[] paramArrayOfLong)
  {
    paramStringBuilder.append('[');
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      paramStringBuilder.append(paramArrayOfLong[i]);
      if (i != j - 1) {
        paramStringBuilder.append(", ");
      }
      i += 1;
    }
    paramStringBuilder.append(']');
  }
  
  private static void objectArrayAppend(StringBuilder paramStringBuilder, Object[] paramArrayOfObject, Map<Object[], Object> paramMap)
  {
    paramStringBuilder.append('[');
    if (!paramMap.containsKey(paramArrayOfObject))
    {
      paramMap.put(paramArrayOfObject, null);
      int j = paramArrayOfObject.length;
      int i = 0;
      while (i < j)
      {
        deeplyAppendParameter(paramStringBuilder, paramArrayOfObject[i], paramMap);
        if (i != j - 1) {
          paramStringBuilder.append(", ");
        }
        i += 1;
      }
      paramMap.remove(paramArrayOfObject);
    }
    else
    {
      paramStringBuilder.append("...");
    }
    paramStringBuilder.append(']');
  }
  
  private static void safeObjectAppend(StringBuilder paramStringBuilder, Object paramObject)
  {
    try
    {
      paramStringBuilder.append(paramObject.toString());
      return;
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SLF4J: Failed toString() invocation on an object of type [");
      localStringBuilder.append(paramObject.getClass().getName());
      localStringBuilder.append("]");
      Util.report(localStringBuilder.toString(), localThrowable);
      paramStringBuilder.append("[FAILED toString()]");
    }
  }
  
  private static void shortArrayAppend(StringBuilder paramStringBuilder, short[] paramArrayOfShort)
  {
    paramStringBuilder.append('[');
    int j = paramArrayOfShort.length;
    int i = 0;
    while (i < j)
    {
      paramStringBuilder.append(paramArrayOfShort[i]);
      if (i != j - 1) {
        paramStringBuilder.append(", ");
      }
      i += 1;
    }
    paramStringBuilder.append(']');
  }
  
  private static Object[] trimmedCopy(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length != 0))
    {
      int i = paramArrayOfObject.length - 1;
      Object[] arrayOfObject = new Object[i];
      System.arraycopy(paramArrayOfObject, 0, arrayOfObject, 0, i);
      return arrayOfObject;
    }
    throw new IllegalStateException("non-sensical empty or null argument array");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.slf4j.helpers.MessageFormatter
 * JD-Core Version:    0.7.0.1
 */