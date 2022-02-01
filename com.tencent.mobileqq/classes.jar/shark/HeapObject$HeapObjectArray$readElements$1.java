package shark;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lshark/HeapValue;", "it", "", "invoke"}, k=3, mv={1, 4, 1})
final class HeapObject$HeapObjectArray$readElements$1
  extends Lambda
  implements Function1<Long, HeapValue>
{
  HeapObject$HeapObjectArray$readElements$1(HeapObject.HeapObjectArray paramHeapObjectArray)
  {
    super(1);
  }
  
  @NotNull
  public final HeapValue invoke(long paramLong)
  {
    return new HeapValue((HeapGraph)HeapObject.HeapObjectArray.a(this.this$0), (ValueHolder)new ValueHolder.ReferenceHolder(paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.HeapObject.HeapObjectArray.readElements.1
 * JD-Core Version:    0.7.0.1
 */