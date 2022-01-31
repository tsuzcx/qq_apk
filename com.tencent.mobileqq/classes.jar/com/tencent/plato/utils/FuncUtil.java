package com.tencent.plato.utils;

import com.tencent.plato.core.IFunction;

public class FuncUtil
{
  public static void invoke(IFunction paramIFunction, Object... paramVarArgs)
  {
    if (paramIFunction != null) {
      paramIFunction.invoke(paramVarArgs);
    }
  }
  
  public static void invokeAlive(IFunction paramIFunction, Object... paramVarArgs)
  {
    if (paramIFunction != null) {
      paramIFunction.invokeAlive(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.plato.utils.FuncUtil
 * JD-Core Version:    0.7.0.1
 */