package kotlinx.coroutines;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/DisposeOnCancel;", "Lkotlinx/coroutines/CancelHandler;", "handle", "Lkotlinx/coroutines/DisposableHandle;", "(Lkotlinx/coroutines/DisposableHandle;)V", "invoke", "", "cause", "", "toString", "", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
final class DisposeOnCancel
  extends CancelHandler
{
  private final DisposableHandle handle;
  
  public DisposeOnCancel(@NotNull DisposableHandle paramDisposableHandle)
  {
    this.handle = paramDisposableHandle;
  }
  
  public void invoke(@Nullable Throwable paramThrowable)
  {
    this.handle.dispose();
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DisposeOnCancel[");
    localStringBuilder.append(this.handle);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.DisposeOnCancel
 * JD-Core Version:    0.7.0.1
 */