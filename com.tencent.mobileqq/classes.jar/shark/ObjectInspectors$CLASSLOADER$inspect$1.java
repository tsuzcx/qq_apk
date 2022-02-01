package shark;

import java.util.Collection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "Lshark/ObjectReporter;", "it", "Lshark/HeapObject$HeapInstance;", "invoke"}, k=3, mv={1, 4, 1})
final class ObjectInspectors$CLASSLOADER$inspect$1
  extends Lambda
  implements Function2<ObjectReporter, HeapObject.HeapInstance, Unit>
{
  public static final 1 INSTANCE = new 1();
  
  ObjectInspectors$CLASSLOADER$inspect$1()
  {
    super(2);
  }
  
  public final void invoke(@NotNull ObjectReporter paramObjectReporter, @NotNull HeapObject.HeapInstance paramHeapInstance)
  {
    Intrinsics.checkParameterIsNotNull(paramObjectReporter, "$receiver");
    Intrinsics.checkParameterIsNotNull(paramHeapInstance, "it");
    ((Collection)paramObjectReporter.c()).add("A ClassLoader is never leaking");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.ObjectInspectors.CLASSLOADER.inspect.1
 * JD-Core Version:    0.7.0.1
 */