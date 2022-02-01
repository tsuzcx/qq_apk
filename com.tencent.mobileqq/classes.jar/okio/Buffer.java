package okio;

import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.MessageDigest;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okio.internal.BufferKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lokio/Buffer;", "Lokio/BufferedSource;", "Lokio/BufferedSink;", "", "Ljava/nio/channels/ByteChannel;", "()V", "buffer", "getBuffer", "()Lokio/Buffer;", "head", "Lokio/Segment;", "<set-?>", "", "size", "()J", "setSize$okio", "(J)V", "clear", "", "clone", "close", "completeSegmentByteCount", "copy", "copyTo", "out", "Ljava/io/OutputStream;", "offset", "byteCount", "digest", "Lokio/ByteString;", "algorithm", "", "emit", "emitCompleteSegments", "equals", "", "other", "", "exhausted", "flush", "get", "", "pos", "getByte", "index", "-deprecated_getByte", "hashCode", "", "hmac", "key", "hmacSha1", "hmacSha256", "hmacSha512", "indexOf", "b", "fromIndex", "toIndex", "bytes", "indexOfElement", "targetBytes", "inputStream", "Ljava/io/InputStream;", "isOpen", "md5", "outputStream", "peek", "rangeEquals", "bytesOffset", "read", "sink", "Ljava/nio/ByteBuffer;", "", "readAll", "Lokio/Sink;", "readAndWriteUnsafe", "Lokio/Buffer$UnsafeCursor;", "unsafeCursor", "readByte", "readByteArray", "readByteString", "readDecimalLong", "readFrom", "input", "forever", "readFully", "readHexadecimalUnsignedLong", "readInt", "readIntLe", "readLong", "readLongLe", "readShort", "", "readShortLe", "readString", "charset", "Ljava/nio/charset/Charset;", "readUnsafe", "readUtf8", "readUtf8CodePoint", "readUtf8Line", "readUtf8LineStrict", "limit", "request", "require", "select", "options", "Lokio/Options;", "sha1", "sha256", "sha512", "-deprecated_size", "skip", "snapshot", "timeout", "Lokio/Timeout;", "toString", "writableSegment", "minimumCapacity", "writableSegment$okio", "write", "source", "byteString", "Lokio/Source;", "writeAll", "writeByte", "writeDecimalLong", "v", "writeHexadecimalUnsignedLong", "writeInt", "i", "writeIntLe", "writeLong", "writeLongLe", "writeShort", "s", "writeShortLe", "writeString", "string", "beginIndex", "endIndex", "writeTo", "writeUtf8", "writeUtf8CodePoint", "codePoint", "UnsafeCursor", "okio"}, k=1, mv={1, 1, 16})
public final class Buffer
  implements Cloneable, ByteChannel, BufferedSink, BufferedSource
{
  @JvmField
  @Nullable
  public Segment head;
  private long size;
  
  private final ByteString digest(String paramString)
  {
    MessageDigest localMessageDigest = MessageDigest.getInstance(paramString);
    Segment localSegment2 = this.head;
    if (localSegment2 != null)
    {
      localMessageDigest.update(localSegment2.data, localSegment2.pos, localSegment2.limit - localSegment2.pos);
      Segment localSegment1 = localSegment2.next;
      paramString = localSegment1;
      if (localSegment1 == null)
      {
        Intrinsics.throwNpe();
        paramString = localSegment1;
      }
      while (paramString != localSegment2)
      {
        localMessageDigest.update(paramString.data, paramString.pos, paramString.limit - paramString.pos);
        localSegment1 = paramString.next;
        paramString = localSegment1;
        if (localSegment1 == null)
        {
          Intrinsics.throwNpe();
          paramString = localSegment1;
        }
      }
    }
    paramString = localMessageDigest.digest();
    Intrinsics.checkExpressionValueIsNotNull(paramString, "messageDigest.digest()");
    return new ByteString(paramString);
  }
  
  private final ByteString hmac(String paramString, ByteString paramByteString)
  {
    try
    {
      Mac localMac = Mac.getInstance(paramString);
      localMac.init((Key)new SecretKeySpec(paramByteString.internalArray$okio(), paramString));
      Segment localSegment = this.head;
      if (localSegment != null)
      {
        localMac.update(localSegment.data, localSegment.pos, localSegment.limit - localSegment.pos);
        paramByteString = localSegment.next;
        paramString = paramByteString;
        if (paramByteString == null)
        {
          Intrinsics.throwNpe();
          paramString = paramByteString;
        }
        while (paramString != localSegment)
        {
          localMac.update(paramString.data, paramString.pos, paramString.limit - paramString.pos);
          paramByteString = paramString.next;
          paramString = paramByteString;
          if (paramByteString == null)
          {
            Intrinsics.throwNpe();
            paramString = paramByteString;
          }
        }
      }
      paramString = localMac.doFinal();
      Intrinsics.checkExpressionValueIsNotNull(paramString, "mac.doFinal()");
      paramString = new ByteString(paramString);
      return paramString;
    }
    catch (InvalidKeyException paramString)
    {
      paramString = (Throwable)new IllegalArgumentException((Throwable)paramString);
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  private final void readFrom(InputStream paramInputStream, long paramLong, boolean paramBoolean)
  {
    for (;;)
    {
      if ((paramLong <= 0L) && (!paramBoolean)) {
        return;
      }
      Segment localSegment = writableSegment$okio(1);
      int i = (int)Math.min(paramLong, 8192 - localSegment.limit);
      i = paramInputStream.read(localSegment.data, localSegment.limit, i);
      if (i == -1)
      {
        if (localSegment.pos == localSegment.limit)
        {
          this.head = localSegment.pop();
          SegmentPool.INSTANCE.recycle(localSegment);
        }
        if (paramBoolean) {
          return;
        }
        throw ((Throwable)new EOFException());
      }
      localSegment.limit += i;
      long l1 = this.size;
      long l2 = i;
      this.size = (l1 + l2);
      paramLong -= l2;
    }
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to operator function", replaceWith=@ReplaceWith(expression="this[index]", imports={}))
  @JvmName(name="-deprecated_getByte")
  public final byte -deprecated_getByte(long paramLong)
  {
    return getByte(paramLong);
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="size", imports={}))
  @JvmName(name="-deprecated_size")
  public final long -deprecated_size()
  {
    return this.size;
  }
  
  @NotNull
  public Buffer buffer()
  {
    return this;
  }
  
  public final void clear()
  {
    skip(size());
  }
  
  @NotNull
  public Buffer clone()
  {
    return copy();
  }
  
  public void close() {}
  
  public final long completeSegmentByteCount()
  {
    long l2 = size();
    if (l2 == 0L) {
      return 0L;
    }
    Segment localSegment = this.head;
    if (localSegment == null) {
      Intrinsics.throwNpe();
    }
    localSegment = localSegment.prev;
    if (localSegment == null) {
      Intrinsics.throwNpe();
    }
    long l1 = l2;
    if (localSegment.limit < 8192)
    {
      l1 = l2;
      if (localSegment.owner) {
        l1 = l2 - (localSegment.limit - localSegment.pos);
      }
    }
    return l1;
  }
  
  @NotNull
  public final Buffer copy()
  {
    Buffer localBuffer = new Buffer();
    if (size() == 0L) {
      return localBuffer;
    }
    Segment localSegment2 = this.head;
    if (localSegment2 == null) {
      Intrinsics.throwNpe();
    }
    Segment localSegment3 = localSegment2.sharedCopy();
    localBuffer.head = localSegment3;
    localSegment3.prev = localBuffer.head;
    localSegment3.next = localSegment3.prev;
    for (Segment localSegment1 = localSegment2.next; localSegment1 != localSegment2; localSegment1 = localSegment1.next)
    {
      Segment localSegment4 = localSegment3.prev;
      if (localSegment4 == null) {
        Intrinsics.throwNpe();
      }
      if (localSegment1 == null) {
        Intrinsics.throwNpe();
      }
      localSegment4.push(localSegment1.sharedCopy());
    }
    localBuffer.setSize$okio(size());
    return localBuffer;
  }
  
  @JvmOverloads
  @NotNull
  public final Buffer copyTo(@NotNull OutputStream paramOutputStream)
  {
    return copyTo$default(this, paramOutputStream, 0L, 0L, 6, null);
  }
  
  @JvmOverloads
  @NotNull
  public final Buffer copyTo(@NotNull OutputStream paramOutputStream, long paramLong)
  {
    return copyTo$default(this, paramOutputStream, paramLong, 0L, 4, null);
  }
  
  @JvmOverloads
  @NotNull
  public final Buffer copyTo(@NotNull OutputStream paramOutputStream, long paramLong1, long paramLong2)
  {
    Intrinsics.checkParameterIsNotNull(paramOutputStream, "out");
    -Util.checkOffsetAndCount(this.size, paramLong1, paramLong2);
    if (paramLong2 == 0L) {
      return this;
    }
    Segment localSegment2;
    long l1;
    long l2;
    for (Segment localSegment1 = this.head;; localSegment1 = localSegment1.next)
    {
      if (localSegment1 == null) {
        Intrinsics.throwNpe();
      }
      localSegment2 = localSegment1;
      l1 = paramLong1;
      l2 = paramLong2;
      if (paramLong1 < localSegment1.limit - localSegment1.pos) {
        break;
      }
      paramLong1 -= localSegment1.limit - localSegment1.pos;
    }
    while (l2 > 0L)
    {
      if (localSegment2 == null) {
        Intrinsics.throwNpe();
      }
      int i = (int)(localSegment2.pos + l1);
      int j = (int)Math.min(localSegment2.limit - i, l2);
      paramOutputStream.write(localSegment2.data, i, j);
      l2 -= j;
      localSegment2 = localSegment2.next;
      l1 = 0L;
    }
    return this;
  }
  
  @NotNull
  public final Buffer copyTo(@NotNull Buffer paramBuffer, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "out");
    return copyTo(paramBuffer, paramLong, this.size - paramLong);
  }
  
  @NotNull
  public final Buffer copyTo(@NotNull Buffer paramBuffer, long paramLong1, long paramLong2)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "out");
    -Util.checkOffsetAndCount(size(), paramLong1, paramLong2);
    if (paramLong2 == 0L) {
      return this;
    }
    paramBuffer.setSize$okio(paramBuffer.size() + paramLong2);
    Segment localSegment2;
    long l1;
    long l2;
    for (Segment localSegment1 = this.head;; localSegment1 = localSegment1.next)
    {
      if (localSegment1 == null) {
        Intrinsics.throwNpe();
      }
      localSegment2 = localSegment1;
      l1 = paramLong1;
      l2 = paramLong2;
      if (paramLong1 < localSegment1.limit - localSegment1.pos) {
        break;
      }
      paramLong1 -= localSegment1.limit - localSegment1.pos;
    }
    while (l2 > 0L)
    {
      if (localSegment2 == null) {
        Intrinsics.throwNpe();
      }
      localSegment1 = localSegment2.sharedCopy();
      localSegment1.pos += (int)l1;
      localSegment1.limit = Math.min(localSegment1.pos + (int)l2, localSegment1.limit);
      Segment localSegment3 = paramBuffer.head;
      if (localSegment3 == null)
      {
        localSegment1.prev = localSegment1;
        localSegment1.next = localSegment1.prev;
        paramBuffer.head = localSegment1.next;
      }
      else
      {
        if (localSegment3 == null) {
          Intrinsics.throwNpe();
        }
        localSegment3 = localSegment3.prev;
        if (localSegment3 == null) {
          Intrinsics.throwNpe();
        }
        localSegment3.push(localSegment1);
      }
      l2 -= localSegment1.limit - localSegment1.pos;
      localSegment2 = localSegment2.next;
      l1 = 0L;
    }
    return this;
  }
  
  @NotNull
  public Buffer emit()
  {
    return this;
  }
  
  @NotNull
  public Buffer emitCompleteSegments()
  {
    return this;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this == paramObject) {}
    for (;;)
    {
      return true;
      if (!(paramObject instanceof Buffer)) {
        return false;
      }
      long l1 = size();
      paramObject = (Buffer)paramObject;
      if (l1 != paramObject.size()) {
        return false;
      }
      if (size() != 0L)
      {
        Object localObject2 = this.head;
        if (localObject2 == null) {
          Intrinsics.throwNpe();
        }
        paramObject = paramObject.head;
        if (paramObject == null) {
          Intrinsics.throwNpe();
        }
        int j = ((Segment)localObject2).pos;
        int i = paramObject.pos;
        l1 = 0L;
        while (l1 < size())
        {
          long l3 = Math.min(((Segment)localObject2).limit - j, paramObject.limit - i);
          long l2 = 0L;
          int k = j;
          while (l2 < l3)
          {
            if (localObject2.data[k] != paramObject.data[i]) {
              return false;
            }
            l2 += 1L;
            k += 1;
            i += 1;
          }
          Object localObject1 = localObject2;
          j = k;
          if (k == ((Segment)localObject2).limit)
          {
            localObject1 = ((Segment)localObject2).next;
            if (localObject1 == null) {
              Intrinsics.throwNpe();
            }
            j = ((Segment)localObject1).pos;
          }
          Object localObject3 = paramObject;
          k = i;
          if (i == paramObject.limit)
          {
            localObject3 = paramObject.next;
            if (localObject3 == null) {
              Intrinsics.throwNpe();
            }
            k = ((Segment)localObject3).pos;
          }
          l1 += l3;
          localObject2 = localObject1;
          paramObject = localObject3;
          i = k;
        }
      }
    }
  }
  
  public boolean exhausted()
  {
    return this.size == 0L;
  }
  
  public void flush() {}
  
  @NotNull
  public Buffer getBuffer()
  {
    return this;
  }
  
  @JvmName(name="getByte")
  public final byte getByte(long paramLong)
  {
    -Util.checkOffsetAndCount(size(), paramLong, 1L);
    Segment localSegment = this.head;
    if (localSegment != null)
    {
      if (size() - paramLong < paramLong)
      {
        for (l1 = size(); l1 > paramLong; l1 -= localSegment.limit - localSegment.pos)
        {
          localSegment = localSegment.prev;
          if (localSegment == null) {
            Intrinsics.throwNpe();
          }
        }
        if (localSegment == null) {
          Intrinsics.throwNpe();
        }
        return localSegment.data[((int)(localSegment.pos + paramLong - l1))];
      }
      long l2;
      for (long l1 = 0L;; l1 = l2)
      {
        l2 = localSegment.limit - localSegment.pos + l1;
        if (l2 > paramLong)
        {
          if (localSegment == null) {
            Intrinsics.throwNpe();
          }
          return localSegment.data[((int)(localSegment.pos + paramLong - l1))];
        }
        localSegment = localSegment.next;
        if (localSegment == null) {
          Intrinsics.throwNpe();
        }
      }
    }
    localSegment = (Segment)null;
    Intrinsics.throwNpe();
    return localSegment.data[((int)(localSegment.pos + paramLong + 1L))];
  }
  
  public int hashCode()
  {
    Object localObject = this.head;
    if (localObject != null)
    {
      int i = 1;
      int j;
      Segment localSegment;
      do
      {
        int k = ((Segment)localObject).pos;
        int m = ((Segment)localObject).limit;
        j = i;
        while (k < m)
        {
          j = j * 31 + localObject.data[k];
          k += 1;
        }
        localSegment = ((Segment)localObject).next;
        if (localSegment == null) {
          Intrinsics.throwNpe();
        }
        localObject = localSegment;
        i = j;
      } while (localSegment != this.head);
      return j;
    }
    return 0;
  }
  
  @NotNull
  public final ByteString hmacSha1(@NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "key");
    return hmac("HmacSHA1", paramByteString);
  }
  
  @NotNull
  public final ByteString hmacSha256(@NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "key");
    return hmac("HmacSHA256", paramByteString);
  }
  
  @NotNull
  public final ByteString hmacSha512(@NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "key");
    return hmac("HmacSHA512", paramByteString);
  }
  
  public long indexOf(byte paramByte)
  {
    return indexOf(paramByte, 0L, 9223372036854775807L);
  }
  
  public long indexOf(byte paramByte, long paramLong)
  {
    return indexOf(paramByte, paramLong, 9223372036854775807L);
  }
  
  public long indexOf(byte paramByte, long paramLong1, long paramLong2)
  {
    long l2 = 0L;
    int i;
    if ((0L <= paramLong1) && (paramLong2 >= paramLong1)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      long l1 = paramLong2;
      if (paramLong2 > size()) {
        l1 = size();
      }
      if (paramLong1 == l1) {
        return -1L;
      }
      Object localObject2 = this.head;
      if (localObject2 != null)
      {
        paramLong2 = l2;
        localObject1 = localObject2;
        int j;
        if (size() - paramLong1 < paramLong1)
        {
          paramLong2 = size();
          localObject1 = localObject2;
          while (paramLong2 > paramLong1)
          {
            localObject1 = ((Segment)localObject1).prev;
            if (localObject1 == null) {
              Intrinsics.throwNpe();
            }
            paramLong2 -= ((Segment)localObject1).limit - ((Segment)localObject1).pos;
          }
          if (localObject1 != null) {
            while (paramLong2 < l1)
            {
              localObject2 = ((Segment)localObject1).data;
              j = (int)Math.min(((Segment)localObject1).limit, ((Segment)localObject1).pos + l1 - paramLong2);
              i = (int)(((Segment)localObject1).pos + paramLong1 - paramLong2);
              while (i < j)
              {
                if (localObject2[i] == paramByte) {
                  return i - ((Segment)localObject1).pos + paramLong2;
                }
                i += 1;
              }
              paramLong1 = ((Segment)localObject1).limit - ((Segment)localObject1).pos + paramLong2;
              localObject1 = ((Segment)localObject1).next;
              if (localObject1 == null) {
                Intrinsics.throwNpe();
              }
              paramLong2 = paramLong1;
            }
          }
        }
        else
        {
          for (;;)
          {
            l2 = ((Segment)localObject1).limit - ((Segment)localObject1).pos + paramLong2;
            if (l2 > paramLong1)
            {
              if (localObject1 == null) {
                break label454;
              }
              for (;;)
              {
                if (paramLong2 >= l1) {
                  break label454;
                }
                localObject2 = ((Segment)localObject1).data;
                j = (int)Math.min(((Segment)localObject1).limit, ((Segment)localObject1).pos + l1 - paramLong2);
                i = (int)(((Segment)localObject1).pos + paramLong1 - paramLong2);
                for (;;)
                {
                  if (i >= j) {
                    break label389;
                  }
                  if (localObject2[i] == paramByte) {
                    break;
                  }
                  i += 1;
                }
                label389:
                paramLong1 = ((Segment)localObject1).limit - ((Segment)localObject1).pos + paramLong2;
                localObject1 = ((Segment)localObject1).next;
                if (localObject1 == null) {
                  Intrinsics.throwNpe();
                }
                paramLong2 = paramLong1;
              }
            }
            localObject1 = ((Segment)localObject1).next;
            if (localObject1 == null) {
              Intrinsics.throwNpe();
            }
            paramLong2 = l2;
          }
        }
      }
      else
      {
        localObject1 = (Segment)null;
      }
      label454:
      return -1L;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("size=");
    ((StringBuilder)localObject1).append(size());
    ((StringBuilder)localObject1).append(" fromIndex=");
    ((StringBuilder)localObject1).append(paramLong1);
    ((StringBuilder)localObject1).append(" toIndex=");
    ((StringBuilder)localObject1).append(paramLong2);
    localObject1 = (Throwable)new IllegalArgumentException(((StringBuilder)localObject1).toString().toString());
    for (;;)
    {
      throw ((Throwable)localObject1);
    }
  }
  
  public long indexOf(@NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "bytes");
    return indexOf(paramByteString, 0L);
  }
  
  public long indexOf(@NotNull ByteString paramByteString, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "bytes");
    int i;
    if (paramByteString.size() > 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      long l1 = 0L;
      if (paramLong >= 0L) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        Object localObject2 = this.head;
        if (localObject2 != null)
        {
          Object localObject1 = localObject2;
          int j;
          int k;
          long l2;
          long l3;
          int m;
          if (size() - paramLong < paramLong)
          {
            l1 = size();
            localObject1 = localObject2;
            while (l1 > paramLong)
            {
              localObject1 = ((Segment)localObject1).prev;
              if (localObject1 == null) {
                Intrinsics.throwNpe();
              }
              l1 -= ((Segment)localObject1).limit - ((Segment)localObject1).pos;
            }
            if (localObject1 != null)
            {
              localObject2 = paramByteString.internalArray$okio();
              j = localObject2[0];
              k = paramByteString.size();
              l2 = size() - k + 1L;
              while (l1 < l2)
              {
                paramByteString = ((Segment)localObject1).data;
                i = ((Segment)localObject1).limit;
                l3 = ((Segment)localObject1).pos;
                m = (int)Math.min(i, l3 + l2 - l1);
                i = (int)(((Segment)localObject1).pos + paramLong - l1);
                while (i < m)
                {
                  if ((paramByteString[i] == j) && (BufferKt.rangeEquals((Segment)localObject1, i + 1, (byte[])localObject2, 1, k)))
                  {
                    paramLong = i - ((Segment)localObject1).pos + l1;
                    return paramLong;
                  }
                  i += 1;
                }
                paramLong = l1 + (((Segment)localObject1).limit - ((Segment)localObject1).pos);
                localObject1 = ((Segment)localObject1).next;
                if (localObject1 == null) {
                  Intrinsics.throwNpe();
                }
                l1 = paramLong;
              }
            }
          }
          else
          {
            for (;;)
            {
              l2 = ((Segment)localObject1).limit - ((Segment)localObject1).pos + l1;
              if (l2 > paramLong)
              {
                if (localObject1 == null) {
                  break label559;
                }
                localObject2 = paramByteString.internalArray$okio();
                j = localObject2[0];
                k = paramByteString.size();
                l2 = size() - k + 1L;
                for (;;)
                {
                  if (l1 >= l2) {
                    break label559;
                  }
                  paramByteString = ((Segment)localObject1).data;
                  i = ((Segment)localObject1).limit;
                  l3 = ((Segment)localObject1).pos;
                  m = (int)Math.min(i, l3 + l2 - l1);
                  i = (int)(((Segment)localObject1).pos + paramLong - l1);
                  for (;;)
                  {
                    if (i >= m) {
                      break label495;
                    }
                    if ((paramByteString[i] == j) && (BufferKt.rangeEquals((Segment)localObject1, i + 1, (byte[])localObject2, 1, k)))
                    {
                      paramLong = i - ((Segment)localObject1).pos + l1;
                      break;
                    }
                    i += 1;
                  }
                  label495:
                  paramLong = ((Segment)localObject1).limit - ((Segment)localObject1).pos + l1;
                  localObject1 = ((Segment)localObject1).next;
                  if (localObject1 == null) {
                    Intrinsics.throwNpe();
                  }
                  l1 = paramLong;
                }
              }
              localObject1 = ((Segment)localObject1).next;
              if (localObject1 == null) {
                Intrinsics.throwNpe();
              }
              l1 = l2;
            }
          }
        }
        else
        {
          paramByteString = (Segment)null;
        }
        label559:
        return -1L;
      }
      paramByteString = new StringBuilder();
      paramByteString.append("fromIndex < 0: ");
      paramByteString.append(paramLong);
      throw ((Throwable)new IllegalArgumentException(paramByteString.toString().toString()));
    }
    paramByteString = (Throwable)new IllegalArgumentException("bytes is empty".toString());
    for (;;)
    {
      throw paramByteString;
    }
  }
  
  public long indexOfElement(@NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "targetBytes");
    return indexOfElement(paramByteString, 0L);
  }
  
  public long indexOfElement(@NotNull ByteString paramByteString, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "targetBytes");
    long l1 = 0L;
    int i;
    if (paramLong >= 0L) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      Object localObject2 = this.head;
      if (localObject2 != null)
      {
        Object localObject1 = localObject2;
        int k;
        int m;
        int j;
        int n;
        int i1;
        if (size() - paramLong < paramLong)
        {
          l1 = size();
          localObject1 = localObject2;
          while (l1 > paramLong)
          {
            localObject1 = ((Segment)localObject1).prev;
            if (localObject1 == null) {
              Intrinsics.throwNpe();
            }
            l1 -= ((Segment)localObject1).limit - ((Segment)localObject1).pos;
          }
          if (localObject1 != null)
          {
            if (paramByteString.size() == 2)
            {
              k = paramByteString.getByte(0);
              m = paramByteString.getByte(1);
              while (l1 < size())
              {
                localObject2 = ((Segment)localObject1).data;
                j = (int)(((Segment)localObject1).pos + paramLong - l1);
                n = ((Segment)localObject1).limit;
                while (j < n)
                {
                  i1 = localObject2[j];
                  paramLong = l1;
                  paramByteString = (ByteString)localObject1;
                  i = j;
                  if (i1 != k) {
                    if (i1 == m)
                    {
                      paramLong = l1;
                      paramByteString = (ByteString)localObject1;
                      i = j;
                    }
                    else
                    {
                      j += 1;
                      continue;
                    }
                  }
                  j = paramByteString.pos;
                  return i - j + paramLong;
                }
                paramLong = ((Segment)localObject1).limit - ((Segment)localObject1).pos + l1;
                localObject1 = ((Segment)localObject1).next;
                if (localObject1 == null) {
                  Intrinsics.throwNpe();
                }
                l1 = paramLong;
              }
            }
            paramByteString = paramByteString.internalArray$okio();
            for (;;)
            {
              if (l1 >= size()) {
                break label784;
              }
              localObject2 = ((Segment)localObject1).data;
              i = (int)(((Segment)localObject1).pos + paramLong - l1);
              k = ((Segment)localObject1).limit;
              for (;;)
              {
                if (i >= k) {
                  break label396;
                }
                m = localObject2[i];
                n = paramByteString.length;
                j = 0;
                for (;;)
                {
                  if (j >= n) {
                    break label387;
                  }
                  if (m == paramByteString[j])
                  {
                    j = ((Segment)localObject1).pos;
                    paramLong = l1;
                    break;
                  }
                  j += 1;
                }
                label387:
                i += 1;
              }
              label396:
              paramLong = ((Segment)localObject1).limit - ((Segment)localObject1).pos + l1;
              localObject1 = ((Segment)localObject1).next;
              if (localObject1 == null) {
                Intrinsics.throwNpe();
              }
              l1 = paramLong;
            }
          }
        }
        else
        {
          for (;;)
          {
            long l2 = ((Segment)localObject1).limit - ((Segment)localObject1).pos + l1;
            if (l2 > paramLong)
            {
              if (localObject1 == null) {
                break label784;
              }
              if (paramByteString.size() == 2)
              {
                k = paramByteString.getByte(0);
                m = paramByteString.getByte(1);
                for (;;)
                {
                  if (l1 >= size()) {
                    break label784;
                  }
                  localObject2 = ((Segment)localObject1).data;
                  j = (int)(((Segment)localObject1).pos + paramLong - l1);
                  n = ((Segment)localObject1).limit;
                  for (;;)
                  {
                    if (j >= n) {
                      break label582;
                    }
                    i1 = localObject2[j];
                    paramLong = l1;
                    paramByteString = (ByteString)localObject1;
                    i = j;
                    if (i1 == k) {
                      break;
                    }
                    if (i1 == m)
                    {
                      paramLong = l1;
                      paramByteString = (ByteString)localObject1;
                      i = j;
                      break;
                    }
                    j += 1;
                  }
                  label582:
                  paramLong = ((Segment)localObject1).limit - ((Segment)localObject1).pos + l1;
                  localObject1 = ((Segment)localObject1).next;
                  if (localObject1 == null) {
                    Intrinsics.throwNpe();
                  }
                  l1 = paramLong;
                }
              }
              paramByteString = paramByteString.internalArray$okio();
              for (;;)
              {
                if (l1 >= size()) {
                  break label784;
                }
                localObject2 = ((Segment)localObject1).data;
                i = (int)(((Segment)localObject1).pos + paramLong - l1);
                k = ((Segment)localObject1).limit;
                for (;;)
                {
                  if (i >= k) {
                    break label720;
                  }
                  m = localObject2[i];
                  n = paramByteString.length;
                  j = 0;
                  for (;;)
                  {
                    if (j >= n) {
                      break label711;
                    }
                    if (m == paramByteString[j]) {
                      break;
                    }
                    j += 1;
                  }
                  label711:
                  i += 1;
                }
                label720:
                paramLong = ((Segment)localObject1).limit - ((Segment)localObject1).pos + l1;
                localObject1 = ((Segment)localObject1).next;
                if (localObject1 == null) {
                  Intrinsics.throwNpe();
                }
                l1 = paramLong;
              }
            }
            localObject1 = ((Segment)localObject1).next;
            if (localObject1 == null) {
              Intrinsics.throwNpe();
            }
            l1 = l2;
          }
        }
      }
      else
      {
        paramByteString = (Segment)null;
      }
      label784:
      return -1L;
    }
    paramByteString = new StringBuilder();
    paramByteString.append("fromIndex < 0: ");
    paramByteString.append(paramLong);
    paramByteString = (Throwable)new IllegalArgumentException(paramByteString.toString().toString());
    for (;;)
    {
      throw paramByteString;
    }
  }
  
  @NotNull
  public InputStream inputStream()
  {
    return (InputStream)new Buffer.inputStream.1(this);
  }
  
  public boolean isOpen()
  {
    return true;
  }
  
  @NotNull
  public final ByteString md5()
  {
    return digest("MD5");
  }
  
  @NotNull
  public OutputStream outputStream()
  {
    return (OutputStream)new Buffer.outputStream.1(this);
  }
  
  @NotNull
  public BufferedSource peek()
  {
    return Okio.buffer((Source)new PeekSource((BufferedSource)this));
  }
  
  public boolean rangeEquals(long paramLong, @NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "bytes");
    return rangeEquals(paramLong, paramByteString, 0, paramByteString.size());
  }
  
  public boolean rangeEquals(long paramLong, @NotNull ByteString paramByteString, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "bytes");
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramLong >= 0L)
    {
      bool1 = bool2;
      if (paramInt1 >= 0)
      {
        bool1 = bool2;
        if (paramInt2 >= 0)
        {
          bool1 = bool2;
          if (size() - paramLong >= paramInt2)
          {
            if (paramByteString.size() - paramInt1 < paramInt2) {
              return false;
            }
            int i = 0;
            while (i < paramInt2)
            {
              if (getByte(i + paramLong) != paramByteString.getByte(paramInt1 + i)) {
                return false;
              }
              i += 1;
            }
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public int read(@NotNull ByteBuffer paramByteBuffer)
  {
    Intrinsics.checkParameterIsNotNull(paramByteBuffer, "sink");
    Segment localSegment = this.head;
    if (localSegment != null)
    {
      int i = Math.min(paramByteBuffer.remaining(), localSegment.limit - localSegment.pos);
      paramByteBuffer.put(localSegment.data, localSegment.pos, i);
      localSegment.pos += i;
      this.size -= i;
      if (localSegment.pos == localSegment.limit)
      {
        this.head = localSegment.pop();
        SegmentPool.INSTANCE.recycle(localSegment);
      }
      return i;
    }
    return -1;
  }
  
  public int read(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "sink");
    return read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public int read(@NotNull byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "sink");
    -Util.checkOffsetAndCount(paramArrayOfByte.length, paramInt1, paramInt2);
    Segment localSegment = this.head;
    if (localSegment != null)
    {
      paramInt2 = Math.min(paramInt2, localSegment.limit - localSegment.pos);
      ArraysKt.copyInto(localSegment.data, paramArrayOfByte, paramInt1, localSegment.pos, localSegment.pos + paramInt2);
      localSegment.pos += paramInt2;
      setSize$okio(size() - paramInt2);
      paramInt1 = paramInt2;
      if (localSegment.pos == localSegment.limit)
      {
        this.head = localSegment.pop();
        SegmentPool.INSTANCE.recycle(localSegment);
        return paramInt2;
      }
    }
    else
    {
      paramInt1 = -1;
    }
    return paramInt1;
  }
  
  public long read(@NotNull Buffer paramBuffer, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "sink");
    int i;
    if (paramLong >= 0L) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (size() == 0L) {
        return -1L;
      }
      long l = paramLong;
      if (paramLong > size()) {
        l = size();
      }
      paramBuffer.write(this, l);
      return l;
    }
    paramBuffer = new StringBuilder();
    paramBuffer.append("byteCount < 0: ");
    paramBuffer.append(paramLong);
    throw ((Throwable)new IllegalArgumentException(paramBuffer.toString().toString()));
  }
  
  public long readAll(@NotNull Sink paramSink)
  {
    Intrinsics.checkParameterIsNotNull(paramSink, "sink");
    long l = size();
    if (l > 0L) {
      paramSink.write(this, l);
    }
    return l;
  }
  
  @JvmOverloads
  @NotNull
  public final Buffer.UnsafeCursor readAndWriteUnsafe()
  {
    return readAndWriteUnsafe$default(this, null, 1, null);
  }
  
  @JvmOverloads
  @NotNull
  public final Buffer.UnsafeCursor readAndWriteUnsafe(@NotNull Buffer.UnsafeCursor paramUnsafeCursor)
  {
    Intrinsics.checkParameterIsNotNull(paramUnsafeCursor, "unsafeCursor");
    int i;
    if (paramUnsafeCursor.buffer == null) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      paramUnsafeCursor.buffer = ((Buffer)this);
      paramUnsafeCursor.readWrite = true;
      return paramUnsafeCursor;
    }
    throw ((Throwable)new IllegalStateException("already attached to a buffer".toString()));
  }
  
  public byte readByte()
  {
    if (size() != 0L)
    {
      Segment localSegment = this.head;
      if (localSegment == null) {
        Intrinsics.throwNpe();
      }
      int i = localSegment.pos;
      int j = localSegment.limit;
      byte[] arrayOfByte = localSegment.data;
      int k = i + 1;
      byte b = arrayOfByte[i];
      setSize$okio(size() - 1L);
      if (k == j)
      {
        this.head = localSegment.pop();
        SegmentPool.INSTANCE.recycle(localSegment);
        return b;
      }
      localSegment.pos = k;
      return b;
    }
    throw ((Throwable)new EOFException());
  }
  
  @NotNull
  public byte[] readByteArray()
  {
    return readByteArray(size());
  }
  
  @NotNull
  public byte[] readByteArray(long paramLong)
  {
    int i;
    if ((paramLong >= 0L) && (paramLong <= 2147483647)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (size() >= paramLong)
      {
        localObject = new byte[(int)paramLong];
        readFully((byte[])localObject);
        return localObject;
      }
      throw ((Throwable)new EOFException());
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("byteCount: ");
    ((StringBuilder)localObject).append(paramLong);
    throw ((Throwable)new IllegalArgumentException(((StringBuilder)localObject).toString().toString()));
  }
  
  @NotNull
  public ByteString readByteString()
  {
    return readByteString(size());
  }
  
  @NotNull
  public ByteString readByteString(long paramLong)
  {
    int i;
    if ((paramLong >= 0L) && (paramLong <= 2147483647)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (size() >= paramLong)
      {
        if (paramLong >= 4096)
        {
          localObject = snapshot((int)paramLong);
          skip(paramLong);
          return localObject;
        }
        return new ByteString(readByteArray(paramLong));
      }
      throw ((Throwable)new EOFException());
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("byteCount: ");
    ((StringBuilder)localObject).append(paramLong);
    throw ((Throwable)new IllegalArgumentException(((StringBuilder)localObject).toString().toString()));
  }
  
  public long readDecimalLong()
  {
    long l1 = size();
    long l3 = 0L;
    if (l1 != 0L)
    {
      int i1 = 0;
      long l2 = -7L;
      int i2 = 0;
      int j = 0;
      int k;
      int m;
      label264:
      do
      {
        localObject1 = this.head;
        if (localObject1 == null) {
          Intrinsics.throwNpe();
        }
        Object localObject2 = ((Segment)localObject1).data;
        int n = ((Segment)localObject1).pos;
        int i3 = ((Segment)localObject1).limit;
        k = i1;
        l1 = l3;
        m = i2;
        while (n < i3)
        {
          int i = localObject2[n];
          i1 = (byte)48;
          if ((i >= i1) && (i <= (byte)57))
          {
            i1 -= i;
            if ((l1 >= -922337203685477580L) && ((l1 != -922337203685477580L) || (i1 >= l2)))
            {
              l1 = l1 * 10L + i1;
            }
            else
            {
              localObject1 = new Buffer().writeDecimalLong(l1).writeByte(i);
              if (m == 0) {
                ((Buffer)localObject1).readByte();
              }
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("Number too large: ");
              ((StringBuilder)localObject2).append(((Buffer)localObject1).readUtf8());
              throw ((Throwable)new NumberFormatException(((StringBuilder)localObject2).toString()));
            }
          }
          else
          {
            if ((i != (byte)45) || (k != 0)) {
              break label264;
            }
            l2 -= 1L;
            m = 1;
          }
          n += 1;
          k += 1;
          continue;
          if (k != 0)
          {
            j = 1;
          }
          else
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("Expected leading [0-9] or '-' character but was 0x");
            ((StringBuilder)localObject1).append(-Util.toHexString(i));
            throw ((Throwable)new NumberFormatException(((StringBuilder)localObject1).toString()));
          }
        }
        if (n == i3)
        {
          this.head = ((Segment)localObject1).pop();
          SegmentPool.INSTANCE.recycle((Segment)localObject1);
        }
        else
        {
          ((Segment)localObject1).pos = n;
        }
        if (j != 0) {
          break;
        }
        i2 = m;
        l3 = l1;
        i1 = k;
      } while (this.head != null);
      setSize$okio(size() - k);
      if (m != 0) {
        return l1;
      }
      return -l1;
    }
    Object localObject1 = (Throwable)new EOFException();
    for (;;)
    {
      throw ((Throwable)localObject1);
    }
  }
  
  @NotNull
  public final Buffer readFrom(@NotNull InputStream paramInputStream)
  {
    Intrinsics.checkParameterIsNotNull(paramInputStream, "input");
    readFrom(paramInputStream, 9223372036854775807L, true);
    return this;
  }
  
  @NotNull
  public final Buffer readFrom(@NotNull InputStream paramInputStream, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramInputStream, "input");
    int i;
    if (paramLong >= 0L) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      readFrom(paramInputStream, paramLong, false);
      return this;
    }
    paramInputStream = new StringBuilder();
    paramInputStream.append("byteCount < 0: ");
    paramInputStream.append(paramLong);
    throw ((Throwable)new IllegalArgumentException(paramInputStream.toString().toString()));
  }
  
  public void readFully(@NotNull Buffer paramBuffer, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "sink");
    if (size() >= paramLong)
    {
      paramBuffer.write(this, paramLong);
      return;
    }
    paramBuffer.write(this, size());
    throw ((Throwable)new EOFException());
  }
  
  public void readFully(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "sink");
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int j = read(paramArrayOfByte, i, paramArrayOfByte.length - i);
      if (j != -1) {
        i += j;
      } else {
        throw ((Throwable)new EOFException());
      }
    }
  }
  
  public long readHexadecimalUnsignedLong()
  {
    if (size() != 0L)
    {
      int n = 0;
      long l1 = 0L;
      int j = 0;
      long l2;
      int k;
      label250:
      do
      {
        localObject1 = this.head;
        if (localObject1 == null) {
          Intrinsics.throwNpe();
        }
        Object localObject2 = ((Segment)localObject1).data;
        int m = ((Segment)localObject1).pos;
        int i2 = ((Segment)localObject1).limit;
        l2 = l1;
        k = n;
        int i1;
        int i;
        for (;;)
        {
          i1 = j;
          if (m >= i2) {
            break label304;
          }
          i = localObject2[m];
          n = (byte)48;
          if ((i >= n) && (i <= (byte)57))
          {
            n = i - n;
          }
          else
          {
            n = (byte)97;
            if ((i >= n) && (i <= (byte)102)) {}
            for (;;)
            {
              n = i - n + 10;
              break;
              n = (byte)65;
              if ((i < n) || (i > (byte)70)) {
                break label250;
              }
            }
          }
          if ((0x0 & l2) != 0L) {
            break;
          }
          l2 = l2 << 4 | n;
          m += 1;
          k += 1;
        }
        localObject1 = new Buffer().writeHexadecimalUnsignedLong(l2).writeByte(i);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Number too large: ");
        ((StringBuilder)localObject2).append(((Buffer)localObject1).readUtf8());
        throw ((Throwable)new NumberFormatException(((StringBuilder)localObject2).toString()));
        if (k != 0)
        {
          i1 = 1;
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("Expected leading [0-9a-fA-F] character but was 0x");
          ((StringBuilder)localObject1).append(-Util.toHexString(i));
          throw ((Throwable)new NumberFormatException(((StringBuilder)localObject1).toString()));
        }
        if (m == i2)
        {
          this.head = ((Segment)localObject1).pop();
          SegmentPool.INSTANCE.recycle((Segment)localObject1);
        }
        else
        {
          ((Segment)localObject1).pos = m;
        }
        if (i1 != 0) {
          break;
        }
        n = k;
        j = i1;
        l1 = l2;
      } while (this.head != null);
      label304:
      setSize$okio(size() - k);
      return l2;
    }
    Object localObject1 = (Throwable)new EOFException();
    for (;;)
    {
      throw ((Throwable)localObject1);
    }
  }
  
  public int readInt()
  {
    if (size() >= 4L)
    {
      Segment localSegment = this.head;
      if (localSegment == null) {
        Intrinsics.throwNpe();
      }
      int j = localSegment.pos;
      int i = localSegment.limit;
      if (i - j < 4L) {
        return (readByte() & 0xFF) << 24 | (readByte() & 0xFF) << 16 | (readByte() & 0xFF) << 8 | readByte() & 0xFF;
      }
      byte[] arrayOfByte = localSegment.data;
      int k = j + 1;
      j = arrayOfByte[j];
      int n = k + 1;
      k = arrayOfByte[k];
      int m = n + 1;
      n = arrayOfByte[n];
      int i1 = m + 1;
      m = arrayOfByte[m];
      setSize$okio(size() - 4L);
      if (i1 == i)
      {
        this.head = localSegment.pop();
        SegmentPool.INSTANCE.recycle(localSegment);
      }
      else
      {
        localSegment.pos = i1;
      }
      return (j & 0xFF) << 24 | (k & 0xFF) << 16 | (n & 0xFF) << 8 | m & 0xFF;
    }
    throw ((Throwable)new EOFException());
  }
  
  public int readIntLe()
  {
    return -Util.reverseBytes(readInt());
  }
  
  public long readLong()
  {
    if (size() >= 8L)
    {
      Segment localSegment = this.head;
      if (localSegment == null) {
        Intrinsics.throwNpe();
      }
      int k = localSegment.pos;
      int i = localSegment.limit;
      if (i - k < 8L) {
        return (readInt() & 0xFFFFFFFF) << 32 | 0xFFFFFFFF & readInt();
      }
      byte[] arrayOfByte = localSegment.data;
      int j = k + 1;
      long l1 = arrayOfByte[k];
      k = j + 1;
      long l2 = arrayOfByte[j];
      j = k + 1;
      long l3 = arrayOfByte[k];
      k = j + 1;
      long l4 = arrayOfByte[j];
      j = k + 1;
      long l5 = arrayOfByte[k];
      k = j + 1;
      long l6 = arrayOfByte[j];
      j = k + 1;
      long l7 = arrayOfByte[k];
      k = j + 1;
      long l8 = arrayOfByte[j];
      setSize$okio(size() - 8L);
      if (k == i)
      {
        this.head = localSegment.pop();
        SegmentPool.INSTANCE.recycle(localSegment);
      }
      else
      {
        localSegment.pos = k;
      }
      return (l4 & 0xFF) << 32 | (l1 & 0xFF) << 56 | (l2 & 0xFF) << 48 | (l3 & 0xFF) << 40 | (l5 & 0xFF) << 24 | (l6 & 0xFF) << 16 | (l7 & 0xFF) << 8 | l8 & 0xFF;
    }
    throw ((Throwable)new EOFException());
  }
  
  public long readLongLe()
  {
    return -Util.reverseBytes(readLong());
  }
  
  public short readShort()
  {
    if (size() >= 2L)
    {
      Segment localSegment = this.head;
      if (localSegment == null) {
        Intrinsics.throwNpe();
      }
      int k = localSegment.pos;
      int i = localSegment.limit;
      if (i - k < 2) {
        return (short)((readByte() & 0xFF) << 8 | readByte() & 0xFF);
      }
      byte[] arrayOfByte = localSegment.data;
      int j = k + 1;
      k = arrayOfByte[k];
      int m = j + 1;
      j = arrayOfByte[j];
      setSize$okio(size() - 2L);
      if (m == i)
      {
        this.head = localSegment.pop();
        SegmentPool.INSTANCE.recycle(localSegment);
      }
      else
      {
        localSegment.pos = m;
      }
      return (short)((k & 0xFF) << 8 | j & 0xFF);
    }
    throw ((Throwable)new EOFException());
  }
  
  public short readShortLe()
  {
    return -Util.reverseBytes(readShort());
  }
  
  @NotNull
  public String readString(long paramLong, @NotNull Charset paramCharset)
  {
    Intrinsics.checkParameterIsNotNull(paramCharset, "charset");
    int i;
    if ((paramLong >= 0L) && (paramLong <= 2147483647)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (this.size >= paramLong)
      {
        if (paramLong == 0L) {
          return "";
        }
        Segment localSegment = this.head;
        if (localSegment == null) {
          Intrinsics.throwNpe();
        }
        if (localSegment.pos + paramLong > localSegment.limit) {
          return new String(readByteArray(paramLong), paramCharset);
        }
        byte[] arrayOfByte = localSegment.data;
        i = localSegment.pos;
        int j = (int)paramLong;
        paramCharset = new String(arrayOfByte, i, j, paramCharset);
        localSegment.pos += j;
        this.size -= paramLong;
        if (localSegment.pos == localSegment.limit)
        {
          this.head = localSegment.pop();
          SegmentPool.INSTANCE.recycle(localSegment);
        }
        return paramCharset;
      }
      throw ((Throwable)new EOFException());
    }
    paramCharset = new StringBuilder();
    paramCharset.append("byteCount: ");
    paramCharset.append(paramLong);
    throw ((Throwable)new IllegalArgumentException(paramCharset.toString().toString()));
  }
  
  @NotNull
  public String readString(@NotNull Charset paramCharset)
  {
    Intrinsics.checkParameterIsNotNull(paramCharset, "charset");
    return readString(this.size, paramCharset);
  }
  
  @JvmOverloads
  @NotNull
  public final Buffer.UnsafeCursor readUnsafe()
  {
    return readUnsafe$default(this, null, 1, null);
  }
  
  @JvmOverloads
  @NotNull
  public final Buffer.UnsafeCursor readUnsafe(@NotNull Buffer.UnsafeCursor paramUnsafeCursor)
  {
    Intrinsics.checkParameterIsNotNull(paramUnsafeCursor, "unsafeCursor");
    int i;
    if (paramUnsafeCursor.buffer == null) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      paramUnsafeCursor.buffer = ((Buffer)this);
      paramUnsafeCursor.readWrite = false;
      return paramUnsafeCursor;
    }
    throw ((Throwable)new IllegalStateException("already attached to a buffer".toString()));
  }
  
  @NotNull
  public String readUtf8()
  {
    return readString(this.size, Charsets.UTF_8);
  }
  
  @NotNull
  public String readUtf8(long paramLong)
  {
    return readString(paramLong, Charsets.UTF_8);
  }
  
  public int readUtf8CodePoint()
  {
    if (size() != 0L)
    {
      int i = getByte(0L);
      int n = 1;
      int j;
      int k;
      int m;
      if ((i & 0x80) == 0)
      {
        j = i & 0x7F;
        k = 1;
        m = 0;
      }
      else if ((i & 0xE0) == 192)
      {
        j = i & 0x1F;
        k = 2;
        m = 128;
      }
      else if ((i & 0xF0) == 224)
      {
        j = i & 0xF;
        k = 3;
        m = 2048;
      }
      else
      {
        if ((i & 0xF8) != 240) {
          break label330;
        }
        j = i & 0x7;
        k = 4;
        m = 65536;
      }
      long l2 = size();
      long l1 = k;
      if (l2 >= l1)
      {
        while (n < k)
        {
          l2 = n;
          int i1 = getByte(l2);
          if ((i1 & 0xC0) == 128)
          {
            j = j << 6 | i1 & 0x3F;
            n += 1;
          }
          else
          {
            skip(l2);
            return 65533;
          }
        }
        skip(l1);
        if (j > 1114111) {
          return 65533;
        }
        if ((55296 <= j) && (57343 >= j)) {
          return 65533;
        }
        if (j < m) {
          return 65533;
        }
        return j;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("size < ");
      ((StringBuilder)localObject).append(k);
      ((StringBuilder)localObject).append(": ");
      ((StringBuilder)localObject).append(size());
      ((StringBuilder)localObject).append(" (to read code point prefixed 0x");
      ((StringBuilder)localObject).append(-Util.toHexString(i));
      ((StringBuilder)localObject).append(')');
      throw ((Throwable)new EOFException(((StringBuilder)localObject).toString()));
      label330:
      skip(1L);
      return 65533;
    }
    Object localObject = (Throwable)new EOFException();
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  @Nullable
  public String readUtf8Line()
  {
    long l = indexOf((byte)10);
    if (l != -1L) {
      return BufferKt.readUtf8Line(this, l);
    }
    if (size() != 0L) {
      return readUtf8(size());
    }
    return null;
  }
  
  @NotNull
  public String readUtf8LineStrict()
  {
    return readUtf8LineStrict(9223372036854775807L);
  }
  
  @NotNull
  public String readUtf8LineStrict(long paramLong)
  {
    int i;
    if (paramLong >= 0L) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      long l1 = 9223372036854775807L;
      if (paramLong != 9223372036854775807L) {
        l1 = paramLong + 1L;
      }
      byte b = (byte)10;
      long l2 = indexOf(b, 0L, l1);
      if (l2 != -1L) {
        return BufferKt.readUtf8Line(this, l2);
      }
      if ((l1 < size()) && (getByte(l1 - 1L) == (byte)13) && (getByte(l1) == b)) {
        return BufferKt.readUtf8Line(this, l1);
      }
      localObject = new Buffer();
      l1 = size();
      copyTo((Buffer)localObject, 0L, Math.min(32, l1));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("\\n not found: limit=");
      localStringBuilder.append(Math.min(size(), paramLong));
      localStringBuilder.append(" content=");
      localStringBuilder.append(((Buffer)localObject).readByteString().hex());
      localStringBuilder.append('…');
      throw ((Throwable)new EOFException(localStringBuilder.toString()));
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("limit < 0: ");
    ((StringBuilder)localObject).append(paramLong);
    throw ((Throwable)new IllegalArgumentException(((StringBuilder)localObject).toString().toString()));
  }
  
  public boolean request(long paramLong)
  {
    return this.size >= paramLong;
  }
  
  public void require(long paramLong)
  {
    if (this.size >= paramLong) {
      return;
    }
    throw ((Throwable)new EOFException());
  }
  
  public int select(@NotNull Options paramOptions)
  {
    Intrinsics.checkParameterIsNotNull(paramOptions, "options");
    int i = BufferKt.selectPrefix$default(this, paramOptions, false, 2, null);
    if (i == -1) {
      return -1;
    }
    skip(paramOptions.getByteStrings$okio()[i].size());
    return i;
  }
  
  public final void setSize$okio(long paramLong)
  {
    this.size = paramLong;
  }
  
  @NotNull
  public final ByteString sha1()
  {
    return digest("SHA-1");
  }
  
  @NotNull
  public final ByteString sha256()
  {
    return digest("SHA-256");
  }
  
  @NotNull
  public final ByteString sha512()
  {
    return digest("SHA-512");
  }
  
  @JvmName(name="size")
  public final long size()
  {
    return this.size;
  }
  
  public void skip(long paramLong)
  {
    while (paramLong > 0L)
    {
      Segment localSegment = this.head;
      if (localSegment != null)
      {
        int i = (int)Math.min(paramLong, localSegment.limit - localSegment.pos);
        long l1 = size();
        long l2 = i;
        setSize$okio(l1 - l2);
        l1 = paramLong - l2;
        localSegment.pos += i;
        paramLong = l1;
        if (localSegment.pos == localSegment.limit)
        {
          this.head = localSegment.pop();
          SegmentPool.INSTANCE.recycle(localSegment);
          paramLong = l1;
        }
      }
      else
      {
        throw ((Throwable)new EOFException());
      }
    }
  }
  
  @NotNull
  public final ByteString snapshot()
  {
    int i;
    if (size() <= 2147483647) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return snapshot((int)size());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("size > Int.MAX_VALUE: ");
    localStringBuilder.append(size());
    throw ((Throwable)new IllegalStateException(localStringBuilder.toString().toString()));
  }
  
  @NotNull
  public final ByteString snapshot(int paramInt)
  {
    if (paramInt == 0) {
      return ByteString.EMPTY;
    }
    -Util.checkOffsetAndCount(size(), 0L, paramInt);
    Segment localSegment = this.head;
    int k = 0;
    int j = 0;
    int i = 0;
    while (j < paramInt)
    {
      if (localSegment == null) {
        Intrinsics.throwNpe();
      }
      if (localSegment.limit != localSegment.pos)
      {
        j += localSegment.limit - localSegment.pos;
        i += 1;
        localSegment = localSegment.next;
      }
      else
      {
        throw ((Throwable)new AssertionError("s.limit == s.pos"));
      }
    }
    byte[][] arrayOfByte = new byte[i][];
    int[] arrayOfInt = new int[i * 2];
    localSegment = this.head;
    i = 0;
    j = k;
    while (j < paramInt)
    {
      if (localSegment == null) {
        Intrinsics.throwNpe();
      }
      arrayOfByte[i] = localSegment.data;
      j += localSegment.limit - localSegment.pos;
      arrayOfInt[i] = Math.min(j, paramInt);
      arrayOfInt[(((Object[])arrayOfByte).length + i)] = localSegment.pos;
      localSegment.shared = true;
      i += 1;
      localSegment = localSegment.next;
    }
    return (ByteString)new SegmentedByteString((byte[][])arrayOfByte, arrayOfInt);
  }
  
  @NotNull
  public Timeout timeout()
  {
    return Timeout.NONE;
  }
  
  @NotNull
  public String toString()
  {
    return snapshot().toString();
  }
  
  @NotNull
  public final Segment writableSegment$okio(int paramInt)
  {
    int i = 1;
    if ((paramInt < 1) || (paramInt > 8192)) {
      i = 0;
    }
    if (i != 0)
    {
      Segment localSegment = this.head;
      if (localSegment == null)
      {
        localSegment = SegmentPool.INSTANCE.take();
        this.head = localSegment;
        localSegment.prev = localSegment;
        localSegment.next = localSegment;
        return localSegment;
      }
      if (localSegment == null) {
        Intrinsics.throwNpe();
      }
      localSegment = localSegment.prev;
      if (localSegment == null) {
        Intrinsics.throwNpe();
      }
      if ((localSegment.limit + paramInt <= 8192) && (localSegment.owner)) {
        return localSegment;
      }
      return localSegment.push(SegmentPool.INSTANCE.take());
    }
    throw ((Throwable)new IllegalArgumentException("unexpected capacity".toString()));
  }
  
  public int write(@NotNull ByteBuffer paramByteBuffer)
  {
    Intrinsics.checkParameterIsNotNull(paramByteBuffer, "source");
    int j = paramByteBuffer.remaining();
    int i = j;
    while (i > 0)
    {
      Segment localSegment = writableSegment$okio(1);
      int k = Math.min(i, 8192 - localSegment.limit);
      paramByteBuffer.get(localSegment.data, localSegment.limit, k);
      i -= k;
      localSegment.limit += k;
    }
    this.size += j;
    return j;
  }
  
  @NotNull
  public Buffer write(@NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "byteString");
    paramByteString.write$okio(this, 0, paramByteString.size());
    return this;
  }
  
  @NotNull
  public Buffer write(@NotNull ByteString paramByteString, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "byteString");
    paramByteString.write$okio(this, paramInt1, paramInt2);
    return this;
  }
  
  @NotNull
  public Buffer write(@NotNull Source paramSource, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramSource, "source");
    while (paramLong > 0L)
    {
      long l = paramSource.read(this, paramLong);
      if (l != -1L) {
        paramLong -= l;
      } else {
        throw ((Throwable)new EOFException());
      }
    }
    return this;
  }
  
  @NotNull
  public Buffer write(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "source");
    return write(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  @NotNull
  public Buffer write(@NotNull byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "source");
    long l1 = paramArrayOfByte.length;
    long l2 = paramInt1;
    long l3 = paramInt2;
    -Util.checkOffsetAndCount(l1, l2, l3);
    int i = paramInt2 + paramInt1;
    while (paramInt1 < i)
    {
      Segment localSegment = writableSegment$okio(1);
      int j = Math.min(i - paramInt1, 8192 - localSegment.limit);
      byte[] arrayOfByte = localSegment.data;
      int k = localSegment.limit;
      paramInt2 = paramInt1 + j;
      ArraysKt.copyInto(paramArrayOfByte, arrayOfByte, k, paramInt1, paramInt2);
      localSegment.limit += j;
      paramInt1 = paramInt2;
    }
    setSize$okio(size() + l3);
    return this;
  }
  
  public void write(@NotNull Buffer paramBuffer, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "source");
    int i;
    if (paramBuffer != this) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      -Util.checkOffsetAndCount(paramBuffer.size(), 0L, paramLong);
      while (paramLong > 0L)
      {
        Segment localSegment1 = paramBuffer.head;
        if (localSegment1 == null) {
          Intrinsics.throwNpe();
        }
        i = localSegment1.limit;
        localSegment1 = paramBuffer.head;
        if (localSegment1 == null) {
          Intrinsics.throwNpe();
        }
        if (paramLong < i - localSegment1.pos)
        {
          localSegment1 = this.head;
          if (localSegment1 != null)
          {
            if (localSegment1 == null) {
              Intrinsics.throwNpe();
            }
            localSegment1 = localSegment1.prev;
          }
          else
          {
            localSegment1 = null;
          }
          if ((localSegment1 != null) && (localSegment1.owner))
          {
            l = localSegment1.limit;
            if (localSegment1.shared) {
              i = 0;
            } else {
              i = localSegment1.pos;
            }
            if (l + paramLong - i <= 8192)
            {
              localSegment2 = paramBuffer.head;
              if (localSegment2 == null) {
                Intrinsics.throwNpe();
              }
              localSegment2.writeTo(localSegment1, (int)paramLong);
              paramBuffer.setSize$okio(paramBuffer.size() - paramLong);
              setSize$okio(size() + paramLong);
              return;
            }
          }
          localSegment1 = paramBuffer.head;
          if (localSegment1 == null) {
            Intrinsics.throwNpe();
          }
          paramBuffer.head = localSegment1.split((int)paramLong);
        }
        localSegment1 = paramBuffer.head;
        if (localSegment1 == null) {
          Intrinsics.throwNpe();
        }
        long l = localSegment1.limit - localSegment1.pos;
        paramBuffer.head = localSegment1.pop();
        Segment localSegment2 = this.head;
        if (localSegment2 == null)
        {
          this.head = localSegment1;
          localSegment1.prev = localSegment1;
          localSegment1.next = localSegment1.prev;
        }
        else
        {
          if (localSegment2 == null) {
            Intrinsics.throwNpe();
          }
          localSegment2 = localSegment2.prev;
          if (localSegment2 == null) {
            Intrinsics.throwNpe();
          }
          localSegment2.push(localSegment1).compact();
        }
        paramBuffer.setSize$okio(paramBuffer.size() - l);
        setSize$okio(size() + l);
        paramLong -= l;
      }
      return;
    }
    paramBuffer = (Throwable)new IllegalArgumentException("source == this".toString());
    for (;;)
    {
      throw paramBuffer;
    }
  }
  
  public long writeAll(@NotNull Source paramSource)
  {
    Intrinsics.checkParameterIsNotNull(paramSource, "source");
    long l2;
    for (long l1 = 0L;; l1 += l2)
    {
      l2 = paramSource.read(this, 8192);
      if (l2 == -1L) {
        return l1;
      }
    }
  }
  
  @NotNull
  public Buffer writeByte(int paramInt)
  {
    Segment localSegment = writableSegment$okio(1);
    byte[] arrayOfByte = localSegment.data;
    int i = localSegment.limit;
    localSegment.limit = (i + 1);
    arrayOfByte[i] = ((byte)paramInt);
    setSize$okio(size() + 1L);
    return this;
  }
  
  @NotNull
  public Buffer writeDecimalLong(long paramLong)
  {
    if (paramLong == 0L) {
      return writeByte(48);
    }
    int j = 0;
    int i = 1;
    long l = paramLong;
    if (paramLong < 0L)
    {
      l = -paramLong;
      if (l < 0L) {
        return writeUtf8("-9223372036854775808");
      }
      j = 1;
    }
    if (l < 100000000L)
    {
      if (l < 10000L)
      {
        if (l < 100L)
        {
          if (l >= 10L) {
            i = 2;
          }
        }
        else if (l < 1000L) {
          i = 3;
        } else {
          i = 4;
        }
      }
      else if (l < 1000000L)
      {
        if (l < 100000L) {
          i = 5;
        } else {
          i = 6;
        }
      }
      else if (l < 10000000L) {
        i = 7;
      } else {
        i = 8;
      }
    }
    else if (l < 1000000000000L)
    {
      if (l < 10000000000L)
      {
        if (l < 1000000000L) {
          i = 9;
        } else {
          i = 10;
        }
      }
      else if (l < 100000000000L) {
        i = 11;
      } else {
        i = 12;
      }
    }
    else if (l < 1000000000000000L)
    {
      if (l < 10000000000000L) {
        i = 13;
      } else if (l < 100000000000000L) {
        i = 14;
      } else {
        i = 15;
      }
    }
    else if (l < 100000000000000000L)
    {
      if (l < 10000000000000000L) {
        i = 16;
      } else {
        i = 17;
      }
    }
    else if (l < 1000000000000000000L) {
      i = 18;
    } else {
      i = 19;
    }
    int k = i;
    if (j != 0) {
      k = i + 1;
    }
    Segment localSegment = writableSegment$okio(k);
    byte[] arrayOfByte = localSegment.data;
    i = localSegment.limit + k;
    while (l != 0L)
    {
      paramLong = 10;
      int m = (int)(l % paramLong);
      i -= 1;
      arrayOfByte[i] = BufferKt.getHEX_DIGIT_BYTES()[m];
      l /= paramLong;
    }
    if (j != 0) {
      arrayOfByte[(i - 1)] = ((byte)45);
    }
    localSegment.limit += k;
    setSize$okio(size() + k);
    return this;
  }
  
  @NotNull
  public Buffer writeHexadecimalUnsignedLong(long paramLong)
  {
    if (paramLong == 0L) {
      return writeByte(48);
    }
    long l = paramLong >>> 1 | paramLong;
    l |= l >>> 2;
    l |= l >>> 4;
    l |= l >>> 8;
    l |= l >>> 16;
    l |= l >>> 32;
    l -= (l >>> 1 & 0x55555555);
    l = (l >>> 2 & 0x33333333) + (l & 0x33333333);
    l = (l >>> 4) + l & 0xF0F0F0F;
    l += (l >>> 8);
    l += (l >>> 16);
    int j = (int)(((l & 0x3F) + (l >>> 32 & 0x3F) + 3) / 4);
    Segment localSegment = writableSegment$okio(j);
    byte[] arrayOfByte = localSegment.data;
    int i = localSegment.limit + j - 1;
    int k = localSegment.limit;
    while (i >= k)
    {
      arrayOfByte[i] = BufferKt.getHEX_DIGIT_BYTES()[((int)(0xF & paramLong))];
      paramLong >>>= 4;
      i -= 1;
    }
    localSegment.limit += j;
    setSize$okio(size() + j);
    return this;
  }
  
  @NotNull
  public Buffer writeInt(int paramInt)
  {
    Segment localSegment = writableSegment$okio(4);
    byte[] arrayOfByte = localSegment.data;
    int j = localSegment.limit;
    int i = j + 1;
    arrayOfByte[j] = ((byte)(paramInt >>> 24 & 0xFF));
    j = i + 1;
    arrayOfByte[i] = ((byte)(paramInt >>> 16 & 0xFF));
    i = j + 1;
    arrayOfByte[j] = ((byte)(paramInt >>> 8 & 0xFF));
    arrayOfByte[i] = ((byte)(paramInt & 0xFF));
    localSegment.limit = (i + 1);
    setSize$okio(size() + 4L);
    return this;
  }
  
  @NotNull
  public Buffer writeIntLe(int paramInt)
  {
    return writeInt(-Util.reverseBytes(paramInt));
  }
  
  @NotNull
  public Buffer writeLong(long paramLong)
  {
    Segment localSegment = writableSegment$okio(8);
    byte[] arrayOfByte = localSegment.data;
    int j = localSegment.limit;
    int i = j + 1;
    arrayOfByte[j] = ((byte)(int)(paramLong >>> 56 & 0xFF));
    j = i + 1;
    arrayOfByte[i] = ((byte)(int)(paramLong >>> 48 & 0xFF));
    i = j + 1;
    arrayOfByte[j] = ((byte)(int)(paramLong >>> 40 & 0xFF));
    j = i + 1;
    arrayOfByte[i] = ((byte)(int)(paramLong >>> 32 & 0xFF));
    i = j + 1;
    arrayOfByte[j] = ((byte)(int)(paramLong >>> 24 & 0xFF));
    j = i + 1;
    arrayOfByte[i] = ((byte)(int)(paramLong >>> 16 & 0xFF));
    i = j + 1;
    arrayOfByte[j] = ((byte)(int)(paramLong >>> 8 & 0xFF));
    arrayOfByte[i] = ((byte)(int)(paramLong & 0xFF));
    localSegment.limit = (i + 1);
    setSize$okio(size() + 8L);
    return this;
  }
  
  @NotNull
  public Buffer writeLongLe(long paramLong)
  {
    return writeLong(-Util.reverseBytes(paramLong));
  }
  
  @NotNull
  public Buffer writeShort(int paramInt)
  {
    Segment localSegment = writableSegment$okio(2);
    byte[] arrayOfByte = localSegment.data;
    int i = localSegment.limit;
    int j = i + 1;
    arrayOfByte[i] = ((byte)(paramInt >>> 8 & 0xFF));
    arrayOfByte[j] = ((byte)(paramInt & 0xFF));
    localSegment.limit = (j + 1);
    setSize$okio(size() + 2L);
    return this;
  }
  
  @NotNull
  public Buffer writeShortLe(int paramInt)
  {
    return writeShort(-Util.reverseBytes((short)paramInt));
  }
  
  @NotNull
  public Buffer writeString(@NotNull String paramString, int paramInt1, int paramInt2, @NotNull Charset paramCharset)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "string");
    Intrinsics.checkParameterIsNotNull(paramCharset, "charset");
    int j = 1;
    int i;
    if (paramInt1 >= 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (paramInt2 >= paramInt1) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        if (paramInt2 <= paramString.length()) {
          i = j;
        } else {
          i = 0;
        }
        if (i != 0)
        {
          if (Intrinsics.areEqual(paramCharset, Charsets.UTF_8)) {
            return writeUtf8(paramString, paramInt1, paramInt2);
          }
          paramString = paramString.substring(paramInt1, paramInt2);
          Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
          if (paramString != null)
          {
            paramString = paramString.getBytes(paramCharset);
            Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.String).getBytes(charset)");
            return write(paramString, 0, paramString.length);
          }
          throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        paramCharset = new StringBuilder();
        paramCharset.append("endIndex > string.length: ");
        paramCharset.append(paramInt2);
        paramCharset.append(" > ");
        paramCharset.append(paramString.length());
        throw ((Throwable)new IllegalArgumentException(paramCharset.toString().toString()));
      }
      paramString = new StringBuilder();
      paramString.append("endIndex < beginIndex: ");
      paramString.append(paramInt2);
      paramString.append(" < ");
      paramString.append(paramInt1);
      throw ((Throwable)new IllegalArgumentException(paramString.toString().toString()));
    }
    paramString = new StringBuilder();
    paramString.append("beginIndex < 0: ");
    paramString.append(paramInt1);
    throw ((Throwable)new IllegalArgumentException(paramString.toString().toString()));
  }
  
  @NotNull
  public Buffer writeString(@NotNull String paramString, @NotNull Charset paramCharset)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "string");
    Intrinsics.checkParameterIsNotNull(paramCharset, "charset");
    return writeString(paramString, 0, paramString.length(), paramCharset);
  }
  
  @JvmOverloads
  @NotNull
  public final Buffer writeTo(@NotNull OutputStream paramOutputStream)
  {
    return writeTo$default(this, paramOutputStream, 0L, 2, null);
  }
  
  @JvmOverloads
  @NotNull
  public final Buffer writeTo(@NotNull OutputStream paramOutputStream, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramOutputStream, "out");
    -Util.checkOffsetAndCount(this.size, 0L, paramLong);
    Object localObject = this.head;
    while (paramLong > 0L)
    {
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      int i = (int)Math.min(paramLong, ((Segment)localObject).limit - ((Segment)localObject).pos);
      paramOutputStream.write(((Segment)localObject).data, ((Segment)localObject).pos, i);
      ((Segment)localObject).pos += i;
      long l1 = this.size;
      long l2 = i;
      this.size = (l1 - l2);
      l1 = paramLong - l2;
      paramLong = l1;
      if (((Segment)localObject).pos == ((Segment)localObject).limit)
      {
        Segment localSegment = ((Segment)localObject).pop();
        this.head = localSegment;
        SegmentPool.INSTANCE.recycle((Segment)localObject);
        localObject = localSegment;
        paramLong = l1;
      }
    }
    return this;
  }
  
  @NotNull
  public Buffer writeUtf8(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "string");
    return writeUtf8(paramString, 0, paramString.length());
  }
  
  @NotNull
  public Buffer writeUtf8(@NotNull String paramString, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "string");
    int i;
    if (paramInt1 >= 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (paramInt2 >= paramInt1) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        if (paramInt2 <= paramString.length()) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0)
        {
          while (paramInt1 < paramInt2)
          {
            int k = paramString.charAt(paramInt1);
            int j;
            if (k < 128)
            {
              localObject = writableSegment$okio(1);
              byte[] arrayOfByte = ((Segment)localObject).data;
              j = ((Segment)localObject).limit - paramInt1;
              int m = Math.min(paramInt2, 8192 - j);
              i = paramInt1 + 1;
              arrayOfByte[(paramInt1 + j)] = ((byte)k);
              paramInt1 = i;
              while (paramInt1 < m)
              {
                i = paramString.charAt(paramInt1);
                if (i >= 128) {
                  break;
                }
                arrayOfByte[(paramInt1 + j)] = ((byte)i);
                paramInt1 += 1;
              }
              i = j + paramInt1 - ((Segment)localObject).limit;
              ((Segment)localObject).limit += i;
              setSize$okio(size() + i);
            }
            else
            {
              label217:
              if (k < 2048)
              {
                localObject = writableSegment$okio(2);
                ((Segment)localObject).data[localObject.limit] = ((byte)(k >> 6 | 0xC0));
                ((Segment)localObject).data[(localObject.limit + 1)] = ((byte)(k & 0x3F | 0x80));
                ((Segment)localObject).limit += 2;
                setSize$okio(size() + 2L);
              }
              for (;;)
              {
                paramInt1 += 1;
                break;
                if ((k >= 55296) && (k <= 57343))
                {
                  j = paramInt1 + 1;
                  if (j < paramInt2) {
                    i = paramString.charAt(j);
                  } else {
                    i = 0;
                  }
                  if ((k <= 56319) && (56320 <= i) && (57343 >= i))
                  {
                    i = ((k & 0x3FF) << 10 | i & 0x3FF) + 65536;
                    localObject = writableSegment$okio(4);
                    ((Segment)localObject).data[localObject.limit] = ((byte)(i >> 18 | 0xF0));
                    ((Segment)localObject).data[(localObject.limit + 1)] = ((byte)(i >> 12 & 0x3F | 0x80));
                    ((Segment)localObject).data[(localObject.limit + 2)] = ((byte)(i >> 6 & 0x3F | 0x80));
                    ((Segment)localObject).data[(localObject.limit + 3)] = ((byte)(i & 0x3F | 0x80));
                    ((Segment)localObject).limit += 4;
                    setSize$okio(size() + 4L);
                    paramInt1 += 2;
                    break;
                  }
                  writeByte(63);
                  paramInt1 = j;
                  break label217;
                }
                localObject = writableSegment$okio(3);
                ((Segment)localObject).data[localObject.limit] = ((byte)(k >> 12 | 0xE0));
                ((Segment)localObject).data[(localObject.limit + 1)] = ((byte)(0x3F & k >> 6 | 0x80));
                ((Segment)localObject).data[(localObject.limit + 2)] = ((byte)(k & 0x3F | 0x80));
                ((Segment)localObject).limit += 3;
                setSize$okio(size() + 3L);
              }
            }
          }
          return this;
        }
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("endIndex > string.length: ");
        ((StringBuilder)localObject).append(paramInt2);
        ((StringBuilder)localObject).append(" > ");
        ((StringBuilder)localObject).append(paramString.length());
        throw ((Throwable)new IllegalArgumentException(((StringBuilder)localObject).toString().toString()));
      }
      paramString = new StringBuilder();
      paramString.append("endIndex < beginIndex: ");
      paramString.append(paramInt2);
      paramString.append(" < ");
      paramString.append(paramInt1);
      throw ((Throwable)new IllegalArgumentException(paramString.toString().toString()));
    }
    paramString = new StringBuilder();
    paramString.append("beginIndex < 0: ");
    paramString.append(paramInt1);
    paramString = (Throwable)new IllegalArgumentException(paramString.toString().toString());
    for (;;)
    {
      throw paramString;
    }
  }
  
  @NotNull
  public Buffer writeUtf8CodePoint(int paramInt)
  {
    if (paramInt < 128)
    {
      writeByte(paramInt);
      return this;
    }
    if (paramInt < 2048)
    {
      localObject = writableSegment$okio(2);
      ((Segment)localObject).data[localObject.limit] = ((byte)(paramInt >> 6 | 0xC0));
      ((Segment)localObject).data[(localObject.limit + 1)] = ((byte)(paramInt & 0x3F | 0x80));
      ((Segment)localObject).limit += 2;
      setSize$okio(size() + 2L);
      return this;
    }
    if ((55296 <= paramInt) && (57343 >= paramInt))
    {
      writeByte(63);
      return this;
    }
    if (paramInt < 65536)
    {
      localObject = writableSegment$okio(3);
      ((Segment)localObject).data[localObject.limit] = ((byte)(paramInt >> 12 | 0xE0));
      ((Segment)localObject).data[(localObject.limit + 1)] = ((byte)(paramInt >> 6 & 0x3F | 0x80));
      ((Segment)localObject).data[(localObject.limit + 2)] = ((byte)(paramInt & 0x3F | 0x80));
      ((Segment)localObject).limit += 3;
      setSize$okio(size() + 3L);
      return this;
    }
    if (paramInt <= 1114111)
    {
      localObject = writableSegment$okio(4);
      ((Segment)localObject).data[localObject.limit] = ((byte)(paramInt >> 18 | 0xF0));
      ((Segment)localObject).data[(localObject.limit + 1)] = ((byte)(paramInt >> 12 & 0x3F | 0x80));
      ((Segment)localObject).data[(localObject.limit + 2)] = ((byte)(paramInt >> 6 & 0x3F | 0x80));
      ((Segment)localObject).data[(localObject.limit + 3)] = ((byte)(paramInt & 0x3F | 0x80));
      ((Segment)localObject).limit += 4;
      setSize$okio(size() + 4L);
      return this;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Unexpected code point: 0x");
    ((StringBuilder)localObject).append(-Util.toHexString(paramInt));
    throw ((Throwable)new IllegalArgumentException(((StringBuilder)localObject).toString()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okio.Buffer
 * JD-Core Version:    0.7.0.1
 */