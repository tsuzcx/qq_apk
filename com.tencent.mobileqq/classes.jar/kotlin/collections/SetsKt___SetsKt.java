package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"minus", "", "T", "element", "(Ljava/util/Set;Ljava/lang/Object;)Ljava/util/Set;", "elements", "", "(Ljava/util/Set;[Ljava/lang/Object;)Ljava/util/Set;", "", "Lkotlin/sequences/Sequence;", "minusElement", "plus", "plusElement", "kotlin-stdlib"}, k=5, mv={1, 1, 16}, xi=1, xs="kotlin/collections/SetsKt")
public class SetsKt___SetsKt
  extends SetsKt__SetsKt
{
  @NotNull
  public static final <T> Set<T> minus(@NotNull Set<? extends T> paramSet, @NotNull Iterable<? extends T> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramSet, "$this$minus");
    Intrinsics.checkParameterIsNotNull(paramIterable, "elements");
    paramIterable = CollectionsKt.convertToSetForSetOperationWith(paramIterable, (Iterable)paramSet);
    if (paramIterable.isEmpty()) {
      return CollectionsKt.toSet((Iterable)paramSet);
    }
    if ((paramIterable instanceof Set))
    {
      Object localObject1 = (Iterable)paramSet;
      paramSet = (Collection)new LinkedHashSet();
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        if (!paramIterable.contains(localObject2)) {
          paramSet.add(localObject2);
        }
      }
      return (Set)paramSet;
    }
    paramSet = new LinkedHashSet((Collection)paramSet);
    paramSet.removeAll(paramIterable);
    return (Set)paramSet;
  }
  
  @NotNull
  public static final <T> Set<T> minus(@NotNull Set<? extends T> paramSet, T paramT)
  {
    Intrinsics.checkParameterIsNotNull(paramSet, "$this$minus");
    LinkedHashSet localLinkedHashSet = new LinkedHashSet(MapsKt.mapCapacity(paramSet.size()));
    paramSet = ((Iterable)paramSet).iterator();
    int i = 0;
    label104:
    for (;;)
    {
      if (paramSet.hasNext())
      {
        Object localObject = paramSet.next();
        int j;
        if ((i == 0) && (Intrinsics.areEqual(localObject, paramT)))
        {
          j = 0;
          i = 1;
        }
        for (;;)
        {
          if (j == 0) {
            break label104;
          }
          ((Collection)localLinkedHashSet).add(localObject);
          break;
          j = 1;
        }
      }
      return (Set)localLinkedHashSet;
    }
  }
  
  @NotNull
  public static final <T> Set<T> minus(@NotNull Set<? extends T> paramSet, @NotNull Sequence<? extends T> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSet, "$this$minus");
    Intrinsics.checkParameterIsNotNull(paramSequence, "elements");
    paramSet = new LinkedHashSet((Collection)paramSet);
    CollectionsKt.removeAll((Collection)paramSet, paramSequence);
    return (Set)paramSet;
  }
  
  @NotNull
  public static final <T> Set<T> minus(@NotNull Set<? extends T> paramSet, @NotNull T[] paramArrayOfT)
  {
    Intrinsics.checkParameterIsNotNull(paramSet, "$this$minus");
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "elements");
    paramSet = new LinkedHashSet((Collection)paramSet);
    CollectionsKt.removeAll((Collection)paramSet, paramArrayOfT);
    return (Set)paramSet;
  }
  
  @InlineOnly
  private static final <T> Set<T> minusElement(@NotNull Set<? extends T> paramSet, T paramT)
  {
    return SetsKt.minus(paramSet, paramT);
  }
  
  @NotNull
  public static final <T> Set<T> plus(@NotNull Set<? extends T> paramSet, @NotNull Iterable<? extends T> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramSet, "$this$plus");
    Intrinsics.checkParameterIsNotNull(paramIterable, "elements");
    Object localObject = CollectionsKt.collectionSizeOrNull(paramIterable);
    if (localObject != null) {}
    for (int i = ((Number)localObject).intValue() + paramSet.size();; i = paramSet.size() * 2)
    {
      localObject = new LinkedHashSet(MapsKt.mapCapacity(i));
      ((LinkedHashSet)localObject).addAll((Collection)paramSet);
      CollectionsKt.addAll((Collection)localObject, paramIterable);
      return (Set)localObject;
    }
  }
  
  @NotNull
  public static final <T> Set<T> plus(@NotNull Set<? extends T> paramSet, T paramT)
  {
    Intrinsics.checkParameterIsNotNull(paramSet, "$this$plus");
    LinkedHashSet localLinkedHashSet = new LinkedHashSet(MapsKt.mapCapacity(paramSet.size() + 1));
    localLinkedHashSet.addAll((Collection)paramSet);
    localLinkedHashSet.add(paramT);
    return (Set)localLinkedHashSet;
  }
  
  @NotNull
  public static final <T> Set<T> plus(@NotNull Set<? extends T> paramSet, @NotNull Sequence<? extends T> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramSet, "$this$plus");
    Intrinsics.checkParameterIsNotNull(paramSequence, "elements");
    LinkedHashSet localLinkedHashSet = new LinkedHashSet(MapsKt.mapCapacity(paramSet.size() * 2));
    localLinkedHashSet.addAll((Collection)paramSet);
    CollectionsKt.addAll((Collection)localLinkedHashSet, paramSequence);
    return (Set)localLinkedHashSet;
  }
  
  @NotNull
  public static final <T> Set<T> plus(@NotNull Set<? extends T> paramSet, @NotNull T[] paramArrayOfT)
  {
    Intrinsics.checkParameterIsNotNull(paramSet, "$this$plus");
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "elements");
    LinkedHashSet localLinkedHashSet = new LinkedHashSet(MapsKt.mapCapacity(paramSet.size() + paramArrayOfT.length));
    localLinkedHashSet.addAll((Collection)paramSet);
    CollectionsKt.addAll((Collection)localLinkedHashSet, paramArrayOfT);
    return (Set)localLinkedHashSet;
  }
  
  @InlineOnly
  private static final <T> Set<T> plusElement(@NotNull Set<? extends T> paramSet, T paramT)
  {
    return SetsKt.plus(paramSet, paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.collections.SetsKt___SetsKt
 * JD-Core Version:    0.7.0.1
 */