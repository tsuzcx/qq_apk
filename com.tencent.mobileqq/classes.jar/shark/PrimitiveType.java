package shark;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/PrimitiveType;", "", "hprofType", "", "byteSize", "(Ljava/lang/String;III)V", "getByteSize", "()I", "getHprofType", "BOOLEAN", "CHAR", "FLOAT", "DOUBLE", "BYTE", "SHORT", "INT", "LONG", "Companion", "shark-hprof"}, k=1, mv={1, 4, 1})
public enum PrimitiveType
{
  @NotNull
  public static final PrimitiveType.Companion Companion;
  public static final int REFERENCE_HPROF_TYPE = 2;
  @NotNull
  private static final Map<Integer, Integer> byteSizeByHprofType;
  @NotNull
  private static final Map<Integer, PrimitiveType> primitiveTypeByHprofType;
  private final int byteSize;
  private final int hprofType;
  
  static
  {
    int j = 0;
    Object localObject1 = new PrimitiveType("BOOLEAN", 0, 4, 1);
    BOOLEAN = (PrimitiveType)localObject1;
    Object localObject2 = new PrimitiveType("CHAR", 1, 5, 2);
    CHAR = (PrimitiveType)localObject2;
    PrimitiveType localPrimitiveType1 = new PrimitiveType("FLOAT", 2, 6, 4);
    FLOAT = localPrimitiveType1;
    PrimitiveType localPrimitiveType2 = new PrimitiveType("DOUBLE", 3, 7, 8);
    DOUBLE = localPrimitiveType2;
    PrimitiveType localPrimitiveType3 = new PrimitiveType("BYTE", 4, 8, 1);
    BYTE = localPrimitiveType3;
    PrimitiveType localPrimitiveType4 = new PrimitiveType("SHORT", 5, 9, 2);
    SHORT = localPrimitiveType4;
    PrimitiveType localPrimitiveType5 = new PrimitiveType("INT", 6, 10, 4);
    INT = localPrimitiveType5;
    PrimitiveType localPrimitiveType6 = new PrimitiveType("LONG", 7, 11, 8);
    LONG = localPrimitiveType6;
    $VALUES = new PrimitiveType[] { localObject1, localObject2, localPrimitiveType1, localPrimitiveType2, localPrimitiveType3, localPrimitiveType4, localPrimitiveType5, localPrimitiveType6 };
    Companion = new PrimitiveType.Companion(null);
    localObject1 = values();
    localObject2 = (Collection)new ArrayList(localObject1.length);
    int k = localObject1.length;
    int i = 0;
    while (i < k)
    {
      localPrimitiveType1 = localObject1[i];
      ((Collection)localObject2).add(TuplesKt.to(Integer.valueOf(localPrimitiveType1.hprofType), Integer.valueOf(localPrimitiveType1.byteSize)));
      i += 1;
    }
    byteSizeByHprofType = MapsKt.toMap((Iterable)localObject2);
    localObject1 = values();
    localObject2 = (Collection)new ArrayList(localObject1.length);
    k = localObject1.length;
    i = j;
    while (i < k)
    {
      localPrimitiveType1 = localObject1[i];
      ((Collection)localObject2).add(TuplesKt.to(Integer.valueOf(localPrimitiveType1.hprofType), localPrimitiveType1));
      i += 1;
    }
    primitiveTypeByHprofType = MapsKt.toMap((Iterable)localObject2);
  }
  
  private PrimitiveType(int paramInt1, int paramInt2)
  {
    this.hprofType = paramInt1;
    this.byteSize = paramInt2;
  }
  
  public final int getByteSize()
  {
    return this.byteSize;
  }
  
  public final int getHprofType()
  {
    return this.hprofType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.PrimitiveType
 * JD-Core Version:    0.7.0.1
 */