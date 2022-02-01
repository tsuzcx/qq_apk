package kotlin.reflect.jvm.internal.impl.incremental.components;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class LookupTracker$DO_NOTHING
  implements LookupTracker
{
  public static final DO_NOTHING INSTANCE = new DO_NOTHING();
  
  public boolean getRequiresPosition()
  {
    return false;
  }
  
  public void record(@NotNull String paramString1, @NotNull Position paramPosition, @NotNull String paramString2, @NotNull ScopeKind paramScopeKind, @NotNull String paramString3)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "filePath");
    Intrinsics.checkParameterIsNotNull(paramPosition, "position");
    Intrinsics.checkParameterIsNotNull(paramString2, "scopeFqName");
    Intrinsics.checkParameterIsNotNull(paramScopeKind, "scopeKind");
    Intrinsics.checkParameterIsNotNull(paramString3, "name");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker.DO_NOTHING
 * JD-Core Version:    0.7.0.1
 */