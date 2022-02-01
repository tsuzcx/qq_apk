package org.junit.runners.parameterized;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.model.FrameworkField;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;
import org.junit.runners.model.TestClass;

public class BlockJUnit4ClassRunnerWithParameters
  extends BlockJUnit4ClassRunner
{
  private final String name;
  private final Object[] parameters;
  
  public BlockJUnit4ClassRunnerWithParameters(TestWithParameters paramTestWithParameters)
  {
    super(paramTestWithParameters.getTestClass().getJavaClass());
    this.parameters = paramTestWithParameters.getParameters().toArray(new Object[paramTestWithParameters.getParameters().size()]);
    this.name = paramTestWithParameters.getName();
  }
  
  private Object createTestUsingConstructorInjection()
  {
    return getTestClass().getOnlyConstructor().newInstance(this.parameters);
  }
  
  private Object createTestUsingFieldInjection()
  {
    Object localObject1 = getAnnotatedFieldsByParameter();
    if (((List)localObject1).size() == this.parameters.length)
    {
      Object localObject2 = getTestClass().getJavaClass().newInstance();
      Object localObject3 = ((List)localObject1).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject1 = ((FrameworkField)((Iterator)localObject3).next()).getField();
        int i = ((Parameterized.Parameter)((Field)localObject1).getAnnotation(Parameterized.Parameter.class)).value();
        try
        {
          ((Field)localObject1).set(localObject2, this.parameters[i]);
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(getTestClass().getName());
          ((StringBuilder)localObject3).append(": Trying to set ");
          ((StringBuilder)localObject3).append(((Field)localObject1).getName());
          ((StringBuilder)localObject3).append(" with the value ");
          ((StringBuilder)localObject3).append(this.parameters[i]);
          ((StringBuilder)localObject3).append(" that is not the right type (");
          ((StringBuilder)localObject3).append(this.parameters[i].getClass().getSimpleName());
          ((StringBuilder)localObject3).append(" instead of ");
          ((StringBuilder)localObject3).append(((Field)localObject1).getType().getSimpleName());
          ((StringBuilder)localObject3).append(").");
          throw new Exception(((StringBuilder)localObject3).toString(), localIllegalArgumentException);
        }
      }
      return localIllegalArgumentException;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Wrong number of parameters and @Parameter fields. @Parameter fields counted: ");
    localStringBuilder.append(((List)localObject1).size());
    localStringBuilder.append(", available parameters: ");
    localStringBuilder.append(this.parameters.length);
    localStringBuilder.append(".");
    localObject1 = new Exception(localStringBuilder.toString());
    for (;;)
    {
      throw ((Throwable)localObject1);
    }
  }
  
  private boolean fieldsAreAnnotated()
  {
    return getAnnotatedFieldsByParameter().isEmpty() ^ true;
  }
  
  private List<FrameworkField> getAnnotatedFieldsByParameter()
  {
    return getTestClass().getAnnotatedFields(Parameterized.Parameter.class);
  }
  
  protected Statement classBlock(RunNotifier paramRunNotifier)
  {
    return childrenInvoker(paramRunNotifier);
  }
  
  public Object createTest()
  {
    if (fieldsAreAnnotated()) {
      return createTestUsingFieldInjection();
    }
    return createTestUsingConstructorInjection();
  }
  
  protected String getName()
  {
    return this.name;
  }
  
  protected Annotation[] getRunnerAnnotations()
  {
    return new Annotation[0];
  }
  
  protected String testName(FrameworkMethod paramFrameworkMethod)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramFrameworkMethod.getName());
    localStringBuilder.append(getName());
    return localStringBuilder.toString();
  }
  
  protected void validateConstructor(List<Throwable> paramList)
  {
    validateOnlyOneConstructor(paramList);
    if (fieldsAreAnnotated()) {
      validateZeroArgConstructor(paramList);
    }
  }
  
  protected void validateFields(List<Throwable> paramList)
  {
    super.validateFields(paramList);
    if (fieldsAreAnnotated())
    {
      Object localObject = getAnnotatedFieldsByParameter();
      int[] arrayOfInt = new int[((List)localObject).size()];
      Iterator localIterator = ((List)localObject).iterator();
      while (localIterator.hasNext())
      {
        i = ((Parameterized.Parameter)((FrameworkField)localIterator.next()).getField().getAnnotation(Parameterized.Parameter.class)).value();
        if ((i >= 0) && (i <= ((List)localObject).size() - 1))
        {
          arrayOfInt[i] += 1;
        }
        else
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Invalid @Parameter value: ");
          localStringBuilder.append(i);
          localStringBuilder.append(". @Parameter fields counted: ");
          localStringBuilder.append(((List)localObject).size());
          localStringBuilder.append(". Please use an index between 0 and ");
          localStringBuilder.append(((List)localObject).size() - 1);
          localStringBuilder.append(".");
          paramList.add(new Exception(localStringBuilder.toString()));
        }
      }
      int i = 0;
      while (i < arrayOfInt.length)
      {
        int j = arrayOfInt[i];
        if (j == 0)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("@Parameter(");
          ((StringBuilder)localObject).append(i);
          ((StringBuilder)localObject).append(") is never used.");
          paramList.add(new Exception(((StringBuilder)localObject).toString()));
        }
        else if (j > 1)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("@Parameter(");
          ((StringBuilder)localObject).append(i);
          ((StringBuilder)localObject).append(") is used more than once (");
          ((StringBuilder)localObject).append(j);
          ((StringBuilder)localObject).append(").");
          paramList.add(new Exception(((StringBuilder)localObject).toString()));
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.junit.runners.parameterized.BlockJUnit4ClassRunnerWithParameters
 * JD-Core Version:    0.7.0.1
 */