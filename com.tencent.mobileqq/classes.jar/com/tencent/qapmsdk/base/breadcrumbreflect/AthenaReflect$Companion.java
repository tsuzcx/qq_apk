package com.tencent.qapmsdk.base.breadcrumbreflect;

import com.tencent.qapmsdk.common.logger.Logger;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/breadcrumbreflect/AthenaReflect$Companion;", "", "()V", "TAG", "", "athenaGenerateEvent", "Ljava/lang/reflect/Method;", "athenaInstance", "isBreadCrumb", "", "getBreadCrumbId", "type", "", "info", "Lcom/tencent/qapmsdk/base/breadcrumbreflect/AthenaInfo;", "qapmbase_release"}, k=1, mv={1, 1, 15})
public final class AthenaReflect$Companion
{
  @JvmStatic
  @NotNull
  public final String getBreadCrumbId(int paramInt, @Nullable AthenaInfo paramAthenaInfo)
  {
    for (;;)
    {
      try
      {
        if ((AthenaReflect.access$getAthenaGenerateEvent$cp() == null) && (AthenaReflect.access$getAthenaInstance$cp() == null))
        {
          localObject2 = Class.forName("com.tencent.qapmsdk.athena.BreadCrumb");
          localObject1 = ((Class)localObject2).getDeclaredMethod("isEnable", new Class[0]);
          Method localMethod = ((Class)localObject2).getDeclaredMethod("generateEvent", new Class[] { Integer.TYPE, AthenaInfo.class });
          Object localObject3 = ((Class)localObject2).getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
          if (((Method)localObject1).invoke(localObject3, new Object[0]) != null)
          {
            localObject2 = ((Method)localObject1).invoke(localObject3, new Object[0]);
            localObject1 = localObject2;
            if (!(localObject2 instanceof Boolean)) {
              localObject1 = null;
            }
            localObject1 = (Boolean)localObject1;
            if (localObject1 == null) {
              break label254;
            }
            bool = ((Boolean)localObject1).booleanValue();
            AthenaReflect.access$setBreadCrumb$cp(bool);
          }
          AthenaReflect.access$setAthenaGenerateEvent$cp(localMethod);
          AthenaReflect.access$setAthenaInstance$cp(localObject3);
        }
        if (AthenaReflect.access$isBreadCrumb$cp())
        {
          localObject1 = AthenaReflect.access$getAthenaGenerateEvent$cp();
          if (localObject1 != null)
          {
            paramAthenaInfo = ((Method)localObject1).invoke(AthenaReflect.access$getAthenaInstance$cp(), new Object[] { Integer.valueOf(paramInt), paramAthenaInfo }).toString();
            return paramAthenaInfo;
          }
        }
      }
      catch (Exception paramAthenaInfo)
      {
        Object localObject1 = Logger.INSTANCE;
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("get bread crumb id may be error. ");
        ((StringBuilder)localObject2).append(paramAthenaInfo);
        ((Logger)localObject1).w(new String[] { "QAPM_base_AthenaReflect", ((StringBuilder)localObject2).toString() });
      }
      return "";
      label254:
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.base.breadcrumbreflect.AthenaReflect.Companion
 * JD-Core Version:    0.7.0.1
 */