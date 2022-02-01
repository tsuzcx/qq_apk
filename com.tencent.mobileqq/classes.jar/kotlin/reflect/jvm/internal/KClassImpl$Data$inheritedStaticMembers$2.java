package kotlin.reflect.jvm.internal;

import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "T", "", "invoke"}, k=3, mv={1, 1, 16})
final class KClassImpl$Data$inheritedStaticMembers$2
  extends Lambda
  implements Function0<Collection<? extends KCallableImpl<?>>>
{
  KClassImpl$Data$inheritedStaticMembers$2(KClassImpl.Data paramData)
  {
    super(0);
  }
  
  @NotNull
  public final Collection<KCallableImpl<?>> invoke()
  {
    return this.this$0.this$0.getMembers(this.this$0.this$0.getStaticScope$kotlin_reflection(), KDeclarationContainerImpl.MemberBelonginess.INHERITED);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.KClassImpl.Data.inheritedStaticMembers.2
 * JD-Core Version:    0.7.0.1
 */