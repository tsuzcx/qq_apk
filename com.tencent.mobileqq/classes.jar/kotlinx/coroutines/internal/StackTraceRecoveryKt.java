package kotlinx.coroutines.internal;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.InternalCoroutinesApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"baseContinuationImplClass", "", "baseContinuationImplClassName", "kotlin.jvm.PlatformType", "stackTraceRecoveryClass", "stackTraceRecoveryClassName", "artificialFrame", "Ljava/lang/StackTraceElement;", "message", "createFinalException", "E", "", "cause", "result", "resultStackTrace", "Ljava/util/ArrayDeque;", "Lkotlinx/coroutines/internal/StackTraceElement;", "(Ljava/lang/Throwable;Ljava/lang/Throwable;Ljava/util/ArrayDeque;)Ljava/lang/Throwable;", "createStackTrace", "continuation", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "mergeRecoveredTraces", "", "recoveredStacktrace", "", "([Ljava/lang/StackTraceElement;Ljava/util/ArrayDeque;)V", "recoverAndThrow", "", "exception", "(Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "recoverFromStackFrame", "(Ljava/lang/Throwable;Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;)Ljava/lang/Throwable;", "recoverStackTrace", "(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "Lkotlin/coroutines/Continuation;", "(Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Throwable;", "unwrap", "unwrapImpl", "causeAndStacktrace", "Lkotlin/Pair;", "(Ljava/lang/Throwable;)Lkotlin/Pair;", "elementWiseEquals", "", "e", "frameIndex", "", "methodName", "([Ljava/lang/StackTraceElement;Ljava/lang/String;)I", "initCause", "isArtificial", "sanitizeStackTrace", "CoroutineStackFrame", "StackTraceElement", "kotlinx-coroutines-core"}, k=2, mv={1, 1, 16})
public final class StackTraceRecoveryKt
{
  private static final String baseContinuationImplClass = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
  private static final String baseContinuationImplClassName;
  private static final String stackTraceRecoveryClass = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
  private static final String stackTraceRecoveryClassName;
  
  static
  {
    String str = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
    Object localObject4 = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
    Object localObject2;
    try
    {
      Object localObject1 = Result.Companion;
      localObject1 = Result.constructor-impl(Class.forName("kotlin.coroutines.jvm.internal.BaseContinuationImpl").getCanonicalName());
    }
    catch (Throwable localThrowable1)
    {
      Result.Companion localCompanion = Result.Companion;
      localObject2 = Result.constructor-impl(ResultKt.createFailure(localThrowable1));
    }
    if (Result.exceptionOrNull-impl(localObject2) == null) {
      localObject4 = localObject2;
    }
    baseContinuationImplClassName = (String)localObject4;
    Object localObject3;
    try
    {
      localObject2 = Result.Companion;
      localObject2 = Result.constructor-impl(Class.forName("kotlinx.coroutines.internal.StackTraceRecoveryKt").getCanonicalName());
    }
    catch (Throwable localThrowable2)
    {
      localObject4 = Result.Companion;
      localObject3 = Result.constructor-impl(ResultKt.createFailure(localThrowable2));
    }
    localObject4 = str;
    if (Result.exceptionOrNull-impl(localObject3) == null) {
      localObject4 = localObject3;
    }
    stackTraceRecoveryClassName = (String)localObject4;
  }
  
