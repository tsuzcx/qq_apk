package com.tencent.mobileqq.pb;

import java.io.InputStream;
import java.util.ArrayList;

public final class CodedInputStreamMicro
{
  private static final int BUFFER_SIZE = 4096;
  private static final int DEFAULT_RECURSION_LIMIT = 64;
  private static final int DEFAULT_SIZE_LIMIT = 67108864;
  private final byte[] buffer;
  private int bufferPos;
  private int bufferSize;
  private int bufferSizeAfterLimit;
  private int currentLimit = 2147483647;
  private final InputStream input;
  private int lastTag;
  private int recursionDepth;
  private int recursionLimit = 64;
  private int sizeLimit = 67108864;
  private int totalBytesRetired;
  
  private CodedInputStreamMicro(InputStream paramInputStream)
  {
    this.buffer = new byte[4096];
    this.bufferSize = 0;
    this.bufferPos = 0;
    this.input = paramInputStream;
  }
  
  private CodedInputStreamMicro(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.buffer = paramArrayOfByte;
    this.bufferSize = (paramInt2 + paramInt1);
    this.bufferPos = paramInt1;
    this.input = null;
  }
  
  public static int decodeZigZag32(int paramInt)
  {
    return -(paramInt & 0x1) ^ paramInt >>> 1;
  }
  
  public static long decodeZigZag64(long paramLong)
  {
    return -(paramLong & 1L) ^ paramLong >>> 1;
  }
  
  public static CodedInputStreamMicro newInstance(InputStream paramInputStream)
  {
    return new CodedInputStreamMicro(paramInputStream);
  }
  
