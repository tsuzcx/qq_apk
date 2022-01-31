package com.tencent.qapmsdk.socket.util;

public class ReflectionHelper$RetrofitCache
{
  private Object cacheInstance;
  
  ReflectionHelper$RetrofitCache(Object paramObject)
  {
    this.cacheInstance = paramObject;
  }
  
  public ReflectionHelper.RetrofitField field(String paramString)
  {
    return new ReflectionHelper.RetrofitField(ReflectionHelper.fieldValue(this.cacheInstance, paramString));
  }
  
  public ReflectionHelper.RetrofitMethod method(String paramString, Class<?>... paramVarArgs)
  {
    return new ReflectionHelper.RetrofitMethod(this.cacheInstance, ReflectionHelper.of(this.cacheInstance.getClass()).method(paramString, paramVarArgs));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.util.ReflectionHelper.RetrofitCache
 * JD-Core Version:    0.7.0.1
 */