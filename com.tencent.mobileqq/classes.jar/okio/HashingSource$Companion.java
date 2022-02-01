package okio;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lokio/HashingSource$Companion;", "", "()V", "hmacSha1", "Lokio/HashingSource;", "source", "Lokio/Source;", "key", "Lokio/ByteString;", "hmacSha256", "hmacSha512", "md5", "sha1", "sha256", "sha512", "okio"}, k=1, mv={1, 1, 16})
public final class HashingSource$Companion
{
  @JvmStatic
  @NotNull
  public final HashingSource hmacSha1(@NotNull Source paramSource, @NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramSource, "source");
    Intrinsics.checkParameterIsNotNull(paramByteString, "key");
    return new HashingSource(paramSource, paramByteString, "HmacSHA1");
  }
  
  @JvmStatic
  @NotNull
  public final HashingSource hmacSha256(@NotNull Source paramSource, @NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramSource, "source");
    Intrinsics.checkParameterIsNotNull(paramByteString, "key");
    return new HashingSource(paramSource, paramByteString, "HmacSHA256");
  }
  
  @JvmStatic
  @NotNull
  public final HashingSource hmacSha512(@NotNull Source paramSource, @NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramSource, "source");
    Intrinsics.checkParameterIsNotNull(paramByteString, "key");
    return new HashingSource(paramSource, paramByteString, "HmacSHA512");
  }
  
  @JvmStatic
  @NotNull
  public final HashingSource md5(@NotNull Source paramSource)
  {
    Intrinsics.checkParameterIsNotNull(paramSource, "source");
    return new HashingSource(paramSource, "MD5");
  }
  
  @JvmStatic
  @NotNull
  public final HashingSource sha1(@NotNull Source paramSource)
  {
    Intrinsics.checkParameterIsNotNull(paramSource, "source");
    return new HashingSource(paramSource, "SHA-1");
  }
  
  @JvmStatic
  @NotNull
  public final HashingSource sha256(@NotNull Source paramSource)
  {
    Intrinsics.checkParameterIsNotNull(paramSource, "source");
    return new HashingSource(paramSource, "SHA-256");
  }
  
  @JvmStatic
  @NotNull
  public final HashingSource sha512(@NotNull Source paramSource)
  {
    Intrinsics.checkParameterIsNotNull(paramSource, "source");
    return new HashingSource(paramSource, "SHA-512");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okio.HashingSource.Companion
 * JD-Core Version:    0.7.0.1
 */