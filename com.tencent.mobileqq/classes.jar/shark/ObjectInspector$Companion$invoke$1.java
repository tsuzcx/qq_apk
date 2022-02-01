package shark;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"shark/ObjectInspector$Companion$invoke$1", "Lshark/ObjectInspector;", "inspect", "", "reporter", "Lshark/ObjectReporter;", "shark"}, k=1, mv={1, 4, 1})
public final class ObjectInspector$Companion$invoke$1
  implements ObjectInspector
{
  public void inspect(@NotNull ObjectReporter paramObjectReporter)
  {
    Intrinsics.checkParameterIsNotNull(paramObjectReporter, "reporter");
    this.b.invoke(paramObjectReporter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.ObjectInspector.Companion.invoke.1
 * JD-Core Version:    0.7.0.1
 */