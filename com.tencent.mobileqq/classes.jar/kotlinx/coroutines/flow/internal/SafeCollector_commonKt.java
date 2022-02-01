package kotlinx.coroutines.flow.internal;

import kotlin.BuilderInference;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.internal.ScopeCoroutine;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"unsafeFlow", "Lkotlinx/coroutines/flow/Flow;", "T", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "checkContext", "Lkotlinx/coroutines/flow/internal/SafeCollector;", "currentContext", "Lkotlin/coroutines/CoroutineContext;", "transitiveCoroutineParent", "Lkotlinx/coroutines/Job;", "collectJob", "kotlinx-coroutines-core"}, k=2, mv={1, 1, 16})
public final class SafeCollector_commonKt
{
  @JvmName(name="checkContext")
  public static final void checkContext(@NotNull SafeCollector<?> paramSafeCollector, @NotNull CoroutineContext paramCoroutineContext)
  {
    if (((Number)paramCoroutineContext.fold(Integer.valueOf(0), (Function2)new SafeCollector_commonKt.checkContext.result.1(paramSafeCollector))).intValue() == paramSafeCollector.collectContextSize) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Flow invariant is violated:\n");
    localStringBuilder.append("\t\tFlow was collected in ");
    localStringBuilder.append(paramSafeCollector.collectContext);
    localStringBuilder.append(",\n");
    localStringBuilder.append("\t\tbut emission happened in ");
    localStringBuilder.append(paramCoroutineContext);
    localStringBuilder.append(".\n");
    localStringBuilder.append("\t\tPlease refer to 'flow' documentation or use 'flowOn' instead");
    throw ((Throwable)new IllegalStateException(localStringBuilder.toString().toString()));
  }
  
  @Nullable
  public static final Job transitiveCoroutineParent(@Nullable Job paramJob1, @Nullable Job paramJob2)
  {
    for (;;)
    {
      if (paramJob1 == null) {
        return null;
      }
      if (paramJob1 == paramJob2) {
        return paramJob1;
      }
      if (!(paramJob1 instanceof ScopeCoroutine)) {
        return paramJob1;
      }
      paramJob1 = ((ScopeCoroutine)paramJob1).getParent$kotlinx_coroutines_core();
    }
  }
  
  @PublishedApi
  @NotNull
  public static final <T> Flow<T> unsafeFlow(@BuilderInference @NotNull Function2<? super FlowCollector<? super T>, ? super Continuation<? super Unit>, ? extends Object> paramFunction2)
  {
    return (Flow)new SafeCollector_commonKt.unsafeFlow.1(paramFunction2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.internal.SafeCollector_commonKt
 * JD-Core Version:    0.7.0.1
 */