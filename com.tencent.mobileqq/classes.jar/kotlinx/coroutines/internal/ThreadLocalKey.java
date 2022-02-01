package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.coroutines.CoroutineContext.Key;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/internal/ThreadLocalKey;", "Lkotlin/coroutines/CoroutineContext$Key;", "Lkotlinx/coroutines/internal/ThreadLocalElement;", "threadLocal", "Ljava/lang/ThreadLocal;", "(Ljava/lang/ThreadLocal;)V", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
@PublishedApi
public final class ThreadLocalKey
  implements CoroutineContext.Key<ThreadLocalElement<?>>
{
  private final ThreadLocal<?> threadLocal;
  
  public ThreadLocalKey(@NotNull ThreadLocal<?> paramThreadLocal)
  {
    this.threadLocal = paramThreadLocal;
  }
  
  private final ThreadLocal<?> component1()
  {
    return this.threadLocal;
  }
  
  @NotNull
  public final ThreadLocalKey copy(@NotNull ThreadLocal<?> paramThreadLocal)
  {
    return new ThreadLocalKey(paramThreadLocal);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof ThreadLocalKey))
      {
        paramObject = (ThreadLocalKey)paramObject;
        if (Intrinsics.areEqual(this.threadLocal, paramObject.threadLocal)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    ThreadLocal localThreadLocal = this.threadLocal;
    if (localThreadLocal != null) {
      return localThreadLocal.hashCode();
    }
    return 0;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ThreadLocalKey(threadLocal=");
    localStringBuilder.append(this.threadLocal);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.internal.ThreadLocalKey
 * JD-Core Version:    0.7.0.1
 */