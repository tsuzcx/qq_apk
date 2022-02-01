package okio;

import java.util.zip.Deflater;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"deflate", "Lokio/DeflaterSink;", "Lokio/Sink;", "deflater", "Ljava/util/zip/Deflater;", "okio"}, k=2, mv={1, 1, 16})
@JvmName(name="-DeflaterSinkExtensions")
public final class -DeflaterSinkExtensions
{
  @NotNull
  public static final DeflaterSink deflate(@NotNull Sink paramSink, @NotNull Deflater paramDeflater)
  {
    Intrinsics.checkParameterIsNotNull(paramSink, "$this$deflate");
    Intrinsics.checkParameterIsNotNull(paramDeflater, "deflater");
    return new DeflaterSink(paramSink, paramDeflater);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okio.-DeflaterSinkExtensions
 * JD-Core Version:    0.7.0.1
 */