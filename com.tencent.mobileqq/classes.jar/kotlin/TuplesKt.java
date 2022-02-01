package kotlin;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"to", "Lkotlin/Pair;", "A", "B", "that", "(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;", "toList", "", "T", "Lkotlin/Triple;", "kotlin-stdlib"}, k=2, mv={1, 1, 16})
@JvmName(name="TuplesKt")
public final class TuplesKt
{
  @NotNull
  public static final <A, B> Pair<A, B> to(A paramA, B paramB)
  {
    return new Pair(paramA, paramB);
  }
  
  @NotNull
  public static final <T> List<T> toList(@NotNull Pair<? extends T, ? extends T> paramPair)
  {
    Intrinsics.checkParameterIsNotNull(paramPair, "$this$toList");
    return CollectionsKt.listOf(new Object[] { paramPair.getFirst(), paramPair.getSecond() });
  }
  
  @NotNull
  public static final <T> List<T> toList(@NotNull Triple<? extends T, ? extends T, ? extends T> paramTriple)
  {
    Intrinsics.checkParameterIsNotNull(paramTriple, "$this$toList");
    return CollectionsKt.listOf(new Object[] { paramTriple.getFirst(), paramTriple.getSecond(), paramTriple.getThird() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.TuplesKt
 * JD-Core Version:    0.7.0.1
 */