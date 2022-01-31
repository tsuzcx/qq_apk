package org.junit.runners.model;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.List;

public class FrameworkMethod
  extends FrameworkMember<FrameworkMethod>
{
  private final Method method;
  
  public FrameworkMethod(Method paramMethod)
  {
    if (paramMethod == null) {
      throw new NullPointerException("FrameworkMethod cannot be created without an underlying method.");
    }
    this.method = paramMethod;
  }
  
  private Class<?>[] getParameterTypes()
  {
    return this.method.getParameterTypes();
  }
  
  public boolean equals(Object paramObject)
  {
    if (!FrameworkMethod.class.isInstance(paramObject)) {
      return false;
    }
    return ((FrameworkMethod)paramObject).method.equals(this.method);
  }
  
  public <T extends Annotation> T getAnnotation(Class<T> paramClass)
  {
    return this.method.getAnnotation(paramClass);
  }
  
  public Annotation[] getAnnotations()
  {
    return this.method.getAnnotations();
  }
  
  public Class<?> getDeclaringClass()
  {
    return this.method.getDeclaringClass();
  }
  
  public Method getMethod()
  {
    return this.method;
  }
  
  protected int getModifiers()
  {
    return this.method.getModifiers();
  }
  
  public String getName()
  {
    return this.method.getName();
  }
  
  public Class<?> getReturnType()
  {
    return this.method.getReturnType();
  }
  
  public Class<?> getType()
  {
    return getReturnType();
  }
  
  public int hashCode()
  {
    return this.method.hashCode();
  }
  
  public Object invokeExplosively(Object paramObject, Object... paramVarArgs)
  {
    return new FrameworkMethod.1(this, paramObject, paramVarArgs).run();
  }
  
  public boolean isShadowedBy(FrameworkMethod paramFrameworkMethod)
  {
    if (!paramFrameworkMethod.getName().equals(getName())) {}
    while (paramFrameworkMethod.getParameterTypes().length != getParameterTypes().length) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramFrameworkMethod.getParameterTypes().length) {
        break label65;
      }
      if (!paramFrameworkMethod.getParameterTypes()[i].equals(getParameterTypes()[i])) {
        break;
      }
      i += 1;
    }
    label65:
    return true;
  }
  
  @Deprecated
  public boolean producesType(Type paramType)
  {
    return (getParameterTypes().length == 0) && ((paramType instanceof Class)) && (((Class)paramType).isAssignableFrom(this.method.getReturnType()));
  }
  
  public String toString()
  {
    return this.method.toString();
  }
  
  public void validateNoTypeParametersOnArgs(List<Throwable> paramList)
  {
    new NoGenericTypeParametersValidator(this.method).validate(paramList);
  }
  
  public void validatePublicVoid(boolean paramBoolean, List<Throwable> paramList)
  {
    if (isStatic() != paramBoolean) {
      if (!paramBoolean) {
        break label177;
      }
    }
    label177:
    for (String str = "should";; str = "should not")
    {
      paramList.add(new Exception("Method " + this.method.getName() + "() " + str + " be static"));
      if (!isPublic()) {
        paramList.add(new Exception("Method " + this.method.getName() + "() should be public"));
      }
      if (this.method.getReturnType() != Void.TYPE) {
        paramList.add(new Exception("Method " + this.method.getName() + "() should be void"));
      }
      return;
    }
  }
  
  public void validatePublicVoidNoArg(boolean paramBoolean, List<Throwable> paramList)
  {
    validatePublicVoid(paramBoolean, paramList);
    if (this.method.getParameterTypes().length != 0) {
      paramList.add(new Exception("Method " + this.method.getName() + " should have no parameters"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     org.junit.runners.model.FrameworkMethod
 * JD-Core Version:    0.7.0.1
 */