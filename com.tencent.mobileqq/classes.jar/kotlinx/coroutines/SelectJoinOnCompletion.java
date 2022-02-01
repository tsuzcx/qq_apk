package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.selects.SelectInstance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/SelectJoinOnCompletion;", "R", "Lkotlinx/coroutines/JobNode;", "Lkotlinx/coroutines/JobSupport;", "job", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlinx/coroutines/JobSupport;Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function1;)V", "Lkotlin/jvm/functions/Function1;", "invoke", "", "cause", "", "toString", "", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
final class SelectJoinOnCompletion<R>
  extends JobNode<JobSupport>
{
  private final Function1<Continuation<? super R>, Object> block;
  private final SelectInstance<R> select;
  
  public SelectJoinOnCompletion(@NotNull JobSupport paramJobSupport, @NotNull SelectInstance<? super R> paramSelectInstance, @NotNull Function1<? super Continuation<? super R>, ? extends Object> paramFunction1)
  {
    super((Job)paramJobSupport);
    this.select = paramSelectInstance;
    this.block = paramFunction1;
  }
  
  public void invoke(@Nullable Throwable paramThrowable)
  {
    if (this.select.trySelect()) {
      CancellableKt.startCoroutineCancellable(this.block, this.select.getCompletion());
    }
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SelectJoinOnCompletion[");
    localStringBuilder.append(this.select);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.SelectJoinOnCompletion
 * JD-Core Version:    0.7.0.1
 */