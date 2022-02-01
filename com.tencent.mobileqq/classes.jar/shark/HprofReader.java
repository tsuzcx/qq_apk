package shark;

import kotlin.Deprecated;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Deprecated(message="Replaced by HprofStreamingReader.readerFor or HprofRandomAccessReader.openReaderFor")
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/HprofReader;", "", "hprof", "Lshark/Hprof;", "(Lshark/Hprof;)V", "identifierByteSize", "", "getIdentifierByteSize", "()I", "startPosition", "", "getStartPosition", "()J", "readHprofRecords", "", "recordTypes", "", "Lkotlin/reflect/KClass;", "Lshark/HprofRecord;", "listener", "Lshark/OnHprofRecordListener;", "shark-hprof"}, k=1, mv={1, 4, 1})
public final class HprofReader
{
  private final Hprof a;
  
  public HprofReader(@NotNull Hprof paramHprof)
  {
    this.a = paramHprof;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.HprofReader
 * JD-Core Version:    0.7.0.1
 */