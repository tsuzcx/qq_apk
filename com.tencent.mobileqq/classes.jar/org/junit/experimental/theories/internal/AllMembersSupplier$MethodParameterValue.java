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
    boolean bool = false;
    try
    {
      Object localObject = this.method.invokeExplosively(null, new Object[0]);
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      DataPoint localDataPoint = (DataPoint)this.method.getAnnotation(DataPoint.class);
      if ((localDataPoint == null) || (!AllMembersSupplier.access$000(localDataPoint.ignoredExceptions(), localThrowable))) {
        bool = true;
      }
      Assume.assumeTrue(bool);
      throw new PotentialAssignment.CouldNotGenerateValueException(localThrowable);
      throw new RuntimeException("unexpected: getMethods returned an inaccessible method");
      throw new RuntimeException("unexpected: argument length is checked");
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      break label73;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      label63:
      label73:
      break label63;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.junit.experimental.theories.internal.AllMembersSupplier.MethodParameterValue
 * JD-Core Version:    0.7.0.1
 */