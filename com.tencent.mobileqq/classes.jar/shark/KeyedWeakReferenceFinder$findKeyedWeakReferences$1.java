package shark;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;
import shark.internal.KeyedWeakReferenceMirror;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "Lshark/internal/KeyedWeakReferenceMirror;", "invoke"}, k=3, mv={1, 4, 1})
final class KeyedWeakReferenceFinder$findKeyedWeakReferences$1
  extends Lambda
  implements Function0<List<? extends KeyedWeakReferenceMirror>>
{
  KeyedWeakReferenceFinder$findKeyedWeakReferences$1(HeapGraph paramHeapGraph)
  {
    super(0);
  }
  
  @NotNull
  public final List<KeyedWeakReferenceMirror> invoke()
  {
    Object localObject = this.$graph.a("leakcanary.KeyedWeakReference");
    long l2 = 0L;
    long l1;
    if (localObject != null) {
      l1 = ((HeapObject.HeapClass)localObject).b();
    } else {
      l1 = 0L;
    }
    localObject = this.$graph.a("com.squareup.leakcanary.KeyedWeakReference");
    if (localObject != null) {
      l2 = ((HeapObject.HeapClass)localObject).b();
    }
    localObject = KeyedWeakReferenceFinder.a.b(this.$graph);
    localObject = SequencesKt.toList(SequencesKt.map(SequencesKt.filter(this.$graph.f(), (Function1)new KeyedWeakReferenceFinder.findKeyedWeakReferences.1.addedToContext.1(l1, l2)), (Function1)new KeyedWeakReferenceFinder.findKeyedWeakReferences.1.addedToContext.2((Long)localObject)));
    this.$graph.b().a(ObjectInspectors.KEYED_WEAK_REFERENCE.name(), localObject);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.KeyedWeakReferenceFinder.findKeyedWeakReferences.1
 * JD-Core Version:    0.7.0.1
 */