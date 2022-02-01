package shark;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/HprofRecord$StackFrameRecord;", "Lshark/HprofRecord;", "id", "", "methodNameStringId", "methodSignatureStringId", "sourceFileNameStringId", "classSerialNumber", "", "lineNumber", "(JJJJII)V", "getClassSerialNumber", "()I", "getId", "()J", "getLineNumber", "getMethodNameStringId", "getMethodSignatureStringId", "getSourceFileNameStringId", "shark-hprof"}, k=1, mv={1, 4, 1})
public final class HprofRecord$StackFrameRecord
  extends HprofRecord
{
  private final long a;
  private final long b;
  private final long c;
  private final long d;
  private final int e;
  private final int f;
  
  public HprofRecord$StackFrameRecord(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt1, int paramInt2)
  {
    super(null);
    this.a = paramLong1;
    this.b = paramLong2;
    this.c = paramLong3;
    this.d = paramLong4;
    this.e = paramInt1;
    this.f = paramInt2;
  }
  
  public final long a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.HprofRecord.StackFrameRecord
 * JD-Core Version:    0.7.0.1
 */