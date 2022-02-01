package shark;

import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import shark.internal.HprofInMemoryIndex;
import shark.internal.HprofInMemoryIndex.Companion;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/HprofIndex$Companion;", "", "()V", "defaultIndexedGcRootTags", "Ljava/util/EnumSet;", "Lshark/HprofRecordTag;", "kotlin.jvm.PlatformType", "indexRecordsOf", "Lshark/HprofIndex;", "hprofSourceProvider", "Lshark/DualSourceProvider;", "hprofHeader", "Lshark/HprofHeader;", "proguardMapping", "Lshark/ProguardMapping;", "indexedGcRootTags", "", "shark-graph"}, k=1, mv={1, 4, 1})
public final class HprofIndex$Companion
{
  @NotNull
  public final HprofIndex a(@NotNull DualSourceProvider paramDualSourceProvider, @NotNull HprofHeader paramHprofHeader, @Nullable ProguardMapping paramProguardMapping, @NotNull Set<? extends HprofRecordTag> paramSet)
  {
    Intrinsics.checkParameterIsNotNull(paramDualSourceProvider, "hprofSourceProvider");
    Intrinsics.checkParameterIsNotNull(paramHprofHeader, "hprofHeader");
    Intrinsics.checkParameterIsNotNull(paramSet, "indexedGcRootTags");
    StreamingHprofReader localStreamingHprofReader = StreamingHprofReader.a.a((StreamingSourceProvider)paramDualSourceProvider, paramHprofHeader);
    paramProguardMapping = HprofInMemoryIndex.a.a(localStreamingHprofReader, paramHprofHeader, paramProguardMapping, paramSet);
    return new HprofIndex((RandomAccessSourceProvider)paramDualSourceProvider, paramHprofHeader, paramProguardMapping, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.HprofIndex.Companion
 * JD-Core Version:    0.7.0.1
 */