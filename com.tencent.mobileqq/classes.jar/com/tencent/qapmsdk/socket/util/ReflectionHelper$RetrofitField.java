package com.tencent.qapmsdk.socket.util;

public class ReflectionHelper$RetrofitField
{
  private Object fieldValue;
  
  ReflectionHelper$RetrofitField(Object paramObject)
  {
    this.fieldValue = paramObject;
  }
  
  public RetrofitField field(String paramString)
  {
    return new RetrofitField(ReflectionHelper.fieldValue(this.fieldValue, paramString));
  }
  
  public Object get()
  {
    return this.fieldValue;
  }
  
  public ReflectionHelper.RetrofitMethod method(String paramString, Class<?>... paramVarArgs)
  {
    return new ReflectionHelper.RetrofitMethod(this.fieldValue, ReflectionHelper.of(this.fieldValue.getClass()).method(paramString, paramVarArgs));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.util.ReflectionHelper.RetrofitField
 * JD-Core Version:    0.7.0.1
 */