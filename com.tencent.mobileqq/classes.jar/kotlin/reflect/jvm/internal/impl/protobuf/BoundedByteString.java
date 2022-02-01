package kotlin.reflect.jvm.internal.impl.protobuf;

class BoundedByteString
  extends LiteralByteString
{
  private final int bytesLength;
  private final int bytesOffset;
  
  BoundedByteString(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    super(paramArrayOfByte);
    if (paramInt1 >= 0)
    {
      if (paramInt2 >= 0)
      {
        if (paramInt1 + paramInt2 <= paramArrayOfByte.length)
        {
          this.bytesOffset = paramInt1;
          this.bytesLength = paramInt2;
          return;
        }
        paramArrayOfByte = new StringBuilder(48);
        paramArrayOfByte.append("Offset+Length too large: ");
        paramArrayOfByte.append(paramInt1);
        paramArrayOfByte.append("+");
        paramArrayOfByte.append(paramInt2);
        throw new IllegalArgumentException(paramArrayOfByte.toString());
      }
      paramArrayOfByte = new StringBuilder(29);
      paramArrayOfByte.append("Length too small: ");
      paramArrayOfByte.append(paramInt1);
      throw new IllegalArgumentException(paramArrayOfByte.toString());
    }
    paramArrayOfByte = new StringBuilder(29);
    paramArrayOfByte.append("Offset too small: ");
    paramArrayOfByte.append(paramInt1);
    throw new IllegalArgumentException(paramArrayOfByte.toString());
  }
  
  public byte byteAt(int paramInt)
  {
    if (paramInt >= 0)
    {
      if (paramInt < size()) {
        return this.bytes[(this.bytesOffset + paramInt)];
      }
      int i = size();
      localStringBuilder = new StringBuilder(41);
      localStringBuilder.append("Index too large: ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", ");
      localStringBuilder.append(i);
      throw new ArrayIndexOutOfBoundsException(localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder(28);
    localStringBuilder.append("Index too small: ");
    localStringBuilder.append(paramInt);
    throw new ArrayIndexOutOfBoundsException(localStringBuilder.toString());
  }
  
  protected void copyToInternal(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    System.arraycopy(this.bytes, getOffsetIntoBytes() + paramInt1, paramArrayOfByte, paramInt2, paramInt3);
  }
  
  protected int getOffsetIntoBytes()
  {
    return this.bytesOffset;
  }
  
  public ByteString.ByteIterator iterator()
  {
    return new BoundedByteString.BoundedByteIterator(this, null);
  }
  
  public int size()
  {
    return this.bytesLength;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.protobuf.BoundedByteString
 * JD-Core Version:    0.7.0.1
 */