  public static CodedInputStreamMicro newInstance(byte[] paramArrayOfByte)
  {
    return newInstance(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static CodedInputStreamMicro newInstance(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new CodedInputStreamMicro(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  static int readRawVarint32(InputStream paramInputStream)
  {
    int i = 0;
    int j = 0;
    for (;;)
    {
      if (i >= 32)
      {
        while (i < 64)
        {
          k = paramInputStream.read();
          if (k != -1)
          {
            if ((k & 0x80) == 0) {
              return j;
            }
            i += 7;
          }
          else
          {
            throw InvalidProtocolBufferMicroException.truncatedMessage();
          }
        }
        throw InvalidProtocolBufferMicroException.malformedVarint();
      }
      int k = paramInputStream.read();
      if (k == -1) {
        break;
      }
      j |= (k & 0x7F) << i;
      if ((k & 0x80) == 0) {
        return j;
      }
      i += 7;
    }
    paramInputStream = InvalidProtocolBufferMicroException.truncatedMessage();
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
  
  private boolean refillBuffer(boolean paramBoolean)
  {
    int j = this.bufferPos;
    int i = this.bufferSize;
    if (j >= i)
    {
      j = this.totalBytesRetired;
      if (j + i == this.currentLimit)
      {
        if (!paramBoolean) {
          return false;
        }
        throw InvalidProtocolBufferMicroException.truncatedMessage();
      }
      this.totalBytesRetired = (j + i);
      this.bufferPos = 0;
      Object localObject = this.input;
      if (localObject == null) {
        i = -1;
      } else {
        i = ((InputStream)localObject).read(this.buffer);
      }
      this.bufferSize = i;
      i = this.bufferSize;
      if ((i != 0) && (i >= -1))
      {
        if (i == -1)
        {
          this.bufferSize = 0;
          if (!paramBoolean) {
            return false;
          }
          throw InvalidProtocolBufferMicroException.truncatedMessage();
        }
        recomputeBufferSizeAfterLimit();
        i = this.totalBytesRetired + this.bufferSize + this.bufferSizeAfterLimit;
        if ((i <= this.sizeLimit) && (i >= 0)) {
          return true;
        }
        throw InvalidProtocolBufferMicroException.sizeLimitExceeded();
      }
      localObject = new StringBuilder("InputStream#read(byte[]) returned invalid result: ");
      ((StringBuilder)localObject).append(this.bufferSize);
      ((StringBuilder)localObject).append("\nThe InputStream implementation is buggy.");
      throw new IllegalStateException(((StringBuilder)localObject).toString());
    }
    throw new IllegalStateException("refillBuffer() called when buffer wasn't empty.");
  }
  
  public void checkLastTagWas(int paramInt)
  {
    if (this.lastTag == paramInt) {
      return;
    }
    throw InvalidProtocolBufferMicroException.invalidEndTag();
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
    return (this.bufferPos == this.bufferSize) && (!refillBuffer(false));
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
      throw InvalidProtocolBufferMicroException.truncatedMessage();
    }
    throw InvalidProtocolBufferMicroException.negativeSize();
  }
  
  public boolean readBool()
  {
    return readRawVarint32() != 0;
  }
  
  public ByteStringMicro readBytes()
  {
    int i = readRawVarint32();
    int j = this.bufferSize;
    int k = this.bufferPos;
    if ((i <= j - k) && (i > 0))
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.copyFrom(this.buffer, k, i);
      this.bufferPos += i;
      return localByteStringMicro;
    }
    return ByteStringMicro.copyFrom(readRawBytes(i));
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
  
  public void readGroup(MessageMicro<?> paramMessageMicro, int paramInt)
  {
    int i = this.recursionDepth;
    if (i < this.recursionLimit)
    {
      this.recursionDepth = (i + 1);
      paramMessageMicro.mergeFrom(this);
      checkLastTagWas(WireFormatMicro.makeTag(paramInt, 4));
      this.recursionDepth -= 1;
      return;
    }
    throw InvalidProtocolBufferMicroException.recursionLimitExceeded();
  }
  
  public int readInt32()
  {
    return readRawVarint32();
  }
  
  public long readInt64()
  {
    return readRawVarint64();
  }
  
  public void readMessage(MessageMicro<?> paramMessageMicro)
  {
    int i = readRawVarint32();
    if (this.recursionDepth < this.recursionLimit)
    {
      i = pushLimit(i);
      this.recursionDepth += 1;
      paramMessageMicro.mergeFrom(this);
      checkLastTagWas(0);
      this.recursionDepth -= 1;
      popLimit(i);
      return;
    }
    throw InvalidProtocolBufferMicroException.recursionLimitExceeded();
  }
  
  public byte readRawByte()
  {
    if (this.bufferPos == this.bufferSize) {
      refillBuffer(true);
    }
    byte[] arrayOfByte = this.buffer;
    int i = this.bufferPos;
    this.bufferPos = (i + 1);
    return arrayOfByte[i];
  }
  
  public byte[] readRawBytes(int paramInt)
  {
    if (paramInt >= 0)
    {
      int i = this.totalBytesRetired;
      int n = this.bufferPos;
      int j = this.currentLimit;
      if (i + n + paramInt <= j)
      {
        j = this.bufferSize;
        if (paramInt <= j - n)
        {
          localObject1 = new byte[paramInt];
          System.arraycopy(this.buffer, n, localObject1, 0, paramInt);
          this.bufferPos += paramInt;
          return localObject1;
        }
        int k;
        if (paramInt < 4096)
        {
          localObject1 = new byte[paramInt];
          i = j - n;
          System.arraycopy(this.buffer, n, localObject1, 0, i);
          for (this.bufferPos = this.bufferSize;; this.bufferPos = j)
          {
            refillBuffer(true);
            j = paramInt - i;
            k = this.bufferSize;
            if (j <= k)
            {
              System.arraycopy(this.buffer, 0, localObject1, i, j);
              this.bufferPos = j;
              return localObject1;
            }
            System.arraycopy(this.buffer, 0, localObject1, i, k);
            j = this.bufferSize;
            i += j;
          }
        }
        this.totalBytesRetired = (i + j);
        this.bufferPos = 0;
        this.bufferSize = 0;
        int m = j - n;
        i = paramInt - m;
        localObject1 = new ArrayList();
        Object localObject2;
        if (i <= 0)
        {
          arrayOfByte = new byte[paramInt];
          System.arraycopy(this.buffer, n, arrayOfByte, 0, m);
          paramInt = 0;
          i = m;
          for (;;)
          {
            if (paramInt >= ((ArrayList)localObject1).size()) {
              return arrayOfByte;
            }
            localObject2 = (byte[])((ArrayList)localObject1).get(paramInt);
            System.arraycopy(localObject2, 0, arrayOfByte, i, localObject2.length);
            i += localObject2.length;
            paramInt += 1;
          }
        }
        byte[] arrayOfByte = new byte[Math.min(i, 4096)];
        j = 0;
        for (;;)
        {
          if (j >= arrayOfByte.length)
          {
            i -= arrayOfByte.length;
            ((ArrayList)localObject1).add(arrayOfByte);
            break;
          }
          localObject2 = this.input;
          if (localObject2 == null) {
            k = -1;
          } else {
            k = ((InputStream)localObject2).read(arrayOfByte, j, arrayOfByte.length - j);
          }
          if (k == -1) {
            break label391;
          }
          this.totalBytesRetired += k;
          j += k;
        }
        label391:
        throw InvalidProtocolBufferMicroException.truncatedMessage();
      }
      skipRawBytes(j - i - n);
      throw InvalidProtocolBufferMicroException.truncatedMessage();
    }
    Object localObject1 = InvalidProtocolBufferMicroException.negativeSize();
    for (;;)
    {
      throw ((Throwable)localObject1);
    }
  }
  
  public int readRawLittleEndian32()
  {
    return readRawByte() & 0xFF | (readRawByte() & 0xFF) << 8 | (readRawByte() & 0xFF) << 16 | (readRawByte() & 0xFF) << 24;
  }
  
  public long readRawLittleEndian64()
  {
    int i = readRawByte();
    int j = readRawByte();
    int k = readRawByte();
    int m = readRawByte();
    int n = readRawByte();
    int i1 = readRawByte();
    int i2 = readRawByte();
    int i3 = readRawByte();
    long l = i;
    return (j & 0xFF) << 8 | l & 0xFF | (k & 0xFF) << 16 | (m & 0xFF) << 24 | (n & 0xFF) << 32 | (i1 & 0xFF) << 40 | (i2 & 0xFF) << 48 | (i3 & 0xFF) << 56;
  }
  
  public int readRawVarint32()
  {
    int i = readRawByte();
    if (i >= 0) {
      return i;
    }
    i &= 0x7F;
    int j = readRawByte();
    if (j >= 0) {
      j <<= 7;
    }
    for (;;)
    {
      return i | j;
      i |= (j & 0x7F) << 7;
      j = readRawByte();
      if (j >= 0)
      {
        j <<= 14;
      }
      else
      {
        i |= (j & 0x7F) << 14;
        j = readRawByte();
        if (j < 0) {
          break;
        }
        j <<= 21;
      }
    }
    int k = readRawByte();
    j = i | (j & 0x7F) << 21 | k << 28;
    if (k < 0)
    {
      i = 0;
      while (i < 5)
      {
        if (readRawByte() >= 0) {
          return j;
        }
        i += 1;
      }
      throw InvalidProtocolBufferMicroException.malformedVarint();
    }
    return j;
  }
  
  public long readRawVarint64()
  {
    int i = 0;
    long l = 0L;
    while (i < 64)
    {
      int j = readRawByte();
      l |= (j & 0x7F) << i;
      if ((j & 0x80) == 0) {
        return l;
      }
      i += 7;
    }
    InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException = InvalidProtocolBufferMicroException.malformedVarint();
    for (;;)
    {
      throw localInvalidProtocolBufferMicroException;
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
    return new String(readRawBytes(i), "UTF-8");
  }
  
  public int readTag()
  {
    if (isAtEnd())
    {
      this.lastTag = 0;
      return 0;
    }
    this.lastTag = readRawVarint32();
    int i = this.lastTag;
    if (i != 0) {
      return i;
    }
    throw InvalidProtocolBufferMicroException.invalidTag();
  }
  
  public int readUInt32()
  {
    return readRawVarint32();
  }
  
  public long readUInt64()
  {
    return readRawVarint64();
  }
  
  public void resetSizeCounter()
  {
    this.totalBytesRetired = 0;
  }
  
  public int setRecursionLimit(int paramInt)
  {
    if (paramInt >= 0)
    {
      int i = this.recursionLimit;
      this.recursionLimit = paramInt;
      return i;
    }
    StringBuilder localStringBuilder = new StringBuilder("Recursion limit cannot be negative: ");
    localStringBuilder.append(paramInt);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public int setSizeLimit(int paramInt)
  {
    if (paramInt >= 0)
    {
      int i = this.sizeLimit;
      this.sizeLimit = paramInt;
      return i;
    }
    StringBuilder localStringBuilder = new StringBuilder("Size limit cannot be negative: ");
    localStringBuilder.append(paramInt);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public boolean skipField(int paramInt)
  {
    int i = WireFormatMicro.getTagWireType(paramInt);
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
                readRawLittleEndian32();
                return true;
              }
              throw InvalidProtocolBufferMicroException.invalidWireType();
            }
            return false;
          }
          skipMessage();
          checkLastTagWas(WireFormatMicro.makeTag(WireFormatMicro.getTagFieldNumber(paramInt), 4));
          return true;
        }
        skipRawBytes(readRawVarint32());
        return true;
      }
      readRawLittleEndian64();
      return true;
    }
    readInt32();
    return true;
  }
  
  public void skipMessage()
  {
    int i;
    do
    {
      i = readTag();
    } while ((i != 0) && (skipField(i)));
  }
  
  public void skipRawBytes(int paramInt)
  {
    if (paramInt >= 0)
    {
      int j = this.totalBytesRetired;
      int i = this.bufferPos;
      int k = this.currentLimit;
      if (j + i + paramInt <= k)
      {
        k = this.bufferSize;
        if (paramInt <= k - i)
        {
          this.bufferPos = (i + paramInt);
          return;
        }
        i = k - i;
        this.totalBytesRetired = (j + i);
        this.bufferPos = 0;
        this.bufferSize = 0;
        for (;;)
        {
          if (i >= paramInt) {
            return;
          }
          localObject = this.input;
          if (localObject == null) {
            j = -1;
          } else {
            j = (int)((InputStream)localObject).skip(paramInt - i);
          }
          if (j <= 0) {
            break;
          }
          i += j;
          this.totalBytesRetired += j;
        }
        throw InvalidProtocolBufferMicroException.truncatedMessage();
      }
      skipRawBytes(k - j - i);
      throw InvalidProtocolBufferMicroException.truncatedMessage();
    }
    Object localObject = InvalidProtocolBufferMicroException.negativeSize();
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pb.CodedInputStreamMicro
 * JD-Core Version:    0.7.0.1
 */