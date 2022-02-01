package okio;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"FCOMMENT", "", "FEXTRA", "FHCRC", "FNAME", "SECTION_BODY", "", "SECTION_DONE", "SECTION_HEADER", "SECTION_TRAILER", "getBit", "", "bit", "gzip", "Lokio/GzipSource;", "Lokio/Source;", "okio"}, k=2, mv={1, 1, 16})
@JvmName(name="-GzipSourceExtensions")
public final class -GzipSourceExtensions
{
  private static final int FCOMMENT = 4;
  private static final int FEXTRA = 2;
  private static final int FHCRC = 1;
  private static final int FNAME = 3;
  private static final byte SECTION_BODY = 1;
  private static final byte SECTION_DONE = 3;
  private static final byte SECTION_HEADER = 0;
  private static final byte SECTION_TRAILER = 2;
  
  private static final boolean getBit(int paramInt1, int paramInt2)
  {
    return (paramInt1 >> paramInt2 & 0x1) == 1;
  }
  
  @NotNull
  public static final GzipSource gzip(@NotNull Source paramSource)
  {
    Intrinsics.checkParameterIsNotNull(paramSource, "$this$gzip");
    return new GzipSource(paramSource);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okio.-GzipSourceExtensions
 * JD-Core Version:    0.7.0.1
 */