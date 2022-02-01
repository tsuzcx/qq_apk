package com.tencent.mobileqq.emosm.web;

import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/emosm/web/RequestModuleManager$RequestModule;", "", "method", "Ljava/lang/reflect/Method;", "object", "(Ljava/lang/reflect/Method;Ljava/lang/Object;)V", "getMethod", "()Ljava/lang/reflect/Method;", "setMethod", "(Ljava/lang/reflect/Method;)V", "getObject", "()Ljava/lang/Object;", "setObject", "(Ljava/lang/Object;)V", "callMethod", "", "params", "Lcom/tencent/mobileqq/emosm/web/RequestParams;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RequestModuleManager$RequestModule
{
  @NotNull
  private Object jdField_a_of_type_JavaLangObject;
  @NotNull
  private Method jdField_a_of_type_JavaLangReflectMethod;
  
  public RequestModuleManager$RequestModule(@NotNull Method paramMethod, @NotNull Object paramObject)
  {
    this.jdField_a_of_type_JavaLangReflectMethod = paramMethod;
    this.jdField_a_of_type_JavaLangObject = paramObject;
  }
  
  public final void a(@NotNull RequestParams paramRequestParams)
  {
    Intrinsics.checkParameterIsNotNull(paramRequestParams, "params");
    this.jdField_a_of_type_JavaLangReflectMethod.invoke(this.jdField_a_of_type_JavaLangObject, new Object[] { paramRequestParams });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.RequestModuleManager.RequestModule
 * JD-Core Version:    0.7.0.1
 */