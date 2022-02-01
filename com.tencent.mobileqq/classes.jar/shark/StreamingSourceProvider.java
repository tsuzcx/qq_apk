package shark;

import kotlin.Metadata;
import okio.BufferedSource;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/StreamingSourceProvider;", "", "openStreamingSource", "Lokio/BufferedSource;", "shark-hprof"}, k=1, mv={1, 4, 1})
public abstract interface StreamingSourceProvider
{
  @NotNull
  public abstract BufferedSource a();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.StreamingSourceProvider
 * JD-Core Version:    0.7.0.1
 */