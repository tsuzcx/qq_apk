package junit.framework;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
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
    if (paramList.contains(str)) {
      return;
    }
    if (!isPublicTestMethod(paramMethod))
    {
      if (isTestMethod(paramMethod))
      {
        paramList = new StringBuilder();
        paramList.append("Test method isn't public: ");
        paramList.append(paramMethod.getName());
        paramList.append("(");
        paramList.append(paramClass.getCanonicalName());
        paramList.append(")");
        addTest(warning(paramList.toString()));
      }
      return;
    }
    paramList.add(str);
    addTest(createTest(paramClass, str));
  }
  
  private void addTestsFromTestCase(Class<?> paramClass)
  {
    this.fName = paramClass.getName();
    try
    {
      getTestConstructor(paramClass);
      if (!Modifier.isPublic(paramClass.getModifiers()))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Class ");
        ((StringBuilder)localObject).append(paramClass.getName());
        ((StringBuilder)localObject).append(" is not public");
        addTest(warning(((StringBuilder)localObject).toString()));
        return;
      }
      ArrayList localArrayList = new ArrayList();
      for (localObject = paramClass; Test.class.isAssignableFrom((Class)localObject); localObject = ((Class)localObject).getSuperclass())
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
      if (this.fTests.size() == 0)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("No tests found in ");
        ((StringBuilder)localObject).append(paramClass.getName());
        addTest(warning(((StringBuilder)localObject).toString()));
      }
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      Object localObject;
      label189:
      break label189;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Class ");
    ((StringBuilder)localObject).append(paramClass.getName());
    ((StringBuilder)localObject).append(" has no public constructor TestCase(String name) or TestCase()");
    addTest(warning(((StringBuilder)localObject).toString()));
  }
  
  public static Test createTest(Class<?> paramClass, String paramString)
  {
    try
    {
      Object localObject = getTestConstructor(paramClass);
      try
      {
        if (((Constructor)localObject).getParameterTypes().length == 0)
        {
          localObject = ((Constructor)localObject).newInstance(new Object[0]);
          paramClass = (Class<?>)localObject;
          if ((localObject instanceof TestCase))
          {
            ((TestCase)localObject).setName(paramString);
            paramClass = (Class<?>)localObject;
          }
        }
        else
        {
          paramClass = ((Constructor)localObject).newInstance(new Object[] { paramString });
        }
        return (Test)paramClass;
      }
      catch (IllegalAccessException paramClass)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Cannot access test case: ");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(" (");
        ((StringBuilder)localObject).append(exceptionToString(paramClass));
        ((StringBuilder)localObject).append(")");
        return warning(((StringBuilder)localObject).toString());
      }
      catch (InvocationTargetException paramClass)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Exception in constructor: ");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(" (");
        ((StringBuilder)localObject).append(exceptionToString(paramClass.getTargetException()));
        ((StringBuilder)localObject).append(")");
        return warning(((StringBuilder)localObject).toString());
      }
      catch (InstantiationException paramClass)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Cannot instantiate test case: ");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(" (");
        ((StringBuilder)localObject).append(exceptionToString(paramClass));
        ((StringBuilder)localObject).append(")");
        return warning(((StringBuilder)localObject).toString());
      }
    }
    catch (NoSuchMethodException paramString)
    {
      label224:
      break label224;
    }
    paramString = new StringBuilder();
    paramString.append("Class ");
    paramString.append(paramClass.getName());
    paramString.append(" has no public constructor TestCase(String name) or TestCase()");
    return warning(paramString.toString());
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
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      label16:
      break label16;
    }
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramClass.getCanonicalName());
    localStringBuilder.append(" does not extend TestCase");
    return warning(localStringBuilder.toString());
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
    int i = 0;
    while (localIterator.hasNext()) {
      i += ((Test)localIterator.next()).countTestCases();
    }
    return i;
  }
  
  public String getName()
  {
    return this.fName;
  }
  
  public void run(TestResult paramTestResult)
  {
    Iterator localIterator = this.fTests.iterator();
    while (localIterator.hasNext())
    {
      Test localTest = (Test)localIterator.next();
      if (paramTestResult.shouldStop()) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     junit.framework.TestSuite
 * JD-Core Version:    0.7.0.1
 */