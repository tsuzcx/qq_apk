package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.FlowPreview;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"distinctUntilChanged", "Lkotlinx/coroutines/flow/Flow;", "T", "areEquivalent", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "old", "new", "", "distinctUntilChangedBy", "K", "keySelector", "Lkotlin/Function1;", "distinctUntilChangedBy$FlowKt__DistinctKt", "kotlinx-coroutines-core"}, k=5, mv={1, 1, 16}, xs="kotlinx/coroutines/flow/FlowKt")
final class FlowKt__DistinctKt
{
  @ExperimentalCoroutinesApi
  @NotNull
  public static final <T> Flow<T> distinctUntilChanged(@NotNull Flow<? extends T> arg0) {}
  
  @FlowPreview
  @NotNull
  public static final <T> Flow<T> distinctUntilChanged(@NotNull Flow<? extends T> arg0, @NotNull Function2<? super T, ? super T, Boolean> arg1) {}
  
  @FlowPreview
  @NotNull
  public static final <T, K> Flow<T> distinctUntilChangedBy(@NotNull Flow<? extends T> arg0, @NotNull Function1<? super T, ? extends K> arg1) {}
  
  private static final <T, K> Flow<T> distinctUntilChangedBy$FlowKt__DistinctKt(@NotNull Flow<? extends T> arg0, Function1<? super T, ? extends K> arg1, Function2<? super K, ? super K, Boolean> arg2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.FlowKt__DistinctKt
 * JD-Core Version:    0.7.0.1
 */