package com.tencent.viola.bridge;

class NativeInvokeHelper$1
  implements Runnable
{
  NativeInvokeHelper$1(NativeInvokeHelper paramNativeInvokeHelper, Invoker paramInvoker, Object paramObject, Object[] paramArrayOfObject) {}
  
  public void run()
  {
    try
    {
      this.val$invoker.invoke(this.val$target, this.val$params);
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.val$target);
      localStringBuilder.append("Invoker ");
      localStringBuilder.append(this.val$invoker.toString());
      throw new RuntimeException(localStringBuilder.toString(), localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.bridge.NativeInvokeHelper.1
 * JD-Core Version:    0.7.0.1
 */