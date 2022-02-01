package kotlin.reflect.jvm;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KCallable;
import kotlin.reflect.KFunction;
import kotlin.reflect.KMutableProperty;
import kotlin.reflect.KMutableProperty.Setter;
import kotlin.reflect.KProperty;
import kotlin.reflect.KProperty.Getter;
import kotlin.reflect.jvm.internal.KCallableImpl;
import kotlin.reflect.jvm.internal.UtilKt;
import kotlin.reflect.jvm.internal.calls.Caller;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"value", "", "isAccessible", "Lkotlin/reflect/KCallable;", "(Lkotlin/reflect/KCallable;)Z", "setAccessible", "(Lkotlin/reflect/KCallable;Z)V", "kotlin-reflection"}, k=2, mv={1, 1, 16})
@JvmName(name="KCallablesJvm")
public final class KCallablesJvm
{
  public static final boolean isAccessible(@NotNull KCallable<?> paramKCallable)
  {
    Intrinsics.checkParameterIsNotNull(paramKCallable, "$this$isAccessible");
    Object localObject2;
    boolean bool;
    if ((paramKCallable instanceof KMutableProperty))
    {
      localObject1 = (KProperty)paramKCallable;
      localObject2 = ReflectJvmMapping.getJavaField((KProperty)localObject1);
      if (localObject2 != null) {
        bool = ((Field)localObject2).isAccessible();
      } else {
        bool = true;
      }
      if (!bool) {
        break label412;
      }
      localObject1 = ReflectJvmMapping.getJavaGetter((KProperty)localObject1);
      if (localObject1 != null) {
        bool = ((Method)localObject1).isAccessible();
      } else {
        bool = true;
      }
      if (!bool) {
        break label412;
      }
      paramKCallable = ReflectJvmMapping.getJavaSetter((KMutableProperty)paramKCallable);
      if (paramKCallable != null) {
        bool = paramKCallable.isAccessible();
      } else {
        bool = true;
      }
      if (!bool) {
        break label412;
      }
    }
    else
    {
      if (!(paramKCallable instanceof KProperty)) {
        break label153;
      }
      paramKCallable = (KProperty)paramKCallable;
      localObject1 = ReflectJvmMapping.getJavaField(paramKCallable);
      if (localObject1 != null) {
        bool = ((Field)localObject1).isAccessible();
      } else {
        bool = true;
      }
      if (!bool) {
        break label412;
      }
      paramKCallable = ReflectJvmMapping.getJavaGetter(paramKCallable);
      if (paramKCallable != null) {
        bool = paramKCallable.isAccessible();
      } else {
        bool = true;
      }
      if (!bool) {
        break label412;
      }
    }
    label153:
    label352:
    do
    {
      for (;;)
      {
        return true;
        if ((paramKCallable instanceof KProperty.Getter))
        {
          localObject1 = ReflectJvmMapping.getJavaField(((KProperty.Getter)paramKCallable).getProperty());
          if (localObject1 != null) {
            bool = ((Field)localObject1).isAccessible();
          } else {
            bool = true;
          }
          if (!bool) {
            break label412;
          }
          paramKCallable = ReflectJvmMapping.getJavaMethod((KFunction)paramKCallable);
          if (paramKCallable != null) {
            bool = paramKCallable.isAccessible();
          } else {
            bool = true;
          }
          if (!bool) {
            break label412;
          }
        }
        else
        {
          if (!(paramKCallable instanceof KMutableProperty.Setter)) {
            break;
          }
          localObject1 = ReflectJvmMapping.getJavaField(((KMutableProperty.Setter)paramKCallable).getProperty());
          if (localObject1 != null) {
            bool = ((Field)localObject1).isAccessible();
          } else {
            bool = true;
          }
          if (!bool) {
            break label412;
          }
          paramKCallable = ReflectJvmMapping.getJavaMethod((KFunction)paramKCallable);
          if (paramKCallable != null) {
            bool = paramKCallable.isAccessible();
          } else {
            bool = true;
          }
          if (!bool) {
            break label412;
          }
        }
      }
      if (!(paramKCallable instanceof KFunction)) {
        break label414;
      }
      localObject2 = (KFunction)paramKCallable;
      localObject1 = ReflectJvmMapping.getJavaMethod((KFunction)localObject2);
      if (localObject1 != null) {
        bool = ((Method)localObject1).isAccessible();
      } else {
        bool = true;
      }
      if (!bool) {
        break;
      }
      paramKCallable = UtilKt.asKCallableImpl(paramKCallable);
      if (paramKCallable != null)
      {
        paramKCallable = paramKCallable.getDefaultCaller();
        if (paramKCallable != null)
        {
          paramKCallable = paramKCallable.getMember();
          break label352;
        }
      }
      paramKCallable = null;
      localObject1 = paramKCallable;
      if (!(paramKCallable instanceof AccessibleObject)) {
        localObject1 = null;
      }
      paramKCallable = (AccessibleObject)localObject1;
      if (paramKCallable != null) {
        bool = paramKCallable.isAccessible();
      } else {
        bool = true;
      }
      if (!bool) {
        break;
      }
      paramKCallable = ReflectJvmMapping.getJavaConstructor((KFunction)localObject2);
      if (paramKCallable != null) {
        bool = paramKCallable.isAccessible();
      } else {
        bool = true;
      }
    } while (bool);
    label412:
    return false;
    label414:
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Unknown callable: ");
    ((StringBuilder)localObject1).append(paramKCallable);
    ((StringBuilder)localObject1).append(" (");
    ((StringBuilder)localObject1).append(paramKCallable.getClass());
    ((StringBuilder)localObject1).append(')');
    paramKCallable = (Throwable)new UnsupportedOperationException(((StringBuilder)localObject1).toString());
    for (;;)
    {
      throw paramKCallable;
    }
  }
  
