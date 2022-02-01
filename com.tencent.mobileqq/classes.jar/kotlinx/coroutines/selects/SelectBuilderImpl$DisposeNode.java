package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/selects/SelectBuilderImpl$DisposeNode;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "handle", "Lkotlinx/coroutines/DisposableHandle;", "(Lkotlinx/coroutines/DisposableHandle;)V", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
final class SelectBuilderImpl$DisposeNode
  extends LockFreeLinkedListNode
{
  @JvmField
  @NotNull
  public final DisposableHandle handle;
  
  public SelectBuilderImpl$DisposeNode(@NotNull DisposableHandle paramDisposableHandle)
  {
    this.handle = paramDisposableHandle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.selects.SelectBuilderImpl.DisposeNode
 * JD-Core Version:    0.7.0.1
 */