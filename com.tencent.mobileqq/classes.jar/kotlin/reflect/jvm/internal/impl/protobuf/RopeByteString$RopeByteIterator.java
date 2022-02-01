package kotlin.reflect.jvm.internal.impl.protobuf;

class RopeByteString$RopeByteIterator
  implements ByteString.ByteIterator
{
  private ByteString.ByteIterator bytes;
  int bytesRemaining;
  private final RopeByteString.PieceIterator pieces;
  
  private RopeByteString$RopeByteIterator(RopeByteString paramRopeByteString)
  {
    this.pieces = new RopeByteString.PieceIterator(paramRopeByteString, null);
    this.bytes = this.pieces.next().iterator();
    this.bytesRemaining = paramRopeByteString.size();
  }
  
  public boolean hasNext()
  {
    return this.bytesRemaining > 0;
  }
  
  public Byte next()
  {
    return Byte.valueOf(nextByte());
  }
  
  public byte nextByte()
  {
    if (!this.bytes.hasNext()) {
      this.bytes = this.pieces.next().iterator();
    }
    this.bytesRemaining -= 1;
    return this.bytes.nextByte();
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.protobuf.RopeByteString.RopeByteIterator
 * JD-Core Version:    0.7.0.1
 */