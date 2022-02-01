package kotlin.jvm;

import java.lang.annotation.Annotation;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.ClassBasedDeclarationContainer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"annotationClass", "Lkotlin/reflect/KClass;", "T", "", "getAnnotationClass", "(Ljava/lang/annotation/Annotation;)Lkotlin/reflect/KClass;", "java", "Ljava/lang/Class;", "java$annotations", "(Lkotlin/reflect/KClass;)V", "getJavaClass", "(Lkotlin/reflect/KClass;)Ljava/lang/Class;", "javaClass", "", "(Ljava/lang/Object;)Ljava/lang/Class;", "javaClass$annotations", "getRuntimeClassOfKClassInstance", "javaObjectType", "getJavaObjectType", "javaPrimitiveType", "getJavaPrimitiveType", "kotlin", "getKotlinClass", "(Ljava/lang/Class;)Lkotlin/reflect/KClass;", "isArrayOf", "", "", "([Ljava/lang/Object;)Z", "kotlin-stdlib"}, k=2, mv={1, 1, 16})
@JvmName(name="JvmClassMappingKt")
public final class JvmClassMappingKt
{
  @NotNull
  public static final <T extends Annotation> KClass<? extends T> getAnnotationClass(@NotNull T paramT)
  {
    Intrinsics.checkParameterIsNotNull(paramT, "$this$annotationClass");
    paramT = paramT.annotationType();
    Intrinsics.checkExpressionValueIsNotNull(paramT, "(this as java.lang.annot…otation).annotationType()");
    paramT = getKotlinClass(paramT);
    if (paramT != null) {
      return paramT;
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.reflect.KClass<out T>");
  }
  
  @NotNull
  public static final <T> Class<T> getJavaClass(@NotNull T paramT)
  {
    Intrinsics.checkParameterIsNotNull(paramT, "$this$javaClass");
    paramT = paramT.getClass();
    if (paramT != null) {
      return paramT;
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.Class<T>");
  }
  
  @JvmName(name="getJavaClass")
  @NotNull
  public static final <T> Class<T> getJavaClass(@NotNull KClass<T> paramKClass)
  {
    Intrinsics.checkParameterIsNotNull(paramKClass, "$this$java");
    paramKClass = ((ClassBasedDeclarationContainer)paramKClass).getJClass();
    if (paramKClass != null) {
      return paramKClass;
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.Class<T>");
  }
  
  @NotNull
  public static final <T> Class<T> getJavaObjectType(@NotNull KClass<T> paramKClass)
  {
    Intrinsics.checkParameterIsNotNull(paramKClass, "$this$javaObjectType");
    paramKClass = ((ClassBasedDeclarationContainer)paramKClass).getJClass();
    if (!paramKClass.isPrimitive())
    {
      if (paramKClass != null) {
        return paramKClass;
      }
      throw new TypeCastException("null cannot be cast to non-null type java.lang.Class<T>");
    }
    String str = paramKClass.getName();
    if (str != null) {
      switch (str.hashCode())
      {
      default: 
        break;
      case 109413500: 
        if (str.equals("short")) {
          paramKClass = Short.class;
        }
        break;
      case 97526364: 
        if (str.equals("float")) {
          paramKClass = Float.class;
        }
        break;
      case 64711720: 
        if (str.equals("boolean")) {
          paramKClass = Boolean.class;
        }
        break;
      case 3625364: 
        if (str.equals("void")) {
          paramKClass = Void.class;
        }
        break;
      case 3327612: 
        if (str.equals("long")) {
          paramKClass = Long.class;
        }
        break;
      case 3052374: 
        if (str.equals("char")) {
          paramKClass = Character.class;
        }
        break;
      case 3039496: 
        if (str.equals("byte")) {
          paramKClass = Byte.class;
        }
        break;
      case 104431: 
        if (str.equals("int")) {
          paramKClass = Integer.class;
        }
        break;
      case -1325958191: 
        if (str.equals("double")) {
          paramKClass = Double.class;
        }
        break;
      }
    }
    if (paramKClass != null) {
      return paramKClass;
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.Class<T>");
  }
  
  @Nullable
  public static final <T> Class<T> getJavaPrimitiveType(@NotNull KClass<T> paramKClass)
  {
    Intrinsics.checkParameterIsNotNull(paramKClass, "$this$javaPrimitiveType");
    paramKClass = ((ClassBasedDeclarationContainer)paramKClass).getJClass();
    if (paramKClass.isPrimitive())
    {
      if (paramKClass != null) {
        return paramKClass;
      }
      throw new TypeCastException("null cannot be cast to non-null type java.lang.Class<T>");
    }
    paramKClass = paramKClass.getName();
    if (paramKClass != null) {
      switch (paramKClass.hashCode())
      {
      default: 
        break;
      case 761287205: 
        if (paramKClass.equals("java.lang.Double")) {
          return Double.TYPE;
        }
        break;
      case 399092968: 
        if (paramKClass.equals("java.lang.Void")) {
          return Void.TYPE;
        }
        break;
      case 398795216: 
        if (paramKClass.equals("java.lang.Long")) {
          return Long.TYPE;
        }
        break;
      case 398507100: 
        if (paramKClass.equals("java.lang.Byte")) {
          return Byte.TYPE;
        }
        break;
      case 344809556: 
        if (paramKClass.equals("java.lang.Boolean")) {
          return Boolean.TYPE;
        }
        break;
      case 155276373: 
        if (paramKClass.equals("java.lang.Character")) {
          return Character.TYPE;
        }
        break;
      case -515992664: 
        if (paramKClass.equals("java.lang.Short")) {
          return Short.TYPE;
        }
        break;
      case -527879800: 
        if (paramKClass.equals("java.lang.Float")) {
          return Float.TYPE;
        }
        break;
      case -2056817302: 
        if (paramKClass.equals("java.lang.Integer")) {
          return Integer.TYPE;
        }
        break;
      }
    }
    return null;
  }
  
  @JvmName(name="getKotlinClass")
  @NotNull
  public static final <T> KClass<T> getKotlinClass(@NotNull Class<T> paramClass)
  {
    Intrinsics.checkParameterIsNotNull(paramClass, "$this$kotlin");
    return Reflection.getOrCreateKotlinClass(paramClass);
  }
  
  @JvmName(name="getRuntimeClassOfKClassInstance")
  @NotNull
  public static final <T> Class<KClass<T>> getRuntimeClassOfKClassInstance(@NotNull KClass<T> paramKClass)
  {
    Intrinsics.checkParameterIsNotNull(paramKClass, "$this$javaClass");
    paramKClass = ((Object)paramKClass).getClass();
    if (paramKClass != null) {
      return paramKClass;
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.Class<kotlin.reflect.KClass<T>>");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.jvm.JvmClassMappingKt
 * JD-Core Version:    0.7.0.1
 */