package shark;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "T", "Lshark/HprofRecord$HeapDumpRecord$ObjectRecord;", "Lshark/HprofRecordReader;", "invoke", "(Lshark/HprofRecordReader;)Lshark/HprofRecord$HeapDumpRecord$ObjectRecord;"}, k=3, mv={1, 4, 1})
final class HprofHeapGraph$readObjectRecord$1
  extends Lambda
  implements Function1<HprofRecordReader, T>
{
  HprofHeapGraph$readObjectRecord$1(Function1 paramFunction1)
  {
    super(1);
  }
  
  @NotNull
  public final T invoke(@NotNull HprofRecordReader paramHprofRecordReader)
  {
    Intrinsics.checkParameterIsNotNull(paramHprofRecordReader, "$receiver");
    return (HprofRecord.HeapDumpRecord.ObjectRecord)this.$readBlock.invoke(paramHprofRecordReader);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.HprofHeapGraph.readObjectRecord.1
 * JD-Core Version:    0.7.0.1
 */