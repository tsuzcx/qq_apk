package kotlinx.coroutines.flow;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"toCollection", "C", "T", "", "Lkotlinx/coroutines/flow/Flow;", "destination", "(Lkotlinx/coroutines/flow/Flow;Ljava/util/Collection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toList", "", "", "(Lkotlinx/coroutines/flow/Flow;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toSet", "", "", "(Lkotlinx/coroutines/flow/Flow;Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=5, mv={1, 1, 16}, xs="kotlinx/coroutines/flow/FlowKt")
final class FlowKt__CollectionKt
{
  @Nullable
  public static final <T, C extends Collection<? super T>> Object toCollection(@NotNull Flow<? extends T> arg0, @NotNull C arg1, @NotNull Continuation<? super C> arg2) {}
  
  @Nullable
  public static final <T> Object toList(@NotNull Flow<? extends T> arg0, @NotNull List<T> arg1, @NotNull Continuation<? super List<? extends T>> arg2) {}
  
  @Nullable
  public static final <T> Object toSet(@NotNull Flow<? extends T> arg0, @NotNull Set<T> arg1, @NotNull Continuation<? super Set<? extends T>> arg2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.FlowKt__CollectionKt
 * JD-Core Version:    0.7.0.1
 */