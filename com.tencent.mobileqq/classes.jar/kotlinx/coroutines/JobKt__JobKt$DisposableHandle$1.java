package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlinx/coroutines/JobKt__JobKt$DisposableHandle$1", "Lkotlinx/coroutines/DisposableHandle;", "dispose", "", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public final class JobKt__JobKt$DisposableHandle$1
  implements DisposableHandle
{
  public JobKt__JobKt$DisposableHandle$1(Function0 paramFunction0) {}
  
  public void dispose()
  {
    this.$block.invoke();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.JobKt__JobKt.DisposableHandle.1
 * JD-Core Version:    0.7.0.1
 */