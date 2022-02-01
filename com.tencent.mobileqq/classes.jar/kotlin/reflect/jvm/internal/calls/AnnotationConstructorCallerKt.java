package kotlin.reflect.jvm.internal.calls;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"createAnnotationInstance", "T", "", "annotationClass", "Ljava/lang/Class;", "values", "", "", "methods", "", "Ljava/lang/reflect/Method;", "(Ljava/lang/Class;Ljava/util/Map;Ljava/util/List;)Ljava/lang/Object;", "throwIllegalArgumentType", "", "index", "", "name", "expectedJvmType", "transformKotlinToJvm", "expectedType", "kotlin-reflection"}, k=2, mv={1, 1, 16})
public final class AnnotationConstructorCallerKt
{
  @NotNull
  public static final <T> T createAnnotationInstance(@NotNull Class<T> paramClass, @NotNull Map<String, ? extends Object> paramMap, @NotNull List<Method> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramClass, "annotationClass");
    Intrinsics.checkParameterIsNotNull(paramMap, "values");
    Intrinsics.checkParameterIsNotNull(paramList, "methods");
    AnnotationConstructorCallerKt.createAnnotationInstance.2 local2 = new AnnotationConstructorCallerKt.createAnnotationInstance.2(paramClass, paramList, paramMap);
    Lazy localLazy1 = LazyKt.lazy((Function0)new AnnotationConstructorCallerKt.createAnnotationInstance.hashCode.2(paramMap));
    Lazy localLazy2 = LazyKt.lazy((Function0)new AnnotationConstructorCallerKt.createAnnotationInstance.toString.2(paramClass, paramMap));
    paramList = paramClass.getClassLoader();
    paramMap = (InvocationHandler)new AnnotationConstructorCallerKt.createAnnotationInstance.result.1(paramClass, localLazy2, null, localLazy1, null, local2, paramMap);
    paramClass = Proxy.newProxyInstance(paramList, new Class[] { paramClass }, paramMap);
    if (paramClass != null) {
      return paramClass;
    }
    throw new TypeCastException("null cannot be cast to non-null type T");
  }
  
  private static final Void throwIllegalArgumentType(int paramInt, String paramString, Class<?> paramClass)
  {
    if (Intrinsics.areEqual(paramClass, Class.class)) {
      paramClass = Reflection.getOrCreateKotlinClass(KClass.class);
    } else if ((paramClass.isArray()) && (Intrinsics.areEqual(paramClass.getComponentType(), Class.class))) {
      paramClass = Reflection.getOrCreateKotlinClass([Lkotlin.reflect.KClass.class);
    } else {
      paramClass = JvmClassMappingKt.getKotlinClass(paramClass);
    }
    if (Intrinsics.areEqual(paramClass.getQualifiedName(), Reflection.getOrCreateKotlinClass([Ljava.lang.Object.class).getQualifiedName()))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramClass.getQualifiedName());
      localStringBuilder.append('<');
      paramClass = JvmClassMappingKt.getJavaClass(paramClass).getComponentType();
      Intrinsics.checkExpressionValueIsNotNull(paramClass, "kotlinClass.java.componentType");
      localStringBuilder.append(JvmClassMappingKt.getKotlinClass(paramClass).getQualifiedName());
      localStringBuilder.append('>');
      paramClass = localStringBuilder.toString();
    }
    else
    {
      paramClass = paramClass.getQualifiedName();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Argument #");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(' ');
    localStringBuilder.append(paramString);
    localStringBuilder.append(" is not of the required type ");
    localStringBuilder.append(paramClass);
    throw ((Throwable)new IllegalArgumentException(localStringBuilder.toString()));
  }
  
  private static final Object transformKotlinToJvm(@Nullable Object paramObject, Class<?> paramClass)
  {
    if ((paramObject instanceof Class)) {
      return null;
    }
    Object localObject;
    if ((paramObject instanceof KClass))
    {
      localObject = JvmClassMappingKt.getJavaClass((KClass)paramObject);
    }
    else
    {
      localObject = paramObject;
      if ((paramObject instanceof Object[]))
      {
        localObject = (Object[])paramObject;
        if ((localObject instanceof Class[])) {
          return null;
        }
        if ((localObject instanceof KClass[])) {
          if (paramObject != null)
          {
            paramObject = (KClass[])paramObject;
            localObject = (Collection)new ArrayList(paramObject.length);
            int j = paramObject.length;
            int i = 0;
            while (i < j)
            {
              ((Collection)localObject).add(JvmClassMappingKt.getJavaClass(paramObject[i]));
              i += 1;
            }
            localObject = ((Collection)localObject).toArray(new Class[0]);
            if (localObject == null) {
              throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
            }
          }
          else
          {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<kotlin.reflect.KClass<*>>");
          }
        }
      }
    }
    if (paramClass.isInstance(localObject)) {
      return localObject;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt
 * JD-Core Version:    0.7.0.1
 */