package kotlin.reflect.jvm.internal.impl.load.kotlin.header;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

public enum KotlinClassHeader$Kind
{
  public static final KotlinClassHeader.Kind.Companion Companion;
  private static final Map<Integer, Kind> entryById;
  private final int id;
  
  static
  {
    int i = 0;
    Object localObject1 = new Kind("UNKNOWN", 0, 0);
    UNKNOWN = (Kind)localObject1;
    Object localObject2 = new Kind("CLASS", 1, 1);
    CLASS = (Kind)localObject2;
    Kind localKind1 = new Kind("FILE_FACADE", 2, 2);
    FILE_FACADE = localKind1;
    Kind localKind2 = new Kind("SYNTHETIC_CLASS", 3, 3);
    SYNTHETIC_CLASS = localKind2;
    Kind localKind3 = new Kind("MULTIFILE_CLASS", 4, 4);
    MULTIFILE_CLASS = localKind3;
    Kind localKind4 = new Kind("MULTIFILE_CLASS_PART", 5, 5);
    MULTIFILE_CLASS_PART = localKind4;
    $VALUES = new Kind[] { localObject1, localObject2, localKind1, localKind2, localKind3, localKind4 };
    Companion = new KotlinClassHeader.Kind.Companion(null);
    localObject1 = values();
    localObject2 = (Map)new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(localObject1.length), 16));
    int j = localObject1.length;
    while (i < j)
    {
      localKind1 = localObject1[i];
      ((Map)localObject2).put(Integer.valueOf(localKind1.id), localKind1);
      i += 1;
    }
    entryById = (Map)localObject2;
  }
  
  private KotlinClassHeader$Kind(int paramInt)
  {
    this.id = paramInt;
  }
  
  @JvmStatic
  @NotNull
  public static final Kind getById(int paramInt)
  {
    return Companion.getById(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader.Kind
 * JD-Core Version:    0.7.0.1
 */