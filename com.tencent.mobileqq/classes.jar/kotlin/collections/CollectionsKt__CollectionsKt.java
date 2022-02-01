package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import kotlin.BuilderInference;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.comparisons.ComparisonsKt;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"indices", "Lkotlin/ranges/IntRange;", "", "getIndices", "(Ljava/util/Collection;)Lkotlin/ranges/IntRange;", "lastIndex", "", "T", "", "getLastIndex", "(Ljava/util/List;)I", "List", "size", "init", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "index", "MutableList", "", "arrayListOf", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "elements", "", "([Ljava/lang/Object;)Ljava/util/ArrayList;", "buildList", "E", "capacity", "builderAction", "", "Lkotlin/ExtensionFunctionType;", "emptyList", "listOf", "([Ljava/lang/Object;)Ljava/util/List;", "listOfNotNull", "", "element", "(Ljava/lang/Object;)Ljava/util/List;", "mutableListOf", "rangeCheck", "fromIndex", "toIndex", "rangeCheck$CollectionsKt__CollectionsKt", "throwCountOverflow", "throwIndexOverflow", "asCollection", "([Ljava/lang/Object;)Ljava/util/Collection;", "binarySearch", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "(Ljava/util/List;Ljava/lang/Object;Ljava/util/Comparator;II)I", "comparison", "", "(Ljava/util/List;Ljava/lang/Comparable;II)I", "binarySearchBy", "K", "key", "selector", "(Ljava/util/List;Ljava/lang/Comparable;IILkotlin/jvm/functions/Function1;)I", "containsAll", "", "Lkotlin/internal/OnlyInputTypes;", "ifEmpty", "R", "C", "defaultValue", "Lkotlin/Function0;", "(Ljava/util/Collection;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "isNotEmpty", "isNullOrEmpty", "optimizeReadOnlyList", "orEmpty", "kotlin-stdlib"}, k=5, mv={1, 1, 16}, xi=1, xs="kotlin/collections/CollectionsKt")
public class CollectionsKt__CollectionsKt
  extends CollectionsKt__CollectionsJVMKt
{
  @SinceKotlin(version="1.1")
  @InlineOnly
  private static final <T> List<T> List(int paramInt, Function1<? super Integer, ? extends T> paramFunction1)
  {
    ArrayList localArrayList = new ArrayList(paramInt);
    int i = 0;
    while (i < paramInt)
    {
      localArrayList.add(paramFunction1.invoke(Integer.valueOf(i)));
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @SinceKotlin(version="1.1")
  @InlineOnly
  private static final <T> List<T> MutableList(int paramInt, Function1<? super Integer, ? extends T> paramFunction1)
  {
    ArrayList localArrayList = new ArrayList(paramInt);
    int i = 0;
    while (i < paramInt)
    {
      localArrayList.add(paramFunction1.invoke(Integer.valueOf(i)));
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @SinceKotlin(version="1.1")
  @InlineOnly
  private static final <T> ArrayList<T> arrayListOf()
  {
    return new ArrayList();
  }
  
  @NotNull
  public static final <T> ArrayList<T> arrayListOf(@NotNull T... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "elements");
    if (paramVarArgs.length == 0) {
      return new ArrayList();
    }
    return new ArrayList((Collection)new ArrayAsCollection(paramVarArgs, true));
  }
  
  @NotNull
  public static final <T> Collection<T> asCollection(@NotNull T[] paramArrayOfT)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$asCollection");
    return (Collection)new ArrayAsCollection(paramArrayOfT, false);
  }
  
  public static final <T> int binarySearch(@NotNull List<? extends T> paramList, int paramInt1, int paramInt2, @NotNull Function1<? super T, Integer> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "$this$binarySearch");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "comparison");
    rangeCheck$CollectionsKt__CollectionsKt(paramList.size(), paramInt1, paramInt2);
    int i = paramInt2 - 1;
    paramInt2 = paramInt1;
    paramInt1 = i;
    if (paramInt2 <= paramInt1)
    {
      i = paramInt2 + paramInt1 >>> 1;
      int j = ((Number)paramFunction1.invoke(paramList.get(i))).intValue();
      if (j < 0) {
        paramInt2 = i + 1;
      }
      for (;;)
      {
        break;
        if (j <= 0) {
          break label93;
        }
        paramInt1 = i - 1;
      }
      label93:
      return i;
    }
    return -(paramInt2 + 1);
  }
  
  public static final <T extends Comparable<? super T>> int binarySearch(@NotNull List<? extends T> paramList, @Nullable T paramT, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "$this$binarySearch");
    rangeCheck$CollectionsKt__CollectionsKt(paramList.size(), paramInt1, paramInt2);
    int i = paramInt2 - 1;
    paramInt2 = paramInt1;
    paramInt1 = i;
    if (paramInt2 <= paramInt1)
    {
      i = paramInt2 + paramInt1 >>> 1;
      int j = ComparisonsKt.compareValues((Comparable)paramList.get(i), paramT);
      if (j < 0) {
        paramInt2 = i + 1;
      }
      for (;;)
      {
        break;
        if (j <= 0) {
          break label82;
        }
        paramInt1 = i - 1;
      }
      label82:
      return i;
    }
    return -(paramInt2 + 1);
  }
  
  public static final <T> int binarySearch(@NotNull List<? extends T> paramList, T paramT, @NotNull Comparator<? super T> paramComparator, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "$this$binarySearch");
    Intrinsics.checkParameterIsNotNull(paramComparator, "comparator");
    rangeCheck$CollectionsKt__CollectionsKt(paramList.size(), paramInt1, paramInt2);
    paramInt2 -= 1;
    while (paramInt1 <= paramInt2)
    {
      int i = paramInt1 + paramInt2 >>> 1;
      int j = paramComparator.compare(paramList.get(i), paramT);
      if (j < 0) {
        paramInt1 = i + 1;
      } else if (j > 0) {
        paramInt2 = i - 1;
      } else {
        return i;
      }
    }
    return -(paramInt1 + 1);
  }
  
  public static final <T, K extends Comparable<? super K>> int binarySearchBy(@NotNull List<? extends T> paramList, @Nullable K paramK, int paramInt1, int paramInt2, @NotNull Function1<? super T, ? extends K> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "$this$binarySearchBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    return CollectionsKt.binarySearch(paramList, paramInt1, paramInt2, (Function1)new CollectionsKt__CollectionsKt.binarySearchBy.1(paramFunction1, paramK));
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <E> List<E> buildList(int paramInt, @BuilderInference Function1<? super List<E>, Unit> paramFunction1)
  {
    ArrayList localArrayList = new ArrayList(paramInt);
    paramFunction1.invoke(localArrayList);
    return (List)localArrayList;
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <E> List<E> buildList(@BuilderInference Function1<? super List<E>, Unit> paramFunction1)
  {
    ArrayList localArrayList = new ArrayList();
    paramFunction1.invoke(localArrayList);
    return (List)localArrayList;
  }
  
  @InlineOnly
  private static final <T> boolean containsAll(@NotNull Collection<? extends T> paramCollection1, Collection<? extends T> paramCollection2)
  {
    return paramCollection1.containsAll(paramCollection2);
  }
  
  @NotNull
  public static final <T> List<T> emptyList()
  {
    return (List)EmptyList.INSTANCE;
  }
  
  @NotNull
  public static final IntRange getIndices(@NotNull Collection<?> paramCollection)
  {
    Intrinsics.checkParameterIsNotNull(paramCollection, "$this$indices");
    return new IntRange(0, paramCollection.size() - 1);
  }
  
  public static final <T> int getLastIndex(@NotNull List<? extends T> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "$this$lastIndex");
    return paramList.size() - 1;
  }
  
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <C extends Collection<?>,  extends R, R> R ifEmpty(C paramC, Function0<? extends R> paramFunction0)
  {
    Object localObject = paramC;
    if (paramC.isEmpty()) {
      localObject = paramFunction0.invoke();
    }
    return localObject;
  }
  
  @InlineOnly
  private static final <T> boolean isNotEmpty(@NotNull Collection<? extends T> paramCollection)
  {
    return !paramCollection.isEmpty();
  }
  
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <T> boolean isNullOrEmpty(@Nullable Collection<? extends T> paramCollection)
  {
    return (paramCollection == null) || (paramCollection.isEmpty());
  }
  
  @InlineOnly
  private static final <T> List<T> listOf()
  {
    return CollectionsKt.emptyList();
  }
  
  @NotNull
  public static final <T> List<T> listOf(@NotNull T... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "elements");
    if (paramVarArgs.length > 0) {
      return ArraysKt.asList(paramVarArgs);
    }
    return CollectionsKt.emptyList();
  }
  
  @NotNull
  public static final <T> List<T> listOfNotNull(@Nullable T paramT)
  {
    if (paramT != null) {
      return CollectionsKt.listOf(paramT);
    }
    return CollectionsKt.emptyList();
  }
  
  @NotNull
  public static final <T> List<T> listOfNotNull(@NotNull T... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "elements");
    return ArraysKt.filterNotNull(paramVarArgs);
  }
  
  @SinceKotlin(version="1.1")
  @InlineOnly
  private static final <T> List<T> mutableListOf()
  {
    return (List)new ArrayList();
  }
  
  @NotNull
  public static final <T> List<T> mutableListOf(@NotNull T... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "elements");
    if (paramVarArgs.length == 0) {
      return (List)new ArrayList();
    }
    return (List)new ArrayList((Collection)new ArrayAsCollection(paramVarArgs, true));
  }
  
  @NotNull
  public static final <T> List<T> optimizeReadOnlyList(@NotNull List<? extends T> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "$this$optimizeReadOnlyList");
    switch (paramList.size())
    {
    default: 
      return paramList;
    case 0: 
      return CollectionsKt.emptyList();
    }
    return CollectionsKt.listOf(paramList.get(0));
  }
  
  @InlineOnly
  private static final <T> Collection<T> orEmpty(@Nullable Collection<? extends T> paramCollection)
  {
    if (paramCollection != null) {
      return paramCollection;
    }
    return (Collection)CollectionsKt.emptyList();
  }
  
  @InlineOnly
  private static final <T> List<T> orEmpty(@Nullable List<? extends T> paramList)
  {
    if (paramList != null) {
      return paramList;
    }
    return CollectionsKt.emptyList();
  }
  
  private static final void rangeCheck$CollectionsKt__CollectionsKt(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 > paramInt3) {
      throw ((Throwable)new IllegalArgumentException("fromIndex (" + paramInt2 + ") is greater than toIndex (" + paramInt3 + ")."));
    }
    if (paramInt2 < 0) {
      throw ((Throwable)new IndexOutOfBoundsException("fromIndex (" + paramInt2 + ") is less than zero."));
    }
    if (paramInt3 > paramInt1) {
      throw ((Throwable)new IndexOutOfBoundsException("toIndex (" + paramInt3 + ") is greater than size (" + paramInt1 + ")."));
    }
  }
  
  @PublishedApi
  @SinceKotlin(version="1.3")
  public static final void throwCountOverflow()
  {
    throw ((Throwable)new ArithmeticException("Count overflow has happened."));
  }
  
  @PublishedApi
  @SinceKotlin(version="1.3")
  public static final void throwIndexOverflow()
  {
    throw ((Throwable)new ArithmeticException("Index overflow has happened."));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.collections.CollectionsKt__CollectionsKt
 * JD-Core Version:    0.7.0.1
 */