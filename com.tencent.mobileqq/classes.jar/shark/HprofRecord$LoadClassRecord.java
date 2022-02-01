package shark;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/HprofRecord$LoadClassRecord;", "Lshark/HprofRecord;", "classSerialNumber", "", "id", "", "stackTraceSerialNumber", "classNameStringId", "(IJIJ)V", "getClassNameStringId", "()J", "getClassSerialNumber", "()I", "getId", "getStackTraceSerialNumber", "shark-hprof"}, k=1, mv={1, 4, 1})
public final class HprofRecord$LoadClassRecord
  extends HprofRecord
{
  private final int a;
  private final long b;
  private final int c;
  private final long d;
  
  public HprofRecord$LoadClassRecord(int paramInt1, long paramLong1, int paramInt2, long paramLong2)
  {
    super(null);
    this.a = paramInt1;
    this.b = paramLong1;
    this.c = paramInt2;
    this.d = paramLong2;
  }
  
  public final int a()
  {
    return this.a;
  }
  
  public final long b()
  {
    return this.b;
  }
  
  public final int c()
  {
    return this.c;
  }
  
  public final long d()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.HprofRecord.LoadClassRecord
 * JD-Core Version:    0.7.0.1
 */