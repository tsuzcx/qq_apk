package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.TypeCastException;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.random.Random;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"addAll", "", "T", "", "elements", "", "(Ljava/util/Collection;[Ljava/lang/Object;)Z", "", "Lkotlin/sequences/Sequence;", "filterInPlace", "", "predicate", "Lkotlin/Function1;", "predicateResultToRemove", "filterInPlace$CollectionsKt__MutableCollectionsKt", "", "minusAssign", "", "element", "(Ljava/util/Collection;Ljava/lang/Object;)V", "(Ljava/util/Collection;[Ljava/lang/Object;)V", "plusAssign", "remove", "Lkotlin/internal/OnlyInputTypes;", "(Ljava/util/Collection;Ljava/lang/Object;)Z", "index", "", "(Ljava/util/List;I)Ljava/lang/Object;", "removeAll", "", "removeFirst", "(Ljava/util/List;)Ljava/lang/Object;", "removeFirstOrNull", "removeLast", "removeLastOrNull", "retainAll", "retainNothing", "retainNothing$CollectionsKt__MutableCollectionsKt", "shuffle", "random", "Lkotlin/random/Random;", "shuffled", "", "kotlin-stdlib"}, k=5, mv={1, 1, 16}, xi=1, xs="kotlin/collections/CollectionsKt")
public class CollectionsKt__MutableCollectionsKt
  extends CollectionsKt__MutableCollectionsJVMKt
{
  public static final <T> boolean addAll(@NotNull Collection<? super T> paramCollection, @NotNull Iterable<? extends T> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramCollection, "$this$addAll");
    Intrinsics.checkParameterIsNotNull(paramIterable, "elements");
    boolean bool2;
    if ((paramIterable instanceof Collection))
    {
      bool2 = paramCollection.addAll((Collection)paramIterable);
      return bool2;
    }
    boolean bool1 = false;
    paramIterable = paramIterable.iterator();
    for (;;)
    {
      bool2 = bool1;
      if (!paramIterable.hasNext()) {
        break;
      }
      if (paramCollection.add(paramIterable.next())) {
        bool1 = true;
      }
    }
  }
  
  public static final <T> boolean addAll(@NotNull Collection<? super T> paramCollection, @NotNull Sequence<? extends T> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramCollection, "$this$addAll");
    Intrinsics.checkParameterIsNotNull(paramSequence, "elements");
    boolean bool = false;
    paramSequence = paramSequence.iterator();
    while (paramSequence.hasNext()) {
      if (paramCollection.add(paramSequence.next())) {
        bool = true;
      }
    }
    return bool;
  }
  
  public static final <T> boolean addAll(@NotNull Collection<? super T> paramCollection, @NotNull T[] paramArrayOfT)
  {
    Intrinsics.checkParameterIsNotNull(paramCollection, "$this$addAll");
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "elements");
    return paramCollection.addAll((Collection)ArraysKt.asList(paramArrayOfT));
  }
  
  private static final <T> boolean filterInPlace$CollectionsKt__MutableCollectionsKt(@NotNull Iterable<? extends T> paramIterable, Function1<? super T, Boolean> paramFunction1, boolean paramBoolean)
  {
    paramIterable = paramIterable.iterator();
    boolean bool = false;
    if (paramIterable.hasNext())
    {
      if (((Boolean)paramFunction1.invoke(paramIterable.next())).booleanValue() != paramBoolean) {
        break label53;
      }
      paramIterable.remove();
      bool = true;
    }
    label53:
    for (;;)
    {
      break;
      return bool;
    }
  }
  
  private static final <T> boolean filterInPlace$CollectionsKt__MutableCollectionsKt(@NotNull List<T> paramList, Function1<? super T, Boolean> paramFunction1, boolean paramBoolean)
  {
    boolean bool = false;
    if (!(paramList instanceof RandomAccess))
    {
      if (paramList == null) {
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableIterable<T>");
      }
      paramBoolean = filterInPlace$CollectionsKt__MutableCollectionsKt(TypeIntrinsics.asMutableIterable(paramList), paramFunction1, paramBoolean);
    }
    int j;
    label125:
    do
    {
      return paramBoolean;
      int m = CollectionsKt.getLastIndex(paramList);
      if (m <= 0)
      {
        int k = 0;
        i = 0;
        Object localObject = paramList.get(k);
        if (((Boolean)paramFunction1.invoke(localObject)).booleanValue() == paramBoolean) {}
        for (;;)
        {
          j = i;
          if (k == m) {
            break label125;
          }
          k += 1;
          break;
          if (i != k) {
            paramList.set(i, localObject);
          }
          i += 1;
        }
      }
      j = 0;
      paramBoolean = bool;
    } while (j >= paramList.size());
    int i = CollectionsKt.getLastIndex(paramList);
    if (i >= j) {
      for (;;)
      {
        paramList.remove(i);
        if (i == j) {
          break;
        }
        i -= 1;
      }
    }
    return true;
  }
  
  @InlineOnly
  private static final <T> void minusAssign(@NotNull Collection<? super T> paramCollection, Iterable<? extends T> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramCollection, "$this$minusAssign");
    CollectionsKt.removeAll(paramCollection, paramIterable);
  }
  
  @InlineOnly
  private static final <T> void minusAssign(@NotNull Collection<? super T> paramCollection, T paramT)
  {
    Intrinsics.checkParameterIsNotNull(paramCollection, "$this$minusAssign");
    paramCollection.remove(paramT);
  }
  
  @InlineOnly
  private static final <T> void minusAssign(@NotNull Collection<? super T> paramCollection, Sequence<? extends T> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramCollection, "$this$minusAssign");
    CollectionsKt.removeAll(paramCollection, paramSequence);
  }
  
  @InlineOnly
  private static final <T> void minusAssign(@NotNull Collection<? super T> paramCollection, T[] paramArrayOfT)
  {
    Intrinsics.checkParameterIsNotNull(paramCollection, "$this$minusAssign");
    CollectionsKt.removeAll(paramCollection, paramArrayOfT);
  }
  
  @InlineOnly
  private static final <T> void plusAssign(@NotNull Collection<? super T> paramCollection, Iterable<? extends T> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramCollection, "$this$plusAssign");
    CollectionsKt.addAll(paramCollection, paramIterable);
  }
  
  @InlineOnly
  private static final <T> void plusAssign(@NotNull Collection<? super T> paramCollection, T paramT)
  {
    Intrinsics.checkParameterIsNotNull(paramCollection, "$this$plusAssign");
    paramCollection.add(paramT);
  }
  
  @InlineOnly
  private static final <T> void plusAssign(@NotNull Collection<? super T> paramCollection, Sequence<? extends T> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramCollection, "$this$plusAssign");
    CollectionsKt.addAll(paramCollection, paramSequence);
  }
  
  @InlineOnly
  private static final <T> void plusAssign(@NotNull Collection<? super T> paramCollection, T[] paramArrayOfT)
  {
    Intrinsics.checkParameterIsNotNull(paramCollection, "$this$plusAssign");
    CollectionsKt.addAll(paramCollection, paramArrayOfT);
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="Use removeAt(index) instead.", replaceWith=@ReplaceWith(expression="removeAt(index)", imports={}))
  @InlineOnly
  private static final <T> T remove(@NotNull List<T> paramList, int paramInt)
  {
    return paramList.remove(paramInt);
  }
  
  @InlineOnly
  private static final <T> boolean remove(@NotNull Collection<? extends T> paramCollection, T paramT)
  {
    if (paramCollection == null) {
      throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
    }
    return TypeIntrinsics.asMutableCollection(paramCollection).remove(paramT);
  }
  
  public static final <T> boolean removeAll(@NotNull Iterable<? extends T> paramIterable, @NotNull Function1<? super T, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$removeAll");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    return filterInPlace$CollectionsKt__MutableCollectionsKt(paramIterable, paramFunction1, true);
  }
  
  public static final <T> boolean removeAll(@NotNull Collection<? super T> paramCollection, @NotNull Iterable<? extends T> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramCollection, "$this$removeAll");
    Intrinsics.checkParameterIsNotNull(paramIterable, "elements");
    paramIterable = CollectionsKt.convertToSetForSetOperationWith(paramIterable, (Iterable)paramCollection);
    return TypeIntrinsics.asMutableCollection(paramCollection).removeAll(paramIterable);
  }
  
  @InlineOnly
  private static final <T> boolean removeAll(@NotNull Collection<? extends T> paramCollection1, Collection<? extends T> paramCollection2)
  {
    if (paramCollection1 == null) {
      throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
    }
    return TypeIntrinsics.asMutableCollection(paramCollection1).removeAll(paramCollection2);
  }
  
  public static final <T> boolean removeAll(@NotNull Collection<? super T> paramCollection, @NotNull Sequence<? extends T> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramCollection, "$this$removeAll");
    Intrinsics.checkParameterIsNotNull(paramSequence, "elements");
    paramSequence = SequencesKt.toHashSet(paramSequence);
    if (!((Collection)paramSequence).isEmpty()) {}
    for (int i = 1; (i != 0) && (paramCollection.removeAll((Collection)paramSequence)); i = 0) {
      return true;
    }
    return false;
  }
  
  public static final <T> boolean removeAll(@NotNull Collection<? super T> paramCollection, @NotNull T[] paramArrayOfT)
  {
    Intrinsics.checkParameterIsNotNull(paramCollection, "$this$removeAll");
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "elements");
    if (paramArrayOfT.length == 0)
    {
      i = 1;
      if (i != 0) {
        break label52;
      }
    }
    label52:
    for (int i = 1;; i = 0)
    {
      if ((i == 0) || (!paramCollection.removeAll((Collection)ArraysKt.toHashSet(paramArrayOfT)))) {
        break label57;
      }
      return true;
      i = 0;
      break;
    }
    label57:
    return false;
  }
  
  public static final <T> boolean removeAll(@NotNull List<T> paramList, @NotNull Function1<? super T, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "$this$removeAll");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    return filterInPlace$CollectionsKt__MutableCollectionsKt(paramList, paramFunction1, true);
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  public static final <T> T removeFirst(@NotNull List<T> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "$this$removeFirst");
    if (paramList.isEmpty()) {
      throw ((Throwable)new NoSuchElementException("List is empty."));
    }
    return paramList.remove(0);
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @Nullable
  public static final <T> T removeFirstOrNull(@NotNull List<T> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "$this$removeFirstOrNull");
    if (paramList.isEmpty()) {
      return null;
    }
    return paramList.remove(0);
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  public static final <T> T removeLast(@NotNull List<T> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "$this$removeLast");
    if (paramList.isEmpty()) {
      throw ((Throwable)new NoSuchElementException("List is empty."));
    }
    return paramList.remove(CollectionsKt.getLastIndex(paramList));
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @Nullable
  public static final <T> T removeLastOrNull(@NotNull List<T> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "$this$removeLastOrNull");
    if (paramList.isEmpty()) {
      return null;
    }
    return paramList.remove(CollectionsKt.getLastIndex(paramList));
  }
  
  public static final <T> boolean retainAll(@NotNull Iterable<? extends T> paramIterable, @NotNull Function1<? super T, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$retainAll");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    return filterInPlace$CollectionsKt__MutableCollectionsKt(paramIterable, paramFunction1, false);
  }
  
  public static final <T> boolean retainAll(@NotNull Collection<? super T> paramCollection, @NotNull Iterable<? extends T> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramCollection, "$this$retainAll");
    Intrinsics.checkParameterIsNotNull(paramIterable, "elements");
    paramIterable = CollectionsKt.convertToSetForSetOperationWith(paramIterable, (Iterable)paramCollection);
    return TypeIntrinsics.asMutableCollection(paramCollection).retainAll(paramIterable);
  }
  
  @InlineOnly
  private static final <T> boolean retainAll(@NotNull Collection<? extends T> paramCollection1, Collection<? extends T> paramCollection2)
  {
    if (paramCollection1 == null) {
      throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
    }
    return TypeIntrinsics.asMutableCollection(paramCollection1).retainAll(paramCollection2);
  }
  
  public static final <T> boolean retainAll(@NotNull Collection<? super T> paramCollection, @NotNull Sequence<? extends T> paramSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramCollection, "$this$retainAll");
    Intrinsics.checkParameterIsNotNull(paramSequence, "elements");
    paramSequence = SequencesKt.toHashSet(paramSequence);
    if (!((Collection)paramSequence).isEmpty()) {}
    for (int i = 1; i != 0; i = 0) {
      return paramCollection.retainAll((Collection)paramSequence);
    }
    return retainNothing$CollectionsKt__MutableCollectionsKt(paramCollection);
  }
  
  public static final <T> boolean retainAll(@NotNull Collection<? super T> paramCollection, @NotNull T[] paramArrayOfT)
  {
    int j = 1;
    Intrinsics.checkParameterIsNotNull(paramCollection, "$this$retainAll");
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "elements");
    if (paramArrayOfT.length == 0)
    {
      i = 1;
      if (i != 0) {
        break label51;
      }
    }
    label51:
    for (int i = j;; i = 0)
    {
      if (i == 0) {
        break label56;
      }
      return paramCollection.retainAll((Collection)ArraysKt.toHashSet(paramArrayOfT));
      i = 0;
      break;
    }
    label56:
    return retainNothing$CollectionsKt__MutableCollectionsKt(paramCollection);
  }
  
  public static final <T> boolean retainAll(@NotNull List<T> paramList, @NotNull Function1<? super T, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "$this$retainAll");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    return filterInPlace$CollectionsKt__MutableCollectionsKt(paramList, paramFunction1, false);
  }
  
  private static final boolean retainNothing$CollectionsKt__MutableCollectionsKt(@NotNull Collection<?> paramCollection)
  {
    if (!paramCollection.isEmpty()) {}
    for (boolean bool = true;; bool = false)
    {
      paramCollection.clear();
      return bool;
    }
  }
  
  @SinceKotlin(version="1.3")
  public static final <T> void shuffle(@NotNull List<T> paramList, @NotNull Random paramRandom)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "$this$shuffle");
    Intrinsics.checkParameterIsNotNull(paramRandom, "random");
    int i = CollectionsKt.getLastIndex(paramList);
    while (i >= 1)
    {
      int j = paramRandom.nextInt(i + 1);
      Object localObject = paramList.get(i);
      paramList.set(i, paramList.get(j));
      paramList.set(j, localObject);
      i -= 1;
    }
  }
  
  @SinceKotlin(version="1.3")
  @NotNull
  public static final <T> List<T> shuffled(@NotNull Iterable<? extends T> paramIterable, @NotNull Random paramRandom)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$shuffled");
    Intrinsics.checkParameterIsNotNull(paramRandom, "random");
    paramIterable = CollectionsKt.toMutableList(paramIterable);
    CollectionsKt.shuffle(paramIterable, paramRandom);
    return paramIterable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.collections.CollectionsKt__MutableCollectionsKt
 * JD-Core Version:    0.7.0.1
 */