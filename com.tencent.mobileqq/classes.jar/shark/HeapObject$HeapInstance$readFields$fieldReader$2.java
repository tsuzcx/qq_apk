package shark;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import shark.internal.FieldValuesReader;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lshark/internal/FieldValuesReader;", "invoke"}, k=3, mv={1, 4, 1})
final class HeapObject$HeapInstance$readFields$fieldReader$2
  extends Lambda
  implements Function0<FieldValuesReader>
{
  HeapObject$HeapInstance$readFields$fieldReader$2(HeapObject.HeapInstance paramHeapInstance)
  {
    super(0);
  }
  
  @NotNull
  public final FieldValuesReader invoke()
  {
    return HeapObject.HeapInstance.a(this.this$0).a(this.this$0.m());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.HeapObject.HeapInstance.readFields.fieldReader.2
 * JD-Core Version:    0.7.0.1
 */