package org.junit.runners.model;

import java.lang.reflect.Modifier;
import java.util.Iterator;
import java.util.List;

public abstract class FrameworkMember<T extends FrameworkMember<T>>
  implements Annotatable
{
  public abstract Class<?> getDeclaringClass();
  
  protected abstract int getModifiers();
  
  public abstract String getName();
  
  public abstract Class<?> getType();
  
  public boolean isPublic()
  {
    return Modifier.isPublic(getModifiers());
  }
  
  boolean isShadowedBy(List<T> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (isShadowedBy((FrameworkMember)paramList.next())) {
        return true;
      }
    }
    return false;
  }
  
  abstract boolean isShadowedBy(T paramT);
  
  public boolean isStatic()
  {
    return Modifier.isStatic(getModifiers());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     org.junit.runners.model.FrameworkMember
 * JD-Core Version:    0.7.0.1
 */