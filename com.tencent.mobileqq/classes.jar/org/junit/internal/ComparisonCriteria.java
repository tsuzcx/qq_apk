package org.junit.internal;

import java.lang.reflect.Array;
import java.util.Arrays;
import org.junit.Assert;

public abstract class ComparisonCriteria
{
  private int assertArraysAreSameLength(Object paramObject1, Object paramObject2, String paramString)
  {
    if (paramObject1 == null) {
      Assert.fail(paramString + "expected array was null");
    }
    if (paramObject2 == null) {
      Assert.fail(paramString + "actual array was null");
    }
    int i = Array.getLength(paramObject2);
    int j = Array.getLength(paramObject1);
    if (i != j) {
      Assert.fail(paramString + "array lengths differed, expected.length=" + j + " actual.length=" + i);
    }
    return j;
  }
  
  private boolean isArray(Object paramObject)
  {
    return (paramObject != null) && (paramObject.getClass().isArray());
  }
  
  public void arrayEquals(String paramString, Object paramObject1, Object paramObject2)
  {
    int i = 0;
    if (paramObject1 != paramObject2) {
      if (!Arrays.deepEquals(new Object[] { paramObject1 }, new Object[] { paramObject2 })) {
        break label31;
      }
    }
    label31:
    String str;
    int j;
    do
    {
      return;
      if (paramString != null) {
        break;
      }
      str = "";
      j = assertArraysAreSameLength(paramObject1, paramObject2, str);
    } while (i >= j);
    Object localObject1 = Array.get(paramObject1, i);
    Object localObject2 = Array.get(paramObject2, i);
    if ((isArray(localObject1)) && (isArray(localObject2))) {}
    for (;;)
    {
      try
      {
        arrayEquals(paramString, localObject1, localObject2);
        i += 1;
      }
      catch (ArrayComparisonFailure paramString)
      {
        paramString.addDimension(i);
        throw paramString;
      }
      str = paramString + ": ";
      break;
      try
      {
        assertElementsEqual(localObject1, localObject2);
      }
      catch (AssertionError paramString)
      {
        throw new ArrayComparisonFailure(str, paramString, i);
      }
    }
  }
  
  protected abstract void assertElementsEqual(Object paramObject1, Object paramObject2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     org.junit.internal.ComparisonCriteria
 * JD-Core Version:    0.7.0.1
 */