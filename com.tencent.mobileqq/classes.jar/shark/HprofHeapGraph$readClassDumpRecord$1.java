package shark;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$ClassDumpRecord;", "Lshark/HprofRecordReader;", "invoke"}, k=3, mv={1, 4, 1})
final class HprofHeapGraph$readClassDumpRecord$1
  extends Lambda
  implements Function1<HprofRecordReader, HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord>
{
  public static final 1 INSTANCE = new 1();
  
  HprofHeapGraph$readClassDumpRecord$1()
  {
    super(1);
  }
  
  @NotNull
  public final HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord invoke(@NotNull HprofRecordReader paramHprofRecordReader)
  {
    Intrinsics.checkParameterIsNotNull(paramHprofRecordReader, "$receiver");
    return paramHprofRecordReader.w();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.HprofHeapGraph.readClassDumpRecord.1
 * JD-Core Version:    0.7.0.1
 */