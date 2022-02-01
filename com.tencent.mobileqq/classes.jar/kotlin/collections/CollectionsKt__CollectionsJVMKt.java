package kotlin.collections;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.TypeCastException;
import kotlin.internal.InlineOnly;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"checkCountOverflow", "", "count", "checkIndexOverflow", "index", "copyToArrayImpl", "", "", "collection", "", "(Ljava/util/Collection;)[Ljava/lang/Object;", "T", "array", "(Ljava/util/Collection;[Ljava/lang/Object;)[Ljava/lang/Object;", "listOf", "", "element", "(Ljava/lang/Object;)Ljava/util/List;", "copyToArrayOfAny", "isVarargs", "", "([Ljava/lang/Object;Z)[Ljava/lang/Object;", "toList", "Ljava/util/Enumeration;", "kotlin-stdlib"}, k=5, mv={1, 1, 16}, xi=1, xs="kotlin/collections/CollectionsKt")
public class CollectionsKt__CollectionsJVMKt
{
  @PublishedApi
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int checkCountOverflow(int paramInt)
  {
    if (paramInt < 0)
    {
      if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
        CollectionsKt.throwCountOverflow();
      }
    }
    else {
      return paramInt;
    }
    throw ((Throwable)new ArithmeticException("Count overflow has happened."));
  }
  
  @PublishedApi
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int checkIndexOverflow(int paramInt)
  {
    if (paramInt < 0)
    {
      if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
        CollectionsKt.throwIndexOverflow();
      }
    }
    else {
      return paramInt;
    }
    throw ((Throwable)new ArithmeticException("Index overflow has happened."));
  }
  
  @InlineOnly
  private static final Object[] copyToArrayImpl(Collection<?> paramCollection)
  {
    return CollectionToArray.toArray(paramCollection);
  }
  
  @InlineOnly
  private static final <T> T[] copyToArrayImpl(Collection<?> paramCollection, T[] paramArrayOfT)
  {
    if (paramArrayOfT == null) {
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
    }
    paramCollection = CollectionToArray.toArray(paramCollection, paramArrayOfT);
    if (paramCollection == null) {
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }
    return paramCollection;
  }
  
  @NotNull
  public static final <T> Object[] copyToArrayOfAny(@NotNull T[] paramArrayOfT, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$copyToArrayOfAny");
    if ((paramBoolean) && (Intrinsics.areEqual(paramArrayOfT.getClass(), [Ljava.lang.Object.class))) {
      return paramArrayOfT;
    }
    paramArrayOfT = Arrays.copyOf(paramArrayOfT, paramArrayOfT.length, [Ljava.lang.Object.class);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfT, "java.util.Arrays.copyOf(… Array<Any?>::class.java)");
    return paramArrayOfT;
  }
  
  @NotNull
  public static final <T> List<T> listOf(T paramT)
  {
    paramT = Collections.singletonList(paramT);
    Intrinsics.checkExpressionValueIsNotNull(paramT, "java.util.Collections.singletonList(element)");
    return paramT;
  }
  
  @InlineOnly
  private static final <T> List<T> toList(@NotNull Enumeration<T> paramEnumeration)
  {
    paramEnumeration = Collections.list(paramEnumeration);
    Intrinsics.checkExpressionValueIsNotNull(paramEnumeration, "java.util.Collections.list(this)");
    return (List)paramEnumeration;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.collections.CollectionsKt__CollectionsJVMKt
 * JD-Core Version:    0.7.0.1
 */