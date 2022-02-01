package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "R", "invoke"}, k=3, mv={1, 1, 16})
final class UnbiasedSelectBuilderImpl$onTimeout$1
  extends Lambda
  implements Function0<Unit>
{
  UnbiasedSelectBuilderImpl$onTimeout$1(UnbiasedSelectBuilderImpl paramUnbiasedSelectBuilderImpl, long paramLong, Function1 paramFunction1)
  {
    super(0);
  }
  
  public final void invoke()
  {
    this.this$0.getInstance().onTimeout(this.$timeMillis, this.$block);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.selects.UnbiasedSelectBuilderImpl.onTimeout.1
 * JD-Core Version:    0.7.0.1
 */