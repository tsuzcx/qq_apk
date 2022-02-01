package kotlin.reflect.full;

import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;
import kotlin.reflect.jvm.internal.impl.utils.DFS.NodeHandlerWithListResult;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlin/reflect/full/KClasses$allSupertypes$2", "Lkotlin/reflect/jvm/internal/impl/utils/DFS$NodeHandlerWithListResult;", "Lkotlin/reflect/KType;", "beforeChildren", "", "current", "kotlin-reflection"}, k=1, mv={1, 1, 16})
public final class KClasses$allSupertypes$2
  extends DFS.NodeHandlerWithListResult<KType, KType>
{
  public boolean beforeChildren(@NotNull KType paramKType)
  {
    Intrinsics.checkParameterIsNotNull(paramKType, "current");
    ((LinkedList)this.result).add(paramKType);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.full.KClasses.allSupertypes.2
 * JD-Core Version:    0.7.0.1
 */