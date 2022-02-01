package kotlin.reflect.full;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map<Lkotlin.reflect.KParameter;+Ljava.lang.Object;>;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.Continuation<-TR;>;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SpreadBuilder;
import kotlin.reflect.KCallable;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;
import kotlin.reflect.KParameter.Kind;
import kotlin.reflect.KType;
import kotlin.reflect.jvm.internal.KCallableImpl;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.UtilKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"extensionReceiverParameter", "Lkotlin/reflect/KParameter;", "Lkotlin/reflect/KCallable;", "extensionReceiverParameter$annotations", "(Lkotlin/reflect/KCallable;)V", "getExtensionReceiverParameter", "(Lkotlin/reflect/KCallable;)Lkotlin/reflect/KParameter;", "instanceParameter", "instanceParameter$annotations", "getInstanceParameter", "valueParameters", "", "valueParameters$annotations", "getValueParameters", "(Lkotlin/reflect/KCallable;)Ljava/util/List;", "callSuspend", "R", "args", "", "", "(Lkotlin/reflect/KCallable;[Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callSuspendBy", "", "(Lkotlin/reflect/KCallable;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findParameterByName", "name", "", "kotlin-reflection"}, k=2, mv={1, 1, 16})
@JvmName(name="KCallables")
public final class KCallables
{
  @SinceKotlin(version="1.3")
  @Nullable
  public static final <R> Object callSuspend(@NotNull KCallable<? extends R> paramKCallable, @NotNull Object[] paramArrayOfObject, @NotNull Continuation<? super R> paramContinuation)
  {
    if ((paramContinuation instanceof KCallables.callSuspend.1))
    {
      localObject1 = (KCallables.callSuspend.1)paramContinuation;
      if ((((KCallables.callSuspend.1)localObject1).label & 0x80000000) != 0)
      {
        ((KCallables.callSuspend.1)localObject1).label += -2147483648;
        paramContinuation = (Continuation<? super R>)localObject1;
        break label52;
      }
    }
    paramContinuation = new KCallables.callSuspend.1(paramContinuation);
    label52:
    Object localObject1 = paramContinuation.result;
    Object localObject2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    int i = paramContinuation.label;
    if (i != 0)
    {
      if (i == 1)
      {
        paramKCallable = (Object[])paramContinuation.L$1;
        paramKCallable = (KCallable)paramContinuation.L$0;
        ResultKt.throwOnFailure(localObject1);
        paramArrayOfObject = (Object[])localObject1;
      }
      else
      {
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      }
    }
    else
    {
      ResultKt.throwOnFailure(localObject1);
      if (!paramKCallable.isSuspend()) {
        return paramKCallable.call(Arrays.copyOf(paramArrayOfObject, paramArrayOfObject.length));
      }
      if (!(paramKCallable instanceof KFunction)) {
        break label275;
      }
      paramContinuation.L$0 = paramKCallable;
      paramContinuation.L$1 = paramArrayOfObject;
      paramContinuation.label = 1;
      localObject1 = (Continuation)paramContinuation;
      paramContinuation = new SpreadBuilder(2);
      paramContinuation.addSpread(paramArrayOfObject);
      paramContinuation.add(localObject1);
      paramContinuation = paramKCallable.call(paramContinuation.toArray(new Object[paramContinuation.size()]));
      if (paramContinuation == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
        DebugProbesKt.probeCoroutineSuspended((Continuation)localObject1);
      }
      paramArrayOfObject = paramContinuation;
      if (paramContinuation == localObject2) {
        return localObject2;
      }
    }
    if ((Intrinsics.areEqual(paramKCallable.getReturnType().getClassifier(), Reflection.getOrCreateKotlinClass(Unit.class))) && (!paramKCallable.getReturnType().isMarkedNullable())) {
      return (Object)Unit.INSTANCE;
    }
    return paramArrayOfObject;
    label275:
    paramArrayOfObject = new StringBuilder();
    paramArrayOfObject.append("Cannot callSuspend on a property ");
    paramArrayOfObject.append(paramKCallable);
    paramArrayOfObject.append(": suspend properties are not supported yet");
    throw ((Throwable)new IllegalArgumentException(paramArrayOfObject.toString()));
  }
  
