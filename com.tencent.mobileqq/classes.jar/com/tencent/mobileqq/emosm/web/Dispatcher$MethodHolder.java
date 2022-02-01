package com.tencent.mobileqq.emosm.web;

import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/emosm/web/Dispatcher$MethodHolder;", "T", "", "method", "Ljava/lang/reflect/Method;", "object", "(Ljava/lang/reflect/Method;Ljava/lang/Object;)V", "getMethod", "()Ljava/lang/reflect/Method;", "setMethod", "(Ljava/lang/reflect/Method;)V", "getObject", "()Ljava/lang/Object;", "setObject", "(Ljava/lang/Object;)V", "apply", "", "params", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class Dispatcher$MethodHolder<T>
{
  @NotNull
  private Object jdField_a_of_type_JavaLangObject;
  @NotNull
  private Method jdField_a_of_type_JavaLangReflectMethod;
  
  public Dispatcher$MethodHolder(@NotNull Method paramMethod, @NotNull Object paramObject)
  {
    this.jdField_a_of_type_JavaLangReflectMethod = paramMethod;
    this.jdField_a_of_type_JavaLangObject = paramObject;
  }
  
  public final void a(T paramT)
  {
    try
    {
      this.jdField_a_of_type_JavaLangReflectMethod.invoke(this.jdField_a_of_type_JavaLangObject, new Object[] { paramT });
      return;
    }
    catch (Exception paramT)
    {
      if ((paramT instanceof InvocationTargetException))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("apply exception : ");
        paramT = (InvocationTargetException)paramT;
        localStringBuilder.append(paramT.getTargetException());
        localStringBuilder.append(" stack :");
        localStringBuilder.append(MsfSdkUtils.getStackTraceString(paramT.getTargetException()));
        QLog.e("Dispatcher", 1, localStringBuilder.toString());
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("apply exception : ");
      localStringBuilder.append(paramT);
      QLog.e("Dispatcher", 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.Dispatcher.MethodHolder
 * JD-Core Version:    0.7.0.1
 */