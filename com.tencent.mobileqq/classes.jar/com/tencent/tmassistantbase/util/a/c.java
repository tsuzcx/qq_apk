package com.tencent.tmassistantbase.util.a;

import java.lang.reflect.Method;

public abstract class c
{
  private boolean a = true;
  
  public Object a(Object paramObject1, Method paramMethod, Object[] paramArrayOfObject, Object paramObject2)
  {
    return paramObject2;
  }
  
  public abstract String a();
  
  public void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public boolean a(Object paramObject, Method paramMethod, Object... paramVarArgs)
  {
    return true;
  }
  
  public Object b(Object paramObject, Method paramMethod, Object... paramVarArgs)
  {
    paramMethod.setAccessible(true);
    return paramMethod.invoke(paramObject, paramVarArgs);
  }
  
  public boolean b()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tmassistantbase.util.a.c
 * JD-Core Version:    0.7.0.1
 */