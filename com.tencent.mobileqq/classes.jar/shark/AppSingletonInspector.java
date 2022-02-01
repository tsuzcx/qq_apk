package shark;

import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/AppSingletonInspector;", "Lshark/ObjectInspector;", "singletonClasses", "", "", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "inspect", "", "reporter", "Lshark/ObjectReporter;", "shark"}, k=1, mv={1, 4, 1})
public final class AppSingletonInspector
  implements ObjectInspector
{
  private final String[] b;
  
  public void inspect(@NotNull ObjectReporter paramObjectReporter)
  {
    Intrinsics.checkParameterIsNotNull(paramObjectReporter, "reporter");
    if ((paramObjectReporter.d() instanceof HeapObject.HeapInstance))
    {
      Iterator localIterator = ((HeapObject.HeapInstance)paramObjectReporter.d()).k().n().iterator();
      while (localIterator.hasNext())
      {
        HeapObject.HeapClass localHeapClass = (HeapObject.HeapClass)localIterator.next();
        if (ArraysKt.contains(this.b, localHeapClass.h()))
        {
          Collection localCollection = (Collection)paramObjectReporter.c();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(localHeapClass.h());
          localStringBuilder.append(" is an app singleton");
          localCollection.add(localStringBuilder.toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.AppSingletonInspector
 * JD-Core Version:    0.7.0.1
 */