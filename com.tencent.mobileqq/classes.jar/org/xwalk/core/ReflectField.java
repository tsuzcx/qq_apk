package org.xwalk.core;

import java.lang.reflect.Field;
import java.util.concurrent.RejectedExecutionException;

public class ReflectField
{
  private Class<?> mClass;
  private Field mField;
  private Object mInstance;
  private String mName;
  
  public ReflectField() {}
  
  public ReflectField(Class<?> paramClass, String paramString)
  {
    init(null, paramClass, paramString);
  }
  
  public ReflectField(Object paramObject, String paramString)
  {
    init(paramObject, null, paramString);
  }
  
  public Object get()
  {
    Object localObject = this.mField;
    if (localObject != null)
    {
      try
      {
        localObject = ((Field)localObject).get(this.mInstance);
        return localObject;
      }
      catch (ExceptionInInitializerError localExceptionInInitializerError)
      {
        throw new RuntimeException(localExceptionInInitializerError);
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        throw localIllegalArgumentException;
      }
      catch (NullPointerException localNullPointerException) {}catch (IllegalAccessException localIllegalAccessException) {}
      throw new RejectedExecutionException(localIllegalAccessException);
    }
    throw new UnsupportedOperationException(toString());
  }
  
  public Object getInstance()
  {
    return this.mInstance;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public boolean init(Object paramObject, Class<?> paramClass, String paramString)
  {
    this.mInstance = paramObject;
    if (paramClass == null) {
      if (paramObject != null) {
        paramClass = paramObject.getClass();
      } else {
        paramClass = null;
      }
    }
    this.mClass = paramClass;
    this.mName = paramString;
    this.mField = null;
    paramObject = this.mClass;
    boolean bool = false;
    if (paramObject == null) {
      return false;
    }
    try
    {
      this.mField = paramObject.getField(this.mName);
    }
    catch (NoSuchFieldException paramObject)
    {
      label70:
      label102:
      break label70;
    }
    for (paramObject = this.mClass; paramObject != null; paramObject = paramObject.getSuperclass()) {
      try
      {
        this.mField = paramObject.getDeclaredField(this.mName);
        this.mField.setAccessible(true);
      }
      catch (NoSuchFieldException paramClass)
      {
        break label102;
      }
    }
    if (this.mField != null) {
      bool = true;
    }
    return bool;
  }
  
  public boolean isNull()
  {
    return this.mField == null;
  }
  
  public String toString()
  {
    Object localObject1 = this.mField;
    if (localObject1 != null) {
      return ((Field)localObject1).toString();
    }
    localObject1 = "";
    if (this.mClass != null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append(this.mClass.toString());
      ((StringBuilder)localObject1).append(".");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    Object localObject2 = localObject1;
    if (this.mName != null)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(this.mName);
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    return localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.xwalk.core.ReflectField
 * JD-Core Version:    0.7.0.1
 */