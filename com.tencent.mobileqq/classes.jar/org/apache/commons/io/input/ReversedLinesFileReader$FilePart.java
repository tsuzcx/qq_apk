package org.apache.commons.io.input;

import java.io.RandomAccessFile;

class ReversedLinesFileReader$FilePart
{
  private int currentLastBytePos;
  private final byte[] data;
  private byte[] leftOver;
  private final long no;
  
  private ReversedLinesFileReader$FilePart(ReversedLinesFileReader paramReversedLinesFileReader, long paramLong, int paramInt, byte[] paramArrayOfByte)
  {
    this.no = paramLong;
    int i;
    if (paramArrayOfByte != null) {
      i = paramArrayOfByte.length;
    } else {
      i = 0;
    }
    this.data = new byte[i + paramInt];
    long l = ReversedLinesFileReader.access$300(paramReversedLinesFileReader);
    if (paramLong > 0L)
    {
      ReversedLinesFileReader.access$400(paramReversedLinesFileReader).seek((paramLong - 1L) * l);
      if (ReversedLinesFileReader.access$400(paramReversedLinesFileReader).read(this.data, 0, paramInt) != paramInt) {
        throw new IllegalStateException("Count of requested bytes and actually read bytes don't match");
      }
    }
    if (paramArrayOfByte != null) {
      System.arraycopy(paramArrayOfByte, 0, this.data, paramInt, paramArrayOfByte.length);
    }
    this.currentLastBytePos = (this.data.length - 1);
    this.leftOver = null;
  }
  
  private void createLeftOver()
  {
    int i = this.currentLastBytePos + 1;
    if (i > 0)
    {
      this.leftOver = new byte[i];
      System.arraycopy(this.data, 0, this.leftOver, 0, i);
    }
    else
    {
      this.leftOver = null;
    }
    this.currentLastBytePos = -1;
  }
  
  private int getNewLineMatchByteCount(byte[] paramArrayOfByte, int paramInt)
  {
    byte[][] arrayOfByte = ReversedLinesFileReader.access$800(this.this$0);
    int n = arrayOfByte.length;
    int i = 0;
    while (i < n)
    {
      byte[] arrayOfByte1 = arrayOfByte[i];
      int j = arrayOfByte1.length - 1;
      int k = 1;
      while (j >= 0)
      {
        int m = paramInt + j - (arrayOfByte1.length - 1);
        if ((m >= 0) && (paramArrayOfByte[m] == arrayOfByte1[j])) {
          m = 1;
        } else {
          m = 0;
        }
        k &= m;
        j -= 1;
      }
      if (k != 0) {
        return arrayOfByte1.length;
      }
      i += 1;
    }
    return 0;
  }
  
  private String readLine()
  {
    int i;
    if (this.no == 1L) {
      i = 1;
    } else {
      i = 0;
    }
    int j = this.currentLastBytePos;
    while (j > -1) {
      if ((i == 0) && (j < ReversedLinesFileReader.access$600(this.this$0)))
      {
        createLeftOver();
      }
      else
      {
        int k = getNewLineMatchByteCount(this.data, j);
        if (k > 0)
        {
          int m = j + 1;
          int n = this.currentLastBytePos - m + 1;
          if (n >= 0)
          {
            localObject1 = new byte[n];
            System.arraycopy(this.data, m, localObject1, 0, n);
            localObject1 = new String((byte[])localObject1, ReversedLinesFileReader.access$500(this.this$0));
            this.currentLastBytePos = (j - k);
            break label192;
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("Unexpected negative line length=");
          ((StringBuilder)localObject1).append(n);
          throw new IllegalStateException(((StringBuilder)localObject1).toString());
        }
        k = j - ReversedLinesFileReader.access$700(this.this$0);
        j = k;
        if (k < 0) {
          createLeftOver();
        }
      }
    }
    Object localObject1 = null;
    label192:
    Object localObject2 = localObject1;
    if (i != 0)
    {
      byte[] arrayOfByte = this.leftOver;
      localObject2 = localObject1;
      if (arrayOfByte != null)
      {
        localObject2 = new String(arrayOfByte, ReversedLinesFileReader.access$500(this.this$0));
        this.leftOver = null;
      }
    }
    return localObject2;
  }
  
  private FilePart rollOver()
  {
    if (this.currentLastBytePos <= -1)
    {
      long l = this.no;
      if (l > 1L)
      {
        localObject = this.this$0;
        return new FilePart((ReversedLinesFileReader)localObject, l - 1L, ReversedLinesFileReader.access$300((ReversedLinesFileReader)localObject), this.leftOver);
      }
      if (this.leftOver == null) {
        return null;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Unexpected leftover of the last block: leftOverOfThisFilePart=");
      ((StringBuilder)localObject).append(new String(this.leftOver, ReversedLinesFileReader.access$500(this.this$0)));
      throw new IllegalStateException(((StringBuilder)localObject).toString());
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Current currentLastCharPos unexpectedly positive... last readLine() should have returned something! currentLastCharPos=");
    ((StringBuilder)localObject).append(this.currentLastBytePos);
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.apache.commons.io.input.ReversedLinesFileReader.FilePart
 * JD-Core Version:    0.7.0.1
 */