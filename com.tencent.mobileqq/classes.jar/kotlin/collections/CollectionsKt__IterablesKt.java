package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.PublishedApi;
import kotlin.TuplesKt;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Iterable", "", "T", "iterator", "Lkotlin/Function0;", "", "collectionSizeOrDefault", "", "default", "collectionSizeOrNull", "(Ljava/lang/Iterable;)Ljava/lang/Integer;", "convertToSetForSetOperation", "", "convertToSetForSetOperationWith", "source", "flatten", "", "safeToConvertToSet", "", "safeToConvertToSet$CollectionsKt__IterablesKt", "unzip", "Lkotlin/Pair;", "R", "kotlin-stdlib"}, k=5, mv={1, 1, 16}, xi=1, xs="kotlin/collections/CollectionsKt")
class CollectionsKt__IterablesKt
  extends CollectionsKt__CollectionsKt
{
  @InlineOnly
  private static final <T> Iterable<T> Iterable(Function0<? extends Iterator<? extends T>> paramFunction0)
  {
    return (Iterable)new CollectionsKt__IterablesKt.Iterable.1(paramFunction0);
  }
  
  @PublishedApi
  public static final <T> int collectionSizeOrDefault(@NotNull Iterable<? extends T> paramIterable, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$collectionSizeOrDefault");
    if ((paramIterable instanceof Collection)) {
      paramInt = ((Collection)paramIterable).size();
    }
    return paramInt;
  }
  
  @PublishedApi
  @Nullable
  public static final <T> Integer collectionSizeOrNull(@NotNull Iterable<? extends T> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$collectionSizeOrNull");
    if ((paramIterable instanceof Collection)) {
      return Integer.valueOf(((Collection)paramIterable).size());
    }
    return null;
  }
  
  @NotNull
  public static final <T> Collection<T> convertToSetForSetOperation(@NotNull Iterable<? extends T> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$convertToSetForSetOperation");
    if ((paramIterable instanceof Set)) {
      return (Collection)paramIterable;
    }
    if ((paramIterable instanceof Collection))
    {
      Collection localCollection = (Collection)paramIterable;
      if (safeToConvertToSet$CollectionsKt__IterablesKt(localCollection)) {
        return (Collection)CollectionsKt.toHashSet(paramIterable);
      }
      return localCollection;
    }
    return (Collection)CollectionsKt.toHashSet(paramIterable);
  }
  
  @NotNull
  public static final <T> Collection<T> convertToSetForSetOperationWith(@NotNull Iterable<? extends T> paramIterable1, @NotNull Iterable<? extends T> paramIterable2)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable1, "$this$convertToSetForSetOperationWith");
    Intrinsics.checkParameterIsNotNull(paramIterable2, "source");
    if ((paramIterable1 instanceof Set)) {
      return (Collection)paramIterable1;
    }
    if ((paramIterable1 instanceof Collection))
    {
      if (((paramIterable2 instanceof Collection)) && (((Collection)paramIterable2).size() < 2)) {
        return (Collection)paramIterable1;
      }
      paramIterable2 = (Collection)paramIterable1;
      if (safeToConvertToSet$CollectionsKt__IterablesKt(paramIterable2)) {
        return (Collection)CollectionsKt.toHashSet(paramIterable1);
      }
      return paramIterable2;
    }
    return (Collection)CollectionsKt.toHashSet(paramIterable1);
  }
  
  @NotNull
  public static final <T> List<T> flatten(@NotNull Iterable<? extends Iterable<? extends T>> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$flatten");
    ArrayList localArrayList = new ArrayList();
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      Iterable localIterable = (Iterable)paramIterable.next();
      CollectionsKt.addAll((Collection)localArrayList, localIterable);
    }
    return (List)localArrayList;
  }
  
  private static final <T> boolean safeToConvertToSet$CollectionsKt__IterablesKt(@NotNull Collection<? extends T> paramCollection)
  {
    return (paramCollection.size() > 2) && ((paramCollection instanceof ArrayList));
  }
  
  @NotNull
  public static final <T, R> Pair<List<T>, List<R>> unzip(@NotNull Iterable<? extends Pair<? extends T, ? extends R>> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$unzip");
    int i = CollectionsKt.collectionSizeOrDefault(paramIterable, 10);
    ArrayList localArrayList1 = new ArrayList(i);
    ArrayList localArrayList2 = new ArrayList(i);
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      Pair localPair = (Pair)paramIterable.next();
      localArrayList1.add(localPair.getFirst());
      localArrayList2.add(localPair.getSecond());
    }
    return TuplesKt.to(localArrayList1, localArrayList2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.collections.CollectionsKt__IterablesKt
 * JD-Core Version:    0.7.0.1
 */