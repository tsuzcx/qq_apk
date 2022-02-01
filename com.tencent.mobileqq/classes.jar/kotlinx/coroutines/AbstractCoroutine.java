package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.Key;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/AbstractCoroutine;", "T", "Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/Job;", "Lkotlin/coroutines/Continuation;", "Lkotlinx/coroutines/CoroutineScope;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "active", "", "(Lkotlin/coroutines/CoroutineContext;Z)V", "context", "context$annotations", "()V", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "getCoroutineContext", "isActive", "()Z", "afterResume", "", "state", "", "cancellationExceptionMessage", "", "handleOnCompletionException", "exception", "", "handleOnCompletionException$kotlinx_coroutines_core", "initParentJob", "initParentJob$kotlinx_coroutines_core", "nameString", "nameString$kotlinx_coroutines_core", "onCancelled", "cause", "handled", "onCompleted", "value", "(Ljava/lang/Object;)V", "onCompletionInternal", "onStart", "onStartInternal", "onStartInternal$kotlinx_coroutines_core", "resumeWith", "result", "Lkotlin/Result;", "start", "R", "Lkotlinx/coroutines/CoroutineStart;", "receiver", "block", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/CoroutineStart;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/Function1;", "(Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function1;)V", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
@InternalCoroutinesApi
public abstract class AbstractCoroutine<T>
  extends JobSupport
  implements Continuation<T>, CoroutineScope, Job
{
  @NotNull
  private final CoroutineContext context;
  @JvmField
  @NotNull
  protected final CoroutineContext parentContext;
  
  public AbstractCoroutine(@NotNull CoroutineContext paramCoroutineContext, boolean paramBoolean)
  {
    super(paramBoolean);
    this.parentContext = paramCoroutineContext;
    this.context = this.parentContext.plus((CoroutineContext)this);
  }
  
  protected void afterResume(@Nullable Object paramObject)
  {
    afterCompletion(paramObject);
  }
  
  @NotNull
  protected String cancellationExceptionMessage()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(DebugStringsKt.getClassSimpleName(this));
    localStringBuilder.append(" was cancelled");
    return localStringBuilder.toString();
  }
  
  @NotNull
  public final CoroutineContext getContext()
  {
    return this.context;
  }
  
  @NotNull
  public CoroutineContext getCoroutineContext()
  {
    return this.context;
  }
  
  public final void handleOnCompletionException$kotlinx_coroutines_core(@NotNull Throwable paramThrowable)
  {
    CoroutineExceptionHandlerKt.handleCoroutineException(this.context, paramThrowable);
  }
  
  public final void initParentJob$kotlinx_coroutines_core()
  {
    initParentJobInternal$kotlinx_coroutines_core((Job)this.parentContext.get((CoroutineContext.Key)Job.Key));
  }
  
  public boolean isActive()
  {
    return super.isActive();
  }
  
  @NotNull
  public String nameString$kotlinx_coroutines_core()
  {
    String str = CoroutineContextKt.getCoroutineName(this.context);
    if (str != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append('"');
      localStringBuilder.append(str);
      localStringBuilder.append("\":");
      localStringBuilder.append(super.nameString$kotlinx_coroutines_core());
      return localStringBuilder.toString();
    }
    return super.nameString$kotlinx_coroutines_core();
  }
  
  protected void onCancelled(@NotNull Throwable paramThrowable, boolean paramBoolean) {}
  
  protected void onCompleted(T paramT) {}
  
  protected final void onCompletionInternal(@Nullable Object paramObject)
  {
    if ((paramObject instanceof CompletedExceptionally))
    {
      paramObject = (CompletedExceptionally)paramObject;
      onCancelled(paramObject.cause, paramObject.getHandled());
      return;
    }
    onCompleted(paramObject);
  }
  
  protected void onStart() {}
  
  public final void onStartInternal$kotlinx_coroutines_core()
  {
    onStart();
  }
  
  public final void resumeWith(@NotNull Object paramObject)
  {
    paramObject = makeCompletingOnce$kotlinx_coroutines_core(CompletedExceptionallyKt.toState(paramObject));
    if (paramObject == JobSupportKt.COMPLETING_WAITING_CHILDREN) {
      return;
    }
    afterResume(paramObject);
  }
  
  public final <R> void start(@NotNull CoroutineStart paramCoroutineStart, R paramR, @NotNull Function2<? super R, ? super Continuation<? super T>, ? extends Object> paramFunction2)
  {
    initParentJob$kotlinx_coroutines_core();
    paramCoroutineStart.invoke(paramFunction2, paramR, (Continuation)this);
  }
  
  public final void start(@NotNull CoroutineStart paramCoroutineStart, @NotNull Function1<? super Continuation<? super T>, ? extends Object> paramFunction1)
  {
    initParentJob$kotlinx_coroutines_core();
    paramCoroutineStart.invoke(paramFunction1, (Continuation)this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.AbstractCoroutine
 * JD-Core Version:    0.7.0.1
 */