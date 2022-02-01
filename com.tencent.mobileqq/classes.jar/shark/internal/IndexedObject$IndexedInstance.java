package shark.internal;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/internal/IndexedObject$IndexedInstance;", "Lshark/internal/IndexedObject;", "position", "", "classId", "recordSize", "(JJJ)V", "getClassId", "()J", "getPosition", "getRecordSize", "shark-graph"}, k=1, mv={1, 4, 1})
public final class IndexedObject$IndexedInstance
  extends IndexedObject
{
  private final long a;
  private final long b;
  private final long c;
  
  public IndexedObject$IndexedInstance(long paramLong1, long paramLong2, long paramLong3)
  {
    super(null);
    this.a = paramLong1;
    this.b = paramLong2;
    this.c = paramLong3;
  }
  
  public long a()
  {
    return this.a;
  }
  
  public long b()
  {
    return this.c;
  }
  
  public final long c()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.internal.IndexedObject.IndexedInstance
 * JD-Core Version:    0.7.0.1
 */