package shark;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/ObjectInspector;", "", "inspect", "", "reporter", "Lshark/ObjectReporter;", "Companion", "shark"}, k=1, mv={1, 4, 1})
public abstract interface ObjectInspector
{
  @NotNull
  public static final ObjectInspector.Companion a = ObjectInspector.Companion.a;
  
  public abstract void inspect(@NotNull ObjectReporter paramObjectReporter);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.ObjectInspector
 * JD-Core Version:    0.7.0.1
 */