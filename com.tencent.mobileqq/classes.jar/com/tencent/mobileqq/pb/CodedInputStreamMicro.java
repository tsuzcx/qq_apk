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
    this.bufferSize = (paramInt1 + paramInt2);
    this.bufferPos = paramInt1;
    this.input = null;
  }
  
  public static int decodeZigZag32(int paramInt)
  {
    return paramInt >>> 1 ^ -(paramInt & 0x1);
  }
  
  public static long decodeZigZag64(long paramLong)
  {
    return paramLong >>> 1 ^ -(1L & paramLong);
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
    int j = 0;
    int i = 0;
    if (j >= 32) {}
    for (;;)
    {
      int k;
      if (j >= 64)
      {
        throw InvalidProtocolBufferMicroException.malformedVarint();
        k = paramInputStream.read();
        if (k == -1) {
          throw InvalidProtocolBufferMicroException.truncatedMessage();
        }
        i |= (k & 0x7F) << j;
        if ((k & 0x80) == 0) {
          k = i;
        }
      }
      int m;
      do
      {
        return k;
        j += 7;
        break;
        m = paramInputStream.read();
        if (m == -1) {
          throw InvalidProtocolBufferMicroException.truncatedMessage();
        }
        k = i;
      } while ((m & 0x80) == 0);
      j += 7;
    }
  }
  
  private void recomputeBufferSizeAfterLimit()
  {
    this.bufferSize += this.bufferSizeAfterLimit;
    int i = this.totalBytesRetired + this.bufferSize;
    if (i > this.currentLimit)
    {
      this.bufferSizeAfterLimit = (i - this.currentLimit);
      this.bufferSize -= this.bufferSizeAfterLimit;
      return;
    }
    this.bufferSizeAfterLimit = 0;
  }
  
  private boolean refillBuffer(boolean paramBoolean)
  {
    if (this.bufferPos < this.bufferSize) {
      throw new IllegalStateException("refillBuffer() called when buffer wasn't empty.");
    }
    if (this.totalBytesRetired + this.bufferSize == this.currentLimit)
    {
      if (paramBoolean) {
        throw InvalidProtocolBufferMicroException.truncatedMessage();
      }
      return false;
    }
    this.totalBytesRetired += this.bufferSize;
    this.bufferPos = 0;
    if (this.input == null) {}
    for (int i = -1;; i = this.input.read(this.buffer))
    {
      this.bufferSize = i;
      if ((this.bufferSize != 0) && (this.bufferSize >= -1)) {
        break;
      }
      throw new IllegalStateException("InputStream#read(byte[]) returned invalid result: " + this.bufferSize + "\nThe InputStream implementation is buggy.");
    }
    if (this.bufferSize == -1)
    {
      this.bufferSize = 0;
      if (paramBoolean) {
        throw InvalidProtocolBufferMicroException.truncatedMessage();
      }
      return false;
    }
    recomputeBufferSizeAfterLimit();
    i = this.totalBytesRetired + this.bufferSize + this.bufferSizeAfterLimit;
    if ((i > this.sizeLimit) || (i < 0)) {
      throw InvalidProtocolBufferMicroException.sizeLimitExceeded();
    }
    return true;
  }
  
  public void checkLastTagWas(int paramInt)
  {
    if (this.lastTag != paramInt) {
      throw InvalidProtocolBufferMicroException.invalidEndTag();
    }
  }
  
  public int getBytesUntilLimit()
  {
    if (this.currentLimit == 2147483647) {
      return -1;
    }
    int i = this.totalBytesRetired;
    int j = this.bufferPos;
    return this.currentLimit - (i + j);
  }
  
  public boolean isAtEnd()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.bufferPos == this.bufferSize)
    {
      bool1 = bool2;
      if (!refillBuffer(false)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void popLimit(int paramInt)
  {
    this.currentLimit = paramInt;
    recomputeBufferSizeAfterLimit();
  }
  
  public int pushLimit(int paramInt)
  {
    if (paramInt < 0) {
      throw InvalidProtocolBufferMicroException.negativeSize();
    }
    paramInt = this.totalBytesRetired + this.bufferPos + paramInt;
    int i = this.currentLimit;
    if (paramInt > i) {
      throw InvalidProtocolBufferMicroException.truncatedMessage();
    }
    this.currentLimit = paramInt;
    recomputeBufferSizeAfterLimit();
    return i;
  }
  
  public boolean readBool()
  {
    return readRawVarint32() != 0;
  }
  
  public ByteStringMicro readBytes()
  {
    int i = readRawVarint32();
    if ((i <= this.bufferSize - this.bufferPos) && (i > 0))
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.copyFrom(this.buffer, this.bufferPos, i);
      this.bufferPos = (i + this.bufferPos);
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
    if (this.recursionDepth >= this.recursionLimit) {
      throw InvalidProtocolBufferMicroException.recursionLimitExceeded();
    }
    this.recursionDepth += 1;
    paramMessageMicro.mergeFrom(this);
    checkLastTagWas(WireFormatMicro.makeTag(paramInt, 4));
    this.recursionDepth -= 1;
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
    if (this.recursionDepth >= this.recursionLimit) {
      throw InvalidProtocolBufferMicroException.recursionLimitExceeded();
    }
    i = pushLimit(i);
    this.recursionDepth += 1;
    paramMessageMicro.mergeFrom(this);
    checkLastTagWas(0);
    this.recursionDepth -= 1;
    popLimit(i);
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
    if (paramInt < 0) {
      throw InvalidProtocolBufferMicroException.negativeSize();
    }
    if (this.totalBytesRetired + this.bufferPos + paramInt > this.currentLimit)
    {
      skipRawBytes(this.currentLimit - this.totalBytesRetired - this.bufferPos);
      throw InvalidProtocolBufferMicroException.truncatedMessage();
    }
    if (paramInt <= this.bufferSize - this.bufferPos)
    {
      localObject = new byte[paramInt];
      System.arraycopy(this.buffer, this.bufferPos, localObject, 0, paramInt);
      this.bufferPos += paramInt;
      return localObject;
    }
    if (paramInt < 4096)
    {
      localObject = new byte[paramInt];
      i = this.bufferSize - this.bufferPos;
      System.arraycopy(this.buffer, this.bufferPos, localObject, 0, i);
      this.bufferPos = this.bufferSize;
      refillBuffer(true);
      for (;;)
      {
        if (paramInt - i <= this.bufferSize)
        {
          System.arraycopy(this.buffer, 0, localObject, i, paramInt - i);
          this.bufferPos = (paramInt - i);
          return localObject;
        }
        System.arraycopy(this.buffer, 0, localObject, i, this.bufferSize);
        i += this.bufferSize;
        this.bufferPos = this.bufferSize;
        refillBuffer(true);
      }
    }
    int m = this.bufferPos;
    int n = this.bufferSize;
    this.totalBytesRetired += this.bufferSize;
    this.bufferPos = 0;
    this.bufferSize = 0;
    Object localObject = new ArrayList();
    int i = paramInt - (n - m);
    byte[] arrayOfByte1;
    if (i <= 0)
    {
      arrayOfByte1 = new byte[paramInt];
      i = n - m;
      System.arraycopy(this.buffer, m, arrayOfByte1, 0, i);
      paramInt = 0;
    }
    for (;;)
    {
      if (paramInt >= ((ArrayList)localObject).size())
      {
        return arrayOfByte1;
        arrayOfByte1 = new byte[Math.min(i, 4096)];
        int j = 0;
        for (;;)
        {
          if (j >= arrayOfByte1.length)
          {
            j = arrayOfByte1.length;
            ((ArrayList)localObject).add(arrayOfByte1);
            i -= j;
            break;
          }
          if (this.input == null) {}
          for (int k = -1; k == -1; k = this.input.read(arrayOfByte1, j, arrayOfByte1.length - j)) {
            throw InvalidProtocolBufferMicroException.truncatedMessage();
          }
          this.totalBytesRetired += k;
          j += k;
        }
      }
      byte[] arrayOfByte2 = (byte[])((ArrayList)localObject).get(paramInt);
      System.arraycopy(arrayOfByte2, 0, arrayOfByte1, i, arrayOfByte2.length);
      i += arrayOfByte2.length;
      paramInt += 1;
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
    if (i >= 0) {}
    int k;
    do
    {
      return i;
      i &= 0x7F;
      j = readRawByte();
      if (j >= 0) {
        return i | j << 7;
      }
      i |= (j & 0x7F) << 7;
      j = readRawByte();
      if (j >= 0) {
        return i | j << 14;
      }
      i |= (j & 0x7F) << 14;
      k = readRawByte();
      if (k >= 0) {
        return i | k << 21;
      }
      j = readRawByte();
      k = i | (k & 0x7F) << 21 | j << 28;
      i = k;
    } while (j >= 0);
    int j = 0;
    for (;;)
    {
      if (j >= 5) {
        throw InvalidProtocolBufferMicroException.malformedVarint();
      }
      i = k;
      if (readRawByte() >= 0) {
        break;
      }
      j += 1;
    }
  }
  
  public long readRawVarint64()
  {
    int i = 0;
    long l = 0L;
    for (;;)
    {
      if (i >= 64) {
        throw InvalidProtocolBufferMicroException.malformedVarint();
      }
      int j = readRawByte();
      l |= (j & 0x7F) << i;
      if ((j & 0x80) == 0) {
        return l;
      }
      i += 7;
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
    if ((i <= this.bufferSize - this.bufferPos) && (i > 0))
    {
      String str = new String(this.buffer, this.bufferPos, i, "UTF-8");
      this.bufferPos = (i + this.bufferPos);
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
    if (this.lastTag == 0) {
      throw InvalidProtocolBufferMicroException.invalidTag();
    }
    return this.lastTag;
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
    if (paramInt < 0) {
      throw new IllegalArgumentException("Recursion limit cannot be negative: " + paramInt);
    }
    int i = this.recursionLimit;
    this.recursionLimit = paramInt;
    return i;
  }
  
  public int setSizeLimit(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("Size limit cannot be negative: " + paramInt);
    }
    int i = this.sizeLimit;
    this.sizeLimit = paramInt;
    return i;
  }
  
  public boolean skipField(int paramInt)
  {
    switch (WireFormatMicro.getTagWireType(paramInt))
    {
    default: 
      throw InvalidProtocolBufferMicroException.invalidWireType();
    case 0: 
      readInt32();
      return true;
    case 1: 
      readRawLittleEndian64();
      return true;
    case 2: 
      skipRawBytes(readRawVarint32());
      return true;
    case 3: 
      skipMessage();
      checkLastTagWas(WireFormatMicro.makeTag(WireFormatMicro.getTagFieldNumber(paramInt), 4));
      return true;
    case 4: 
      return false;
    }
    readRawLittleEndian32();
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
    if (paramInt < 0) {
      throw InvalidProtocolBufferMicroException.negativeSize();
    }
    if (this.totalBytesRetired + this.bufferPos + paramInt > this.currentLimit)
    {
      skipRawBytes(this.currentLimit - this.totalBytesRetired - this.bufferPos);
      throw InvalidProtocolBufferMicroException.truncatedMessage();
    }
    if (paramInt <= this.bufferSize - this.bufferPos) {
      this.bufferPos += paramInt;
    }
    for (;;)
    {
      return;
      int i = this.bufferSize - this.bufferPos;
      this.totalBytesRetired += i;
      this.bufferPos = 0;
      this.bufferSize = 0;
      while (i < paramInt)
      {
        if (this.input == null) {}
        for (int j = -1; j <= 0; j = (int)this.input.skip(paramInt - i)) {
          throw InvalidProtocolBufferMicroException.truncatedMessage();
        }
        i += j;
        this.totalBytesRetired = (j + this.totalBytesRetired);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pb.CodedInputStreamMicro
 * JD-Core Version:    0.7.0.1
 */