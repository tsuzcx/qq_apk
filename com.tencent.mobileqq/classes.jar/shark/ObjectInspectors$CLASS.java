package shark;

import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/ObjectInspectors$CLASS;", "Lshark/ObjectInspectors;", "inspect", "", "reporter", "Lshark/ObjectReporter;", "shark"}, k=1, mv={1, 4, 1})
final class ObjectInspectors$CLASS
  extends ObjectInspectors
{
  ObjectInspectors$CLASS()
  {
    super(str, i, null);
  }
  
  public void inspect(@NotNull ObjectReporter paramObjectReporter)
  {
    Intrinsics.checkParameterIsNotNull(paramObjectReporter, "reporter");
    if ((paramObjectReporter.d() instanceof HeapObject.HeapClass)) {
      ((Collection)paramObjectReporter.c()).add("a class is never leaking");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.ObjectInspectors.CLASS
 * JD-Core Version:    0.7.0.1
 */