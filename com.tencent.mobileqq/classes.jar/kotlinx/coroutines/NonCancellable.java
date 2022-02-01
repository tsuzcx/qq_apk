package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext.Key;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.selects.SelectClause0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/NonCancellable;", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/Job;", "()V", "children", "Lkotlin/sequences/Sequence;", "children$annotations", "getChildren", "()Lkotlin/sequences/Sequence;", "isActive", "", "isActive$annotations", "()Z", "isCancelled", "isCancelled$annotations", "isCompleted", "isCompleted$annotations", "onJoin", "Lkotlinx/coroutines/selects/SelectClause0;", "getOnJoin", "()Lkotlinx/coroutines/selects/SelectClause0;", "attachChild", "Lkotlinx/coroutines/ChildHandle;", "child", "Lkotlinx/coroutines/ChildJob;", "cancel", "cause", "", "", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "getCancellationException", "invokeOnCompletion", "Lkotlinx/coroutines/DisposableHandle;", "onCancelling", "invokeImmediately", "handler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "join", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "start", "toString", "", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public final class NonCancellable
  extends AbstractCoroutineContextElement
  implements Job
{
  public static final NonCancellable INSTANCE = new NonCancellable();
  
  private NonCancellable()
  {
    super((CoroutineContext.Key)Job.Key);
  }
  
  @InternalCoroutinesApi
  @NotNull
  public ChildHandle attachChild(@NotNull ChildJob paramChildJob)
  {
    return (ChildHandle)NonDisposableHandle.INSTANCE;
  }
  
  @InternalCoroutinesApi
  public void cancel(@Nullable CancellationException paramCancellationException) {}
  
  @InternalCoroutinesApi
  @NotNull
  public CancellationException getCancellationException()
  {
    throw ((Throwable)new IllegalStateException("This job is always active"));
  }
  
  @NotNull
  public Sequence<Job> getChildren()
  {
    return SequencesKt.emptySequence();
  }
  
  @NotNull
  public SelectClause0 getOnJoin()
  {
    throw ((Throwable)new UnsupportedOperationException("This job is always active"));
  }
  
  @InternalCoroutinesApi
  @NotNull
  public DisposableHandle invokeOnCompletion(@NotNull Function1<? super Throwable, Unit> paramFunction1)
  {
    return (DisposableHandle)NonDisposableHandle.INSTANCE;
  }
  
  @InternalCoroutinesApi
  @NotNull
  public DisposableHandle invokeOnCompletion(boolean paramBoolean1, boolean paramBoolean2, @NotNull Function1<? super Throwable, Unit> paramFunction1)
  {
    return (DisposableHandle)NonDisposableHandle.INSTANCE;
  }
  
  public boolean isActive()
  {
    return true;
  }
  
  public boolean isCancelled()
  {
    return false;
  }
  
  public boolean isCompleted()
  {
    return false;
  }
  
  @InternalCoroutinesApi
  @Nullable
  public Object join(@NotNull Continuation<? super Unit> paramContinuation)
  {
    throw ((Throwable)new UnsupportedOperationException("This job is always active"));
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
  @NotNull
  public Job plus(@NotNull Job paramJob)
  {
    return Job.DefaultImpls.plus(this, paramJob);
  }
  
  @InternalCoroutinesApi
  public boolean start()
  {
    return false;
  }
  
  @NotNull
  public String toString()
  {
    return "NonCancellable";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.NonCancellable
 * JD-Core Version:    0.7.0.1
 */