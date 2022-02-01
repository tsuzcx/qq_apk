package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class CodedInputStream
{
  private final byte[] buffer;
  private final boolean bufferIsImmutable;
  private int bufferPos;
  private int bufferSize;
  private int bufferSizeAfterLimit;
  private int currentLimit = 2147483647;
  private boolean enableAliasing = false;
  private final InputStream input;
  private int lastTag;
  private int recursionDepth;
  private int recursionLimit = 64;
  private CodedInputStream.RefillCallback refillCallback = null;
  private int sizeLimit = 67108864;
  private int totalBytesRetired;
  
  private CodedInputStream(InputStream paramInputStream)
  {
    this.buffer = new byte[4096];
    this.bufferSize = 0;
    this.bufferPos = 0;
    this.totalBytesRetired = 0;
    this.input = paramInputStream;
    this.bufferIsImmutable = false;
  }
  
  private CodedInputStream(LiteralByteString paramLiteralByteString)
  {
    this.buffer = paramLiteralByteString.bytes;
    this.bufferPos = paramLiteralByteString.getOffsetIntoBytes();
    this.bufferSize = (this.bufferPos + paramLiteralByteString.size());
    this.totalBytesRetired = (-this.bufferPos);
    this.input = null;
    this.bufferIsImmutable = true;
  }
  
  public static int decodeZigZag32(int paramInt)
  {
    return -(paramInt & 0x1) ^ paramInt >>> 1;
  }
  
  public static long decodeZigZag64(long paramLong)
  {
    return -(paramLong & 1L) ^ paramLong >>> 1;
  }
  
  private void ensureAvailable(int paramInt)
  {
    if (this.bufferSize - this.bufferPos < paramInt) {
      refillBuffer(paramInt);
    }
  }
  
  public static CodedInputStream newInstance(InputStream paramInputStream)
  {
    return new CodedInputStream(paramInputStream);
  }
  
  static CodedInputStream newInstance(LiteralByteString paramLiteralByteString)
  {
    CodedInputStream localCodedInputStream = new CodedInputStream(paramLiteralByteString);
    try
    {
      localCodedInputStream.pushLimit(paramLiteralByteString.size());
      return localCodedInputStream;
    }
    catch (InvalidProtocolBufferException paramLiteralByteString)
    {
      throw new IllegalArgumentException(paramLiteralByteString);
    }
  }
  
  private byte[] readRawBytesSlowPath(int paramInt)
  {
    if (paramInt <= 0)
    {
      if (paramInt == 0) {
        return Internal.EMPTY_BYTE_ARRAY;
      }
      throw InvalidProtocolBufferException.negativeSize();
    }
    int i = this.totalBytesRetired;
    int n = this.bufferPos;
    int j = this.currentLimit;
    if (i + n + paramInt <= j)
    {
      if (paramInt < 4096)
      {
        localObject1 = new byte[paramInt];
        i = this.bufferSize - n;
        System.arraycopy(this.buffer, n, localObject1, 0, i);
        this.bufferPos = this.bufferSize;
        paramInt -= i;
        ensureAvailable(paramInt);
        System.arraycopy(this.buffer, 0, localObject1, i, paramInt);
        this.bufferPos = paramInt;
        return localObject1;
      }
      j = this.bufferSize;
      this.totalBytesRetired = (i + j);
      this.bufferPos = 0;
      this.bufferSize = 0;
      int m = j - n;
      i = paramInt - m;
      localObject1 = new ArrayList();
      Object localObject2;
      while (i > 0)
      {
        arrayOfByte = new byte[Math.min(i, 4096)];
        j = 0;
        while (j < arrayOfByte.length)
        {
          localObject2 = this.input;
          int k;
          if (localObject2 == null) {
            k = -1;
          } else {
            k = ((InputStream)localObject2).read(arrayOfByte, j, arrayOfByte.length - j);
          }
          if (k != -1)
          {
            this.totalBytesRetired += k;
            j += k;
          }
          else
          {
            throw InvalidProtocolBufferException.truncatedMessage();
          }
        }
        i -= arrayOfByte.length;
        ((List)localObject1).add(arrayOfByte);
      }
      byte[] arrayOfByte = new byte[paramInt];
      System.arraycopy(this.buffer, n, arrayOfByte, 0, m);
      localObject1 = ((List)localObject1).iterator();
      paramInt = m;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (byte[])((Iterator)localObject1).next();
        System.arraycopy(localObject2, 0, arrayOfByte, paramInt, localObject2.length);
        paramInt += localObject2.length;
      }
      return arrayOfByte;
    }
    skipRawBytes(j - i - n);
    Object localObject1 = InvalidProtocolBufferException.truncatedMessage();
    for (;;)
    {
      throw ((Throwable)localObject1);
    }
  }
  
  public static int readRawVarint32(int paramInt, InputStream paramInputStream)
  {
    if ((paramInt & 0x80) == 0) {
      return paramInt;
    }
    int i = paramInt & 0x7F;
    paramInt = 7;
    int j;
    for (;;)
    {
      j = paramInt;
      if (paramInt >= 32) {
        break label67;
      }
      j = paramInputStream.read();
      if (j == -1) {
        break;
      }
      i |= (j & 0x7F) << paramInt;
      if ((j & 0x80) == 0) {
        return i;
      }
      paramInt += 7;
    }
    throw InvalidProtocolBufferException.truncatedMessage();
    label67:
    while (j < 64)
    {
      paramInt = paramInputStream.read();
      if (paramInt != -1)
      {
        if ((paramInt & 0x80) == 0) {
          return i;
        }
        j += 7;
      }
      else
      {
        throw InvalidProtocolBufferException.truncatedMessage();
      }
    }
    paramInputStream = InvalidProtocolBufferException.malformedVarint();
    for (;;)
    {
      throw paramInputStream;
    }
  }
  
  private void recomputeBufferSizeAfterLimit()
  {
    this.bufferSize += this.bufferSizeAfterLimit;
    int j = this.totalBytesRetired;
    int i = this.bufferSize;
    j += i;
    int k = this.currentLimit;
    if (j > k)
    {
      this.bufferSizeAfterLimit = (j - k);
      this.bufferSize = (i - this.bufferSizeAfterLimit);
      return;
    }
    this.bufferSizeAfterLimit = 0;
  }
  
  private void refillBuffer(int paramInt)
  {
    if (tryRefillBuffer(paramInt)) {
      return;
    }
    throw InvalidProtocolBufferException.truncatedMessage();
  }
  
  private void skipRawBytesSlowPath(int paramInt)
  {
    if (paramInt >= 0)
    {
      int j = this.totalBytesRetired;
      int i = this.bufferPos;
      int k = this.currentLimit;
      if (j + i + paramInt <= k)
      {
        j = this.bufferSize;
        i = j - i;
        this.bufferPos = j;
        refillBuffer(1);
        for (;;)
        {
          k = paramInt - i;
          j = this.bufferSize;
          if (k <= j) {
            break;
          }
          i += j;
          this.bufferPos = j;
          refillBuffer(1);
        }
        this.bufferPos = k;
        return;
      }
      skipRawBytes(k - j - i);
      throw InvalidProtocolBufferException.truncatedMessage();
    }
    InvalidProtocolBufferException localInvalidProtocolBufferException = InvalidProtocolBufferException.negativeSize();
    for (;;)
    {
      throw localInvalidProtocolBufferException;
    }
  }
  
  private boolean tryRefillBuffer(int paramInt)
  {
    int i = this.bufferPos;
    if (i + paramInt > this.bufferSize)
    {
      if (this.totalBytesRetired + i + paramInt > this.currentLimit) {
        return false;
      }
      localObject = this.refillCallback;
      if (localObject != null) {
        ((CodedInputStream.RefillCallback)localObject).onRefill();
      }
      if (this.input != null)
      {
        i = this.bufferPos;
        if (i > 0)
        {
          int j = this.bufferSize;
          if (j > i)
          {
            localObject = this.buffer;
            System.arraycopy(localObject, i, localObject, 0, j - i);
          }
          this.totalBytesRetired += i;
          this.bufferSize -= i;
          this.bufferPos = 0;
        }
        localObject = this.input;
        byte[] arrayOfByte = this.buffer;
        i = this.bufferSize;
        i = ((InputStream)localObject).read(arrayOfByte, i, arrayOfByte.length - i);
        if ((i != 0) && (i >= -1) && (i <= this.buffer.length))
        {
          if (i > 0)
          {
            this.bufferSize += i;
            if (this.totalBytesRetired + paramInt - this.sizeLimit <= 0)
            {
              recomputeBufferSizeAfterLimit();
              if (this.bufferSize >= paramInt) {
                return true;
              }
              return tryRefillBuffer(paramInt);
            }
            throw InvalidProtocolBufferException.sizeLimitExceeded();
          }
        }
        else
        {
          localObject = new StringBuilder(102);
          ((StringBuilder)localObject).append("InputStream#read(byte[]) returned invalid result: ");
          ((StringBuilder)localObject).append(i);
          ((StringBuilder)localObject).append("\nThe InputStream implementation is buggy.");
          throw new IllegalStateException(((StringBuilder)localObject).toString());
        }
      }
      return false;
    }
    Object localObject = new StringBuilder(77);
    ((StringBuilder)localObject).append("refillBuffer() called when ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" bytes were already available in buffer");
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public void checkLastTagWas(int paramInt)
  {
    if (this.lastTag == paramInt) {
      return;
    }
    throw InvalidProtocolBufferException.invalidEndTag();
  }
  
  public int getBytesUntilLimit()
  {
    int i = this.currentLimit;
    if (i == 2147483647) {
      return -1;
    }
    return i - (this.totalBytesRetired + this.bufferPos);
  }
  
  public boolean isAtEnd()
  {
    return (this.bufferPos == this.bufferSize) && (!tryRefillBuffer(1));
  }
  
  public void popLimit(int paramInt)
  {
    this.currentLimit = paramInt;
    recomputeBufferSizeAfterLimit();
  }
  
  public int pushLimit(int paramInt)
  {
    if (paramInt >= 0)
    {
      paramInt += this.totalBytesRetired + this.bufferPos;
      int i = this.currentLimit;
      if (paramInt <= i)
      {
        this.currentLimit = paramInt;
        recomputeBufferSizeAfterLimit();
        return i;
      }
      throw InvalidProtocolBufferException.truncatedMessage();
    }
    throw InvalidProtocolBufferException.negativeSize();
  }
  
  public boolean readBool()
  {
    return readRawVarint64() != 0L;
  }
  
  public ByteString readBytes()
  {
    int i = readRawVarint32();
    int j = this.bufferSize;
    int k = this.bufferPos;
    if ((i <= j - k) && (i > 0))
    {
      Object localObject;
      if ((this.bufferIsImmutable) && (this.enableAliasing)) {
        localObject = new BoundedByteString(this.buffer, k, i);
      } else {
        localObject = ByteString.copyFrom(this.buffer, this.bufferPos, i);
      }
      this.bufferPos += i;
      return localObject;
    }
    if (i == 0) {
      return ByteString.EMPTY;
    }
    return new LiteralByteString(readRawBytesSlowPath(i));
  }
  
  public double readDouble()
  {
    return Double.longBitsToDouble(readRawLittleEndian64());
  }
  
  public int readEnum()
  {
    return readRawVarint32();
  }
  
  public int readFixed32()
  {
    return readRawLittleEndian32();
  }
  
  public long readFixed64()
  {
    return readRawLittleEndian64();
  }
  
  public float readFloat()
  {
    return Float.intBitsToFloat(readRawLittleEndian32());
  }
  
  public void readGroup(int paramInt, MessageLite.Builder paramBuilder, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    int i = this.recursionDepth;
    if (i < this.recursionLimit)
    {
      this.recursionDepth = (i + 1);
      paramBuilder.mergeFrom(this, paramExtensionRegistryLite);
      checkLastTagWas(WireFormat.makeTag(paramInt, 4));
      this.recursionDepth -= 1;
      return;
    }
    throw InvalidProtocolBufferException.recursionLimitExceeded();
  }
  
  public int readInt32()
  {
    return readRawVarint32();
  }
  
  public long readInt64()
  {
    return readRawVarint64();
  }
  
  public <T extends MessageLite> T readMessage(Parser<T> paramParser, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    int i = readRawVarint32();
    if (this.recursionDepth < this.recursionLimit)
    {
      i = pushLimit(i);
      this.recursionDepth += 1;
      paramParser = (MessageLite)paramParser.parsePartialFrom(this, paramExtensionRegistryLite);
      checkLastTagWas(0);
      this.recursionDepth -= 1;
      popLimit(i);
      return paramParser;
    }
    throw InvalidProtocolBufferException.recursionLimitExceeded();
  }
  
  public void readMessage(MessageLite.Builder paramBuilder, ExtensionRegistryLite paramExtensionRegistryLite)
  {
    int i = readRawVarint32();
    if (this.recursionDepth < this.recursionLimit)
    {
      i = pushLimit(i);
      this.recursionDepth += 1;
      paramBuilder.mergeFrom(this, paramExtensionRegistryLite);
      checkLastTagWas(0);
      this.recursionDepth -= 1;
      popLimit(i);
      return;
    }
    throw InvalidProtocolBufferException.recursionLimitExceeded();
  }
  
  public byte readRawByte()
  {
    if (this.bufferPos == this.bufferSize) {
      refillBuffer(1);
    }
    byte[] arrayOfByte = this.buffer;
    int i = this.bufferPos;
    this.bufferPos = (i + 1);
    return arrayOfByte[i];
  }
  
  public int readRawLittleEndian32()
  {
    int j = this.bufferPos;
    int i = j;
    if (this.bufferSize - j < 4)
    {
      refillBuffer(4);
      i = this.bufferPos;
    }
    byte[] arrayOfByte = this.buffer;
    this.bufferPos = (i + 4);
    j = arrayOfByte[i];
    int k = arrayOfByte[(i + 1)];
    int m = arrayOfByte[(i + 2)];
    return (arrayOfByte[(i + 3)] & 0xFF) << 24 | j & 0xFF | (k & 0xFF) << 8 | (m & 0xFF) << 16;
  }
  
  public long readRawLittleEndian64()
  {
    int j = this.bufferPos;
    int i = j;
    if (this.bufferSize - j < 8)
    {
      refillBuffer(8);
      i = this.bufferPos;
    }
    byte[] arrayOfByte = this.buffer;
    this.bufferPos = (i + 8);
    long l1 = arrayOfByte[i];
    long l2 = arrayOfByte[(i + 1)];
    long l3 = arrayOfByte[(i + 2)];
    long l4 = arrayOfByte[(i + 3)];
    long l5 = arrayOfByte[(i + 4)];
    long l6 = arrayOfByte[(i + 5)];
    long l7 = arrayOfByte[(i + 6)];
    return (arrayOfByte[(i + 7)] & 0xFF) << 56 | l1 & 0xFF | (l2 & 0xFF) << 8 | (l3 & 0xFF) << 16 | (l4 & 0xFF) << 24 | (l5 & 0xFF) << 32 | (l6 & 0xFF) << 40 | (l7 & 0xFF) << 48;
  }
  
  public int readRawVarint32()
  {
    int k = this.bufferPos;
    int j = this.bufferSize;
    int i;
    if (j != k)
    {
      byte[] arrayOfByte = this.buffer;
      i = k + 1;
      k = arrayOfByte[k];
      if (k >= 0)
      {
        this.bufferPos = i;
        return k;
      }
      if (j - i >= 9)
      {
        j = i + 1;
        k ^= arrayOfByte[i] << 7;
        long l1 = k;
        long l2;
        if (l1 < 0L)
        {
          l2 = -128L;
          i = j;
          j = (int)(l1 ^ l2);
          break label300;
        }
        i = j + 1;
        k ^= arrayOfByte[j] << 14;
        l1 = k;
        if (l1 >= 0L) {
          j = (int)(0x3F80 ^ l1);
        }
        int m;
        int n;
        do
        {
          do
          {
            do
            {
              break label300;
              j = i + 1;
              i = k ^ arrayOfByte[i] << 21;
              l1 = i;
              if (l1 < 0L)
              {
                l2 = -2080896L;
                i = j;
                break;
              }
              m = j + 1;
              n = arrayOfByte[j];
              k = (int)(i ^ n << 28 ^ 0xFE03F80);
              j = k;
              i = m;
            } while (n >= 0);
            n = m + 1;
            j = k;
            i = n;
            if (arrayOfByte[m] >= 0) {
              break label300;
            }
            m = n + 1;
            j = k;
            i = m;
          } while (arrayOfByte[n] >= 0);
          n = m + 1;
          j = k;
          i = n;
          if (arrayOfByte[m] >= 0) {
            break label300;
          }
          m = n + 1;
          j = k;
          i = m;
        } while (arrayOfByte[n] >= 0);
        i = m + 1;
        j = k;
        if (arrayOfByte[m] >= 0) {
          break label300;
        }
      }
    }
    return (int)readRawVarint64SlowPath();
    label300:
    this.bufferPos = i;
    return j;
  }
  
  public long readRawVarint64()
  {
    int k = this.bufferPos;
    int i = this.bufferSize;
    long l1;
    if (i != k)
    {
      byte[] arrayOfByte = this.buffer;
      int j = k + 1;
      k = arrayOfByte[k];
      if (k >= 0)
      {
        this.bufferPos = j;
        return k;
      }
      if (i - j >= 9)
      {
        i = j + 1;
        l1 = k ^ arrayOfByte[j] << 7;
        if (l1 < 0L)
        {
          l2 = -128L;
          l1 ^= l2;
          break label356;
        }
        j = i + 1;
        long l2 = l1 ^ arrayOfByte[i] << 14;
        if (l2 >= 0L)
        {
          l1 = 16256L;
          i = j;
          label125:
          l1 = l2 ^ l1;
        }
        do
        {
          break label356;
          i = j + 1;
          l1 = l2 ^ arrayOfByte[j] << 21;
          if (l1 < 0L)
          {
            l2 = -2080896L;
            break;
          }
          j = i + 1;
          l2 = l1 ^ arrayOfByte[i] << 28;
          if (l2 >= 0L)
          {
            l1 = 266354560L;
            i = j;
            break label125;
          }
          i = j + 1;
          l1 = l2 ^ arrayOfByte[j] << 35;
          if (l1 < 0L)
          {
            l2 = -34093383808L;
            break;
          }
          j = i + 1;
          l2 = l1 ^ arrayOfByte[i] << 42;
          if (l2 >= 0L)
          {
            l1 = 4363953127296L;
            i = j;
            break label125;
          }
          i = j + 1;
          l1 = l2 ^ arrayOfByte[j] << 49;
          if (l1 < 0L)
          {
            l2 = -558586000294016L;
            break;
          }
          j = i + 1;
          l2 = l1 ^ arrayOfByte[i] << 56 ^ 0xFE03F80;
          i = j;
          l1 = l2;
        } while (l2 >= 0L);
        i = j + 1;
        l1 = l2;
        if (arrayOfByte[j] >= 0L) {
          break label356;
        }
      }
    }
    return readRawVarint64SlowPath();
    label356:
    this.bufferPos = i;
    return l1;
  }
  
  long readRawVarint64SlowPath()
  {
    long l = 0L;
    int i = 0;
    while (i < 64)
    {
      int j = readRawByte();
      l |= (j & 0x7F) << i;
      if ((j & 0x80) == 0) {
        return l;
      }
      i += 7;
    }
    InvalidProtocolBufferException localInvalidProtocolBufferException = InvalidProtocolBufferException.malformedVarint();
    for (;;)
    {
      throw localInvalidProtocolBufferException;
    }
  }
  
  public int readSFixed32()
  {
    return readRawLittleEndian32();
  }
  
  public long readSFixed64()
  {
    return readRawLittleEndian64();
  }
  
  public int readSInt32()
  {
    return decodeZigZag32(readRawVarint32());
  }
  
  public long readSInt64()
  {
    return decodeZigZag64(readRawVarint64());
  }
  
  public String readString()
  {
    int i = readRawVarint32();
    int j = this.bufferSize;
    int k = this.bufferPos;
    if ((i <= j - k) && (i > 0))
    {
      String str = new String(this.buffer, k, i, "UTF-8");
      this.bufferPos += i;
      return str;
    }
    if (i == 0) {
      return "";
    }
    return new String(readRawBytesSlowPath(i), "UTF-8");
  }
  
  public String readStringRequireUtf8()
  {
    int j = readRawVarint32();
    int i = this.bufferPos;
    byte[] arrayOfByte;
    if ((j <= this.bufferSize - i) && (j > 0))
    {
      arrayOfByte = this.buffer;
      this.bufferPos = (i + j);
    }
    else
    {
      if (j == 0) {
        return "";
      }
      arrayOfByte = readRawBytesSlowPath(j);
      i = 0;
    }
    if (Utf8.isValidUtf8(arrayOfByte, i, i + j)) {
      return new String(arrayOfByte, i, j, "UTF-8");
    }
    throw InvalidProtocolBufferException.invalidUtf8();
  }
  
  public int readTag()
  {
    if (isAtEnd())
    {
      this.lastTag = 0;
      return 0;
    }
    this.lastTag = readRawVarint32();
    if (WireFormat.getTagFieldNumber(this.lastTag) != 0) {
      return this.lastTag;
    }
    throw InvalidProtocolBufferException.invalidTag();
  }
  
  public int readUInt32()
  {
    return readRawVarint32();
  }
  
  public long readUInt64()
  {
    return readRawVarint64();
  }
  
  public boolean skipField(int paramInt, CodedOutputStream paramCodedOutputStream)
  {
    int i = WireFormat.getTagWireType(paramInt);
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4)
            {
              if (i == 5)
              {
                i = readRawLittleEndian32();
                paramCodedOutputStream.writeRawVarint32(paramInt);
                paramCodedOutputStream.writeFixed32NoTag(i);
                return true;
              }
              throw InvalidProtocolBufferException.invalidWireType();
            }
            return false;
          }
          paramCodedOutputStream.writeRawVarint32(paramInt);
          skipMessage(paramCodedOutputStream);
          paramInt = WireFormat.makeTag(WireFormat.getTagFieldNumber(paramInt), 4);
          checkLastTagWas(paramInt);
          paramCodedOutputStream.writeRawVarint32(paramInt);
          return true;
        }
        ByteString localByteString = readBytes();
        paramCodedOutputStream.writeRawVarint32(paramInt);
        paramCodedOutputStream.writeBytesNoTag(localByteString);
        return true;
      }
      l = readRawLittleEndian64();
      paramCodedOutputStream.writeRawVarint32(paramInt);
      paramCodedOutputStream.writeFixed64NoTag(l);
      return true;
    }
    long l = readInt64();
    paramCodedOutputStream.writeRawVarint32(paramInt);
    paramCodedOutputStream.writeUInt64NoTag(l);
    return true;
  }
  
  public void skipMessage(CodedOutputStream paramCodedOutputStream)
  {
    int i;
    do
    {
      i = readTag();
    } while ((i != 0) && (skipField(i, paramCodedOutputStream)));
  }
  
  public void skipRawBytes(int paramInt)
  {
    int i = this.bufferSize;
    int j = this.bufferPos;
    if ((paramInt <= i - j) && (paramInt >= 0))
    {
      this.bufferPos = (j + paramInt);
      return;
    }
    skipRawBytesSlowPath(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream
 * JD-Core Version:    0.7.0.1
 */