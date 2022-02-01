package shark;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/GcRoot$JniGlobal;", "Lshark/GcRoot;", "id", "", "jniGlobalRefId", "(JJ)V", "getId", "()J", "getJniGlobalRefId", "shark-hprof"}, k=1, mv={1, 4, 1})
public final class GcRoot$JniGlobal
  extends GcRoot
{
  private final long a;
  private final long b;
  
  public GcRoot$JniGlobal(long paramLong1, long paramLong2)
  {
    super(null);
    this.a = paramLong1;
    this.b = paramLong2;
  }
  
  public long a()
  {
    return this.a;
  }
  
  public final long b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.GcRoot.JniGlobal
 * JD-Core Version:    0.7.0.1
 */