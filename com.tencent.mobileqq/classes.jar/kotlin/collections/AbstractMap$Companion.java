package kotlin.collections;

import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/collections/AbstractMap$Companion;", "", "()V", "entryEquals", "", "e", "", "other", "entryEquals$kotlin_stdlib", "entryHashCode", "", "entryHashCode$kotlin_stdlib", "entryToString", "", "entryToString$kotlin_stdlib", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class AbstractMap$Companion
{
  public final boolean entryEquals$kotlin_stdlib(@NotNull Map.Entry<?, ?> paramEntry, @Nullable Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramEntry, "e");
    if (!(paramObject instanceof Map.Entry)) {
      return false;
    }
    if ((Intrinsics.areEqual(paramEntry.getKey(), ((Map.Entry)paramObject).getKey())) && (Intrinsics.areEqual(paramEntry.getValue(), ((Map.Entry)paramObject).getValue()))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public final int entryHashCode$kotlin_stdlib(@NotNull Map.Entry<?, ?> paramEntry)
  {
    int j = 0;
    Intrinsics.checkParameterIsNotNull(paramEntry, "e");
    Object localObject = paramEntry.getKey();
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      paramEntry = paramEntry.getValue();
      if (paramEntry != null) {
        j = paramEntry.hashCode();
      }
      return i ^ j;
    }
  }
  
  @NotNull
  public final String entryToString$kotlin_stdlib(@NotNull Map.Entry<?, ?> paramEntry)
  {
    Intrinsics.checkParameterIsNotNull(paramEntry, "e");
    return paramEntry.getKey() + '=' + paramEntry.getValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.collections.AbstractMap.Companion
 * JD-Core Version:    0.7.0.1
 */