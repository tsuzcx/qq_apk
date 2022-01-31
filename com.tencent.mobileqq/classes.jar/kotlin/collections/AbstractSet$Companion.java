package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/collections/AbstractSet$Companion;", "", "()V", "setEquals", "", "c", "", "other", "setEquals$kotlin_stdlib", "unorderedHashCode", "", "", "unorderedHashCode$kotlin_stdlib", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class AbstractSet$Companion
{
  public final boolean setEquals$kotlin_stdlib(@NotNull Set<?> paramSet1, @NotNull Set<?> paramSet2)
  {
    Intrinsics.checkParameterIsNotNull(paramSet1, "c");
    Intrinsics.checkParameterIsNotNull(paramSet2, "other");
    if (paramSet1.size() != paramSet2.size()) {
      return false;
    }
    return paramSet1.containsAll((Collection)paramSet2);
  }
  
  public final int unorderedHashCode$kotlin_stdlib(@NotNull Collection<?> paramCollection)
  {
    Intrinsics.checkParameterIsNotNull(paramCollection, "c");
    paramCollection = paramCollection.iterator();
    int i = 0;
    if (paramCollection.hasNext())
    {
      Object localObject = paramCollection.next();
      if (localObject != null) {}
      for (int j = localObject.hashCode();; j = 0)
      {
        i += j;
        break;
      }
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.collections.AbstractSet.Companion
 * JD-Core Version:    0.7.0.1
 */