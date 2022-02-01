package shark;

import java.io.File;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/Hprof$Companion;", "", "()V", "open", "Lshark/Hprof;", "hprofFile", "Ljava/io/File;", "shark-hprof"}, k=1, mv={1, 4, 1})
public final class Hprof$Companion
{
  @Deprecated(message="Replaced by HprofStreamingReader.readerFor or HprofRandomAccessReader.openReaderFor")
  @NotNull
  public final Hprof a(@NotNull File paramFile)
  {
    Intrinsics.checkParameterIsNotNull(paramFile, "hprofFile");
    return new Hprof(paramFile, HprofHeader.a.a(paramFile), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.Hprof.Companion
 * JD-Core Version:    0.7.0.1
 */