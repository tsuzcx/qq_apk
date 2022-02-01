package org.junit.experimental.theories.internal;

import org.junit.Assume;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.PotentialAssignment;
import org.junit.experimental.theories.PotentialAssignment.CouldNotGenerateValueException;
import org.junit.runners.model.FrameworkMethod;

class AllMembersSupplier$MethodParameterValue
  extends PotentialAssignment
{
  private final FrameworkMethod method;
  
  private AllMembersSupplier$MethodParameterValue(FrameworkMethod paramFrameworkMethod)
  {
    this.method = paramFrameworkMethod;
  }
  
  public String getDescription()
  {
    return this.method.getName();
  }
  
  public Object getValue()
  {
    DataPoint localDataPoint;
    try
    {
      Object localObject = this.method.invokeExplosively(null, new Object[0]);
      return localObject;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      throw new RuntimeException("unexpected: argument length is checked");
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new RuntimeException("unexpected: getMethods returned an inaccessible method");
    }
    catch (Throwable localThrowable)
    {
      localDataPoint = (DataPoint)this.method.getAnnotation(DataPoint.class);
      if (localDataPoint == null) {
        break label68;
      }
    }
    if (!AllMembersSupplier.access$000(localDataPoint.ignoredExceptions(), localThrowable)) {}
    label68:
    for (boolean bool = true;; bool = false)
    {
      Assume.assumeTrue(bool);
      throw new PotentialAssignment.CouldNotGenerateValueException(localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     org.junit.experimental.theories.internal.AllMembersSupplier.MethodParameterValue
 * JD-Core Version:    0.7.0.1
 */