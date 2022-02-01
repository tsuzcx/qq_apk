package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class ChainedMemberScope$Companion
{
  @NotNull
  public final MemberScope create(@NotNull String paramString, @NotNull List<? extends MemberScope> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "debugName");
    Intrinsics.checkParameterIsNotNull(paramList, "scopes");
    int i = paramList.size();
    if (i != 0)
    {
      if (i != 1) {
        return (MemberScope)new ChainedMemberScope(paramString, paramList);
      }
      return (MemberScope)CollectionsKt.single(paramList);
    }
    return (MemberScope)MemberScope.Empty.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.resolve.scopes.ChainedMemberScope.Companion
 * JD-Core Version:    0.7.0.1
 */