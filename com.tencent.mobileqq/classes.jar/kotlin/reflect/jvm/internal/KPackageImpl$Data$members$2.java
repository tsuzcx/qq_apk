package kotlin.reflect.jvm.internal;

import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "invoke"}, k=3, mv={1, 1, 16})
final class KPackageImpl$Data$members$2
  extends Lambda
  implements Function0<Collection<? extends KCallableImpl<?>>>
{
  KPackageImpl$Data$members$2(KPackageImpl.Data paramData)
  {
    super(0);
  }
  
  @NotNull
  public final Collection<KCallableImpl<?>> invoke()
  {
    return this.this$0.this$0.getMembers(this.this$0.getScope(), KDeclarationContainerImpl.MemberBelonginess.DECLARED);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.KPackageImpl.Data.members.2
 * JD-Core Version:    0.7.0.1
 */