package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.Key;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.internal.SystemPropsKt;
import kotlinx.coroutines.internal.ThreadContextKt;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"COROUTINES_SCHEDULER_PROPERTY_NAME", "", "DEBUG_THREAD_NAME_SEPARATOR", "useCoroutinesScheduler", "", "getUseCoroutinesScheduler", "()Z", "coroutineName", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineName", "(Lkotlin/coroutines/CoroutineContext;)Ljava/lang/String;", "createDefaultDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "withCoroutineContext", "T", "context", "countOrElement", "", "block", "Lkotlin/Function0;", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "newCoroutineContext", "Lkotlinx/coroutines/CoroutineScope;", "kotlinx-coroutines-core"}, k=2, mv={1, 1, 16})
public final class CoroutineContextKt
{
  @NotNull
  public static final String COROUTINES_SCHEDULER_PROPERTY_NAME = "kotlinx.coroutines.scheduler";
  private static final String DEBUG_THREAD_NAME_SEPARATOR = " @";
  private static final boolean useCoroutinesScheduler;
  
  static
  {
    String str = SystemPropsKt.systemProp("kotlinx.coroutines.scheduler");
    if (str != null)
    {
      int i = str.hashCode();
      if (i != 0)
      {
        if (i != 3551)
        {
          if ((i != 109935) || (!str.equals("off"))) {
            break label77;
          }
          bool = false;
          break label72;
        }
        if (!str.equals("on")) {
          break label77;
        }
      }
      else
      {
        if (!str.equals("")) {
          break label77;
        }
      }
    }
    boolean bool = true;
    label72:
    useCoroutinesScheduler = bool;
    return;
    label77:
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("System property 'kotlinx.coroutines.scheduler' has unrecognized value '");
    localStringBuilder.append(str);
    localStringBuilder.append('\'');
    throw ((Throwable)new IllegalStateException(localStringBuilder.toString().toString()));
  }
  
  @NotNull
  public static final CoroutineDispatcher createDefaultDispatcher()
  {
    Object localObject;
    if (useCoroutinesScheduler) {
      localObject = DefaultScheduler.INSTANCE;
    } else {
      localObject = CommonPool.INSTANCE;
    }
    return (CoroutineDispatcher)localObject;
  }
  
  @Nullable
  public static final String getCoroutineName(@NotNull CoroutineContext paramCoroutineContext)
  {
    if (!DebugKt.getDEBUG()) {
      return null;
    }
    CoroutineId localCoroutineId = (CoroutineId)paramCoroutineContext.get((CoroutineContext.Key)CoroutineId.Key);
    if (localCoroutineId != null)
    {
      paramCoroutineContext = (CoroutineName)paramCoroutineContext.get((CoroutineContext.Key)CoroutineName.Key);
      if (paramCoroutineContext != null)
      {
        paramCoroutineContext = paramCoroutineContext.getName();
        if (paramCoroutineContext != null) {}
      }
      else
      {
        paramCoroutineContext = "coroutine";
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramCoroutineContext);
      localStringBuilder.append('#');
      localStringBuilder.append(localCoroutineId.getId());
      return localStringBuilder.toString();
    }
    return null;
  }
  
  public static final boolean getUseCoroutinesScheduler()
  {
    return useCoroutinesScheduler;
  }
  
  @ExperimentalCoroutinesApi
  @NotNull
  public static final CoroutineContext newCoroutineContext(@NotNull CoroutineScope paramCoroutineScope, @NotNull CoroutineContext paramCoroutineContext)
  {
    CoroutineContext localCoroutineContext = paramCoroutineScope.getCoroutineContext().plus(paramCoroutineContext);
    if (DebugKt.getDEBUG()) {
      paramCoroutineScope = localCoroutineContext.plus((CoroutineContext)new CoroutineId(DebugKt.getCOROUTINE_ID().incrementAndGet()));
    } else {
      paramCoroutineScope = localCoroutineContext;
    }
    paramCoroutineContext = paramCoroutineScope;
    if (localCoroutineContext != Dispatchers.getDefault())
    {
      paramCoroutineContext = paramCoroutineScope;
      if (localCoroutineContext.get((CoroutineContext.Key)ContinuationInterceptor.Key) == null) {
        paramCoroutineContext = paramCoroutineScope.plus((CoroutineContext)Dispatchers.getDefault());
      }
    }
    return paramCoroutineContext;
  }
  
  public static final <T> T withCoroutineContext(@NotNull CoroutineContext paramCoroutineContext, @Nullable Object paramObject, @NotNull Function0<? extends T> paramFunction0)
  {
    paramObject = ThreadContextKt.updateThreadContext(paramCoroutineContext, paramObject);
    try
    {
      paramFunction0 = paramFunction0.invoke();
      return paramFunction0;
    }
    finally
    {
      InlineMarker.finallyStart(1);
      ThreadContextKt.restoreThreadContext(paramCoroutineContext, paramObject);
      InlineMarker.finallyEnd(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.CoroutineContextKt
 * JD-Core Version:    0.7.0.1
 */