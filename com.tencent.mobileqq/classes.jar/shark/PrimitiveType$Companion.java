package shark;

import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/PrimitiveType$Companion;", "", "()V", "REFERENCE_HPROF_TYPE", "", "byteSizeByHprofType", "", "getByteSizeByHprofType", "()Ljava/util/Map;", "primitiveTypeByHprofType", "Lshark/PrimitiveType;", "getPrimitiveTypeByHprofType", "shark-hprof"}, k=1, mv={1, 4, 1})
public final class PrimitiveType$Companion
{
  @NotNull
  public final Map<Integer, Integer> a()
  {
    return PrimitiveType.access$getByteSizeByHprofType$cp();
  }
  
  @NotNull
  public final Map<Integer, PrimitiveType> b()
  {
    return PrimitiveType.access$getPrimitiveTypeByHprofType$cp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.PrimitiveType.Companion
 * JD-Core Version:    0.7.0.1
 */