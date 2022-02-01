package shark;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/ObjectInspectors$CLASSLOADER;", "Lshark/ObjectInspectors;", "inspect", "", "reporter", "Lshark/ObjectReporter;", "shark"}, k=1, mv={1, 4, 1})
final class ObjectInspectors$CLASSLOADER
  extends ObjectInspectors
{
  ObjectInspectors$CLASSLOADER()
  {
    super(str, i, null);
  }
  
  public void inspect(@NotNull ObjectReporter paramObjectReporter)
  {
    Intrinsics.checkParameterIsNotNull(paramObjectReporter, "reporter");
    paramObjectReporter.a(Reflection.getOrCreateKotlinClass(ClassLoader.class), (Function2)ObjectInspectors.CLASSLOADER.inspect.1.INSTANCE);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.ObjectInspectors.CLASSLOADER
 * JD-Core Version:    0.7.0.1
 */