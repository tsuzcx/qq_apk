package okio;

import java.util.zip.Inflater;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"inflate", "Lokio/InflaterSource;", "Lokio/Source;", "inflater", "Ljava/util/zip/Inflater;", "okio"}, k=2, mv={1, 1, 16})
@JvmName(name="-InflaterSourceExtensions")
public final class -InflaterSourceExtensions
{
  @NotNull
  public static final InflaterSource inflate(@NotNull Source paramSource, @NotNull Inflater paramInflater)
  {
    Intrinsics.checkParameterIsNotNull(paramSource, "$this$inflate");
    Intrinsics.checkParameterIsNotNull(paramInflater, "inflater");
    return new InflaterSource(paramSource, paramInflater);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okio.-InflaterSourceExtensions
 * JD-Core Version:    0.7.0.1
 */