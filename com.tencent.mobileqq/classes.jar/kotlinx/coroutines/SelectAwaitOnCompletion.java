package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.selects.SelectInstance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/SelectAwaitOnCompletion;", "T", "R", "Lkotlinx/coroutines/JobNode;", "Lkotlinx/coroutines/JobSupport;", "job", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlinx/coroutines/JobSupport;Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "invoke", "", "cause", "", "toString", "", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
final class SelectAwaitOnCompletion<T, R>
  extends JobNode<JobSupport>
{
  private final Function2<T, Continuation<? super R>, Object> block;
  private final SelectInstance<R> select;
  
  public SelectAwaitOnCompletion(@NotNull JobSupport paramJobSupport, @NotNull SelectInstance<? super R> paramSelectInstance, @NotNull Function2<? super T, ? super Continuation<? super R>, ? extends Object> paramFunction2)
  {
    super((Job)paramJobSupport);
    this.select = paramSelectInstance;
    this.block = paramFunction2;
  }
  
  public void invoke(@Nullable Throwable paramThrowable)
  {
    if (this.select.trySelect()) {
      ((JobSupport)this.job).selectAwaitCompletion$kotlinx_coroutines_core(this.select, this.block);
    }
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SelectAwaitOnCompletion[");
    localStringBuilder.append(this.select);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.SelectAwaitOnCompletion
 * JD-Core Version:    0.7.0.1
 */