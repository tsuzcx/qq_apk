package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.InputStream;

class RopeByteString$RopeInputStream
  extends InputStream
{
  private LiteralByteString currentPiece;
  private int currentPieceIndex;
  private int currentPieceOffsetInRope;
  private int currentPieceSize;
  private int mark;
  private RopeByteString.PieceIterator pieceIterator;
  
  public RopeByteString$RopeInputStream(RopeByteString paramRopeByteString)
  {
    initialize();
  }
  
  private void advanceIfCurrentPieceFullyRead()
  {
    if (this.currentPiece != null)
    {
      int i = this.currentPieceIndex;
      int j = this.currentPieceSize;
      if (i == j)
      {
        this.currentPieceOffsetInRope += j;
        this.currentPieceIndex = 0;
        if (this.pieceIterator.hasNext())
        {
          this.currentPiece = this.pieceIterator.next();
          this.currentPieceSize = this.currentPiece.size();
          return;
        }
        this.currentPiece = null;
        this.currentPieceSize = 0;
      }
    }
  }
  
  private void initialize()
  {
    this.pieceIterator = new RopeByteString.PieceIterator(this.this$0, null);
    this.currentPiece = this.pieceIterator.next();
    this.currentPieceSize = this.currentPiece.size();
    this.currentPieceIndex = 0;
    this.currentPieceOffsetInRope = 0;
  }
  
  private int readSkipInternal(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    paramInt1 = paramInt2;
    while (paramInt1 > 0)
    {
      advanceIfCurrentPieceFullyRead();
      if (this.currentPiece == null)
      {
        if (paramInt1 != paramInt2) {
          break;
        }
        return -1;
      }
      int k = Math.min(this.currentPieceSize - this.currentPieceIndex, paramInt1);
      int j = i;
      if (paramArrayOfByte != null)
      {
        this.currentPiece.copyTo(paramArrayOfByte, this.currentPieceIndex, i, k);
        j = i + k;
      }
      this.currentPieceIndex += k;
      paramInt1 -= k;
      i = j;
    }
    return paramInt2 - paramInt1;
  }
  
  public int available()
  {
    int i = this.currentPieceOffsetInRope;
    int j = this.currentPieceIndex;
    return this.this$0.size() - (i + j);
  }
  
  public void mark(int paramInt)
  {
    this.mark = (this.currentPieceOffsetInRope + this.currentPieceIndex);
  }
  
  public boolean markSupported()
  {
    return true;
  }
  
  public int read()
  {
    advanceIfCurrentPieceFullyRead();
    LiteralByteString localLiteralByteString = this.currentPiece;
    if (localLiteralByteString == null) {
      return -1;
    }
    int i = this.currentPieceIndex;
    this.currentPieceIndex = (i + 1);
    return localLiteralByteString.byteAt(i) & 0xFF;
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte != null)
    {
      if ((paramInt1 >= 0) && (paramInt2 >= 0) && (paramInt2 <= paramArrayOfByte.length - paramInt1)) {
        return readSkipInternal(paramArrayOfByte, paramInt1, paramInt2);
      }
      throw new IndexOutOfBoundsException();
    }
    throw new NullPointerException();
  }
  
  public void reset()
  {
    try
    {
      initialize();
      readSkipInternal(null, 0, this.mark);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public long skip(long paramLong)
  {
    if (paramLong >= 0L)
    {
      long l = paramLong;
      if (paramLong > 2147483647L) {
        l = 2147483647L;
      }
      return readSkipInternal(null, 0, (int)l);
    }
    throw new IndexOutOfBoundsException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.protobuf.RopeByteString.RopeInputStream
 * JD-Core Version:    0.7.0.1
 */