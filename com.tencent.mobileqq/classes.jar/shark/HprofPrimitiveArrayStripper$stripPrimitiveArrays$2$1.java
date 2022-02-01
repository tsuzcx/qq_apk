package shark;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "", "record", "Lshark/HprofRecord;", "onHprofRecord"}, k=3, mv={1, 4, 1})
final class HprofPrimitiveArrayStripper$stripPrimitiveArrays$2$1
  implements OnHprofRecordListener
{
  public final void a(long paramLong, @NotNull HprofRecord paramHprofRecord)
  {
    Intrinsics.checkParameterIsNotNull(paramHprofRecord, "record");
    if ((paramHprofRecord instanceof HprofRecord.HeapDumpEndRecord)) {
      return;
    }
    HprofWriter localHprofWriter = this.a;
    HprofRecord localHprofRecord;
    if ((paramHprofRecord instanceof HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.BooleanArrayDump))
    {
      paramHprofRecord = (HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.BooleanArrayDump)paramHprofRecord;
      localHprofRecord = (HprofRecord)new HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.BooleanArrayDump(paramHprofRecord.a(), paramHprofRecord.b(), new boolean[paramHprofRecord.c().length]);
    }
    else if ((paramHprofRecord instanceof HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.CharArrayDump))
    {
      paramHprofRecord = (HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.CharArrayDump)paramHprofRecord;
      paramLong = paramHprofRecord.a();
      int j = paramHprofRecord.b();
      int k = paramHprofRecord.c().length;
      paramHprofRecord = new char[k];
      int i = 0;
      while (i < k)
      {
        paramHprofRecord[i] = 63;
        i += 1;
      }
      localHprofRecord = (HprofRecord)new HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.CharArrayDump(paramLong, j, paramHprofRecord);
    }
    else if ((paramHprofRecord instanceof HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.FloatArrayDump))
    {
      paramHprofRecord = (HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.FloatArrayDump)paramHprofRecord;
      localHprofRecord = (HprofRecord)new HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.FloatArrayDump(paramHprofRecord.a(), paramHprofRecord.b(), new float[paramHprofRecord.c().length]);
    }
    else if ((paramHprofRecord instanceof HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.DoubleArrayDump))
    {
      paramHprofRecord = (HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.DoubleArrayDump)paramHprofRecord;
      localHprofRecord = (HprofRecord)new HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.DoubleArrayDump(paramHprofRecord.a(), paramHprofRecord.b(), new double[paramHprofRecord.c().length]);
    }
    else if ((paramHprofRecord instanceof HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.ByteArrayDump))
    {
      paramHprofRecord = (HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.ByteArrayDump)paramHprofRecord;
      localHprofRecord = (HprofRecord)new HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.ByteArrayDump(paramHprofRecord.a(), paramHprofRecord.b(), new byte[paramHprofRecord.c().length]);
    }
    else if ((paramHprofRecord instanceof HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.ShortArrayDump))
    {
      paramHprofRecord = (HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.ShortArrayDump)paramHprofRecord;
      localHprofRecord = (HprofRecord)new HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.ShortArrayDump(paramHprofRecord.a(), paramHprofRecord.b(), new short[paramHprofRecord.c().length]);
    }
    else if ((paramHprofRecord instanceof HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.IntArrayDump))
    {
      paramHprofRecord = (HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.IntArrayDump)paramHprofRecord;
      localHprofRecord = (HprofRecord)new HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.IntArrayDump(paramHprofRecord.a(), paramHprofRecord.b(), new int[paramHprofRecord.c().length]);
    }
    else
    {
      localHprofRecord = paramHprofRecord;
      if ((paramHprofRecord instanceof HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.LongArrayDump))
      {
        paramHprofRecord = (HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.LongArrayDump)paramHprofRecord;
        localHprofRecord = (HprofRecord)new HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.LongArrayDump(paramHprofRecord.a(), paramHprofRecord.b(), new long[paramHprofRecord.c().length]);
      }
    }
    localHprofWriter.a(localHprofRecord);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.HprofPrimitiveArrayStripper.stripPrimitiveArrays.2.1
 * JD-Core Version:    0.7.0.1
 */