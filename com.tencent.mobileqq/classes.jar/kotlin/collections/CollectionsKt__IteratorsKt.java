package kotlin.collections;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"forEach", "", "T", "", "operation", "Lkotlin/Function1;", "iterator", "withIndex", "Lkotlin/collections/IndexedValue;", "kotlin-stdlib"}, k=5, mv={1, 1, 16}, xi=1, xs="kotlin/collections/CollectionsKt")
class CollectionsKt__IteratorsKt
  extends CollectionsKt__IteratorsJVMKt
{
  public static final <T> void forEach(@NotNull Iterator<? extends T> paramIterator, @NotNull Function1<? super T, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramIterator, "$this$forEach");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "operation");
    while (paramIterator.hasNext()) {
      paramFunction1.invoke(paramIterator.next());
    }
  }
  
  @InlineOnly
  private static final <T> Iterator<T> iterator(@NotNull Iterator<? extends T> paramIterator)
  {
    Intrinsics.checkParameterIsNotNull(paramIterator, "$this$iterator");
    return paramIterator;
  }
  
  @NotNull
  public static final <T> Iterator<IndexedValue<T>> withIndex(@NotNull Iterator<? extends T> paramIterator)
  {
    Intrinsics.checkParameterIsNotNull(paramIterator, "$this$withIndex");
    return (Iterator)new IndexingIterator(paramIterator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.collections.CollectionsKt__IteratorsKt
 * JD-Core Version:    0.7.0.1
 */