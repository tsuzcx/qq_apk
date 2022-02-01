package com.tencent.mobileqq.emosm.web;

import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/emosm/web/RequestModuleManager$Companion;", "", "()V", "TAG", "", "sHandlers", "", "Lcom/tencent/mobileqq/emosm/web/RequestModuleManager$RequestModule;", "getRequestModule", "key", "registerHandler", "", "clazz", "Ljava/lang/Class;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RequestModuleManager$Companion
{
  @JvmStatic
  @Nullable
  public final RequestModuleManager.RequestModule a(@Nullable String paramString)
  {
    return (RequestModuleManager.RequestModule)RequestModuleManager.a().get(paramString);
  }
  
  @JvmStatic
  public final void a(@NotNull Class<?> paramClass)
  {
    Intrinsics.checkParameterIsNotNull(paramClass, "clazz");
    Object localObject2;
    int j;
    int i;
    try
    {
      Object localObject1 = paramClass.newInstance();
      if (localObject1 == null) {
        return;
      }
    }
    catch (Exception localException)
    {
      do
      {
        for (;;)
        {
          QLog.e(RequestModuleManager.a(), 1, "registerHandler new instance error: " + localException);
          localObject2 = null;
        }
        paramClass = paramClass.getDeclaredMethods();
      } while (paramClass == null);
      j = paramClass.length;
      i = 0;
    }
    label67:
    Object localObject3;
    Object localObject4;
    if (i < j)
    {
      localObject3 = paramClass[i];
      localObject4 = (WebRequestRoute)localObject3.getAnnotation(WebRequestRoute.class);
      if ((localObject4 != null) && (RequestModuleManager.a().get(((WebRequestRoute)localObject4).a()) == null)) {
        break label119;
      }
    }
    for (;;)
    {
      i += 1;
      break label67;
      break;
      label119:
      Map localMap = RequestModuleManager.a();
      localObject4 = ((WebRequestRoute)localObject4).a();
      Intrinsics.checkExpressionValueIsNotNull(localObject3, "m");
      localMap.put(localObject4, new RequestModuleManager.RequestModule(localObject3, localObject2));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.RequestModuleManager.Companion
 * JD-Core Version:    0.7.0.1
 */