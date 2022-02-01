package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "R", "invoke", "()[Ljava/lang/Object;"}, k=3, mv={1, 1, 16})
public final class FlowKt__ZipKt$combineTransform$7$1
  extends Lambda
  implements Function0<T[]>
{
  public FlowKt__ZipKt$combineTransform$7$1(FlowKt__ZipKt.combineTransform.7 param7)
  {
    super(0);
  }
  
  @NotNull
  public final T[] invoke()
  {
    int i = this.this$0.$flowArray.length;
    Intrinsics.reifiedOperationMarker(0, "T?");
    return new Object[i];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.FlowKt__ZipKt.combineTransform.7.1
 * JD-Core Version:    0.7.0.1
 */