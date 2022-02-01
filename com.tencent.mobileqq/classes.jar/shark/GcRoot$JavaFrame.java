package shark;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/GcRoot$JavaFrame;", "Lshark/GcRoot;", "id", "", "threadSerialNumber", "", "frameNumber", "(JII)V", "getFrameNumber", "()I", "getId", "()J", "getThreadSerialNumber", "shark-hprof"}, k=1, mv={1, 4, 1})
public final class GcRoot$JavaFrame
  extends GcRoot
{
  private final long a;
  private final int b;
  private final int c;
  
  public GcRoot$JavaFrame(long paramLong, int paramInt1, int paramInt2)
  {
    super(null);
    this.a = paramLong;
    this.b = paramInt1;
    this.c = paramInt2;
  }
  
  public long a()
  {
    return this.a;
  }
  
  public final int b()
  {
    return this.b;
  }
  
  public final int c()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.GcRoot.JavaFrame
 * JD-Core Version:    0.7.0.1
 */