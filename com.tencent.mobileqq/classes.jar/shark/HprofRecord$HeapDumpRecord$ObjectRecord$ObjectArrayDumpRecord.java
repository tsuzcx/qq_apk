package shark;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$ObjectArrayDumpRecord;", "Lshark/HprofRecord$HeapDumpRecord$ObjectRecord;", "id", "", "stackTraceSerialNumber", "", "arrayClassId", "elementIds", "", "(JIJ[J)V", "getArrayClassId", "()J", "getElementIds", "()[J", "getId", "getStackTraceSerialNumber", "()I", "shark-hprof"}, k=1, mv={1, 4, 1})
public final class HprofRecord$HeapDumpRecord$ObjectRecord$ObjectArrayDumpRecord
  extends HprofRecord.HeapDumpRecord.ObjectRecord
{
  private final long a;
  private final int b;
  private final long c;
  @NotNull
  private final long[] d;
  
  public HprofRecord$HeapDumpRecord$ObjectRecord$ObjectArrayDumpRecord(long paramLong1, int paramInt, long paramLong2, @NotNull long[] paramArrayOfLong)
  {
    super(null);
    this.a = paramLong1;
    this.b = paramInt;
    this.c = paramLong2;
    this.d = paramArrayOfLong;
  }
  
  public final long a()
  {
    return this.a;
  }
  
  public final int b()
  {
    return this.b;
  }
  
  public final long c()
  {
    return this.c;
  }
  
  @NotNull
  public final long[] d()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.HprofRecord.HeapDumpRecord.ObjectRecord.ObjectArrayDumpRecord
 * JD-Core Version:    0.7.0.1
 */