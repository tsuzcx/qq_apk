package com.tencent.plato.core;

public abstract interface IExportedMethod
{
  public abstract String getName();
  
  public abstract Class[] getParameterTypes();
  
  public abstract <T extends IExportedModule> Object invoke(T paramT, Object... paramVarArgs);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.plato.core.IExportedMethod
 * JD-Core Version:    0.7.0.1
 */