  @InternalCoroutinesApi
  @NotNull
  public static final StackTraceElement artificialFrame(@NotNull String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\b\b\b(");
    localStringBuilder.append(paramString);
    return new StackTraceElement(localStringBuilder.toString(), "\b", "\b", -1);
  }
  
  private static final <E extends Throwable> Pair<E, StackTraceElement[]> causeAndStacktrace(@NotNull E paramE)
  {
    Throwable localThrowable = paramE.getCause();
    if ((localThrowable != null) && (Intrinsics.areEqual(localThrowable.getClass(), paramE.getClass())))
    {
      StackTraceElement[] arrayOfStackTraceElement = paramE.getStackTrace();
      int j = arrayOfStackTraceElement.length;
      int i = 0;
      while (i < j)
      {
        if (isArtificial(arrayOfStackTraceElement[i]))
        {
          i = 1;
          break label64;
        }
        i += 1;
      }
      i = 0;
      label64:
      if (i != 0) {
        return TuplesKt.to(localThrowable, arrayOfStackTraceElement);
      }
      return TuplesKt.to(paramE, new StackTraceElement[0]);
    }
    return TuplesKt.to(paramE, new StackTraceElement[0]);
  }
  
  private static final <E extends Throwable> E createFinalException(E paramE1, E paramE2, ArrayDeque<StackTraceElement> paramArrayDeque)
  {
    paramArrayDeque.addFirst(artificialFrame("Coroutine boundary"));
    StackTraceElement[] arrayOfStackTraceElement = paramE1.getStackTrace();
    int k = frameIndex(arrayOfStackTraceElement, baseContinuationImplClassName);
    int j = 0;
    if (k == -1)
    {
      paramE1 = ((Collection)paramArrayDeque).toArray(new StackTraceElement[0]);
      if (paramE1 != null)
      {
        paramE2.setStackTrace((StackTraceElement[])paramE1);
        return paramE2;
      }
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }
    paramE1 = new StackTraceElement[paramArrayDeque.size() + k];
    int i = 0;
    while (i < k)
    {
      paramE1[i] = arrayOfStackTraceElement[i];
      i += 1;
    }
    paramArrayDeque = ((Iterable)paramArrayDeque).iterator();
    i = j;
    while (paramArrayDeque.hasNext())
    {
      paramE1[(k + i)] = ((StackTraceElement)paramArrayDeque.next());
      i += 1;
    }
    paramE2.setStackTrace(paramE1);
    return paramE2;
  }
  
  private static final ArrayDeque<StackTraceElement> createStackTrace(CoroutineStackFrame paramCoroutineStackFrame)
  {
    ArrayDeque localArrayDeque = new ArrayDeque();
    StackTraceElement localStackTraceElement = paramCoroutineStackFrame.getStackTraceElement();
    CoroutineStackFrame localCoroutineStackFrame = paramCoroutineStackFrame;
    if (localStackTraceElement != null)
    {
      localArrayDeque.add(localStackTraceElement);
      localCoroutineStackFrame = paramCoroutineStackFrame;
    }
    for (;;)
    {
      paramCoroutineStackFrame = localCoroutineStackFrame;
      if (!(localCoroutineStackFrame instanceof CoroutineStackFrame)) {
        paramCoroutineStackFrame = null;
      }
      if (paramCoroutineStackFrame == null) {
        break;
      }
      paramCoroutineStackFrame = paramCoroutineStackFrame.getCallerFrame();
      if (paramCoroutineStackFrame == null) {
        break;
      }
      localStackTraceElement = paramCoroutineStackFrame.getStackTraceElement();
      localCoroutineStackFrame = paramCoroutineStackFrame;
      if (localStackTraceElement != null)
      {
        localArrayDeque.add(localStackTraceElement);
        localCoroutineStackFrame = paramCoroutineStackFrame;
      }
    }
    return localArrayDeque;
  }
  
  private static final boolean elementWiseEquals(@NotNull StackTraceElement paramStackTraceElement1, StackTraceElement paramStackTraceElement2)
  {
    return (paramStackTraceElement1.getLineNumber() == paramStackTraceElement2.getLineNumber()) && (Intrinsics.areEqual(paramStackTraceElement1.getMethodName(), paramStackTraceElement2.getMethodName())) && (Intrinsics.areEqual(paramStackTraceElement1.getFileName(), paramStackTraceElement2.getFileName())) && (Intrinsics.areEqual(paramStackTraceElement1.getClassName(), paramStackTraceElement2.getClassName()));
  }
  
  private static final int frameIndex(@NotNull StackTraceElement[] paramArrayOfStackTraceElement, String paramString)
  {
    int j = paramArrayOfStackTraceElement.length;
    int i = 0;
    while (i < j)
    {
      if (Intrinsics.areEqual(paramString, paramArrayOfStackTraceElement[i].getClassName())) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public static final void initCause(@NotNull Throwable paramThrowable1, @NotNull Throwable paramThrowable2)
  {
    paramThrowable1.initCause(paramThrowable2);
  }
  
  public static final boolean isArtificial(@NotNull StackTraceElement paramStackTraceElement)
  {
    return StringsKt.startsWith$default(paramStackTraceElement.getClassName(), "\b\b\b", false, 2, null);
  }
  
  private static final void mergeRecoveredTraces(StackTraceElement[] paramArrayOfStackTraceElement, ArrayDeque<StackTraceElement> paramArrayDeque)
  {
    int j = paramArrayOfStackTraceElement.length;
    int i = 0;
    while (i < j)
    {
      if (isArtificial(paramArrayOfStackTraceElement[i])) {
        break label31;
      }
      i += 1;
    }
    i = -1;
    label31:
    j = i + 1;
    i = paramArrayOfStackTraceElement.length - 1;
    if (i >= j) {
      for (;;)
      {
        if (elementWiseEquals(paramArrayOfStackTraceElement[i], (StackTraceElement)paramArrayDeque.getLast())) {
          paramArrayDeque.removeLast();
        }
        paramArrayDeque.addFirst(paramArrayOfStackTraceElement[i]);
        if (i == j) {
          break;
        }
        i -= 1;
      }
    }
  }
  
  @Nullable
  public static final Object recoverAndThrow(@NotNull Throwable paramThrowable, @NotNull Continuation<?> paramContinuation)
  {
    if (DebugKt.getRECOVER_STACK_TRACES())
    {
      if (!(paramContinuation instanceof CoroutineStackFrame)) {
        throw paramThrowable;
      }
      throw access$recoverFromStackFrame(paramThrowable, (CoroutineStackFrame)paramContinuation);
    }
    throw paramThrowable;
  }
  
  @Nullable
  private static final Object recoverAndThrow$$forInline(@NotNull Throwable paramThrowable, @NotNull Continuation paramContinuation)
  {
    if (DebugKt.getRECOVER_STACK_TRACES())
    {
      InlineMarker.mark(0);
      if (!(paramContinuation instanceof CoroutineStackFrame)) {
        throw paramThrowable;
      }
      throw access$recoverFromStackFrame(paramThrowable, (CoroutineStackFrame)paramContinuation);
    }
    throw paramThrowable;
  }
  
  private static final <E extends Throwable> E recoverFromStackFrame(E paramE, CoroutineStackFrame paramCoroutineStackFrame)
  {
    Object localObject = causeAndStacktrace(paramE);
    Throwable localThrowable1 = (Throwable)((Pair)localObject).component1();
    StackTraceElement[] arrayOfStackTraceElement = (StackTraceElement[])((Pair)localObject).component2();
    Throwable localThrowable2 = ExceptionsConstuctorKt.tryCopyException(localThrowable1);
    localObject = paramE;
    if (localThrowable2 != null)
    {
      if ((Intrinsics.areEqual(localThrowable2.getMessage(), localThrowable1.getMessage()) ^ true)) {
        return paramE;
      }
      paramCoroutineStackFrame = createStackTrace(paramCoroutineStackFrame);
      if (paramCoroutineStackFrame.isEmpty()) {
        return paramE;
      }
      if (localThrowable1 != paramE) {
        mergeRecoveredTraces(arrayOfStackTraceElement, paramCoroutineStackFrame);
      }
      localObject = createFinalException(localThrowable1, localThrowable2, paramCoroutineStackFrame);
    }
    return localObject;
  }
  
  @NotNull
  public static final <E extends Throwable> E recoverStackTrace(@NotNull E paramE)
  {
    if (!DebugKt.getRECOVER_STACK_TRACES()) {
      return paramE;
    }
    Throwable localThrowable = ExceptionsConstuctorKt.tryCopyException(paramE);
    if (localThrowable != null) {
      paramE = sanitizeStackTrace(localThrowable);
    }
    return paramE;
  }
  
  @NotNull
  public static final <E extends Throwable> E recoverStackTrace(@NotNull E paramE, @NotNull Continuation<?> paramContinuation)
  {
    Object localObject = paramE;
    if (DebugKt.getRECOVER_STACK_TRACES())
    {
      if (!(paramContinuation instanceof CoroutineStackFrame)) {
        return paramE;
      }
      localObject = access$recoverFromStackFrame(paramE, (CoroutineStackFrame)paramContinuation);
    }
    return localObject;
  }
  
  private static final <E extends Throwable> E sanitizeStackTrace(@NotNull E paramE)
  {
    StackTraceElement[] arrayOfStackTraceElement1 = paramE.getStackTrace();
    int m = arrayOfStackTraceElement1.length;
    int k = frameIndex(arrayOfStackTraceElement1, stackTraceRecoveryClassName);
    int i = frameIndex(arrayOfStackTraceElement1, baseContinuationImplClassName);
    int j = 0;
    if (i == -1) {
      i = 0;
    } else {
      i = m - i;
    }
    m = m - k - i;
    StackTraceElement[] arrayOfStackTraceElement2 = new StackTraceElement[m];
    i = j;
    while (i < m)
    {
      StackTraceElement localStackTraceElement;
      if (i == 0) {
        localStackTraceElement = artificialFrame("Coroutine boundary");
      } else {
        localStackTraceElement = arrayOfStackTraceElement1[(k + 1 + i - 1)];
      }
      arrayOfStackTraceElement2[i] = localStackTraceElement;
      i += 1;
    }
    paramE.setStackTrace(arrayOfStackTraceElement2);
    return paramE;
  }
  
  @NotNull
  public static final <E extends Throwable> E unwrap(@NotNull E paramE)
  {
    if (!DebugKt.getRECOVER_STACK_TRACES()) {
      return paramE;
    }
    return unwrapImpl(paramE);
  }
  
  @NotNull
  public static final <E extends Throwable> E unwrapImpl(@NotNull E paramE)
  {
    Throwable localThrowable = paramE.getCause();
    if (localThrowable != null)
    {
      boolean bool = Intrinsics.areEqual(localThrowable.getClass(), paramE.getClass());
      int j = 1;
      if ((bool ^ true)) {
        return paramE;
      }
      StackTraceElement[] arrayOfStackTraceElement = paramE.getStackTrace();
      int k = arrayOfStackTraceElement.length;
      int i = 0;
      while (i < k)
      {
        if (isArtificial(arrayOfStackTraceElement[i]))
        {
          i = j;
          break label77;
        }
        i += 1;
      }
      i = 0;
      label77:
      if (i != 0) {
        return localThrowable;
      }
    }
    return paramE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.internal.StackTraceRecoveryKt
 * JD-Core Version:    0.7.0.1
 */