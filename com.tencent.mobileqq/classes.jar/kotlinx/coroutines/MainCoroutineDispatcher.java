package kotlinx.coroutines;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/MainCoroutineDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "()V", "immediate", "getImmediate", "()Lkotlinx/coroutines/MainCoroutineDispatcher;", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public abstract class MainCoroutineDispatcher
  extends CoroutineDispatcher
{
  @NotNull
  public abstract MainCoroutineDispatcher getImmediate();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.MainCoroutineDispatcher
 * JD-Core Version:    0.7.0.1
 */