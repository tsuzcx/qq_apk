package kotlinx.coroutines;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/NonDisposableHandle;", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/ChildHandle;", "()V", "childCancelled", "", "cause", "", "dispose", "", "toString", "", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
@InternalCoroutinesApi
public final class NonDisposableHandle
  implements ChildHandle, DisposableHandle
{
  public static final NonDisposableHandle INSTANCE = new NonDisposableHandle();
  
  public boolean childCancelled(@NotNull Throwable paramThrowable)
  {
    return false;
  }
  
  public void dispose() {}
  
  @NotNull
  public String toString()
  {
    return "NonDisposableHandle";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.NonDisposableHandle
 * JD-Core Version:    0.7.0.1
 */