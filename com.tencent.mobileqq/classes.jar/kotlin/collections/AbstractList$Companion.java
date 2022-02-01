package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/collections/AbstractList$Companion;", "", "()V", "checkBoundsIndexes", "", "startIndex", "", "endIndex", "size", "checkBoundsIndexes$kotlin_stdlib", "checkElementIndex", "index", "checkElementIndex$kotlin_stdlib", "checkPositionIndex", "checkPositionIndex$kotlin_stdlib", "checkRangeIndexes", "fromIndex", "toIndex", "checkRangeIndexes$kotlin_stdlib", "orderedEquals", "", "c", "", "other", "orderedEquals$kotlin_stdlib", "orderedHashCode", "orderedHashCode$kotlin_stdlib", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class AbstractList$Companion
{
  public final void checkBoundsIndexes$kotlin_stdlib(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 >= 0) && (paramInt2 <= paramInt3))
    {
      if (paramInt1 <= paramInt2) {
        return;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("startIndex: ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" > endIndex: ");
      localStringBuilder.append(paramInt2);
      throw ((Throwable)new IllegalArgumentException(localStringBuilder.toString()));
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startIndex: ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", endIndex: ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(", size: ");
    localStringBuilder.append(paramInt3);
    throw ((Throwable)new IndexOutOfBoundsException(localStringBuilder.toString()));
  }
  
  public final void checkElementIndex$kotlin_stdlib(int paramInt1, int paramInt2)
  {
    if ((paramInt1 >= 0) && (paramInt1 < paramInt2)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("index: ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", size: ");
    localStringBuilder.append(paramInt2);
    throw ((Throwable)new IndexOutOfBoundsException(localStringBuilder.toString()));
  }
  
  public final void checkPositionIndex$kotlin_stdlib(int paramInt1, int paramInt2)
  {
    if ((paramInt1 >= 0) && (paramInt1 <= paramInt2)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("index: ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", size: ");
    localStringBuilder.append(paramInt2);
    throw ((Throwable)new IndexOutOfBoundsException(localStringBuilder.toString()));
  }
  
  public final void checkRangeIndexes$kotlin_stdlib(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 >= 0) && (paramInt2 <= paramInt3))
    {
      if (paramInt1 <= paramInt2) {
        return;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("fromIndex: ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" > toIndex: ");
      localStringBuilder.append(paramInt2);
      throw ((Throwable)new IllegalArgumentException(localStringBuilder.toString()));
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fromIndex: ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", toIndex: ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(", size: ");
    localStringBuilder.append(paramInt3);
    throw ((Throwable)new IndexOutOfBoundsException(localStringBuilder.toString()));
  }
  
  public final boolean orderedEquals$kotlin_stdlib(@NotNull Collection<?> paramCollection1, @NotNull Collection<?> paramCollection2)
  {
    Intrinsics.checkParameterIsNotNull(paramCollection1, "c");
    Intrinsics.checkParameterIsNotNull(paramCollection2, "other");
    if (paramCollection1.size() != paramCollection2.size()) {
      return false;
    }
    paramCollection2 = paramCollection2.iterator();
    paramCollection1 = paramCollection1.iterator();
    while (paramCollection1.hasNext()) {
      if ((Intrinsics.areEqual(paramCollection1.next(), paramCollection2.next()) ^ true)) {
        return false;
      }
    }
    return true;
  }
  
  public final int orderedHashCode$kotlin_stdlib(@NotNull Collection<?> paramCollection)
  {
    Intrinsics.checkParameterIsNotNull(paramCollection, "c");
    paramCollection = paramCollection.iterator();
    int j;
    for (int i = 1; paramCollection.hasNext(); i = i * 31 + j)
    {
      Object localObject = paramCollection.next();
      if (localObject != null) {
        j = localObject.hashCode();
      } else {
        j = 0;
      }
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.collections.AbstractList.Companion
 * JD-Core Version:    0.7.0.1
 */