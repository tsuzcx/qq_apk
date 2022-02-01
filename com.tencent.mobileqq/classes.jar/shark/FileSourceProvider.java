package shark;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.BufferedSource;
import okio.Okio;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/FileSourceProvider;", "Lshark/DualSourceProvider;", "file", "Ljava/io/File;", "(Ljava/io/File;)V", "openRandomAccessSource", "Lshark/RandomAccessSource;", "openStreamingSource", "Lokio/BufferedSource;", "shark-hprof"}, k=1, mv={1, 4, 1})
public final class FileSourceProvider
  implements DualSourceProvider
{
  private final File a;
  
  public FileSourceProvider(@NotNull File paramFile)
  {
    this.a = paramFile;
  }
  
  @NotNull
  public BufferedSource a()
  {
    BufferedSource localBufferedSource = Okio.buffer(Okio.source((InputStream)new FileInputStream(this.a)));
    Intrinsics.checkExpressionValueIsNotNull(localBufferedSource, "Okio.buffer(Okio.source(file.inputStream()))");
    return localBufferedSource;
  }
  
  @NotNull
  public RandomAccessSource b()
  {
    return (RandomAccessSource)new FileSourceProvider.openRandomAccessSource.1(new FileInputStream(this.a).getChannel());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.FileSourceProvider
 * JD-Core Version:    0.7.0.1
 */