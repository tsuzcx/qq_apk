package org.junit;

import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.junit.internal.ExactComparisonCriteria;
import org.junit.internal.InexactComparisonCriteria;

public class Assert
{
  public static void assertArrayEquals(String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    internalArrayEquals(paramString, paramArrayOfByte1, paramArrayOfByte2);
  }
  
  public static void assertArrayEquals(String paramString, char[] paramArrayOfChar1, char[] paramArrayOfChar2)
  {
    internalArrayEquals(paramString, paramArrayOfChar1, paramArrayOfChar2);
  }
  
  public static void assertArrayEquals(String paramString, double[] paramArrayOfDouble1, double[] paramArrayOfDouble2, double paramDouble)
  {
    new InexactComparisonCriteria(paramDouble).arrayEquals(paramString, paramArrayOfDouble1, paramArrayOfDouble2);
  }
  
  public static void assertArrayEquals(String paramString, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float paramFloat)
  {
    new InexactComparisonCriteria(paramFloat).arrayEquals(paramString, paramArrayOfFloat1, paramArrayOfFloat2);
  }
  
  public static void assertArrayEquals(String paramString, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    internalArrayEquals(paramString, paramArrayOfInt1, paramArrayOfInt2);
  }
  
  public static void assertArrayEquals(String paramString, long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    internalArrayEquals(paramString, paramArrayOfLong1, paramArrayOfLong2);
  }
  
  public static void assertArrayEquals(String paramString, Object[] paramArrayOfObject1, Object[] paramArrayOfObject2)
  {
    internalArrayEquals(paramString, paramArrayOfObject1, paramArrayOfObject2);
  }
  
  public static void assertArrayEquals(String paramString, short[] paramArrayOfShort1, short[] paramArrayOfShort2)
  {
    internalArrayEquals(paramString, paramArrayOfShort1, paramArrayOfShort2);
  }
  
  public static void assertArrayEquals(String paramString, boolean[] paramArrayOfBoolean1, boolean[] paramArrayOfBoolean2)
  {
    internalArrayEquals(paramString, paramArrayOfBoolean1, paramArrayOfBoolean2);
  }
  
  public static void assertArrayEquals(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    assertArrayEquals(null, paramArrayOfByte1, paramArrayOfByte2);
  }
  
  public static void assertArrayEquals(char[] paramArrayOfChar1, char[] paramArrayOfChar2)
  {
    assertArrayEquals(null, paramArrayOfChar1, paramArrayOfChar2);
  }
  
  public static void assertArrayEquals(double[] paramArrayOfDouble1, double[] paramArrayOfDouble2, double paramDouble)
  {
    assertArrayEquals(null, paramArrayOfDouble1, paramArrayOfDouble2, paramDouble);
  }
  
  public static void assertArrayEquals(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float paramFloat)
  {
    assertArrayEquals(null, paramArrayOfFloat1, paramArrayOfFloat2, paramFloat);
  }
  
  public static void assertArrayEquals(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    assertArrayEquals(null, paramArrayOfInt1, paramArrayOfInt2);
  }
  
  public static void assertArrayEquals(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    assertArrayEquals(null, paramArrayOfLong1, paramArrayOfLong2);
  }
  
  public static void assertArrayEquals(Object[] paramArrayOfObject1, Object[] paramArrayOfObject2)
  {
    assertArrayEquals(null, paramArrayOfObject1, paramArrayOfObject2);
  }
  
  public static void assertArrayEquals(short[] paramArrayOfShort1, short[] paramArrayOfShort2)
  {
    assertArrayEquals(null, paramArrayOfShort1, paramArrayOfShort2);
  }
  
  public static void assertArrayEquals(boolean[] paramArrayOfBoolean1, boolean[] paramArrayOfBoolean2)
  {
    assertArrayEquals(null, paramArrayOfBoolean1, paramArrayOfBoolean2);
  }
  
  @Deprecated
  public static void assertEquals(double paramDouble1, double paramDouble2)
  {
    assertEquals(null, paramDouble1, paramDouble2);
  }
  
  public static void assertEquals(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    assertEquals(null, paramDouble1, paramDouble2, paramDouble3);
  }
  
  public static void assertEquals(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    assertEquals(null, paramFloat1, paramFloat2, paramFloat3);
  }
  
  public static void assertEquals(long paramLong1, long paramLong2)
  {
    assertEquals(null, paramLong1, paramLong2);
  }
  
  public static void assertEquals(Object paramObject1, Object paramObject2)
  {
    assertEquals(null, paramObject1, paramObject2);
  }
  
