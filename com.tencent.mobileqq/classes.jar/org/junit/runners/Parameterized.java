package org.junit.runners;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.junit.runner.Runner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.TestClass;
import org.junit.runners.parameterized.BlockJUnit4ClassRunnerWithParametersFactory;
import org.junit.runners.parameterized.ParametersRunnerFactory;
import org.junit.runners.parameterized.TestWithParameters;

public class Parameterized
  extends Suite
{
  private static final ParametersRunnerFactory DEFAULT_FACTORY = new BlockJUnit4ClassRunnerWithParametersFactory();
  private static final List<Runner> NO_RUNNERS = Collections.emptyList();
  private final List<Runner> runners;
  
  public Parameterized(Class<?> paramClass)
  {
    super(paramClass, NO_RUNNERS);
    paramClass = getParametersRunnerFactory(paramClass);
    Parameterized.Parameters localParameters = (Parameterized.Parameters)getParametersMethod().getAnnotation(Parameterized.Parameters.class);
    this.runners = Collections.unmodifiableList(createRunnersForParameters(allParameters(), localParameters.name(), paramClass));
  }
  
  private Iterable<Object> allParameters()
  {
    Object localObject = getParametersMethod().invokeExplosively(null, new Object[0]);
    if ((localObject instanceof Iterable)) {
      return (Iterable)localObject;
    }
    if ((localObject instanceof Object[])) {
      return Arrays.asList((Object[])localObject);
    }
    throw parametersMethodReturnedWrongType();
  }
  
  private List<Runner> createRunnersForParameters(Iterable<Object> paramIterable, String paramString, ParametersRunnerFactory paramParametersRunnerFactory)
  {
    try
    {
      paramString = createTestsForParameters(paramIterable, paramString);
      paramIterable = new ArrayList();
      paramString = paramString.iterator();
      while (paramString.hasNext()) {
        paramIterable.add(paramParametersRunnerFactory.createRunnerForTestWithParameters((TestWithParameters)paramString.next()));
      }
      return paramIterable;
    }
    catch (ClassCastException paramIterable)
    {
      label58:
      break label58;
    }
    paramIterable = parametersMethodReturnedWrongType();
    for (;;)
    {
      throw paramIterable;
    }
  }
  
  private TestWithParameters createTestWithNotNormalizedParameters(String paramString, int paramInt, Object paramObject)
  {
    if ((paramObject instanceof Object[])) {
      paramObject = (Object[])paramObject;
    } else {
      paramObject = new Object[] { paramObject };
    }
    return createTestWithParameters(getTestClass(), paramString, paramInt, paramObject);
  }
  
  private static TestWithParameters createTestWithParameters(TestClass paramTestClass, String paramString, int paramInt, Object[] paramArrayOfObject)
  {
    paramString = MessageFormat.format(paramString.replaceAll("\\{index\\}", Integer.toString(paramInt)), paramArrayOfObject);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("]");
    return new TestWithParameters(localStringBuilder.toString(), paramTestClass, Arrays.asList(paramArrayOfObject));
  }
  
  private List<TestWithParameters> createTestsForParameters(Iterable<Object> paramIterable, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramIterable = paramIterable.iterator();
    int i = 0;
    while (paramIterable.hasNext())
    {
      localArrayList.add(createTestWithNotNormalizedParameters(paramString, i, paramIterable.next()));
      i += 1;
    }
    return localArrayList;
  }
  
  private FrameworkMethod getParametersMethod()
  {
    Object localObject = getTestClass().getAnnotatedMethods(Parameterized.Parameters.class).iterator();
    while (((Iterator)localObject).hasNext())
    {
      FrameworkMethod localFrameworkMethod = (FrameworkMethod)((Iterator)localObject).next();
      if ((localFrameworkMethod.isStatic()) && (localFrameworkMethod.isPublic())) {
        return localFrameworkMethod;
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("No public static parameters method on class ");
    ((StringBuilder)localObject).append(getTestClass().getName());
    localObject = new Exception(((StringBuilder)localObject).toString());
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  private ParametersRunnerFactory getParametersRunnerFactory(Class<?> paramClass)
  {
    paramClass = (Parameterized.UseParametersRunnerFactory)paramClass.getAnnotation(Parameterized.UseParametersRunnerFactory.class);
    if (paramClass == null) {
      return DEFAULT_FACTORY;
    }
    return (ParametersRunnerFactory)paramClass.value().newInstance();
  }
  
  private Exception parametersMethodReturnedWrongType()
  {
    return new Exception(MessageFormat.format("{0}.{1}() must return an Iterable of arrays.", new Object[] { getTestClass().getName(), getParametersMethod().getName() }));
  }
  
  protected List<Runner> getChildren()
  {
    return this.runners;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.junit.runners.Parameterized
 * JD-Core Version:    0.7.0.1
 */