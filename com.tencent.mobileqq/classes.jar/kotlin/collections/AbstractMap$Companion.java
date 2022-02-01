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
    boolean bool1 = paramObject instanceof Map.Entry;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    Object localObject = paramEntry.getKey();
    paramObject = (Map.Entry)paramObject;
    bool1 = bool2;
    if (Intrinsics.areEqual(localObject, paramObject.getKey()))
    {
      bool1 = bool2;
      if (Intrinsics.areEqual(paramEntry.getValue(), paramObject.getValue())) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final int entryHashCode$kotlin_stdlib(@NotNull Map.Entry<?, ?> paramEntry)
  {
    Intrinsics.checkParameterIsNotNull(paramEntry, "e");
    Object localObject = paramEntry.getKey();
    int j = 0;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    paramEntry = paramEntry.getValue();
    if (paramEntry != null) {
      j = paramEntry.hashCode();
    }
    return i ^ j;
  }
  
  @NotNull
  public final String entryToString$kotlin_stdlib(@NotNull Map.Entry<?, ?> paramEntry)
  {
    Intrinsics.checkParameterIsNotNull(paramEntry, "e");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramEntry.getKey());
    localStringBuilder.append('=');
    localStringBuilder.append(paramEntry.getValue());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.collections.AbstractMap.Companion
 * JD-Core Version:    0.7.0.1
 */