package kotlin.jvm.internal;

import java.util.Iterator;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"iterator", "", "T", "array", "", "([Ljava/lang/Object;)Ljava/util/Iterator;", "kotlin-stdlib"}, k=2, mv={1, 1, 16})
public final class ArrayIteratorKt
{
  @NotNull
  public static final <T> Iterator<T> iterator(@NotNull T[] paramArrayOfT)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "array");
    return (Iterator)new ArrayIterator(paramArrayOfT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.jvm.internal.ArrayIteratorKt
 * JD-Core Version:    0.7.0.1
 */