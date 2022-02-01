package shark;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/StreamingHprofReader$Companion;", "", "()V", "readerFor", "Lshark/StreamingHprofReader;", "hprofFile", "Ljava/io/File;", "hprofHeader", "Lshark/HprofHeader;", "hprofSourceProvider", "Lshark/StreamingSourceProvider;", "shark-hprof"}, k=1, mv={1, 4, 1})
public final class StreamingHprofReader$Companion
{
  @NotNull
  public final StreamingHprofReader a(@NotNull StreamingSourceProvider paramStreamingSourceProvider, @NotNull HprofHeader paramHprofHeader)
  {
    Intrinsics.checkParameterIsNotNull(paramStreamingSourceProvider, "hprofSourceProvider");
    Intrinsics.checkParameterIsNotNull(paramHprofHeader, "hprofHeader");
    return new StreamingHprofReader(paramStreamingSourceProvider, paramHprofHeader, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.StreamingHprofReader.Companion
 * JD-Core Version:    0.7.0.1
 */