package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.Element;
import kotlin.coroutines.CoroutineContext.Key;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "count", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke"}, k=3, mv={1, 1, 16})
final class SafeCollector_commonKt$checkContext$result$1
  extends Lambda
  implements Function2<Integer, CoroutineContext.Element, Integer>
{
  SafeCollector_commonKt$checkContext$result$1(SafeCollector paramSafeCollector)
  {
    super(2);
  }
  
  public final int invoke(int paramInt, @NotNull CoroutineContext.Element paramElement)
  {
    Object localObject1 = paramElement.getKey();
    Object localObject2 = this.$this_checkContext.collectContext.get((CoroutineContext.Key)localObject1);
    if (localObject1 != Job.Key)
    {
      if (paramElement != localObject2) {
        return -2147483648;
      }
      return paramInt + 1;
    }
    localObject1 = (Job)localObject2;
    if (paramElement != null)
    {
      paramElement = SafeCollector_commonKt.transitiveCoroutineParent((Job)paramElement, (Job)localObject1);
      if (paramElement == localObject1)
      {
        if (localObject1 == null) {
          return paramInt;
        }
        return paramInt + 1;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Flow invariant is violated:\n\t\tEmission from another coroutine is detected.\n");
      ((StringBuilder)localObject2).append("\t\tChild of ");
      ((StringBuilder)localObject2).append(paramElement);
      ((StringBuilder)localObject2).append(", expected child of ");
      ((StringBuilder)localObject2).append(localObject1);
      ((StringBuilder)localObject2).append(".\n");
      ((StringBuilder)localObject2).append("\t\tFlowCollector is not thread-safe and concurrent emissions are prohibited.\n");
      ((StringBuilder)localObject2).append("\t\tTo mitigate this restriction please use 'channelFlow' builder instead of 'flow'");
      throw ((Throwable)new IllegalStateException(((StringBuilder)localObject2).toString().toString()));
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.Job");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.internal.SafeCollector_commonKt.checkContext.result.1
 * JD-Core Version:    0.7.0.1
 */