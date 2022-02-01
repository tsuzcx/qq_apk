package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "it", "", "invoke"}, k=3, mv={1, 1, 16})
final class FlowKt__ErrorsKt$onErrorCollect$1
  extends Lambda
  implements Function1<Throwable, Boolean>
{
  public static final 1 INSTANCE = new 1();
  
  FlowKt__ErrorsKt$onErrorCollect$1()
  {
    super(1);
  }
  
  public final boolean invoke(@NotNull Throwable paramThrowable)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.FlowKt__ErrorsKt.onErrorCollect.1
 * JD-Core Version:    0.7.0.1
 */