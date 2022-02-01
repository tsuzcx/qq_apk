package com.tencent.mobileqq.vas.api.impl;

import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/api/impl/VasServiceImpl$DynamicProxy;", "Ljava/lang/reflect/InvocationHandler;", "o", "", "(Ljava/lang/Object;)V", "invoke", "proxy", "method", "Ljava/lang/reflect/Method;", "args", "", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", "vas-impl_release"}, k=1, mv={1, 1, 16})
final class VasServiceImpl$DynamicProxy
  implements InvocationHandler
{
  private final Object a;
  
  @NotNull
  public Object invoke(@NotNull Object paramObject, @NotNull Method paramMethod, @Nullable Object[] paramArrayOfObject)
  {
    Intrinsics.checkParameterIsNotNull(paramObject, "proxy");
    Intrinsics.checkParameterIsNotNull(paramMethod, "method");
    QLog.i("VasServiceImpl", 1, "call " + paramMethod.getName() + " at " + VasServiceImpl.access$getPROCESS_NAME$cp());
    if (paramArrayOfObject != null) {
      if (paramArrayOfObject.length != 0) {
        break label89;
      }
    }
    label89:
    for (int i = 1; i != 0; i = 0)
    {
      paramObject = paramMethod.invoke(this.a, new Object[0]);
      Intrinsics.checkExpressionValueIsNotNull(paramObject, "method.invoke(o)");
      return paramObject;
    }
    paramObject = paramMethod.invoke(this.a, new Object[] { paramArrayOfObject });
    Intrinsics.checkExpressionValueIsNotNull(paramObject, "method.invoke(o, args)");
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.api.impl.VasServiceImpl.DynamicProxy
 * JD-Core Version:    0.7.0.1
 */