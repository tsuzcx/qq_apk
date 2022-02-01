package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "Q", "R", "invoke"}, k=3, mv={1, 1, 16})
final class UnbiasedSelectBuilderImpl$invoke$2
  extends Lambda
  implements Function0<Unit>
{
  UnbiasedSelectBuilderImpl$invoke$2(UnbiasedSelectBuilderImpl paramUnbiasedSelectBuilderImpl, SelectClause1 paramSelectClause1, Function2 paramFunction2)
  {
    super(0);
  }
  
  public final void invoke()
  {
    this.$this_invoke.registerSelectClause1((SelectInstance)this.this$0.getInstance(), this.$block);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.selects.UnbiasedSelectBuilderImpl.invoke.2
 * JD-Core Version:    0.7.0.1
 */