  @Deprecated
  public static void assertEquals(String paramString, double paramDouble1, double paramDouble2)
  {
    fail("Use assertEquals(expected, actual, delta) to compare floating-point numbers");
  }
  
  public static void assertEquals(String paramString, double paramDouble1, double paramDouble2, double paramDouble3)
  {
    if (doubleIsDifferent(paramDouble1, paramDouble2, paramDouble3)) {
      failNotEquals(paramString, Double.valueOf(paramDouble1), Double.valueOf(paramDouble2));
    }
  }
  
  public static void assertEquals(String paramString, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (floatIsDifferent(paramFloat1, paramFloat2, paramFloat3)) {
      failNotEquals(paramString, Float.valueOf(paramFloat1), Float.valueOf(paramFloat2));
    }
  }
  
  public static void assertEquals(String paramString, long paramLong1, long paramLong2)
  {
    if (paramLong1 != paramLong2) {
      failNotEquals(paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2));
    }
  }
  
  public static void assertEquals(String paramString, Object paramObject1, Object paramObject2)
  {
    if (equalsRegardingNull(paramObject1, paramObject2)) {
      return;
    }
    if (((paramObject1 instanceof String)) && ((paramObject2 instanceof String)))
    {
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      throw new ComparisonFailure(str, (String)paramObject1, (String)paramObject2);
    }
    failNotEquals(paramString, paramObject1, paramObject2);
  }
  
  @Deprecated
  public static void assertEquals(String paramString, Object[] paramArrayOfObject1, Object[] paramArrayOfObject2)
  {
    assertArrayEquals(paramString, paramArrayOfObject1, paramArrayOfObject2);
  }
  
  @Deprecated
  public static void assertEquals(Object[] paramArrayOfObject1, Object[] paramArrayOfObject2)
  {
    assertArrayEquals(paramArrayOfObject1, paramArrayOfObject2);
  }
  
  public static void assertFalse(String paramString, boolean paramBoolean)
  {
    assertTrue(paramString, paramBoolean ^ true);
  }
  
  public static void assertFalse(boolean paramBoolean)
  {
    assertFalse(null, paramBoolean);
  }
  
  public static void assertNotEquals(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    assertNotEquals(null, paramDouble1, paramDouble2, paramDouble3);
  }
  
  public static void assertNotEquals(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    assertNotEquals(null, paramFloat1, paramFloat2, paramFloat3);
  }
  
  public static void assertNotEquals(long paramLong1, long paramLong2)
  {
    assertNotEquals(null, paramLong1, paramLong2);
  }
  
  public static void assertNotEquals(Object paramObject1, Object paramObject2)
  {
    assertNotEquals(null, paramObject1, paramObject2);
  }
  
  public static void assertNotEquals(String paramString, double paramDouble1, double paramDouble2, double paramDouble3)
  {
    if (!doubleIsDifferent(paramDouble1, paramDouble2, paramDouble3)) {
      failEquals(paramString, Double.valueOf(paramDouble2));
    }
  }
  
  public static void assertNotEquals(String paramString, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (!floatIsDifferent(paramFloat1, paramFloat2, paramFloat3)) {
      failEquals(paramString, Float.valueOf(paramFloat2));
    }
  }
  
  public static void assertNotEquals(String paramString, long paramLong1, long paramLong2)
  {
    if (paramLong1 == paramLong2) {
      failEquals(paramString, Long.valueOf(paramLong2));
    }
  }
  
  public static void assertNotEquals(String paramString, Object paramObject1, Object paramObject2)
  {
    if (equalsRegardingNull(paramObject1, paramObject2)) {
      failEquals(paramString, paramObject2);
    }
  }
  
  public static void assertNotNull(Object paramObject)
  {
    assertNotNull(null, paramObject);
  }
  
  public static void assertNotNull(String paramString, Object paramObject)
  {
    boolean bool;
    if (paramObject != null) {
      bool = true;
    } else {
      bool = false;
    }
    assertTrue(paramString, bool);
  }
  
  public static void assertNotSame(Object paramObject1, Object paramObject2)
  {
    assertNotSame(null, paramObject1, paramObject2);
  }
  
  public static void assertNotSame(String paramString, Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == paramObject2) {
      failSame(paramString);
    }
  }
  
  public static void assertNull(Object paramObject)
  {
    assertNull(null, paramObject);
  }
  
  public static void assertNull(String paramString, Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    failNotNull(paramString, paramObject);
  }
  
  public static void assertSame(Object paramObject1, Object paramObject2)
  {
    assertSame(null, paramObject1, paramObject2);
  }
  
  public static void assertSame(String paramString, Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == paramObject2) {
      return;
    }
    failNotSame(paramString, paramObject1, paramObject2);
  }
  
  public static <T> void assertThat(T paramT, Matcher<? super T> paramMatcher)
  {
    assertThat("", paramT, paramMatcher);
  }
  
  public static <T> void assertThat(String paramString, T paramT, Matcher<? super T> paramMatcher)
  {
    MatcherAssert.assertThat(paramString, paramT, paramMatcher);
  }
  
  public static void assertTrue(String paramString, boolean paramBoolean)
  {
    if (!paramBoolean) {
      fail(paramString);
    }
  }
  
  public static void assertTrue(boolean paramBoolean)
  {
    assertTrue(null, paramBoolean);
  }
  
  private static boolean doubleIsDifferent(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    if (Double.compare(paramDouble1, paramDouble2) == 0) {
      return false;
    }
    return Math.abs(paramDouble1 - paramDouble2) > paramDouble3;
  }
  
  private static boolean equalsRegardingNull(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == null) {
      return paramObject2 == null;
    }
    return isEquals(paramObject1, paramObject2);
  }
  
  public static void fail()
  {
    fail(null);
  }
  
  public static void fail(String paramString)
  {
    if (paramString == null) {
      throw new AssertionError();
    }
    throw new AssertionError(paramString);
  }
  
  private static void failEquals(String paramString, Object paramObject)
  {
    if (paramString != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(". ");
      paramString = localStringBuilder.toString();
    }
    else
    {
      paramString = "Values should be different. ";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("Actual: ");
    localStringBuilder.append(paramObject);
    fail(localStringBuilder.toString());
  }
  
  private static void failNotEquals(String paramString, Object paramObject1, Object paramObject2)
  {
    fail(format(paramString, paramObject1, paramObject2));
  }
  
  private static void failNotNull(String paramString, Object paramObject)
  {
    if (paramString != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(" ");
      paramString = localStringBuilder.toString();
    }
    else
    {
      paramString = "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("expected null, but was:<");
    localStringBuilder.append(paramObject);
    localStringBuilder.append(">");
    fail(localStringBuilder.toString());
  }
  
  private static void failNotSame(String paramString, Object paramObject1, Object paramObject2)
  {
    if (paramString != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(" ");
      paramString = localStringBuilder.toString();
    }
    else
    {
      paramString = "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("expected same:<");
    localStringBuilder.append(paramObject1);
    localStringBuilder.append("> was not:<");
    localStringBuilder.append(paramObject2);
    localStringBuilder.append(">");
    fail(localStringBuilder.toString());
  }
  
  private static void failSame(String paramString)
  {
    if (paramString != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(" ");
      paramString = localStringBuilder.toString();
    }
    else
    {
      paramString = "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("expected not same");
    fail(localStringBuilder.toString());
  }
  
  private static boolean floatIsDifferent(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (Float.compare(paramFloat1, paramFloat2) == 0) {
      return false;
    }
    return Math.abs(paramFloat1 - paramFloat2) > paramFloat3;
  }
  
  static String format(String paramString, Object paramObject1, Object paramObject2)
  {
    String str = "";
    Object localObject = str;
    if (paramString != null)
    {
      localObject = str;
      if (!paramString.equals(""))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(" ");
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    paramString = String.valueOf(paramObject1);
    str = String.valueOf(paramObject2);
    if (paramString.equals(str))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("expected: ");
      localStringBuilder.append(formatClassAndValue(paramObject1, paramString));
      localStringBuilder.append(" but was: ");
      localStringBuilder.append(formatClassAndValue(paramObject2, str));
      return localStringBuilder.toString();
    }
    paramObject1 = new StringBuilder();
    paramObject1.append((String)localObject);
    paramObject1.append("expected:<");
    paramObject1.append(paramString);
    paramObject1.append("> but was:<");
    paramObject1.append(str);
    paramObject1.append(">");
    return paramObject1.toString();
  }
  
  private static String formatClassAndValue(Object paramObject, String paramString)
  {
    if (paramObject == null) {
      paramObject = "null";
    } else {
      paramObject = paramObject.getClass().getName();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramObject);
    localStringBuilder.append("<");
    localStringBuilder.append(paramString);
    localStringBuilder.append(">");
    return localStringBuilder.toString();
  }
  
  private static void internalArrayEquals(String paramString, Object paramObject1, Object paramObject2)
  {
    new ExactComparisonCriteria().arrayEquals(paramString, paramObject1, paramObject2);
  }
  
  private static boolean isEquals(Object paramObject1, Object paramObject2)
  {
    return paramObject1.equals(paramObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.junit.Assert
 * JD-Core Version:    0.7.0.1
 */