package shark;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import shark.internal.IndexedObject.IndexedObjectArray;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/HeapObject$HeapObjectArray;", "Lshark/HeapObject;", "hprofGraph", "Lshark/HprofHeapGraph;", "indexedObject", "Lshark/internal/IndexedObject$IndexedObjectArray;", "objectId", "", "objectIndex", "", "(Lshark/HprofHeapGraph;Lshark/internal/IndexedObject$IndexedObjectArray;JI)V", "arrayClass", "Lshark/HeapObject$HeapClass;", "getArrayClass", "()Lshark/HeapObject$HeapClass;", "arrayClassName", "", "getArrayClassName", "()Ljava/lang/String;", "arrayClassSimpleName", "getArrayClassSimpleName", "graph", "Lshark/HeapGraph;", "getGraph", "()Lshark/HeapGraph;", "getIndexedObject$shark_graph", "()Lshark/internal/IndexedObject$IndexedObjectArray;", "getObjectId", "()J", "getObjectIndex", "()I", "recordSize", "getRecordSize", "readByteSize", "readElements", "Lkotlin/sequences/Sequence;", "Lshark/HeapValue;", "readRecord", "Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$ObjectArrayDumpRecord;", "toString", "shark-graph"}, k=1, mv={1, 4, 1})
public final class HeapObject$HeapObjectArray
  extends HeapObject
{
  private final HprofHeapGraph b;
  @NotNull
  private final IndexedObject.IndexedObjectArray c;
  private final long d;
  private final int e;
  
  public HeapObject$HeapObjectArray(@NotNull HprofHeapGraph paramHprofHeapGraph, @NotNull IndexedObject.IndexedObjectArray paramIndexedObjectArray, long paramLong, int paramInt)
  {
    super(null);
    this.b = paramHprofHeapGraph;
    this.c = paramIndexedObjectArray;
    this.d = paramLong;
    this.e = paramInt;
  }
  
  @NotNull
  public HeapGraph a()
  {
    return (HeapGraph)this.b;
  }
  
  public long b()
  {
    return this.d;
  }
  
  public int d()
  {
    return (int)this.c.b();
  }
  
  @NotNull
  public final String h()
  {
    return this.b.d(this.c.c());
  }
  
  public final int i()
  {
    return this.b.b(b(), this.c);
  }
  
  @NotNull
  public HprofRecord.HeapDumpRecord.ObjectRecord.ObjectArrayDumpRecord j()
  {
    return this.b.a(b(), this.c);
  }
  
  @NotNull
  public final IndexedObject.IndexedObjectArray k()
  {
    return this.c;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("object array @");
    localStringBuilder.append(b());
    localStringBuilder.append(" of ");
    localStringBuilder.append(h());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.HeapObject.HeapObjectArray
 * JD-Core Version:    0.7.0.1
 */