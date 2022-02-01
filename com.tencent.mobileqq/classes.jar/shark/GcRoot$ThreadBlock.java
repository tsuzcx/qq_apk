package shark;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/GcRoot$ThreadBlock;", "Lshark/GcRoot;", "id", "", "threadSerialNumber", "", "(JI)V", "getId", "()J", "getThreadSerialNumber", "()I", "shark-hprof"}, k=1, mv={1, 4, 1})
public final class GcRoot$ThreadBlock
  extends GcRoot
{
  private final long a;
  private final int b;
  
  public GcRoot$ThreadBlock(long paramLong, int paramInt)
  {
    super(null);
    this.a = paramLong;
    this.b = paramInt;
  }
  
  public long a()
  {
    return this.a;
  }
  
  public final int b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.GcRoot.ThreadBlock
 * JD-Core Version:    0.7.0.1
 */