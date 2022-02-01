package shark;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lshark/HeapField;", "fieldRecord", "Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$ClassDumpRecord$StaticFieldRecord;", "invoke"}, k=3, mv={1, 4, 1})
final class HeapObject$HeapClass$readStaticFields$1
  extends Lambda
  implements Function1<HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.StaticFieldRecord, HeapField>
{
  HeapObject$HeapClass$readStaticFields$1(HeapObject.HeapClass paramHeapClass)
  {
    super(1);
  }
  
  @NotNull
  public final HeapField invoke(@NotNull HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.StaticFieldRecord paramStaticFieldRecord)
  {
    Intrinsics.checkParameterIsNotNull(paramStaticFieldRecord, "fieldRecord");
    HeapObject.HeapClass localHeapClass = this.this$0;
    return new HeapField(localHeapClass, HeapObject.HeapClass.b(localHeapClass).a(this.this$0.b(), paramStaticFieldRecord), new HeapValue((HeapGraph)HeapObject.HeapClass.b(this.this$0), paramStaticFieldRecord.c()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.HeapObject.HeapClass.readStaticFields.1
 * JD-Core Version:    0.7.0.1
 */