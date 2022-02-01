package shark;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/RandomAccessHprofReader$Companion;", "", "()V", "openReaderFor", "Lshark/RandomAccessHprofReader;", "hprofFile", "Ljava/io/File;", "hprofHeader", "Lshark/HprofHeader;", "hprofSourceProvider", "Lshark/RandomAccessSourceProvider;", "shark-hprof"}, k=1, mv={1, 4, 1})
public final class RandomAccessHprofReader$Companion
{
  @NotNull
  public final RandomAccessHprofReader a(@NotNull RandomAccessSourceProvider paramRandomAccessSourceProvider, @NotNull HprofHeader paramHprofHeader)
  {
    Intrinsics.checkParameterIsNotNull(paramRandomAccessSourceProvider, "hprofSourceProvider");
    Intrinsics.checkParameterIsNotNull(paramHprofHeader, "hprofHeader");
    return new RandomAccessHprofReader(paramRandomAccessSourceProvider.b(), paramHprofHeader, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.RandomAccessHprofReader.Companion
 * JD-Core Version:    0.7.0.1
 */