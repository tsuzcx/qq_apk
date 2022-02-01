package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "P", "Q", "R", "invoke"}, k=3, mv={1, 1, 16})
final class UnbiasedSelectBuilderImpl$invoke$3
  extends Lambda
  implements Function0<Unit>
{
  UnbiasedSelectBuilderImpl$invoke$3(UnbiasedSelectBuilderImpl paramUnbiasedSelectBuilderImpl, SelectClause2 paramSelectClause2, Object paramObject, Function2 paramFunction2)
  {
    super(0);
  }
  
  public final void invoke()
  {
    this.$this_invoke.registerSelectClause2((SelectInstance)this.this$0.getInstance(), this.$param, this.$block);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.selects.UnbiasedSelectBuilderImpl.invoke.3
 * JD-Core Version:    0.7.0.1
 */