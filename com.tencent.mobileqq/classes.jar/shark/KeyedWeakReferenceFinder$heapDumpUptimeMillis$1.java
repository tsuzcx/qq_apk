package shark;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke", "()Ljava/lang/Long;"}, k=3, mv={1, 4, 1})
final class KeyedWeakReferenceFinder$heapDumpUptimeMillis$1
  extends Lambda
  implements Function0<Long>
{
  KeyedWeakReferenceFinder$heapDumpUptimeMillis$1(HeapGraph paramHeapGraph)
  {
    super(0);
  }
  
  @Nullable
  public final Long invoke()
  {
    Object localObject1 = this.$graph.a("leakcanary.KeyedWeakReference");
    SharkLog.Logger localLogger = null;
    if (localObject1 == null)
    {
      localObject1 = localLogger;
    }
    else
    {
      Object localObject2 = ((HeapObject.HeapClass)localObject1).b("heapDumpUptimeMillis");
      localObject1 = localLogger;
      if (localObject2 != null)
      {
        localObject2 = ((HeapField)localObject2).c();
        localObject1 = localLogger;
        if (localObject2 != null) {
          localObject1 = ((HeapValue)localObject2).b();
        }
      }
    }
    if (localObject1 == null)
    {
      localLogger = SharkLog.a.a();
      if (localLogger != null) {
        localLogger.a("leakcanary.KeyedWeakReference.heapDumpUptimeMillis field not found");
      }
    }
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.KeyedWeakReferenceFinder.heapDumpUptimeMillis.1
 * JD-Core Version:    0.7.0.1
 */