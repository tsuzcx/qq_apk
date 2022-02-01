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
    boolean bool = paramClass.isAnonymousClass();
    String str = null;
    if (bool) {
      return null;
    }
    if (paramClass.isLocalClass()) {
      return null;
    }
    if (paramClass.isArray())
    {
      Object localObject = paramClass.getComponentType();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "componentType");
      paramClass = str;
      if (((Class)localObject).isPrimitive())
      {
        localObject = (String)ClassReference.access$getClassFqNames$cp().get(((Class)localObject).getName());
        paramClass = str;
        if (localObject != null)
        {
          paramClass = new StringBuilder();
          paramClass.append((String)localObject);
          paramClass.append("Array");
          paramClass = paramClass.toString();
        }
      }
      if (paramClass != null) {
        return paramClass;
      }
      return "kotlin.Array";
    }
    str = (String)ClassReference.access$getClassFqNames$cp().get(paramClass.getName());
    if (str != null) {
      return str;
    }
    return paramClass.getCanonicalName();
  }
  
  @Nullable
  public final String getClassSimpleName(@NotNull Class<?> paramClass)
  {
    Intrinsics.checkParameterIsNotNull(paramClass, "jClass");
    boolean bool = paramClass.isAnonymousClass();
    Object localObject1 = "Array";
    String str = null;
    Object localObject2 = null;
    if (bool) {
      paramClass = (Class<?>)localObject2;
    }
    for (;;)
    {
      return paramClass;
      if (paramClass.isLocalClass())
      {
        str = paramClass.getSimpleName();
        localObject1 = paramClass.getEnclosingMethod();
        if (localObject1 != null)
        {
          Intrinsics.checkExpressionValueIsNotNull(str, "name");
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(((Method)localObject1).getName());
          ((StringBuilder)localObject2).append("$");
          localObject1 = StringsKt.substringAfter$default(str, ((StringBuilder)localObject2).toString(), null, 2, null);
          if (localObject1 != null)
          {
            paramClass = (Class<?>)localObject1;
            break label166;
          }
        }
        paramClass = paramClass.getEnclosingConstructor();
        if (paramClass != null)
        {
          Intrinsics.checkExpressionValueIsNotNull(str, "name");
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(paramClass.getName());
          ((StringBuilder)localObject1).append("$");
          paramClass = StringsKt.substringAfter$default(str, ((StringBuilder)localObject1).toString(), null, 2, null);
        }
        else
        {
          paramClass = null;
        }
        label166:
        if (paramClass != null) {
          return paramClass;
        }
        Intrinsics.checkExpressionValueIsNotNull(str, "name");
        return StringsKt.substringAfter$default(str, '$', null, 2, null);
      }
      if (!paramClass.isArray()) {
        break;
      }
      localObject2 = paramClass.getComponentType();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "componentType");
      paramClass = str;
      if (((Class)localObject2).isPrimitive())
      {
        localObject2 = (String)ClassReference.access$getSimpleNames$cp().get(((Class)localObject2).getName());
        paramClass = str;
        if (localObject2 != null)
        {
          paramClass = new StringBuilder();
          paramClass.append((String)localObject2);
          paramClass.append("Array");
          paramClass = paramClass.toString();
        }
      }
      if (paramClass == null) {
        return localObject1;
      }
    }
    localObject1 = (String)ClassReference.access$getSimpleNames$cp().get(paramClass.getName());
    if (localObject1 != null) {
      return localObject1;
    }
    localObject1 = paramClass.getSimpleName();
    return localObject1;
  }
  
  public final boolean isInstance(@Nullable Object paramObject, @NotNull Class<?> paramClass)
  {
    Intrinsics.checkParameterIsNotNull(paramClass, "jClass");
    Object localObject = ClassReference.access$getFUNCTION_CLASSES$cp();
    if (localObject != null)
    {
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
    throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<K, V>");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.jvm.internal.ClassReference.Companion
 * JD-Core Version:    0.7.0.1
 */