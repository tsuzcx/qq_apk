package com.tencent.mobileqq.javahook;

import com.tencent.mobileqq.javahooksdk.MethodHookParam;
import com.tencent.mobileqq.javahooksdk.ReplaceMethodCallback;

class TimeoutExceptionHooker$MyReplaceMethodCallback
  implements ReplaceMethodCallback
{
  public void replaceMethod(MethodHookParam paramMethodHookParam)
  {
    TimeoutExceptionHooker.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.javahook.TimeoutExceptionHooker.MyReplaceMethodCallback
 * JD-Core Version:    0.7.0.1
 */