  @SinceKotlin(version="1.3")
  @Nullable
  public static final <R> Object callSuspendBy(@NotNull KCallable<? extends R> paramKCallable, @NotNull Map<KParameter, ? extends Object> paramMap, @NotNull Continuation<? super R> paramContinuation)
  {
    if ((paramContinuation instanceof KCallables.callSuspendBy.1))
    {
      localObject1 = (KCallables.callSuspendBy.1)paramContinuation;
      if ((((KCallables.callSuspendBy.1)localObject1).label & 0x80000000) != 0)
      {
        ((KCallables.callSuspendBy.1)localObject1).label += -2147483648;
        paramContinuation = (Continuation<? super R>)localObject1;
        break label52;
      }
    }
    paramContinuation = new KCallables.callSuspendBy.1(paramContinuation);
    label52:
    Object localObject1 = paramContinuation.result;
    Object localObject2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    int i = paramContinuation.label;
    if (i != 0)
    {
      if (i == 1)
      {
        paramKCallable = (KCallableImpl)paramContinuation.L$2;
        paramKCallable = (Map)paramContinuation.L$1;
        paramKCallable = (KCallable)paramContinuation.L$0;
        ResultKt.throwOnFailure(localObject1);
        paramMap = (Map<KParameter, ? extends Object>)localObject1;
      }
      else
      {
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      }
    }
    else
    {
      ResultKt.throwOnFailure(localObject1);
      if (!paramKCallable.isSuspend()) {
        return paramKCallable.callBy(paramMap);
      }
      if (!(paramKCallable instanceof KFunction)) {
        break label302;
      }
      localObject1 = UtilKt.asKCallableImpl(paramKCallable);
      if (localObject1 == null) {
        break label266;
      }
      paramContinuation.L$0 = paramKCallable;
      paramContinuation.L$1 = paramMap;
      paramContinuation.L$2 = localObject1;
      paramContinuation.label = 1;
      Continuation localContinuation = (Continuation)paramContinuation;
      paramContinuation = ((KCallableImpl)localObject1).callDefaultMethod$kotlin_reflection(paramMap, localContinuation);
      if (paramContinuation == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
        DebugProbesKt.probeCoroutineSuspended(localContinuation);
      }
      paramMap = paramContinuation;
      if (paramContinuation == localObject2) {
        return localObject2;
      }
    }
    if ((Intrinsics.areEqual(paramKCallable.getReturnType().getClassifier(), Reflection.getOrCreateKotlinClass(Unit.class))) && (!paramKCallable.getReturnType().isMarkedNullable())) {
      return (Object)Unit.INSTANCE;
    }
    return paramMap;
    label266:
    paramMap = new StringBuilder();
    paramMap.append("This callable does not support a default call: ");
    paramMap.append(paramKCallable);
    throw ((Throwable)new KotlinReflectionInternalError(paramMap.toString()));
    label302:
    paramMap = new StringBuilder();
    paramMap.append("Cannot callSuspendBy on a property ");
    paramMap.append(paramKCallable);
    paramMap.append(": suspend properties are not supported yet");
    throw ((Throwable)new IllegalArgumentException(paramMap.toString()));
  }
  
  @SinceKotlin(version="1.1")
  @Nullable
  public static final KParameter findParameterByName(@NotNull KCallable<?> paramKCallable, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramKCallable, "$this$findParameterByName");
    Intrinsics.checkParameterIsNotNull(paramString, "name");
    Iterator localIterator = ((Iterable)paramKCallable.getParameters()).iterator();
    Object localObject1 = null;
    int i = 0;
    paramKCallable = null;
    while (localIterator.hasNext())
    {
      Object localObject2 = localIterator.next();
      if (Intrinsics.areEqual(((KParameter)localObject2).getName(), paramString))
      {
        if (i != 0)
        {
          paramKCallable = localObject1;
          break label96;
        }
        i = 1;
        paramKCallable = localObject2;
      }
    }
    if (i == 0) {
      paramKCallable = localObject1;
    }
    label96:
    return (KParameter)paramKCallable;
  }
  
  @Nullable
  public static final KParameter getExtensionReceiverParameter(@NotNull KCallable<?> paramKCallable)
  {
    Intrinsics.checkParameterIsNotNull(paramKCallable, "$this$extensionReceiverParameter");
    Iterator localIterator = ((Iterable)paramKCallable.getParameters()).iterator();
    Object localObject1 = null;
    paramKCallable = null;
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject2 = localIterator.next();
      int j;
      if (((KParameter)localObject2).getKind() == KParameter.Kind.EXTENSION_RECEIVER) {
        j = 1;
      } else {
        j = 0;
      }
      if (j != 0)
      {
        if (i != 0)
        {
          paramKCallable = localObject1;
          break label101;
        }
        paramKCallable = localObject2;
        i = 1;
      }
    }
    if (i == 0) {
      paramKCallable = localObject1;
    }
    label101:
    return (KParameter)paramKCallable;
  }
  
  @Nullable
  public static final KParameter getInstanceParameter(@NotNull KCallable<?> paramKCallable)
  {
    Intrinsics.checkParameterIsNotNull(paramKCallable, "$this$instanceParameter");
    Iterator localIterator = ((Iterable)paramKCallable.getParameters()).iterator();
    Object localObject1 = null;
    paramKCallable = null;
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject2 = localIterator.next();
      int j;
      if (((KParameter)localObject2).getKind() == KParameter.Kind.INSTANCE) {
        j = 1;
      } else {
        j = 0;
      }
      if (j != 0)
      {
        if (i != 0)
        {
          paramKCallable = localObject1;
          break label101;
        }
        paramKCallable = localObject2;
        i = 1;
      }
    }
    if (i == 0) {
      paramKCallable = localObject1;
    }
    label101:
    return (KParameter)paramKCallable;
  }
  
  @NotNull
  public static final List<KParameter> getValueParameters(@NotNull KCallable<?> paramKCallable)
  {
    Intrinsics.checkParameterIsNotNull(paramKCallable, "$this$valueParameters");
    Object localObject1 = (Iterable)paramKCallable.getParameters();
    paramKCallable = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      int i;
      if (((KParameter)localObject2).getKind() == KParameter.Kind.VALUE) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        paramKCallable.add(localObject2);
      }
    }
    return (List)paramKCallable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.full.KCallables
 * JD-Core Version:    0.7.0.1
 */