package com.tencent.plato.core;

public abstract interface IFunction
{
  public abstract void free();
  
  public abstract int getId();
  
  public abstract void invoke(Object... paramVarArgs);
  
  public abstract void invokeAlive(Object... paramVarArgs);
  
  public static abstract interface CallbackInvoker
  {
    public abstract void invokeCallback(int paramInt1, int paramInt2, int paramInt3, Object[] paramArrayOfObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.plato.core.IFunction
 * JD-Core Version:    0.7.0.1
 */