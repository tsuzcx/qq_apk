package kotlin.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref.IntRef;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke", "(Lkotlin/Unit;Lkotlin/coroutines/CoroutineContext$Element;)V"}, k=3, mv={1, 1, 16})
final class CombinedContext$writeReplace$1
  extends Lambda
  implements Function2<Unit, CoroutineContext.Element, Unit>
{
  CombinedContext$writeReplace$1(CoroutineContext[] paramArrayOfCoroutineContext, Ref.IntRef paramIntRef)
  {
    super(2);
  }
  
  public final void invoke(@NotNull Unit paramUnit, @NotNull CoroutineContext.Element paramElement)
  {
    Intrinsics.checkParameterIsNotNull(paramUnit, "<anonymous parameter 0>");
    Intrinsics.checkParameterIsNotNull(paramElement, "element");
    paramUnit = this.$elements;
    Ref.IntRef localIntRef = this.$index;
    int i = localIntRef.element;
    localIntRef.element = (i + 1);
    paramUnit[i] = ((CoroutineContext)paramElement);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.coroutines.CombinedContext.writeReplace.1
 * JD-Core Version:    0.7.0.1
 */