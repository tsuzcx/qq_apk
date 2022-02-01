package shark;

import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import shark.internal.FieldValuesReader;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lshark/HeapField;", "fieldRecord", "Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$ClassDumpRecord$FieldRecord;", "invoke"}, k=3, mv={1, 4, 1})
final class HeapObject$HeapInstance$readFields$1$1
  extends Lambda
  implements Function1<HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.FieldRecord, HeapField>
{
  HeapObject$HeapInstance$readFields$1$1(HeapObject.HeapInstance.readFields.1 param1, HeapObject.HeapClass paramHeapClass)
  {
    super(1);
  }
  
  @NotNull
  public final HeapField invoke(@NotNull HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.FieldRecord paramFieldRecord)
  {
    Intrinsics.checkParameterIsNotNull(paramFieldRecord, "fieldRecord");
    String str = HeapObject.HeapInstance.a(this.this$0.this$0).a(this.$heapClass.b(), paramFieldRecord);
    Lazy localLazy = this.this$0.$fieldReader;
    KProperty localKProperty = this.this$0.$fieldReader$metadata;
    paramFieldRecord = ((FieldValuesReader)localLazy.getValue()).a(paramFieldRecord);
    return new HeapField(this.$heapClass, str, new HeapValue((HeapGraph)HeapObject.HeapInstance.a(this.this$0.this$0), paramFieldRecord));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.HeapObject.HeapInstance.readFields.1.1
 * JD-Core Version:    0.7.0.1
 */