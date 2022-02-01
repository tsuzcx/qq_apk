package com.tencent.mobileqq.javahook;

import android.widget.TextView;
import com.tencent.mobileqq.javahooksdk.HookMethodCallback;
import com.tencent.mobileqq.javahooksdk.MethodHookParam;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;

class BlinkHooker$MyHookMethodCallback
  implements HookMethodCallback
{
  int a;
  
  public void afterHookedMethod(MethodHookParam paramMethodHookParam)
  {
    paramMethodHookParam = paramMethodHookParam.thisObject;
    try
    {
      paramMethodHookParam = BlinkHooker.a.get(paramMethodHookParam);
      paramMethodHookParam = (TextView)BlinkHooker.b.get(paramMethodHookParam);
      if (((paramMethodHookParam instanceof ClearableEditText)) && (((ClearableEditText)paramMethodHookParam).a))
      {
        StringBuilder localStringBuilder = new StringBuilder(1024);
        localStringBuilder.append("afterHookedMethod type:");
        localStringBuilder.append(this.a);
        localStringBuilder.append(" ");
        localStringBuilder.append(paramMethodHookParam.getContext().getClass().getSimpleName());
        localStringBuilder.append("@0x");
        localStringBuilder.append(Integer.toHexString(paramMethodHookParam.getContext().hashCode()));
        localStringBuilder.append(" ClearableEditText@0x");
        localStringBuilder.append(Integer.toHexString(paramMethodHookParam.hashCode()));
        QLog.d("ClearableEditText", 2, localStringBuilder.toString());
        return;
      }
    }
    catch (Throwable paramMethodHookParam)
    {
      QLog.e("ClearableEditText", 2, "afterHookedMethod error", paramMethodHookParam);
    }
  }
  
  public void beforeHookedMethod(MethodHookParam paramMethodHookParam) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.javahook.BlinkHooker.MyHookMethodCallback
 * JD-Core Version:    0.7.0.1
 */