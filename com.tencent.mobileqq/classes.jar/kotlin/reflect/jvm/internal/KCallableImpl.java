package kotlin.reflect.jvm.internal;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KCallable;
import kotlin.reflect.KParameter;
import kotlin.reflect.KParameter.Kind;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVisibility;
import kotlin.reflect.full.IllegalCallableAccessException;
import kotlin.reflect.jvm.ReflectJvmMapping;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/reflect/jvm/internal/KCallableImpl;", "R", "Lkotlin/reflect/KCallable;", "()V", "_annotations", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "", "", "kotlin.jvm.PlatformType", "_parameters", "Ljava/util/ArrayList;", "Lkotlin/reflect/KParameter;", "_returnType", "Lkotlin/reflect/jvm/internal/KTypeImpl;", "_typeParameters", "Lkotlin/reflect/jvm/internal/KTypeParameterImpl;", "annotations", "getAnnotations", "()Ljava/util/List;", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "defaultCaller", "getDefaultCaller", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/CallableMemberDescriptor;", "isAbstract", "", "()Z", "isAnnotationConstructor", "isBound", "isFinal", "isOpen", "parameters", "getParameters", "returnType", "Lkotlin/reflect/KType;", "getReturnType", "()Lkotlin/reflect/KType;", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", "visibility", "Lkotlin/reflect/KVisibility;", "getVisibility", "()Lkotlin/reflect/KVisibility;", "call", "args", "", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "callAnnotationConstructor", "", "(Ljava/util/Map;)Ljava/lang/Object;", "callBy", "callDefaultMethod", "continuationArgument", "Lkotlin/coroutines/Continuation;", "callDefaultMethod$kotlin_reflection", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "defaultPrimitiveValue", "type", "Ljava/lang/reflect/Type;", "extractContinuationArgument", "kotlin-reflection"}, k=1, mv={1, 1, 16})
public abstract class KCallableImpl<R>
  implements KCallable<R>
{
  private final ReflectProperties.LazySoftVal<List<Annotation>> _annotations;
  private final ReflectProperties.LazySoftVal<ArrayList<KParameter>> _parameters;
  private final ReflectProperties.LazySoftVal<KTypeImpl> _returnType;
  private final ReflectProperties.LazySoftVal<List<KTypeParameterImpl>> _typeParameters;
  
  public KCallableImpl()
  {
    ReflectProperties.LazySoftVal localLazySoftVal = ReflectProperties.lazySoft((Function0)new KCallableImpl._annotations.1(this));
    Intrinsics.checkExpressionValueIsNotNull(localLazySoftVal, "ReflectProperties.lazySo…or.computeAnnotations() }");
    this._annotations = localLazySoftVal;
    localLazySoftVal = ReflectProperties.lazySoft((Function0)new KCallableImpl._parameters.1(this));
    Intrinsics.checkExpressionValueIsNotNull(localLazySoftVal, "ReflectProperties.lazySo…ze()\n        result\n    }");
    this._parameters = localLazySoftVal;
    localLazySoftVal = ReflectProperties.lazySoft((Function0)new KCallableImpl._returnType.1(this));
    Intrinsics.checkExpressionValueIsNotNull(localLazySoftVal, "ReflectProperties.lazySo…eturnType\n        }\n    }");
    this._returnType = localLazySoftVal;
    localLazySoftVal = ReflectProperties.lazySoft((Function0)new KCallableImpl._typeParameters.1(this));
    Intrinsics.checkExpressionValueIsNotNull(localLazySoftVal, "ReflectProperties.lazySo…KTypeParameterImpl)\n    }");
    this._typeParameters = localLazySoftVal;
  }
  
  private final R callAnnotationConstructor(Map<KParameter, ? extends Object> paramMap)
  {
    Object localObject = (Iterable)getParameters();
    Collection localCollection = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject, 10));
    Iterator localIterator = ((Iterable)localObject).iterator();
    while (localIterator.hasNext())
    {
      KParameter localKParameter = (KParameter)localIterator.next();
      if (paramMap.containsKey(localKParameter))
      {
        localObject = paramMap.get(localKParameter);
        if (localObject == null)
        {
          paramMap = new StringBuilder();
          paramMap.append("Annotation argument value cannot be null (");
          paramMap.append(localKParameter);
          paramMap.append(')');
          throw ((Throwable)new IllegalArgumentException(paramMap.toString()));
        }
      }
      else
      {
        if (!localKParameter.isOptional()) {
          break label149;
        }
        localObject = null;
      }
      localCollection.add(localObject);
      continue;
      label149:
      paramMap = new StringBuilder();
      paramMap.append("No argument provided for a required parameter: ");
      paramMap.append(localKParameter);
      throw ((Throwable)new IllegalArgumentException(paramMap.toString()));
    }
    localObject = (List)localCollection;
    paramMap = getDefaultCaller();
    if (paramMap != null) {
      try
      {
        localObject = ((Collection)localObject).toArray(new Object[0]);
        if (localObject != null) {
          return paramMap.call((Object[])localObject);
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
      }
      catch (IllegalAccessException paramMap)
      {
        throw ((Throwable)new IllegalCallableAccessException(paramMap));
      }
    }
    paramMap = new StringBuilder();
    paramMap.append("This callable does not support a default call: ");
    paramMap.append(getDescriptor());
    paramMap = (Throwable)new KotlinReflectionInternalError(paramMap.toString());
    for (;;)
    {
      throw paramMap;
    }
  }
  
  private final Object defaultPrimitiveValue(Type paramType)
  {
    if (((paramType instanceof Class)) && (((Class)paramType).isPrimitive()))
    {
      if (Intrinsics.areEqual(paramType, Boolean.TYPE)) {
        return Boolean.valueOf(false);
      }
      if (Intrinsics.areEqual(paramType, Character.TYPE)) {
        return Character.valueOf((char)0);
      }
      if (Intrinsics.areEqual(paramType, Byte.TYPE)) {
        return Byte.valueOf((byte)0);
      }
      if (Intrinsics.areEqual(paramType, Short.TYPE)) {
        return Short.valueOf((short)0);
      }
      if (Intrinsics.areEqual(paramType, Integer.TYPE)) {
        return Integer.valueOf(0);
      }
      if (Intrinsics.areEqual(paramType, Float.TYPE)) {
        return Float.valueOf(0.0F);
      }
      if (Intrinsics.areEqual(paramType, Long.TYPE)) {
        return Long.valueOf(0L);
      }
      if (Intrinsics.areEqual(paramType, Double.TYPE)) {
        return Double.valueOf(0.0D);
      }
      if (Intrinsics.areEqual(paramType, Void.TYPE)) {
        throw ((Throwable)new IllegalStateException("Parameter with void type is illegal"));
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unknown primitive: ");
      localStringBuilder.append(paramType);
      throw ((Throwable)new UnsupportedOperationException(localStringBuilder.toString()));
    }
    return null;
  }
  
  private final Type extractContinuationArgument()
  {
    Object localObject1 = getDescriptor();
    boolean bool = localObject1 instanceof FunctionDescriptor;
    Object localObject3 = null;
    if (!bool) {
      localObject1 = null;
    }
    Object localObject2 = (FunctionDescriptor)localObject1;
    localObject1 = localObject3;
    if (localObject2 != null)
    {
      localObject1 = localObject3;
      if (((FunctionDescriptor)localObject2).isSuspend() == true)
      {
        localObject2 = CollectionsKt.lastOrNull(getCaller().getParameterTypes());
        localObject1 = localObject2;
        if (!(localObject2 instanceof ParameterizedType)) {
          localObject1 = null;
        }
        ParameterizedType localParameterizedType = (ParameterizedType)localObject1;
        if (localParameterizedType != null) {
          localObject2 = localParameterizedType.getRawType();
        } else {
          localObject2 = null;
        }
        localObject1 = localObject3;
        if (Intrinsics.areEqual(localObject2, Continuation.class))
        {
          localObject1 = localParameterizedType.getActualTypeArguments();
          Intrinsics.checkExpressionValueIsNotNull(localObject1, "continuationType.actualTypeArguments");
          localObject2 = ArraysKt.single((Object[])localObject1);
          localObject1 = localObject2;
          if (!(localObject2 instanceof WildcardType)) {
            localObject1 = null;
          }
          localObject2 = (WildcardType)localObject1;
          localObject1 = localObject3;
          if (localObject2 != null)
          {
            localObject2 = ((WildcardType)localObject2).getLowerBounds();
            localObject1 = localObject3;
            if (localObject2 != null) {
              localObject1 = (Type)ArraysKt.first((Object[])localObject2);
            }
          }
        }
      }
    }
    return localObject1;
  }
  
  public R call(@NotNull Object... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "args");
    try
    {
      paramVarArgs = getCaller().call(paramVarArgs);
      return paramVarArgs;
    }
    catch (IllegalAccessException paramVarArgs)
    {
      throw ((Throwable)new IllegalCallableAccessException(paramVarArgs));
    }
  }
  
  public R callBy(@NotNull Map<KParameter, ? extends Object> paramMap)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "args");
    if (isAnnotationConstructor()) {
      return callAnnotationConstructor(paramMap);
    }
    return callDefaultMethod$kotlin_reflection(paramMap, null);
  }
  
  public final R callDefaultMethod$kotlin_reflection(@NotNull Map<KParameter, ? extends Object> paramMap, @Nullable Continuation<?> paramContinuation)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "args");
    Object localObject = getParameters();
    ArrayList localArrayList1 = new ArrayList(((List)localObject).size());
    ArrayList localArrayList2 = new ArrayList(1);
    Iterator localIterator = ((List)localObject).iterator();
    int k = 0;
    int m = 0;
    int i = 0;
    while (localIterator.hasNext())
    {
      localObject = (KParameter)localIterator.next();
      int j = i;
      if (k != 0)
      {
        j = i;
        if (k % 32 == 0)
        {
          localArrayList2.add(Integer.valueOf(i));
          j = 0;
        }
      }
      int n;
      if (paramMap.containsKey(localObject))
      {
        localArrayList1.add(paramMap.get(localObject));
        n = m;
      }
      else
      {
        if (!((KParameter)localObject).isOptional()) {
          break label223;
        }
        localArrayList1.add(defaultPrimitiveValue(ReflectJvmMapping.getJavaType(((KParameter)localObject).getType())));
        j = 1 << k % 32 | j;
        n = 1;
      }
      m = n;
      i = j;
      if (((KParameter)localObject).getKind() == KParameter.Kind.VALUE)
      {
        k += 1;
        m = n;
        i = j;
        continue;
        label223:
        paramMap = new StringBuilder();
        paramMap.append("No argument provided for a required parameter: ");
        paramMap.append(localObject);
        throw ((Throwable)new IllegalArgumentException(paramMap.toString()));
      }
    }
    if (paramContinuation != null) {
      localArrayList1.add(paramContinuation);
    }
    if (m == 0)
    {
      paramMap = ((Collection)localArrayList1).toArray(new Object[0]);
      if (paramMap != null) {
        return call(Arrays.copyOf(paramMap, paramMap.length));
      }
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }
    localArrayList2.add(Integer.valueOf(i));
    paramMap = getDefaultCaller();
    if (paramMap != null)
    {
      localArrayList1.addAll((Collection)localArrayList2);
      localArrayList1.add(null);
      try
      {
        paramContinuation = ((Collection)localArrayList1).toArray(new Object[0]);
        if (paramContinuation != null) {
          return paramMap.call(paramContinuation);
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
      }
      catch (IllegalAccessException paramMap)
      {
        throw ((Throwable)new IllegalCallableAccessException(paramMap));
      }
    }
    paramMap = new StringBuilder();
    paramMap.append("This callable does not support a default call: ");
    paramMap.append(getDescriptor());
    paramMap = (Throwable)new KotlinReflectionInternalError(paramMap.toString());
    for (;;)
    {
      throw paramMap;
    }
  }
  
  @NotNull
  public List<Annotation> getAnnotations()
  {
    Object localObject = this._annotations.invoke();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "_annotations()");
    return (List)localObject;
  }
  
  @NotNull
  public abstract Caller<?> getCaller();
  
  @NotNull
  public abstract KDeclarationContainerImpl getContainer();
  
  @Nullable
  public abstract Caller<?> getDefaultCaller();
  
  @NotNull
  public abstract CallableMemberDescriptor getDescriptor();
  
  @NotNull
  public List<KParameter> getParameters()
  {
    Object localObject = this._parameters.invoke();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "_parameters()");
    return (List)localObject;
  }
  
  @NotNull
  public KType getReturnType()
  {
    Object localObject = this._returnType.invoke();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "_returnType()");
    return (KType)localObject;
  }
  
  @NotNull
  public List<KTypeParameter> getTypeParameters()
  {
    Object localObject = this._typeParameters.invoke();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "_typeParameters()");
    return (List)localObject;
  }
  
  @Nullable
  public KVisibility getVisibility()
  {
    Visibility localVisibility = getDescriptor().getVisibility();
    Intrinsics.checkExpressionValueIsNotNull(localVisibility, "descriptor.visibility");
    return UtilKt.toKVisibility(localVisibility);
  }
  
  public boolean isAbstract()
  {
    return getDescriptor().getModality() == Modality.ABSTRACT;
  }
  
  protected final boolean isAnnotationConstructor()
  {
    return (Intrinsics.areEqual(getName(), "<init>")) && (getContainer().getJClass().isAnnotation());
  }
  
  public abstract boolean isBound();
  
  public boolean isFinal()
  {
    return getDescriptor().getModality() == Modality.FINAL;
  }
  
  public boolean isOpen()
  {
    return getDescriptor().getModality() == Modality.OPEN;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.KCallableImpl
 * JD-Core Version:    0.7.0.1
 */