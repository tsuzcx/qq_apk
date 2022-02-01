package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.intrinsics.CancellableKt;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run", "kotlinx/coroutines/RunnableKt$Runnable$1"}, k=3, mv={1, 1, 16})
public final class SelectBuilderImpl$onTimeout$$inlined$Runnable$1
  implements Runnable
{
  public SelectBuilderImpl$onTimeout$$inlined$Runnable$1(SelectBuilderImpl paramSelectBuilderImpl, Function1 paramFunction1) {}
  
  public final void run()
  {
    if (this.this$0.trySelect()) {
      CancellableKt.startCoroutineCancellable(this.$block$inlined, this.this$0.getCompletion());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.selects.SelectBuilderImpl.onTimeout..inlined.Runnable.1
 * JD-Core Version:    0.7.0.1
 */