package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext.Element;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.selects.SelectClause0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/Job;", "Lkotlin/coroutines/CoroutineContext$Element;", "children", "Lkotlin/sequences/Sequence;", "getChildren", "()Lkotlin/sequences/Sequence;", "isActive", "", "()Z", "isCancelled", "isCompleted", "onJoin", "Lkotlinx/coroutines/selects/SelectClause0;", "getOnJoin", "()Lkotlinx/coroutines/selects/SelectClause0;", "attachChild", "Lkotlinx/coroutines/ChildHandle;", "child", "Lkotlinx/coroutines/ChildJob;", "cancel", "", "cause", "", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "getCancellationException", "invokeOnCompletion", "Lkotlinx/coroutines/DisposableHandle;", "onCancelling", "invokeImmediately", "handler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "join", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "plus", "other", "start", "Key", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public abstract interface Job
  extends CoroutineContext.Element
{
  public static final Job.Key Key = Job.Key.$$INSTANCE;
  
  @InternalCoroutinesApi
  @NotNull
  public abstract ChildHandle attachChild(@NotNull ChildJob paramChildJob);
  
  public abstract void cancel(@Nullable CancellationException paramCancellationException);
  
  @InternalCoroutinesApi
  @NotNull
  public abstract CancellationException getCancellationException();
  
  @NotNull
  public abstract Sequence<Job> getChildren();
  
  @NotNull
  public abstract SelectClause0 getOnJoin();
  
  @NotNull
  public abstract DisposableHandle invokeOnCompletion(@NotNull Function1<? super Throwable, Unit> paramFunction1);
  
  @InternalCoroutinesApi
  @NotNull
  public abstract DisposableHandle invokeOnCompletion(boolean paramBoolean1, boolean paramBoolean2, @NotNull Function1<? super Throwable, Unit> paramFunction1);
  
  public abstract boolean isActive();
  
  public abstract boolean isCancelled();
  
  public abstract boolean isCompleted();
  
  @Nullable
  public abstract Object join(@NotNull Continuation<? super Unit> paramContinuation);
  
  @Deprecated(level=DeprecationLevel.ERROR, message="Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
  @NotNull
  public abstract Job plus(@NotNull Job paramJob);
  
  public abstract boolean start();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.Job
 * JD-Core Version:    0.7.0.1
 */