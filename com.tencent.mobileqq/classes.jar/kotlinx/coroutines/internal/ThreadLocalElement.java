package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.Element;
import kotlin.coroutines.CoroutineContext.Key;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ThreadContextElement;
import kotlinx.coroutines.ThreadContextElement.DefaultImpls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/internal/ThreadLocalElement;", "T", "Lkotlinx/coroutines/ThreadContextElement;", "value", "threadLocal", "Ljava/lang/ThreadLocal;", "(Ljava/lang/Object;Ljava/lang/ThreadLocal;)V", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "Ljava/lang/Object;", "get", "E", "Lkotlin/coroutines/CoroutineContext$Element;", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "minusKey", "Lkotlin/coroutines/CoroutineContext;", "restoreThreadContext", "", "context", "oldState", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;)V", "toString", "", "updateThreadContext", "(Lkotlin/coroutines/CoroutineContext;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public final class ThreadLocalElement<T>
  implements ThreadContextElement<T>
{
  @NotNull
  private final CoroutineContext.Key<?> key;
  private final ThreadLocal<T> threadLocal;
  private final T value;
  
  public ThreadLocalElement(T paramT, @NotNull ThreadLocal<T> paramThreadLocal)
  {
    this.value = paramT;
    this.threadLocal = paramThreadLocal;
    this.key = ((CoroutineContext.Key)new ThreadLocalKey(this.threadLocal));
  }
  
  public <R> R fold(R paramR, @NotNull Function2<? super R, ? super CoroutineContext.Element, ? extends R> paramFunction2)
  {
    return ThreadContextElement.DefaultImpls.fold(this, paramR, paramFunction2);
  }
  
  @Nullable
  public <E extends CoroutineContext.Element> E get(@NotNull CoroutineContext.Key<E> paramKey)
  {
    if (Intrinsics.areEqual(getKey(), paramKey)) {
      return (CoroutineContext.Element)this;
    }
    return null;
  }
  
  @NotNull
  public CoroutineContext.Key<?> getKey()
  {
    return this.key;
  }
  
  @NotNull
  public CoroutineContext minusKey(@NotNull CoroutineContext.Key<?> paramKey)
  {
    if (Intrinsics.areEqual(getKey(), paramKey)) {
      return (CoroutineContext)EmptyCoroutineContext.INSTANCE;
    }
    return (CoroutineContext)this;
  }
  
  @NotNull
  public CoroutineContext plus(@NotNull CoroutineContext paramCoroutineContext)
  {
    return ThreadContextElement.DefaultImpls.plus(this, paramCoroutineContext);
  }
  
  public void restoreThreadContext(@NotNull CoroutineContext paramCoroutineContext, T paramT)
  {
    this.threadLocal.set(paramT);
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ThreadLocal(value=");
    localStringBuilder.append(this.value);
    localStringBuilder.append(", threadLocal = ");
    localStringBuilder.append(this.threadLocal);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
  
  public T updateThreadContext(@NotNull CoroutineContext paramCoroutineContext)
  {
    paramCoroutineContext = this.threadLocal.get();
    this.threadLocal.set(this.value);
    return paramCoroutineContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.internal.ThreadLocalElement
 * JD-Core Version:    0.7.0.1
 */