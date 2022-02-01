package okio;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"gzip", "Lokio/GzipSink;", "Lokio/Sink;", "okio"}, k=2, mv={1, 1, 16})
@JvmName(name="-GzipSinkExtensions")
public final class -GzipSinkExtensions
{
  @NotNull
  public static final GzipSink gzip(@NotNull Sink paramSink)
  {
    Intrinsics.checkParameterIsNotNull(paramSink, "$this$gzip");
    return new GzipSink(paramSink);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okio.-GzipSinkExtensions
 * JD-Core Version:    0.7.0.1
 */