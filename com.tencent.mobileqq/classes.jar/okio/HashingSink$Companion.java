package okio;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lokio/HashingSink$Companion;", "", "()V", "hmacSha1", "Lokio/HashingSink;", "sink", "Lokio/Sink;", "key", "Lokio/ByteString;", "hmacSha256", "hmacSha512", "md5", "sha1", "sha256", "sha512", "okio"}, k=1, mv={1, 1, 16})
public final class HashingSink$Companion
{
  @JvmStatic
  @NotNull
  public final HashingSink hmacSha1(@NotNull Sink paramSink, @NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramSink, "sink");
    Intrinsics.checkParameterIsNotNull(paramByteString, "key");
    return new HashingSink(paramSink, paramByteString, "HmacSHA1");
  }
  
  @JvmStatic
  @NotNull
  public final HashingSink hmacSha256(@NotNull Sink paramSink, @NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramSink, "sink");
    Intrinsics.checkParameterIsNotNull(paramByteString, "key");
    return new HashingSink(paramSink, paramByteString, "HmacSHA256");
  }
  
  @JvmStatic
  @NotNull
  public final HashingSink hmacSha512(@NotNull Sink paramSink, @NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramSink, "sink");
    Intrinsics.checkParameterIsNotNull(paramByteString, "key");
    return new HashingSink(paramSink, paramByteString, "HmacSHA512");
  }
  
  @JvmStatic
  @NotNull
  public final HashingSink md5(@NotNull Sink paramSink)
  {
    Intrinsics.checkParameterIsNotNull(paramSink, "sink");
    return new HashingSink(paramSink, "MD5");
  }
  
  @JvmStatic
  @NotNull
  public final HashingSink sha1(@NotNull Sink paramSink)
  {
    Intrinsics.checkParameterIsNotNull(paramSink, "sink");
    return new HashingSink(paramSink, "SHA-1");
  }
  
  @JvmStatic
  @NotNull
  public final HashingSink sha256(@NotNull Sink paramSink)
  {
    Intrinsics.checkParameterIsNotNull(paramSink, "sink");
    return new HashingSink(paramSink, "SHA-256");
  }
  
  @JvmStatic
  @NotNull
  public final HashingSink sha512(@NotNull Sink paramSink)
  {
    Intrinsics.checkParameterIsNotNull(paramSink, "sink");
    return new HashingSink(paramSink, "SHA-512");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okio.HashingSink.Companion
 * JD-Core Version:    0.7.0.1
 */