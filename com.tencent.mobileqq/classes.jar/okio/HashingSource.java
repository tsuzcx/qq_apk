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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lokio/HashingSource;", "Lokio/ForwardingSource;", "source", "Lokio/Source;", "algorithm", "", "(Lokio/Source;Ljava/lang/String;)V", "key", "Lokio/ByteString;", "(Lokio/Source;Lokio/ByteString;Ljava/lang/String;)V", "hash", "()Lokio/ByteString;", "mac", "Ljavax/crypto/Mac;", "messageDigest", "Ljava/security/MessageDigest;", "-deprecated_hash", "read", "", "sink", "Lokio/Buffer;", "byteCount", "Companion", "okio"}, k=1, mv={1, 1, 16})
public final class HashingSource
  extends ForwardingSource
{
  public static final HashingSource.Companion Companion = new HashingSource.Companion(null);
  private final Mac mac;
  private final MessageDigest messageDigest;
  
  public HashingSource(@NotNull Source paramSource, @NotNull String paramString)
  {
    super(paramSource);
    this.messageDigest = MessageDigest.getInstance(paramString);
    this.mac = ((Mac)null);
  }
  
  public HashingSource(@NotNull Source paramSource, @NotNull ByteString paramByteString, @NotNull String paramString)
  {
    super(paramSource);
    try
    {
      paramSource = Mac.getInstance(paramString);
      paramSource.init((Key)new SecretKeySpec(paramByteString.toByteArray(), paramString));
      this.mac = paramSource;
      this.messageDigest = ((MessageDigest)null);
      return;
    }
    catch (InvalidKeyException paramSource)
    {
      throw ((Throwable)new IllegalArgumentException((Throwable)paramSource));
    }
  }
  
  @JvmStatic
  @NotNull
  public static final HashingSource hmacSha1(@NotNull Source paramSource, @NotNull ByteString paramByteString)
  {
    return Companion.hmacSha1(paramSource, paramByteString);
  }
  
  @JvmStatic
  @NotNull
  public static final HashingSource hmacSha256(@NotNull Source paramSource, @NotNull ByteString paramByteString)
  {
    return Companion.hmacSha256(paramSource, paramByteString);
  }
  
  @JvmStatic
  @NotNull
  public static final HashingSource hmacSha512(@NotNull Source paramSource, @NotNull ByteString paramByteString)
  {
    return Companion.hmacSha512(paramSource, paramByteString);
  }
  
  @JvmStatic
  @NotNull
  public static final HashingSource md5(@NotNull Source paramSource)
  {
    return Companion.md5(paramSource);
  }
  
  @JvmStatic
  @NotNull
  public static final HashingSource sha1(@NotNull Source paramSource)
  {
    return Companion.sha1(paramSource);
  }
  
  @JvmStatic
  @NotNull
  public static final HashingSource sha256(@NotNull Source paramSource)
  {
    return Companion.sha256(paramSource);
  }
  
  @JvmStatic
  @NotNull
  public static final HashingSource sha512(@NotNull Source paramSource)
  {
    return Companion.sha512(paramSource);
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
  
  public long read(@NotNull Buffer paramBuffer, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "sink");
    long l4 = super.read(paramBuffer, paramLong);
    if (l4 != -1L)
    {
      long l3 = paramBuffer.size() - l4;
      long l1 = paramBuffer.size();
      Object localObject2 = paramBuffer.head;
      paramLong = l1;
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        Intrinsics.throwNpe();
        localObject1 = localObject2;
      }
      long l2;
      for (paramLong = l1;; paramLong -= ((Segment)localObject1).limit - ((Segment)localObject1).pos)
      {
        l1 = l3;
        l2 = paramLong;
        localObject2 = localObject1;
        if (paramLong <= l3) {
          break;
        }
        localObject1 = ((Segment)localObject1).prev;
        if (localObject1 == null) {
          Intrinsics.throwNpe();
        }
      }
      while (l2 < paramBuffer.size())
      {
        int i = (int)(((Segment)localObject2).pos + l1 - l2);
        localObject1 = this.messageDigest;
        if (localObject1 != null)
        {
          ((MessageDigest)localObject1).update(((Segment)localObject2).data, i, ((Segment)localObject2).limit - i);
        }
        else
        {
          localObject1 = this.mac;
          if (localObject1 == null) {
            Intrinsics.throwNpe();
          }
          ((Mac)localObject1).update(((Segment)localObject2).data, i, ((Segment)localObject2).limit - i);
        }
        l1 = ((Segment)localObject2).limit - ((Segment)localObject2).pos + l2;
        localObject2 = ((Segment)localObject2).next;
        if (localObject2 == null) {
          Intrinsics.throwNpe();
        }
        l2 = l1;
      }
    }
    return l4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okio.HashingSource
 * JD-Core Version:    0.7.0.1
 */