package shark;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/HprofRecord$HeapDumpRecord$HeapDumpInfoRecord;", "Lshark/HprofRecord$HeapDumpRecord;", "heapId", "", "heapNameStringId", "", "(IJ)V", "getHeapId", "()I", "getHeapNameStringId", "()J", "shark-hprof"}, k=1, mv={1, 4, 1})
public final class HprofRecord$HeapDumpRecord$HeapDumpInfoRecord
  extends HprofRecord.HeapDumpRecord
{
  private final int a;
  private final long b;
  
  public HprofRecord$HeapDumpRecord$HeapDumpInfoRecord(int paramInt, long paramLong)
  {
    super(null);
    this.a = paramInt;
    this.b = paramLong;
  }
  
  public final int a()
  {
    return this.a;
  }
  
  public final long b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.HprofRecord.HeapDumpRecord.HeapDumpInfoRecord
 * JD-Core Version:    0.7.0.1
 */