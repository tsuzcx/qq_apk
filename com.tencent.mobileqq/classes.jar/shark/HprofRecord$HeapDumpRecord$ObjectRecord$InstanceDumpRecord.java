package shark;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$InstanceDumpRecord;", "Lshark/HprofRecord$HeapDumpRecord$ObjectRecord;", "id", "", "stackTraceSerialNumber", "", "classId", "fieldValues", "", "(JIJ[B)V", "getClassId", "()J", "getFieldValues", "()[B", "getId", "getStackTraceSerialNumber", "()I", "shark-hprof"}, k=1, mv={1, 4, 1})
public final class HprofRecord$HeapDumpRecord$ObjectRecord$InstanceDumpRecord
  extends HprofRecord.HeapDumpRecord.ObjectRecord
{
  private final long a;
  private final int b;
  private final long c;
  @NotNull
  private final byte[] d;
  
  public HprofRecord$HeapDumpRecord$ObjectRecord$InstanceDumpRecord(long paramLong1, int paramInt, long paramLong2, @NotNull byte[] paramArrayOfByte)
  {
    super(null);
    this.a = paramLong1;
    this.b = paramInt;
    this.c = paramLong2;
    this.d = paramArrayOfByte;
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
  public final byte[] d()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.HprofRecord.HeapDumpRecord.ObjectRecord.InstanceDumpRecord
 * JD-Core Version:    0.7.0.1
 */