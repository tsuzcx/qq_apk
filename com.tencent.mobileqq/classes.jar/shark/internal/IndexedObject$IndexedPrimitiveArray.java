package shark.internal;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import shark.PrimitiveType;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/internal/IndexedObject$IndexedPrimitiveArray;", "Lshark/internal/IndexedObject;", "position", "", "primitiveType", "Lshark/PrimitiveType;", "recordSize", "(JLshark/PrimitiveType;J)V", "getPosition", "()J", "getPrimitiveType", "()Lshark/PrimitiveType;", "primitiveTypeOrdinal", "", "getRecordSize", "shark-graph"}, k=1, mv={1, 4, 1})
public final class IndexedObject$IndexedPrimitiveArray
  extends IndexedObject
{
  private final byte a;
  private final long b;
  private final long c;
  
  public IndexedObject$IndexedPrimitiveArray(long paramLong1, @NotNull PrimitiveType paramPrimitiveType, long paramLong2)
  {
    super(null);
    this.b = paramLong1;
    this.c = paramLong2;
    this.a = ((byte)paramPrimitiveType.ordinal());
  }
  
  public long a()
  {
    return this.b;
  }
  
  public long b()
  {
    return this.c;
  }
  
  @NotNull
  public final PrimitiveType c()
  {
    return PrimitiveType.values()[this.a];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.internal.IndexedObject.IndexedPrimitiveArray
 * JD-Core Version:    0.7.0.1
 */