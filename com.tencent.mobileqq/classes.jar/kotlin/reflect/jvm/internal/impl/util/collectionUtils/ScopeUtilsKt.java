package kotlin.reflect.jvm.internal.impl.util.collectionUtils;

import java.util.Collection;
import java.util.LinkedHashSet;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ScopeUtilsKt
{
  @Nullable
  public static final <T> Collection<T> concat(@Nullable Collection<? extends T> paramCollection1, @NotNull Collection<? extends T> paramCollection2)
  {
    Intrinsics.checkParameterIsNotNull(paramCollection2, "collection");
    if (paramCollection2.isEmpty()) {
      return paramCollection1;
    }
    if (paramCollection1 == null) {
      return paramCollection2;
    }
    if ((paramCollection1 instanceof LinkedHashSet))
    {
      ((LinkedHashSet)paramCollection1).addAll(paramCollection2);
      return paramCollection1;
    }
    paramCollection1 = new LinkedHashSet(paramCollection1);
    paramCollection1.addAll(paramCollection2);
    return (Collection)paramCollection1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.util.collectionUtils.ScopeUtilsKt
 * JD-Core Version:    0.7.0.1
 */