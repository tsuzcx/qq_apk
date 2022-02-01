package kotlin.concurrent;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"thread", "Ljava/lang/Thread;", "start", "", "isDaemon", "contextClassLoader", "Ljava/lang/ClassLoader;", "name", "", "priority", "", "block", "Lkotlin/Function0;", "", "getOrSet", "T", "", "Ljava/lang/ThreadLocal;", "default", "(Ljava/lang/ThreadLocal;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "kotlin-stdlib"}, k=2, mv={1, 1, 16})
@JvmName(name="ThreadsKt")
public final class ThreadsKt
{
  @InlineOnly
  private static final <T> T getOrSet(@NotNull ThreadLocal<T> paramThreadLocal, Function0<? extends T> paramFunction0)
  {
    Object localObject = paramThreadLocal.get();
    if (localObject != null) {
      return localObject;
    }
    paramFunction0 = paramFunction0.invoke();
    paramThreadLocal.set(paramFunction0);
    return paramFunction0;
  }
  
  @NotNull
  public static final Thread thread(boolean paramBoolean1, boolean paramBoolean2, @Nullable ClassLoader paramClassLoader, @Nullable String paramString, int paramInt, @NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "block");
    paramFunction0 = new ThreadsKt.thread.thread.1(paramFunction0);
    if (paramBoolean2) {
      paramFunction0.setDaemon(true);
    }
    if (paramInt > 0) {
      paramFunction0.setPriority(paramInt);
    }
    if (paramString != null) {
      paramFunction0.setName(paramString);
    }
    if (paramClassLoader != null) {
      paramFunction0.setContextClassLoader(paramClassLoader);
    }
    if (paramBoolean1) {
      paramFunction0.start();
    }
    return (Thread)paramFunction0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.concurrent.ThreadsKt
 * JD-Core Version:    0.7.0.1
 */