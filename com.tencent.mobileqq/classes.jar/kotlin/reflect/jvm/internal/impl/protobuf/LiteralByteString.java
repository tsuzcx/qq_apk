package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.OutputStream;

class LiteralByteString
  extends ByteString
{
  protected final byte[] bytes;
  private int hash = 0;
  
  LiteralByteString(byte[] paramArrayOfByte)
  {
    this.bytes = paramArrayOfByte;
  }
  
  static int hashCode(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    int i = paramInt1;
    paramInt1 = paramInt2;
    while (paramInt1 < paramInt2 + paramInt3)
    {
      i = i * 31 + paramArrayOfByte[paramInt1];
      paramInt1 += 1;
    }
    return i;
  }
  
  public byte byteAt(int paramInt)
  {
    return this.bytes[paramInt];
  }
  
  protected void copyToInternal(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    System.arraycopy(this.bytes, paramInt1, paramArrayOfByte, paramInt2, paramInt3);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof ByteString)) {
      return false;
    }
    if (size() != ((ByteString)paramObject).size()) {
      return false;
    }
    if (size() == 0) {
      return true;
    }
    if ((paramObject instanceof LiteralByteString)) {
      return equalsRange((LiteralByteString)paramObject, 0, size());
    }
    if ((paramObject instanceof RopeByteString)) {
      return paramObject.equals(this);
    }
    paramObject = String.valueOf(String.valueOf(paramObject.getClass()));
    StringBuilder localStringBuilder = new StringBuilder(paramObject.length() + 49);
    localStringBuilder.append("Has a new type of ByteString been created? Found ");
    localStringBuilder.append(paramObject);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  boolean equalsRange(LiteralByteString paramLiteralByteString, int paramInt1, int paramInt2)
  {
    if (paramInt2 <= paramLiteralByteString.size())
    {
      if (paramInt1 + paramInt2 <= paramLiteralByteString.size())
      {
        byte[] arrayOfByte1 = this.bytes;
        byte[] arrayOfByte2 = paramLiteralByteString.bytes;
        int j = getOffsetIntoBytes();
        i = getOffsetIntoBytes();
        paramInt1 = paramLiteralByteString.getOffsetIntoBytes() + paramInt1;
        while (i < j + paramInt2)
        {
          if (arrayOfByte1[i] != arrayOfByte2[paramInt1]) {
            return false;
          }
          i += 1;
          paramInt1 += 1;
        }
        return true;
      }
      int i = paramLiteralByteString.size();
      paramLiteralByteString = new StringBuilder(59);
      paramLiteralByteString.append("Ran off end of other: ");
      paramLiteralByteString.append(paramInt1);
      paramLiteralByteString.append(", ");
      paramLiteralByteString.append(paramInt2);
      paramLiteralByteString.append(", ");
      paramLiteralByteString.append(i);
      throw new IllegalArgumentException(paramLiteralByteString.toString());
    }
    paramInt1 = size();
    paramLiteralByteString = new StringBuilder(40);
    paramLiteralByteString.append("Length too large: ");
    paramLiteralByteString.append(paramInt2);
    paramLiteralByteString.append(paramInt1);
    paramLiteralByteString = new IllegalArgumentException(paramLiteralByteString.toString());
    for (;;)
    {
      throw paramLiteralByteString;
    }
  }
  
  protected int getOffsetIntoBytes()
  {
    return 0;
  }
  
  protected int getTreeDepth()
  {
    return 0;
  }
  
  public int hashCode()
  {
    int j = this.hash;
    int i = j;
    if (j == 0)
    {
      i = size();
      j = partialHash(i, 0, i);
      i = j;
      if (j == 0) {
        i = 1;
      }
      this.hash = i;
    }
    return i;
  }
  
  protected boolean isBalanced()
  {
    return true;
  }
  
  public boolean isValidUtf8()
  {
    int i = getOffsetIntoBytes();
    return Utf8.isValidUtf8(this.bytes, i, size() + i);
  }
  
  public ByteString.ByteIterator iterator()
  {
    return new LiteralByteString.LiteralByteIterator(this, null);
  }
  
  public CodedInputStream newCodedInput()
  {
    return CodedInputStream.newInstance(this);
  }
  
  protected int partialHash(int paramInt1, int paramInt2, int paramInt3)
  {
    return hashCode(paramInt1, this.bytes, getOffsetIntoBytes() + paramInt2, paramInt3);
  }
  
  protected int partialIsValidUtf8(int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt2 = getOffsetIntoBytes() + paramInt2;
    return Utf8.partialIsValidUtf8(paramInt1, this.bytes, paramInt2, paramInt3 + paramInt2);
  }
  
  protected int peekCachedHashCode()
  {
    return this.hash;
  }
  
  public int size()
  {
    return this.bytes.length;
  }
  
  public String toString(String paramString)
  {
    return new String(this.bytes, getOffsetIntoBytes(), size(), paramString);
  }
  
  void writeToInternal(OutputStream paramOutputStream, int paramInt1, int paramInt2)
  {
    paramOutputStream.write(this.bytes, getOffsetIntoBytes() + paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.protobuf.LiteralByteString
 * JD-Core Version:    0.7.0.1
 */