package shark;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import shark.internal.IndexedObject.IndexedPrimitiveArray;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/HeapObject$HeapPrimitiveArray;", "Lshark/HeapObject;", "hprofGraph", "Lshark/HprofHeapGraph;", "indexedObject", "Lshark/internal/IndexedObject$IndexedPrimitiveArray;", "objectId", "", "objectIndex", "", "(Lshark/HprofHeapGraph;Lshark/internal/IndexedObject$IndexedPrimitiveArray;JI)V", "arrayClass", "Lshark/HeapObject$HeapClass;", "getArrayClass", "()Lshark/HeapObject$HeapClass;", "arrayClassName", "", "getArrayClassName", "()Ljava/lang/String;", "graph", "Lshark/HeapGraph;", "getGraph", "()Lshark/HeapGraph;", "getObjectId", "()J", "getObjectIndex", "()I", "primitiveType", "Lshark/PrimitiveType;", "getPrimitiveType", "()Lshark/PrimitiveType;", "recordSize", "getRecordSize", "readByteSize", "readRecord", "Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord;", "toString", "shark-graph"}, k=1, mv={1, 4, 1})
public final class HeapObject$HeapPrimitiveArray
  extends HeapObject
{
  private final HprofHeapGraph b;
  private final IndexedObject.IndexedPrimitiveArray c;
  private final long d;
  private final int e;
  
  public HeapObject$HeapPrimitiveArray(@NotNull HprofHeapGraph paramHprofHeapGraph, @NotNull IndexedObject.IndexedPrimitiveArray paramIndexedPrimitiveArray, long paramLong, int paramInt)
  {
    super(null);
    this.b = paramHprofHeapGraph;
    this.c = paramIndexedPrimitiveArray;
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
  
  public final int h()
  {
    return this.b.b(b(), this.c);
  }
  
  @NotNull
  public final PrimitiveType i()
  {
    return this.c.c();
  }
  
  @NotNull
  public final String j()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str = i().name();
    Locale localLocale = Locale.US;
    Intrinsics.checkExpressionValueIsNotNull(localLocale, "Locale.US");
    if (str != null)
    {
      str = str.toLowerCase(localLocale);
      Intrinsics.checkExpressionValueIsNotNull(str, "(this as java.lang.String).toLowerCase(locale)");
      localStringBuilder.append(str);
      localStringBuilder.append("[]");
      return localStringBuilder.toString();
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
  }
  
  @NotNull
  public HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord k()
  {
    return this.b.a(b(), this.c);
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("primitive array @");
    localStringBuilder.append(b());
    localStringBuilder.append(" of ");
    localStringBuilder.append(j());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.HeapObject.HeapPrimitiveArray
 * JD-Core Version:    0.7.0.1
 */