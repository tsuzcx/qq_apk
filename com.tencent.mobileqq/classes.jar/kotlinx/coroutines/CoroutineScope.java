package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/CoroutineScope;", "", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public abstract interface CoroutineScope
{
  @NotNull
  public abstract CoroutineContext getCoroutineContext();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.CoroutineScope
 * JD-Core Version:    0.7.0.1
 */