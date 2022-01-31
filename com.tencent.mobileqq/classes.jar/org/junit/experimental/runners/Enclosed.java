package org.junit.experimental.runners;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import org.junit.runners.Suite;
import org.junit.runners.model.RunnerBuilder;

public class Enclosed
  extends Suite
{
  public Enclosed(Class<?> paramClass, RunnerBuilder paramRunnerBuilder)
  {
    super(paramRunnerBuilder, paramClass, filterAbstractClasses(paramClass.getClasses()));
  }
  
  private static Class<?>[] filterAbstractClasses(Class<?>[] paramArrayOfClass)
  {
    ArrayList localArrayList = new ArrayList(paramArrayOfClass.length);
    int j = paramArrayOfClass.length;
    int i = 0;
    while (i < j)
    {
      Class<?> localClass = paramArrayOfClass[i];
      if (!Modifier.isAbstract(localClass.getModifiers())) {
        localArrayList.add(localClass);
      }
      i += 1;
    }
    return (Class[])localArrayList.toArray(new Class[localArrayList.size()]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     org.junit.experimental.runners.Enclosed
 * JD-Core Version:    0.7.0.1
 */