package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.NoSuchElementException;

class LiteralByteString$LiteralByteIterator
  implements ByteString.ByteIterator
{
  private final int limit;
  private int position = 0;
  
  private LiteralByteString$LiteralByteIterator(LiteralByteString paramLiteralByteString)
  {
    this.limit = paramLiteralByteString.size();
  }
  
  public boolean hasNext()
  {
    return this.position < this.limit;
  }
  
  public Byte next()
  {
    return Byte.valueOf(nextByte());
  }
  
  public byte nextByte()
  {
    try
    {
      byte[] arrayOfByte = this.this$0.bytes;
      int i = this.position;
      this.position = (i + 1);
      byte b = arrayOfByte[i];
      return b;
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
      throw new NoSuchElementException(localArrayIndexOutOfBoundsException.getMessage());
    }
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.protobuf.LiteralByteString.LiteralByteIterator
 * JD-Core Version:    0.7.0.1
 */