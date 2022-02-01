package kotlin.reflect.jvm.internal;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "T", "", "invoke"}, k=3, mv={1, 1, 16})
final class KClassImpl$Data$allStaticMembers$2
  extends Lambda
  implements Function0<List<? extends KCallableImpl<?>>>
{
  KClassImpl$Data$allStaticMembers$2(KClassImpl.Data paramData)
  {
    super(0);
  }
  
  @NotNull
  public final List<KCallableImpl<?>> invoke()
  {
    return CollectionsKt.plus(KClassImpl.Data.access$getDeclaredStaticMembers$p(this.this$0), (Iterable)KClassImpl.Data.access$getInheritedStaticMembers$p(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.KClassImpl.Data.allStaticMembers.2
 * JD-Core Version:    0.7.0.1
 */