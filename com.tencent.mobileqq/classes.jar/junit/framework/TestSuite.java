package junit.framework;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import org.junit.internal.MethodSorter;

public class TestSuite
  implements Test
{
  private String fName;
  private Vector<Test> fTests = new Vector(10);
  
  public TestSuite() {}
  
  public TestSuite(Class<?> paramClass)
  {
    addTestsFromTestCase(paramClass);
  }
  
  public TestSuite(Class<? extends TestCase> paramClass, String paramString)
  {
    this(paramClass);
    setName(paramString);
  }
  
  public TestSuite(String paramString)
  {
    setName(paramString);
  }
  
  public TestSuite(Class<?>... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      addTest(testCaseForClass(paramVarArgs[i]));
      i += 1;
    }
  }
  
  public TestSuite(Class<? extends TestCase>[] paramArrayOfClass, String paramString)
  {
    this(paramArrayOfClass);
    setName(paramString);
  }
  
  private void addTestMethod(Method paramMethod, List<String> paramList, Class<?> paramClass)
  {
    String str = paramMethod.getName();
    if (paramList.contains(str)) {}
    do
    {
      return;
      if (isPublicTestMethod(paramMethod)) {
        break;
      }
    } while (!isTestMethod(paramMethod));
    addTest(warning("Test method isn't public: " + paramMethod.getName() + "(" + paramClass.getCanonicalName() + ")"));
    return;
    paramList.add(str);
    addTest(createTest(paramClass, str));
  }
  
  private void addTestsFromTestCase(Class<?> paramClass)
  {
    this.fName = paramClass.getName();
    do
    {
      try
      {
        getTestConstructor(paramClass);
        if (!Modifier.isPublic(paramClass.getModifiers()))
        {
          addTest(warning("Class " + paramClass.getName() + " is not public"));
          return;
        }
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        addTest(warning("Class " + paramClass.getName() + " has no public constructor TestCase(String name) or TestCase()"));
        return;
      }
      ArrayList localArrayList = new ArrayList();
      for (Object localObject = paramClass; Test.class.isAssignableFrom((Class)localObject); localObject = ((Class)localObject).getSuperclass())
      {
        Method[] arrayOfMethod = MethodSorter.getDeclaredMethods((Class)localObject);
        int j = arrayOfMethod.length;
        int i = 0;
        while (i < j)
        {
          addTestMethod(arrayOfMethod[i], localArrayList, paramClass);
          i += 1;
        }
      }
    } while (this.fTests.size() != 0);
    addTest(warning("No tests found in " + paramClass.getName()));
  }
  
  /* Error */
  public static Test createTest(Class<?> paramClass, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 114	junit/framework/TestSuite:getTestConstructor	(Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   4: astore_2
    //   5: aload_2
    //   6: invokevirtual 166	java/lang/reflect/Constructor:getParameterTypes	()[Ljava/lang/Class;
    //   9: arraylength
    //   10: ifne +64 -> 74
    //   13: aload_2
    //   14: iconst_0
    //   15: anewarray 4	java/lang/Object
    //   18: invokevirtual 170	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   21: astore_0
    //   22: aload_0
    //   23: instanceof 172
    //   26: ifeq +190 -> 216
    //   29: aload_0
    //   30: checkcast 172	junit/framework/TestCase
    //   33: aload_1
    //   34: invokevirtual 173	junit/framework/TestCase:setName	(Ljava/lang/String;)V
    //   37: aload_0
    //   38: checkcast 6	junit/framework/Test
    //   41: areturn
    //   42: astore_1
    //   43: new 74	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   50: ldc 126
    //   52: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: aload_0
    //   56: invokevirtual 108	java/lang/Class:getName	()Ljava/lang/String;
    //   59: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: ldc 130
    //   64: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: invokestatic 97	junit/framework/TestSuite:warning	(Ljava/lang/String;)Ljunit/framework/Test;
    //   73: areturn
    //   74: aload_2
    //   75: iconst_1
    //   76: anewarray 4	java/lang/Object
    //   79: dup
    //   80: iconst_0
    //   81: aload_1
    //   82: aastore
    //   83: invokevirtual 170	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   86: astore_0
    //   87: goto -50 -> 37
    //   90: astore_0
    //   91: new 74	java/lang/StringBuilder
    //   94: dup
    //   95: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   98: ldc 175
    //   100: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: aload_1
    //   104: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: ldc 177
    //   109: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: aload_0
    //   113: invokestatic 181	junit/framework/TestSuite:exceptionToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   116: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: ldc 90
    //   121: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   127: invokestatic 97	junit/framework/TestSuite:warning	(Ljava/lang/String;)Ljunit/framework/Test;
    //   130: areturn
    //   131: astore_0
    //   132: new 74	java/lang/StringBuilder
    //   135: dup
    //   136: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   139: ldc 183
    //   141: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: aload_1
    //   145: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: ldc 177
    //   150: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: aload_0
    //   154: invokevirtual 187	java/lang/reflect/InvocationTargetException:getTargetException	()Ljava/lang/Throwable;
    //   157: invokestatic 181	junit/framework/TestSuite:exceptionToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   160: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: ldc 90
    //   165: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: invokestatic 97	junit/framework/TestSuite:warning	(Ljava/lang/String;)Ljunit/framework/Test;
    //   174: areturn
    //   175: astore_0
    //   176: new 74	java/lang/StringBuilder
    //   179: dup
    //   180: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   183: ldc 189
    //   185: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: aload_1
    //   189: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: ldc 177
    //   194: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: aload_0
    //   198: invokestatic 181	junit/framework/TestSuite:exceptionToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   201: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: ldc 90
    //   206: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   212: invokestatic 97	junit/framework/TestSuite:warning	(Ljava/lang/String;)Ljunit/framework/Test;
    //   215: areturn
    //   216: goto -179 -> 37
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	219	0	paramClass	Class<?>
    //   0	219	1	paramString	String
    //   4	71	2	localConstructor	Constructor
    // Exception table:
    //   from	to	target	type
    //   0	5	42	java/lang/NoSuchMethodException
    //   5	37	90	java/lang/InstantiationException
    //   74	87	90	java/lang/InstantiationException
    //   5	37	131	java/lang/reflect/InvocationTargetException
    //   74	87	131	java/lang/reflect/InvocationTargetException
    //   5	37	175	java/lang/IllegalAccessException
    //   74	87	175	java/lang/IllegalAccessException
  }
  
  private static String exceptionToString(Throwable paramThrowable)
  {
    StringWriter localStringWriter = new StringWriter();
    paramThrowable.printStackTrace(new PrintWriter(localStringWriter));
    return localStringWriter.toString();
  }
  
  public static Constructor<?> getTestConstructor(Class<?> paramClass)
  {
    try
    {
      Constructor localConstructor = paramClass.getConstructor(new Class[] { String.class });
      return localConstructor;
    }
    catch (NoSuchMethodException localNoSuchMethodException) {}
    return paramClass.getConstructor(new Class[0]);
  }
  
  private boolean isPublicTestMethod(Method paramMethod)
  {
    return (isTestMethod(paramMethod)) && (Modifier.isPublic(paramMethod.getModifiers()));
  }
  
  private boolean isTestMethod(Method paramMethod)
  {
    return (paramMethod.getParameterTypes().length == 0) && (paramMethod.getName().startsWith("test")) && (paramMethod.getReturnType().equals(Void.TYPE));
  }
  
  private Test testCaseForClass(Class<?> paramClass)
  {
    if (TestCase.class.isAssignableFrom(paramClass)) {
      return new TestSuite(paramClass.asSubclass(TestCase.class));
    }
    return warning(paramClass.getCanonicalName() + " does not extend TestCase");
  }
  
  public static Test warning(String paramString)
  {
    return new TestSuite.1("warning", paramString);
  }
  
  public void addTest(Test paramTest)
  {
    this.fTests.add(paramTest);
  }
  
  public void addTestSuite(Class<? extends TestCase> paramClass)
  {
    addTest(new TestSuite(paramClass));
  }
  
  public int countTestCases()
  {
    Iterator localIterator = this.fTests.iterator();
    for (int i = 0; localIterator.hasNext(); i = ((Test)localIterator.next()).countTestCases() + i) {}
    return i;
  }
  
  public String getName()
  {
    return this.fName;
  }
  
  public void run(TestResult paramTestResult)
  {
    Iterator localIterator = this.fTests.iterator();
    for (;;)
    {
      Test localTest;
      if (localIterator.hasNext())
      {
        localTest = (Test)localIterator.next();
        if (!paramTestResult.shouldStop()) {}
      }
      else
      {
        return;
      }
      runTest(localTest, paramTestResult);
    }
  }
  
  public void runTest(Test paramTest, TestResult paramTestResult)
  {
    paramTest.run(paramTestResult);
  }
  
  public void setName(String paramString)
  {
    this.fName = paramString;
  }
  
  public Test testAt(int paramInt)
  {
    return (Test)this.fTests.get(paramInt);
  }
  
  public int testCount()
  {
    return this.fTests.size();
  }
  
  public Enumeration<Test> tests()
  {
    return this.fTests.elements();
  }
  
  public String toString()
  {
    if (getName() != null) {
      return getName();
    }
    return super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     junit.framework.TestSuite
 * JD-Core Version:    0.7.0.1
 */