package kotlin.jvm.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/jvm/internal/ClassReference$Companion;", "", "()V", "FUNCTION_CLASSES", "", "Ljava/lang/Class;", "Lkotlin/Function;", "", "classFqNames", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "primitiveFqNames", "primitiveWrapperFqNames", "simpleNames", "getClassQualifiedName", "jClass", "getClassSimpleName", "isInstance", "", "value", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class ClassReference$Companion
{
  @Nullable
  public final String getClassQualifiedName(@NotNull Class<?> paramClass)
  {
    Intrinsics.checkParameterIsNotNull(paramClass, "jClass");
    Object localObject;
    if (paramClass.isAnonymousClass()) {
      localObject = null;
    }
    String str;
    do
    {
      return localObject;
      if (paramClass.isLocalClass()) {
        return null;
      }
      if (paramClass.isArray())
      {
        paramClass = paramClass.getComponentType();
        Intrinsics.checkExpressionValueIsNotNull(paramClass, "componentType");
        if (paramClass.isPrimitive())
        {
          paramClass = (String)ClassReference.access$getClassFqNames$cp().get(paramClass.getName());
          if (paramClass != null) {
            paramClass = paramClass + "Array";
          }
        }
        for (;;)
        {
          localObject = paramClass;
          if (paramClass != null) {
            break;
          }
          return "kotlin.Array";
          paramClass = null;
          continue;
          paramClass = null;
        }
      }
      str = (String)ClassReference.access$getClassFqNames$cp().get(paramClass.getName());
      localObject = str;
    } while (str != null);
    return paramClass.getCanonicalName();
  }
  
  @Nullable
  public final String getClassSimpleName(@NotNull Class<?> paramClass)
  {
    Intrinsics.checkParameterIsNotNull(paramClass, "jClass");
    Object localObject;
    if (paramClass.isAnonymousClass()) {
      localObject = null;
    }
    String str;
    do
    {
      return localObject;
      if (paramClass.isLocalClass())
      {
        str = paramClass.getSimpleName();
        localObject = paramClass.getEnclosingMethod();
        if (localObject != null)
        {
          Intrinsics.checkExpressionValueIsNotNull(str, "name");
          localObject = StringsKt.substringAfter$default(str, ((Method)localObject).getName() + "$", null, 2, null);
          if (localObject != null) {
            paramClass = (Class<?>)localObject;
          }
        }
        for (;;)
        {
          localObject = paramClass;
          if (paramClass != null) {
            break;
          }
          Intrinsics.checkExpressionValueIsNotNull(str, "name");
          return StringsKt.substringAfter$default(str, '$', null, 2, null);
          paramClass = paramClass.getEnclosingConstructor();
          if (paramClass != null)
          {
            Intrinsics.checkExpressionValueIsNotNull(str, "name");
            paramClass = StringsKt.substringAfter$default(str, paramClass.getName() + "$", null, 2, null);
          }
          else
          {
            paramClass = null;
          }
        }
      }
      if (paramClass.isArray())
      {
        paramClass = paramClass.getComponentType();
        Intrinsics.checkExpressionValueIsNotNull(paramClass, "componentType");
        if (paramClass.isPrimitive())
        {
          paramClass = (String)ClassReference.access$getSimpleNames$cp().get(paramClass.getName());
          if (paramClass != null) {
            paramClass = paramClass + "Array";
          }
        }
        for (;;)
        {
          localObject = paramClass;
          if (paramClass != null) {
            break;
          }
          return "Array";
          paramClass = null;
          continue;
          paramClass = null;
        }
      }
      str = (String)ClassReference.access$getSimpleNames$cp().get(paramClass.getName());
      localObject = str;
    } while (str != null);
    return paramClass.getSimpleName();
  }
  
  public final boolean isInstance(@Nullable Object paramObject, @NotNull Class<?> paramClass)
  {
    Intrinsics.checkParameterIsNotNull(paramClass, "jClass");
    Object localObject = ClassReference.access$getFUNCTION_CLASSES$cp();
    if (localObject == null) {
      throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<K, V>");
    }
    localObject = (Integer)((Map)localObject).get(paramClass);
    if (localObject != null) {
      return TypeIntrinsics.isFunctionOfArity(paramObject, ((Number)localObject).intValue());
    }
    localObject = paramClass;
    if (paramClass.isPrimitive()) {
      localObject = JvmClassMappingKt.getJavaObjectType(JvmClassMappingKt.getKotlinClass(paramClass));
    }
    return ((Class)localObject).isInstance(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.jvm.internal.ClassReference.Companion
 * JD-Core Version:    0.7.0.1
 */