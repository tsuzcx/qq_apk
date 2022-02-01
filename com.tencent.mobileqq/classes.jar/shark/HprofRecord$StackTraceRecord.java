package shark;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/HprofRecord$StackTraceRecord;", "Lshark/HprofRecord;", "stackTraceSerialNumber", "", "threadSerialNumber", "stackFrameIds", "", "(II[J)V", "getStackFrameIds", "()[J", "getStackTraceSerialNumber", "()I", "getThreadSerialNumber", "shark-hprof"}, k=1, mv={1, 4, 1})
public final class HprofRecord$StackTraceRecord
  extends HprofRecord
{
  private final int a;
  private final int b;
  @NotNull
  private final long[] c;
  
  public HprofRecord$StackTraceRecord(int paramInt1, int paramInt2, @NotNull long[] paramArrayOfLong)
  {
    super(null);
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramArrayOfLong;
  }
  
  public final int a()
  {
    return this.a;
  }
  
  public final int b()
  {
    return this.b;
  }
  
  @NotNull
  public final long[] c()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.HprofRecord.StackTraceRecord
 * JD-Core Version:    0.7.0.1
 */