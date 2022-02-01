package shark;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.LongRef;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "", "record", "Lshark/HprofRecord;", "onHprofRecord", "shark/HprofDeobfuscator$writeHprofRecords$1$1"}, k=3, mv={1, 4, 1})
final class HprofDeobfuscator$writeHprofRecords$$inlined$use$lambda$1
  implements OnHprofRecordListener
{
  public final void a(long paramLong, @NotNull HprofRecord paramHprofRecord)
  {
    Intrinsics.checkParameterIsNotNull(paramHprofRecord, "record");
    if ((paramHprofRecord instanceof HprofRecord.HeapDumpEndRecord)) {
      return;
    }
    if ((paramHprofRecord instanceof HprofRecord.StringRecord))
    {
      this.a.a((HprofRecord)HprofDeobfuscator.a(this.b, (HprofRecord.StringRecord)paramHprofRecord, this.c, this.d));
      return;
    }
    if ((paramHprofRecord instanceof HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord))
    {
      paramHprofRecord = HprofDeobfuscator.a(this.b, (HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord)paramHprofRecord, this.c, this.d, this.e, this.f.element);
      Object localObject = (List)paramHprofRecord.component1();
      paramLong = ((Number)paramHprofRecord.component2()).longValue();
      this.f.element = paramLong;
      paramHprofRecord = ((Iterable)localObject).iterator();
      while (paramHprofRecord.hasNext())
      {
        localObject = (HprofRecord)paramHprofRecord.next();
        this.a.a((HprofRecord)localObject);
      }
    }
    this.a.a(paramHprofRecord);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.HprofDeobfuscator.writeHprofRecords..inlined.use.lambda.1
 * JD-Core Version:    0.7.0.1
 */