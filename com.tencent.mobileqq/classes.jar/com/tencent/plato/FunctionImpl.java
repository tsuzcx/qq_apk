package com.tencent.plato;

import com.tencent.plato.core.IFunction;
import com.tencent.plato.core.IFunction.CallbackInvoker;

public class FunctionImpl
  implements IFunction
{
  private final int mCallId;
  private final IFunction.CallbackInvoker mCallbackInvoker;
  private final int mFunctionId;
  
  public FunctionImpl(IFunction.CallbackInvoker paramCallbackInvoker, int paramInt1, int paramInt2)
  {
    this.mCallbackInvoker = paramCallbackInvoker;
    this.mCallId = paramInt1;
    this.mFunctionId = paramInt2;
  }
  
  private void callback(int paramInt, Object[] paramArrayOfObject)
  {
    this.mCallbackInvoker.invokeCallback(this.mCallId, this.mFunctionId, paramInt, paramArrayOfObject);
  }
  
  public void free()
  {
    this.mCallbackInvoker.invokeCallback(this.mCallId, -1, 0, null);
  }
  
  public int getId()
  {
    return this.mFunctionId;
  }
  
  public void invoke(Object... paramVarArgs)
  {
    callback(0, paramVarArgs);
  }
  
  public void invokeAlive(Object... paramVarArgs)
  {
    callback(1, paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.plato.FunctionImpl
 * JD-Core Version:    0.7.0.1
 */