  public static final void setAccessible(@NotNull KCallable<?> paramKCallable, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramKCallable, "$this$isAccessible");
    Object localObject2;
    if ((paramKCallable instanceof KMutableProperty))
    {
      localObject1 = (KProperty)paramKCallable;
      localObject2 = ReflectJvmMapping.getJavaField((KProperty)localObject1);
      if (localObject2 != null) {
        ((Field)localObject2).setAccessible(paramBoolean);
      }
      localObject1 = ReflectJvmMapping.getJavaGetter((KProperty)localObject1);
      if (localObject1 != null) {
        ((Method)localObject1).setAccessible(paramBoolean);
      }
      paramKCallable = ReflectJvmMapping.getJavaSetter((KMutableProperty)paramKCallable);
      if (paramKCallable != null) {
        paramKCallable.setAccessible(paramBoolean);
      }
    }
    else if ((paramKCallable instanceof KProperty))
    {
      paramKCallable = (KProperty)paramKCallable;
      localObject1 = ReflectJvmMapping.getJavaField(paramKCallable);
      if (localObject1 != null) {
        ((Field)localObject1).setAccessible(paramBoolean);
      }
      paramKCallable = ReflectJvmMapping.getJavaGetter(paramKCallable);
      if (paramKCallable != null) {
        paramKCallable.setAccessible(paramBoolean);
      }
    }
    else if ((paramKCallable instanceof KProperty.Getter))
    {
      localObject1 = ReflectJvmMapping.getJavaField(((KProperty.Getter)paramKCallable).getProperty());
      if (localObject1 != null) {
        ((Field)localObject1).setAccessible(paramBoolean);
      }
      paramKCallable = ReflectJvmMapping.getJavaMethod((KFunction)paramKCallable);
      if (paramKCallable != null) {
        paramKCallable.setAccessible(paramBoolean);
      }
    }
    else if ((paramKCallable instanceof KMutableProperty.Setter))
    {
      localObject1 = ReflectJvmMapping.getJavaField(((KMutableProperty.Setter)paramKCallable).getProperty());
      if (localObject1 != null) {
        ((Field)localObject1).setAccessible(paramBoolean);
      }
      paramKCallable = ReflectJvmMapping.getJavaMethod((KFunction)paramKCallable);
      if (paramKCallable != null) {
        paramKCallable.setAccessible(paramBoolean);
      }
    }
    else
    {
      if (!(paramKCallable instanceof KFunction)) {
        break label295;
      }
      localObject2 = (KFunction)paramKCallable;
      localObject1 = ReflectJvmMapping.getJavaMethod((KFunction)localObject2);
      if (localObject1 != null) {
        ((Method)localObject1).setAccessible(paramBoolean);
      }
      paramKCallable = UtilKt.asKCallableImpl(paramKCallable);
      if (paramKCallable != null)
      {
        paramKCallable = paramKCallable.getDefaultCaller();
        if (paramKCallable != null)
        {
          paramKCallable = paramKCallable.getMember();
          break label255;
        }
      }
      paramKCallable = null;
      label255:
      localObject1 = paramKCallable;
      if (!(paramKCallable instanceof AccessibleObject)) {
        localObject1 = null;
      }
      paramKCallable = (AccessibleObject)localObject1;
      if (paramKCallable != null) {
        paramKCallable.setAccessible(true);
      }
      paramKCallable = ReflectJvmMapping.getJavaConstructor((KFunction)localObject2);
      if (paramKCallable != null) {
        paramKCallable.setAccessible(paramBoolean);
      }
    }
    return;
    label295:
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Unknown callable: ");
    ((StringBuilder)localObject1).append(paramKCallable);
    ((StringBuilder)localObject1).append(" (");
    ((StringBuilder)localObject1).append(paramKCallable.getClass());
    ((StringBuilder)localObject1).append(')');
    throw ((Throwable)new UnsupportedOperationException(((StringBuilder)localObject1).toString()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.KCallablesJvm
 * JD-Core Version:    0.7.0.1
 */