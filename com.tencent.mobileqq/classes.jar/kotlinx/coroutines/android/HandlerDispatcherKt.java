package kotlinx.coroutines.android;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.support.annotation.VisibleForTesting;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"MAX_DELAY", "", "Main", "Lkotlinx/coroutines/android/HandlerDispatcher;", "Main$annotations", "()V", "choreographer", "Landroid/view/Choreographer;", "awaitFrame", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "postFrameCallback", "", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "updateChoreographerAndPostFrameCallback", "asCoroutineDispatcher", "Landroid/os/Handler;", "name", "", "from", "asHandler", "Landroid/os/Looper;", "async", "", "kotlinx-coroutines-android"}, k=2, mv={1, 1, 16})
public final class HandlerDispatcherKt
{
  private static final long MAX_DELAY = 4611686018427387903L;
  @JvmField
  @Nullable
  public static final HandlerDispatcher Main;
  private static volatile Choreographer choreographer;
  
  static
  {
    Object localObject2;
    try
    {
      Object localObject1 = Result.Companion;
      localObject1 = Result.constructor-impl(new HandlerContext(asHandler(Looper.getMainLooper(), true), "Main"));
    }
    catch (Throwable localThrowable)
    {
      localObject3 = Result.Companion;
      localObject2 = Result.constructor-impl(ResultKt.createFailure(localThrowable));
    }
    Object localObject3 = localObject2;
    if (Result.isFailure-impl(localObject2)) {
      localObject3 = null;
    }
    Main = (HandlerDispatcher)localObject3;
  }
  
  @VisibleForTesting
  @NotNull
  public static final Handler asHandler(@NotNull Looper paramLooper, boolean paramBoolean)
  {
    if ((paramBoolean) && (Build.VERSION.SDK_INT >= 16)) {
      if (Build.VERSION.SDK_INT >= 28)
      {
        paramLooper = Handler.class.getDeclaredMethod("createAsync", new Class[] { Looper.class }).invoke(null, new Object[] { paramLooper });
        if (paramLooper != null) {
          return (Handler)paramLooper;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.os.Handler");
      }
    }
    try
    {
      Constructor localConstructor = Handler.class.getDeclaredConstructor(new Class[] { Looper.class, Handler.Callback.class, Boolean.TYPE });
      return (Handler)localConstructor.newInstance(new Object[] { paramLooper, null, Boolean.valueOf(true) });
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      label124:
      break label124;
    }
    return new Handler(paramLooper);
    return new Handler(paramLooper);
  }
  
  @Nullable
  public static final Object awaitFrame(@NotNull Continuation<? super Long> paramContinuation)
  {
    Object localObject1 = choreographer;
    if (localObject1 != null)
    {
      localObject2 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(paramContinuation), 1);
      access$postFrameCallback((Choreographer)localObject1, (CancellableContinuation)localObject2);
      localObject1 = ((CancellableContinuationImpl)localObject2).getResult();
      if (localObject1 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
        DebugProbesKt.probeCoroutineSuspended(paramContinuation);
      }
      return localObject1;
    }
    localObject1 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(paramContinuation), 1);
    Object localObject2 = (CancellableContinuation)localObject1;
    Dispatchers.getMain().dispatch((CoroutineContext)EmptyCoroutineContext.INSTANCE, (Runnable)new HandlerDispatcherKt..special..inlined.Runnable.1((CancellableContinuation)localObject2));
    localObject1 = ((CancellableContinuationImpl)localObject1).getResult();
    if (localObject1 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
      DebugProbesKt.probeCoroutineSuspended(paramContinuation);
    }
    return localObject1;
  }
  
  @JvmName(name="from")
  @JvmOverloads
  @NotNull
  public static final HandlerDispatcher from(@NotNull Handler paramHandler)
  {
    return from$default(paramHandler, null, 1, null);
  }
  
  @JvmName(name="from")
  @JvmOverloads
  @NotNull
  public static final HandlerDispatcher from(@NotNull Handler paramHandler, @Nullable String paramString)
  {
    return (HandlerDispatcher)new HandlerContext(paramHandler, paramString);
  }
  
  private static final void postFrameCallback(Choreographer paramChoreographer, CancellableContinuation<? super Long> paramCancellableContinuation)
  {
    paramChoreographer.postFrameCallback((Choreographer.FrameCallback)new HandlerDispatcherKt.postFrameCallback.1(paramCancellableContinuation));
  }
  
  private static final void updateChoreographerAndPostFrameCallback(CancellableContinuation<? super Long> paramCancellableContinuation)
  {
    Choreographer localChoreographer = choreographer;
    if (localChoreographer == null)
    {
      localChoreographer = Choreographer.getInstance();
      if (localChoreographer == null) {
        Intrinsics.throwNpe();
      }
      choreographer = localChoreographer;
    }
    postFrameCallback(localChoreographer, paramCancellableContinuation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.android.HandlerDispatcherKt
 * JD-Core Version:    0.7.0.1
 */