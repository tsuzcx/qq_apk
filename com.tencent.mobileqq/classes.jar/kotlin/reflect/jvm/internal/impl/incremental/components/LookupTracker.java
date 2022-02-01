package kotlin.reflect.jvm.internal.impl.incremental.components;

import org.jetbrains.annotations.NotNull;

public abstract interface LookupTracker
{
  public abstract boolean getRequiresPosition();
  
  public abstract void record(@NotNull String paramString1, @NotNull Position paramPosition, @NotNull String paramString2, @NotNull ScopeKind paramScopeKind, @NotNull String paramString3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker
 * JD-Core Version:    0.7.0.1
 */