package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/internal/ContextScope;", "Lkotlinx/coroutines/CoroutineScope;", "context", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/coroutines/CoroutineContext;)V", "coroutineContext", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "toString", "", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public final class ContextScope
  implements CoroutineScope
{
  @NotNull
  private final CoroutineContext coroutineContext;
  
  public ContextScope(@NotNull CoroutineContext paramCoroutineContext)
  {
    this.coroutineContext = paramCoroutineContext;
  }
  
  @NotNull
  public CoroutineContext getCoroutineContext()
  {
    return this.coroutineContext;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CoroutineScope(coroutineContext=");
    localStringBuilder.append(getCoroutineContext());
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.internal.ContextScope
 * JD-Core Version:    0.7.0.1
 */