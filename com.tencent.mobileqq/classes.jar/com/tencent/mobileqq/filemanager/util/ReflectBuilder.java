package com.tencent.mobileqq.filemanager.util;

import android.text.TextUtils;
import java.lang.reflect.Method;

public class ReflectBuilder<T>
{
  private int a = 12288;
  private Class<?>[] b;
  private Object[] c;
  private Class<?> d;
  private String e;
  private boolean f;
  private Object g;
  
  ReflectBuilder<T> a(int paramInt)
  {
    this.a = paramInt;
    return this;
  }
  
  ReflectBuilder<T> a(Class<?> paramClass, Object paramObject)
  {
    this.d = paramClass;
    this.g = paramObject;
    return this;
  }
  
  ReflectBuilder<T> a(String paramString)
  {
    this.e = paramString;
    return this;
  }
  
  ReflectBuilder<T> a(boolean paramBoolean)
  {
    this.f = paramBoolean;
    return this;
  }
  
  ReflectBuilder<T> a(Class<?>... paramVarArgs)
  {
    this.b = new Class[paramVarArgs.length];
    System.arraycopy(paramVarArgs, 0, this.b, 0, paramVarArgs.length);
    return this;
  }
  
  ReflectBuilder<T> a(Object... paramVarArgs)
  {
    this.c = new Object[paramVarArgs.length];
    System.arraycopy(paramVarArgs, 0, this.c, 0, paramVarArgs.length);
    return this;
  }
  
  void a()
  {
    if ((this.a == 8192) && (this.d != null) && (this.g != null) && (!TextUtils.isEmpty(this.e)))
    {
      Object localObject = this.b;
      if (localObject.length == this.c.length)
      {
        localObject = this.d.getDeclaredMethod(this.e, (Class[])localObject);
        if (this.f) {
          ((Method)localObject).setAccessible(true);
        }
        ((Method)localObject).invoke(this.g, this.c);
        return;
      }
      throw new ReflectBuilder.WrongParamException();
    }
    throw new ReflectBuilder.WrongParamException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.ReflectBuilder
 * JD-Core Version:    0.7.0.1
 */