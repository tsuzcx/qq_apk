package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class DisjointKeysUnionTypeSubstitution$Companion
{
  @JvmStatic
  @NotNull
  public final TypeSubstitution create(@NotNull TypeSubstitution paramTypeSubstitution1, @NotNull TypeSubstitution paramTypeSubstitution2)
  {
    Intrinsics.checkParameterIsNotNull(paramTypeSubstitution1, "first");
    Intrinsics.checkParameterIsNotNull(paramTypeSubstitution2, "second");
    if (paramTypeSubstitution1.isEmpty()) {
      return paramTypeSubstitution2;
    }
    if (paramTypeSubstitution2.isEmpty()) {
      return paramTypeSubstitution1;
    }
    return (TypeSubstitution)new DisjointKeysUnionTypeSubstitution(paramTypeSubstitution1, paramTypeSubstitution2, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.DisjointKeysUnionTypeSubstitution.Companion
 * JD-Core Version:    0.7.0.1
 */