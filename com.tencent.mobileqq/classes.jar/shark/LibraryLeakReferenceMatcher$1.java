package shark;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lshark/HeapGraph;", "invoke"}, k=3, mv={1, 4, 1})
final class LibraryLeakReferenceMatcher$1
  extends Lambda
  implements Function1<HeapGraph, Boolean>
{
  public static final 1 INSTANCE = new 1();
  
  LibraryLeakReferenceMatcher$1()
  {
    super(1);
  }
  
  public final boolean invoke(@NotNull HeapGraph paramHeapGraph)
  {
    Intrinsics.checkParameterIsNotNull(paramHeapGraph, "it");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.LibraryLeakReferenceMatcher.1
 * JD-Core Version:    0.7.0.1
 */