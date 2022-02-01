package shark;

import java.io.Closeable;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Deprecated(message="Replaced by HprofStreamingReader.readerFor or HprofRandomAccessReader.openReaderFor")
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/Hprof;", "Ljava/io/Closeable;", "file", "Ljava/io/File;", "header", "Lshark/HprofHeader;", "(Ljava/io/File;Lshark/HprofHeader;)V", "closeables", "", "getFile", "()Ljava/io/File;", "fileLength", "", "getFileLength", "()J", "getHeader", "()Lshark/HprofHeader;", "heapDumpTimestamp", "getHeapDumpTimestamp", "hprofVersion", "Lshark/Hprof$HprofVersion;", "getHprofVersion", "()Lshark/Hprof$HprofVersion;", "reader", "Lshark/HprofReader;", "getReader", "()Lshark/HprofReader;", "attachClosable", "", "closeable", "close", "Companion", "HprofVersion", "shark-hprof"}, k=1, mv={1, 4, 1})
public final class Hprof
  implements Closeable
{
  @NotNull
  public static final Hprof.Companion a = new Hprof.Companion(null);
  @NotNull
  private final HprofReader b;
  private final List<Closeable> c;
  @NotNull
  private final File d;
  @NotNull
  private final HprofHeader e;
  
  private Hprof(File paramFile, HprofHeader paramHprofHeader)
  {
    this.d = paramFile;
    this.e = paramHprofHeader;
    this.b = new HprofReader(this);
    this.c = ((List)new ArrayList());
  }
  
  @NotNull
  public final File a()
  {
    return this.d;
  }
  
  public final void a(@NotNull Closeable paramCloseable)
  {
    Intrinsics.checkParameterIsNotNull(paramCloseable, "closeable");
    ((Collection)this.c).add(paramCloseable);
  }
  
  @NotNull
  public final HprofHeader b()
  {
    return this.e;
  }
  
  public void close()
  {
    Iterator localIterator = ((Iterable)this.c).iterator();
    while (localIterator.hasNext()) {
      ((Closeable)localIterator.next()).close();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.Hprof
 * JD-Core Version:    0.7.0.1
 */