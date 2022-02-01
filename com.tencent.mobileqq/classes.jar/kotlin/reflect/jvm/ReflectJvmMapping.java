package kotlin.reflect.jvm;

import java.lang.reflect.Constructor;
import java.lang.reflect.Constructor<TT;>;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KFunction;
import kotlin.reflect.KMutableProperty;
import kotlin.reflect.KProperty;
import kotlin.reflect.KType;
import kotlin.reflect.full.KClasses;
import kotlin.reflect.jvm.internal.KCallableImpl;
import kotlin.reflect.jvm.internal.KPackageImpl;
import kotlin.reflect.jvm.internal.KPropertyImpl;
import kotlin.reflect.jvm.internal.KTypeImpl;
import kotlin.reflect.jvm.internal.UtilKt;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass.Factory;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"javaConstructor", "Ljava/lang/reflect/Constructor;", "T", "Lkotlin/reflect/KFunction;", "javaConstructor$annotations", "(Lkotlin/reflect/KFunction;)V", "getJavaConstructor", "(Lkotlin/reflect/KFunction;)Ljava/lang/reflect/Constructor;", "javaField", "Ljava/lang/reflect/Field;", "Lkotlin/reflect/KProperty;", "getJavaField", "(Lkotlin/reflect/KProperty;)Ljava/lang/reflect/Field;", "javaGetter", "Ljava/lang/reflect/Method;", "getJavaGetter", "(Lkotlin/reflect/KProperty;)Ljava/lang/reflect/Method;", "javaMethod", "getJavaMethod", "(Lkotlin/reflect/KFunction;)Ljava/lang/reflect/Method;", "javaSetter", "Lkotlin/reflect/KMutableProperty;", "getJavaSetter", "(Lkotlin/reflect/KMutableProperty;)Ljava/lang/reflect/Method;", "javaType", "Ljava/lang/reflect/Type;", "Lkotlin/reflect/KType;", "getJavaType", "(Lkotlin/reflect/KType;)Ljava/lang/reflect/Type;", "kotlinFunction", "", "getKotlinFunction", "(Ljava/lang/reflect/Constructor;)Lkotlin/reflect/KFunction;", "(Ljava/lang/reflect/Method;)Lkotlin/reflect/KFunction;", "kotlinProperty", "getKotlinProperty", "(Ljava/lang/reflect/Field;)Lkotlin/reflect/KProperty;", "getKPackage", "Lkotlin/reflect/KDeclarationContainer;", "Ljava/lang/reflect/Member;", "kotlin-reflection"}, k=2, mv={1, 1, 16})
@JvmName(name="ReflectJvmMapping")
public final class ReflectJvmMapping
{
  @Nullable
  public static final <T> Constructor<T> getJavaConstructor(@NotNull KFunction<? extends T> paramKFunction)
  {
    Intrinsics.checkParameterIsNotNull(paramKFunction, "$this$javaConstructor");
    paramKFunction = UtilKt.asKCallableImpl(paramKFunction);
    if (paramKFunction != null)
    {
      paramKFunction = paramKFunction.getCaller();
      if (paramKFunction != null)
      {
        paramKFunction = paramKFunction.getMember();
        break label36;
      }
    }
    paramKFunction = null;
    label36:
    KFunction<? extends T> localKFunction = paramKFunction;
    if (!(paramKFunction instanceof Constructor)) {
      localKFunction = null;
    }
    return (Constructor)localKFunction;
  }
  
  @Nullable
  public static final Field getJavaField(@NotNull KProperty<?> paramKProperty)
  {
    Intrinsics.checkParameterIsNotNull(paramKProperty, "$this$javaField");
    paramKProperty = UtilKt.asKPropertyImpl(paramKProperty);
    if (paramKProperty != null) {
      return paramKProperty.getJavaField();
    }
    return null;
  }
  
