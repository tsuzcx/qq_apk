package okio;

import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public final class HashingSource
  extends ForwardingSource
{
  private final Mac mac;
  private final MessageDigest messageDigest;
  
  private HashingSource(Source paramSource, String paramString)
  {
    super(paramSource);
    try
    {
      this.messageDigest = MessageDigest.getInstance(paramString);
      this.mac = null;
      return;
    }
    catch (NoSuchAlgorithmException paramSource)
    {
      label19:
      break label19;
    }
    throw new AssertionError();
  }
  
  private HashingSource(Source paramSource, ByteString paramByteString, String paramString)
  {
    super(paramSource);
    try
    {
      this.mac = Mac.getInstance(paramString);
      this.mac.init(new SecretKeySpec(paramByteString.toByteArray(), paramString));
      this.messageDigest = null;
      return;
    }
    catch (InvalidKeyException paramSource)
    {
      throw new IllegalArgumentException(paramSource);
      throw new AssertionError();
    }
    catch (NoSuchAlgorithmException paramSource)
    {
      label48:
      break label48;
    }
  }
  
  public static HashingSource hmacSha1(Source paramSource, ByteString paramByteString)
  {
    return new HashingSource(paramSource, paramByteString, "HmacSHA1");
  }
  
  public static HashingSource hmacSha256(Source paramSource, ByteString paramByteString)
  {
    return new HashingSource(paramSource, paramByteString, "HmacSHA256");
  }
  
  public static HashingSource md5(Source paramSource)
  {
    return new HashingSource(paramSource, "MD5");
  }
  
  public static HashingSource sha1(Source paramSource)
  {
    return new HashingSource(paramSource, "SHA-1");
  }
  
  public static HashingSource sha256(Source paramSource)
  {
    return new HashingSource(paramSource, "SHA-256");
  }
  
  public final ByteString hash()
  {
    Object localObject = this.messageDigest;
    if (localObject != null) {
      localObject = ((MessageDigest)localObject).digest();
    } else {
      localObject = this.mac.doFinal();
    }
    return ByteString.of((byte[])localObject);
  }
  
  public long read(Buffer paramBuffer, long paramLong)
  {
    long l4 = super.read(paramBuffer, paramLong);
    if (l4 != -1L)
    {
      long l3 = paramBuffer.size - l4;
      paramLong = paramBuffer.size;
      Object localObject1 = paramBuffer.head;
      long l1;
      long l2;
      Object localObject2;
      for (;;)
      {
        l1 = l3;
        l2 = paramLong;
        localObject2 = localObject1;
        if (paramLong <= l3) {
          break;
        }
        localObject1 = ((Segment)localObject1).prev;
        paramLong -= ((Segment)localObject1).limit - ((Segment)localObject1).pos;
      }
      while (l2 < paramBuffer.size)
      {
        int i = (int)(((Segment)localObject2).pos + l1 - l2);
        localObject1 = this.messageDigest;
        if (localObject1 != null) {
          ((MessageDigest)localObject1).update(((Segment)localObject2).data, i, ((Segment)localObject2).limit - i);
        } else {
          this.mac.update(((Segment)localObject2).data, i, ((Segment)localObject2).limit - i);
        }
        l1 = ((Segment)localObject2).limit - ((Segment)localObject2).pos + l2;
        localObject2 = ((Segment)localObject2).next;
        l2 = l1;
      }
    }
    return l4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     okio.HashingSource
 * JD-Core Version:    0.7.0.1
 */