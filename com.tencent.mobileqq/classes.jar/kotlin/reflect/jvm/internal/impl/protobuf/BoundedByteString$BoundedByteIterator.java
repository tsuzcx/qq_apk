package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.NoSuchElementException;

class BoundedByteString$BoundedByteIterator
  implements ByteString.ByteIterator
{
  private final int limit;
  private int position;
  
  private BoundedByteString$BoundedByteIterator(BoundedByteString paramBoundedByteString)
  {
    this.position = paramBoundedByteString.getOffsetIntoBytes();
    this.limit = (this.position + paramBoundedByteString.size());
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
    if (this.position < this.limit)
    {
      byte[] arrayOfByte = this.this$0.bytes;
      int i = this.position;
      this.position = (i + 1);
      return arrayOfByte[i];
    }
    throw new NoSuchElementException();
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.protobuf.BoundedByteString.BoundedByteIterator
 * JD-Core Version:    0.7.0.1
 */