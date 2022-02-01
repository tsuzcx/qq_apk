package kotlin.collections;

import java.util.Enumeration;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"iterator", "", "T", "Ljava/util/Enumeration;", "kotlin-stdlib"}, k=5, mv={1, 1, 16}, xi=1, xs="kotlin/collections/CollectionsKt")
public class CollectionsKt__IteratorsJVMKt
  extends CollectionsKt__IterablesKt
{
  @NotNull
  public static final <T> Iterator<T> iterator(@NotNull Enumeration<T> paramEnumeration)
  {
    Intrinsics.checkParameterIsNotNull(paramEnumeration, "$this$iterator");
    return (Iterator)new CollectionsKt__IteratorsJVMKt.iterator.1(paramEnumeration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.collections.CollectionsKt__IteratorsJVMKt
 * JD-Core Version:    0.7.0.1
 */