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
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: invokevirtual 153	junit/framework/TestCase:setUp	()V
    //   6: aload_0
    //   7: invokevirtual 156	junit/framework/TestCase:runTest	()V
    //   10: aload_0
    //   11: invokevirtual 159	junit/framework/TestCase:tearDown	()V
    //   14: aload_1
    //   15: ifnull +46 -> 61
    //   18: aload_1
    //   19: athrow
    //   20: astore_1
    //   21: iconst_0
    //   22: ifne +43 -> 65
    //   25: goto -11 -> 14
    //   28: astore_1
    //   29: aload_0
    //   30: invokevirtual 159	junit/framework/TestCase:tearDown	()V
    //   33: goto -19 -> 14
    //   36: astore_2
    //   37: aload_1
    //   38: ifnonnull +24 -> 62
    //   41: aload_2
    //   42: astore_1
    //   43: goto -29 -> 14
    //   46: astore_1
    //   47: aload_0
    //   48: invokevirtual 159	junit/framework/TestCase:tearDown	()V
    //   51: aload_1
    //   52: athrow
    //   53: astore_2
    //   54: iconst_0
    //   55: ifne -4 -> 51
    //   58: goto -7 -> 51
    //   61: return
    //   62: goto -19 -> 43
    //   65: aconst_null
    //   66: astore_1
    //   67: goto -42 -> 25
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	70	0	this	TestCase
    //   1	18	1	localObject1	Object
    //   20	1	1	localThrowable1	java.lang.Throwable
    //   28	10	1	localThrowable2	java.lang.Throwable
    //   42	1	1	localObject2	Object
    //   46	6	1	localObject3	Object
    //   66	1	1	localObject4	Object
    //   36	6	2	localThrowable3	java.lang.Throwable
    //   53	1	2	localThrowable4	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   10	14	20	java/lang/Throwable
    //   6	10	28	java/lang/Throwable
    //   29	33	36	java/lang/Throwable
    //   6	10	46	finally
    //   47	51	53	java/lang/Throwable
  }
  
  protected void runTest()
  {
    assertNotNull("TestCase.fName cannot be null", this.fName);
    try
    {
      localMethod = getClass().getMethod(this.fName, (Class[])null);
      if (!Modifier.isPublic(localMethod.getModifiers())) {
        fail("Method \"" + this.fName + "\" should be public");
      }
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        try
        {
          Method localMethod;
          localMethod.invoke(this, new Object[0]);
          return;
        }
        catch (InvocationTargetException localInvocationTargetException)
        {
          Object localObject;
          localInvocationTargetException.fillInStackTrace();
          throw localInvocationTargetException.getTargetException();
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          localIllegalAccessException.fillInStackTrace();
          throw localIllegalAccessException;
        }
        localNoSuchMethodException = localNoSuchMethodException;
        fail("Method \"" + this.fName + "\" not found");
        localObject = null;
      }
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
    return getName() + "(" + getClass().getName() + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     junit.framework.TestCase
 * JD-Core Version:    0.7.0.1
 */