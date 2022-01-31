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
    Object localObject2 = getAnnotatedFieldsByParameter();
    if (((List)localObject2).size() != this.parameters.length) {
      throw new Exception("Wrong number of parameters and @Parameter fields. @Parameter fields counted: " + ((List)localObject2).size() + ", available parameters: " + this.parameters.length + ".");
    }
    Object localObject1 = getTestClass().getJavaClass().newInstance();
    Iterator localIterator = ((List)localObject2).iterator();
    while (localIterator.hasNext())
    {
      localObject2 = ((FrameworkField)localIterator.next()).getField();
      int i = ((Parameterized.Parameter)((Field)localObject2).getAnnotation(Parameterized.Parameter.class)).value();
      try
      {
        ((Field)localObject2).set(localObject1, this.parameters[i]);
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        throw new Exception(getTestClass().getName() + ": Trying to set " + ((Field)localObject2).getName() + " with the value " + this.parameters[i] + " that is not the right type (" + this.parameters[i].getClass().getSimpleName() + " instead of " + ((Field)localObject2).getType().getSimpleName() + ").", localIllegalArgumentException);
      }
    }
    return localIllegalArgumentException;
  }
  
  private boolean fieldsAreAnnotated()
  {
    return !getAnnotatedFieldsByParameter().isEmpty();
  }
  
  private List<FrameworkField> getAnnotatedFieldsByParameter()
  {
    return getTestClass().getAnnotatedFields(Parameterized.Parameter.class);
  }
  
  public Statement classBlock(RunNotifier paramRunNotifier)
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
  
  public String getName()
  {
    return this.name;
  }
  
  public Annotation[] getRunnerAnnotations()
  {
    return new Annotation[0];
  }
  
  public String testName(FrameworkMethod paramFrameworkMethod)
  {
    return paramFrameworkMethod.getName() + getName();
  }
  
  public void validateConstructor(List<Throwable> paramList)
  {
    validateOnlyOneConstructor(paramList);
    if (fieldsAreAnnotated()) {
      validateZeroArgConstructor(paramList);
    }
  }
  
  public void validateFields(List<Throwable> paramList)
  {
    super.validateFields(paramList);
    if (fieldsAreAnnotated())
    {
      List localList = getAnnotatedFieldsByParameter();
      int[] arrayOfInt = new int[localList.size()];
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        i = ((Parameterized.Parameter)((FrameworkField)localIterator.next()).getField().getAnnotation(Parameterized.Parameter.class)).value();
        if ((i < 0) || (i > localList.size() - 1)) {
          paramList.add(new Exception("Invalid @Parameter value: " + i + ". @Parameter fields counted: " + localList.size() + ". Please use an index between 0 and " + (localList.size() - 1) + "."));
        } else {
          arrayOfInt[i] += 1;
        }
      }
      int i = 0;
      if (i < arrayOfInt.length)
      {
        int j = arrayOfInt[i];
        if (j == 0) {
          paramList.add(new Exception("@Parameter(" + i + ") is never used."));
        }
        for (;;)
        {
          i += 1;
          break;
          if (j > 1) {
            paramList.add(new Exception("@Parameter(" + i + ") is used more than once (" + j + ")."));
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     org.junit.runners.parameterized.BlockJUnit4ClassRunnerWithParameters
 * JD-Core Version:    0.7.0.1
 */