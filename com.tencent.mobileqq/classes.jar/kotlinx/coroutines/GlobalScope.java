package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/GlobalScope;", "Lkotlinx/coroutines/CoroutineScope;", "()V", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public final class GlobalScope
  implements CoroutineScope
{
  public static final GlobalScope INSTANCE = new GlobalScope();
  
  @NotNull
  public CoroutineContext getCoroutineContext()
  {
    return (CoroutineContext)EmptyCoroutineContext.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.GlobalScope
 * JD-Core Version:    0.7.0.1
 */