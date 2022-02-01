package kotlinx.coroutines;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"newFixedThreadPoolContext", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "nThreads", "", "name", "", "newSingleThreadContext", "kotlinx-coroutines-core"}, k=2, mv={1, 1, 16})
public final class ThreadPoolDispatcherKt
{
  @ObsoleteCoroutinesApi
  @NotNull
  public static final ExecutorCoroutineDispatcher newFixedThreadPoolContext(int paramInt, @NotNull String paramString)
  {
    int i = 1;
    if (paramInt < 1) {
      i = 0;
    }
    if (i != 0) {
      return (ExecutorCoroutineDispatcher)new ThreadPoolDispatcher(paramInt, paramString);
    }
    paramString = new StringBuilder();
    paramString.append("Expected at least one thread, but ");
    paramString.append(paramInt);
    paramString.append(" specified");
    throw ((Throwable)new IllegalArgumentException(paramString.toString().toString()));
  }
  
  @ObsoleteCoroutinesApi
  @NotNull
  public static final ExecutorCoroutineDispatcher newSingleThreadContext(@NotNull String paramString)
  {
    return newFixedThreadPoolContext(1, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.ThreadPoolDispatcherKt
 * JD-Core Version:    0.7.0.1
 */