  @Nullable
  public static final Method getJavaGetter(@NotNull KProperty<?> paramKProperty)
  {
    Intrinsics.checkParameterIsNotNull(paramKProperty, "$this$javaGetter");
    return getJavaMethod((KFunction)paramKProperty.getGetter());
  }
  
  @Nullable
  public static final Method getJavaMethod(@NotNull KFunction<?> paramKFunction)
  {
    Intrinsics.checkParameterIsNotNull(paramKFunction, "$this$javaMethod");
    paramKFunction = UtilKt.asKCallableImpl(paramKFunction);
    if (paramKFunction != null)
    {
      paramKFunction = paramKFunction.getCaller();
      if (paramKFunction != null)
      {
        paramKFunction = paramKFunction.getMember();
        break label36;
      }
    }
    paramKFunction = null;
    label36:
    KFunction<?> localKFunction = paramKFunction;
    if (!(paramKFunction instanceof Method)) {
      localKFunction = null;
    }
    return (Method)localKFunction;
  }
  
  @Nullable
  public static final Method getJavaSetter(@NotNull KMutableProperty<?> paramKMutableProperty)
  {
    Intrinsics.checkParameterIsNotNull(paramKMutableProperty, "$this$javaSetter");
    return getJavaMethod((KFunction)paramKMutableProperty.getSetter());
  }
  
  @NotNull
  public static final Type getJavaType(@NotNull KType paramKType)
  {
    Intrinsics.checkParameterIsNotNull(paramKType, "$this$javaType");
    return ((KTypeImpl)paramKType).getJavaType$kotlin_reflection();
  }
  
  private static final KDeclarationContainer getKPackage(@NotNull Member paramMember)
  {
    Object localObject = ReflectKotlinClass.Factory;
    Class localClass = paramMember.getDeclaringClass();
    Intrinsics.checkExpressionValueIsNotNull(localClass, "declaringClass");
    localObject = ((ReflectKotlinClass.Factory)localObject).create(localClass);
    if (localObject != null)
    {
      localObject = ((ReflectKotlinClass)localObject).getClassHeader();
      if (localObject != null)
      {
        localObject = ((KotlinClassHeader)localObject).getKind();
        break label46;
      }
    }
    localObject = null;
    label46:
    if (localObject == null) {
      return null;
    }
    int i = ReflectJvmMapping.WhenMappings.$EnumSwitchMapping$0[localObject.ordinal()];
    if ((i != 1) && (i != 2) && (i != 3)) {
      return null;
    }
    paramMember = paramMember.getDeclaringClass();
    Intrinsics.checkExpressionValueIsNotNull(paramMember, "declaringClass");
    return (KDeclarationContainer)new KPackageImpl(paramMember, null, 2, null);
  }
  
