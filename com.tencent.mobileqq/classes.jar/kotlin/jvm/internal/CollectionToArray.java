package kotlin.jvm.internal;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collection<*>;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"EMPTY", "", "", "[Ljava/lang/Object;", "MAX_SIZE", "", "collectionToArray", "collection", "", "toArray", "(Ljava/util/Collection;)[Ljava/lang/Object;", "a", "(Ljava/util/Collection;[Ljava/lang/Object;)[Ljava/lang/Object;", "toArrayImpl", "empty", "Lkotlin/Function0;", "alloc", "Lkotlin/Function1;", "trim", "Lkotlin/Function2;", "(Ljava/util/Collection;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)[Ljava/lang/Object;", "kotlin-stdlib"}, k=2, mv={1, 1, 16})
@JvmName(name="CollectionToArray")
public final class CollectionToArray
{
  private static final Object[] EMPTY = new Object[0];
  private static final int MAX_SIZE = 2147483645;
  
  @JvmName(name="toArray")
  @NotNull
  public static final Object[] toArray(@NotNull Collection<?> paramCollection)
  {
    Intrinsics.checkParameterIsNotNull(paramCollection, "collection");
    int i = paramCollection.size();
    if (i == 0) {}
    Iterator localIterator;
    do
    {
      return EMPTY;
      localIterator = paramCollection.iterator();
    } while (!localIterator.hasNext());
    paramCollection = new Object[i];
    i = 0;
    for (;;)
    {
      int j = i + 1;
      paramCollection[i] = localIterator.next();
      Object localObject;
      if (j >= paramCollection.length)
      {
        if (!localIterator.hasNext()) {
          return paramCollection;
        }
        int k = j * 3 + 1 >>> 1;
        i = k;
        if (k <= j) {
          if (j < 2147483645) {
            i = 2147483645;
          } else {
            throw ((Throwable)new OutOfMemoryError());
          }
        }
        localObject = Arrays.copyOf(paramCollection, i);
        Intrinsics.checkExpressionValueIsNotNull(localObject, "Arrays.copyOf(result, newSize)");
      }
      else
      {
        localObject = paramCollection;
        if (!localIterator.hasNext())
        {
          paramCollection = Arrays.copyOf(paramCollection, j);
          Intrinsics.checkExpressionValueIsNotNull(paramCollection, "Arrays.copyOf(result, size)");
          return paramCollection;
        }
      }
      i = j;
      paramCollection = (Collection<?>)localObject;
    }
  }
  
  @JvmName(name="toArray")
  @NotNull
  public static final Object[] toArray(@NotNull Collection<?> paramCollection, @Nullable Object[] paramArrayOfObject)
  {
    Intrinsics.checkParameterIsNotNull(paramCollection, "collection");
    if (paramArrayOfObject != null)
    {
      int j = paramCollection.size();
      int i = 0;
      Iterator localIterator;
      if (j == 0)
      {
        paramCollection = paramArrayOfObject;
        if (paramArrayOfObject.length > 0)
        {
          paramArrayOfObject[0] = null;
          return paramArrayOfObject;
        }
      }
      else
      {
        localIterator = paramCollection.iterator();
        if (!localIterator.hasNext())
        {
          paramCollection = paramArrayOfObject;
          if (paramArrayOfObject.length > 0)
          {
            paramArrayOfObject[0] = null;
            return paramArrayOfObject;
          }
        }
        else if (j <= paramArrayOfObject.length)
        {
          paramCollection = paramArrayOfObject;
        }
        else
        {
          paramCollection = Array.newInstance(paramArrayOfObject.getClass().getComponentType(), j);
          if (paramCollection == null) {
            break label235;
          }
        }
      }
      Object localObject;
      for (paramCollection = (Object[])paramCollection;; paramCollection = (Collection<?>)localObject)
      {
        j = i + 1;
        paramCollection[i] = localIterator.next();
        if (j >= paramCollection.length)
        {
          if (!localIterator.hasNext()) {
            return paramCollection;
          }
          int k = j * 3 + 1 >>> 1;
          i = k;
          if (k <= j) {
            if (j < 2147483645) {
              i = 2147483645;
            } else {
              throw ((Throwable)new OutOfMemoryError());
            }
          }
          localObject = Arrays.copyOf(paramCollection, i);
          Intrinsics.checkExpressionValueIsNotNull(localObject, "Arrays.copyOf(result, newSize)");
        }
        else
        {
          localObject = paramCollection;
          if (!localIterator.hasNext())
          {
            if (paramCollection == paramArrayOfObject)
            {
              paramArrayOfObject[j] = null;
              return paramArrayOfObject;
            }
            paramCollection = Arrays.copyOf(paramCollection, j);
            Intrinsics.checkExpressionValueIsNotNull(paramCollection, "Arrays.copyOf(result, size)");
            return paramCollection;
          }
        }
        i = j;
      }
      label235:
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
    }
    paramCollection = (Throwable)new NullPointerException();
    for (;;)
    {
      throw paramCollection;
    }
  }
  
  private static final Object[] toArrayImpl(Collection<?> paramCollection, Function0<Object[]> paramFunction0, Function1<? super Integer, Object[]> paramFunction1, Function2<? super Object[], ? super Integer, Object[]> paramFunction2)
  {
    int i = paramCollection.size();
    if (i == 0) {
      return (Object[])paramFunction0.invoke();
    }
    Iterator localIterator = paramCollection.iterator();
    if (!localIterator.hasNext()) {
      return (Object[])paramFunction0.invoke();
    }
    paramCollection = (Object[])paramFunction1.invoke(Integer.valueOf(i));
    i = 0;
    for (;;)
    {
      int j = i + 1;
      paramCollection[i] = localIterator.next();
      if (j >= paramCollection.length)
      {
        if (!localIterator.hasNext()) {
          return paramCollection;
        }
        int k = j * 3 + 1 >>> 1;
        i = k;
        if (k <= j) {
          if (j < 2147483645) {
            i = 2147483645;
          } else {
            throw ((Throwable)new OutOfMemoryError());
          }
        }
        paramFunction0 = Arrays.copyOf(paramCollection, i);
        Intrinsics.checkExpressionValueIsNotNull(paramFunction0, "Arrays.copyOf(result, newSize)");
      }
      else
      {
        paramFunction0 = paramCollection;
        if (!localIterator.hasNext()) {
          return (Object[])paramFunction2.invoke(paramCollection, Integer.valueOf(j));
        }
      }
      i = j;
      paramCollection = paramFunction0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.jvm.internal.CollectionToArray
 * JD-Core Version:    0.7.0.1
 */