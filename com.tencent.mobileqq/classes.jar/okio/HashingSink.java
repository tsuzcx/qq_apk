package okio;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.MessageDigest;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lokio/HashingSink;", "Lokio/ForwardingSink;", "sink", "Lokio/Sink;", "algorithm", "", "(Lokio/Sink;Ljava/lang/String;)V", "key", "Lokio/ByteString;", "(Lokio/Sink;Lokio/ByteString;Ljava/lang/String;)V", "hash", "()Lokio/ByteString;", "mac", "Ljavax/crypto/Mac;", "messageDigest", "Ljava/security/MessageDigest;", "-deprecated_hash", "write", "", "source", "Lokio/Buffer;", "byteCount", "", "Companion", "okio"}, k=1, mv={1, 1, 16})
public final class HashingSink
  extends ForwardingSink
{
  public static final HashingSink.Companion Companion = new HashingSink.Companion(null);
  private final Mac mac;
  private final MessageDigest messageDigest;
  
  public HashingSink(@NotNull Sink paramSink, @NotNull String paramString)
  {
    super(paramSink);
    this.messageDigest = MessageDigest.getInstance(paramString);
    this.mac = ((Mac)null);
  }
  
  public HashingSink(@NotNull Sink paramSink, @NotNull ByteString paramByteString, @NotNull String paramString)
  {
    super(paramSink);
    try
    {
      paramSink = Mac.getInstance(paramString);
      paramSink.init((Key)new SecretKeySpec(paramByteString.toByteArray(), paramString));
      this.mac = paramSink;
      this.messageDigest = ((MessageDigest)null);
      return;
    }
    catch (InvalidKeyException paramSink)
    {
      throw ((Throwable)new IllegalArgumentException((Throwable)paramSink));
    }
  }
  
  @JvmStatic
  @NotNull
  public static final HashingSink hmacSha1(@NotNull Sink paramSink, @NotNull ByteString paramByteString)
  {
    return Companion.hmacSha1(paramSink, paramByteString);
  }
  
  @JvmStatic
  @NotNull
  public static final HashingSink hmacSha256(@NotNull Sink paramSink, @NotNull ByteString paramByteString)
  {
    return Companion.hmacSha256(paramSink, paramByteString);
  }
  
  @JvmStatic
  @NotNull
  public static final HashingSink hmacSha512(@NotNull Sink paramSink, @NotNull ByteString paramByteString)
  {
    return Companion.hmacSha512(paramSink, paramByteString);
  }
  
  @JvmStatic
  @NotNull
  public static final HashingSink md5(@NotNull Sink paramSink)
  {
    return Companion.md5(paramSink);
  }
  
  @JvmStatic
  @NotNull
  public static final HashingSink sha1(@NotNull Sink paramSink)
  {
    return Companion.sha1(paramSink);
  }
  
  @JvmStatic
  @NotNull
  public static final HashingSink sha256(@NotNull Sink paramSink)
  {
    return Companion.sha256(paramSink);
  }
  
  @JvmStatic
  @NotNull
  public static final HashingSink sha512(@NotNull Sink paramSink)
  {
    return Companion.sha512(paramSink);
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="hash", imports={}))
  @JvmName(name="-deprecated_hash")
  @NotNull
  public final ByteString -deprecated_hash()
  {
    return hash();
  }
  
  @JvmName(name="hash")
  @NotNull
  public final ByteString hash()
  {
    Object localObject = this.messageDigest;
    if (localObject != null)
    {
      localObject = ((MessageDigest)localObject).digest();
    }
    else
    {
      localObject = this.mac;
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      localObject = ((Mac)localObject).doFinal();
    }
    Intrinsics.checkExpressionValueIsNotNull(localObject, "result");
    return new ByteString((byte[])localObject);
  }
  
  public void write(@NotNull Buffer paramBuffer, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "source");
    -Util.checkOffsetAndCount(paramBuffer.size(), 0L, paramLong);
    Object localObject1 = paramBuffer.head;
    if (localObject1 == null) {
      Intrinsics.throwNpe();
    }
    long l1 = 0L;
    while (l1 < paramLong)
    {
      int i = (int)Math.min(paramLong - l1, ((Segment)localObject1).limit - ((Segment)localObject1).pos);
      Object localObject2 = this.messageDigest;
      if (localObject2 != null)
      {
        ((MessageDigest)localObject2).update(((Segment)localObject1).data, ((Segment)localObject1).pos, i);
      }
      else
      {
        localObject2 = this.mac;
        if (localObject2 == null) {
          Intrinsics.throwNpe();
        }
        ((Mac)localObject2).update(((Segment)localObject1).data, ((Segment)localObject1).pos, i);
      }
      long l2 = l1 + i;
      localObject2 = ((Segment)localObject1).next;
      localObject1 = localObject2;
      l1 = l2;
      if (localObject2 == null)
      {
        Intrinsics.throwNpe();
        localObject1 = localObject2;
        l1 = l2;
      }
    }
    super.write(paramBuffer, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okio.HashingSink
 * JD-Core Version:    0.7.0.1
 */