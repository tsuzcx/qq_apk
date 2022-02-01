package shark;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import shark.internal.KeyedWeakReferenceMirror;
import shark.internal.KeyedWeakReferenceMirror.Companion;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lshark/internal/KeyedWeakReferenceMirror;", "it", "Lshark/HeapObject$HeapInstance;", "invoke"}, k=3, mv={1, 4, 1})
final class KeyedWeakReferenceFinder$findKeyedWeakReferences$1$addedToContext$2
  extends Lambda
  implements Function1<HeapObject.HeapInstance, KeyedWeakReferenceMirror>
{
  KeyedWeakReferenceFinder$findKeyedWeakReferences$1$addedToContext$2(Long paramLong)
  {
    super(1);
  }
  
  @NotNull
  public final KeyedWeakReferenceMirror invoke(@NotNull HeapObject.HeapInstance paramHeapInstance)
  {
    Intrinsics.checkParameterIsNotNull(paramHeapInstance, "it");
    return KeyedWeakReferenceMirror.a.a(paramHeapInstance, this.$heapDumpUptimeMillis);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.KeyedWeakReferenceFinder.findKeyedWeakReferences.1.addedToContext.2
 * JD-Core Version:    0.7.0.1
 */