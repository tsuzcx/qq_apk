package shark;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"shark/OnHprofRecordTagListener$Companion$invoke$1", "Lshark/OnHprofRecordTagListener;", "onHprofRecord", "", "tag", "Lshark/HprofRecordTag;", "length", "", "reader", "Lshark/HprofRecordReader;", "shark-hprof"}, k=1, mv={1, 4, 1})
public final class StreamingRecordReaderAdapter$readRecords$$inlined$invoke$1
  implements OnHprofRecordTagListener
{
  public void a(@NotNull HprofRecordTag paramHprofRecordTag, long paramLong, @NotNull HprofRecordReader paramHprofRecordReader)
  {
    Intrinsics.checkParameterIsNotNull(paramHprofRecordTag, "tag");
    Intrinsics.checkParameterIsNotNull(paramHprofRecordReader, "reader");
    switch (StreamingRecordReaderAdapter.WhenMappings.$EnumSwitchMapping$0[paramHprofRecordTag.ordinal()])
    {
    default: 
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unexpected heap dump tag ");
      localStringBuilder.append(paramHprofRecordTag);
      localStringBuilder.append(" at position ");
      localStringBuilder.append(paramHprofRecordReader.a());
      throw ((Throwable)new IllegalStateException(localStringBuilder.toString().toString()));
    case 26: 
      paramLong = paramHprofRecordReader.a();
      paramHprofRecordTag = HprofRecord.HeapDumpEndRecord.a;
      this.b.a(paramLong, (HprofRecord)paramHprofRecordTag);
      return;
    case 25: 
      paramLong = paramHprofRecordReader.a();
      paramHprofRecordTag = paramHprofRecordReader.v();
      this.b.a(paramLong, (HprofRecord)paramHprofRecordTag);
      return;
    case 24: 
      paramLong = paramHprofRecordReader.a();
      paramHprofRecordTag = paramHprofRecordReader.x();
      this.b.a(paramLong, (HprofRecord)paramHprofRecordTag);
      return;
    case 23: 
      paramLong = paramHprofRecordReader.a();
      paramHprofRecordTag = paramHprofRecordReader.y();
      this.b.a(paramLong, (HprofRecord)paramHprofRecordTag);
      return;
    case 22: 
      paramLong = paramHprofRecordReader.a();
      paramHprofRecordTag = paramHprofRecordReader.u();
      this.b.a(paramLong, (HprofRecord)paramHprofRecordTag);
      return;
    case 21: 
      paramLong = paramHprofRecordReader.a();
      paramHprofRecordTag = paramHprofRecordReader.w();
      this.b.a(paramLong, (HprofRecord)paramHprofRecordTag);
      return;
    case 20: 
      paramLong = paramHprofRecordReader.a();
      paramHprofRecordTag = paramHprofRecordReader.t();
      this.b.a(paramLong, (HprofRecord)new HprofRecord.HeapDumpRecord.GcRootRecord((GcRoot)paramHprofRecordTag));
      return;
    case 19: 
      paramLong = paramHprofRecordReader.a();
      paramHprofRecordTag = paramHprofRecordReader.s();
      this.b.a(paramLong, (HprofRecord)new HprofRecord.HeapDumpRecord.GcRootRecord((GcRoot)paramHprofRecordTag));
      return;
    case 18: 
      paramLong = paramHprofRecordReader.a();
      paramHprofRecordTag = paramHprofRecordReader.r();
      this.b.a(paramLong, (HprofRecord)new HprofRecord.HeapDumpRecord.GcRootRecord((GcRoot)paramHprofRecordTag));
      return;
    case 17: 
      paramLong = paramHprofRecordReader.a();
      paramHprofRecordTag = paramHprofRecordReader.q();
      this.b.a(paramLong, (HprofRecord)new HprofRecord.HeapDumpRecord.GcRootRecord((GcRoot)paramHprofRecordTag));
      return;
    case 16: 
      paramLong = paramHprofRecordReader.a();
      paramHprofRecordTag = paramHprofRecordReader.p();
      this.b.a(paramLong, (HprofRecord)new HprofRecord.HeapDumpRecord.GcRootRecord((GcRoot)paramHprofRecordTag));
      return;
    case 15: 
      paramLong = paramHprofRecordReader.a();
      paramHprofRecordTag = paramHprofRecordReader.o();
      this.b.a(paramLong, (HprofRecord)new HprofRecord.HeapDumpRecord.GcRootRecord((GcRoot)paramHprofRecordTag));
      return;
    case 14: 
      paramLong = paramHprofRecordReader.a();
      paramHprofRecordTag = paramHprofRecordReader.n();
      this.b.a(paramLong, (HprofRecord)new HprofRecord.HeapDumpRecord.GcRootRecord((GcRoot)paramHprofRecordTag));
      return;
    case 13: 
      paramLong = paramHprofRecordReader.a();
      paramHprofRecordTag = paramHprofRecordReader.m();
      this.b.a(paramLong, (HprofRecord)new HprofRecord.HeapDumpRecord.GcRootRecord((GcRoot)paramHprofRecordTag));
      return;
    case 12: 
      paramLong = paramHprofRecordReader.a();
      paramHprofRecordTag = paramHprofRecordReader.l();
      this.b.a(paramLong, (HprofRecord)new HprofRecord.HeapDumpRecord.GcRootRecord((GcRoot)paramHprofRecordTag));
      return;
    case 11: 
      paramLong = paramHprofRecordReader.a();
      paramHprofRecordTag = paramHprofRecordReader.k();
      this.b.a(paramLong, (HprofRecord)new HprofRecord.HeapDumpRecord.GcRootRecord((GcRoot)paramHprofRecordTag));
      return;
    case 10: 
      paramLong = paramHprofRecordReader.a();
      paramHprofRecordTag = paramHprofRecordReader.j();
      this.b.a(paramLong, (HprofRecord)new HprofRecord.HeapDumpRecord.GcRootRecord((GcRoot)paramHprofRecordTag));
      return;
    case 9: 
      paramLong = paramHprofRecordReader.a();
      paramHprofRecordTag = paramHprofRecordReader.i();
      this.b.a(paramLong, (HprofRecord)new HprofRecord.HeapDumpRecord.GcRootRecord((GcRoot)paramHprofRecordTag));
      return;
    case 8: 
      paramLong = paramHprofRecordReader.a();
      paramHprofRecordTag = paramHprofRecordReader.h();
      this.b.a(paramLong, (HprofRecord)new HprofRecord.HeapDumpRecord.GcRootRecord((GcRoot)paramHprofRecordTag));
      return;
    case 7: 
      paramLong = paramHprofRecordReader.a();
      paramHprofRecordTag = paramHprofRecordReader.g();
      this.b.a(paramLong, (HprofRecord)new HprofRecord.HeapDumpRecord.GcRootRecord((GcRoot)paramHprofRecordTag));
      return;
    case 6: 
      paramLong = paramHprofRecordReader.a();
      paramHprofRecordTag = paramHprofRecordReader.f();
      this.b.a(paramLong, (HprofRecord)new HprofRecord.HeapDumpRecord.GcRootRecord((GcRoot)paramHprofRecordTag));
      return;
    case 5: 
      paramLong = paramHprofRecordReader.a();
      paramHprofRecordTag = paramHprofRecordReader.e();
      this.b.a(paramLong, (HprofRecord)new HprofRecord.HeapDumpRecord.GcRootRecord((GcRoot)paramHprofRecordTag));
      return;
    case 4: 
      paramLong = paramHprofRecordReader.a();
      paramHprofRecordTag = paramHprofRecordReader.d();
      this.b.a(paramLong, (HprofRecord)paramHprofRecordTag);
      return;
    case 3: 
      paramLong = paramHprofRecordReader.a();
      paramHprofRecordTag = paramHprofRecordReader.c();
      this.b.a(paramLong, (HprofRecord)paramHprofRecordTag);
      return;
    case 2: 
      paramLong = paramHprofRecordReader.a();
      paramHprofRecordTag = paramHprofRecordReader.b();
      this.b.a(paramLong, (HprofRecord)paramHprofRecordTag);
      return;
    }
    long l = paramHprofRecordReader.a();
    paramHprofRecordTag = paramHprofRecordReader.a(paramLong);
    this.b.a(l, (HprofRecord)paramHprofRecordTag);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.StreamingRecordReaderAdapter.readRecords..inlined.invoke.1
 * JD-Core Version:    0.7.0.1
 */