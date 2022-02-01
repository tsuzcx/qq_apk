package com.tencent.mobileqq.javahook;

import com.tencent.mobileqq.javahooksdk.HookMethodCallback;
import com.tencent.mobileqq.javahooksdk.JavaHookBridge;
import com.tencent.mobileqq.javahooksdk.MethodHookParam;

class BitmapOOMHooker$MyHookMethodCallback
  implements HookMethodCallback
{
  private int a;
  
  public BitmapOOMHooker$MyHookMethodCallback(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void afterHookedMethod(MethodHookParam paramMethodHookParam)
  {
    if (paramMethodHookParam.throwable == null) {
      return;
    }
    Throwable localThrowable;
    if (paramMethodHookParam.throwable.getCause() != null) {
      localThrowable = paramMethodHookParam.throwable.getCause();
    } else {
      localThrowable = paramMethodHookParam.throwable;
    }
    if (!(localThrowable instanceof OutOfMemoryError)) {
      return;
    }
    BitmapOOMHooker.b();
    try
    {
      paramMethodHookParam.result = JavaHookBridge.invokeOriginMethod(paramMethodHookParam.method, paramMethodHookParam.thisObject, paramMethodHookParam.args);
      paramMethodHookParam.throwable = null;
      BitmapOOMHooker.a(true, this.a);
      return;
    }
    catch (Exception paramMethodHookParam)
    {
      break label87;
    }
    catch (Error paramMethodHookParam)
    {
      label78:
      break label78;
    }
    BitmapOOMHooker.a(false, this.a);
    return;
    label87:
    BitmapOOMHooker.a(false, this.a);
  }
  
  public void beforeHookedMethod(MethodHookParam paramMethodHookParam) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.javahook.BitmapOOMHooker.MyHookMethodCallback
 * JD-Core Version:    0.7.0.1
 */