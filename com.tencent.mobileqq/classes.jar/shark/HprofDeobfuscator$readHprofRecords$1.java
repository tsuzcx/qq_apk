package shark;

import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.LongRef;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "", "record", "Lshark/HprofRecord;", "onHprofRecord"}, k=3, mv={1, 4, 1})
final class HprofDeobfuscator$readHprofRecords$1
  implements OnHprofRecordListener
{
  public final void a(long paramLong, @NotNull HprofRecord paramHprofRecord)
  {
    Intrinsics.checkParameterIsNotNull(paramHprofRecord, "record");
    Ref.LongRef localLongRef;
    if ((paramHprofRecord instanceof HprofRecord.StringRecord))
    {
      localLongRef = this.a;
      paramLong = localLongRef.element;
      paramHprofRecord = (HprofRecord.StringRecord)paramHprofRecord;
      localLongRef.element = RangesKt.coerceAtLeast(paramLong, paramHprofRecord.a());
      this.b.put(Long.valueOf(paramHprofRecord.a()), paramHprofRecord.b());
      return;
    }
    if ((paramHprofRecord instanceof HprofRecord.LoadClassRecord))
    {
      localLongRef = this.a;
      paramLong = localLongRef.element;
      paramHprofRecord = (HprofRecord.LoadClassRecord)paramHprofRecord;
      localLongRef.element = RangesKt.coerceAtLeast(paramLong, paramHprofRecord.b());
      this.c.put(Long.valueOf(paramHprofRecord.b()), Long.valueOf(paramHprofRecord.d()));
      return;
    }
    if ((paramHprofRecord instanceof HprofRecord.StackFrameRecord))
    {
      localLongRef = this.a;
      localLongRef.element = RangesKt.coerceAtLeast(localLongRef.element, ((HprofRecord.StackFrameRecord)paramHprofRecord).a());
      return;
    }
    if ((paramHprofRecord instanceof HprofRecord.HeapDumpRecord.ObjectRecord))
    {
      localLongRef = this.a;
      if ((paramHprofRecord instanceof HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord))
      {
        paramLong = RangesKt.coerceAtLeast(localLongRef.element, ((HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord)paramHprofRecord).a());
      }
      else if ((paramHprofRecord instanceof HprofRecord.HeapDumpRecord.ObjectRecord.InstanceDumpRecord))
      {
        paramLong = RangesKt.coerceAtLeast(localLongRef.element, ((HprofRecord.HeapDumpRecord.ObjectRecord.InstanceDumpRecord)paramHprofRecord).a());
      }
      else if ((paramHprofRecord instanceof HprofRecord.HeapDumpRecord.ObjectRecord.ObjectArrayDumpRecord))
      {
        paramLong = RangesKt.coerceAtLeast(localLongRef.element, ((HprofRecord.HeapDumpRecord.ObjectRecord.ObjectArrayDumpRecord)paramHprofRecord).a());
      }
      else
      {
        if (!(paramHprofRecord instanceof HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord)) {
          break label282;
        }
        paramLong = RangesKt.coerceAtLeast(localLongRef.element, ((HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord)paramHprofRecord).a());
      }
      localLongRef.element = paramLong;
      return;
      label282:
      throw new NoWhenBranchMatchedException();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.HprofDeobfuscator.readHprofRecords.1
 * JD-Core Version:    0.7.0.1
 */