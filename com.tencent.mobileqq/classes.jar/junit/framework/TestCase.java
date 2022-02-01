package junit.framework;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public abstract class TestCase
  extends Assert
  implements Test
{
  private String fName;
  
  public TestCase()
  {
    this.fName = null;
  }
  
  public TestCase(String paramString)
  {
    this.fName = paramString;
  }
  
  public static void assertEquals(byte paramByte1, byte paramByte2)
  {
    Assert.assertEquals(paramByte1, paramByte2);
  }
  
  public static void assertEquals(char paramChar1, char paramChar2)
  {
    Assert.assertEquals(paramChar1, paramChar2);
  }
  
  public static void assertEquals(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    Assert.assertEquals(paramDouble1, paramDouble2, paramDouble3);
  }
  
  public static void assertEquals(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    Assert.assertEquals(paramFloat1, paramFloat2, paramFloat3);
  }
  
  public static void assertEquals(int paramInt1, int paramInt2)
  {
    Assert.assertEquals(paramInt1, paramInt2);
  }
  
  public static void assertEquals(long paramLong1, long paramLong2)
  {
    Assert.assertEquals(paramLong1, paramLong2);
  }
  
  public static void assertEquals(Object paramObject1, Object paramObject2)
  {
    Assert.assertEquals(paramObject1, paramObject2);
  }
  
  public static void assertEquals(String paramString, byte paramByte1, byte paramByte2)
  {
    Assert.assertEquals(paramString, paramByte1, paramByte2);
  }
  
  public static void assertEquals(String paramString, char paramChar1, char paramChar2)
  {
    Assert.assertEquals(paramString, paramChar1, paramChar2);
  }
  
  public static void assertEquals(String paramString, double paramDouble1, double paramDouble2, double paramDouble3)
  {
    Assert.assertEquals(paramString, paramDouble1, paramDouble2, paramDouble3);
  }
  
  public static void assertEquals(String paramString, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    Assert.assertEquals(paramString, paramFloat1, paramFloat2, paramFloat3);
  }
  
  public static void assertEquals(String paramString, int paramInt1, int paramInt2)
  {
    Assert.assertEquals(paramString, paramInt1, paramInt2);
  }
  
  public static void assertEquals(String paramString, long paramLong1, long paramLong2)
  {
    Assert.assertEquals(paramString, paramLong1, paramLong2);
  }
  
  public static void assertEquals(String paramString, Object paramObject1, Object paramObject2)
  {
    Assert.assertEquals(paramString, paramObject1, paramObject2);
  }
  
  public static void assertEquals(String paramString1, String paramString2)
  {
    Assert.assertEquals(paramString1, paramString2);
  }
  
  public static void assertEquals(String paramString1, String paramString2, String paramString3)
  {
    Assert.assertEquals(paramString1, paramString2, paramString3);
  }
  
  public static void assertEquals(String paramString, short paramShort1, short paramShort2)
  {
    Assert.assertEquals(paramString, paramShort1, paramShort2);
  }
  
  public static void assertEquals(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    Assert.assertEquals(paramString, paramBoolean1, paramBoolean2);
  }
  
  public static void assertEquals(short paramShort1, short paramShort2)
  {
    Assert.assertEquals(paramShort1, paramShort2);
  }
  
  public static void assertEquals(boolean paramBoolean1, boolean paramBoolean2)
  {
    Assert.assertEquals(paramBoolean1, paramBoolean2);
  }
  
  public static void assertFalse(String paramString, boolean paramBoolean)
  {
    Assert.assertFalse(paramString, paramBoolean);
  }
  
  public static void assertFalse(boolean paramBoolean)
  {
    Assert.assertFalse(paramBoolean);
  }
  
  public static void assertNotNull(Object paramObject)
  {
    Assert.assertNotNull(paramObject);
  }
  
  public static void assertNotNull(String paramString, Object paramObject)
  {
    Assert.assertNotNull(paramString, paramObject);
  }
  
  public static void assertNotSame(Object paramObject1, Object paramObject2)
  {
    Assert.assertNotSame(paramObject1, paramObject2);
  }
  
  public static void assertNotSame(String paramString, Object paramObject1, Object paramObject2)
  {
    Assert.assertNotSame(paramString, paramObject1, paramObject2);
  }
  
  public static void assertNull(Object paramObject)
  {
    Assert.assertNull(paramObject);
  }
  
  public static void assertNull(String paramString, Object paramObject)
  {
    Assert.assertNull(paramString, paramObject);
  }
  
  public static void assertSame(Object paramObject1, Object paramObject2)
  {
    Assert.assertSame(paramObject1, paramObject2);
  }
  
  public static void assertSame(String paramString, Object paramObject1, Object paramObject2)
  {
    Assert.assertSame(paramString, paramObject1, paramObject2);
  }
  
  public static void assertTrue(String paramString, boolean paramBoolean)
  {
    Assert.assertTrue(paramString, paramBoolean);
  }
  
  public static void assertTrue(boolean paramBoolean)
  {
    Assert.assertTrue(paramBoolean);
  }
  
  public static void fail() {}
  
  public static void fail(String paramString)
  {
    Assert.fail(paramString);
  }
  
  public static void failNotEquals(String paramString, Object paramObject1, Object paramObject2)
  {
    Assert.failNotEquals(paramString, paramObject1, paramObject2);
  }
  
  public static void failNotSame(String paramString, Object paramObject1, Object paramObject2)
  {
    Assert.failNotSame(paramString, paramObject1, paramObject2);
  }
  
  public static void failSame(String paramString)
  {
    Assert.failSame(paramString);
  }
  
  public static String format(String paramString, Object paramObject1, Object paramObject2)
  {
    return Assert.format(paramString, paramObject1, paramObject2);
  }
  
  public int countTestCases()
  {
    return 1;
  }
  
  protected TestResult createResult()
  {
    return new TestResult();
  }
  
  public String getName()
  {
    return this.fName;
  }
  
  public TestResult run()
  {
    TestResult localTestResult = createResult();
    run(localTestResult);
    return localTestResult;
  }
  
  public void run(TestResult paramTestResult)
  {
    paramTestResult.run(this);
  }
  
  /* Error */
  public void runBare()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 153	junit/framework/TestCase:setUp	()V
    //   4: aload_0
    //   5: invokevirtual 156	junit/framework/TestCase:runTest	()V
    //   8: aload_0
    //   9: invokevirtual 159	junit/framework/TestCase:tearDown	()V
    //   12: aconst_null
    //   13: astore_1
    //   14: goto +22 -> 36
    //   17: astore_1
    //   18: goto +18 -> 36
    //   21: astore_1
    //   22: aload_0
    //   23: invokevirtual 159	junit/framework/TestCase:tearDown	()V
    //   26: aload_1
    //   27: athrow
    //   28: astore_1
    //   29: aload_0
    //   30: invokevirtual 159	junit/framework/TestCase:tearDown	()V
    //   33: goto +3 -> 36
    //   36: aload_1
    //   37: ifnonnull +4 -> 41
    //   40: return
    //   41: aload_1
    //   42: athrow
    //   43: astore_2
    //   44: goto -18 -> 26
    //   47: astore_2
    //   48: goto -12 -> 36
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	this	TestCase
    //   13	1	1	localObject1	Object
    //   17	1	1	localThrowable1	java.lang.Throwable
    //   21	6	1	localObject2	Object
    //   28	14	1	localThrowable2	java.lang.Throwable
    //   43	1	2	localThrowable3	java.lang.Throwable
    //   47	1	2	localThrowable4	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   8	12	17	java/lang/Throwable
    //   4	8	21	finally
    //   4	8	28	java/lang/Throwable
    //   22	26	43	java/lang/Throwable
    //   29	33	47	java/lang/Throwable
  }
  
  protected void runTest()
  {
    assertNotNull("TestCase.fName cannot be null", this.fName);
    Object localObject1 = null;
    try
    {
      localObject2 = getClass().getMethod(this.fName, (Class[])null);
      localObject1 = localObject2;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      Object localObject2;
      label32:
      break label32;
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("Method \"");
    ((StringBuilder)localObject2).append(this.fName);
    ((StringBuilder)localObject2).append("\" not found");
    fail(((StringBuilder)localObject2).toString());
    if (!Modifier.isPublic(localObject1.getModifiers()))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Method \"");
      ((StringBuilder)localObject2).append(this.fName);
      ((StringBuilder)localObject2).append("\" should be public");
      fail(((StringBuilder)localObject2).toString());
    }
    try
    {
      localObject1.invoke(this, new Object[0]);
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      localIllegalAccessException.fillInStackTrace();
      throw localIllegalAccessException;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      localInvocationTargetException.fillInStackTrace();
      throw localInvocationTargetException.getTargetException();
    }
  }
  
  public void setName(String paramString)
  {
    this.fName = paramString;
  }
  
  protected void setUp() {}
  
  protected void tearDown() {}
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getName());
    localStringBuilder.append("(");
    localStringBuilder.append(getClass().getName());
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     junit.framework.TestCase
 * JD-Core Version:    0.7.0.1
 */