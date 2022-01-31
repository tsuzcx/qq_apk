package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.internal.HidesMembers;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"all", "", "K", "V", "", "predicate", "Lkotlin/Function1;", "", "any", "asIterable", "", "asSequence", "Lkotlin/sequences/Sequence;", "count", "", "flatMap", "", "R", "transform", "flatMapTo", "C", "", "destination", "(Ljava/util/Map;Ljava/util/Collection;Lkotlin/jvm/functions/Function1;)Ljava/util/Collection;", "forEach", "", "action", "map", "mapNotNull", "", "mapNotNullTo", "mapTo", "maxBy", "", "selector", "maxWith", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "minBy", "minWith", "none", "onEach", "M", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "toList", "Lkotlin/Pair;", "kotlin-stdlib"}, k=5, mv={1, 1, 16}, xi=1, xs="kotlin/collections/MapsKt")
class MapsKt___MapsKt
  extends MapsKt__MapsKt
{
  public static final <K, V> boolean all(@NotNull Map<? extends K, ? extends V> paramMap, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$all");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    if (paramMap.isEmpty()) {
      return true;
    }
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext()) {
      if (!((Boolean)paramFunction1.invoke((Map.Entry)paramMap.next())).booleanValue()) {
        return false;
      }
    }
    return true;
  }
  
  public static final <K, V> boolean any(@NotNull Map<? extends K, ? extends V> paramMap)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$any");
    return !paramMap.isEmpty();
  }
  
  public static final <K, V> boolean any(@NotNull Map<? extends K, ? extends V> paramMap, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$any");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    if (paramMap.isEmpty()) {
      return false;
    }
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext()) {
      if (((Boolean)paramFunction1.invoke((Map.Entry)paramMap.next())).booleanValue()) {
        return true;
      }
    }
    return false;
  }
  
  @InlineOnly
  private static final <K, V> Iterable<Map.Entry<K, V>> asIterable(@NotNull Map<? extends K, ? extends V> paramMap)
  {
    return (Iterable)paramMap.entrySet();
  }
  
  @NotNull
  public static final <K, V> Sequence<Map.Entry<K, V>> asSequence(@NotNull Map<? extends K, ? extends V> paramMap)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$asSequence");
    return CollectionsKt.asSequence((Iterable)paramMap.entrySet());
  }
  
  @InlineOnly
  private static final <K, V> int count(@NotNull Map<? extends K, ? extends V> paramMap)
  {
    return paramMap.size();
  }
  
  public static final <K, V> int count(@NotNull Map<? extends K, ? extends V> paramMap, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$count");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    if (paramMap.isEmpty()) {
      return 0;
    }
    paramMap = paramMap.entrySet().iterator();
    int i = 0;
    while (paramMap.hasNext()) {
      if (((Boolean)paramFunction1.invoke((Map.Entry)paramMap.next())).booleanValue()) {
        i += 1;
      }
    }
    return i;
  }
  
  @NotNull
  public static final <K, V, R> List<R> flatMap(@NotNull Map<? extends K, ? extends V> paramMap, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, ? extends Iterable<? extends R>> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$flatMap");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    Collection localCollection = (Collection)new ArrayList();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext()) {
      CollectionsKt.addAll(localCollection, (Iterable)paramFunction1.invoke((Map.Entry)paramMap.next()));
    }
    return (List)localCollection;
  }
  
  @NotNull
  public static final <K, V, R, C extends Collection<? super R>> C flatMapTo(@NotNull Map<? extends K, ? extends V> paramMap, @NotNull C paramC, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, ? extends Iterable<? extends R>> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$flatMapTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext()) {
      CollectionsKt.addAll(paramC, (Iterable)paramFunction1.invoke((Map.Entry)paramMap.next()));
    }
    return paramC;
  }
  
  @HidesMembers
  public static final <K, V> void forEach(@NotNull Map<? extends K, ? extends V> paramMap, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$forEach");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "action");
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext()) {
      paramFunction1.invoke((Map.Entry)paramMap.next());
    }
  }
  
  @NotNull
  public static final <K, V, R> List<R> map(@NotNull Map<? extends K, ? extends V> paramMap, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$map");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    Collection localCollection = (Collection)new ArrayList(paramMap.size());
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext()) {
      localCollection.add(paramFunction1.invoke((Map.Entry)paramMap.next()));
    }
    return (List)localCollection;
  }
  
  @NotNull
  public static final <K, V, R> List<R> mapNotNull(@NotNull Map<? extends K, ? extends V> paramMap, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$mapNotNull");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    Collection localCollection = (Collection)new ArrayList();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Object localObject = paramFunction1.invoke((Map.Entry)paramMap.next());
      if (localObject != null) {
        localCollection.add(localObject);
      }
    }
    return (List)localCollection;
  }
  
  @NotNull
  public static final <K, V, R, C extends Collection<? super R>> C mapNotNullTo(@NotNull Map<? extends K, ? extends V> paramMap, @NotNull C paramC, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$mapNotNullTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Object localObject = paramFunction1.invoke((Map.Entry)paramMap.next());
      if (localObject != null) {
        paramC.add(localObject);
      }
    }
    return paramC;
  }
  
  @NotNull
  public static final <K, V, R, C extends Collection<? super R>> C mapTo(@NotNull Map<? extends K, ? extends V> paramMap, @NotNull C paramC, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$mapTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext()) {
      paramC.add(paramFunction1.invoke((Map.Entry)paramMap.next()));
    }
    return paramC;
  }
  
  @InlineOnly
  private static final <K, V, R extends Comparable<? super R>> Map.Entry<K, V> maxBy(@NotNull Map<? extends K, ? extends V> paramMap, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> paramFunction1)
  {
    Iterator localIterator = ((Iterable)paramMap.entrySet()).iterator();
    if (!localIterator.hasNext()) {
      paramMap = null;
    }
    label118:
    for (;;)
    {
      return (Map.Entry)paramMap;
      paramMap = localIterator.next();
      if (localIterator.hasNext())
      {
        Object localObject1 = (Comparable)paramFunction1.invoke(paramMap);
        Object localObject2 = localIterator.next();
        Comparable localComparable = (Comparable)paramFunction1.invoke(localObject2);
        if (((Comparable)localObject1).compareTo(localComparable) < 0)
        {
          paramMap = localObject2;
          localObject1 = localComparable;
        }
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label118;
          }
          break;
        }
      }
    }
  }
  
  @InlineOnly
  private static final <K, V> Map.Entry<K, V> maxWith(@NotNull Map<? extends K, ? extends V> paramMap, Comparator<? super Map.Entry<? extends K, ? extends V>> paramComparator)
  {
    return (Map.Entry)CollectionsKt.maxWith((Iterable)paramMap.entrySet(), paramComparator);
  }
  
  @Nullable
  public static final <K, V, R extends Comparable<? super R>> Map.Entry<K, V> minBy(@NotNull Map<? extends K, ? extends V> paramMap, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$minBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    Iterator localIterator = ((Iterable)paramMap.entrySet()).iterator();
    if (!localIterator.hasNext()) {
      paramMap = null;
    }
    label130:
    for (;;)
    {
      return (Map.Entry)paramMap;
      paramMap = localIterator.next();
      if (localIterator.hasNext())
      {
        Object localObject1 = (Comparable)paramFunction1.invoke(paramMap);
        Object localObject2 = localIterator.next();
        Comparable localComparable = (Comparable)paramFunction1.invoke(localObject2);
        if (((Comparable)localObject1).compareTo(localComparable) > 0)
        {
          paramMap = localObject2;
          localObject1 = localComparable;
        }
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label130;
          }
          break;
        }
      }
    }
  }
  
  @Nullable
  public static final <K, V> Map.Entry<K, V> minWith(@NotNull Map<? extends K, ? extends V> paramMap, @NotNull Comparator<? super Map.Entry<? extends K, ? extends V>> paramComparator)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$minWith");
    Intrinsics.checkParameterIsNotNull(paramComparator, "comparator");
    return (Map.Entry)CollectionsKt.minWith((Iterable)paramMap.entrySet(), paramComparator);
  }
  
  public static final <K, V> boolean none(@NotNull Map<? extends K, ? extends V> paramMap)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$none");
    return paramMap.isEmpty();
  }
  
  public static final <K, V> boolean none(@NotNull Map<? extends K, ? extends V> paramMap, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$none");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    if (paramMap.isEmpty()) {
      return true;
    }
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext()) {
      if (((Boolean)paramFunction1.invoke((Map.Entry)paramMap.next())).booleanValue()) {
        return false;
      }
    }
    return true;
  }
  
  @SinceKotlin(version="1.1")
  @NotNull
  public static final <K, V, M extends Map<? extends K, ? extends V>> M onEach(@NotNull M paramM, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramM, "$this$onEach");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "action");
    Iterator localIterator = paramM.entrySet().iterator();
    while (localIterator.hasNext()) {
      paramFunction1.invoke((Map.Entry)localIterator.next());
    }
    return paramM;
  }
  
  @NotNull
  public static final <K, V> List<Pair<K, V>> toList(@NotNull Map<? extends K, ? extends V> paramMap)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$toList");
    if (paramMap.size() == 0) {
      return CollectionsKt.emptyList();
    }
    Iterator localIterator = paramMap.entrySet().iterator();
    if (!localIterator.hasNext()) {
      return CollectionsKt.emptyList();
    }
    Map.Entry localEntry = (Map.Entry)localIterator.next();
    if (!localIterator.hasNext()) {
      return CollectionsKt.listOf(new Pair(localEntry.getKey(), localEntry.getValue()));
    }
    paramMap = new ArrayList(paramMap.size());
    paramMap.add(new Pair(localEntry.getKey(), localEntry.getValue()));
    do
    {
      localEntry = (Map.Entry)localIterator.next();
      paramMap.add(new Pair(localEntry.getKey(), localEntry.getValue()));
    } while (localIterator.hasNext());
    return (List)paramMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.collections.MapsKt___MapsKt
 * JD-Core Version:    0.7.0.1
 */