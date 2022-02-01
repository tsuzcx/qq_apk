package shark;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord$IntArrayDump;", "Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord;", "id", "", "stackTraceSerialNumber", "", "array", "", "(JI[I)V", "getArray", "()[I", "getId", "()J", "size", "getSize", "()I", "getStackTraceSerialNumber", "shark-hprof"}, k=1, mv={1, 4, 1})
public final class HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord$IntArrayDump
  extends HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord
{
  private final long a;
  private final int b;
  @NotNull
  private final int[] c;
  
  public HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord$IntArrayDump(long paramLong, int paramInt, @NotNull int[] paramArrayOfInt)
  {
    super(null);
    this.a = paramLong;
    this.b = paramInt;
    this.c = paramArrayOfInt;
  }
  
  public long a()
  {
    return this.a;
  }
  
  public int b()
  {
    return this.b;
  }
  
  @NotNull
  public final int[] c()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.IntArrayDump
 * JD-Core Version:    0.7.0.1
 */