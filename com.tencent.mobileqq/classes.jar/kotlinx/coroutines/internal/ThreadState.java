package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/internal/ThreadState;", "", "context", "Lkotlin/coroutines/CoroutineContext;", "n", "", "(Lkotlin/coroutines/CoroutineContext;I)V", "a", "", "[Ljava/lang/Object;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "i", "append", "", "value", "start", "take", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
final class ThreadState
{
  private Object[] a;
  @NotNull
  private final CoroutineContext context;
  private int i;
  
  public ThreadState(@NotNull CoroutineContext paramCoroutineContext, int paramInt)
  {
    this.context = paramCoroutineContext;
    this.a = new Object[paramInt];
  }
  
  public final void append(@Nullable Object paramObject)
  {
    Object[] arrayOfObject = this.a;
    int j = this.i;
    this.i = (j + 1);
    arrayOfObject[j] = paramObject;
  }
  
  @NotNull
  public final CoroutineContext getContext()
  {
    return this.context;
  }
  
  public final void start()
  {
    this.i = 0;
  }
  
  @Nullable
  public final Object take()
  {
    Object[] arrayOfObject = this.a;
    int j = this.i;
    this.i = (j + 1);
    return arrayOfObject[j];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.internal.ThreadState
 * JD-Core Version:    0.7.0.1
 */