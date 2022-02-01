package kotlin.reflect.jvm.internal.impl.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CollectionsKt
{
  public static final <T> void addIfNotNull(@NotNull Collection<T> paramCollection, @Nullable T paramT)
  {
    Intrinsics.checkParameterIsNotNull(paramCollection, "$this$addIfNotNull");
    if (paramT != null) {
      paramCollection.add(paramT);
    }
  }
  
  private static final int capacity(int paramInt)
  {
    if (paramInt < 3) {
      return 3;
    }
    return paramInt + paramInt / 3 + 1;
  }
  
  @NotNull
  public static final <T> List<T> compact(@NotNull ArrayList<T> paramArrayList)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayList, "$this$compact");
    int i = paramArrayList.size();
    if (i != 0)
    {
      if (i != 1)
      {
        paramArrayList.trimToSize();
        return (List)paramArrayList;
      }
      return kotlin.collections.CollectionsKt.listOf(kotlin.collections.CollectionsKt.first((List)paramArrayList));
    }
    return kotlin.collections.CollectionsKt.emptyList();
  }
  
  @NotNull
  public static final <K> Map<K, Integer> mapToIndex(@NotNull Iterable<? extends K> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$mapToIndex");
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    paramIterable = paramIterable.iterator();
    int i = 0;
    while (paramIterable.hasNext())
    {
      Object localObject = paramIterable.next();
      ((Map)localLinkedHashMap).put(localObject, Integer.valueOf(i));
      i += 1;
    }
    return (Map)localLinkedHashMap;
  }
  
  @NotNull
  public static final <K, V> HashMap<K, V> newHashMapWithExpectedSize(int paramInt)
  {
    return new HashMap(capacity(paramInt));
  }
  
  @NotNull
  public static final <E> HashSet<E> newHashSetWithExpectedSize(int paramInt)
  {
    return new HashSet(capacity(paramInt));
  }
  
  @NotNull
  public static final <E> LinkedHashSet<E> newLinkedHashSetWithExpectedSize(int paramInt)
  {
    return new LinkedHashSet(capacity(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.utils.CollectionsKt
 * JD-Core Version:    0.7.0.1
 */