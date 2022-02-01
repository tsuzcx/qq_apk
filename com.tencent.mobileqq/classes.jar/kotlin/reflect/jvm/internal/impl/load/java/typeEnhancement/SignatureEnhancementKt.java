package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class SignatureEnhancementKt
{
  @NotNull
  public static final JavaTypeQualifiers createJavaTypeQualifiers(@Nullable NullabilityQualifier paramNullabilityQualifier, @Nullable MutabilityQualifier paramMutabilityQualifier, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean2) && (paramNullabilityQualifier == NullabilityQualifier.NOT_NULL)) {
      return new JavaTypeQualifiers(paramNullabilityQualifier, paramMutabilityQualifier, true, paramBoolean1);
    }
    return new JavaTypeQualifiers(paramNullabilityQualifier, paramMutabilityQualifier, false, paramBoolean1);
  }
  
  @Nullable
  public static final <T> T select(@NotNull Set<? extends T> paramSet, @NotNull T paramT1, @NotNull T paramT2, @Nullable T paramT3, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramSet, "$this$select");
    Intrinsics.checkParameterIsNotNull(paramT1, "low");
    Intrinsics.checkParameterIsNotNull(paramT2, "high");
    if (paramBoolean)
    {
      if (paramSet.contains(paramT1)) {
        paramSet = paramT1;
      } else if (paramSet.contains(paramT2)) {
        paramSet = paramT2;
      } else {
        paramSet = null;
      }
      if ((Intrinsics.areEqual(paramSet, paramT1)) && (Intrinsics.areEqual(paramT3, paramT2))) {
        return null;
      }
      if (paramT3 != null) {
        paramSet = paramT3;
      }
      return paramSet;
    }
    paramT1 = paramSet;
    if (paramT3 != null)
    {
      paramT2 = CollectionsKt.toSet((Iterable)SetsKt.plus(paramSet, paramT3));
      paramT1 = paramSet;
      if (paramT2 != null) {
        paramT1 = paramT2;
      }
    }
    return CollectionsKt.singleOrNull((Iterable)paramT1);
  }
  
  @Nullable
  public static final NullabilityQualifier select(@NotNull Set<? extends NullabilityQualifier> paramSet, @Nullable NullabilityQualifier paramNullabilityQualifier, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramSet, "$this$select");
    if (paramNullabilityQualifier == NullabilityQualifier.FORCE_FLEXIBILITY) {
      return NullabilityQualifier.FORCE_FLEXIBILITY;
    }
    return (NullabilityQualifier)select(paramSet, NullabilityQualifier.NOT_NULL, NullabilityQualifier.NULLABLE, paramNullabilityQualifier, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementKt
 * JD-Core Version:    0.7.0.1
 */