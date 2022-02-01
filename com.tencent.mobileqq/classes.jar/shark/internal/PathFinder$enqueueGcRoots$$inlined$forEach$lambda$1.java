package shark.internal;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import shark.HeapField;
import shark.HeapObject.HeapInstance;
import shark.HeapValue;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke", "shark/internal/PathFinder$enqueueGcRoots$1$threadName$1"}, k=3, mv={1, 4, 1})
final class PathFinder$enqueueGcRoots$$inlined$forEach$lambda$1
  extends Lambda
  implements Function0<String>
{
  PathFinder$enqueueGcRoots$$inlined$forEach$lambda$1(HeapObject.HeapInstance paramHeapInstance, PathFinder paramPathFinder, PathFinder.State paramState, Map paramMap1, Map paramMap2)
  {
    super(0);
  }
  
  @NotNull
  public final String invoke()
  {
    Object localObject = this.$threadInstance.b(Reflection.getOrCreateKotlinClass(Thread.class), "name");
    if (localObject != null)
    {
      localObject = ((HeapField)localObject).c();
      if (localObject != null)
      {
        localObject = ((HeapValue)localObject).f();
        if (localObject != null) {
          break label43;
        }
      }
    }
    localObject = "";
    label43:
    this.$threadNames$inlined.put(this.$threadInstance, localObject);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.internal.PathFinder.enqueueGcRoots..inlined.forEach.lambda.1
 * JD-Core Version:    0.7.0.1
 */