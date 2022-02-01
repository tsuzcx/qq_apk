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
    Object localObject1 = null;
    String str = "";
    label256:
    for (;;)
    {
      try
      {
        Object localObject2;
        if ((AthenaReflect.access$getAthenaGenerateEvent$cp() == null) && (AthenaReflect.access$getAthenaInstance$cp() == null))
        {
          Object localObject3 = Class.forName("com.tencent.qapmsdk.athena.BreadCrumb");
          localObject2 = ((Class)localObject3).getDeclaredMethod("isEnable", new Class[0]);
          Method localMethod = ((Class)localObject3).getDeclaredMethod("generateEvent", new Class[] { Integer.TYPE, AthenaInfo.class });
          localObject3 = ((Class)localObject3).getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
          if (((Method)localObject2).invoke(localObject3, new Object[0]) != null)
          {
            localObject2 = ((Method)localObject2).invoke(localObject3, new Object[0]);
            if ((localObject2 instanceof Boolean)) {
              break label256;
            }
            localObject1 = (Boolean)localObject1;
            if (localObject1 != null)
            {
              bool = ((Boolean)localObject1).booleanValue();
              AthenaReflect.access$setBreadCrumb$cp(bool);
            }
          }
          else
          {
            AthenaReflect.access$setAthenaGenerateEvent$cp(localMethod);
            AthenaReflect.access$setAthenaInstance$cp(localObject3);
          }
        }
        else
        {
          localObject1 = str;
          if (AthenaReflect.access$isBreadCrumb$cp())
          {
            localObject1 = AthenaReflect.access$getAthenaGenerateEvent$cp();
            if (localObject1 == null) {
              continue;
            }
            paramAthenaInfo = ((Method)localObject1).invoke(AthenaReflect.access$getAthenaInstance$cp(), new Object[] { Integer.valueOf(paramInt), paramAthenaInfo }).toString();
            localObject1 = paramAthenaInfo;
          }
          return localObject1;
        }
        boolean bool = false;
        continue;
        paramAthenaInfo = "";
        continue;
        localObject1 = localObject2;
      }
      catch (Exception paramAthenaInfo)
      {
        Logger.INSTANCE.w(new String[] { "QAPM_base_AthenaReflect", "get bread crumb id may be error. " + paramAthenaInfo });
        return "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.base.breadcrumbreflect.AthenaReflect.Companion
 * JD-Core Version:    0.7.0.1
 */