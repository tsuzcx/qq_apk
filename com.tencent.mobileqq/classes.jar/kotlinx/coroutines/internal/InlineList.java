package kotlinx.coroutines.internal;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/internal/InlineList;", "E", "", "holder", "constructor-impl", "(Ljava/lang/Object;)Ljava/lang/Object;", "equals", "", "other", "forEachReversed", "", "action", "Lkotlin/Function1;", "forEachReversed-impl", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "hashCode", "", "plus", "element", "plus-impl", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "toString", "", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public final class InlineList<E>
{
  private final Object holder;
  
  @NotNull
  public static Object constructor-impl(@Nullable Object paramObject)
  {
    return paramObject;
  }
  
  public static boolean equals-impl(Object paramObject1, @Nullable Object paramObject2)
  {
    return ((paramObject2 instanceof InlineList)) && (Intrinsics.areEqual(paramObject1, ((InlineList)paramObject2).unbox-impl()));
  }
  
  public static final boolean equals-impl0(@Nullable Object paramObject1, @Nullable Object paramObject2)
  {
    return Intrinsics.areEqual(paramObject1, paramObject2);
  }
  
  public static final void forEachReversed-impl(Object paramObject, @NotNull Function1<? super E, Unit> paramFunction1)
  {
    if (paramObject == null) {
      return;
    }
    if (!(paramObject instanceof ArrayList))
    {
      paramFunction1.invoke(paramObject);
      return;
    }
    if (paramObject != null)
    {
      paramObject = (ArrayList)paramObject;
      int i = paramObject.size() - 1;
      while (i >= 0)
      {
        paramFunction1.invoke(paramObject.get(i));
        i -= 1;
      }
      return;
    }
    paramObject = new TypeCastException("null cannot be cast to non-null type kotlin.collections.ArrayList<E> /* = java.util.ArrayList<E> */");
    for (;;)
    {
      throw paramObject;
    }
  }
  
  public static int hashCode-impl(Object paramObject)
  {
    if (paramObject != null) {
      return paramObject.hashCode();
    }
    return 0;
  }
  
  @NotNull
  public static final Object plus-impl(Object paramObject, E paramE)
  {
    if (DebugKt.getASSERTIONS_ENABLED())
    {
      int i;
      if (!(paramE instanceof List)) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0) {
        throw ((Throwable)new AssertionError());
      }
    }
    if (paramObject == null) {
      return constructor-impl(paramE);
    }
    if ((paramObject instanceof ArrayList))
    {
      if (paramObject != null)
      {
        ((ArrayList)paramObject).add(paramE);
        return constructor-impl(paramObject);
      }
      throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.ArrayList<E> /* = java.util.ArrayList<E> */");
    }
    ArrayList localArrayList = new ArrayList(4);
    localArrayList.add(paramObject);
    localArrayList.add(paramE);
    return constructor-impl(localArrayList);
  }
  
  @NotNull
  public static String toString-impl(Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("InlineList(holder=");
    localStringBuilder.append(paramObject);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public boolean equals(Object paramObject)
  {
    return equals-impl(this.holder, paramObject);
  }
  
  public int hashCode()
  {
    return hashCode-impl(this.holder);
  }
  
  public String toString()
  {
    return toString-impl(this.holder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.internal.InlineList
 * JD-Core Version:    0.7.0.1
 */