  @Nullable
  public static final <T> KFunction<T> getKotlinFunction(@NotNull Constructor<T> paramConstructor)
  {
    Intrinsics.checkParameterIsNotNull(paramConstructor, "$this$kotlinFunction");
    Object localObject = paramConstructor.getDeclaringClass();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "declaringClass");
    Iterator localIterator = ((Iterable)JvmClassMappingKt.getKotlinClass((Class)localObject).getConstructors()).iterator();
    while (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (Intrinsics.areEqual(getJavaConstructor((KFunction)localObject), paramConstructor))
      {
        paramConstructor = (Constructor<T>)localObject;
        break label72;
      }
    }
    paramConstructor = null;
    label72:
    return (KFunction)paramConstructor;
  }
  
  @Nullable
  public static final KFunction<?> getKotlinFunction(@NotNull Method paramMethod)
  {
    Intrinsics.checkParameterIsNotNull(paramMethod, "$this$kotlinFunction");
    if (Modifier.isStatic(paramMethod.getModifiers()))
    {
      localObject1 = getKPackage((Member)paramMethod);
      Object localObject3;
      if (localObject1 != null)
      {
        localObject2 = (Iterable)((KDeclarationContainer)localObject1).getMembers();
        localObject1 = (Collection)new ArrayList();
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = ((Iterator)localObject2).next();
          if ((localObject3 instanceof KFunction)) {
            ((Collection)localObject1).add(localObject3);
          }
        }
        localObject2 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject1 = ((Iterator)localObject2).next();
          if (Intrinsics.areEqual(getJavaMethod((KFunction)localObject1), paramMethod))
          {
            paramMethod = (Method)localObject1;
            break label143;
          }
        }
        paramMethod = null;
        label143:
        return (KFunction)paramMethod;
      }
      localObject1 = paramMethod.getDeclaringClass();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "declaringClass");
      localObject1 = KClasses.getCompanionObject(JvmClassMappingKt.getKotlinClass((Class)localObject1));
      if (localObject1 != null)
      {
        localObject2 = ((Iterable)KClasses.getFunctions((KClass)localObject1)).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject1 = ((Iterator)localObject2).next();
          localObject3 = getJavaMethod((KFunction)localObject1);
          if ((localObject3 != null) && (Intrinsics.areEqual(((Method)localObject3).getName(), paramMethod.getName())))
          {
            Class[] arrayOfClass1 = ((Method)localObject3).getParameterTypes();
            if (arrayOfClass1 == null) {
              Intrinsics.throwNpe();
            }
            Class[] arrayOfClass2 = paramMethod.getParameterTypes();
            Intrinsics.checkExpressionValueIsNotNull(arrayOfClass2, "this.parameterTypes");
            if ((Arrays.equals(arrayOfClass1, arrayOfClass2)) && (Intrinsics.areEqual(((Method)localObject3).getReturnType(), paramMethod.getReturnType())))
            {
              i = 1;
              break label290;
            }
          }
          int i = 0;
          label290:
          if (i != 0) {
            break label299;
          }
        }
        localObject1 = null;
        label299:
        localObject1 = (KFunction)localObject1;
        if (localObject1 != null) {
          return localObject1;
        }
      }
    }
    Object localObject1 = paramMethod.getDeclaringClass();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "declaringClass");
    Object localObject2 = ((Iterable)KClasses.getFunctions(JvmClassMappingKt.getKotlinClass((Class)localObject1))).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = ((Iterator)localObject2).next();
      if (Intrinsics.areEqual(getJavaMethod((KFunction)localObject1), paramMethod))
      {
        paramMethod = (Method)localObject1;
        break label374;
      }
    }
    paramMethod = null;
    label374:
    return (KFunction)paramMethod;
  }
  
  @Nullable
  public static final KProperty<?> getKotlinProperty(@NotNull Field paramField)
  {
    Intrinsics.checkParameterIsNotNull(paramField, "$this$kotlinProperty");
    boolean bool = paramField.isSynthetic();
    Object localObject2 = null;
    Iterator localIterator = null;
    if (bool) {
      return null;
    }
    Object localObject1 = getKPackage((Member)paramField);
    if (localObject1 != null)
    {
      localObject2 = (Iterable)((KDeclarationContainer)localObject1).getMembers();
      localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = ((Iterator)localObject2).next();
        if ((localObject3 instanceof KProperty)) {
          ((Collection)localObject1).add(localObject3);
        }
      }
      localObject2 = ((Iterable)localObject1).iterator();
      do
      {
        localObject1 = localIterator;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject1 = ((Iterator)localObject2).next();
      } while (!Intrinsics.areEqual(getJavaField((KProperty)localObject1), paramField));
      return (KProperty)localObject1;
    }
    localObject1 = paramField.getDeclaringClass();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "declaringClass");
    localIterator = ((Iterable)KClasses.getMemberProperties(JvmClassMappingKt.getKotlinClass((Class)localObject1))).iterator();
    do
    {
      localObject1 = localObject2;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject1 = localIterator.next();
    } while (!Intrinsics.areEqual(getJavaField((KProperty)localObject1), paramField));
    return (KProperty)localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.ReflectJvmMapping
 * JD-Core Version:    0.7.0.1
 */