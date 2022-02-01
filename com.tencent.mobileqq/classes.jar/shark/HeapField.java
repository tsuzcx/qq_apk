package shark;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/HeapField;", "", "declaringClass", "Lshark/HeapObject$HeapClass;", "name", "", "value", "Lshark/HeapValue;", "(Lshark/HeapObject$HeapClass;Ljava/lang/String;Lshark/HeapValue;)V", "getDeclaringClass", "()Lshark/HeapObject$HeapClass;", "getName", "()Ljava/lang/String;", "getValue", "()Lshark/HeapValue;", "valueAsClass", "getValueAsClass", "valueAsInstance", "Lshark/HeapObject$HeapInstance;", "getValueAsInstance", "()Lshark/HeapObject$HeapInstance;", "valueAsObjectArray", "Lshark/HeapObject$HeapObjectArray;", "getValueAsObjectArray", "()Lshark/HeapObject$HeapObjectArray;", "valueAsPrimitiveArray", "Lshark/HeapObject$HeapPrimitiveArray;", "getValueAsPrimitiveArray", "()Lshark/HeapObject$HeapPrimitiveArray;", "shark-graph"}, k=1, mv={1, 4, 1})
public final class HeapField
{
  @NotNull
  private final HeapObject.HeapClass a;
  @NotNull
  private final String b;
  @NotNull
  private final HeapValue c;
  
  public HeapField(@NotNull HeapObject.HeapClass paramHeapClass, @NotNull String paramString, @NotNull HeapValue paramHeapValue)
  {
    this.a = paramHeapClass;
    this.b = paramString;
    this.c = paramHeapValue;
  }
  
  @NotNull
  public final HeapObject.HeapClass a()
  {
    return this.a;
  }
  
  @NotNull
  public final String b()
  {
    return this.b;
  }
  
  @NotNull
  public final HeapValue c()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.HeapField
 * JD-Core Version:    0.7.0.1
 */